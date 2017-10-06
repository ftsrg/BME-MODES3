#include <gtest/gtest.h>
#include <traindetector.h>

TEST(DistanceTest, SingleLocomotiveMeasurement) {
    TrainDetector detector;

    detector.handleEdge(RIGHT, RISING, 0); // 1
    detector.handleEdge(LEFT, RISING); // 1
    detector.handleEdge(RIGHT, FALLING); // 2
    detector.handleEdge(LEFT, FALLING, 100); // 2

    auto detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 1);
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
}