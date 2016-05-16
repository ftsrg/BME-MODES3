package hu.bme.mit.inf.master.mqtt.client.main;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;

import java.io.IOException;

import hu.bme.mit.inf.master.mqtt.client.network.SectionsMessageHandler;
import hu.bme.mit.inf.master.mqtt.client.network.TurnoutMessageHandler;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * The application that is uploaded to the embedded controllers. It manages the
 * referred turnout and the connecting sections.
 *
 * The actual pinout configuration is located at
 * src/main/resources/conf/settings.json.
 *
 * For details see
 * {@link hu.bme.mit.inf.master.bbb.strategy.ExpanderSectionController} and
 * {@link hu.bme.mit.inf.master.bbb.strategy.ExpanderTurnoutController} and
 * {@link hu.bme.mit.inf.master.bbb.conf.ExpanderControllerConfiguration}
 * classes.
 *
 * @author benedekh
 */
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

            Integer mqttPort = getParameterIntegerValue(parsed,
                    mqttPortArg, "-p");
            Integer mqttQOS = getParameterIntegerValue(parsed,
                    mqttQOSArg, "-q");

            boolean enableStatusLog = parsed.has("sl");
            setStatusLogEnabled(enableStatusLog);

            MQTTConfiguration config = createConfiguration(parsed,
                    mqttProtocolArg, mqttAddressArg, mqttPort, mqttQOS);

            // start the message handlers for the sections and turnout messages
            MQTTPublishSubscribeDispatcher sender = new MQTTPublishSubscribeDispatcher(
                    config);
            new SectionsMessageHandler(sender);
            new TurnoutMessageHandler(sender);

        } catch (IOException ex) {
            logException(Main.class.getName(), ex);
        }

        while (true) {
            Thread.sleep(100);
        }
    }

    /**
     * Get the Integer parameter of the respective command-line argument.
     *
     * @param parsed the parsed arguments
     * @param parameter the argument whose parameter should be extracted
     * @param parameterFieldName the name of the argument
     * @return the referred argument's Integer parameter extracted
     * @throws IOException if the parameter cannot be converted to Integer
     */
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

    /**
     * Creates a MQTT Configuration based on the parameters.
     *
     * @param parsed the parsed arguments
     * @param protocolArg the protocol of the MQTT Broker
     * @param addressArg the address of the MQTT Broker
     * @param port the port of the MQTT Broker
     * @param qos the QOS (Quality of Service) of the MQTT Broker
     * @return a new MQTT Configuration
     */
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

}
