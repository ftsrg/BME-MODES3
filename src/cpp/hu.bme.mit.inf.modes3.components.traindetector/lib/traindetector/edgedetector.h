#pragma once

#include <iostream>
#include "enums.h"

namespace td {
    template <int T>
    class EdgeDetector {
    private:
        int buffer[T];        
    public:
        EdgeDirection detectEdge(int signalLevel){
            EdgeDirection ret = NOEDGE;
            
            long lowerAcc = 0;
            for (int i = 0; i < T/2; i++) {
                lowerAcc += this->buffer[i];
            }
            int lowerAvg = lowerAcc / (T/2);
            if (lowerAvg > 0) 
                std::cout << lowerAvg << std::endl;

            long higherAcc = 0;
            for (int i = (T/2)+1; i < T; i++) {
                higherAcc += this->buffer[i];
            }
            int higherAvg = higherAcc / (T/2);
            if (higherAvg > 0) 
                std::cout << higherAvg << std::endl;
        
            return ret;
        };
    };
};