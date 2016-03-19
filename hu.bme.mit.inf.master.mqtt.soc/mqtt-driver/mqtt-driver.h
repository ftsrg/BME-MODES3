/* 
 * File:   mqtt-driver.h
 * Author: zsoltmazlo
 *
 * Created on March 19, 2016, 12:36 PM
 */

#ifndef MQTT_DRIVER_H
#define	MQTT_DRIVER_H

#define MQTTCLIENT_QOS2 1
    
    void mqtt_initialize();

    void mqtt_connect();
    
    void mqtt_send(char* message);

#endif	/* MQTT_DRIVER_H */

