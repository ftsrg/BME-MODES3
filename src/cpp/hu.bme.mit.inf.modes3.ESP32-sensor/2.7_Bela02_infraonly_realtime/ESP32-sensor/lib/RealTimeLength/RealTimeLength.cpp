#include "RealTimeLength.h"
#include <iostream>
using namespace std;

RealTimeLength::RealTimeLength(int* Asindex, double* Astack, int* Bsindex, double* Bstack){
    sindex=0;                       //temporary stackindex reset
	lastLength=0.0;                 //last measure reset
	difference=SENSOR_DISTANCE;     //set infra sensor distance
	sstack[0]=Astack;               //set pointer to A infra's datastack
	sstack[1]=Bstack;               //set pointer to B infra's datastack
	ssindex[0]=Asindex;             //set pointer to A infra's stackindex
	ssindex[1]=Bsindex;             //set pointer to B infra's stackindex
}
bool RealTimeLength::Update(){
	if((sindex+1<*ssindex[0])&&(sindex+1<*ssindex[1])){         //if new data pair available
		double intime=sstack[0][sindex]-sstack[1][sindex];      //income time delay
		double outtime=sstack[0][sindex+1]-sstack[1][sindex+1]; //outcome time delay
		intime<0 ? intime=-intime : intime;                     //calculating abs()
		outtime<0 ? outtime=-outtime : outtime;                 //calculating abs()
		double avgSpeed=difference*2/(intime+outtime);          //calculating average speed
		lastLength=(sstack[0][sindex+1]+sstack[1][sindex+1]-
                    sstack[0][sindex]-sstack[1][sindex])
                    /2*avgSpeed;                              //calculating wagon length
		sindex+=2;                                              //increment the index of processed data
		return true;                                            //return with "new length available"
	}
	return false;                                               //return with "no new length"
}
bool RealTimeLength::Update(int Asindex, int Bsindex){
	if((sindex+1<Asindex)&&(sindex+1<Bsindex)){         //if new data pair available
		double intime=sstack[0][sindex]-sstack[1][sindex];      //income time delay
		double outtime=sstack[0][sindex+1]-sstack[1][sindex+1]; //outcome time delay
		intime<0 ? intime=-intime : intime;                     //calculating abs()
		outtime<0 ? outtime=-outtime : outtime;                 //calculating abs()
		double avgSpeed=difference*2/(intime+outtime);          //calculating average speed
		lastLength=(sstack[0][sindex+1]+sstack[1][sindex+1]-
                    sstack[0][sindex]-sstack[1][sindex])
                    /2*avgSpeed;                              //calculating wagon length
		sindex+=2;                                              //increment the index of processed data
		return true;                                            //return with "new length available"
	}
	return false;                                               //return with "no new length"
}
double RealTimeLength::GetLastLength(){
	return lastLength;                                          //return with lastLength
}
bool RealTimeLength::Reset(){
	sindex=0;                                                   //reset the processed data index
	return true;
}

