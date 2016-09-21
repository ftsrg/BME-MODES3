package hu.bme.mit.inf.modes3.components.safetylogic.sc.network;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCanGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCannotGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReleaseTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReserveTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;

public class YakinduMessageBridgeToInternal implements IYakinduReleaseTo, IYakinduReserveTo, IYakinduCanGoTo, IYakinduCannotGoTo {

	protected final Logger logger;
	
	protected final Map<Integer, ISectionStatemachine> localSections = new TreeMap<>();

	protected final Map<Integer, ITurnoutStatemachine> localTurnouts = new TreeMap<>();

	public YakinduMessageBridgeToInternal(ILoggerFactory factory){
		this.logger = factory.getLogger(this.getClass().getName());
	}
	
	public void registerSectionStatemachine(int id, ISectionStatemachine statemachine) {
		localSections.put(id, statemachine);
	}

	public void registerTurnoutStatemachine(int id, ITurnoutStatemachine statemachine) {
		localTurnouts.put(id, statemachine);
	}

	@Override
	public void reserveTo(int targetID, ConnectionDirection direction) {
		ISectionStatemachine section = localSections.get(targetID);
		if (section != null) {
			logger.debug("ReserveFrom raised to " + targetID + " " + direction);
			section.getSCIProtocol().raiseReserveFrom(direction.getValueInYakindu());
		} else {
			ITurnoutStatemachine turnout = localTurnouts.get(targetID);
			if (turnout != null) {
				logger.debug("ReserveFrom raised to " + targetID + " " + direction);
				turnout.getSCIProtocol().raiseReserveFrom(direction.getValueInYakindu());
			}
		}
	}

	@Override
	public void releaseTo(int targetID, ConnectionDirection direction) {
		ISectionStatemachine section = localSections.get(targetID);
		if (section != null) {
			logger.debug("ReleaseFrom raised to " + targetID + " " + direction);
			section.getSCIProtocol().raiseReleaseFrom(direction.getValueInYakindu());
		} else {
			ITurnoutStatemachine turnout = localTurnouts.get(targetID);
			if (turnout != null) {
				logger.debug("ReleaseFrom raised to " + targetID + " " + direction);
				turnout.getSCIProtocol().raiseReleaseFrom(direction.getValueInYakindu());
			}
		}
	}

	@Override
	public void canGoTo(int targetID, ConnectionDirection direction) {
		ISectionStatemachine section = localSections.get(targetID);
		if (section != null) {
			logger.debug("CanGoFrom raised to " + targetID + " " + direction);
			section.getSCIProtocol().raiseCanGoFrom(direction.getValueInYakindu());
		} else {
			ITurnoutStatemachine turnout = localTurnouts.get(targetID);
			if (turnout != null) {
				logger.debug("CanGoFrom raised to " + targetID + " " + direction);
				turnout.getSCIProtocol().raiseCanGoFrom(direction.getValueInYakindu());
			}
		}
	}

	@Override
	public void cannotGoTo(int targetID, ConnectionDirection direction) {
		ISectionStatemachine section = localSections.get(targetID);
		if (section != null) {
			logger.debug("CannotGoFrom raised to " + targetID + " " + direction);
			section.getSCIProtocol().raiseCannotGoFrom(direction.getValueInYakindu());
		} else {
			ITurnoutStatemachine turnout = localTurnouts.get(targetID);
			if (turnout != null) {
				logger.debug("CanGoFrom raised to " + targetID + " " + direction);
				turnout.getSCIProtocol().raiseCannotGoFrom(direction.getValueInYakindu());
			}
		}
	}

}
