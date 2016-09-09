package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public interface IYakinduMessageHandler {
	void reserveTo(final int targetID, final ConnectionDirection direction);

	void releaseTo(final int targetID, final ConnectionDirection direction);

	void reserveResultTo(final int targetID, final ConnectionDirection direction, final boolean result);
}
