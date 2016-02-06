package hu.bme.mit.inf.kvcontrol.mqtt.client.data;

/**
 *
 * @author benedekh
 */
public class MQTTConfiguration {

    private final String address;
    private final int qos;
    private final String topic;
    private String clientId;

    public MQTTConfiguration(String address, int qos, String topic) {
        this.address = address;
        this.qos = qos;
        this.topic = topic;
        this.clientId = new String();
    }

    public MQTTConfiguration(String address, int qos, String topic,
            String clientId) {
        this.address = address;
        this.qos = qos;
        this.topic = topic;
        this.clientId = clientId;
    }

    public void setClientID(String clientId) {
        this.clientId = clientId;
    }

    public String getClientID() {
        return this.clientId;
    }

    public String getAddress() {
        return this.address;
    }

    public int getQOS() {
        return this.qos;
    }

    public String getTopic() {
        return this.topic;
    }

}
