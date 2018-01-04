/*
 * Visualizer.h
 *
 *  Created on: 2016. aug. 19.
 *      Author: M�t�
 */

#ifndef SIMPLEVISUALIZER_H_
#define SIMPLEVISUALIZER_H_

#include <tbb/flow_graph.h>
#include <opencv2/highgui.hpp>
#include "core/data/DataTypes.h"
#include "modules/visualizer/Visualizer.h"

class SimpleVisualizer: public Visualizer{
private:
	std::vector<ModelData> dataBuffer;
	std::vector<Frame> frameBuffer;
	std::string windowName;
	uint64_t delay;
	uint64_t lastTimestamp;
public:
	
	SimpleVisualizer(std::string windowName, int64_t delay ,tbb::flow::graph& g):Visualizer(g),windowName(windowName),delay(delay),lastTimestamp(0) {};

	tbb::flow::continue_msg process(tbb::flow::tuple<Frame, ModelData> data);

	SimpleVisualizer(SimpleVisualizer& vis) = delete;

	virtual ~SimpleVisualizer();
};

#endif /* VISUALIZER_H_ */
