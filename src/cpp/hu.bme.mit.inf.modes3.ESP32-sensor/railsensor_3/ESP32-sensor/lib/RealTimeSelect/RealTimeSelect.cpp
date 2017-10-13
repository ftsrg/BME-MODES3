#include "RealTimeSelect.hpp"
#include <iostream>

RealTimeSelect::RealTimeSelect(){
    sindex=0;
    for(int i=0;i<10;i++){
        lenarray[i]=0;
    }
}
bool RealTimeSelect::AddTrain(char name[10],double length){
    for(int j=0;j<10;j++){
        if(lenarray[j]<length){
            int i;
            for(i=j;lenarray[i]!=0;i++){
                if(i==10) return false;
            }
            for(int k=i;k>j;k--){
                lenarray[k]=lenarray[k-1];
                for(int i=0;i<10;i++) namearray[k][i]=namearray[k-1][i];
            }
            lenarray[j]=length;
            for(int i=0;i<10;i++) namearray[j][i]=name[i];
            sindex++;
            return true;
        }
        if(sindex==9) return false;
    }
    return false;
}
bool RealTimeSelect::DeleteTrain(char name[10]){
    return false;
}
char* RealTimeSelect::Search(double length){
    for(int i=0;i<sindex;i++){
        if(lenarray[i]<length){
            if(i==0){
                return namearray[0];
            }
            if((lenarray[i-1]+lenarray[i])/2>length){
                return namearray[i];
            }else{
                return namearray[i-1];
            }
        }else{
            if(i==sindex-1){
                return namearray[sindex-1];
            }
        }
    }
    char unknown[]="UNKNOWN";
    return unknown;
}
void RealTimeSelect::Print(){
    for(int i=0;i<sindex;i++){
        std::cout<<namearray[i]<<": "<<lenarray[i]<<std::endl;
    }
}
