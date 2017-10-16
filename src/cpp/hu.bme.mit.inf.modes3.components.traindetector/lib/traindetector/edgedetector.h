#pragma once

#include "enums.h"

namespace td {
    class EdgeDetector {
    protected:
        SignalLevel previousLevel;
    public:
        EdgeDirection detectEdge(SignalLevel currentSignal);
    };
};