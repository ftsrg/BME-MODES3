package hu.bme.mit.inf.modes3.safetylogic.sc.linkage;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionHolder;

public class NextTrackElementWrapper implements INextTrackElement{

	protected INextTrackElement nextTrackElement;
	
	protected ConnectionDirectionHolder directions;

	public NextTrackElementWrapper(INextTrackElement nextTrackElement, ConnectionDirectionHolder directions) {
		this(directions);
		this.nextTrackElement = nextTrackElement;
	}
	
	protected NextTrackElementWrapper(ConnectionDirectionHolder directions){
		this.directions = directions;	
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
		nextTrackElement.raiseReserveFrom(value);
	}

	@Override
	public void raiseCanGoFrom(int value) {
		nextTrackElement.raiseCanGoFrom(value);
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		nextTrackElement.raiseCannotGoFrom(value);
	}

	@Override
	public void raiseReleaseFrom(int value) {
		nextTrackElement.raiseReleaseFrom(value);
	}

}
