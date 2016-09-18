package hu.bme.mit.inf.modes3.safetylogic.sc.linkage;

import org.yakindu.scr.turnout.ITurnoutStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCIProtocolListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class LinkedTurnoutStatemachine implements SCIProtocolListener, INextTrackElement {

	protected ITurnoutStatemachine statemachine;

	protected NextTrackElement nextTrackElement;

	public LinkedTurnoutStatemachine(ITurnoutStatemachine statemachine, NextTrackElement nextTrackElement) {
		this.statemachine = statemachine;
		this.nextTrackElement = nextTrackElement;

		statemachine.getSCIProtocol().getListeners().add(this);
	}

	@Override
	public void onReserveToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseReserveFrom(nextTrackElement.itReceivesOurMessagesFrom.getValueInYakindu());
		}
	}

	@Override
	public void onCanGoToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseCanGoFrom(nextTrackElement.itReceivesOurMessagesFrom.getValueInYakindu());
		}
	}

	@Override
	public void onCannotGoToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseCannotGoFrom(nextTrackElement.itReceivesOurMessagesFrom.getValueInYakindu());
		}
	}

	@Override
	public void onReleaseToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom)) {
			nextTrackElement.raiseReleaseFrom(nextTrackElement.itReceivesOurMessagesFrom.getValueInYakindu());
		}
	}

	@Override
	public void raiseReserveFrom(int value) {
		statemachine.getSCIProtocol().raiseReserveFrom(value);
	}

	@Override
	public void raiseCanGoFrom(int value) {
		statemachine.getSCIProtocol().raiseCanGoFrom(value);
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		statemachine.getSCIProtocol().raiseCannotGoFrom(value);
	}

	@Override
	public void raiseReleaseFrom(int value) {
		statemachine.getSCIProtocol().raiseReleaseFrom(value);
	}

}
