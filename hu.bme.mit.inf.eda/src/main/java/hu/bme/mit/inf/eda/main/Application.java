package hu.bme.mit.inf.eda.main;

import hu.bme.mit.inf.eda.collector.Collector;
import hu.bme.mit.inf.eda.collector.OccupancyStatusCollector;
import hu.bme.mit.inf.eda.collector.SectionStatusCollector;
import hu.bme.mit.inf.eda.collector.TrainsCVCollector;
import hu.bme.mit.inf.eda.collector.TurnoutStatusCollector;
import hu.bme.mit.inf.eda.util.TimeSettings;
import static hu.bme.mit.inf.eda.util.PathValidator.isPathValid;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.parameters.ArgumentDescriptor;
import hu.bme.mit.inf.mqtt.common.parameters.ArgumentRegistrar;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The application of the EDA (Exploratory Data Analysis) component.
 *
 * Different data collectors can be registered and enabled so different data can
 * be collected from the model railway track. Most of the data is transferred
 * through different MQTT topics, for that the collectors subscribe.
 *
 * The frequency and the duration of the data collection can be set.
 *
 * @author benedekh
 */
public class Application {

    public static final void main(String[] args) {
        try {
            ArgumentRegistrar reg = new ArgumentRegistrar();

            // register arguments
            reg.registerArgumentWithOptions(new ArgumentDescriptor("sl",
                    "Path for section status (enabled/disabled) log file [optional, if omitted then section status is excluded]",
                    String.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("tl",
                    "Path for turnout status (divergent/straight) log file [optional, if omitted then turnout status is excluded]",
                    String.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("ol",
                    "Path for occupancy section status (occupied/free) log file [optional, if omitted then section occupancy status is excluded]",
                    String.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("tcvl",
                    "Path for trains location information based on CV (Computer Vision) log file [optional, if omitted then trains CV status is excluded]",
                    String.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("i",
                    "Interval for data collection in minutes. [optional, default = 1]",
                    Integer.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("f",
                    "Frequency for data collection in milliseconds. [optional, default = 100]",
                    Integer.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("pp",
                    "MQTT Broker Protocol [optional, default = tcp]",
                    String.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("p",
                    "MQTT Broker Port [optional, default = 1883]", Integer.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("a",
                    "MQTT Broker Address [optional, default = localhost]",
                    String.class));
            reg.registerArgumentWithOptions(new ArgumentDescriptor("q",
                    "MQTT Broker QOS [optional, default = 1 (at least once); possible values: 0 - at most once, 2 - exactly once]",
                    Integer.class));

            reg.printHelp(System.out);
            reg.parseArguments(args);

            // check required arguments
            Set<String> requiredArgs = new HashSet<>(Arrays.asList("sl", "tl",
                    "ol"));
            if (!reg.hasMandatoryArguments(requiredArgs)) {
                System.err.println("Logger does not log any status information.");
                System.err.println(
                        "Choose at least one: section status, turnout status, occupancy status.");
                return;
            }

            // get parameter values
            Integer mqttPort = reg.getParameterIntegerValue("p");
            Integer mqttQOS = reg.getParameterIntegerValue("q");
            Integer interval = reg.getParameterIntegerValue("i");
            Integer frequency = reg.getParameterIntegerValue("f");

            String sectionStatusPath = reg.getParameterStringValue("sl");
            String occupancyStatusPath = reg.getParameterStringValue("ol");
            String turnoutStatusPath = reg.getParameterStringValue("tl");
            String trainCVStatusPath = reg.getParameterStringValue("tcvl");
            String protocolArg = reg.getParameterStringValue("pp");
            String addressArg = reg.getParameterStringValue("a");

            // create configuration objects
            MQTTConfiguration config = createConfiguration(protocolArg,
                    addressArg, mqttPort, mqttQOS);
            TimeSettings timeSettings = createTimeSettings(interval,
                    frequency);

            // create and start collectors
            Collection<Collector> collectors = createCollectors(
                    sectionStatusPath, occupancyStatusPath, turnoutStatusPath,
                    trainCVStatusPath, config, timeSettings);
            startCollectors(collectors);

        } catch (IOException ex) {
            logException(Application.class.getName(), ex);
        }
    }

    /**
     * Create a time settings for the data collection.
     *
     * @param intervalInt the duration of the data collection in minutes
     * @param frequencyInt the frequency the data shall be updated in
     * milliseconds
     * @return the new time settings object
     */
    private static TimeSettings createTimeSettings(Integer intervalInt,
            Integer frequencyInt) {
        int interval = (intervalInt == null) ? 1 : intervalInt;
        int frequency = (frequencyInt == null) ? 100 : frequencyInt;

        return new TimeSettings(interval, frequency);
    }

    /**
     * Creates the data collectors based on the referred output path. If the
     * output path is null, then the referred collector will not be
     * instantiated.
     *
     * @param sectionStatusPath the output file path for the section status data
     * collection
     * @param occupancyStatusPath the output file path for the section occupancy
     * status data collection
     * @param turnoutStatusPath the output file path for the turnout status data
     * collection
     * @param trainsCVPath the output file path for the train information
     * received from the CV (Computer Vision)
     * @param config the MQTT Configuration
     * @param timeSettings the time interval and frequency for data collection
     * @return a collection of data collectors
     */
    private static Collection<Collector> createCollectors(
            String sectionStatusPath,
            String occupancyStatusPath, String turnoutStatusPath,
            String trainsCVPath,
            MQTTConfiguration config, TimeSettings timeSettings) {

        MQTTPublishSubscribeDispatcher dispatcher = null;
        Collection<Collector> collectors = new HashSet<>();

        if (sectionStatusPath != null && isPathValid(sectionStatusPath)) {
            if (dispatcher == null) {
                dispatcher = new MQTTPublishSubscribeDispatcher(
                        config);
            }
            collectors.add(new SectionStatusCollector(dispatcher, timeSettings,
                    sectionStatusPath));
        }

        if (occupancyStatusPath != null && isPathValid(occupancyStatusPath)) {
            if (dispatcher == null) {
                dispatcher = new MQTTPublishSubscribeDispatcher(
                        config);
            }
            collectors.add(
                    new OccupancyStatusCollector(dispatcher, timeSettings,
                            occupancyStatusPath));
        }

        if (turnoutStatusPath != null && isPathValid(turnoutStatusPath)) {
            if (dispatcher == null) {
                dispatcher = new MQTTPublishSubscribeDispatcher(
                        config);
            }
            collectors.add(new TurnoutStatusCollector(dispatcher, timeSettings,
                    turnoutStatusPath));
        }

        if (trainsCVPath != null && isPathValid(trainsCVPath)) {
            if (dispatcher == null) {
                dispatcher = new MQTTPublishSubscribeDispatcher(
                        config);
            }
            collectors.add(new TrainsCVCollector(dispatcher, timeSettings,
                    trainsCVPath));
        }

        return collectors;
    }

    /**
     * Starts the referred data collectors.
     *
     * @param collectors to be started
     */
    private static void startCollectors(Collection<Collector> collectors) {
        for (Collector collector : collectors) {
            collector.startCollectingData();
        }
    }

    /**
     * Creates a MQTT Configuration based on the parameters.
     *
     * @param protocolArg the protocol of the MQTT Broker
     * @param addressArg the address of the MQTT Broker
     * @param port the port of the MQTT Broker
     * @param qos the QOS (Quality of Service) of the MQTT Broker
     * @return a new MQTT Configuration
     */
    private static MQTTConfiguration createConfiguration(
            String protocolArg, String addressArg,
            Integer port, Integer qos) {

        MQTTConfiguration conf = new MQTTConfiguration();

        if (protocolArg != null) {
            conf.setProtocol(protocolArg);
        }
        if (addressArg != null) {
            conf.setAddress(addressArg);
        }
        if (port != null) {
            conf.setPort(port);
        }
        if (qos != null) {
            conf.setQOS(qos);
        }
        return conf;
    }

}
