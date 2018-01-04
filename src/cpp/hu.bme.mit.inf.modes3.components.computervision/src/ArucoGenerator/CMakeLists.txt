cmake_minimum_required(VERSION 3.7)

SET(PROJECT_NAME ArucoGenerator)
project(${PROJECT_NAME})

file(GLOB SOURCES ${CMAKE_SOURCE_DIR}/ArucoGenerator/src/*.cpp)

add_executable(${PROJECT_NAME} ${SOURCES})

SET(DEBUG_LIBS opencv_core320d opencv_highgui320d opencv_calib3d320d opencv_videoio320d opencv_imgproc320d opencv_aruco320d )
SET(RELEASE_LIBS opencv_imgcodecs320 opencv_core320 opencv_highgui320 opencv_calib3d320 opencv_videoio320 opencv_imgproc320 opencv_aruco320 libboost_program_options-vc140-mt-1_63)

foreach (_dlib ${DEBUG_LIBS})

	target_link_libraries(${PROJECT_NAME} debug ${_dlib})
endforeach()

foreach (_rlib ${RELEASE_LIBS})
MESSAGE( STATUS "LIB: " ${_rlib} )
	target_link_libraries(${PROJECT_NAME} optimized ${_rlib})
endforeach()