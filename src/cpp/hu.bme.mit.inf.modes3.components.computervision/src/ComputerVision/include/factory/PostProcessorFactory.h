#pragma once

#include <tbb/flow_graph.h>
#include <boost/property_tree/ptree.hpp>
#include "modules/postprocessor/CoordinateTransformer.h"
#include "modules/postprocessor/ModesPostProcessor.h"
#include <map>

constexpr auto PATH = "path_to_matrices";

enum PostProcessorType {
	DEPTHCALCULATOR,
	MODES_POSTPROCESSOR
};

std::map<std::string, PostProcessorType> res_PostProcessorType{ {"depth_calculator", PostProcessorType::DEPTHCALCULATOR}, {"modes_postprocessor" , PostProcessorType::MODES_POSTPROCESSOR} };

class PostProcessorFactory
{
public:

	PostProcessorFactory() = delete;

	static std::unique_ptr<PostProcessor> createPostProcessor(boost::property_tree::ptree parameters, tbb::flow::graph& g) {
		std::unique_ptr<PostProcessor> postProcessor;

		try {
			auto type = res_PostProcessorType[parameters.get<std::string>(TYPE)];

			switch (type) {
			case DEPTHCALCULATOR:
			{
				auto path = parameters.get<std::string>(PATH);
				auto depthCalculator = std::make_unique<CoordinateTransformer>(g);
				depthCalculator->loadMatrices(path);
				postProcessor = std::move(depthCalculator);
			}
			break;
			case MODES_POSTPROCESSOR:
				{
					auto path = parameters.get<std::string>(PATH);
					auto modesPostProcessor = std::make_unique<ModesPostProcessor>(g);
					modesPostProcessor->loadMatrices(path);
					postProcessor = std::move(modesPostProcessor);
				}
				break;
			default:
				throw std::runtime_error("Not supported post processor!");
				break;
			}

		}
		catch (std::exception& e) {
			throw e;
		}

		return postProcessor;
	}

	virtual ~PostProcessorFactory() = delete;
};

