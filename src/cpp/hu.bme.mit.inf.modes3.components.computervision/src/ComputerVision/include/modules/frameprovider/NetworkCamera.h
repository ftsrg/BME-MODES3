#ifndef NETWORKCAMERA_H_
#define NETWORKCAMERA_H_

#include <opencv2/opencv.hpp>
#include "modules/frameprovider/FrameProvider.h"
#include "core/data/DataTypes.h"
#include <zmq.hpp>

constexpr auto ADDRESS = "address";
constexpr auto TOPIC = "topic";

class NetworkCamera :
	public FrameProvider
{
public:
	NetworkCamera(tbb::flow::graph& g);
	~NetworkCamera();

	bool provide(Frame& frame);
	void reconfigure(boost::property_tree::ptree config);
	bool initializeNetwork(std::string address , std::string topic);

private:
	int frameCounter;
	zmq::context_t context;
	zmq::socket_t subscriber;
};

#endif