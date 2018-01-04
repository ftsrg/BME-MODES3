/*
 * FrameProvider.h
 *
 *  Created on: Oct 7, 2016
 *      Author: teqbox
 */

#ifndef FRAMEPROVIDER_H_
#define FRAMEPROVIDER_H_

#include "core/data/DataTypes.h"
#include "core/graph/Provider.h"
#include <boost/property_tree/ptree.hpp>
#include <atomic>

class FrameProvider: public Provider<Frame> {
public:
	FrameProvider(tbb::flow::graph& g): Provider<Frame>(g){}

	virtual bool provide(Frame& images) = 0;

	virtual void reconfigure(boost::property_tree::ptree config) = 0;

	virtual ~FrameProvider() = default;
};

#endif /* FRAMEPROVIDER_H_ */
