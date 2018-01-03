#include "modules/frameprovider/NetworkCamera.h"
#include "logger/logger.h"
#include <cppcodec/base64_default_rfc4648.hpp>
#include <opencv2/core.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/imgcodecs.hpp>

NetworkCamera::NetworkCamera(tbb::flow::graph& g) :FrameProvider(g),
													context(zmq::context_t(1)),
													subscriber(zmq::socket_t(context , ZMQ_SUB)),
													frameCounter(0){}

bool NetworkCamera::provide(Frame& frame)
{
	if (providing) {
		frame.images.clear();

		zmq::message_t topic;
		zmq::message_t image;
		
		//Receive image data
		subscriber.recv(&topic , 0);
		subscriber.recv(&image, 0);

		//convert image back to opencv mat
		std::string base64_image(static_cast<char*>(image.data()), image.size());
		auto jpeg_image = base64::decode(base64_image);
		cv::Mat decoded_image;
		decoded_image =cv::imdecode(jpeg_image , CV_LOAD_IMAGE_COLOR);
		
		//push it into the processing workflow
		frame.fps = 30;
		frame.frameIndex = frameCounter;
		auto time = std::chrono::steady_clock::now();
		auto timestamp = std::chrono::duration_cast<std::chrono::milliseconds>(time.time_since_epoch()).count();
		frame.timestamp = timestamp;
		frame.images.push_back(decoded_image);

		frameCounter++;
		return true;
	}
	else {
		return false;
	}
}

void NetworkCamera::reconfigure(boost::property_tree::ptree config)
{
}

bool NetworkCamera::initializeNetwork(std::string address, std::string topic)
{
	bool success = true;
	try {
		subscriber.connect(address);
		subscriber.setsockopt(ZMQ_SUBSCRIBE, topic.c_str(), topic.length());
	}
	catch (std::exception& e) {
		success = false;
	}
	
	return success;
}

NetworkCamera::~NetworkCamera()
{
	subscriber.close();
	context.close();
}
