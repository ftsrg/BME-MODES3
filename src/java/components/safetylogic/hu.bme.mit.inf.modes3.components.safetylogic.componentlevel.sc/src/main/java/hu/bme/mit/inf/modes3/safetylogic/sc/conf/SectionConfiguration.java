package hu.bme.mit.inf.modes3.safetylogic.sc.conf;

public class SectionConfiguration {

	protected String name;

	protected int occupancyId;

	protected ConnectingTrackElementConfiguration cw;

	protected ConnectingTrackElementConfiguration ccw;

	public SectionConfiguration(String name, int occupancyId, ConnectingTrackElementConfiguration cw, ConnectingTrackElementConfiguration ccw) {
		this.name = name;
		this.occupancyId = occupancyId;
		this.cw = cw;
		this.ccw = ccw;
	}

	public String getName() {
		return name;
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
