#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=avr-gcc
CCC=avr-g++
CXX=avr-g++
FC=gfortran
AS=avr-as

# Macros
CND_PLATFORM=Arduino-Linux-x86
CND_DLIB_EXT=so
CND_CONF=Debug
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/MQTTClient/MQTTConnectClient.o \
	${OBJECTDIR}/MQTTClient/MQTTConnectServer.o \
	${OBJECTDIR}/MQTTClient/MQTTDeserializePublish.o \
	${OBJECTDIR}/MQTTClient/MQTTFormat.o \
	${OBJECTDIR}/MQTTClient/MQTTPacket.o \
	${OBJECTDIR}/MQTTClient/MQTTSerializePublish.o \
	${OBJECTDIR}/MQTTClient/MQTTSubscribeClient.o \
	${OBJECTDIR}/MQTTClient/MQTTSubscribeServer.o \
	${OBJECTDIR}/MQTTClient/MQTTUnsubscribeClient.o \
	${OBJECTDIR}/MQTTClient/MQTTUnsubscribeServer.o \
	${OBJECTDIR}/main.o \
	${OBJECTDIR}/mqtt-driver/mqtt-driver.o \
	${OBJECTDIR}/s88/s88.o


# C Compiler Flags
CFLAGS=${FLAGS_GCC}

# CC Compiler Flags
CCFLAGS=${FLAGS_GPP}
CXXFLAGS=${FLAGS_GPP}

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/hu.bme.mit.inf.master.mqtt.soc

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/hu.bme.mit.inf.master.mqtt.soc: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	avr-gcc -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/hu.bme.mit.inf.master.mqtt.soc ${OBJECTFILES} ${LDLIBSOPTIONS} ${FLAGS_LINKER}

${OBJECTDIR}/MQTTClient/MQTTConnectClient.o: MQTTClient/MQTTConnectClient.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTConnectClient.o MQTTClient/MQTTConnectClient.c

${OBJECTDIR}/MQTTClient/MQTTConnectServer.o: MQTTClient/MQTTConnectServer.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTConnectServer.o MQTTClient/MQTTConnectServer.c

${OBJECTDIR}/MQTTClient/MQTTDeserializePublish.o: MQTTClient/MQTTDeserializePublish.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTDeserializePublish.o MQTTClient/MQTTDeserializePublish.c

${OBJECTDIR}/MQTTClient/MQTTFormat.o: MQTTClient/MQTTFormat.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTFormat.o MQTTClient/MQTTFormat.c

${OBJECTDIR}/MQTTClient/MQTTPacket.o: MQTTClient/MQTTPacket.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTPacket.o MQTTClient/MQTTPacket.c

${OBJECTDIR}/MQTTClient/MQTTSerializePublish.o: MQTTClient/MQTTSerializePublish.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTSerializePublish.o MQTTClient/MQTTSerializePublish.c

${OBJECTDIR}/MQTTClient/MQTTSubscribeClient.o: MQTTClient/MQTTSubscribeClient.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTSubscribeClient.o MQTTClient/MQTTSubscribeClient.c

${OBJECTDIR}/MQTTClient/MQTTSubscribeServer.o: MQTTClient/MQTTSubscribeServer.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTSubscribeServer.o MQTTClient/MQTTSubscribeServer.c

${OBJECTDIR}/MQTTClient/MQTTUnsubscribeClient.o: MQTTClient/MQTTUnsubscribeClient.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTUnsubscribeClient.o MQTTClient/MQTTUnsubscribeClient.c

${OBJECTDIR}/MQTTClient/MQTTUnsubscribeServer.o: MQTTClient/MQTTUnsubscribeServer.c 
	${MKDIR} -p ${OBJECTDIR}/MQTTClient
	${RM} "$@.d"
	$(COMPILE.c) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/MQTTClient/MQTTUnsubscribeServer.o MQTTClient/MQTTUnsubscribeServer.c

${OBJECTDIR}/main.o: main.cpp 
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/main.o main.cpp

${OBJECTDIR}/mqtt-driver/mqtt-driver.o: mqtt-driver/mqtt-driver.cpp 
	${MKDIR} -p ${OBJECTDIR}/mqtt-driver
	${RM} "$@.d"
	$(COMPILE.cc) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/mqtt-driver/mqtt-driver.o mqtt-driver/mqtt-driver.cpp

${OBJECTDIR}/s88/s88.o: s88/s88.cpp 
	${MKDIR} -p ${OBJECTDIR}/s88
	${RM} "$@.d"
	$(COMPILE.cc) -g -I${INCLUDE} -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/s88/s88.o s88/s88.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}
	${RM} ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/hu.bme.mit.inf.master.mqtt.soc

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
