package hu.bme.mit.inf.kv.yakindu.control.controller;

import java.io.IOException;

import hu.bme.mit.inf.kv.yakindu.control.helper.SimpleLogger;
import hu.bme.mit.inf.kv.yakindu.control.sm.TraceableStatemachine;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.TurnoutEventListener;
import hu.bme.mit.inf.kv.yakindu.control.transmitter.CommunicationConfiguration;
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

            Integer kvControlPort = null;
            Integer kvControlBPExtensionPort = null;

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

            initializeAndStartStatemachines(traceLogFirstTurnoutArg,
                    traceLogSecondTurnoutArg, parsed);

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
