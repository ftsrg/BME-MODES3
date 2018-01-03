#ifndef LOGGER_H_
#define LOGGER_H_
#include <string>
#include <iostream>
#include <fstream>
#include <ctime>
#include <chrono>

enum Severity{
	LOG,
	WARNING,
	CRITICAL
};

class LOGGER {
public:
	static void LOG(Severity severity, std::string source, std::string message) {
		auto currentTime = std::chrono::system_clock::now();
		auto t = std::chrono::system_clock::to_time_t(currentTime);
		auto date = std::ctime(&t);
		
		std::cout << date;
		
		switch (severity) {
		case Severity::LOG:	
			std::cout << " LOG: ";
			break;
		case Severity::WARNING:
			std::cout << " WARNING: ";
			break;
		case Severity::CRITICAL:
			std::cout << " ERROR: ";
			break;
		}
		std::cout << message;
		std::cout << " SOURCE: " << source << std::endl << std::endl;
	}
};
#endif // !LOGGER_H_
