#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
#include <opencv2/highgui.hpp>
using namespace cv;

#include "Position.hpp"
#include "Board.hpp"
#include "Train.hpp"


void drawMarkerToMat(Mat& marker, int x, int y, int outer, int ring, int inner);

Mat createCirclePattern(Size vidsize, int outer, int ring, int inner);

Mat convolve(Mat raw, Mat circleSpectrum, float thresold);

bool findMarker(Point2f a, Point2f b, double min, double max);

int identifyMarker(Point2f markerCenter, Mat img);

std::vector<Point2f> calculateMassCenters(Mat contour);

void drawTrainMarker(Mat& raw, Train& train, Point2f start, Point2f end, Point2f center);