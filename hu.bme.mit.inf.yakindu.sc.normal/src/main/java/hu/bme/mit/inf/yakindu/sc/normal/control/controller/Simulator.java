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
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.yakindu.sc.normal.control.helper.YakinduSMConfiguration;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
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

    private static void initializeAndStartStateMachine(
            MQTTConfiguration mqttConf, Integer turnoutId) throws MqttException {
        YakinduSMConfiguration smConf = null;

        MQTTPublisherSubscriber mqtt = new MQTTPublisherSubscriber(mqttConf);
        MQTTPublishSubscribeDispatcher sender = new MQTTPublishSubscribeDispatcher(mqtt);

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
