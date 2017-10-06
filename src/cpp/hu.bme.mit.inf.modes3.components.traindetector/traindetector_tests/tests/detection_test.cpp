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
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
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
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
    ASSERT_EQ(detections[1].state, DetectionState::COMPL_STR);
}

//TEST(DetectionTest, RevStrtLocomotive) {
//    TrainDetector detector;
//
//    // Invalid train movement, moving in reverse after
//    // covering both sensors
//    // Should not detect, but detections after should
//    // be valid
//    detector.handleEdge(RIGHT, RISING);  // 1
//    detector.handleEdge(LEFT, RISING);   // 1
//    detector.handleEdge(LEFT, FALLING);  // 1
//    detector.handleEdge(RIGHT, FALLING); // 1
//    // Corrent train movement, should be detected
//    detector.handleEdge(LEFT, RISING);   // 2
//    detector.handleEdge(RIGHT, RISING);  // 2
//    detector.handleEdge(LEFT, FALLING);  // 2
//    detector.handleEdge(RIGHT, FALLING); // 2
//
//    auto detections = detector.getDetections();
//    ASSERT_EQ(detections.size(), 2);
//    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
//    ASSERT_EQ(detections[1].state, DetectionState::COMPL_REV);
//}

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
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
    ASSERT_EQ(detections[1].state, DetectionState::COMPL_STR);
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
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);

    detector.handleEdge(LEFT, RISING);   // 2
    detector.handleEdge(RIGHT, FALLING); // 2
    detector.handleEdge(RIGHT, RISING);  // 3
    detector.handleEdge(LEFT, FALLING);  // 2
    // Train two should be completed by now
    detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 3);
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
    ASSERT_EQ(detections[1].state, DetectionState::COMPL_STR);

    detector.handleEdge(LEFT, RISING);   // 3
    detector.handleEdge(RIGHT, FALLING); // 3
    detector.handleEdge(LEFT, FALLING);  // 3
    // Train three should be completed by now
    detections = detector.getDetections();
    ASSERT_EQ(detections.size(), 3);
    ASSERT_EQ(detections[0].state, DetectionState::COMPL_STR);
    ASSERT_EQ(detections[1].state, DetectionState::COMPL_STR);
    ASSERT_EQ(detections[2].state, DetectionState::COMPL_STR);
}