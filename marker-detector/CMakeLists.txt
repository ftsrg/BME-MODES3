cmake_minimum_required(VERSION 3.0)
project(marker-detector)

add_definitions(-std=c++11)

set(CMAKE_BUILD_TYPE "Debug" ON CACHE STRING "Build type")
set(ENABLE_GPU OFF CACHE BOOL "Enable CUDA")
set(ENABLE_MQTT ON CACHE BOOL "Enable MQTT communication")
set(ENABLE_BENCHMARK OFF CACHE BOOL "Enable benchmarking, no board detection")

include_directories("src/")
file(GLOB SOURCES "src/*.cpp")
add_executable(marker-detector ${SOURCES})

if (${ENABLE_GPU})
	message(STATUS "GPU enabled, adding CUDA sources")
	add_definitions(-DENABLE_GPU)
else (${ENABLE_GPU})
	message(STATUS "GPU disabled, adding CPU sources")
endif (${ENABLE_GPU})

if (${ENABLE_MQTT})
	message(STATUS "MQTT communication enabled")
	add_definitions(-DENABLE_MQTT)
else (${ENABLE_MQTT})
	message(STATUS "MQTT communication disabled")
endif (${ENABLE_MQTT})

if (${ENABLE_BENCHMARK})
	message(STATUS "Benchmarking enabled")
	add_definitions(-DENABLE_BENCHMARK)
endif (${ENABLE_BENCHMARK})

target_link_libraries(marker-detector tbb pthread)
target_link_libraries(marker-detector mosquitto mosquittopp)
target_link_libraries(marker-detector opencv_core opencv_highgui opencv_imgcodecs opencv_imgproc opencv_videoio)
if (${ENABLE_GPU})
	target_link_libraries(marker-detector opencv_cudaarithm)
endif (${ENABLE_GPU})
