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

    public void initialize0x81(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x81);
        sm.getSCITurnout().setTurnoutSectionId(0x01);

        this.setSections(sm, -1, 0x0D, 0x09);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.TOP, Direction.DIVERGENT, 0x87),
                new RemoteTurnout(Direction.DIVERGENT, Direction.TOP, 0x83)));

        sm.getSCITurnout().setRemTopIsPrior(true);
        sm.getSCITurnout().setRemDivergentIsPrior(false);
        sm.getSCITurnout().setRemStraightIsPrior(true);

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    public void initialize0x82(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x82);
        sm.getSCITurnout().setTurnoutSectionId(0x02);

        this.setSections(sm, 0x0C, 0x0F, -1);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.TOP, Direction.STRAIGHT, 0x84),
                new RemoteTurnout(Direction.DIVERGENT, Direction.DIVERGENT, 0x84),
                new RemoteTurnout(Direction.STRAIGHT, Direction.STRAIGHT, 0x87)));

        sm.getSCITurnout().setRemTopIsPrior(false);
        sm.getSCITurnout().setRemDivergentIsPrior(false);
        sm.getSCITurnout().setRemStraightIsPrior(true);

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    public void initialize0x83(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x83);
        sm.getSCITurnout().setTurnoutSectionId(0x03);

        this.setSections(sm, 0x08, 0x17, 0x0B);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.TOP, Direction.DIVERGENT, 0x81),
                new RemoteTurnout(Direction.DIVERGENT, Direction.DIVERGENT, 0x85),
                new RemoteTurnout(Direction.STRAIGHT, Direction.STRAIGHT, 0x85)));

        sm.getSCITurnout().setRemTopIsPrior(true);
        sm.getSCITurnout().setRemDivergentIsPrior(true);
        sm.getSCITurnout().setRemStraightIsPrior(true);

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    public void initialize0x84(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x84);
        sm.getSCITurnout().setTurnoutSectionId(0x05);

        this.setSections(sm, -1, 0x11, 0x0A);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.TOP, Direction.DIVERGENT, 0x86),
                new RemoteTurnout(Direction.DIVERGENT, Direction.DIVERGENT, 0x82),
                new RemoteTurnout(Direction.STRAIGHT, Direction.TOP, 0x82)));

        sm.getSCITurnout().setRemTopIsPrior(true);
        sm.getSCITurnout().setRemDivergentIsPrior(true);
        sm.getSCITurnout().setRemStraightIsPrior(true);

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    public void initialize0x85(ITraceableStatemachine sm) {
        sm.init();
        sm.getSCITurnout().setTurnoutId(0x85);
        sm.getSCITurnout().setTurnoutSectionId(0x06);

        this.setSections(sm, -1, 0x14, 0x13);

        Set<RemoteTurnout> remoteTurnouts = new HashSet<>(Arrays.asList(
                new RemoteTurnout(Direction.TOP, Direction.STRAIGHT, 0x86),
                new RemoteTurnout(Direction.DIVERGENT, Direction.DIVERGENT, 0x83),
                new RemoteTurnout(Direction.STRAIGHT, Direction.STRAIGHT, 0x83)));

        sm.getSCITurnout().setRemTopIsPrior(true);
        sm.getSCITurnout().setRemDivergentIsPrior(false);
        sm.getSCITurnout().setRemStraightIsPrior(false);

        sm.getSCISections().getListeners().add(new RemoteSectionEventListener(
                remoteTurnouts));
    }

    private void setSections(IKvStatemachine sm, int topId, int divergentId,
            int straightId) {
        sm.getSCISectionTop().setSectionId(topId);
        sm.getSCISectionDivergent().setSectionId(divergentId);
        sm.getSCISectionStraight().setSectionId(straightId);
    }

    private StatemachineInitializer() {

    }

}
