#include <gtest/gtest.h>
#include <traindetector.h>

TEST(DetectionTest, RegularLocomotive) {
    TrainDetector detector;

    detector.handleEdge(RIGHT, RISING); // 1
    detector.handleEdge(LEFT, RISING); // 1
    detector.handleEdge(RIGHT, FALLING); // 2
    detector.handleEdge(LEFT, FALLING); // 2

    auto detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 1);
    ASSERT_EQ(detections[0].getState(), DetectionState::COMPL);
}

TEST(DetectionTest, DoubleLocomotive) {
    TrainDetector detector;

    detector.handleEdge(RIGHT, RISING);  // 1
    detector.handleEdge(LEFT, RISING);  // 1
    detector.handleEdge(RIGHT, RISING);  // 2
    detector.handleEdge(LEFT, RISING);  // 2
    detector.handleEdge(RIGHT, FALLING); // 1
    detector.handleEdge(LEFT, FALLING); // 1
    detector.handleEdge(RIGHT, FALLING); // 2
    detector.handleEdge(LEFT, FALLING); // 2

    auto detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 2);
    ASSERT_EQ(detections[0].getState(), DetectionState::COMPL);
    ASSERT_EQ(detections[1].getState(), DetectionState::COMPL);
}

TEST(DetectionTest, TrainWithTwoCars) {
    TrainDetector detector;

    detector.handleEdge(RIGHT, RISING);  // 1
    detector.handleEdge(LEFT, RISING);   // 1
    detector.handleEdge(RIGHT, FALLING); // 1
    detector.handleEdge(RIGHT, RISING);  // 2
    detector.handleEdge(LEFT, FALLING);  // 1
    detector.handleEdge(LEFT, RISING);   // 2
    detector.handleEdge(RIGHT, FALLING); // 2
    detector.handleEdge(LEFT, FALLING);  // 2

    auto detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 2);
    ASSERT_EQ(detections[0].getState(), DetectionState::COMPL);
    ASSERT_EQ(detections[1].getState(), DetectionState::COMPL);
}


TEST(DetectionTest, TrainWithThreeCars) {
    TrainDetector detector;
    std::vector<TrainDetection> detections;

    detector.handleEdge(RIGHT, RISING);  // 1
    detector.handleEdge(LEFT, RISING);   // 1
    detector.handleEdge(RIGHT, FALLING); // 1
    detector.handleEdge(RIGHT, RISING);  // 2
    detector.handleEdge(LEFT, FALLING);  // 1
    // Train one should be completed by now
    detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 2);
    ASSERT_EQ(detections[0].getState(), DetectionState::COMPL);

    detector.handleEdge(LEFT, RISING);   // 2
    detector.handleEdge(RIGHT, FALLING); // 2
    detector.handleEdge(RIGHT, RISING);  // 3
    detector.handleEdge(LEFT, FALLING);  // 2
    // Train two should be completed by now
    detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 3);
    ASSERT_EQ(detections[0].getState(), DetectionState::COMPL);
    ASSERT_EQ(detections[1].getState(), DetectionState::COMPL);

    detector.handleEdge(LEFT, RISING);   // 3
    detector.handleEdge(RIGHT, FALLING); // 3
    detector.handleEdge(LEFT, FALLING);  // 3
    // Train three should be completed by now
    detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 3);
    ASSERT_EQ(detections[0].getState(), DetectionState::COMPL);
    ASSERT_EQ(detections[1].getState(), DetectionState::COMPL);
    ASSERT_EQ(detections[2].getState(), DetectionState::COMPL);
}