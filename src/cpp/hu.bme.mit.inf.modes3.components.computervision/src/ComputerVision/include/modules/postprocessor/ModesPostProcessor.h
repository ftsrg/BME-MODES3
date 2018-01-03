#pragma once
#include "modules/postprocessor/PostProcessor.h"
#include "core/data/DataTypes.h"
#include <tbb/flow_graph.h>
#include <opencv2/core.hpp>

class ModesPostProcessor :
	public PostProcessor
{
private:
	ObjectData tablePosition;
	cv::Point2f leftTop;
	cv::Point2f rightTop;
	cv::Point2f leftBottom;
	cv::Point2f rightBottom;
	cv::Mat camMatrix;
	cv::Mat distCoeffs;
	bool validDetection;
	cv::Mat perspective;

	float calculateDistance(cv::Point2f p1, cv::Point2f p2);
	void initializeTablePositions(ObjectData tablePosition);
public:
	ModesPostProcessor(tbb::flow::graph& g) :PostProcessor(g),validDetection(false) {};

	void loadMatrices(std::string path);

	ModelData process(ModelData inData);

	

	~ModesPostProcessor()=default;
};

