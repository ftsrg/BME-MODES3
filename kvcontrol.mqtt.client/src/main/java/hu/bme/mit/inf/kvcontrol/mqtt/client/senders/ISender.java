package hu.bme.mit.inf.kvcontrol.mqtt.client.senders;

/**
 *
 * @author benedekh
 */
public interface ISender {

    public void send(byte[] message);
}
