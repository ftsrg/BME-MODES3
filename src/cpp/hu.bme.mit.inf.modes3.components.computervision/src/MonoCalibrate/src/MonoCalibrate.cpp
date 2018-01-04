#include "opencv2/calib3d.hpp"
#include "opencv2/core.hpp"
#include "opencv2/highgui.hpp"
#include "opencv2/imgproc.hpp"
#include <opencv2/videoio.hpp>
#include <iostream>

using namespace std;
using namespace cv;


bool findChessboard(Mat frame, vector<Point2f>& corners, Size boardsize) {

	bool found;
	found = findChessboardCorners(frame, boardsize, corners, CALIB_CB_ADAPTIVE_THRESH | CALIB_CB_NORMALIZE_IMAGE);

	if (corners.size() != boardsize.height*boardsize.width) {
		return false;
	}

	if (found) {
		cornerSubPix(frame, corners, Size(11, 11), Size(-1, -1),
			TermCriteria(CV_TERMCRIT_EPS + CV_TERMCRIT_ITER, 30, 0.1));
	}
	return found;
}

int main(int argc, char *argv[]) {

	bool calibrate = true;

	cv::VideoCapture capture_1;

	if (!calibrate) {
		capture_1.open("C:/Users/Mate/Pictures/Camera Roll/WIN_20170621_14_50_25_Pro.jpg");
	}
	else {
		capture_1.open(cv::CAP_DSHOW+1);
	}
	
	capture_1.set(cv::CAP_PROP_FOURCC, cv::VideoWriter::fourcc('M', 'J', 'P', 'G'));
	capture_1.set(cv::CAP_PROP_XI_AEAG, 0.0);
	capture_1.set(cv::CAP_PROP_FPS, 30);
	capture_1.set(cv::CAP_PROP_EXPOSURE, -7);
	capture_1.set(cv::CAP_PROP_GAIN, 0);
	capture_1.set(cv::CAP_PROP_FRAME_WIDTH, 1920);
	capture_1.set(cv::CAP_PROP_FRAME_HEIGHT, 1080);


	Mat m1 = Mat::eye(3, 3, CV_64F);;
	Mat d1 = Mat::zeros(8, 1, CV_64F);
	Mat rvec;
	Mat tvec;

	Mat image;
	vector< vector<Point3f> > object_points;
	vector< vector<Point2f> > img_points;

	cv::Size board_size(9, 6);
	cv::Size image_size(1920,1080);
	vector <Point2f> corners;

	char command = ' ';

	if (calibrate) {
		

		while (command != 'q') {
			capture_1.grab();
			capture_1.retrieve(image);

			cvtColor(image, image, CV_RGB2GRAY);

			if (command == 'c') {
				if (findChessboard(image, corners, board_size)) {

					std::cout << "Found chessboard!" << std::endl;

					drawChessboardCorners(image, Size(9, 6), corners, true);
					vector<Point3f>obj;
					for (int i = 0; i < 6; i++) {
						for (int j = 0; j < 9; j++)
							obj.push_back(Point3f(i * 2, j * 2, 0.0f));
					}

					object_points.push_back(obj);
					img_points.push_back(corners);
				}
			}

			resize(image, image, Size(image.cols / 2, image.rows / 2));
			cv::imshow("image", image);

			command = waitKey(10);
		}

		std::cout << "Calibrating...." << std::endl;

		double error = cv::calibrateCamera(object_points, img_points, image_size, m1, d1,
			rvec, tvec, CV_CALIB_FIX_K4 | CV_CALIB_FIX_K5);

		std::cout << "Calibration finished! Rms error: " << error << std::endl;
	}

	if (!calibrate) {
		cv::FileStorage fs;
		fs.open("C:/Users/Mate/BME/onlab/git/ComputerVision/computer_vision_framework/MonoCalibrate/matrices.yml", cv::FileStorage::READ);
		fs["cameraMatrix"] >> m1;
		fs["distCoeffs"] >> d1;
	}

	command = ' ';
	cv::Mat res;
	while (command != 'q') {
		capture_1.grab();
		capture_1.retrieve(image);

		cv::undistort(image, res, m1, d1);
		cv::resize(res, res, cv::Size(1920/2, 1080/2));

		cv::imshow("undi", res);

		command = cv::waitKey(10);

		if (command == 's') {
			cv::FileStorage fs("matrices.yml", FileStorage::WRITE);
			fs << "cameraMatrix" << m1 << "distCoeffs" << d1 << "rvecs" << rvec << "tvecs" << tvec;
			fs.release();
		}
	}

	return 0;
}
