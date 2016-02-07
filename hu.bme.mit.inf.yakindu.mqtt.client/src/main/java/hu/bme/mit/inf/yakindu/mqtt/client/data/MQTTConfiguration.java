package hu.bme.mit.inf.yakindu.mqtt.client.data;

/**
 *
 * @author benedekh
 */
public class MQTTConfiguration {

    private String protocol = "tcp";
    private String address = "localhost";
    private int port = 1883;

    private int qos = 1;
    private final String topic;
    private String clientId = new String();

    public MQTTConfiguration(String topic) {
        this.topic = topic;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setQOS(int qos) {
        this.qos = qos;
    }

    public void setClientID(String clientId) {
        this.clientId = clientId;
    }

    public String getClientID() {
        return this.clientId;
    }

    public String getFullAddress() {
        return protocol + "://" + address + ":" + port;
    }

    public int getQOS() {
        return this.qos;
    }

    public String getTopic() {
        return this.topic;
    }

}
