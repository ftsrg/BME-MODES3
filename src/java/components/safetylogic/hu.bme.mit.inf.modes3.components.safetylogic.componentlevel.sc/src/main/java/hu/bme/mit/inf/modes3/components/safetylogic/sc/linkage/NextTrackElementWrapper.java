package hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionHolder;

public class NextTrackElementWrapper implements INextTrackElement{
	
	protected final Logger logger;

	protected INextTrackElement nextTrackElement;
	
	protected ConnectionDirectionHolder directions;

	public NextTrackElementWrapper(INextTrackElement nextTrackElement, ConnectionDirectionHolder directions,  ILoggerFactory factory) {
		this(directions, factory);
		this.nextTrackElement = nextTrackElement;
	}
	
	protected NextTrackElementWrapper(ConnectionDirectionHolder directions,  ILoggerFactory factory){
		this.directions = directions;
		this.logger = factory.getLogger(this.getClass().getName());
	}
	
	/**
	 * from the perspective of the track element who owns the next track element
	 */
	public ConnectionDirection weSeeItFrom(){
		return directions.getFirst();
	}
	
	/**
	 * from the perspective of the next track element
	 */
	public ConnectionDirection itReceivesOurMessagesFrom(){
		return directions.getSecond();
	}

	@Override
	public void raiseReserveFrom(int value) {
		logger.debug("ReserveFrom forwarded to next track element with parameter " + value);
		nextTrackElement.raiseReserveFrom(value);
	}

	@Override
	public void raiseCanGoFrom(int value) {
		logger.debug("CanGoFrom forwarded to next track element with parameter " + value);
		nextTrackElement.raiseCanGoFrom(value);
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		logger.debug("CannotGoFrom forwarded to next track element with parameter " + value);
		nextTrackElement.raiseCannotGoFrom(value);
	}

	@Override
	public void raiseReleaseFrom(int value) {
		logger.debug("ReleaseFrom forwarded to next track element with parameter " + value);
		nextTrackElement.raiseReleaseFrom(value);
	}

}
