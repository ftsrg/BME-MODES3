#pragma once
#include "modules/visualizer/Visualizer.h"
#include "modules/visualizer/SimpleVisualizer.h"
#include <tbb/flow_graph.h>
#include <boost/property_tree/ptree.hpp>
#include <map>

constexpr auto DELAY = "delay";
constexpr auto WINDOW_NAME = "windowname";

enum VisualizerType {
	SIMPLE
};

std::map<std::string, VisualizerType> res_VisualizerType = { {"simple",VisualizerType::SIMPLE} };

class VisualizerFactory
{
public:
	VisualizerFactory()=delete;

	static std::unique_ptr<Visualizer> createVisualizer(boost::property_tree::ptree parameters, tbb::flow::graph& g) {
		std::unique_ptr<Visualizer> visualizer;

		try {
			auto type = res_VisualizerType[parameters.get<std::string>(TYPE)];

			switch (type) {
			case VisualizerType::SIMPLE:
			{
				auto delay = parameters.get<int>(DELAY);
				auto windowName = parameters.get<std::string>(WINDOW_NAME);
				auto simple = std::make_unique<SimpleVisualizer>(windowName, delay, g);
				visualizer = std::move(simple);
				break; 
			}		
			default:
				throw std::runtime_error("Not supported visualizer!");
				break;
			}
		}
		catch (std::exception& e) {
			throw e;
		}
		return visualizer;
	}

	~VisualizerFactory()=delete;
};

