project(traindetector)

set(HEADER_FILES
        traindetection.h
        traindetector.h)

set(SOURCE_FILES
        traindetection.cpp
        traindetector.cpp)

add_library(traindetector STATIC ${SOURCE_FILES} ${HEADER_FILES})