package hu.bme.mit.inf.kv.yakindu.control.controller;

import java.io.IOException;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import hu.bme.mit.inf.kv.yakindu.control.sm.TraceableStatemachine;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.TurnoutEventListener;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlAddress;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlBpExtensionAddress;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlBpExtensionPort;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration.setKvControlPort;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import static hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationServer.setCloudIntegrationEnabled;

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
            parser.accepts("ci",
                    "enable cloud integration with Node-RED [optional]");

            ArgumentAcceptingOptionSpec<String> traceLogFirstTurnoutArg = parser
                    .accepts("tp1", "trace log save path for 0x87 [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> traceLogSecondTurnoutArg = parser
                    .accepts("tp2", "trace log save path for 0x86 [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<String> kvControlAddressArg = parser
                    .accepts("a", "kvControlAddress [optional]")
                    .withRequiredArg().ofType(String.class);

            ArgumentAcceptingOptionSpec<Integer> kvControlPortArg = parser.accepts(
                    "p", "kvControlPort [optional]")
                    .withRequiredArg().ofType(Integer.class);

            ArgumentAcceptingOptionSpec<String> kvControlBPExtensionAddressArg = parser
                    .accepts("bpa", "kvControlBPExntensionAddress [optional]").withRequiredArg().ofType(
                            String.class);

            ArgumentAcceptingOptionSpec<Integer> kvControlBPExtensionPortArg = parser
                    .accepts("bpp", "kvControlBPExtensionPort [optional]").withRequiredArg().ofType(
                            Integer.class);

            parser.printHelpOn(System.out);

            OptionSet parsed = parser.parse(args);

            Integer kvControlPort = getParameterIntegerValue(parsed,
                    kvControlPortArg, "-p");
            Integer kvControlBPExtensionPort = getParameterIntegerValue(parsed,
                    kvControlBPExtensionPortArg, "-bpp");

            boolean enableStatusLog = parsed.has("sl");
            boolean enableCloudIntegration = parsed.has("ci");

            setPreferences(kvControlAddressArg, kvControlPortArg,
                    kvControlBPExtensionAddressArg,
                    kvControlBPExtensionPortArg, parsed, enableStatusLog,
                    enableCloudIntegration,
                    kvControlPort, kvControlBPExtensionPort);

            initializeAndStartStatemachines(traceLogFirstTurnoutArg,
                    traceLogSecondTurnoutArg, parsed);

        } catch (IOException ex) {
            SimpleLogger.printErrorMessage(Simulator.class.getName(),
                    ex.getMessage());
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
            OptionSet parsed,
            boolean enableStatusLog, boolean enableCloudIntegration,
            Integer kvControlPort,
            Integer kvControlBPExtensionPort) {

        if (enableStatusLog) {
            SimpleLogger.setStatusLogEnabled(true);
        }
        if (enableCloudIntegration) {
            setCloudIntegrationEnabled(true);
        }
        if (parsed.has(kvControlAddressArg)) {
            setKvControlAddress(parsed.valueOf(kvControlAddressArg));
        }
        if (parsed.has(kvControlPortArg)) {
            setKvControlPort(kvControlPort);
        }
        if (parsed.has(kvControlBPExtensionAddressArg)) {
            setKvControlBpExtensionAddress(parsed
                    .valueOf(kvControlBPExtensionAddressArg));
        }
        if (parsed.has(kvControlBPExtensionPortArg)) {
            setKvControlBpExtensionPort(kvControlBPExtensionPort);
        }
    }

    private static void initializeAndStartStatemachines(
            ArgumentAcceptingOptionSpec<String> traceLogFirstTurnoutArg,
            ArgumentAcceptingOptionSpec<String> traceLogSecondTurnoutArg,
            OptionSet parsed) {

        KvStatemachine smTurnout135 = new KvStatemachine();
        TraceableStatemachine tsmTurnout135 = new TraceableStatemachine(
                smTurnout135);
        StatemachineInitializer.getInstance().initialize0x87(tsmTurnout135);

        KvStatemachine smTurnout134 = new KvStatemachine();
        TraceableStatemachine tsmTurnout134 = new TraceableStatemachine(
                smTurnout134);
        StatemachineInitializer.getInstance().initialize0x86(tsmTurnout134);

        YakinduKVController turnout135Controller = new YakinduKVController(
                tsmTurnout135,
                parsed.valueOf(traceLogFirstTurnoutArg));
        YakinduKVController turnout134Controller = new YakinduKVController(
                tsmTurnout134,
                parsed.valueOf(traceLogSecondTurnoutArg));

        turnout135Controller.addTurnoutEventListener(new TurnoutEventListener(
                turnout134Controller));
        turnout134Controller.addTurnoutEventListener(new TurnoutEventListener(
                turnout135Controller));

        startStateMachines(turnout135Controller, turnout134Controller);
    }

    private static void startStateMachines(
            final YakinduKVController turnout135Controller,
            final YakinduKVController turnout134Controller) {
        Thread turnout135 = new Thread() {
            @Override
            public void run() {
                turnout135Controller.start();
            }
        };

        Thread turnout134 = new Thread() {
            @Override
            public void run() {
                turnout134Controller.start();
            }
        };

        turnout135.start();
        if (turnout135.isAlive()) {
            turnout134.start();
        }
    }
}
