package hu.bme.mit.inf.yakindu.sc.english.control.controller;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.OccupancyRequestSender;
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender;
import static hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer.initialize0x86;
import static hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer.initialize0x87;
import java.io.IOException;

import hu.bme.mit.inf.yakindu.sc.english.control.helper.YakinduSMConfiguration;
import static hu.bme.mit.inf.yakindu.sc.english.control.trace.StatemachineTraceBuilder.setDefaultSavePath;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
import hu.bme.mit.inf.yakindu.mqtt.client.receiver.DistributedMessageReceiver;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

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

            Integer mqttPort = getParameterIntegerValue(parsed,
                    mqttPortArg, "-p");
            Integer mqttQOS = getParameterIntegerValue(parsed,
                    mqttQOSArg, "-q");

            boolean enableStatusLog = parsed.has("sl");

            setLoggingPreferences(traceLogArg, parsed, enableStatusLog);

            MQTTConfiguration conf = createConfiguration(parsed, mqttProtocolArg,
                    mqttAddressArg,
                    mqttPort, mqttQOS);
            initializeAndStartStatemachines(conf);

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

    private static void initializeAndStartStatemachines(MQTTConfiguration conf) {
        MQTTPublishSubscribeDispatcher sender = new MQTTPublishSubscribeDispatcher(
                conf);

        YakinduSMConfiguration sm134ConfObj = initialize0x86(sender);
        YakinduSMConfiguration sm135ConfObj = initialize0x87(sender);

        // connect turnouts to each other
        sm134ConfObj.getTurnoutEventListener().setOtherHalfOfTurnoutSM(
                sm135ConfObj.getTurnoutStatemachine());
        sm135ConfObj.getTurnoutEventListener().setOtherHalfOfTurnoutSM(
                sm134ConfObj.getTurnoutStatemachine());

        OccupancyRequestSender occupancyRequester = new OccupancyRequestSender(
                sender);
        TurnoutRequestSender turnoutRequester = new TurnoutRequestSender(sender);
        DistributedMessageReceiver messageReceiver = new DistributedMessageReceiver(
                sender);

        YakinduSMRunner turnout135Runner = new YakinduSMRunner(sender,
                sm135ConfObj, occupancyRequester, turnoutRequester,
                messageReceiver);
        YakinduSMRunner turnout134Runner = new YakinduSMRunner(sender,
                sm134ConfObj, occupancyRequester, turnoutRequester,
                messageReceiver);

        turnout135Runner.start();
        turnout134Runner.start();
    }
}
