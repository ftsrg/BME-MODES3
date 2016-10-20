cmake_minimum_required(VERSION 3.0.2)

project(xpressnetbridge)

SET(CMAKE_MODULE_PATH "${PROJECT_SOURCE_DIR}/cmake_modules" ${CMAKE_MODULE_PATH})
set(BOOST_LIBRARYDIR "/usr/lib/x86_64-linux-gnu/")
set(CMAKE_INCLUDE_CURRENT_DIR ON)
#set(CMAKE_AUTORCC ON) # resource compiler

include(CheckCXXCompilerFlag)
CHECK_CXX_COMPILER_FLAG("-std=c++11" COMPILER_SUPPORTS_CXX11)
if(COMPILER_SUPPORTS_CXX11)
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
else()
        message(STATUS "The compiler ${CMAKE_CXX_COMPILER} has no C++11 support. Please use a different C++ compiler.")
endif()


find_package(Mosquitto)
find_package(Mosquittopp)
find_package(Protobuf REQUIRED)
find_package(Boost COMPONENTS thread system REQUIRED)

include_directories(
	${MOSQUITTO_INCLUDE_DIRS}
	${MOSQUITTOPP_INCLUDE_DIRS}
	${Boost_INCLUDE_DIRS}
	${PROTOBUF_INCLUDE_DIRS}
        ${CMAKE_SOURCE_DIR}/
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/
	${CMAKE_SOURCE_DIR}/Network/
	${CMAKE_SOURCE_DIR}/XpressNetSerial/
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetInterfaces/
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/)

SET(SOURCES
	${CMAKE_SOURCE_DIR}/main.cpp
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/DccOperationsCommand.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/DccOperationsState.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/Enums.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/Message.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/SegmentCommand.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/SegmentOccupancy.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/SegmentState.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/SendAllStatus.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TrainCurrentSegment.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TrainFunctionCommand.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TrainFunctionState.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TurnoutCommand.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TurnoutReferenceState.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/TurnoutState.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/YakinduCanGoTo.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/YakinduReleaseTo.pb.cc
	${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/YakinduReserveTo.pb.cc
	${CMAKE_SOURCE_DIR}/Network/MosquittoppClient.cpp
	${CMAKE_SOURCE_DIR}/Network/NetworkInterface.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/AsyncSerial.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/BoardStatus.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/SerialConnection.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/TrackPowerStatus.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/TrainStatus.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/TurnoutStatus.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp
	${CMAKE_SOURCE_DIR}/XpressNetSerial/XpressNetSerial.cpp)

message("assd: ${Boost_LIBRARIES}")

add_executable(xpressnetbridge ${SOURCES})
target_link_libraries(
	xpressnetbridge
	${MOSQUITTO_LIBRARIES}
	${MOSQUITTOPP_LIBRARIES}
	${PROTOBUF_LIBRARIES}
	${Boost_LIBRARIES})

install(TARGETS xpressnetbridge DESTINATION .)

set(CPACK_PACKAGE_NAME "XpressNet Bridge to project MoDeS3")
set(CPACK_PACKAGE_VENDOR "Biró Attila")
set(CPACK_PACKAGE_VERSION "0.1.0")
set(CPACK_PACKAGE_VERSION_MAJOR "0")
set(CPACK_PACKAGE_VERSION_MINOR "9")
set(CPACK_PACKAGE_VERSION_PATCH "0")
set(CPACK_PACKAGE_INSTALL_DIRECTORY "XpressNet Bridge")

include(CPack)
