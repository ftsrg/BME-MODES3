#include "modules/frameprovider/VideoSource.h"
#include "tbb/concurrent_vector.h"
#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/imgproc.hpp>
#include <chrono>
#include <thread>

bool VideoSource::initialize(std::vector<std::string> sources) {

	for (auto source : sources) {
		cv::VideoCapture video(source);
		video.set(cv::CAP_PROP_FRAME_WIDTH, 1366);
		video.set(cv::CAP_PROP_FRAME_HEIGHT, 768);
		if (video.isOpened()) {
			streams.push_back(video);
		}
		else {
			return false;
		}
	}
	return true;
}


bool VideoSource::provide(Frame& frame) {
	frame.images = tbb::concurrent_vector<cv::Mat>(streams.size());

	auto currentTime = std::chrono::steady_clock::now();
	auto currentTimestamp = std::chrono::duration_cast<std::chrono::milliseconds>(currentTime.time_since_epoch()).count();

	auto delay = (1000 / fps) - (currentTimestamp - lastTimestamp);

	if (delay > 0 && lastTimestamp != 0) {
		std::this_thread::sleep_for(std::chrono::milliseconds(delay));
	}

	currentTime = std::chrono::steady_clock::now();
	currentTimestamp = std::chrono::duration_cast<std::chrono::milliseconds>(
		currentTime.time_since_epoch()).count();

	int i = 0;
	for (auto& stream : streams) {
		if (!stream.read(frame.images[i])) {
			std::cout << "Failed to read the next image!" << std::endl;
			providing = false;
			return false;
		}
		i++;
	}
	float currentFps;
	if ((currentTimestamp - lastTimestamp)>0) {
		currentFps = 1000.0f / (currentTimestamp - lastTimestamp);
	}
	std::stringstream fpsstring;
	fpsstring << "Current fps: " << currentFps;
	frame.fps = currentFps;

	for (auto& i : frame.images) {
		cv::putText(i, fpsstring.str(), cv::Point(100, 100), cv::FONT_HERSHEY_SIMPLEX, 1.0, cv::Scalar(255, 255, 255), 2);
	}
	frame.frameIndex = frameIndex;
	frame.timestamp = currentTimestamp;

	frameIndex++;
	lastTimestamp = currentTimestamp;

	if (!providing) {
		for (auto& stream : streams) {
			stream.release();
		}
	}
	return providing;
}

void VideoSource::reconfigure(boost::property_tree::ptree config) {
	fps = config.get<int>("fps");
}