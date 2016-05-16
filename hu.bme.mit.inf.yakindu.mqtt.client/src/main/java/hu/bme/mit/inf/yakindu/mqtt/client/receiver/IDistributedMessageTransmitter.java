package hu.bme.mit.inf.yakindu.mqtt.client.receiver;

/**
 *
 * The interface between the MQTT communication and the former (network) message
 * handling method for the integration code to the StateMachines.
 *
 * @author benedekh
 */
public interface IDistributedMessageTransmitter {

    /**
     * Add a packet to the inner storage of implementation that handles the
     * receives messages, and extracts the statechart specific events and
     * parameters from it (glue code attached to the statechart's generated
     * code).
     *
     * @param packet to be stored
     */
    public void addPacket(byte[] packet);
}
