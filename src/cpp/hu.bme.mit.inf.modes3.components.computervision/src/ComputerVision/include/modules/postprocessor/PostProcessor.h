#pragma once
#include "core/graph/Processor.h"
#include "core/data/TemplateConfiguration.h"
#include "core/data/DataTypes.h"
#include <tbb/concurrent_unordered_map.h>
#include <tbb/flow_graph.h>


class PostProcessor :
	public Processor<ModelData , ModelData ,tbb::flow::queueing>
{
public:
	PostProcessor(tbb::flow::graph& g):Processor<ModelData, ModelData, tbb::flow::queueing>(g, tbb::flow::serial){};

	virtual ModelData process(ModelData inData) = 0;

	virtual ~PostProcessor()=default;
};

