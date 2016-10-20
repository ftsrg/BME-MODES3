//
// Created by Hegyi Bálint on 20/06/16.
//

#include "SerialConnection.h"

SerialConnection::SerialConnection()
    : io()
    , serial(io, "/dev/ttyACM0")
{
    using boost::asio::serial_port_base;

    serial.set_option(serial_port_base::baud_rate(9600));
    serial.set_option(serial_port_base::character_size(8));
    serial.set_option(serial_port_base::parity(serial_port_base::parity::none));
    serial.set_option(serial_port_base::stop_bits(serial_port_base::stop_bits::one));
}

void SerialConnection::sendCommand(std::vector<uint8_t> commandBytes)
{
    // auto data = command.getData();

    uint8_t xOrByte = 0x00;
    std::cout << "Sending data" << std::endl;
    std::cout << "++++++++++++" << std::endl;

    for(uint8_t commandByte : commandBytes) {
        xOrByte ^= commandByte;
    }
    commandBytes.push_back(xOrByte);

    for(uint8_t commandByte : commandBytes) {
        std::cout << "0x" << std::hex << std::setfill('0') << std::setw(2) << static_cast<int>(commandByte)
                  << std::endl;
    }
    std::cout << "============" << std::endl << std::endl;

    this->serial.write_some(boost::asio::buffer(commandBytes));
}
