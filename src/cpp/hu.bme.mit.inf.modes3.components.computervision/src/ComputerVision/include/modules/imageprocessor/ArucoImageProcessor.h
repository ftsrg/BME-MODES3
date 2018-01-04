/*
 * ArucoImageProcessor.h
 *
 *  Created on: 2016. aug. 9.
 *      Author: Máté
 */

#ifndef ARUCOIMAGEPROCESSOR_H_
#define ARUCOIMAGEPROCESSOR_H_

#include "modules/imageprocessor/ImageProcessor.h"
#include <opencv2/aruco.hpp>
#include <tbb/flow_graph.h>
#include <fstream>
#include <mutex>

template<typename CONFIG>
class ArucoImageProcessor : public ImageProcessor<CONFIG> {
private:
	cv::Ptr<cv::aruco::Dictionary> dictionary;
	cv::Ptr<cv::aruco::DetectorParameters> detectorParams;
	int64_t prevFrameIdx;

	std::mutex lock;

public:
	ArucoImageProcessor(tbb::flow::graph& g) :ImageProcessor<CONFIG>(g), dictionary(cv::aruco::getPredefinedDictionary(cv::aruco::DICT_ARUCO_ORIGINAL)), detectorParams(cv::aruco::DetectorParameters::create()), prevFrameIdx(0) {
		detectorParams->adaptiveThreshWinSizeMin = 5;
		detectorParams->adaptiveThreshWinSizeMax = 35;
		detectorParams->adaptiveThreshWinSizeStep = 10;
		detectorParams->adaptiveThreshConstant = 10;
		//detectorParams->doCornerRefinement = true;
	};
	ImageProcessingData<CONFIG> process(Frame frame);

	virtual void reconfigure(boost::property_tree::ptree config);

	virtual ~ArucoImageProcessor() = default;
};

#endif /* ARUCOIMAGEPROCESSOR_H_ */
