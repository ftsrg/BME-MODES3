cmake_minimum_required(VERSION 3.7)

include(ExternalProject)

ExternalProject_Add(intel_tbb URL https://github.com/01org/tbb/releases/download/2017_U7/tbb2017_20170604oss_win.zip
					PREFIX "tbb"
					BUILD_COMMAND ""
					CONFIGURE_COMMAND ""
					INSTALL_COMMAND ""
					)