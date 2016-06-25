#include "Board.hpp"
#include "Utils.hpp"

void Board::calculatePerspectiveMat() {
	cv::Point2f src[4] = {
		topLeft, topRight, bottomRight, bottomLeft
	};

	cv::Point2f dst[4] = {
		cv::Point2f(0, 0),
		cv::Point2f(BOARD_WIDTH, 0),
		cv::Point2f(BOARD_WIDTH, BOARD_HEIGHT),
		cv::Point2f(0, BOARD_HEIGHT)
	};

	perspectiveTrans = cv::getPerspectiveTransform(src, dst);
	inverseTrans = perspectiveTrans.inv();
}

cv::Rect Board::getBoundingBox() {
	std::vector<cv::Point> points = { topLeft, topRight, bottomLeft, bottomRight };
	return cv::boundingRect(points);
}

Point2f Board::getCenter() {
	return Point2f(BOARD_WIDTH / 2, BOARD_HEIGHT / 2);
}

Board Board::detectBoard(VideoCapture& vid, Mat cameraMatrix, Mat distCoeffs) {
	#ifdef ENABLE_BENCHMARK
	Board benchmarkBoard;
	benchmarkBoard.topLeft = Point2f(0, 0);
	benchmarkBoard.topRight = Point2f(1920, 0);
	benchmarkBoard.bottomLeft = Point2f(0, 1080);
	benchmarkBoard.bottomRight = Point2f(1920, 1080);
	benchmarkBoard.calculatePerspectiveMat();
	return benchmarkBoard;
	#else

	Mat raw;
	vid >> raw;
	std::cout << raw.size() << std::endl;

	Mat undistorted;
	cv::undistort(raw, undistorted, cameraMatrix, distCoeffs);
	Point2i decPoint = raw.size() / 2;

	#ifdef ENABLE_GPU
	GpuMat boardCicle = createCirclePattern(Size(2048, 1024), B_MARKER_OUTER, B_MARKER_MID, B_MARKER_INNER);
	#else
	Mat boardCicle = createCirclePattern(Size(2048, 1024), B_MARKER_OUTER, B_MARKER_MID, B_MARKER_INNER);
	#endif

	std::cout << "Searching board..." << std::endl;

	Mat contour;
	std::vector<Point2f> mc;
	float thresold = 0.99;
	while (true) {
		contour = convolve(undistorted, boardCicle, thresold);

		/*
		 Mat debug;
		 cv::resize(contour, debug, contour.size() * 2 / 3);
		 imshow("c", debug);
		 waitKey(0);
		 */

		std::cout << "Thresold: " << thresold << std::endl;

		mc = calculateMassCenters(contour);
		if (mc.size() == 4) {
			bool zeroPoint = false;
			for (auto& point : mc) {
				if (point.x < 0.1 || point.y < 0.1)
					zeroPoint = true;
			}
			if (zeroPoint) {
				thresold -= 0.025;
				continue;
			}
			break;
		} else if (mc.size() > 4 || thresold < 0.5)
			throw std::runtime_error("Board cannot be detected");

		thresold -= 0.05;
	}

	std::cout << "Board found" << std::endl;
	std::cout << "===========" << std::endl;

	Board board;
	for (auto& point : mc) {
		if (point.x < decPoint.x) {
			if (point.y < decPoint.y) {
				board.topLeft = point;
			} else {
				board.bottomLeft = point;
			}
		} else {
			if (point.y < decPoint.y) {
				board.topRight = point;
			} else {
				board.bottomRight = point;
			}
		}
	}
	board.calculatePerspectiveMat();

	return board;

	#endif
}
