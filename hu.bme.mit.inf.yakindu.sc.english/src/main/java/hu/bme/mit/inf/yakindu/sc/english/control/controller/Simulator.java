package hu.bme.mit.inf.yakindu.sc.english.control.controller;

import static hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer.initialize0x86;
import static hu.bme.mit.inf.yakindu.sc.english.control.controller.StatemachineInitializer.initialize0x87;
import java.io.IOException;

import hu.bme.mit.inf.yakindu.sc.english.control.helper.YakinduSMConfiguration;
import static hu.bme.mit.inf.yakindu.sc.english.control.trace.StatemachineTraceBuilder.setDefaultSavePath;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.setKvControlAddress;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.setKvControlPort;
import static hu.bme.mit.inf.yakindu.sc.english.control.transmitter.CommunicationConfiguration.setStateMachineMQTTConfiguration;
import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.logException;
import static hu.bme.mit.inf.mqtt.common.util.logging.LogManager.setStatusLogEnabled;
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

            ArgumentAcceptingOptionSpec<String> kvControlAddressArg = parser
                    .accepts("a", "kvControlAddress [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> kvControlPortArg = parser.accepts(
                    "p", "kvControlPort [optional]")
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
