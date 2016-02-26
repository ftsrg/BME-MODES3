package hu.bme.mit.inf.yakindu.sc.normal.control.transmitter;

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;

/**
 *
 * @author benedekh
 */
public class CommunicationConfiguration {

    private static MQTTConfiguration statemachineMQTTConf;
    private static MQTTConfiguration kvcontrolMQTTConf;

    public static void setKvcontrolMQTTConfiguration(MQTTConfiguration conf) {
        kvcontrolMQTTConf = conf;
    }

    public static MQTTConfiguration getKvcontrolMQTTConfiguration() {
        return kvcontrolMQTTConf;
    }

    public static void setStateMachineMQTTConfiguration(MQTTConfiguration conf) {
        statemachineMQTTConf = conf;
    }

    public static MQTTConfiguration getStateMachineMQTTConfiguration() {
        return statemachineMQTTConf;
    }
}
