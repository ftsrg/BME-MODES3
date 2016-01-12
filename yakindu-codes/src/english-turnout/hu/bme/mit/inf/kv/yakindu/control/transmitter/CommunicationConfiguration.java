package hu.bme.mit.inf.kv.yakindu.control.transmitter;

import hu.bme.mit.inf.kvcontrol.requests.AbstractRequest;

/**
 *
 * @author benedekh
 */
public class CommunicationConfiguration {

    public static void setKvControlAddress(String address) {
        AbstractRequest.setDefultAddress("http://" + address);
    }

    public static void setKvControlPort(int port) {
        AbstractRequest.setDefaultPort(port);
    }

    public static void setKvControlBpExtensionAddress(String address) {
        hu.bme.mit.inf.kvcontrol.bpextension.requests.AbstractRequest.setDefultAddress(
                "http://" + address);
    }

    public static void setKvControlBpExtensionPort(int port) {
        hu.bme.mit.inf.kvcontrol.bpextension.requests.AbstractRequest.setDefaultPort(
                port);
    }

}
