#include "realtimespeed.hpp"

RealTimeSpeed::RealTimeSpeed(int *aStackIndex, double *aStack, int *bStackIndex, double *bStack)
{
	stackIndex = 0;
	lastSpeed = 0.0;
	difference = SENSOR_DISTANCE;
	sensorStack[0] = aStack;
	sensorStack[1] = bStack;
	sensorStackIndex[0] = aStackIndex;
	sensorStackIndex[1] = bStackIndex;
}
bool RealTimeSpeed::Update()
{
	if ((stackIndex < *sensorStackIndex[0]) && (stackIndex < *sensorStackIndex[1]))
	{
		double deltatime = sensorStack[0][stackIndex] - sensorStack[1][stackIndex];
		deltatime < 0 ? deltatime = -deltatime : deltatime;
		lastSpeed = difference / deltatime;
		stackIndex++;
		return true;
	}
	return false;
}
double RealTimeSpeed::GetLastSpeed()
{
	return lastSpeed;
}
bool RealTimeSpeed::Reset()
{
	stackIndex = 0;
	return true;
}
