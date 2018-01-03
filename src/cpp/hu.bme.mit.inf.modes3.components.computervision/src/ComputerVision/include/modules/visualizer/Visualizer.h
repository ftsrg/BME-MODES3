#ifndef VISUALIZER_H_
#define VISUALIZER_H_

#include <tbb/flow_graph.h>
#include "core/graph/Processor.h"
#include "core/data/DataTypes.h"
#include <iostream>

class Visualizer :public Processor<tbb::flow::tuple<Frame, ModelData>, tbb::flow::continue_msg, tbb::flow::queueing> 
{
public:
	virtual tbb::flow::continue_msg process(tbb::flow::tuple<Frame, ModelData> data) = 0 ;

	Visualizer(tbb::flow::graph& g):Processor<tbb::flow::tuple<Frame, ModelData>, tbb::flow::continue_msg, tbb::flow::queueing>(g,1) {};

	Visualizer(Visualizer& vis) = delete;
	
	virtual ~Visualizer()=default;
};

#endif