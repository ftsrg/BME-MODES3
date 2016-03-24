package hu.bme.mit.inf.master.mqtt.client.main;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;

import java.io.IOException;

import hu.bme.mit.inf.master.mqtt.client.network.SectionsMessageHandler;
import hu.bme.mit.inf.master.mqtt.client.network.TurnoutMessageHandler;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class Main {

    public static void main(String[] args) throws Exception {
        try {
            OptionParser parser = new OptionParser();
            parser.accepts("sl", "enable status log [optional]");

            ArgumentAcceptingOptionSpec<String> mqttProtocolArg
                    = parser.accepts("pp",
                            "MQTT Broker Protocol [optional, default = tcp]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> mqttPortArg
                    = parser.accepts("p",
                            "MQTT Broker Port [optional, default = 1883]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<Integer> mqttQOSArg
                    = parser.accepts("q",
                            "MQTT Broker QOS [optional, default = 1 (at least once); possible values: 0 - at most once, 2 - exactly once]")
                    .withRequiredArg().ofType(Integer.class);

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);

            Integer mqttPort = getParameterIntegerValue(parsed,
                    mqttPortArg, "-p");
            Integer mqttQOS = getParameterIntegerValue(parsed,
                    mqttQOSArg, "-q");

            boolean enableStatusLog = parsed.has("sl");
            setStatusLogEnabled(enableStatusLog);

            MQTTConfiguration config = createMQTTConfiguration(parsed,
                    mqttProtocolArg, mqttPort, mqttQOS);

            // start the message handlers for the sections and turnout messages
            MQTTPublisherSubscriber pubsub = new MQTTPublisherSubscriber(config);
            new SectionsMessageHandler(pubsub);
            new TurnoutMessageHandler(pubsub);

        } catch (IOException ex) {
            logException(Main.class.getName(), ex);
        }

        while (true) {
            Thread.sleep(100);
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
            Integer smMQTTPort, Integer smMQTTQOS) {

        MQTTConfiguration conf = new MQTTConfiguration();

        if (parsed.has(smMQTTProtocolArg)) {
            conf.setProtocol(parsed.valueOf(smMQTTProtocolArg));
        }
        if (smMQTTPort != null) {
            conf.setPort(smMQTTPort);
        }
        if (smMQTTQOS != null) {
            conf.setQOS(smMQTTQOS);
        }

        return conf;
    }

}
