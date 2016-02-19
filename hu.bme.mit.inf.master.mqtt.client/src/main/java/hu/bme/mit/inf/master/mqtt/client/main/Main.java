package hu.bme.mit.inf.master.mqtt.client.main;

import hu.bme.mit.inf.master.mqtt.client.network.MessageHandler;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
import java.io.IOException;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class Main {

    public static void main(String[] args) {
        try {
            OptionParser parser = new OptionParser();
            parser.accepts("sl", "enable status log [optional]");

            ArgumentAcceptingOptionSpec<String> mqttProtocolArg
                    = parser.accepts("pp",
                            "MQTT Broker Protocol [optional, default = tcp]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> mqttAddressArg
                    = parser.accepts("a",
                            "MQTT Broker Address [optional, default = localhost]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> mqttPortArg
                    = parser.accepts("p",
                            "MQTT Broker Port [optional, default = 1883]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<Integer> mqttQOSArg
                    = parser.accepts("q",
                            "MQTT Broker QOS [optional, default = 1 (at least once); possible values: 0 - at most once, 2 - exactly once]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> mqttTopicArg
                    = parser.accepts("t",
                            "MQTT Broker Topic [optional, default = modes3/kvcontrol]")
                    .withRequiredArg().ofType(String.class);

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);

            Integer mqttPort = getParameterIntegerValue(parsed,
                    mqttPortArg, "-p");
            Integer mqttQOS = getParameterIntegerValue(parsed,
                    mqttQOSArg, "-q");

            boolean enableStatusLog = parsed.has("sl");
            setStatusLogEnabled(enableStatusLog);

            MQTTConfiguration conf = createMQTTConfiguration(parsed,
                    mqttProtocolArg, mqttAddressArg,
                    mqttTopicArg, mqttPort, mqttQOS);

            startMessageHandler(conf);

        } catch (IOException ex) {
            logException(Main.class.getName(), ex);
        }
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

    private static MQTTConfiguration createMQTTConfiguration(
            OptionSet parsed,
            ArgumentAcceptingOptionSpec<String> smMQTTProtocolArg,
            ArgumentAcceptingOptionSpec<String> smMQTTAddressArg,
            ArgumentAcceptingOptionSpec<String> smMQTTTopicArg,
            Integer smMQTTPort, Integer smMQTTQOS) {

        MQTTConfiguration conf = new MQTTConfiguration(
                "modes3/kvcontrol");

        if (parsed.has(smMQTTProtocolArg)) {
            conf.setProtocol(parsed.valueOf(smMQTTProtocolArg));
        }
        if (parsed.has(smMQTTAddressArg)) {
            conf.setAddress(parsed.valueOf(smMQTTAddressArg));
        }
        if (parsed.has(smMQTTTopicArg)) {
            conf.setTopic(parsed.valueOf(smMQTTTopicArg));
        }
        if (smMQTTPort != null) {
            conf.setPort(smMQTTPort);
        }
        if (smMQTTQOS != null) {
            conf.setQOS(smMQTTQOS);
        }

        return conf;
    }

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    private static void startMessageHandler(MQTTConfiguration conf) {
        new MessageHandler(conf);
    }

}
