cmake_minimum_required(VERSION 3.0.2)

project(xpressnetbridge)

set(CMAKE_MODULE_PATH "${PROJECT_SOURCE_DIR}/cmake_modules" ${CMAKE_MODULE_PATH})
set (CMAKE_CXX_FLAGS "-std=c++11 ${CMAKE_CXX_FLAGS}")

find_package(Mosquitto REQUIRED)
find_package(Mosquittopp REQUIRED)
find_package(Protobuf REQUIRED)
find_package(Boost REQUIRED thread system)

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

file(GLOB protosources ${CMAKE_SOURCE_DIR}/GoogleProtocolBuffers/*.pb.cc)
message(${protosources})

SET(SOURCES
    ${protosources}
	${CMAKE_SOURCE_DIR}/main.cpp
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

add_executable(xpressnetbridge ${SOURCES})
target_link_libraries(
	xpressnetbridge
	${MOSQUITTO_LIBRARIES}
	${MOSQUITTOPP_LIBRARIES}
	${PROTOBUF_LIBRARIES}
	${Boost_LIBRARIES}
)
