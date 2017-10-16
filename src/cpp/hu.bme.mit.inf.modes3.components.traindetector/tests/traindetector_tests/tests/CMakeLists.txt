include_directories(${gtest_SOURCE_DIR}/include ${gtest_SOURCE_DIR})

add_executable(runTraindetectorTests
        detection_test.cpp
        distance_test.cpp)

target_link_libraries(runTraindetectorTests gtest gtest_main)
target_link_libraries(runTraindetectorTests traindetector)