cmake_minimum_required(VERSION 3.7)
SET(PROJECT_NAME MonoCalibrate)
project(${PROJECT_NAME})

file(GLOB MAIN_SOURCES ${CMAKE_SOURCE_DIR}/MonoCalibrate/src/*.cpp)

add_executable(${PROJECT_NAME} ${MAIN_SOURCES})

target_link_libraries(${PROJECT_NAME} opencv_core320 opencv_videoio320 opencv_calib3d320 opencv_imgproc320 opencv_highgui320)