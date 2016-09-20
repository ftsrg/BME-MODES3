package hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson;

public class SectionConfiguration {

	protected int occupancyId;

	protected ConnectingTrackElementConfiguration cw;

	protected ConnectingTrackElementConfiguration ccw;

	public SectionConfiguration(int occupancyId, ConnectingTrackElementConfiguration cw, ConnectingTrackElementConfiguration ccw) {
		this.occupancyId = occupancyId;
		this.cw = cw;
		this.ccw = ccw;
	}

	public int getOccupancyId() {
		return occupancyId;
	}

	public ConnectingTrackElementConfiguration getCw() {
		return cw;
	}

	public ConnectingTrackElementConfiguration getCcw() {
		return ccw;
	}

}
