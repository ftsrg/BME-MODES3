package hu.bme.mit.inf.yakindu.sc.normal.control.controller;

import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x81;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x82;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x83;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x84;
import static hu.bme.mit.inf.yakindu.sc.normal.control.controller.StatemachineInitializer.initialize0x85;
import static hu.bme.mit.inf.yakindu.sc.normal.control.trace.StatemachineTraceBuilder.setDefaultSavePath;
import static hu.bme.mit.inf.yakindu.sc.normal.control.transmitter.CommunicationConfiguration.setKvcontrolOccupancyMQTTConfiguration;
import static hu.bme.mit.inf.yakindu.sc.normal.control.transmitter.CommunicationConfiguration.setKvcontrolSectionMQTTConfiguration;
import static hu.bme.mit.inf.yakindu.sc.normal.control.transmitter.CommunicationConfiguration.setKvcontrolTurnoutMQTTConfiguration;
import static hu.bme.mit.inf.yakindu.sc.normal.control.transmitter.CommunicationConfiguration.setStateMachineMQTTConfiguration;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import hu.bme.mit.inf.yakindu.sc.normal.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.yakindu.sc.normal.control.transmitter.CommunicationConfiguration;
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
            final String defaultSectionTopic = "modes3/kvcontrol/section";
            final String defaultTurnoutTopic = "modes3/kvcontrol/turnout";
            final String defaultOccupancyTopic = "modes3/kvcontrol/soc";

            OptionParser parser = new OptionParser();
            parser.accepts("sl", "enable status log [optional]");

            ArgumentAcceptingOptionSpec<String> traceLogArg = parser
                    .accepts("tp", "trace log save path [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> turnoutIdArg = parser
                    .accepts("ti",
                            "ID of the turnout to be simulated [optional]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> kvMQTTProtocolArg
                    = parser.accepts("kvbpp",
                            "KVControl MQTT Broker Protocol [optional, default = tcp]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> kvMQTTAddressArg
                    = parser.accepts("kvba",
                            "KVControl MQTT Broker Address [optional, default = localhost]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> kvMQTTPortArg
                    = parser.accepts("kvbp",
                            "KVControl MQTT Broker Port [optional, default = 1883]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<Integer> kvMQTTQOSArg
                    = parser.accepts("kvbq",
                            "KVControl MQTT Broker QOS [optional, default = 1 (at least once); possible values: 0 - at most once, 2 - exactly once]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> smMQTTProtocolArg
                    = parser.accepts("smbpp",
                            "StateMachine MQTT Broker Protocol [optional, default = tcp]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> smMQTTAddressArg
                    = parser.accepts("smba",
                            "StateMachine MQTT Broker Address [optional, default = localhost]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> smMQTTPortArg
                    = parser.accepts("smbp",
                            "StateMachine MQTT Broker Port [optional, default = 1883]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<Integer> smMQTTQOSArg
                    = parser.accepts("smbq",
                            "StateMachine MQTT Broker QOS [optional, default = 1 (at least once); possible values: 0 - at most once, 2 - exactly once]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> smMQTTTopicArg
                    = parser.accepts("smbt",
                            "StateMachine MQTT Broker Topic [optional, default = modes3/yakindu]")
                    .withRequiredArg().ofType(String.class);

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);
            if (!parsed.has(turnoutIdArg)) {
                return;
            }

            Integer turnoutId = getParameterIntegerValue(parsed, turnoutIdArg,
                    "-ti");
            Integer kvMQTTPort = getParameterIntegerValue(parsed,
                    kvMQTTPortArg, "-kvbp");
            Integer kvMQTTQOS = getParameterIntegerValue(parsed,
                    kvMQTTQOSArg, "-kvbq");
            Integer smMQTTPort = getParameterIntegerValue(parsed,
                    smMQTTPortArg, "-smbp");
            Integer smMQTTQOS = getParameterIntegerValue(parsed,
                    smMQTTQOSArg, "-smbq");

            boolean enableStatusLog = parsed.has("sl");

            setLoggingPreferences(traceLogArg, parsed, enableStatusLog);

            setKVMQTTPreferences(parsed, kvMQTTProtocolArg, kvMQTTAddressArg,
                    kvMQTTSectionTopicArg, defaultSectionTopic, "section",
                    kvMQTTPort, kvMQTTQOS);

            setKVMQTTPreferences(parsed, kvMQTTProtocolArg, kvMQTTAddressArg,
                    kvMQTTTurnoutTopicArg, defaultTurnoutTopic, "turnout",
                    kvMQTTPort, kvMQTTQOS);

            setKVMQTTPreferences(parsed, kvMQTTProtocolArg, kvMQTTAddressArg,
                    kvMQTTOccupancyTopicArg, defaultOccupancyTopic, "occupancy",
                    kvMQTTPort, kvMQTTQOS);

            setSMMQTTPreferences(parsed, smMQTTProtocolArg, smMQTTAddressArg,
                    smMQTTTopicArg, smMQTTPort, smMQTTQOS);

            initializeAndStartStateMachine(turnoutId);

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
            ArgumentAcceptingOptionSpec<String> topicArg,
            Integer port, Integer qos, String topic) {
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

    private static void setKVMQTTPreferences(
            OptionSet parsed,
            ArgumentAcceptingOptionSpec<String> kvMQTTProtocolArg,
            ArgumentAcceptingOptionSpec<String> kvMQTTAddressArg,
            ArgumentAcceptingOptionSpec<String> kvMQTTTopicArg,
            String defaultTopicName, String target, Integer kvMQTTPort,
            Integer kvMQTTQOS) {

        MQTTConfiguration conf = createConfiguration(parsed, kvMQTTProtocolArg,
                kvMQTTAddressArg, kvMQTTTopicArg, kvMQTTPort, kvMQTTQOS,
                defaultTopicName);

        switch (target) {
            case "section":
                setKvcontrolSectionMQTTConfiguration(conf);
                break;
            case "turnout":
                setKvcontrolTurnoutMQTTConfiguration(conf);
                break;
            case "occupancy":
                setKvcontrolOccupancyMQTTConfiguration(conf);
                break;
        }
    }

    private static void setSMMQTTPreferences(
            OptionSet parsed,
            ArgumentAcceptingOptionSpec<String> smMQTTProtocolArg,
            ArgumentAcceptingOptionSpec<String> smMQTTAddressArg,
            ArgumentAcceptingOptionSpec<String> smMQTTTopicArg,
            Integer smMQTTPort, Integer smMQTTQOS) {

        MQTTConfiguration conf = createConfiguration(parsed, smMQTTProtocolArg,
                smMQTTAddressArg, smMQTTTopicArg, smMQTTPort, smMQTTQOS,
                "modes3/yakindu");

        setStateMachineMQTTConfiguration(conf);
    }

    private static void initializeAndStartStateMachine(Integer turnoutId) throws MqttException {
    	YakinduSMConfiguration conf = null;
    	
    	MQTTConfiguration kvcontrolMQTTConf = CommunicationConfiguration.getKvcontrolOccupancyMQTTConfiguration();
        MQTTPublisherSubscriber mqtt = new MQTTPublisherSubscriber(kvcontrolMQTTConf);

        switch (turnoutId) {
            case 0x81:
                conf = initialize0x81(mqtt);
                break;
            case 0x82:
                conf = initialize0x82(mqtt);
                break;
            case 0x83:
                conf = initialize0x83(mqtt);
                break;
            case 0x84:
                conf = initialize0x84(mqtt);
                break;
            case 0x85:
                conf = initialize0x85(mqtt);
                break;
            default:
                break;
        }

        YakinduSMRunner yakinduController = new YakinduSMRunner(mqtt, conf);
        yakinduController.start();
    }

}
