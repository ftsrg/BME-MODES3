#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// OpenCV - CUDA
#include <opencv2/core/cuda.hpp>
using namespace cv::cuda;

// User
#include "Constants.hpp"

#include "Filter.hpp"
#include "InputFilter.hpp"

using namespace cv;
using namespace cv::cuda;

class ConvolutionFilter : public Filter<cv::Mat, cv::Mat> {
	InputFilter& inputFilter;
	GpuMat circleSpectrum;
	
	void process();
	
public:
	ConvolutionFilter(InputFilter& inputFilter);
};