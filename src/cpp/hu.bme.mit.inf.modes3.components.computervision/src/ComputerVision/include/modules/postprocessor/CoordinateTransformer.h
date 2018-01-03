/*
 * CoordinateTransformer.h
 *
 *  Created on: Sep 19, 2016
 *      Author: teqbox
 */

#ifndef COORDINATETRANSFORMER_H_
#define COORDINATETRANSFORMER_H_

#include "core/graph/Processor.h"
#include "core/data/TemplateConfiguration.h"
#include "modules/frameprovider/Camera.h"
#include <tbb/concurrent_unordered_map.h>
#include <tbb/flow_graph.h>
#include "modules/postprocessor/PostProcessor.h"

struct Matrices{
	tbb::concurrent_vector<cv::Mat> cameraMatrix;
	tbb::concurrent_vector<cv::Mat> distCoeffs;
	tbb::concurrent_vector<cv::Mat> projectionMatrix;
	tbb::concurrent_vector<cv::Mat> rectificationMatrix;
};

class CoordinateTransformer: public PostProcessor {
private:
	Matrices matrices;
	bool canTransform;
public:
	CoordinateTransformer(tbb::flow::graph& g):PostProcessor(g),canTransform(false){};

	bool loadMatrices(std::string path);

	ModelData process(ModelData ipData);

	~CoordinateTransformer()=default;
};

#endif /* COORDINATETRANSFORMER_H_ */
