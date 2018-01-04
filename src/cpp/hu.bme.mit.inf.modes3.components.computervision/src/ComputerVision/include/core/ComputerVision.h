/*
 * ComputerVision.h
 *
 *  Created on: 2016. aug. 9.
 *      Author: M�t�
 */

#ifndef COMPUTERVISION_H_
#define COMPUTERVISION_H_

#include <tbb/flow_graph.h>
#include <tbb/concurrent_vector.h>
#include <tbb/concurrent_unordered_map.h>
#include <opencv2/opencv.hpp>
#include <atomic>
#include <iostream>
#include <map>
#include <boost/property_tree/ptree.hpp>

#include "core/graph/Object.h"
#include "modules/frameprovider/FrameProvider.h"
#include "core/data/TemplateConfiguration.h"
#include "modules/imageprocessor/ImageProcessor.h"
#include "core/graph/ModelDataStore.h"
#include "core/graph/ObjectDataCollector.h"
#include "modules/datasender/DataSender.h"
#include "core/data/DataTypes.h"

constexpr auto FRAME_PROVIDER	=	"frameprovider";
constexpr auto VISUALIZER		=	"visualizer";
constexpr auto POSTPROCESSOR	= "postprocessor";
constexpr auto OBJECTS			= "objects";
constexpr auto IMAGEPROCESSORS  = "imageprocessors";
constexpr auto IMAGEPROCESSOR   = "imageprocessor";
constexpr auto DATA_SENDERS		= "datasenders";
constexpr auto TRANSFORMER		= "transformer";
constexpr auto NAME				= "name";
constexpr auto LIMIT			= "limit";
constexpr auto MARKER_TYPE		= "markertype";
constexpr auto ID				= "id";
constexpr auto MARKERS			= "markers";

constexpr auto DEFAULT_CAMERA	= 0;

using t_cfg						= TEMPLATE_CONFIG<tbb_vector<cv::Point2f>, tbb_vector<int > >;

using ip_data_sequencer			= tbb::flow::sequencer_node<ImageProcessingData<t_cfg> >;
using ip_data_broadcaster		= tbb::flow::broadcast_node<ImageProcessingData<t_cfg> >;
using frame_limiter				= tbb::flow::limiter_node<Frame >;
using object_limiter			= tbb::flow::limiter_node<ImageProcessingData<t_cfg> >;

class ComputerVision  :public tbb::flow::graph {
private:
	std::unique_ptr<FrameProvider> frameProvider;
	std::unique_ptr<ModelDataStore> model;
	std::vector<std::shared_ptr<DataSender<ModelData> > > objectDataSenders;
	//raw image processing data senders mapped by markertype
	std::map < std::string, std::shared_ptr<DataSender<ImageProcessingData<t_cfg> > > > ipDataSenders;
	//image processors mapped by markertype
	std::map <std::string, std::shared_ptr<ImageProcessor<t_cfg> > > imageProcessors;
	//configuration instance
	boost::property_tree::ptree config;
	std::atomic<bool> initialized;
	std::atomic<bool> processing;

	bool validateConfig();
public:
	ComputerVision():initialized(false), processing(false),model(std::make_unique<ModelDataStore>(*this)) {};
	bool initialize(const std::string configFilePath);
	void startProcessing();
	void stopProcessing();
	bool getData(ModelData& output);
	void reconfigure(const std::string configFilePath);
	bool isProcessing();
	virtual ~ComputerVision() = default;
};

#endif /* COMPUTERVISION_H_ */
