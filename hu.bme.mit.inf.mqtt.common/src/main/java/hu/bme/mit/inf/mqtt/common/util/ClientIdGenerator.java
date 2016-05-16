package hu.bme.mit.inf.mqtt.common.util;

import java.util.UUID;

/**
 * Used for generating a client ID.
 * 
 * @author benedekh
 */
public class ClientIdGenerator {

    /**
     * Generates a unique client ID with the referred prefix.
     * 
     * @param prefix of the client ID
     * @return the client ID
     */
    public static String generateId(String prefix) {
        return prefix + UUID.randomUUID().toString();
    }
}
