#!/bin/sh

# ?? libmosquittopp1
sudo apt-get update
sudo apt-get install git cmake autoconf automake libtool curl make g++ unzip libboost-all-dev libmosquittopp-dev

git clone https://github.com/google/protobuf.git
cd protobuf

./autogen.sh
./configure
make check
sudo make install
sudo ldconfig # refresh shared library cache.

# cd back to the folder of BME-MODES3/src
cd ../../../

# generate protoc files
protoc --proto_path=java/messaging/hu.bme.mit.inf.modes3.messaging.proto/src/main/proto --cpp_out=cpp/hu.bme.mit.inf.modes3.components.xpressnetbridge/GoogleProtocolBuffers/ java/messaging/hu.bme.mit.inf.modes3.messaging.proto/src/main/proto/*

# go back to xpressnetbridge folder
cd ./cpp/hu.bme.mit.inf.modes3.components.xpressnetbridge

# build xpressnetbridge itself
mkdir build
cd build
cmake ../
make -j4

