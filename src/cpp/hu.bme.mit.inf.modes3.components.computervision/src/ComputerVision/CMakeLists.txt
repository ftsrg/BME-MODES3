cmake_minimum_required(VERSION 3.5)

SET(PROJECT_NAME ComputerVision)
project(${PROJECT_NAME})

file(GLOB_RECURSE SOURCES ${CMAKE_SOURCE_DIR}/ComputerVision/src/*)

add_library(${PROJECT_NAME} STATIC ${SOURCES})

