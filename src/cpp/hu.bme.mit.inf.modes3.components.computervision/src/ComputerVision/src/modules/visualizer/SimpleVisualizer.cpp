/*
 * Visualizer.cpp
 *
 *  Created on: 2016. aug. 19.
 *      Author: M�t�
 */

#include "modules/visualizer/SimpleVisualizer.h"
#include <opencv2/highgui.hpp>
#include <opencv2/imgproc.hpp>
#include <thread>
#include <chrono>
#include <iostream>


tbb::flow::continue_msg SimpleVisualizer::process(tbb::flow::tuple<Frame, ModelData> data) {
	auto frame = std::get<0>(data);

	tbb::concurrent_vector<cv::Mat> clonedImages;
	for (auto i : frame.images) {
		clonedImages.push_back(i.clone());
	}

	frame.images = clonedImages;

	frameBuffer.push_back(frame);
	dataBuffer.push_back(std::get<1>(data));
	
	if (delay > 0 ) {
		auto time = std::chrono::steady_clock::now();
		auto ts = std::chrono::duration_cast<std::chrono::milliseconds>(time.time_since_epoch()).count();
		auto diff = ts - frameBuffer.begin()->timestamp;

		/*
		if ((delay - diff) <  delay) {
			tbb::flow::continue_msg m;
			return m;
		}
		*/
		if ((delay - diff) > 0) {
			std::this_thread::sleep_for(std::chrono::milliseconds(delay - diff));
		}
	}

	size_t i = 0;
	for (auto& image : frameBuffer.begin()->images) {

		auto& modelData = *dataBuffer.begin();

		for (auto& objectData : modelData.objectData) {

			for (auto& markerData : objectData.second.markerData) {
				if (markerData.second.tracked[i]) {
					int x = static_cast<int>(markerData.second.screenPosition[i].x);
					int y = static_cast<int>(markerData.second.screenPosition[i].y);
					
					int baseline = 0;
					cv::Size text_size = cv::getTextSize(markerData.second.name, cv::FONT_HERSHEY_COMPLEX, 1.0 , 2, &baseline);
					cv::Rect background(x, y - text_size.height-baseline, text_size.width, text_size.height*2);

					if (background.x + background.width > image.cols) {
						background.x -= background.width;
						x -= background.width;
					}

					if (background.y - background.height < 0) {
						background.y += background.height/2;
						y += background.height/2;
					}
					

					//std::cout << background << std::endl;
					cv::Mat ROI = image(background);
					cv::Mat color(ROI.size(), CV_8UC3, cv::Scalar(235, 206, 135));
					double alpha = 0.7;
					cv::addWeighted(color, alpha, ROI, 1.0 - alpha, 0.0, ROI);
					//cv:rectangle(image, background, cv::Scalar(255, 255, 255, 0.5), CV_FILLED);
					cv::putText(image, markerData.second.name, cv::Point(x, y), cv::FONT_HERSHEY_SIMPLEX, 1.0, cv::Scalar(0, 0, 0), 2);
				}
			}
		}

		cv::resize(image, image, cv::Size(image.cols/2, image.rows/2));
		std::stringstream winname;
		winname << windowName << i;
		cv::imshow(winname.str(), image);
		i++;
	}
	
	frameBuffer.erase(frameBuffer.begin());
	dataBuffer.erase(dataBuffer.begin());
	cv::waitKey(10);

	tbb::flow::continue_msg msg;
	return msg;
}

SimpleVisualizer::~SimpleVisualizer() {
	cv::destroyAllWindows();
}