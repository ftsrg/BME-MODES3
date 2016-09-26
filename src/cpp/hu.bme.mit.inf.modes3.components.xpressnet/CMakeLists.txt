cmake_minimum_required(VERSION 2.8.11)

project(XpressController-codelite)



include_directories(
    /home/pi/Xpress/XpressController-codelite/
    /home/pi/Xpress/XpressController-codelite/
    /usr/include/boost/

)

# Linker options
set(CMAKE_LDFLAGS "${CMAKE_LDFLAGS}  -O0 -lboost_system -lboost_thread -lpthread -lmosquittopp -lmosquitto `pkg-config --libs protobuf`")

# Library path
set(CMAKE_LDFLAGS "${CMAKE_LDFLAGS} -L\".\" -L\".\" -L\"Debug\" -L\"/usr/lib/arm-linux-gnueabihf\" ")

# Define the CXX sources
set ( CXX_SRCS
    main.cpp
    XpressNetSerial/AsyncSerial.cpp
    XpressNetSerial/Connection.cpp
    XpressNetSerial/OldMain.cpp
    XpressNetSerial/IncomingByteBuffer.cpp
    XpressNetSerial/IncomingXPNMessage.cpp
    XpressNetSerial/AccessoryDecoderInformationResponse.cpp
    XpressNetSerial/TrackPowerStatus.cpp
    XpressNetSerial/AccessoryDecoderInformationResponse_LNN.cpp
    XpressNetSerial/LocomotiveInformation.cpp
    XpressNetSerial/LocomotiveControlTaken.cpp
)

set_source_files_properties(
    ${CXX_SRCS} PROPERTIES COMPILE_FLAGS 
    " -g -Wall -std=c++11 `pkg-config --cflags protobuf`")

add_executable(XpressController-codelite ${CXX_SRCS} ${C_SRCS})

