#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// User
#include "Constants.hpp"

using namespace cv;
using namespace cv::cuda;

struct Board {
    Point2f topLeft, topRight, bottomLeft, bottomRight;
	Mat perspectiveTrans;
	Mat inverseTrans;
    
	void calculatePerspectiveMat();
	cv::Rect getBoundingBox();
	Point2f getCenter();
	static Board detectBoard(VideoCapture& vid, Mat cameraMatrix, Mat distCoeffs);
};