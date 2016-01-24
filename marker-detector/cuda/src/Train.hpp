#pragma once

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// OpenCV - CUDA
#include <opencv2/core/cuda.hpp>
#include <opencv2/cudaarithm.hpp>
using namespace cv;
using namespace cv::cuda;

// User
#include "Constants.hpp"
#include "Position.hpp"
#include "Board.hpp"

struct Train {
    const int BUFFER_SIZE = 5;
	
    int id = -1;
    int dir = DIR_NONE;
    bool detected = false;
    float lastSpeed = 0.0;
    std::vector<Position> positions;

	Train();
	Train(int identifier);

	void setCurrentPosition(Position pos);
	void setDetected(bool detected);
	
	bool getDetected();
	float getSpeed();
	std::string getDir();
	Position getPosition();
	Point2f getCoordinate();
	
	void clearPositions();
	
	static Point2f getCorrectedCenter(Point2f currentCameraPos, Board& board);
	static Point2f getCorrectedToCamera(Point2f corrected, Board& board);
};