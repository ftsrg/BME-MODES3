package hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson;

public class TurnoutConfiguration {

	protected int occupancyId;

	protected ConnectingTrackElementConfiguration straight;

	protected ConnectingTrackElementConfiguration divergent;

	protected ConnectingTrackElementConfiguration top;

	public TurnoutConfiguration(int occupancyId, ConnectingTrackElementConfiguration straight, ConnectingTrackElementConfiguration divergent,
			ConnectingTrackElementConfiguration top) {
		this.occupancyId = occupancyId;
		this.straight = straight;
		this.divergent = divergent;
		this.top = top;
	}

	public int getOccupancyId() {
		return occupancyId;
	}

	public ConnectingTrackElementConfiguration getStraight() {
		return straight;
	}

	public ConnectingTrackElementConfiguration getDivergent() {
		return divergent;
	}

	public ConnectingTrackElementConfiguration getTop() {
		return top;
	}

}
