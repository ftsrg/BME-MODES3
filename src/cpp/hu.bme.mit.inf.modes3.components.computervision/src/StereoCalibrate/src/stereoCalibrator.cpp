/*
 * stereoCalibrate.cpp
 *
 *  Created on: Jan 27, 2016
 *      Author: teqbox
 */

#include "opencv2/calib3d.hpp"
#include "opencv2/core.hpp"
#include "opencv2/highgui.hpp"
#include "opencv2/imgproc.hpp"
#include <opencv2/videoio.hpp>
#include <iostream>

using namespace std;
using namespace cv;


bool findChessboard(Mat frame , vector<Point2f>& corners , Size boardsize){

	bool found;
	found =findChessboardCorners(frame , boardsize , corners , CALIB_CB_ADAPTIVE_THRESH | CALIB_CB_NORMALIZE_IMAGE);

	if (corners.size() != boardsize.height*boardsize.width) {
		return false;
	}

	if(found){
		cornerSubPix(frame, corners, Size(11, 11), Size(-1, -1),
				TermCriteria(CV_TERMCRIT_EPS + CV_TERMCRIT_ITER, 30, 0.1));
	}
	return found;
}

int main(int argc , char *argv[]){

	cv::VideoCapture capture_1(-1);
	cv::VideoCapture capture_2(-1);

	Mat r1, r2, p1, p2, q;
	Mat m1;
	Mat d1;
	Mat m2;
	Mat d2;
	
	Mat image_1, image_2;

	vector< vector<Point3f> > object_points;
	vector< vector<Point2f> > img_points_1;
	vector< vector<Point2f> > img_points_2;

	cv::Size board_size(6, 3);
	cv::Size image_size;

	vector <Point2f> corners_1;
	vector <Point2f> corners_2;

	char command = ' ';

	while (command != 'q') {
		capture_1.grab();
		capture_2.grab();

		capture_1.retrieve(image_1);
		capture_2.retrieve(image_2);

		image_size = cv::Size(image_1.cols , image_1.rows);
		
		if (command == 'c') {
			if (findChessboard(image_1, corners_1, board_size) && findChessboard(image_2, corners_2, board_size)) {
				
				std::cout << "Found chessboard!" << std::endl;
				
				drawChessboardCorners(image_1, Size(6, 3), corners_1, true);
				drawChessboardCorners(image_2, Size(6, 3), corners_2, true);

				vector<Point3f>obj;
				for (int i = 0; i<3; i++) {
					for (int j = 0; j<6; j++)
						obj.push_back(Point3f(i*5.8, j*5.8, 0.0f));
				}

				object_points.push_back(obj);
				img_points_1.push_back(corners_1);
				img_points_2.push_back(corners_2);
			}
		}
		
		resize(image_1, image_1, Size(640, 480));
		resize(image_2, image_2, Size(640, 480));

		cv::imshow("1", image_1);
		cv::imshow("2", image_2);

		command = waitKey(10);
	}

	std::cout << "Calibrating...." << std::endl;

	m1 = cv::initCameraMatrix2D(object_points, img_points_1, image_size, 0);
	m1 = cv::initCameraMatrix2D(object_points, img_points_2, image_size, 0);

	cv::Mat r, t, e, f;

	double rms = stereoCalibrate(object_points, img_points_1, img_points_2, m1, d1,
		m2, d2, Size(image_1.cols, image_1.rows), r, t, e, f, CALIB_FIX_ASPECT_RATIO +
		CALIB_ZERO_TANGENT_DIST +
		CALIB_USE_INTRINSIC_GUESS +
		CALIB_SAME_FOCAL_LENGTH,
		TermCriteria(TermCriteria::COUNT + TermCriteria::EPS, 100, 1e-5));

	std::cout << "Calibration finished! Rms error: " <<rms << std::endl;

	Rect validRoi[2];

	stereoRectify(m1, d1,
		m2, d2,
		image_size, r, t, r1, r2, p1, p2, q , 0 , 1.0 , image_size , &validRoi[0] , &validRoi[1]);

	cv::Mat map11, map12, map21, map22;
	initUndistortRectifyMap(m1, d1, r1, p1, image_size, CV_16SC2, map11, map12);
	initUndistortRectifyMap(m2, d2, r2, p2, image_size, CV_16SC2, map21, map22);

	command = ' ';

	cv::Mat u_1, u_2;

	while (command != 'q') {

		capture_1.grab();
		capture_2.grab();

		capture_1.retrieve(image_1);
		capture_2.retrieve(image_2);

		remap(image_1, u_1, map11, map12, INTER_LINEAR);
		remap(image_1, u_2, map21, map22, INTER_LINEAR);

		cv::rectangle(u_1, validRoi[0] , cv::Scalar(255,0,0));
		cv::rectangle(u_2, validRoi[1], cv::Scalar(255, 0, 0));

		cv::resize(u_1, u_1, cv::Size(640, 480));
		cv::resize(u_2, u_2, cv::Size(640, 480));

		cv::imshow("u1", u_1);
		cv::imshow("u2", u_2);

		command = cv::waitKey(10);
	}

	
	capture_1.release();
	capture_2.release();

	cv::FileStorage fs("matrices.yml" , FileStorage::WRITE);
	fs << "m1" << m1 << "m2" << m2 << "d1" << d1 << "d2" << d2 << "r1" << r1 << "r2" << r2 << "p1" << p1 << "p2" << p2 << "q" << q;
	fs.release();


	return 0;
}


