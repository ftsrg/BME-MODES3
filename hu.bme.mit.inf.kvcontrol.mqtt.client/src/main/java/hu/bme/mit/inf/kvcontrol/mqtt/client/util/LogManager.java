package hu.bme.mit.inf.kvcontrol.mqtt.client.util;

import java.util.Properties;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author benedekh
 */
public class LogManager {

    private static boolean STATUS_LOG_ENABLED = true;
    
    /**
     * # Root logger option 
     * log4j.rootLogger=DEBUG, stdout
     *
     * # Direct log messages to stdout
     * log4j.appender.stdout=org.apache.log4j.ConsoleAppender
     * log4j.appender.stdout.Target=System.out
     * log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
     * log4j.appender.stdout.layout.ConversionPattern=%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n
     */
    static {
        Properties prop = new Properties();

        prop.put("log4j.rootLogger", "DEBUG, stdout");
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
     * properties.put("log4j.rootLogger", "DEBUG, stdout");
     * properties.put("log4j.appender.stdout","org.apache.log4j.ConsoleAppender");
     * properties.put("log4j.appender.stdout.Target","System.out");
     * properties.put("log4j.appender.stdout.layout","org.apache.log4j.PatternLayout");
     * properties.put("log4j.appender.stdout.layout.ConversionPattern","%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n");
     * 
     * @param properties
     */
    public static void setLog4JProperties(Properties properties) {
        PropertyConfigurator.configure(properties);
    }
    
    public static void setStatusLogEnabled(boolean isEnabled){
        STATUS_LOG_ENABLED = isEnabled;
    }

    public static void logInfoMessage(String className, String message) {
        if(STATUS_LOG_ENABLED){
            Logger.getLogger(className).log(Level.INFO, message);
        }
    }

    public static void logException(String className, Exception ex) {
        if(STATUS_LOG_ENABLED){
            Logger.getLogger(className).log(Level.ERROR, ex);
        }
    }
}
