package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kvcontrol.requests.AbstractRequest;
import hu.bme.mit.inf.yakindu.mqtt.client.data.MQTTConfiguration;

/**
 *
 * @author benedekh
 */
public class CommunicationConfiguration {

    private static MQTTConfiguration statemachineMQTTConf;

    public static void setKvControlAddress(String address) {
        AbstractRequest.setDefultAddress("http://" + address);
    }

    public static void setKvControlPort(int port) {
        AbstractRequest.setDefaultPort(port);
    }

    public static void setStateMachineMQTTConfiguration(MQTTConfiguration conf) {
        statemachineMQTTConf = conf;
    }

    public static MQTTConfiguration getStateMachineMQTTConfiguration() {
        return statemachineMQTTConf;
    }
}
