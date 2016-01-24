#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// OpenCV - CUDA
#include <opencv2/core/cuda.hpp>
#include <opencv2/cudaarithm.hpp>
#include <opencv2/cudawarping.hpp>
using namespace cv::cuda;

#include "Position.hpp"
#include "Board.hpp"
#include "Train.hpp"


void drawMarkerToMat(Mat& marker, int x, int y, int outer, int ring, int inner);

GpuMat createCirclePattern(Size vidsize, int outer, int ring, int inner);

Mat convolve(Mat raw, GpuMat circleSpectrum, float thresold);

bool findMarker(Point2f a, Point2f b, double min, double max);

int identifyMarker(Point2f markerCenter, Mat img);

std::vector<Point2f> calculateMassCenters(Mat contour);

void drawTrainMarker(Mat& raw, Train& train, Point2f start, Point2f end, Point2f center);