package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener;

public class TrackElementStatusToInternalTransmitter implements ISegmentOccupancyChangeListener, ITurnoutStateChangeListener {

	protected final Logger logger;

	protected final Map<Integer, ISectionStatemachine> localSections = new TreeMap<>();
	protected final Map<Integer, ITurnoutStatemachine> localTurnouts = new TreeMap<>();

	public TrackElementStatusToInternalTransmitter(ITrackElementStateRegistry stateProvider, ILoggerFactory factory) {
		stateProvider.setSegmentOccupancyChangeListener(this);
		stateProvider.setTurnoutStateChangeListener(this);
		logger = factory.getLogger(this.getClass().getName());
	}

	public void registerSectionStatemachine(int id, ISectionStatemachine statemachine) {
		localSections.put(id, statemachine);
	}

	public void registerTurnoutStatemachine(int id, ITurnoutStatemachine statemachine) {
		localTurnouts.put(id, statemachine);
	}

	@Override
	public void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		if (localTurnouts.containsKey(id)) {
			ITurnoutStatemachine sm = localTurnouts.get(id);
			switch (newValue) {
			case STRAIGHT:
				logger.debug("Turnout straight raised for turnout " + id);
				sm.getSCITurnout().raiseTurnoutStraight();
				break;
			case DIVERGENT:
				logger.debug("Turnout divergent raised for turnout " + id);
				sm.getSCITurnout().raiseTurnoutDivergent();
				break;
			}
		}
	}

	@Override
	public void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		if (localTurnouts.containsKey(id)) {
			ITurnoutStatemachine sm = localTurnouts.get(id);
			switch (newValue) {
			case FREE:
				logger.debug("Turnout free raised for turnout " + id);
				sm.getSCITrain().raiseUnoccupy();
				break;
			case OCCUPIED:
				logger.debug("Turnout occupied raised for turnout " + id);
				sm.getSCITrain().raiseOccupy();
				break;
			}
		} else if (localSections.containsKey(id)) {
			ISectionStatemachine sm = localSections.get(id);
			switch (newValue) {
			case FREE:
				logger.debug("Section free raised for turnout " + id);
				sm.getSCITrain().raiseUnoccupy();
				break;
			case OCCUPIED:
				logger.debug("Section occupied raised for turnout " + id);
				sm.getSCITrain().raiseOccupy();
				break;
			}
		}
	}

}
