cmake_minimum_required(VERSION 3.7)
SET(PROJECT_NAME StereoCalibrate)
project(${PROJECT_NAME})

file(GLOB MAIN_SOURCES ${CMAKE_SOURCE_DIR}/StereoCalibrate/src/*.cpp)

add_executable(${PROJECT_NAME} ${MAIN_SOURCES})

target_link_libraries(${PROJECT_NAME} opencv_core310 opencv_videoio310 opencv_calib3d310 xiapi32 opencv_imgproc310 opencv_highgui310)