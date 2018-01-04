#ifndef IMAGEPROCESSORFACTORY_H_
#define IMAGEPROCESSORFACTORY_H_

#include <memory>
#include <string>
#include <boost/property_tree/ptree.hpp>
#include "modules/imageprocessor/ImageProcessor.h"
#include "modules/imageprocessor/ArucoImageProcessor.h"
#include "modules/imageprocessor/ArucoImageProcessor.cpp"


constexpr auto TYPE			= "type";
constexpr auto DICTIONARY	= "dictionary";

enum MarkerType {
	ARUCO,
	CIRCLE,
	IRTD
};

std::map<std::string, MarkerType> res_MarkerType = { { "aruco",MarkerType::ARUCO },{ "irtd", MarkerType::IRTD },{ "circle",MarkerType::CIRCLE } };

class ImageProcessorFactory
{
public:
	ImageProcessorFactory()=delete;

	template <typename CONFIG>
	static std::shared_ptr<ImageProcessor<CONFIG> >createImageProcessor(boost::property_tree::ptree parameters, tbb::flow::graph& g) {

		std::shared_ptr < ImageProcessor<CONFIG> > imageprocessor;
		try {
			auto markerType = res_MarkerType[parameters.get<std::string>(TYPE)];
			switch (markerType) {
			case ARUCO:
				imageprocessor = std::make_shared<ArucoImageProcessor<CONFIG> >(g);
				break;
			case IRTD:
			{
				throw std::runtime_error("not supported image processor!");
				break;
			}
			case CIRCLE:
				throw std::runtime_error("not supported image processor!");
				break;
			default:
				throw std::runtime_error("Not supported image processing method!");
				break;
			}
			imageprocessor->reconfigure(parameters);
		}
		catch (std::exception& e) {
			throw e;
		}
		
		return imageprocessor;
	}

	virtual ~ImageProcessorFactory()=delete;
};

#endif //IMAGEPROCESSORFACTORY_H_
