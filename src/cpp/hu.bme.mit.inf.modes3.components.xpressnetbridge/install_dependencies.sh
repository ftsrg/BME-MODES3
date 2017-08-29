#!/bin/sh

# ?? libmosquittopp1
sudo apt-get update
sudo apt-get install git cmake autoconf automake libtool curl make g++ unzip libboost-all-dev mosquitto libmosquitto-dev libmosquittopp-dev

git clone https://github.com/google/protobuf.git
cd protobuf

./autogen.sh
./configure
make check
sudo make install
sudo ldconfig # refresh shared library cache.
