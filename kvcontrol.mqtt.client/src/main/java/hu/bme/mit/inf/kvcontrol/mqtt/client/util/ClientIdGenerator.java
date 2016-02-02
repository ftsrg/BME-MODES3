package hu.bme.mit.inf.kvcontrol.mqtt.client.util;

import java.util.UUID;

/**
 *
 * @author benedekh
 */
public class ClientIdGenerator {

    public static String generateId(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }

}
