cmake_minimum_required(VERSION 3.1)
project(TrainDetector)

set (CMAKE_CXX_STANDARD 11)

include_directories(lib/traindetector)

add_subdirectory(lib/traindetector)
add_subdirectory(tests/traindetector_tests)