cmake_minimum_required(VERSION 3.5)
SET(PROJECT_NAME Application)
project(${PROJECT_NAME})

file(GLOB MAIN_SOURCES ${CMAKE_SOURCE_DIR}/Application/src/*.cpp)

add_executable(${PROJECT_NAME} ${MAIN_SOURCES})

if(UNIX)
SET(CV_DEBUG "${CMAKE_BINARY_DIR}/ComputerVision/libComputerVision.a")
SET(CV_RELEASE "${CMAKE_BINARY_DIR}/ComputerVision/libComputerVision.a")
endif(UNIX)

if(WIN32)
SET(CV_DEBUG "${CMAKE_BINARY_DIR}/ComputerVision/Debug/ComputerVision.lib")
SET(CV_RELEASE "${CMAKE_BINARY_DIR}/ComputerVision/Release/ComputerVision.lib")
endif(WIN32)

target_link_libraries(${PROJECT_NAME} debug ${CV_DEBUG})
target_link_libraries(${PROJECT_NAME} optimized ${CV_RELEASE})

find_package(Protobuf REQUIRED)

if(WIN32)
	SET(DEBUG_LIBS opencv_core320d opencv_highgui320d opencv_calib3d320d opencv_videoio320d opencv_imgproc320d
	opencv_aruco320d tbb_debug tbbmalloc_debug tbbmalloc_proxy_debug libzmq_debug libprotobuf)

	SET(RELEASE_LIBS opencv_imgcodecs320 opencv_core320 opencv_highgui320 opencv_calib3d320 opencv_videoio320 
	opencv_imgproc320 opencv_aruco320 tbb tbbmalloc tbbmalloc_proxy libzmq paho-mqtt3c libprotobuf)
endif (WIN32)

if(UNIX)
	SET(DEBUG_LIBS opencv_core opencv_highgui opencv_calib3d opencv_videoio opencv_imgproc
	opencv_aruco tbb tbbmalloc tbbmalloc_proxy zmq ${PROTOBUF_LIBRARY} paho-mqtt3c png)

	SET(RELEASE_LIBS opencv_imgcodecs opencv_core opencv_highgui opencv_calib3d opencv_videoio 
	opencv_imgproc opencv_aruco tbb tbbmalloc tbbmalloc_proxy zmq paho-mqtt3c  ${PROTOBUF_LIBRARY} png)
endif (UNIX)

foreach (_dlib ${DEBUG_LIBS})
	target_link_libraries(${PROJECT_NAME} debug ${_dlib})
endforeach()

foreach (_rlib ${RELEASE_LIBS})
#MESSAGE( STATUS "LIB: " ${_rlib} )
	target_link_libraries(${PROJECT_NAME} optimized ${_rlib})
endforeach()
