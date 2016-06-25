#define _WINSOCK_DEPRECATED_NO_WARNINGS

#include <iostream>
#include <list>
#include <chrono>

// OpenCV
#include <opencv2/opencv.hpp>
using namespace cv;

// User
#include "Constants.hpp"
#include "Board.hpp"
#include "MqttClient.hpp"

#include "InputFilter.hpp"
#include "ConvolutionFilter.hpp"
#include "DetectionFilter.hpp"

template class Filter<Mat>;
template class Filter<Mat, Mat>;

Mat distCoeffs, cameraMatrix;

int main(int argc, char** argv)
{
	cv::namedWindow("DetectionOut");
	
	#ifdef MQTT_ENABLED
		MqttClient client;
		if (!client.Connect("192.168.1.2")) {
			std::cout << "Error while connectiong to MQTT broker, aborting";
			return -10;
		}
	#endif

	cv::FileStorage fs("camera_data.xml", FileStorage::READ);
	fs["Distortion_Coefficients"] >> distCoeffs;
	fs["Camera_Matrix"] >> cameraMatrix;

	#ifdef ENABLE_BENCHMARK
	VideoCapture vid("Test4T.mov");
	vid.set(CAP_PROP_FPS, 5);
	#else
	VideoCapture vid(1);
	#endif
	vid.set(CAP_PROP_FRAME_WIDTH, 1920);
	vid.set(CAP_PROP_FRAME_HEIGHT, 1080);

	Board board = Board::detectBoard(vid, cameraMatrix, distCoeffs);

	InputFilter inputFilter(vid);
	ConvolutionFilter convFilter(inputFilter);
	DetectionFilter detFilter(convFilter, cameraMatrix, distCoeffs, board);

	inputFilter.start();
	convFilter.start();
	detFilter.start();

	std::list<long> times;
	while (true) {
		auto start = std::chrono::steady_clock::now();

		static Mat output;
		detFilter.getData<0>().copyTo(output);
		detFilter.clearToProcess();
		
		// EYE CANDY
		//cv::resize(output, output, output.size() / 3 * 2);
		imshow("DetectionOut", output);
		waitKey(1);

		static DataSerializer data;
		data = detFilter.getData<1>();

		#ifdef MQTT_ENABLED
			client.SendTrainData(data);
		#endif

		// FPS CALCULUS ===========

		long dur = std::chrono::duration_cast<std::chrono::milliseconds>(std::chrono::steady_clock::now() - start).count();
		times.push_back(dur);

		float fps = 0;
		for (long dur : times) {
			fps += dur;
		}
		fps = (times.size() * 1000) / fps;

		if (times.size() == 10) {
			times.pop_front();
			std::cout << "FPS: " << fps << std::endl;
		}
	}

	return 0;
}
