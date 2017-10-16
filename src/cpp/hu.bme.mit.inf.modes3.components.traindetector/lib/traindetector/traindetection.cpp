#include "traindetection.h"

using namespace td;

void TrainDetection::computeSpeed(time_t coverTimestamp) {
    time_t diff = coverTimestamp - this->startTimestamp;
    if (diff > 0) {
        this->speed = SENSOR_DISTANCE_MM / diff;
    } else {
        this->speed = std::numeric_limits<double>::infinity();
    }
}

void TrainDetection::computeLength(time_t departionTimestamp) {
    //this->length = this->speed * ()
}

bool TrainDetection::step(SensorSide side, EdgeDirection dir, time_t timestamp) {
    bool stepped = false;
    switch (this->state) {
        case C:
            if (side != this->side && dir == RISING) {
                this->state = CO;
                this->computeSpeed(timestamp);
                stepped = true;
                break;
            }
            break;
        case CO:
            if (side == this->side && dir == FALLING) {
                this->state = O;
                this->computeLength(timestamp);
                stepped = true;
                break;
            }
            break;
        case O:
            if (side != this->side && dir == FALLING) {
                this->state = COMPL;
                stepped = true;
                break;
            }
            break;
        default:
            break;
    }
    return stepped;
}

int TrainDetection::getId() const {
    return id;
}

SensorSide TrainDetection::getSide() const {
    return side;
}

DetectionState TrainDetection::getState() const {
    return state;
}

double TrainDetection::getSpeed() const {
    return speed;
}

double TrainDetection::getLength() const {
    return length;
}

namespace td {
    std::ostream &operator<<(std::ostream &stream, const TrainDetection &td) {
        static auto stateToString = [](DetectionState state) {
            switch (state) {
                case C:
                    return "Coming";
                case CO:
                    return "Coming/Outbound";
                case O:
                    return "Outbound";
                case COMPL:
                    return "Departed";
                default:
                    return "Undefined";
            }
        };

        stream << td.id;
        stream << " " << stateToString(td.state);
        stream << ", start: " << td.startTimestamp << ", speed: " << td.speed << ", length: " << td.length;
        return stream;
    }
}
