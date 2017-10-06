#include "traindetection.h"

void TrainDetection::computeSpeed(time_t coverTimestamp) {
    std::cout << "FUCK SPEED" << std::endl;
}

void TrainDetection::computeLength(time_t departionTimestamp) {
    std::cout << "FUCK SPEED" << std::endl;
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
//            if (side == this->side && dir == FALLING) {
//                this->state = COMPL_REV;
//                stepped = true;
//                break;
//            }
            break;
        case CO:
//            if (side != this->side && dir == FALLING) {
//                this->state = C;
//                stepped = true;
//                break;
//            }
            if (side == this->side && dir == FALLING) {
                this->state = O;
                this->computeLength(timestamp);
                stepped = true;
                break;
            }
            break;
        case O:
//            if (side == this->side && dir == RISING) {
//                this->state = CO;
//                stepped = true;
//                break;
//            }
            if (side != this->side && dir == FALLING) {
                this->state = COMPL_STR;
                stepped = true;
                break;
            }
            break;
        default:
            break;
    }
    return stepped;
}

std::ostream &operator<<(std::ostream &stream, const TrainDetection &td) {
    static auto stateToString = [](DetectionState state) {
        switch (state) {
            case C:
                return "Coming";
            case CO:
                return "Coming/Outbound";
            case O:
                return "Outbound";
            case COMPL_STR:
            case COMPL_REV:
                return "Departed";
        }
    };

    stream << td.id;
    stream << " " << stateToString(td.state);
    stream << ", start: " << td.startTimestamp << ", speed: " << td.speed << ", length: " << td.length;
    return stream;
}