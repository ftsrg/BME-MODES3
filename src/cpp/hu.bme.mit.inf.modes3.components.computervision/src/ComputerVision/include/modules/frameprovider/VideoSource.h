#ifndef VIDEOSOURCE_H_
#define VIDEOSOURCE_H_

#include "modules/frameprovider/FrameProvider.h"
#include "core/data/DataTypes.h"
#include <tbb/flow_graph.h>
#include <opencv2/videoio.hpp>
#include <boost/property_tree/ptree.hpp>

#define SOURCES		"sources"

class VideoSource : public FrameProvider	{
private:
	std::vector<cv::VideoCapture> streams;
	int64_t frameIndex;
	int64_t lastTimestamp;
	int fps;
public:
	VideoSource(int fps, tbb::flow::graph& g) :FrameProvider(g),frameIndex(0),lastTimestamp(0),fps(fps) {};
	bool initialize(std::vector<std::string> path);
	void reconfigure(boost::property_tree::ptree config);
	bool provide(Frame& frame);
	virtual ~VideoSource()=default;
};

#endif //VIDEOSOURCE_H_