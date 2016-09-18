package hu.bme.mit.inf.modes3.safetylogic.sc.integration;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class NextTrackElementInReservationProtocol implements IReservationProtocol {

	protected IReservationProtocol nextTrackElement;

	// from the perspective of the track element who owns the next track element
	protected ConnectionDirection weSeeItFrom;

	// from the perspective of the next track element
	protected ConnectionDirection itSeeUsFrom;

	public NextTrackElementInReservationProtocol(IReservationProtocol nextTrackElement, ConnectionDirection weSeeItFrom, ConnectionDirection itSeeUsFrom) {
		this.nextTrackElement = nextTrackElement;
		this.weSeeItFrom = weSeeItFrom;
		this.itSeeUsFrom = itSeeUsFrom;
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
