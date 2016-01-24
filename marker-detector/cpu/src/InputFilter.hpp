#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// User
#include "Constants.hpp"
#include "Filter.hpp"

using namespace cv;

class InputFilter : public Filter<cv::Mat> {
	VideoCapture& vid;

	void process();

public:
	InputFilter(VideoCapture& vid) : vid(vid) {	}
};