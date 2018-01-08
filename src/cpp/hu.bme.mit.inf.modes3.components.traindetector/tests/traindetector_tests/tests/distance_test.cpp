#include <gtest/gtest.h>
#include <traindetector.h>

using namespace td;

TEST(DistanceTest, SingleLocomotiveMeasurement) {
    TrainDetector detector;

    detector.handleEdge(RIGHT, RISING, 0);
    detector.handleEdge(LEFT, RISING, 100);
    detector.handleEdge(RIGHT, FALLING, 200);
    detector.handleEdge(LEFT, FALLING, 300);

    auto detections = detector.getDetections();
    ASSERT_EQ(detections[0].getSpeed(), 1);
}