package hu.bme.mit.inf.mqtt.common.network;

/**
 * Stores the configuration of an MQTT connection.
 *
 * @author benedekh
 */
public class MQTTConfiguration {

    // the protocol of the MQTT Broker
    private String protocol = "tcp";

    // the address of the MQTT Broker
    private String address = "localhost";

    // the port of the MQTT Broker
    private int port = 1883;

    // the QOS of the MQTT Broker
    private int qos = 0;

    // the ID of the connecting client
    private String clientId = new String();

    public MQTTConfiguration() {

    }

    /**
     * @param address of the MQTT Broker
     */
    public MQTTConfiguration(String address) {
        this.address = address;
    }

    /**
     * @param protocol of the MQTT Broker
     */
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    /**
     * @param address of the MQTT Broker
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @param port of the MQTT Broker
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * @param qos of the MQTT Broker
     */
    public void setQOS(int qos) {
        this.qos = qos;
    }

    /**
     *
     * @param clientId the ID of the connecting client
     */
    public void setClientID(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return the ID of the connecting client
     */
    public String getClientID() {
        return this.clientId;
    }

    /**
     * @return the full address of the MQTT Broker
     */
    public String getFullAddress() {
        return protocol + "://" + address + ":" + port;
    }

    /**
     * @return QOS of the MQTT Broker
     */
    public int getQOS() {
        return this.qos;
    }

}
