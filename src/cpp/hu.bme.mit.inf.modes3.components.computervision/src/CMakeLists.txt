cmake_minimum_required(VERSION 3.5)
SET(PROJECT_NAME ComputerVisionFrameWork)
project(${PROJECT_NAME})

option(BUILD_APPLICATION "Build a sample application" OFF)
option(BUILD_STEREOCALIBRATE "Build stereo calibrator application" OFF)
option(BUILD_ARUCO_GENERATOR "Build Aruco marker generator application" OFF)
option(BUILD_MONOCALIBRATE "Build mono camera calibrator application" OFF)

set(INCLUDE_DIR ${USER_HOME}/include CACHE PATH "Directory that contains all include files")
set(LIBRARY_DIR ${USER_HOME}/lib CACHE PATH "Directory that contains all library files")

set(OPENCV_INCLUDE "" CACHE PATH "OpenCV include directory")
set(BOOST_INCLUDE "" CACHE PATH "Boost include directory")
set(ZEROMQ_INCLUDE "" CACHE PATH "ZeroMQ include directory")
set(MQTT_INCLUDE "" CACHE PATH "MQTT include directory")
set(TBB_INCLUDE "" CACHE PATH "Intel Threading Building Blocks include directory")
set(PROTOBUF_INCLUDE "" CACHE PATH "Protobuf include directory")

set(OPENCV_LIB "" CACHE PATH "OpenCV library directory")
set(BOOST_LIB "" CACHE PATH "Boost library directory")
set(ZEROMQ_LIB "" CACHE PATH "ZeroMQ library directory")
set(MQTT_LIB "" CACHE PATH "MQTT library directory")
set(TBB_LIB "" CACHE PATH "Intel Threading Building Blocks library directory")
set(PROTOBUF_LIB "" CACHE PATH "Protobuf library directory")


SET(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++14")

include_directories(${CMAKE_SOURCE_DIR}/ComputerVision/include)
include_directories(${CMAKE_SOURCE_DIR}/ComputerVision/src)
include_directories(${CMAKE_SOURCE_DIR}/ComputerVision/include/core/data/proto)
include_directories(${CMAKE_SOURCE_DIR}/external/cppcodec)
#include_directories(${CMAKE_BINARY_DIR}/external/tbb/tbb/src/intel_tbb/include)

#include_directories(${CMAKE_BINARY_DIR}/external/build/include)

#link_directories(${CMAKE_BINARY_DIR}/external/build/x86/vc14/lib)
#link_directories(${CMAKE_BINARY_DIR}/external/build/lib)
#link_directories(${CMAKE_BINARY_DIR}/external/tbb/tbb/src/intel_tbb/lib/ia32/vc14)

if(INCLUDE_DIR)
	include_directories(${INCLUDE_DIR})
endif(INCLUDE_DIR)

if(OPENCV_INCLUDE)
	include_directories(${OPENCV_INCLUDE})
endif(OPENCV_INCLUDE)

if(BOOST_INCLUDE)
	include_directories(${BOOST_INCLUDE})
endif(BOOST_INCLUDE)

if(TBB_INCLUDE)
	include_directories(${TBB_INCLUDE})
endif(TBB_INCLUDE)

if(ZEROMQ_INCLUDE)
	include_directories(${ZEROMQ_INCLUDE})
endif(ZEROMQ_INCLUDE)

if(PROTOBUF_INCLUDE)
	include_directories(${PROTOBUF_INCLUDE})
endif(PROTOBUF_INCLUDE)

if(MQTT_INCLUDE)
	include_directories(${MQTT_INCLUDE})
endif(MQTT_INCLUDE)

if(LIBRARY_DIR)
	link_directories(${LIBRARY_DIR})
endif(LIBRARY_DIR)

if(OPENCV_LIB)
	link_directories(${OPENCV_LIB})
endif(OPENCV_LIB)

if(BOOST_LIB)
	link_directories(${BOOST_LIB})
endif(BOOST_LIB)

if(TBB_LIB)
	link_directories(${TBB_LIB})
endif(TBB_LIB)

if(ZEROMQ_LIB)
	link_directories(${ZEROMQ_LIB})
endif(ZEROMQ_LIB)

if(MQTT_LIB)
	link_directories(${MQTT_LIB})
endif(MQTT_LIB)

if(PROTOBUF_LIB)
	link_directories(${PROTOBUF_LIB})
endif(PROTOBUF_LIB)

add_subdirectory(ComputerVision)

#add_subdirectory(external/opencv)
#add_subdirectory(external/protobuf)
#add_subdirectory(external/tbb)

#add_dependencies(ComputerVision opencv)
#add_dependencies(ComputerVision intel_tbb)
#add_dependencies(ComputerVision protobuf)



if(BUILD_MONOCALIBRATE)
add_subdirectory(MonoCalibrate)
endif (BUILD_MONOCALIBRATE)

if(BUILD_APPLICATION)
add_subdirectory(Application)
add_dependencies(Application ComputerVision)
endif(BUILD_APPLICATION)

if(BUILD_STEREOCALIBRATE)
add_subdirectory(StereoCalibrate)
endif(BUILD_STEREOCALIBRATE)

if(BUILD_ARUCO_GENERATOR)
add_subdirectory(ArucoGenerator)
endif(BUILD_ARUCO_GENERATOR)

