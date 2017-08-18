#include <opencv2/core.hpp>
#include <opencv2/imgproc.hpp>
#include <opencv2/videoio.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/video.hpp>
#include <iostream>
#include <string>

void help() {
	std::cout << "Train image generator application" << std::endl<<std::endl;
	std::cout << "Press 'q' to stop processing" << std::endl;
	std::cout << "Press 'c' to re-capture background image" << std::endl;
	std::cout << "Parameters: <masked/nonmasked><padding><output image size><output folder path>";
}

int main(int argc, char *argv[]) {
	help();
	//with or without background
	bool mask_image = true;
	//padding next to train
	int	 padding = 25;
	//resize image to size before save
	int size = 224;
	//folder to save images
	std::string path = "C:/";
	if (argc > 4) {
		mask_image = std::string(argv[1]) == "masked" ? true : false;
		std::cout << mask_image << std::endl;
		padding = atoi(argv[2]);
		size = atoi(argv[3]);
		path = argv[4];
	}
	
	auto camera = cv::VideoCapture(cv::CAP_DSHOW + 1);
	
	camera.set(cv::CAP_PROP_FRAME_WIDTH, 1366);
	camera.set(cv::CAP_PROP_FRAME_HEIGHT, 768);
	camera.set(cv::CAP_PROP_FOURCC, cv::VideoWriter::fourcc('M', 'J', 'P', 'G'));

	//capture static background
	cv::Mat background;
	camera.grab();
	camera.retrieve(background);

	auto fr_count = 0;

	cv::cvtColor(background, background, cv::COLOR_RGB2GRAY);

	auto command = ' ';
	cv::Mat image;
	cv::Mat image_gray;
	cv::Mat mask;
	cv::Mat masked;
	std::vector<std::vector<cv::Point>> contours;
	std::vector<cv::Vec4i> hierarchy;
	while(command != 'q'){
		camera.grab();
		camera.retrieve(image);

		cv::cvtColor(image, image_gray , cv::COLOR_RGB2GRAY);

		//re-capture static background if something terrible happened
		if (command == 'c') {
			command = ' ';
			std::cout << "re-captured background image" << std::endl;
			background = image_gray.clone();
		}
		
		//foreground mask creation
		cv::absdiff(image_gray, background, mask);
		cv::threshold(mask, mask, 50, 255, cv::THRESH_BINARY);
		auto kernel = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(15, 15));
		cv::morphologyEx(mask, mask, cv::MORPH_CLOSE, kernel);
		//cv::morphologyEx(mask, mask, cv::MORPH_OPEN, kernel);
		cv::cvtColor(mask, mask, cv::COLOR_GRAY2RGB);
		//mask image
		cv::bitwise_and(image, mask, masked);

		cv::cvtColor(mask, mask, cv::COLOR_RGB2GRAY);

		cv::findContours(mask.clone(), contours, hierarchy, cv::RETR_EXTERNAL, cv::CHAIN_APPROX_SIMPLE);

		//crop train images from masked or non masked image (based on command line parameter)
		int index = 0;
		for (auto& c : contours) {
			if (cv::contourArea(c) > 1000 && fr_count>50) {
				index++;
				auto rotrect = cv::minAreaRect(c);
				auto angle = rotrect.angle;
				auto rect_size = rotrect.size;
				//rotate image to make cropping easy
				auto rotMat = cv::getRotationMatrix2D(rotrect.center, angle, 1.0);
				cv::Mat rotated;
				if (mask_image) {
					cv::warpAffine(masked, rotated, rotMat, masked.size(), cv::INTER_CUBIC);
				}
				else {
					cv::warpAffine(image, rotated, rotMat, masked.size(), cv::INTER_CUBIC);
				}
				
				cv::Mat train;
				if (rect_size.width > rect_size.height) {
					rect_size.width += padding;
					rect_size.height += rect_size.width - rect_size.height;
				}
				else {
					rect_size.height += padding;
					rect_size.width += rect_size.height - rect_size.width;
				}

				cv::getRectSubPix(rotated, rect_size, rotrect.center, train);
				cv::resize(train, train, cv::Size(size, size));
				//TODO save image, does not work with my OpenCV build :(
				//build opencv with jpg and png support!!
				cv::imwrite(path+"/train"+std::to_string(fr_count)+".jpg", train);
				cv::imshow(std::to_string(index) + "image", train);
			}
		}

		cv::resize(image, image, cv::Size(image.cols / 2, image.rows / 2));
		cv::resize(masked, masked, cv::Size(masked.cols / 2, masked.rows / 2));
		cv::imshow("image", image);
		cv::imshow("mask", masked);

		command = cv::waitKey(5);
		fr_count++;
	}
}


