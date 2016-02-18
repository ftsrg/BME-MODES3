package hu.bme.mit.inf.kv.yakindu.control.controller;

import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x81;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x82;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x83;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x84;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x85;
import hu.bme.mit.inf.kv.yakindu.control.helper.YakinduSMConfiguration;
import static hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineTraceBuilder.setDefaultSavePath;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlAddress;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlPort;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setStateMachineMQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
import java.io.IOException;
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

            ArgumentAcceptingOptionSpec<Integer> turnoutIdArg = parser
                    .accepts("ti",
                            "ID of the turnout to be simulated [optional]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> kvControlAddressArg = parser
                    .accepts("a", "kvControlAddress [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> kvControlPortArg = parser
                    .accepts("p", "kvControlPort [optional]")
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
            Integer kvControlPort = getParameterIntegerValue(parsed,
                    kvControlPortArg, "-p");
            Integer smMQTTPort = getParameterIntegerValue(parsed,
                    smMQTTPortArg, "-smbp");
            Integer smMQTTQOS = getParameterIntegerValue(parsed,
                    smMQTTQOSArg, "-smbq");

            boolean enableStatusLog = parsed.has("sl");

            setPreferences(kvControlAddressArg, kvControlPortArg, traceLogArg,
                    parsed, enableStatusLog, kvControlPort);

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

    private static void setPreferences(
            ArgumentAcceptingOptionSpec<String> kvControlAddressArg,
            ArgumentAcceptingOptionSpec<Integer> kvControlPortArg,
            ArgumentAcceptingOptionSpec<String> traceLogArg,
            OptionSet parsed, boolean isStatusLogEnabled, Integer kvControlPort) {

        setStatusLogEnabled(isStatusLogEnabled);

        if (parsed.has(kvControlAddressArg)) {
            setKvControlAddress(parsed.valueOf(kvControlAddressArg));
        }
        if (parsed.has(kvControlPortArg)) {
            setKvControlPort(kvControlPort);
        }
        if (parsed.has(traceLogArg)) {
            SectionWrapperWithListeners.setTraceLogEnabled(true);
            TurnoutWrapperWithListeners.setTraceLogEnabled(true);
            setDefaultSavePath(parsed.valueOf(traceLogArg));
        }
    }

    private static void setSMMQTTPreferences(
            OptionSet parsed,
            ArgumentAcceptingOptionSpec<String> smMQTTProtocolArg,
            ArgumentAcceptingOptionSpec<String> smMQTTAddressArg,
            ArgumentAcceptingOptionSpec<String> smMQTTTopicArg,
            Integer smMQTTPort, Integer smMQTTQOS) {

        MQTTConfiguration conf = new MQTTConfiguration(
                "modes3/yakindu");

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

        setStateMachineMQTTConfiguration(conf);
    }

    private static void initializeAndStartStateMachine(Integer turnoutId) {
        YakinduSMConfiguration conf = null;

        switch (turnoutId) {
            case 0x81:
                conf = initialize0x81();
                break;
            case 0x82:
                conf = initialize0x82();
                break;
            case 0x83:
                conf = initialize0x83();
                break;
            case 0x84:
                conf = initialize0x84();
                break;
            case 0x85:
                conf = initialize0x85();
                break;
            default:
                break;
        }

        YakinduSMRunner yakinduController = new YakinduSMRunner(conf);
        yakinduController.start();
    }

}
