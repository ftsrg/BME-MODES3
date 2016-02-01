#pragma once

#include <cmath>
#include <chrono>

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// User
#include "Constants.hpp"

struct Position {
    std::chrono::time_point<std::chrono::steady_clock> time;
    Point2f coordinate;
    
	float getSpeed(const Position& newPos);
	int getDir(const Position& newPos);
};