#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

#ifdef ENABLE_GPU
// OpenCV - CUDA
#include <opencv2/core/cuda.hpp>
using namespace cv::cuda;
#endif

// User
#include "Constants.hpp"

#include "Filter.hpp"
#include "InputFilter.hpp"

using namespace cv;
using namespace cv::cuda;

class ConvolutionFilter : public Filter<cv::Mat, cv::Mat> {
	InputFilter& inputFilter;
	
	#ifdef ENABLE_GPU
	GpuMat circleSpectrum;
	#else
	Mat circleSpectrum;
	#endif
	
	void process();
	
public:
	ConvolutionFilter(InputFilter& inputFilter);
};