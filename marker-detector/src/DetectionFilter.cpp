#include "DetectionFilter.hpp"
#include "Utils.hpp"

void DetectionFilter::process() {
	auto timestamp = std::chrono::steady_clock::now();
	
	static Mat raw;
	cv::swap(convFilter.getData<1>(), raw);
	static Mat contour;
	cv::swap(convFilter.getData<0>(), contour);
	convFilter.clearToProcess();
	
	auto mc = calculateMassCenters(contour);
	
	for (int i = 0; i < MARKER_COUNT; ++i) {
		trains[i].setDetected(false);
	}
	
	DataSerializer serializer;
	serializer.setTimestamp(timestamp);
	
	#ifndef ENABLED_BENCHMARK
	
	std::tuple<int, Point2f, Point2f, Point2f> markers[MARKER_COUNT];
	for (int i = 0; i < MARKER_COUNT; ++i) {
		markers[i] = std::make_tuple(0, Point2f(), Point2f(), Point2f());
	}
	
	for (int i = 0; i < mc.size() - 1; ++i) {
		for (int j = i + 1; j < mc.size(); ++j) {
			//bool found = findMarker(mc[i], mc[j], 53, 60);
			bool found = findMarker(mc[i], mc[j], 60, 64);
			if (!found)
				continue;
			
			Point2f start = mc[i];
			Point2f end = mc[j];
			Point2f center = (start + end) / 2;
			
			int id = identifyMarker(center, raw);
			if (id != MARKER_UNKNOWN) {
				std::get<0>(markers[id])++;
				std::get<1>(markers[id]) = start;
				std::get<2>(markers[id]) = end;
				std::get<3>(markers[id]) = center;
			}
			
		}
	}
	
	for (int id = 0; id < MARKER_COUNT; ++id) {
		if (std::get<0>(markers[id]) == 1) {
			switch (id) {
				case MARKER_R:
					std::cout << "RED MARKER @ ";
					break;
				case MARKER_G:
					std::cout << "GREEN MARKER @ ";
					break;
				case MARKER_B:
					std::cout << "BLUE MARKER @ ";
					break;
				case MARKER_UNKNOWN:
					std::cout << "UNKOWN MARKER @ ";
				default:
					break;
			}
			
			trains[id].setDetected(true);
			
			Mat_<Point2f> cameraCorrectionMat(1, 1, std::get<3>(markers[id]));
			cv::undistortPoints(cameraCorrectionMat, cameraCorrectionMat, cameraMatrix, distCoeffs, cv::noArray(), cameraMatrix);
			Point2f undistorted = cameraCorrectionMat.at<Point2f>(0, 0);
			Point2f corrected = Train::getCorrectedCenter(undistorted, board);
			
			Position pos = { timestamp, corrected };
			trains[id].setCurrentPosition(pos);
			
			std::cout << trains[id].getCoordinate() << std::endl;
			std::cout << trains[id].getSpeed() << " cm/s" << std::endl;
			
			cv::circle(raw, Train::getCorrectedToCamera(Train::getCorrectedCenter(std::get<3>(markers[id]), board), board), 4, Scalar(0, 0, 255), -1);
			cv::circle(raw, Train::getCorrectedToCamera(corrected, board), 4, Scalar(0, 255, 0), -1);
			serializer.addTrain(trains[id]);
			
			drawTrainMarker(raw, trains[id], std::get<1>(markers[id]), std::get<2>(markers[id]), std::get<3>(markers[id]));
		} else {
			trains[id].setDetected(false);
		}
	}
	#endif
	
	std::cout << "----------------" << std::endl;
	
	for (int i = 0; i < MARKER_COUNT; ++i) {
		if(trains[i].getDetected() == false)
			trains[i].clearPositions();
	}
	
	cv::circle(raw, board.topLeft, 10, Scalar(255, 0, 0));
	cv::circle(raw, board.topRight, 10, Scalar(255, 0, 0));
	cv::circle(raw, board.bottomLeft, 10, Scalar(255, 0, 0));
	cv::circle(raw, board.bottomRight, 10, Scalar(255, 0, 0));
	
	//cv::line(raw, Point2f(1920 / 2, 0), Point2f(1920 / 2, 1080), Scalar(255, 255, 255), 2);
	//cv::line(raw, Point2f(0, 120), Point2f(1920, 120), Scalar(255, 255, 255), 2);
	//cv::line(raw, Point2f(0, 960), Point2f(1920, 960), Scalar(255, 255, 255), 2);
	
	cv::resize(raw, raw, raw.size() / 2);
	setData<0>(raw);
	setData<1>(serializer);
}

DetectionFilter::DetectionFilter(ConvolutionFilter& convFilter, Mat cameraMatrix, Mat distCoeffs, Board board)
: convFilter(convFilter), cameraMatrix(cameraMatrix), distCoeffs(distCoeffs), board(board)
{
	
}