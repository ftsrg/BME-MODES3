#include "Position.hpp"

float Position::getSpeed(const Position& newPos) {
	float distance = cv::norm(coordinate - newPos.coordinate);
	float ms = std::chrono::duration_cast<std::chrono::milliseconds>(newPos.time - time).count();
	
	float newSpeed = distance / ms * 1000;
	return newSpeed;
}

int Position::getDir(const Position& newPos) {
	Point2f center = {
		BOARD_WIDTH / 2,
		BOARD_HEIGHT / 2
	};
	
	Point2f centeredOld = center - coordinate;
	Point2f centeredNew = center - newPos.coordinate;
	float z = centeredOld.cross(centeredNew);
 
	if (abs(z) > 7.5) {
		if (z < 0)
			return DIR_CCW;
		else if (z > 0)
			return DIR_CW;
	}
	
	return DIR_NONE;
}