#include <iostream>
#include <opencv2/core.hpp>
#include <opencv2/aruco.hpp>
#include <opencv2/highgui.hpp>
#include <boost/program_options.hpp>


int main(int argc, char *argv[]) {

	//boost::po::options_description desc("Allowed options");


	cv::Mat markerImage;
	cv::Ptr<cv::aruco::Dictionary> dict_ptr(cv::aruco::getPredefinedDictionary(cv::aruco::DICT_4X4_100));

	for (int i = 0; i < 20; i++) {
		std::stringstream image_name;
		image_name << "marker" << i<<".png";
		cv::aruco::drawMarker(dict_ptr, i, 100, markerImage);
		cv::imwrite(image_name.str(), markerImage);
	}
}