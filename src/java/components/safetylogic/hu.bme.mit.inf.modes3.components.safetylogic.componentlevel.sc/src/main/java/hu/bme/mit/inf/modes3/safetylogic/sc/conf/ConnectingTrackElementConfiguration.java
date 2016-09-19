package hu.bme.mit.inf.modes3.safetylogic.sc.conf;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class ConnectingTrackElementConfiguration {

	protected String targetId;

	protected ConnectionDirection itReceivesOurMessagesFrom;

	public ConnectingTrackElementConfiguration(String targetId, ConnectionDirection itReceivesOurMessagesFrom) {
		this.targetId = targetId;
		this.itReceivesOurMessagesFrom = itReceivesOurMessagesFrom;
	}

	public String getTargetId() {
		return targetId;
	}

	public ConnectionDirection getItReceivesOurMessagesFrom() {
		return itReceivesOurMessagesFrom;
	}

}
