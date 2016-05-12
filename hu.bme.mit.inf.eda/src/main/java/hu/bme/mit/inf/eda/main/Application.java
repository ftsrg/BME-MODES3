package hu.bme.mit.inf.eda.main;

import hu.bme.mit.inf.eda.collector.Collector;
import hu.bme.mit.inf.eda.collector.OccupancyStatusCollector;
import hu.bme.mit.inf.eda.collector.SectionStatusCollector;
import hu.bme.mit.inf.eda.collector.TurnoutStatusCollector;
import hu.bme.mit.inf.eda.data.CollectionTimeSettings;
import static hu.bme.mit.inf.eda.util.PathValidator.isPathValid;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 *
 * @author benedekh
 */
public class Application {

    public static final void main(String[] args) {
        try {
            OptionParser parser = new OptionParser();
            ArgumentAcceptingOptionSpec<String> sectionStatusLogPathArg
                    = parser.accepts("sl",
                            "Path for section status (enabled/disabled) log file [optional, if omitted then section status is excluded]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> turnoutStatusLogPathArg
                    = parser.accepts("tl",
                            "Path for turnout status (divergent/straight) log file [optional, if omitted then turnout status is excluded]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> occupancyStatusLogPathArg
                    = parser.accepts("ol",
                            "Path for occupancy section status (occupied/free) log file [optional, if omitted then section occupancy status is excluded]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> intervalArg
                    = parser.accepts("i",
                            "Interval for data collection in minutes. [optional, default = 1]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<Integer> frequencyArg
                    = parser.accepts("f",
                            "Frequency for data collection in milliseconds. [optional, default = 100]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> mqttProtocolArg
                    = parser.accepts("pp",
                            "MQTT Broker Protocol [optional, default = tcp]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> mqttPortArg
                    = parser.accepts("p",
                            "MQTT Broker Port [optional, default = 1883]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> mqttAddressArg
                    = parser.accepts("a",
                            "MQTT Broker Address [optional, default = localhost]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> mqttQOSArg
                    = parser.accepts("q",
                            "MQTT Broker QOS [optional, default = 1 (at least once); possible values: 0 - at most once, 2 - exactly once]")
                    .withRequiredArg().ofType(Integer.class);

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);

            boolean enableSectionStatusLog = parsed.has("sl");
            boolean enableTurnoutStatusLog = parsed.has("tl");
            boolean enableOccupancyStatusLog = parsed.has("ol");

            if (!enableSectionStatusLog && !enableTurnoutStatusLog && !enableOccupancyStatusLog) {
                System.err.println("Logger does not log any status information.");
                System.err.println(
                        "Choose at least one: section status, turnout status, occupancy status.");
                return;
            }

            Integer mqttPort = getParameterIntegerValue(parsed,
                    mqttPortArg, "-p");
            Integer mqttQOS = getParameterIntegerValue(parsed,
                    mqttQOSArg, "-q");
            Integer interval = getParameterIntegerValue(parsed,
                    intervalArg, "-i");
            Integer frequency = getParameterIntegerValue(parsed,
                    frequencyArg, "-f");

            String sectionStatusPath = getParameterStringValue(parsed,
                    sectionStatusLogPathArg, "--sl");
            String occupancyStatusPath = getParameterStringValue(parsed,
                    occupancyStatusLogPathArg, "--ol");
            String turnoutStatusPath = getParameterStringValue(parsed,
                    turnoutStatusLogPathArg, "--tl");

            MQTTConfiguration config = createConfiguration(parsed,
                    mqttProtocolArg, mqttAddressArg, mqttPort, mqttQOS);

            CollectionTimeSettings timeSettings = createTimeSettings(interval,
                    frequency);

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

        MQTTPublisherSubscriber pubsub = new MQTTPublisherSubscriber(config);
        MQTTPublishSubscribeDispatcher dispatcher = new MQTTPublishSubscribeDispatcher(
                pubsub);

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
            OptionSet parsed,
            ArgumentAcceptingOptionSpec<String> protocolArg,
            ArgumentAcceptingOptionSpec<String> addressArg,
            Integer port, Integer qos) {
        MQTTConfiguration conf = new MQTTConfiguration();
        if (parsed.has(protocolArg)) {
            conf.setProtocol(parsed.valueOf(protocolArg));
        }
        if (parsed.has(addressArg)) {
            conf.setAddress(parsed.valueOf(addressArg));
        }
        if (port != null) {
            conf.setPort(port);
        }
        if (qos != null) {
            conf.setQOS(qos);
        }
        return conf;
    }

    private static Integer getParameterIntegerValue(OptionSet parsed,
            ArgumentAcceptingOptionSpec<Integer> parameter,
            String parameterFieldName) throws IOException {
        if (parsed.has(parameter)) {
            try {
                return parsed.valueOf(parameter);
            } catch (joptsimple.OptionException ex) {
                throw new IOException(
                        "Please use a number for the " + parameterFieldName + " parameter.");
            }
        }
        return null;
    }

    private static String getParameterStringValue(OptionSet parsed,
            ArgumentAcceptingOptionSpec<String> parameter,
            String parameterFieldName) throws IOException {
        if (parsed.has(parameter)) {
            try {
                return parsed.valueOf(parameter);
            } catch (joptsimple.OptionException ex) {
                throw new IOException(
                        "Please use a string for the " + parameterFieldName + " parameter.");
            }
        }
        return null;
    }

}
