package hu.bme.mit.inf.yakindu.sc.normal.control.controller;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x81;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x82;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x83;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x84;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x85;
import static hu.bme.mit.inf.yakindu.sc.normal.control.trace.StatemachineTraceBuilder.setDefaultSavePath;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.yakindu.sc.normal.control.helper.YakinduSMConfiguration;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * The application which starts the respective turnout's and the connecting
 * sections statemachines and handles the events and messages.
 *
 * @author benedekh
 */
public class Simulator {

    public static final void main(String[] args) throws MqttException {

        try {
            OptionParser parser = new OptionParser();
            parser.accepts("sl", "enable status log [optional]");

            ArgumentAcceptingOptionSpec<String> traceLogArg = parser
                    .accepts("tp", "trace log save path [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> turnoutIdArg = parser
                    .accepts("ti",
                            "ID of the turnout to be simulated [optional]")
                    .withRequiredArg().ofType(Integer.class);

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

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);
            if (!parsed.has(turnoutIdArg)) {
                return;
            }

            Integer turnoutId = getParameterIntegerValue(parsed, turnoutIdArg,
                    "-ti");
            Integer mqttPort = getParameterIntegerValue(parsed,
                    mqttPortArg, "-p");
            Integer mqttQOS = getParameterIntegerValue(parsed,
                    mqttQOSArg, "-q");

            boolean enableStatusLog = parsed.has("sl");

            setLoggingPreferences(traceLogArg, parsed, enableStatusLog);

            MQTTConfiguration conf = createConfiguration(parsed, mqttProtocolArg,
                    mqttAddressArg,
                    mqttPort, mqttQOS);

            initializeAndStartStateMachine(conf, turnoutId);

        } catch (IOException ex) {
            logException(Simulator.class.getName(), ex);
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
     * Sets the logging preferences for the statuses (info messages) and for the
     * statemachines as a trace log.
     *
     * For details see {@link hu.bme.mit.inf.mqtt.common.util.logging} and
     * {@link hu.bme.mit.inf.yakindu.sc.english.control.trace.StatemachineTraceBuilder}.
     *
     * @param traceLogArg if it is set, then trace info will be saved for the
     * statecharts.
     * @param parsed the parsed command-line arguments
     * @param isStatusLogEnabled if it is set, then info messages will be logged
     * (as would be printed to the standard output)
     */
    private static void setLoggingPreferences(
            ArgumentAcceptingOptionSpec<String> traceLogArg,
            OptionSet parsed, boolean isStatusLogEnabled) {

        setStatusLogEnabled(isStatusLogEnabled);

        if (parsed.has(traceLogArg)) {
            SectionWrapperWithListeners.setTraceLogEnabled(true);
            TurnoutWrapperWithListeners.setTraceLogEnabled(true);
            setDefaultSavePath(parsed.valueOf(traceLogArg));
        }
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

    /**
     * Initialize and start statecharts based on the MQTT configuration for the
     * MQTT connection, and the turnout ID.
     *
     * For the initialization details see
     * {@link hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer}.
     *
     * @param mqttConf the configuration data for the MQTT connection.
     * @param turnoutId the ID of the turnout whose and the connecting sections
     * statecharts should be started
     */
    private static void initializeAndStartStateMachine(
            MQTTConfiguration mqttConf, Integer turnoutId) throws MqttException {
        YakinduSMConfiguration smConf = null;

        MQTTPublishSubscribeDispatcher sender = new MQTTPublishSubscribeDispatcher(
                mqttConf);

        switch (turnoutId) {
            case 0x81:
                smConf = initialize0x81(sender);
                break;
            case 0x82:
                smConf = initialize0x82(sender);
                break;
            case 0x83:
                smConf = initialize0x83(sender);
                break;
            case 0x84:
                smConf = initialize0x84(sender);
                break;
            case 0x85:
                smConf = initialize0x85(sender);
                break;
            default:
                break;
        }

        YakinduSMRunner yakinduController = new YakinduSMRunner(sender, smConf);
        yakinduController.start();
    }

}
