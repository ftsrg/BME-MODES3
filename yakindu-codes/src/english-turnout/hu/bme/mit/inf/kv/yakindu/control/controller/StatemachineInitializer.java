package hu.bme.mit.inf.kv.yakindu.control.controller;

import hu.bme.mit.inf.kv.yakindu.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.kv.yakindu.control.sm.RemoteTurnout;
import hu.bme.mit.inf.kv.yakindu.control.sm.Section;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.SectionEventListener;
import hu.bme.mit.inf.kv.yakindu.control.sm.handler.TurnoutEventListener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction;
import static hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.DIVERGENT;
import static hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.STRAIGHT;
import static hu.bme.mit.inf.kvcontrol.bpextension.requests.enums.Direction.TOP;
import java.util.HashMap;
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

    public static YakinduSMConfiguration initialize0x86() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x86;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x04);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x10;
        int strSectionID = 0x15;

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
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, TOP, 0x84));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, TOP, 0x85));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        conf.setTurnoutEventListener(outgoingEventListener);
        return conf;
    }

    public static YakinduSMConfiguration initialize0x87() {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x87;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);

        conf.setTurnoutSectionId(0x04);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x0E;
        int strSectionID = 0x16;

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
        remoteTurnouts.put(DIVERGENT, new RemoteTurnout(DIVERGENT, TOP, 0x81));
        remoteTurnouts.put(STRAIGHT, new RemoteTurnout(STRAIGHT, STRAIGHT, 0x82));

        TurnoutEventListener outgoingEventListener = new TurnoutEventListener(
                remoteTurnouts, localSections);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        conf.setTurnoutEventListener(outgoingEventListener);
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
