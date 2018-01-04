#include "modules/postprocessor/ModesPostProcessor.h"
#include "logger/logger.h"
#include <opencv2/imgproc.hpp>
#include <opencv2/calib3d.hpp>

void ModesPostProcessor::loadMatrices(std::string path) {
	cv::FileStorage file;
	if (!file.open(path, cv::FileStorage::READ)) {
		throw std::runtime_error("The file containing the matrices is missing!");
	}

	try {
		file["cameraMatrix"] >>camMatrix;
		file["distCoeffs"] >> distCoeffs;
		file.release();
	}
	catch (std::exception& e) {
		file.release();
		throw e;
	}
}

ModelData ModesPostProcessor::process(ModelData inData) {

	auto retData = inData;

	if (!validDetection) {
		tablePosition = inData.objectData["table"];

		if (tablePosition.markerData["left top"].tracked[0] && 
			tablePosition.markerData["right top"].tracked[0] &&
			tablePosition.markerData["left bottom"].tracked[0] && 
			tablePosition.markerData["right bottom"].tracked[0]) {
				initializeTablePositions(tablePosition);
				validDetection = true;
		}
	}
	if (validDetection) {
		for (auto& object : retData.objectData) {
			if (object.first != "table") {
				for (auto& marker : object.second.markerData) {
					if (marker.second.tracked[0]) {
						auto screenPosition = marker.second.screenPosition[0];
						std::vector<cv::Point2f> undistortedMarkerPosition;
						cv::undistortPoints(std::vector<cv::Point2f>{screenPosition}, undistortedMarkerPosition,
							camMatrix, distCoeffs, cv::noArray(), camMatrix);
             
						std::vector<cv::Point2f> transformedPoints;
						cv::perspectiveTransform(undistortedMarkerPosition, transformedPoints, perspective);
						auto x = transformedPoints[0].x*(140.0f/145.0f)+125.0f;
						auto y = transformedPoints[0].y*(140.0f/145.0f)+70.0f;
						
						marker.second.realPosition = cv::Point3f(x,y, 1.5);
						//std::cout<<"POSTPROCESSOR:" << marker.second.name << "    " << marker.second.realPosition << std::endl;
					}
				}
			}
		}
	}
	
	return retData;
}

float ModesPostProcessor::calculateDistance(cv::Point2f p1, cv::Point2f p2) {
	cv::Point2f diff = p1 - p2;
	return sqrtf(powf(diff.x, 2.0f) + powf(diff.y, 2.0f));
}

void ModesPostProcessor::initializeTablePositions(ObjectData table) {
	std::vector<cv::Point2f> distortedTablePoints =
	{
		tablePosition.markerData["left top"].screenPosition[0],
		tablePosition.markerData["right top"].screenPosition[0],
		tablePosition.markerData["left bottom"].screenPosition[0],
		tablePosition.markerData["right bottom"].screenPosition[0]
	};

	std::vector<cv::Point2f> undistortedTablePoints;

	cv::undistortPoints(distortedTablePoints, undistortedTablePoints, camMatrix, distCoeffs, cv::noArray(), camMatrix);

	std::vector<cv::Point2f> rectangle = { cv::Point2f(-107.0f,-52.0f) , cv::Point2f(107.0f,-52.0f) , cv::Point2f(-107.0f,52.0f) , cv::Point2f(107.0f,52.0f)};
	cv::Mat tr = cv::getPerspectiveTransform(undistortedTablePoints, rectangle);

	std::vector<cv::Point2f> transformedPoints;
	cv::perspectiveTransform(undistortedTablePoints, transformedPoints, tr);

	perspective = tr;

	leftTop = transformedPoints[0];
	rightTop = transformedPoints[1];
	leftBottom = transformedPoints[2];
	rightBottom = transformedPoints[3];
}
