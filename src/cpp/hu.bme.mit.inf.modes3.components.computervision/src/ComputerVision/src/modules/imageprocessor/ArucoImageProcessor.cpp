/*
 * ArucoImageProcessor.cpp
 *
 *  Created on: 2016. aug. 9.
 *      Author: M�t�
 */

#include "modules/imageprocessor/ArucoImageProcessor.h"
#include <tbb/parallel_for.h>
#include <tbb/concurrent_vector.h>
#include <opencv2/aruco.hpp>
#include <opencv2/imgproc.hpp>
#include <chrono>

//#define MEASURE_TIME

template <typename CONFIG>
ImageProcessingData< CONFIG >ArucoImageProcessor<CONFIG>::process(Frame frame){

	ImageProcessingData<CONFIG> foundMarkers;
	foundMarkers.data = tbb::concurrent_vector<tbb::concurrent_vector<cv::Point2f> >(frame.images.size());
	foundMarkers.identifiers = tbb::concurrent_vector<tbb::concurrent_vector<int> >(frame.images.size());

#ifdef MEASURE_TIME
	auto time = std::chrono::steady_clock::now();
#endif
	try{
		tbb::parallel_for(size_t(0), frame.images.size(), size_t(1), [&](size_t i){

			/*cv::Mat thresholded;
			cv::cvtColor(frame.images[i], thresholded , CV_BGR2GRAY);
			cv::adaptiveThreshold(thresholded, thresholded, 255, CV_ADAPTIVE_THRESH_GAUSSIAN_C, CV_THRESH_BINARY_INV, 11, 7);
			cv::resize(thresholded, thresholded ,  thresholded.size() / 2);
			cv::imshow("debug", thresholded);
			cv::waitKey(5);
			*/
			std::vector< std::vector< cv::Point2f > > corners, rejected;
			std::vector<int> identifiers;
			try{
				cv::aruco::detectMarkers(frame.images[i].clone(), dictionary, corners, identifiers, detectorParams, rejected);
			}
			catch (std::exception& e){
				std::cout << e.what() << std::endl;
			}
			cv::Point2f center;
			float r;
			
			tbb::concurrent_vector<cv::Point2f> markerPosition(corners.size());
			tbb::concurrent_vector<int> 		markerIdentifier(identifiers.size());

			int j = 0;
			for (auto& corner : corners){
				cv::minEnclosingCircle(corner, center, r);
				markerPosition[j] = center;
				markerIdentifier[j] = identifiers[j];
				j++;
			}
			foundMarkers.data[i] = markerPosition;
			foundMarkers.identifiers[i] = markerIdentifier;
		});
	}
	catch (std::exception& e){
		std::cout<<e.what()<<std::endl;
	}

#ifdef MEASURE_TIME

	auto endTime = std::chrono::steady_clock::now();

	auto diff = std::chrono::duration_cast<std::chrono::milliseconds>(endTime-time).count();

	std::unique_lock<std::mutex> l(lock);
	std::cout << diff << std::endl;

#endif

	foundMarkers.timestamp = frame.timestamp;
	foundMarkers.frameIndex = frame.frameIndex;
	prevFrameIdx = frame.frameIndex;

	return foundMarkers;
}

template <typename CONFIG>
void ArucoImageProcessor<CONFIG>::reconfigure(boost::property_tree::ptree config){
}
