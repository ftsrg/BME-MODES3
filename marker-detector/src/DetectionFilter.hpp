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
#include "Position.hpp"
#include "Train.hpp"
#include "Board.hpp"
#include "DataSerializer.hpp"

#include "ConvolutionFilter.hpp"

using namespace cv;
using namespace cv::cuda;

class DetectionFilter : public Filter<cv::Mat, DataSerializer> {
	ConvolutionFilter& convFilter;
	Mat cameraMatrix, distCoeffs;
	Board board;
	
	#ifdef ENABLE_GPU
	GpuMat circleSpectrum;
	#else
	Mat circleSpectrum;
	#endif
	
	Train trains[3] {
		Train(MARKER_R),
		Train(MARKER_G),
		Train(MARKER_B)
	};
	
	void process();
	
public:
	DetectionFilter(ConvolutionFilter& convFilter, Mat cameraMatrix, Mat distCoeffs, Board board);
};