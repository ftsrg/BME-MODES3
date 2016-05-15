package hu.bme.mit.inf.eda.main;

import hu.bme.mit.inf.eda.collector.Collector;
import hu.bme.mit.inf.eda.collector.OccupancyStatusCollector;
import hu.bme.mit.inf.eda.collector.SectionStatusCollector;
import hu.bme.mit.inf.eda.collector.TurnoutStatusCollector;
import hu.bme.mit.inf.eda.data.CollectionTimeSettings;
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
            String protocolArg = reg.getParameterStringValue("pp");
            String addressArg = reg.getParameterStringValue("a");

            // create configuration objects
            MQTTConfiguration config = createConfiguration(protocolArg,
                    addressArg, mqttPort, mqttQOS);
            CollectionTimeSettings timeSettings = createTimeSettings(interval,
                    frequency);

            // create and start collectors
            Collection<Collector> collectors = createCollectors(
                    sectionStatusPath, occupancyStatusPath, turnoutStatusPath,
                    config, timeSettings);
            startCollectors(collectors);

        } catch (IOException ex) {
            logException(Application.class.getName(), ex);
        }
    }

    private static CollectionTimeSettings createTimeSettings(Integer intervalInt,
            Integer frequencyInt) {
        int interval = (intervalInt == null) ? 1 : intervalInt;
        int frequency = (frequencyInt == null) ? 100 : frequencyInt;

        return new CollectionTimeSettings(interval, frequency);
    }

    private static Collection<Collector> createCollectors(
            String sectionStatusPath,
            String occupancyStatusPath, String turnoutStatusPath,
            MQTTConfiguration config, CollectionTimeSettings timeSettings) {

        MQTTPublishSubscribeDispatcher dispatcher = new MQTTPublishSubscribeDispatcher(
                config);

        Collection<Collector> collectors = new HashSet<>();

        if (sectionStatusPath != null && isPathValid(sectionStatusPath)) {
            collectors.add(new SectionStatusCollector(dispatcher, timeSettings,
                    sectionStatusPath));
        }

        if (occupancyStatusPath != null && isPathValid(occupancyStatusPath)) {
            collectors.add(
                    new OccupancyStatusCollector(dispatcher, timeSettings,
                            occupancyStatusPath));
        }

        if (turnoutStatusPath != null && isPathValid(turnoutStatusPath)) {
            collectors.add(new TurnoutStatusCollector(dispatcher, timeSettings,
                    turnoutStatusPath));
        }

        return collectors;
    }

    private static void startCollectors(Collection<Collector> collectors) {
        for (Collector collector : collectors) {
            collector.startCollectingData();
        }
    }

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
