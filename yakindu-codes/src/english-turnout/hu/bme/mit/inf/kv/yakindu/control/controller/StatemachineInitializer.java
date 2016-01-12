package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kv.yakindu.control.sm.ITraceableStatemachine;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.RemoteSectionEventListener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;

import org.yakindu.scr.kv.IKvStatemachine;

/**
 *
 * @author benedekh
 */
public class StatemachineInitializer {

    private static final StatemachineInitializer instance = new StatemachineInitializer();

    public static StatemachineInitializer getInstance() {
        return instance;
    }

    public void initialize0x86(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x86);
        sm.getSCITurnout().setTurnoutSectionId(0x04);

        this.setSections(sm, 0x10, 0x15);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.DIVERGENT, Direction.TOP, 0x84),
                new RemoteTurnout(Direction.STRAIGHT, Direction.TOP, 0x85)));

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    public void initialize0x87(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x87);
        sm.getSCITurnout().setTurnoutSectionId(0x04);

        this.setSections(sm, 0x0E, 0x16);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.DIVERGENT, Direction.TOP, 0x81),
                new RemoteTurnout(Direction.STRAIGHT, Direction.STRAIGHT, 0x82)));

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    private void setSections(IKvStatemachine sm, int divergentId, int straightId) {
        sm.getSCISectionDivergent().setSectionId(divergentId);
        sm.getSCISectionStraight().setSectionId(straightId);
    }

    private StatemachineInitializer() {

    }

}
