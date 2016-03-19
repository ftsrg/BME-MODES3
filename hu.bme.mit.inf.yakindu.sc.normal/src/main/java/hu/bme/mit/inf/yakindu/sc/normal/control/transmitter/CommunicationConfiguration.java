package hu.bme.mit.inf.yakindu.sc.normal.control.transmitter;

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;

/**
 *
 * @author benedekh
 */
public class CommunicationConfiguration {

    private static MQTTConfiguration statemachineMQTTConf;
    private static MQTTConfiguration kvcontrolSectionMQTTConf;
    private static MQTTConfiguration kvcontrolTurnoutMQTTConf;
    private static MQTTConfiguration kvcontrolOccupancyMQTTConf;

    public static void setKvcontrolSectionMQTTConfiguration(
            MQTTConfiguration conf) {
        kvcontrolSectionMQTTConf = conf;
    }

    public static MQTTConfiguration getKvcontrolSectionMQTTConfiguration() {
        return kvcontrolSectionMQTTConf;
    }

    public static void setKvcontrolTurnoutMQTTConfiguration(
            MQTTConfiguration conf) {
        kvcontrolTurnoutMQTTConf = conf;
    }

    public static MQTTConfiguration getKvcontrolTurnoutMQTTConfiguration() {
        return kvcontrolTurnoutMQTTConf;
    }

    public static void setKvcontrolOccupancyMQTTConfiguration(
            MQTTConfiguration conf) {
        kvcontrolOccupancyMQTTConf = conf;
    }

    public static MQTTConfiguration getKvcontrolOccupancyMQTTConfiguration() {
        return kvcontrolOccupancyMQTTConf;
    }

    public static void setStateMachineMQTTConfiguration(MQTTConfiguration conf) {
        statemachineMQTTConf = conf;
    }

    public static MQTTConfiguration getStateMachineMQTTConfiguration() {
        return statemachineMQTTConf;
    }
}
