package hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.yakindu.scr.section.ISectionStatemachine;
import org.yakindu.scr.section.ISectionStatemachine.SCIProtocolListener;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;

public class LinkedSectionStatemachine implements SCIProtocolListener, INextTrackElement {

	protected final Logger logger;

	protected ISectionStatemachine statemachine;

	protected NextTrackElementWrapper nextTrackElement;

	public LinkedSectionStatemachine(ISectionStatemachine statemachine, NextTrackElementWrapper nextTrackElement, ILoggerFactory factory) {
		this.statemachine = statemachine;
		this.nextTrackElement = nextTrackElement;
		this.logger = factory.getLogger(this.getClass().getName());

		statemachine.getSCIProtocol().getListeners().add(this);
	}

	@Override
	public void onReserveToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom())) {
			logger.debug("ReserveToRaised to " + direction);
			nextTrackElement.raiseReserveFrom(nextTrackElement.itReceivesOurMessagesFrom().getValueInYakindu());
		}
	}

	@Override
	public void onCanGoToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom())) {
			logger.debug("CanGoToRaised to " + direction);
			nextTrackElement.raiseCanGoFrom(nextTrackElement.itReceivesOurMessagesFrom().getValueInYakindu());
		}
	}

	@Override
	public void onCannotGoToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom())) {
			logger.debug("CannotGoToRaised to " + direction);
			nextTrackElement.raiseCannotGoFrom(nextTrackElement.itReceivesOurMessagesFrom().getValueInYakindu());
		}
	}

	@Override
	public void onReleaseToRaised(int value) {
		ConnectionDirection direction = ConnectionDirection.getDirectionByValue(value);
		if (direction != null && direction.equals(nextTrackElement.weSeeItFrom())) {
			logger.debug("ReleaseToRaised to " + direction);
			nextTrackElement.raiseReleaseFrom(nextTrackElement.itReceivesOurMessagesFrom().getValueInYakindu());
		}
	}

	@Override
	public void raiseReserveFrom(int value) {
		logger.debug("ReserveFrom forwarded to statemachine with parameter " + value);
		statemachine.getSCIProtocol().raiseReserveFrom(value);
	}

	@Override
	public void raiseCanGoFrom(int value) {
		logger.debug("CanGoFrom forwarded to statemachine with parameter " + value);
		statemachine.getSCIProtocol().raiseCanGoFrom(value);
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		logger.debug("CannotGoFrom forwarded to statemachine with parameter " + value);
		statemachine.getSCIProtocol().raiseCannotGoFrom(value);
	}

	@Override
	public void raiseReleaseFrom(int value) {
		logger.debug("ReleaseFrom forwarded to statemachine with parameter " + value);
		statemachine.getSCIProtocol().raiseReleaseFrom(value);
	}

}
