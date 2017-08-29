#!/bin/sh

# first, delete build folder is there is any
echo "deleting previous build folder"
rm -rf build

echo "deleting previous protobuf gen folder"
rm -rf GoogleProtocolBuffers
mkdir GoogleProtocolBuffers

# cd back to the folder of BME-MODES3/src
cd ../../
pwd

# generate protoc files
protoc --proto_path=java/messaging/hu.bme.mit.inf.modes3.messaging.proto/src/main/proto --cpp_out=cpp/hu.bme.mit.inf.modes3.components.xpressnetbridge/GoogleProtocolBuffers/ java/messaging/hu.bme.mit.inf.modes3.messaging.proto/src/main/proto/*

# go back to xpressnetbridge folder
cd ./cpp/hu.bme.mit.inf.modes3.components.xpressnetbridge

# build xpressnetbridge itself
#mkdir build
#cd build
#cmake ../
#make -j2

