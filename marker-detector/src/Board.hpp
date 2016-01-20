#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// OpenCV - CUDA
#include <opencv2/core/cuda.hpp>
#include <opencv2/cudaarithm.hpp>
using namespace cv::cuda;

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