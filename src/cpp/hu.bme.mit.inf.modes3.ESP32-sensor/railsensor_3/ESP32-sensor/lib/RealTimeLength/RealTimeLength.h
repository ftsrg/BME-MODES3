#ifndef REALTIMELENGTH_H_INCLUDED
#define REALTIMELENGTH_H_INCLUDED

#ifndef SENSOR_DISTANCE
#define SENSOR_DISTANCE 3.178
#endif

class RealTimeLength{
private:
	int sindex;                                     //processed data index
	double* sstack[2];                              //infra sensor datastack pointers
	int* ssindex[2];                                //infra sensor datastack index pointers
	double difference;                              //infra sensor distance
	double lastLength;                              //last calculated length
public:
	RealTimeLength(int*, double*, int*, double*);   //RTL constructor
	//bool Update();                                //calculating length if available
	bool Update(int,int);                           //calculating length if available
	double GetLastLength();                         //getting last calculated length
	bool Reset();                                   //resetting calculation
};

#endif // REALTIMESPEED_HPP_INCLUDED
