package hu.bme.mit.inf.modes3.safetylogic.sc.linkage;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class NextTrackElement implements INextTrackElement {

	protected INextTrackElement nextTrackElement;

	// from the perspective of the track element who owns the next track element
	protected ConnectionDirection weSeeItFrom;

	// from the perspective of the next track element
	protected ConnectionDirection itReceivesOurMessagesFrom;

	public NextTrackElement(INextTrackElement nextTrackElement, ConnectionDirection weSeeItFrom, ConnectionDirection itReceivesOurMessagesFrom) {
		this.nextTrackElement = nextTrackElement;
		this.weSeeItFrom = weSeeItFrom;
		this.itReceivesOurMessagesFrom = itReceivesOurMessagesFrom;
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
