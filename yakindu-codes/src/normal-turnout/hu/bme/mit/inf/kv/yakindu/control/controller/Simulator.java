package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import hu.bme.mit.inf.kv.yakindu.control.sm.TraceableStatemachine;
import hu.bme.mit.inf.kv.yakindu.control.trace.StatemachineTraceBuilder;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration;
import java.io.IOException;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

import org.yakindu.scr.kv.KvStatemachine;

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

            Integer turnoutId = null;
            Integer kvControlPort = null;
            Integer kvControlBPExtensionPort = null;

            if (parsed.has(turnoutIdArg)) {
                try {
                    turnoutId = parsed.valueOf(turnoutIdArg);
                } catch (joptsimple.OptionException ex) {
                    throw new IOException(
                            "Please use a number for the -ti parameter.");
                }
            }
            if (parsed.has(kvControlPortArg)) {
                try {
                    kvControlPort = parsed.valueOf(kvControlPortArg);
                } catch (joptsimple.OptionException ex) {
                    throw new IOException(
                            "Please use a number for the -p parameter.");
                }
            }
            if (parsed.has(kvControlBPExtensionPortArg)) {
                try {
                    kvControlBPExtensionPort = parsed.valueOf(
                            kvControlBPExtensionPortArg);
                } catch (joptsimple.OptionException ex) {
                    throw new IOException(
                            "Please use a number for the -bpp parameter.");
                }
            }

            boolean enableStatusLog = parsed.has("sl");

            setPreferences(kvControlAddressArg, kvControlPortArg,
                    kvControlBPExtensionAddressArg,
                    kvControlBPExtensionPortArg, parsed, enableStatusLog,
                    kvControlPort, kvControlBPExtensionPort);

            initializeAndStartStateMachine(traceLogArg, turnoutId, parsed);

        } catch (IOException ex) {
            SimpleLogger.printErrorMessage(Simulator.class.getName(),
                    ex.getMessage());
        }
    }

    private static void setPreferences(
            ArgumentAcceptingOptionSpec<String> kvControlAddressArg,
            ArgumentAcceptingOptionSpec<Integer> kvControlPortArg,
            ArgumentAcceptingOptionSpec<String> kvControlBPExtensionAddressArg,
            ArgumentAcceptingOptionSpec<Integer> kvControlBPExtensionPortArg,
            OptionSet parsed,
            boolean enableStatusLog, Integer kvControlPort,
            Integer kvControlBPExtensionPort) {

        if (enableStatusLog) {
            SimpleLogger.setStatusLogEnabled(true);
        }
        if (parsed.has(kvControlAddressArg)) {
            CommunicationConfiguration.setKvControlAddress(parsed.valueOf(
                    kvControlAddressArg));
        }
        if (parsed.has(kvControlPortArg)) {
            CommunicationConfiguration.setKvControlPort(kvControlPort);
        }
        if (parsed.has(kvControlBPExtensionAddressArg)) {
            CommunicationConfiguration.setKvControlBpExtensionAddress(parsed
                    .valueOf(kvControlBPExtensionAddressArg));
        }
        if (parsed.has(kvControlBPExtensionPortArg)) {
            CommunicationConfiguration.setKvControlBpExtensionPort(
                    kvControlBPExtensionPort);
        }
    }

    private static void initializeAndStartStateMachine(
            ArgumentAcceptingOptionSpec<String> traceLogArg,
            Integer turnoutId, OptionSet parsed) {

        KvStatemachine sm = new KvStatemachine();
        TraceableStatemachine statemachine = new TraceableStatemachine(sm);

        switch (turnoutId) {
            case 0x81:
                StatemachineInitializer.getInstance().initialize0x81(
                        statemachine);
                break;
            case 0x82:
                StatemachineInitializer.getInstance().initialize0x82(
                        statemachine);
                break;
            case 0x83:
                StatemachineInitializer.getInstance().initialize0x83(
                        statemachine);
                break;
            case 0x84:
                StatemachineInitializer.getInstance().initialize0x84(
                        statemachine);
                break;
            case 0x85:
                StatemachineInitializer.getInstance().initialize0x85(
                        statemachine);
                break;
            default:
                break;
        }

        if (parsed.has(traceLogArg)) {
            YakinduKVController.setTraceLogEnabled(true);
            StatemachineTraceBuilder.setDefaultSavePath(
                    parsed.valueOf(traceLogArg));
        }

        YakinduKVController yakinduController = new YakinduKVController(
                statemachine);

        yakinduController.start();
    }
}
