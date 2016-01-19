package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kv.yakindu.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;
import hu.bme.mit.inf.kv.yakindu.control.sm.Section;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.SectionEventListener;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.TurnoutEventListener;

import java.util.Arrays;
import java.util.Set;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;
import static hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.DIVERGENT;
import static hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.STRAIGHT;
import static hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.TOP;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import org.yakindu.scr.section.ISectionStatemachine;

import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

/**
 *
 * @author benedekh
 */
public class StatemachineInitializer {

    public static YakinduSMConfiguration initialize0x81() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x81;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x01);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x0D;
        int strSectionID = 0x09;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                strSectionID, turnoutStatemachine);

        Section divSection = new Section(divSectionID, divSectionSM);
        Section strSection = new Section(strSectionID, strSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(divSection,
                strSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(DIVERGENT, divSectionSM);
        localSections.put(STRAIGHT, strSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(TOP, new RemoteTurnout(TOP, DIVERGENT, 0x87));
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, TOP, 0x83));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x82() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x82;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x02);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int topSectionID = 0x0C;
        int divSectionID = 0x0F;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine);
        SectionWrapperWithListeners topSectionSM = createSectionStatemachine(
                topSectionID, turnoutStatemachine);

        Section divSection = new Section(divSectionID, divSectionSM);
        Section topSection = new Section(topSectionID, topSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(divSection,
                topSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(DIVERGENT, divSectionSM);
        localSections.put(TOP, topSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(TOP, new RemoteTurnout(TOP, STRAIGHT, 0x84));
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, DIVERGENT,
                0x84));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, STRAIGHT, 0x87));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x83() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x83;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x03);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int topSectionID = 0x08;
        int divSectionID = 0x17;
        int strSectionID = 0x0B;

        SectionWrapperWithListeners topSectionSM = createSectionStatemachine(
                topSectionID, turnoutStatemachine);
        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                strSectionID, turnoutStatemachine);

        Section topSection = new Section(topSectionID, topSectionSM);
        Section divSection = new Section(divSectionID, divSectionSM);
        Section strSection = new Section(strSectionID, strSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(topSection,
                divSection, strSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(TOP, topSectionSM);
        localSections.put(DIVERGENT, divSectionSM);
        localSections.put(STRAIGHT, strSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(TOP, new RemoteTurnout(TOP, DIVERGENT, 0x81));
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, DIVERGENT,
                0x85));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, STRAIGHT, 0x85));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x84() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x84;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x05);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x11;
        int strSectionID = 0x0A;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                strSectionID, turnoutStatemachine);

        Section divSection = new Section(divSectionID, divSectionSM);
        Section strSection = new Section(strSectionID, strSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(divSection,
                strSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(DIVERGENT, divSectionSM);
        localSections.put(STRAIGHT, strSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(TOP, new RemoteTurnout(TOP, DIVERGENT, 0x86));
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, DIVERGENT,
                0x82));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, TOP, 0x82));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x85() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x85;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x06);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x14;
        int strSectionID = 0x13;

        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                strSectionID, turnoutStatemachine);
        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                divSectionID, turnoutStatemachine);

        Section strSection = new Section(strSectionID, strSectionSM);
        Section divSection = new Section(divSectionID, divSectionSM);

        Set<Section> managedSections = new HashSet<>(Arrays.asList(strSection,
                divSection));
        conf.setManagedSections(managedSections);

        Map<Direction, ISectionStatemachine> localSections = new HashMap<>();
        localSections.put(STRAIGHT, strSectionSM);
        localSections.put(DIVERGENT, divSectionSM);

        Map<Direction, RemoteTurnout> remoteTurnouts = new HashMap<>();
        remoteTurnouts.put(TOP, new RemoteTurnout(TOP, STRAIGHT, 0x86));
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, DIVERGENT,
                0x83));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, STRAIGHT, 0x83));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(false);

        return conf;
    }

    private static SectionWrapperWithListeners createSectionStatemachine(
            int sectionID,
            ITurnoutStatemachine turnoutStatemachine) {
        SectionWrapperWithListeners sectionStatemachine = new SectionWrapperWithListeners(
                "section" + String.valueOf(sectionID));
        sectionStatemachine.init();

        SectionEventListener outgoingEventListener = new SectionEventListener(
                turnoutStatemachine);
        sectionStatemachine.addListener(outgoingEventListener);

        return sectionStatemachine;
    }

}
