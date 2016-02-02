package hu.bme.mit.inf.kvcontrol.mqtt.client.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 *
 * @author benedekh
 */
public class LogManager {

    public static void logInfoMessage(String className, String message) {
        Logger.getLogger(className).log(Level.INFO, message);
    }

    public static void logException(String className, Exception ex) {
        Logger.getLogger(className).log(Level.ERROR, ex);
    }
}
