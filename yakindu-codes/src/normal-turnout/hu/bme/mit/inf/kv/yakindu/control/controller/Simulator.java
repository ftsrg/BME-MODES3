package hu.bme.mit.inf.kv.yakindu.control.controller;

import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x81;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x82;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x83;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x84;
import static hu.bme.mit.inf.kv.yakindu.control.controller.StatemachineInitializer.initialize0x85;
import static hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger.printErrorMessage;
import static hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger.setStatusLogEnabled;
import hu.bme.mit.inf.kv.yakindu.control.helper.YakinduSMConfiguration;
import static hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineTraceBuilder.setDefaultSavePath;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlAddress;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlBpExtensionAddress;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlBpExtensionPort;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlPort;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationServer.setCloudIntegrationEnabled;
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
            parser.accepts("ci",
                    "enable cloud integration with Node-RED [optional]");

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

            ArgumentAcceptingOptionSpec<String> kvControlBPExtensionAddressArg
                    = parser.accepts("bpa",
                            "kvControlBPExntensionAddress [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> kvControlBPExtensionPortArg
                    = parser.accepts("bpp",
                            "kvControlBPExtensionPort [optional]")
                    .withRequiredArg().ofType(Integer.class);

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);
            if (!parsed.has(turnoutIdArg)) {
                return;
            }

            Integer turnoutId = getParameterIntegerValue(parsed, turnoutIdArg,
                    "-ti");
            Integer kvControlPort = getParameterIntegerValue(parsed,
                    kvControlPortArg, "-p");
            Integer kvControlBPExtensionPort = getParameterIntegerValue(parsed,
                    kvControlBPExtensionPortArg, "-bpp");

            boolean enableStatusLog = parsed.has("sl");
            boolean enableCloudIntegration = parsed.has("ci");

            setPreferences(kvControlAddressArg, kvControlPortArg,
                    kvControlBPExtensionAddressArg,
                    kvControlBPExtensionPortArg, traceLogArg, parsed,
                    enableStatusLog,
                    enableCloudIntegration,
                    kvControlPort, kvControlBPExtensionPort);

            initializeAndStartStateMachine(turnoutId);

        } catch (IOException ex) {
            printErrorMessage(Simulator.class.getName(), ex.getMessage());
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
            ArgumentAcceptingOptionSpec<String> kvControlBPExtensionAddressArg,
            ArgumentAcceptingOptionSpec<Integer> kvControlBPExtensionPortArg,
            ArgumentAcceptingOptionSpec<String> traceLogArg,
            OptionSet parsed,
            boolean enableStatusLog, boolean enableCloudIntegration,
            Integer kvControlPort,
            Integer kvControlBPExtensionPort) {

        if (enableStatusLog) {
            setStatusLogEnabled(true);
        }
        if (enableCloudIntegration) {
            setCloudIntegrationEnabled(enableStatusLog);
        }
        if (parsed.has(kvControlAddressArg)) {
            setKvControlAddress(parsed.valueOf(kvControlAddressArg));
        }
        if (parsed.has(kvControlPortArg)) {
            setKvControlPort(kvControlPort);
        }
        if (parsed.has(kvControlBPExtensionAddressArg)) {
            setKvControlBpExtensionAddress(parsed.valueOf(
                    kvControlBPExtensionAddressArg));
        }
        if (parsed.has(kvControlBPExtensionPortArg)) {
            setKvControlBpExtensionPort(kvControlBPExtensionPort);
        }
        if (parsed.has(traceLogArg)) {
            SectionWrapperWithListeners.setTraceLogEnabled(true);
            TurnoutWrapperWithListeners.setTraceLogEnabled(true);
            setDefaultSavePath(parsed.valueOf(traceLogArg));
        }
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
