package hu.bme.mit.inf.modes3.safetylogic.sc.conf.gson;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class ConnectingTrackElementConfiguration {

	protected int occupancyId;

	protected ConnectionDirection itReceivesOurMessagesFrom;

	public ConnectingTrackElementConfiguration(int occupancyId, ConnectionDirection itReceivesOurMessagesFrom) {
		this.occupancyId = occupancyId;
		this.itReceivesOurMessagesFrom = itReceivesOurMessagesFrom;
	}

	public int getId() {
		return occupancyId;
	}

	public ConnectionDirection getItReceivesOurMessagesFrom() {
		return itReceivesOurMessagesFrom;
	}

}
