package hu.bme.mit.inf.yakindu.sc.normal.control.controller;

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.SectionRequestSender;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber;
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher;
import hu.bme.mit.inf.yakindu.sc.normal.control.helper.YakinduSMConfiguration;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.RemoteTurnout;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.Section;
import static hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler.DirectionConverterHelper.getValueFromDirection;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler.SectionEventListener;
import hu.bme.mit.inf.yakindu.sc.normal.control.sm.handler.TurnoutEventListener;

import java.util.Arrays;
import java.util.Set;

import hu.bme.mit.inf.yakindu.mqtt.client.data.Direction;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.DIVERGENT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.STRAIGHT;
import static hu.bme.mit.inf.yakindu.mqtt.client.data.Direction.TOP;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.yakindu.scr.section.ISectionStatemachine;

import org.yakindu.scr.section.SectionWrapperWithListeners;
import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutWrapperWithListeners;

/**
 *
 * @author benedekh
 */
public class StatemachineInitializer {

    private static final long DIVERGENT_VALUE = getValueFromDirection(DIVERGENT);
    private static final long STRAIGHT_VALUE = getValueFromDirection(STRAIGHT);
    private static final long TOP_VALUE = getValueFromDirection(TOP);

    public static YakinduSMConfiguration initialize0x81(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x81;
        int turnoutSectionID = 0x01;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        turnoutStatemachine.getSCITurnout().setDivergentExists(true);
        turnoutStatemachine.getSCITurnout().setStraightExists(true);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x0D;
        int strSectionID = 0x09;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                sender, divSectionID, turnoutStatemachine, DIVERGENT_VALUE);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                sender, strSectionID, turnoutStatemachine, STRAIGHT_VALUE);

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

        conf.setTurnoutEventListener(outgoingEventListener);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x82(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x82;
        int turnoutSectionID = 0x02;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        turnoutStatemachine.getSCITurnout().setDivergentExists(true);
        turnoutStatemachine.getSCITurnout().setTopExists(true);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int topSectionID = 0x0C;
        int divSectionID = 0x0F;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                sender, divSectionID, turnoutStatemachine, DIVERGENT_VALUE);
        SectionWrapperWithListeners topSectionSM = createSectionStatemachine(
                sender, topSectionID, turnoutStatemachine, TOP_VALUE);

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

        conf.setTurnoutEventListener(outgoingEventListener);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x83(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x83;
        int turnoutSectionID = 0x03;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        turnoutStatemachine.getSCITurnout().setTopExists(true);
        turnoutStatemachine.getSCITurnout().setDivergentExists(true);
        turnoutStatemachine.getSCITurnout().setStraightExists(true);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int topSectionID = 0x08;
        int divSectionID = 0x17;
        int strSectionID = 0x0B;

        SectionWrapperWithListeners topSectionSM = createSectionStatemachine(
                sender, topSectionID, turnoutStatemachine, TOP_VALUE);
        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                sender, divSectionID, turnoutStatemachine, DIVERGENT_VALUE);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                sender, strSectionID, turnoutStatemachine, STRAIGHT_VALUE);

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

        conf.setTurnoutEventListener(outgoingEventListener);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x84(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x84;
        int turnoutSectionID = 0x05;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        turnoutStatemachine.getSCITurnout().setDivergentExists(true);
        turnoutStatemachine.getSCITurnout().setStraightExists(true);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x11;
        int strSectionID = 0x0A;

        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                sender, divSectionID, turnoutStatemachine, DIVERGENT_VALUE);
        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                sender, strSectionID, turnoutStatemachine, STRAIGHT_VALUE);

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

        conf.setTurnoutEventListener(outgoingEventListener);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(true);

        return conf;
    }

    public static YakinduSMConfiguration initialize0x85(
            MQTTPublishSubscribeDispatcher sender) {
        YakinduSMConfiguration conf = new YakinduSMConfiguration();
        int turnoutID = 0x85;
        int turnoutSectionID = 0x06;

        TurnoutWrapperWithListeners turnoutStatemachine = new TurnoutWrapperWithListeners(
                "turnout" + String.valueOf(turnoutID));

        turnoutStatemachine.init();
        turnoutStatemachine.getSCITurnout().setId(turnoutID);
        turnoutStatemachine.getSCITurnout().setIsOccupied(false);

        turnoutStatemachine.getSCITurnout().setDivergentExists(true);
        turnoutStatemachine.getSCITurnout().setStraightExists(true);

        conf.setTurnoutSectionId(turnoutSectionID);
        conf.setTurnoutStatemachine(turnoutStatemachine);

        int divSectionID = 0x14;
        int strSectionID = 0x13;

        SectionWrapperWithListeners strSectionSM = createSectionStatemachine(
                sender, strSectionID, turnoutStatemachine, STRAIGHT_VALUE);
        SectionWrapperWithListeners divSectionSM = createSectionStatemachine(
                sender, divSectionID, turnoutStatemachine, DIVERGENT_VALUE);

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

        conf.setTurnoutEventListener(outgoingEventListener);
        turnoutStatemachine.addSectionsListener(outgoingEventListener);
        turnoutStatemachine.addTurnoutListener(outgoingEventListener);

        turnoutStatemachine.getSCITurnout().setRemTopIsPrior(true);
        turnoutStatemachine.getSCITurnout().setRemDivergentIsPrior(false);
        turnoutStatemachine.getSCITurnout().setRemStraightIsPrior(false);

        return conf;
    }

    private static SectionWrapperWithListeners createSectionStatemachine(
            MQTTPublishSubscribeDispatcher sender, int sectionID,
            ITurnoutStatemachine turnoutStatemachine,
            long directionValue) {
        SectionWrapperWithListeners sectionStatemachine = new SectionWrapperWithListeners(
                "section" + String.valueOf(sectionID));
        sectionStatemachine.init();
        sectionStatemachine.getSCISection().setId(sectionID);
        sectionStatemachine.getSCISection().setDirection(directionValue);

        SectionRequestSender requestSender = new SectionRequestSender(sender);

        SectionEventListener outgoingEventListener = new SectionEventListener(
                turnoutStatemachine, requestSender);
        sectionStatemachine.addListener(outgoingEventListener);

        return sectionStatemachine;
    }

}
