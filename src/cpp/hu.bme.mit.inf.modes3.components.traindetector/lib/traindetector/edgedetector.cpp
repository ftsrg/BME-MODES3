#include "edgedetector.h"

using namespace td;

EdgeDirection EdgeDetector::detectEdge(SignalLevel currentLevel) {
    EdgeDirection ret = NOEDGE;
    if (this->previousLevel == HIGH && currentLevel == LOW) {
        ret = FALLING;
    } else if (this->previousLevel == LOW && currentLevel == HIGH) {
        ret = RISING;
    }
    previousLevel = currentLevel;
    return ret;
}