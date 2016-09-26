##
## Auto Generated makefile by CodeLite IDE
## any manual changes will be erased      
##
## Debug
ProjectName            :=XpressController-codelite
ConfigurationName      :=Debug
WorkspacePath          :=/home/chorithian/Documents/xpressnet-codelite
ProjectPath            :=/home/chorithian/Documents/xpressnet-codelite
IntermediateDirectory  :=./Debug
OutDir                 := $(IntermediateDirectory)
CurrentFileName        :=
CurrentFilePath        :=
CurrentFileFullPath    :=
User                   :=Chorithian
Date                   :=26/09/16
CodeLitePath           :=/home/chorithian/.codelite
LinkerName             :=/usr/bin/g++
SharedObjectLinkerName :=/usr/bin/g++ -shared -fPIC
ObjectSuffix           :=.o
DependSuffix           :=.o.d
PreprocessSuffix       :=.i
DebugSwitch            :=-g 
IncludeSwitch          :=-I
LibrarySwitch          :=-l
OutputSwitch           :=-o 
LibraryPathSwitch      :=-L
PreprocessorSwitch     :=-D
SourceSwitch           :=-c 
OutputFile             :=$(IntermediateDirectory)/$(ProjectName)
Preprocessors          :=
ObjectSwitch           :=-o 
ArchiveOutputSwitch    := 
PreprocessOnlySwitch   :=-E
ObjectsFileList        :="XpressController-codelite.txt"
PCHCompileFlags        :=
MakeDirCommand         :=mkdir -p
LinkOptions            :=  -O0 -lboost_system -lboost_thread -lpthread -lmosquittopp -lmosquitto `pkg-config --libs protobuf`
IncludePath            :=  $(IncludeSwitch). $(IncludeSwitch). $(IncludeSwitch)/usr/include/boost/ 
IncludePCH             := 
RcIncludePath          := 
Libs                   := 
ArLibs                 :=  
LibPath                := $(LibraryPathSwitch). $(LibraryPathSwitch). $(LibraryPathSwitch)Debug $(LibraryPathSwitch)/usr/lib/arm-linux-gnueabihf 

##
## Common variables
## AR, CXX, CC, AS, CXXFLAGS and CFLAGS can be overriden using an environment variables
##
AR       := /usr/bin/ar rcu
CXX      := /usr/bin/g++
CC       := /usr/bin/gcc
CXXFLAGS :=  -g -Wall -std=c++11 `pkg-config --cflags protobuf` $(Preprocessors)
CFLAGS   :=   $(Preprocessors)
ASFLAGS  := 
AS       := /usr/bin/as


##
## User defined environment variables
##
CodeLiteDir:=/usr/share/codelite
Objects0=$(IntermediateDirectory)/main.cpp$(ObjectSuffix) $(IntermediateDirectory)/Network_MqttClient.cpp$(ObjectSuffix) $(IntermediateDirectory)/Network_NetworkInterface.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(ObjectSuffix) \
	$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(ObjectSuffix) \
	$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(ObjectSuffix) $(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(ObjectSuffix) \
	$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(ObjectSuffix) \
	$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(ObjectSuffix) 

Objects1=$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(ObjectSuffix) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(ObjectSuffix) \
	



Objects=$(Objects0) $(Objects1) 

##
## Main Build Targets 
##
.PHONY: all clean PreBuild PrePreBuild PostBuild MakeIntermediateDirs
all: $(OutputFile)

$(OutputFile): $(IntermediateDirectory)/.d $(Objects) 
	@$(MakeDirCommand) $(@D)
	@echo "" > $(IntermediateDirectory)/.d
	@echo $(Objects0)  > $(ObjectsFileList)
	@echo $(Objects1) >> $(ObjectsFileList)
	$(LinkerName) $(OutputSwitch)$(OutputFile) @$(ObjectsFileList) $(LibPath) $(Libs) $(LinkOptions)

MakeIntermediateDirs:
	@test -d ./Debug || $(MakeDirCommand) ./Debug


$(IntermediateDirectory)/.d:
	@test -d ./Debug || $(MakeDirCommand) ./Debug

PreBuild:


##
## Objects
##
$(IntermediateDirectory)/main.cpp$(ObjectSuffix): main.cpp $(IntermediateDirectory)/main.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/main.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/main.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/main.cpp$(DependSuffix): main.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/main.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/main.cpp$(DependSuffix) -MM main.cpp

$(IntermediateDirectory)/main.cpp$(PreprocessSuffix): main.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/main.cpp$(PreprocessSuffix)main.cpp

$(IntermediateDirectory)/Network_MqttClient.cpp$(ObjectSuffix): Network/MqttClient.cpp $(IntermediateDirectory)/Network_MqttClient.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/Network/MqttClient.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/Network_MqttClient.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/Network_MqttClient.cpp$(DependSuffix): Network/MqttClient.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/Network_MqttClient.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/Network_MqttClient.cpp$(DependSuffix) -MM Network/MqttClient.cpp

$(IntermediateDirectory)/Network_MqttClient.cpp$(PreprocessSuffix): Network/MqttClient.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/Network_MqttClient.cpp$(PreprocessSuffix)Network/MqttClient.cpp

$(IntermediateDirectory)/Network_NetworkInterface.cpp$(ObjectSuffix): Network/NetworkInterface.cpp $(IntermediateDirectory)/Network_NetworkInterface.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/Network/NetworkInterface.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/Network_NetworkInterface.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/Network_NetworkInterface.cpp$(DependSuffix): Network/NetworkInterface.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/Network_NetworkInterface.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/Network_NetworkInterface.cpp$(DependSuffix) -MM Network/NetworkInterface.cpp

$(IntermediateDirectory)/Network_NetworkInterface.cpp$(PreprocessSuffix): Network/NetworkInterface.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/Network_NetworkInterface.cpp$(PreprocessSuffix)Network/NetworkInterface.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(ObjectSuffix): XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(DependSuffix): XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetInterfaces_ProtobufTranslator.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetInterfaces/ProtobufTranslator.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveNotAvailable.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/LocomotiveNotAvailable.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_TrackPowerStatusMessage.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/TrackPowerStatusMessage.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingXPNMessage.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/IncomingXPNMessage.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse_LNN.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse_LNN.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_AccessoryDecoderInformationResponse.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/AccessoryDecoderInformationResponse.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveControlTaken.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/LocomotiveControlTaken.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_IncomingByteBuffer.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/IncomingByteBuffer.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(ObjectSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(DependSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetIncomingMessages_LocomotiveInformation.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetIncomingMessages/LocomotiveInformation.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveSpeed.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveSpeed.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopAllLocomotives.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/StopAllLocomotives.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetLocomotiveFunctions.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/SetLocomotiveFunctions.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_GetLocomotiveInformation.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/GetLocomotiveInformation.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_CVTrainProgramming.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/CVTrainProgramming.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_SetTurnout.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/SetTurnout.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_OutgoingXPNMessage.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/OutgoingXPNMessage.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StartOperations.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/StartOperations.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_StopOperations.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/StopOperations.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(ObjectSuffix): XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(DependSuffix): XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetOutgoingMessages_EmergencyStopALocomotive.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetOutgoingMessages/EmergencyStopALocomotive.cpp

$(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(ObjectSuffix): XpressNetSerial/TrainStatus.cpp $(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/TrainStatus.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(DependSuffix): XpressNetSerial/TrainStatus.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(DependSuffix) -MM XpressNetSerial/TrainStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(PreprocessSuffix): XpressNetSerial/TrainStatus.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_TrainStatus.cpp$(PreprocessSuffix)XpressNetSerial/TrainStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(ObjectSuffix): XpressNetSerial/BoardStatus.cpp $(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/BoardStatus.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(DependSuffix): XpressNetSerial/BoardStatus.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(DependSuffix) -MM XpressNetSerial/BoardStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(PreprocessSuffix): XpressNetSerial/BoardStatus.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_BoardStatus.cpp$(PreprocessSuffix)XpressNetSerial/BoardStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(ObjectSuffix): XpressNetSerial/TurnoutStatus.cpp $(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/TurnoutStatus.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(DependSuffix): XpressNetSerial/TurnoutStatus.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(DependSuffix) -MM XpressNetSerial/TurnoutStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(PreprocessSuffix): XpressNetSerial/TurnoutStatus.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_TurnoutStatus.cpp$(PreprocessSuffix)XpressNetSerial/TurnoutStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(ObjectSuffix): XpressNetSerial/XpressNetSerial.cpp $(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/XpressNetSerial.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(DependSuffix): XpressNetSerial/XpressNetSerial.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(DependSuffix) -MM XpressNetSerial/XpressNetSerial.cpp

$(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(PreprocessSuffix): XpressNetSerial/XpressNetSerial.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_XpressNetSerial.cpp$(PreprocessSuffix)XpressNetSerial/XpressNetSerial.cpp

$(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(ObjectSuffix): XpressNetSerial/AsyncSerial.cpp $(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/AsyncSerial.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(DependSuffix): XpressNetSerial/AsyncSerial.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(DependSuffix) -MM XpressNetSerial/AsyncSerial.cpp

$(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(PreprocessSuffix): XpressNetSerial/AsyncSerial.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_AsyncSerial.cpp$(PreprocessSuffix)XpressNetSerial/AsyncSerial.cpp

$(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(ObjectSuffix): XpressNetSerial/TrackPowerStatus.cpp $(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/TrackPowerStatus.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(DependSuffix): XpressNetSerial/TrackPowerStatus.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(DependSuffix) -MM XpressNetSerial/TrackPowerStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(PreprocessSuffix): XpressNetSerial/TrackPowerStatus.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_TrackPowerStatus.cpp$(PreprocessSuffix)XpressNetSerial/TrackPowerStatus.cpp

$(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(ObjectSuffix): XpressNetSerial/SerialConnection.cpp $(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/XpressNetSerial/SerialConnection.cpp" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(DependSuffix): XpressNetSerial/SerialConnection.cpp
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(ObjectSuffix) -MF$(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(DependSuffix) -MM XpressNetSerial/SerialConnection.cpp

$(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(PreprocessSuffix): XpressNetSerial/SerialConnection.cpp
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/XpressNetSerial_SerialConnection.cpp$(PreprocessSuffix)XpressNetSerial/SerialConnection.cpp

$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/DccOperationsCommand.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/DccOperationsCommand.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(DependSuffix): GoogleProtocolBuffers/DccOperationsCommand.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/DccOperationsCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/DccOperationsCommand.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsCommand.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/DccOperationsCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/DccOperationsState.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/DccOperationsState.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(DependSuffix): GoogleProtocolBuffers/DccOperationsState.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/DccOperationsState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/DccOperationsState.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_DccOperationsState.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/DccOperationsState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/Enums.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/Enums.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(DependSuffix): GoogleProtocolBuffers/Enums.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/Enums.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/Enums.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_Enums.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/Enums.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/Message.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/Message.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(DependSuffix): GoogleProtocolBuffers/Message.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/Message.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/Message.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_Message.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/Message.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/SegmentCommand.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/SegmentCommand.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(DependSuffix): GoogleProtocolBuffers/SegmentCommand.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/SegmentCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/SegmentCommand.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentCommand.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/SegmentCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/SegmentOccupancy.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/SegmentOccupancy.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(DependSuffix): GoogleProtocolBuffers/SegmentOccupancy.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/SegmentOccupancy.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/SegmentOccupancy.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentOccupancy.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/SegmentOccupancy.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/SegmentState.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/SegmentState.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(DependSuffix): GoogleProtocolBuffers/SegmentState.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/SegmentState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/SegmentState.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_SegmentState.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/SegmentState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TrainCurrentSegment.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TrainCurrentSegment.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(DependSuffix): GoogleProtocolBuffers/TrainCurrentSegment.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TrainCurrentSegment.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TrainCurrentSegment.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSegment.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TrainCurrentSegment.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(DependSuffix): GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainCurrentSpeed.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TrainCurrentSpeed.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TrainFunctionCommand.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TrainFunctionCommand.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(DependSuffix): GoogleProtocolBuffers/TrainFunctionCommand.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TrainFunctionCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TrainFunctionCommand.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionCommand.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TrainFunctionCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TrainFunctionState.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TrainFunctionState.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(DependSuffix): GoogleProtocolBuffers/TrainFunctionState.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TrainFunctionState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TrainFunctionState.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainFunctionState.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TrainFunctionState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(DependSuffix): GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeed.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TrainReferenceSpeed.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(DependSuffix): GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TrainReferenceSpeedCommand.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TrainReferenceSpeedCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TurnoutCommand.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TurnoutCommand.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(DependSuffix): GoogleProtocolBuffers/TurnoutCommand.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TurnoutCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TurnoutCommand.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutCommand.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TurnoutCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(DependSuffix): GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceCommand.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TurnoutReferenceCommand.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TurnoutReferenceState.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TurnoutReferenceState.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(DependSuffix): GoogleProtocolBuffers/TurnoutReferenceState.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TurnoutReferenceState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TurnoutReferenceState.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutReferenceState.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TurnoutReferenceState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/TurnoutState.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/TurnoutState.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(DependSuffix): GoogleProtocolBuffers/TurnoutState.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/TurnoutState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/TurnoutState.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_TurnoutState.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/TurnoutState.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/YakinduCanGoTo.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/YakinduCanGoTo.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(DependSuffix): GoogleProtocolBuffers/YakinduCanGoTo.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/YakinduCanGoTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/YakinduCanGoTo.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCanGoTo.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/YakinduCanGoTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(DependSuffix): GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduCannotGoTo.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/YakinduCannotGoTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/YakinduReleaseTo.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/YakinduReleaseTo.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(DependSuffix): GoogleProtocolBuffers/YakinduReleaseTo.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/YakinduReleaseTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/YakinduReleaseTo.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReleaseTo.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/YakinduReleaseTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(ObjectSuffix): GoogleProtocolBuffers/YakinduReserveTo.pb.cc $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(DependSuffix)
	$(CXX) $(IncludePCH) $(SourceSwitch) "/home/chorithian/Documents/xpressnet-codelite/GoogleProtocolBuffers/YakinduReserveTo.pb.cc" $(CXXFLAGS) $(ObjectSwitch)$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(ObjectSuffix) $(IncludePath)
$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(DependSuffix): GoogleProtocolBuffers/YakinduReserveTo.pb.cc
	@$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) -MG -MP -MT$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(ObjectSuffix) -MF$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(DependSuffix) -MM GoogleProtocolBuffers/YakinduReserveTo.pb.cc

$(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(PreprocessSuffix): GoogleProtocolBuffers/YakinduReserveTo.pb.cc
	$(CXX) $(CXXFLAGS) $(IncludePCH) $(IncludePath) $(PreprocessOnlySwitch) $(OutputSwitch) $(IntermediateDirectory)/GoogleProtocolBuffers_YakinduReserveTo.pb.cc$(PreprocessSuffix)GoogleProtocolBuffers/YakinduReserveTo.pb.cc


-include $(IntermediateDirectory)/*$(DependSuffix)
##
## Clean
##
clean:
	$(RM) -r ./Debug/


