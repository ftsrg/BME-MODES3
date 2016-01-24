#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// User
#include "Constants.hpp"

#include "Filter.hpp"
#include "InputFilter.hpp"

using namespace cv;
using namespace cv::cuda;

class ConvolutionFilter : public Filter<cv::Mat, cv::Mat> {
	InputFilter& inputFilter;
	Mat circleSpectrum;
	
	void process();
	
public:
	ConvolutionFilter(InputFilter& inputFilter);
};