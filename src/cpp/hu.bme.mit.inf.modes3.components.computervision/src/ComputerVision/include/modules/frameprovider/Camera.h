/*
 * Camera.h
 *
 *  Created on: 2016. aug. 9.
 *      Author: M�t�
 */

#ifndef CAMERA_H_
#define CAMERA_H_

#include <opencv2/videoio.hpp>
#include <tbb/flow_graph.h>
#include <tbb/parallel_for.h>
#include <tbb/concurrent_vector.h>
#include <boost/property_tree/ptree.hpp>
#include <chrono>
#include <atomic>
#include <thread>
#include <fstream>
#include "modules/frameprovider/FrameProvider.h"
#include "core/data/DataTypes.h"

constexpr auto EXPOSURE = "exposure";
constexpr auto GAIN = "gain";
constexpr auto FPS = "fps";
constexpr auto NUMBEROFCAMERAS = "number";
constexpr auto WIDTH = "width";
constexpr auto HEIGHT = "height";

class Camera: public FrameProvider {
	int numberOfCameras;
	int exposure;
	float gain;
	int fps;
	int frameCounter ;
	std::ofstream ofs;
	int64_t lastTimestamp;

	std::vector<cv::VideoCapture> cameras;

public:

	Camera(int fps , int exposure , float gain, int numberOfCameras, tbb::flow::graph& g) :
			FrameProvider(g), numberOfCameras(numberOfCameras), exposure(
					exposure), gain(gain),fps(fps),frameCounter(0),lastTimestamp(0){};

	bool provide(Frame &frame);
	void reconfigure(boost::property_tree::ptree config);
	bool initialize(int cameraType , cv::Size frameSize);

	virtual ~Camera();
};

#endif /* CAMERA_H_ */
