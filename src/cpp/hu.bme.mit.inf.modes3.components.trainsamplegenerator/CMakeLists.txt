cmake_minimum_required(VERSION 3.7)
SET(PROJECT_NAME TrainSampleGenerator)
project(${PROJECT_NAME})

file(GLOB SOURCES ${CMAKE_SOURCE_DIR}/src/*.cpp)

if (WIN32)
include_directories(../external/opencv_build/install/include)
link_directories("C:/Users/Mate/BME/onlab/external/opencv_build/install/x86/vc14/lib")
SET(RELEASE_LIBS opencv_imgcodecs320.lib opencv_core320.lib opencv_highgui320.lib opencv_calib3d320.lib opencv_videoio320.lib opencv_imgproc320.lib opencv_aruco320.lib opencv_video320.lib)
endif (WIN32)

if (UNIX)
SET(RELEASE_LIBS opencv_imgcodecs opencv_core opencv_highgui opencv_calib3d opencv_videoio opencv_imgproc opencv_aruco opencv_video)
endif (UNIX)

add_executable(${PROJECT_NAME} ${SOURCES})

foreach (_rlib ${RELEASE_LIBS})
	target_link_libraries(${PROJECT_NAME} optimized ${_rlib})
endforeach()

