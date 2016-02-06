package hu.bme.mit.inf.yakindu.mqtt.client.receiver;

/**
 *
 * The interface between the MQTT communication and the former (network) message
 * handling method for the integration code to the StateMachines.
 *
 * @author benedekh
 */
public interface IDistributedMessageTransmitter {

    public void addPacket(byte[] packet);
}
