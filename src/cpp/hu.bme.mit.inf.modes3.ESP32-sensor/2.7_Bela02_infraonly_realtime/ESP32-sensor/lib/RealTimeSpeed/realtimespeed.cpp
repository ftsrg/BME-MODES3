#include "realtimespeed.hpp"

RealTimeSpeed::RealTimeSpeed(int* Asindex, double* Astack, int* Bsindex, double* Bstack){
    sindex=0;
	lastspeed=0.0;
	difference=SENSOR_DISTANCE;
	sstack[0]=Astack;
	sstack[1]=Bstack;
	ssindex[0]=Asindex;
	ssindex[1]=Bsindex;
}
bool RealTimeSpeed::Update(){
	if((sindex<*ssindex[0])&&(sindex<*ssindex[1])){
		double deltatime=sstack[0][sindex]-sstack[1][sindex];
		deltatime<0 ? deltatime=-deltatime : deltatime;
		lastspeed=difference/deltatime;
		sindex++;
		return true;
	}
	return false;
}
double RealTimeSpeed::GetLastSpeed(){
	return lastspeed;
}
bool RealTimeSpeed::Reset(){
	sindex=0;
	return true;
}
