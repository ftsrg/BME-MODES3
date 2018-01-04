/*
 * CoordinateTransformer.cpp
 *
 *  Created on: Sep 19, 2016
 *      Author: teqbox
 */

#include "modules/postprocessor/CoordinateTransformer.h"
#include <opencv2/calib3d.hpp>
#include <opencv2/imgproc.hpp>

bool CoordinateTransformer::loadMatrices(std::string path){
	cv::FileStorage file;
	try {
		if (!file.open(path, cv::FileStorage::READ)) {
			throw std::runtime_error("The file containing the matrices is missing!");
		}
	}
	catch (std::exception& e) {
		
		file.release();
		canTransform = false;

		throw e;
		return false;
	}
	try {
		cv::Mat matrix;
		file["m1"] >> matrix;
		matrices.cameraMatrix.push_back(matrix.clone());
		file["m2"] >> matrix;
		matrices.cameraMatrix.push_back(matrix.clone());
		file["d1"] >> matrix;
		matrices.distCoeffs.push_back(matrix.clone());
		file["d2"] >> matrix;
		matrices.distCoeffs.push_back(matrix.clone());
		file["p1"] >> matrix;
		matrices.projectionMatrix.push_back(matrix.clone());
		file["p2"] >> matrix;
		matrices.projectionMatrix.push_back(matrix.clone());
		file["r1"] >> matrix;
		matrices.rectificationMatrix.push_back(matrix.clone());
		file["r2"] >> matrix;
		matrices.rectificationMatrix.push_back(matrix.clone());

		file.release();
	}
	catch (std::exception& e) {
		throw e;
		canTransform = false;
		return false;
	}
	canTransform = true;
	return true;
}

ModelData CoordinateTransformer::process(ModelData modelData){
	if (canTransform) {
		for (auto& objectData : modelData.objectData) {
			for (auto& markerData : objectData.second.markerData) {
				if (markerData.second.screenPosition.size() == 2 && markerData.second.tracked[0] && markerData.second.tracked[1]) {

					std::vector<cv::Point2f> p1{ markerData.second.screenPosition[0] };
					std::vector<cv::Point2f> p2{ markerData.second.screenPosition[1] };

					cv::undistortPoints(p1, p1, matrices.cameraMatrix[0], matrices.distCoeffs[0], matrices.rectificationMatrix[0], matrices.projectionMatrix[0]);
					cv::undistortPoints(p2, p2, matrices.cameraMatrix[1], matrices.distCoeffs[1], matrices.rectificationMatrix[1], matrices.projectionMatrix[1]);

					cv::Mat cord;
					cv::triangulatePoints(matrices.projectionMatrix[0], matrices.projectionMatrix[1], p1, p2, cord);

					float x, y, z;
					for (int i = 0; i<cord.cols; i++) {
						float w = cord.at<float>(3, i);
						x = cord.at<float>(0, i) / w;
						y = cord.at<float>(1, i) / w;
						z = cord.at<float>(2, i) / w;
					}
					markerData.second.realPosition = cv::Point3f(x, y, z);
				}
			}
		}
	}
	return modelData;
}
