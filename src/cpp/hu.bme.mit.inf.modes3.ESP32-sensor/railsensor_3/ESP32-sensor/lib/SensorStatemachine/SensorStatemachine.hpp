#ifndef SENSOR_STATEMACHINE_HPP
#define SENSOR_STATEMACHINE_HPP

const double maxtime=4;

enum StateMachine{
    Trainwait,
    Firstdetect,
    Traindetect,
    Nextwait,
    Datasend
};

class SensorStateMachine{
  private:
    StateMachine state;
    bool detect;
    InfSensor* sensor;
    int kocsiszam;
    bool direction;
  public:
    SensorStateMachine(InfSensor* sensors)
    {
      sensor=sensors;
      state=Trainwait;
      kocsiszam=0;
    }
    bool Update(){
      double atime;
      bool det[2], detect;
      for(int i=0;i<2;i++){
        det[i]=sensor[i].Update();
      }
      detect=det[0]||det[1];
      switch(state){
        case Firstdetect:
          state = Traindetect;
          if(sensor[0].GetValue()==1){
            direction=false;
          }else{
            direction=true;
          }
        break;
        case Trainwait:
          if(detect==1){
            state=Firstdetect;
          }
        break;
        case Traindetect:
          if(detect==0){
            state=Nextwait;
            atime=SecTime();
          }
        break;
        case Nextwait:
          if(detect==1){
            state=Traindetect;
          }
          if(detect==0&&(SecTime()-atime>maxtime)){
            state=Datasend;
           
            Serial.println("\tMQTT-re kiirva");
            for(int i=0;i<2;i++){
              sensor[i].Reset();
            }
            kocsiszam = 0;
          }
        break;
        case Datasend:
          state=Trainwait;
        break;
      }
    }
    int GetKocsiszam(){
      return kocsiszam;
    }
    StateMachine GetState(){
      return state;
    }
    bool GetDirection(){
      return direction;
    }
    void IncKocsiszam(){
      kocsiszam++;
    }
};

#endif