package hu.bme.mit.inf.mqtt.common.util.logging;

import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * A common Logger class for logging INFO messages and ERROR Exceptions.
 *
 * @author benedekh
 */
public class LogManager {

    // enables the status logging
    private static boolean STATUS_LOG_ENABLED = true;

    /**
     * # Root logger option 
     * log4j.rootLogger=INFO, stdout
     *
     * # Direct log messages to stdout
     * log4j.appender.stdout=org.apache.log4j.ConsoleAppender
     * log4j.appender.stdout.Target=System.out
     * log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
     * log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
     */
    static {
        Properties prop = new Properties();

        prop.put("log4j.rootLogger", "INFO, stdout");
        prop.put("log4j.appender.stdout", "org.apache.log4j.ConsoleAppender");
        prop.put("log4j.appender.stdout.Target", "System.out");
        prop.put("log4j.appender.stdout.layout",
                "org.apache.log4j.PatternLayout");
        prop.put("log4j.appender.stdout.layout.ConversionPattern",
                "%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");

        PropertyConfigurator.configure(prop);
    }

    /**
     * Set the PropertyConfiguration with the new properties. E.g.:
     *
     * Properties properties = new Properties();
     * properties.put("log4j.rootLogger", "INFO, stdout");
     * properties.put("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");
     * properties.put("log4j.appender.stdout.Target","System.out");
     * properties.put("log4j.appender.stdout.layout","org.apache.log4j.PatternLayout");
     * properties.put("log4j.appender.stdout.layout.ConversionPattern","%d{yyyy-MM-dd
     * HH:mm:ss} %-5p %c{1}:%L - %m%n");
     *
     * @param properties
     */
    public static void setLog4JProperties(Properties properties) {
        PropertyConfigurator.configure(properties);
    }

    /**
     * @param isEnabled set the status logging enabled or not
     */
    public static void setStatusLogEnabled(boolean isEnabled) {
        STATUS_LOG_ENABLED = isEnabled;
    }

    /**
     * Logs a new message from the referred class name with INFO level.
     *
     * @param className which sends the message
     * @param message to be logged
     */
    public static void logInfoMessage(String className, String message) {
        if (STATUS_LOG_ENABLED) {
            Logger.getLogger(className).log(Level.INFO, message);
        }
    }

    /**
     * Logs a new Exception from the referred class name with ERROR level.
     *
     * @param className which sends the exception
     * @param ex to be logged
     */
    public static void logException(String className, Exception ex) {
        if (STATUS_LOG_ENABLED) {
            Logger.getLogger(className).log(Level.ERROR, ex);
        }
    }
}
