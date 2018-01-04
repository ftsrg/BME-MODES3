cmake_minimum_required(VERSION 3.7)

include(ExternalProject)

ExternalProject_Add(protobuf GIT_REPOSITORY "https://github.com/google/protobuf.git"
					PREFIX "protobuf"
					#SOURCE_DIR ${CMAKE_BINARY_DIR}/external/protobuf/protobuf/src/protobuf
					SOURCE_SUBDIR cmake
					CMAKE_ARGS -Dprotobuf_BUILD_TESTS=OFF 
					-DCMAKE_INSTALL_PREFIX=${CMAKE_BINARY_DIR}/external/build
					-Dprotobuf_MSVC_STATIC_RUNTIME=OFF
					#${CMAKE_BINARY_DIR}/external/protobuf/protobuf/src/protobuf/cmake
					#INSTALL_DIR ${CMAKE_BINARY_DIR}/external/build
					)