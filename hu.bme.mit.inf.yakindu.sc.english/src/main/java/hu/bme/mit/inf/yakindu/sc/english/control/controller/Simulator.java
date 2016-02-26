package hu.bme.mit.inf.yakindu.sc.english.control.controller;

import static hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer.initialize0x86;
import static hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer.initialize0x87;
import java.io.IOException;

import hu.bme.mit.inf.yakindu.sc.english.control.helper.YakinduSMConfiguration;
import static hu.bme.mit.inf.yakindu.sc.english.control.trace.StatemachineTraceBuilder.setDefaultSavePath;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.setStateMachineMQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.setKvcontrolMQTTConfiguration;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

/**
 *
 * @author benedekh
 */
public class Simulator {

    public static final void main(String[] args) {
        try {
            OptionParser parser = new OptionParser();
            parser.accepts("sl", "enable status log [optional]");

            ArgumentAcceptingOptionSpec<String> traceLogArg = parser
                    .accepts("tp", "trace log save path [optional]")
                    .withRequiredArg().ofType(String.class);

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

            ArgumentAcceptingOptionSpec<String> kvMQTTTopicArg
                    = parser.accepts("kvbt",
                            "KVControl MQTT Broker Topic [optional, default = modes3/kvcontrol]")
                    .withRequiredArg().ofType(String.class);

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
                    kvMQTTTopicArg, kvMQTTPort, kvMQTTQOS);

            setSMMQTTPreferences(parsed, smMQTTProtocolArg, smMQTTAddressArg,
                    smMQTTTopicArg, smMQTTPort, smMQTTQOS);

            initializeAndStartStatemachines();

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
        MQTTConfiguration conf = new MQTTConfiguration(
                topic);
        if (parsed.has(protocolArg)) {
            conf.setProtocol(parsed.valueOf(protocolArg));
        }
        if (parsed.has(addressArg)) {
            conf.setAddress(parsed.valueOf(addressArg));
        }
        if (parsed.has(topicArg)) {
            conf.setTopic(parsed.valueOf(topicArg));
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
            Integer kvMQTTPort, Integer kvMQTTQOS) {

        MQTTConfiguration conf = createConfiguration(parsed, kvMQTTProtocolArg,
                kvMQTTAddressArg, kvMQTTTopicArg, kvMQTTPort, kvMQTTQOS,
                "modes3/kvcontrol");

        setKvcontrolMQTTConfiguration(conf);
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

    private static void initializeAndStartStatemachines() {
        YakinduSMConfiguration sm134ConfObj = initialize0x86();
        YakinduSMConfiguration sm135ConfObj = initialize0x87();

        // connect turnouts to each other
        sm134ConfObj.getTurnoutEventListener().setOtherHalfOfTurnoutSM(
                sm135ConfObj.getTurnoutStatemachine());
        sm135ConfObj.getTurnoutEventListener().setOtherHalfOfTurnoutSM(
                sm134ConfObj.getTurnoutStatemachine());

        YakinduSMRunner turnout135Runner = new YakinduSMRunner(sm135ConfObj);
        YakinduSMRunner turnout134Runner = new YakinduSMRunner(sm134ConfObj);

        turnout135Runner.start();
        turnout134Runner.start();
    }
}
