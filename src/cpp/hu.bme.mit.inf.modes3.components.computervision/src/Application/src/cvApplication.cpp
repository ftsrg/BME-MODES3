//============================================================================
// Name        : cvApplication.cpp
// Author      : Fuzesi MAte
// Version     :
// Copyright   : Your copyright notice
// Description : Computer Vision framework usage example in C++, Ansi-style
//============================================================================

#include <iostream>
#include "core/ComputerVision.h"
#include <iostream>
#include <fstream>
#include <tbb/compat/thread>
#include <tbb/tbb.h>

using namespace std;

void help() {
	std::cout << "Computer Vision application" << std::endl<<std::endl;
	std::cout << "s - Initialize computer vision module and start processing"<<std::endl;
	std::cout << "r - Reconfigure computer vision module" << std::endl;
	std::cout << "x - Stop processing" << std::endl;
	std::cout << "q - Quit application" << std::endl<<std::endl;
}

int main(int argc , char *argv[]) {
std::cout<<"retek"<<std::endl;

	if (argc < 2) {
		std::cout << "No command line argument! Please provide the path to the configuration file!" << std::endl;
		return -1;
	}

	ComputerVision cvModule;

	std::ofstream out;

	char c='a';

	help();

	
	while(c!='q'){
		cin>>c;
		switch(c){
		case 's':
		{
			if (cvModule.initialize(argv[1])) {
				tbb::tbb_thread processingThread(std::bind(&ComputerVision::startProcessing, &cvModule));
				processingThread.detach();
			}
			break;
		}
		case 'x':
			cvModule.stopProcessing();
			break;
		case 'r':
			cvModule.reconfigure(argv[1]);
			break;
		case 'g':
		{
				ModelData posdata;
				if (cvModule.getData(posdata)) {
					out.open("ex.json");
					out<<posdata.toJSON();
					out.close();
				}
				
			break;
		}
		default:
			cout<<"invalid"<<endl;
			break;
		}
	}

	return 0;
}
