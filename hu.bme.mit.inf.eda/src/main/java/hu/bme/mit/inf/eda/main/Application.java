package hu.bme.mit.inf.eda.main;

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import java.io.IOException;
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

            ArgumentAcceptingOptionSpec<Integer> logIntervalArg
                    = parser.accepts("li",
                            "Interval for logging in minutes. [optional, default = 1]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<Integer> logFrequencyArg
                    = parser.accepts("lf",
                            "Frequency for logging in milliseconds. [optional, default = 100]")
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
            Integer logInterval = getParameterIntegerValue(parsed,
                    logIntervalArg, "--li");
            Integer logFrequency = getParameterIntegerValue(parsed,
                    logFrequencyArg, "--lf");

            String sectionStatusPath = getParameterStringValue(parsed,
                    sectionStatusLogPathArg, "--sl");
            String occupancyStatusPath = getParameterStringValue(parsed,
                    occupancyStatusLogPathArg, "--ol");
            String turnoutStatusPath = getParameterStringValue(parsed,
                    turnoutStatusLogPathArg, "--tl");

            MQTTConfiguration config = createConfiguration(parsed,
                    mqttProtocolArg, mqttAddressArg, mqttPort, mqttQOS);

        } catch (IOException ex) {
            logException(Application.class.getName(), ex);
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
