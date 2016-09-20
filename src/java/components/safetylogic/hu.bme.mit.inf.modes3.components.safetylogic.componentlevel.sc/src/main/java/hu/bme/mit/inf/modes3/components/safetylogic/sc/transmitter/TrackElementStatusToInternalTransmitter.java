package hu.bme.mit.inf.modes3.components.safetylogic.sc.transmitter;

import java.util.Map;
import java.util.TreeMap;

import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine;

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry;

public class TrackElementStatusToInternalTransmitter {

	protected final Map<Integer, ISectionStatemachine> localSections = new TreeMap<>();
	protected final Map<Integer, ITurnoutStatemachine> localTurnouts = new TreeMap<>();

	protected final ITrackElementStateRegistry trackElementStateProvider;
	protected final Thread internalThread = new TrackElementStatusTransmitterThread();

	public TrackElementStatusToInternalTransmitter(ITrackElementStateRegistry stateProvider) {
		this.trackElementStateProvider = stateProvider;
	}

	public void registerSectionStatemachine(int id, ISectionStatemachine statemachine) {
		localSections.put(id, statemachine);
	}

	public void registerTurnoutStatemachine(int id, ITurnoutStatemachine statemachine) {
		localTurnouts.put(id, statemachine);
	}

	public void start() {
		internalThread.start();
	}

	public void interrupt() {
		internalThread.interrupt();
	}

	private class TrackElementStatusTransmitterThread extends Thread {

		private static final int SLEEP_TIME = 50;

		@Override
		public void run() {
			while (!Thread.interrupted()) {
				try {
					pollSectionOccupancies();
					pollTurnoutOccupancies();

					pollTurnoutDirections();
					restartProtocolForSections();

					Thread.sleep(SLEEP_TIME);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
				}
			}
		}

		private void pollSectionOccupancies() {
			for (Map.Entry<Integer, ISectionStatemachine> sectionEntry : localSections.entrySet()) {
				SegmentOccupancy sectionOccupancy = trackElementStateProvider.getSegmentOccupancy(sectionEntry.getKey());
				switch (sectionOccupancy) {
				case FREE:
					sectionEntry.getValue().getSCITrain().raiseUnoccupy();
					break;
				case OCCUPIED:
					sectionEntry.getValue().getSCITrain().raiseOccupy();
					break;
				}
			}
		}

		private void pollTurnoutOccupancies() {
			for (Map.Entry<Integer, ITurnoutStatemachine> turnoutEntry : localTurnouts.entrySet()) {
				SegmentOccupancy turnoutOccupancy = trackElementStateProvider.getSegmentOccupancy(turnoutEntry.getKey());
				switch (turnoutOccupancy) {
				case FREE:
					turnoutEntry.getValue().getSCITrain().raiseUnoccupy();
					break;
				case OCCUPIED:
					turnoutEntry.getValue().getSCITrain().raiseOccupy();
					break;
				}
			}
		}

		private void pollTurnoutDirections() {
			for (Map.Entry<Integer, ITurnoutStatemachine> turnoutEntry : localTurnouts.entrySet()) {
				TurnoutState turnoutState = trackElementStateProvider.getTurnoutState(turnoutEntry.getKey());
				switch (turnoutState) {
				case STRAIGHT:
					turnoutEntry.getValue().getSCITurnout().raiseTurnoutStraight();
					break;
				case DIVERGENT:
					turnoutEntry.getValue().getSCITurnout().raiseTurnoutDivergent();
					break;
				}
			}
		}

		private void restartProtocolForSections() {
			for (Map.Entry<Integer, ISectionStatemachine> sectionEntry : localSections.entrySet()) {
				sectionEntry.getValue().getSCIProtocol().raiseRestartProtocol();
			}
		}

	}

}
