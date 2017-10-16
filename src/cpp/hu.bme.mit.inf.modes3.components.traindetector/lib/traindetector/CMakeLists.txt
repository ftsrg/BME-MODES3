project(traindetector)

set(HEADER_FILES
        enums.h
        edgedetector.h
        traindetection.h
        traindetector.h)

set(SOURCE_FILES
        edgedetector.cpp
        traindetection.cpp
        traindetector.cpp)

add_library(traindetector STATIC ${SOURCE_FILES} ${HEADER_FILES})