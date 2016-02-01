#include "Train.hpp"
#include "Utils.hpp"

Train::Train() { }

Train::Train(int identifier) : id(identifier) { }

void Train::setCurrentPosition(Position pos) {
	if (positions.size() < BUFFER_SIZE) {
		positions.push_back(pos);
		lastSpeed = 0.0;
	} else {
		positions.push_back(pos);
		positions.erase(positions.begin());
		
		float accumulatedSpeed = 0.0;
		for (int i = 0; i < positions.size() - 1; ++i) {
			accumulatedSpeed += positions[i].getSpeed(positions[i+1]);
		}
		
		float speed = accumulatedSpeed / positions.size();
		if (speed < 0.5) {
			lastSpeed = 0.0;
		} else {
			lastSpeed = speed;
		}
		
		dir = positions[0].getDir(positions[positions.size() - 1]);
	}
}

void Train::setDetected(bool detected) {
	this->detected = detected;
}

bool Train::getDetected() {
	return detected;
}

void Train::clearPositions() {
	positions.clear();
}

float Train::getSpeed() {
	return lastSpeed;
}

std::string Train::getDir() {
	switch (dir) {
		case DIR_NONE:
			return "NONE";
		case DIR_CW:
			return "CW";
		case DIR_CCW:
			return "CCW";
	}
	
	return "LOL";
}

Position Train::getPosition() {
	return positions[positions.size() - 1];
}

Point2f Train::getCoordinate() {
	return positions[positions.size() - 1].coordinate;
}

Point2f Train::getCorrectedCenter(Point2f currentCameraPos, Board& board) {
	static Mat_<Point2f> perspectiveCorrMat(1, 1);
	perspectiveCorrMat.at<Point2f>(0, 0) = currentCameraPos;
	cv::perspectiveTransform(perspectiveCorrMat, perspectiveCorrMat, board.perspectiveTrans);
	
	Point2f corrected(perspectiveCorrMat.at<Point2f>(0, 0));
	Point2f distFromCenter = board.getCenter() - corrected;
	Point2f perspectiveError = distFromCenter * (TRAIN_HEIGHT / CAMERA_HEIGHT);
	Point2f perspectiveCorrected = corrected + perspectiveError;
	
	return perspectiveCorrected;
}

Point2f Train::getCorrectedToCamera(Point2f corrected, Board& board) {
	static Mat_<Point2f> translatedCenterMat(Size(1, 1));
	translatedCenterMat.at<Point2f>(0, 0) = corrected;
	cv::perspectiveTransform(translatedCenterMat, translatedCenterMat, board.inverseTrans);
	
	return translatedCenterMat.at<Point2f>(0, 0);
}
