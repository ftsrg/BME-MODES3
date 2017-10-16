#ifndef REALTIMESELECT_HPP_INCLUDED
#define REALTIMESELECT_HPP_INCLUDED
#include <string>

class RealTimeSelect
{
  private:
    int sindex;
    double lenarray[10];
    char namearray[10][10];

  public:
    RealTimeSelect();
    bool AddTrain(char[], double);
    bool DeleteTrain(char[]);
    char *Search(double);
    void Print();
};

#endif // REALTIMESELECT_HPP_INCLUDED
