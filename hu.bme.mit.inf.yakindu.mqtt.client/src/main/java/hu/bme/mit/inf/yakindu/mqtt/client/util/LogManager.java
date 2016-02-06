package hu.bme.mit.inf.yakindu.mqtt.client.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author benedekh
 */
public class LogManager {

    static {
        PropertyConfigurator.configure("log4j.properties");
    }

    public static void logInfoMessage(String className, String message) {
        Logger.getLogger(className).log(Level.INFO, message);
    }

    public static void logException(String className, Exception ex) {
        Logger.getLogger(className).log(Level.ERROR, ex);
    }
}
