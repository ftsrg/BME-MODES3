#ifndef REALTIMESPEED_HPP_INCLUDED
#define REALTIMESPEED_HPP_INCLUDED

#ifndef SENSOR_DISTANCE
#define SENSOR_DISTANCE 3.178
#endif

#define DEBUG

class RealTimeSpeed{
private:
	int sindex;                                     //processed data index
	double* sstack[2];                              //infra sensor datastack pointers
	int* ssindex[2];                                //infra sensor datastack index pointers
	double difference;                              //infra sensor distance
	double lastspeed;                               //last calculated speed
public:
	RealTimeSpeed(int*, double*, int*, double*);    //RTS Constructor
	bool Update();                                  //calculating speed if available
	double GetLastSpeed();                          //getting last calculated speed
	bool Reset();                                   //resetting calculation
};

#endif // REALTIMESPEED_HPP_INCLUDED
