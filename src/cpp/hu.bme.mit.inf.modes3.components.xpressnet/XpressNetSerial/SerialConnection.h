//
// Created by Hegyi Bálint on 20/06/16.
//

#pragma once

#include <iostream>
#include <iomanip>
#include <chrono>
#include <thread>
#include <vector>
#include <boost/asio.hpp>

class SerialConnection
{

protected:
    boost::asio::io_service io;
    boost::asio::serial_port serial;

public:
    SerialConnection();
    void sendCommand(std::vector<uint8_t> commandBytes);
};
