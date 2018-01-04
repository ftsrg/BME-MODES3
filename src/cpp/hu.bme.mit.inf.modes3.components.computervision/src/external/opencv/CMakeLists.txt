cmake_minimum_required(VERSION 3.7)


include(ExternalProject)

ExternalProject_Add(opencv_contrib GIT_REPOSITORY "https://github.com/opencv/opencv_contrib.git"
					PREFIX "opencv_contrib"
					BUILD_COMMAND ""
					INSTALL_COMMAND ""
					CONFIGURE_COMMAND "")
ExternalProject_Add(opencv GIT_REPOSITORY "https://github.com/opencv/opencv.git"
					PREFIX "opencv"
					CMAKE_ARGS -DCMAKE_BUILD_TYPE=Release 
							   -DOPENCV_EXTRA_MODULES_PATH=${CMAKE_BINARY_DIR}/external/opencv/opencv_contrib/src/opencv_contrib/modules
							   -DCMAKE_INSTALL_PREFIX=${CMAKE_BINARY_DIR}/external/build
							   -DBUILD_opencv_dnn_modern=OFF
							   -DBUILD_opencv_java=OFF 
							   -DBUILD_opencv_python=OFF
					#INSTALL_COMMAND ""
					#BUILD_COMMAND ""
					#CONFIGURE_COMMAND ""
					)