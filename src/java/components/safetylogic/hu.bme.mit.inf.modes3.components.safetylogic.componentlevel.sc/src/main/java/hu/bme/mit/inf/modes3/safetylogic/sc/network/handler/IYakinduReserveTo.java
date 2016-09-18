package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public interface IYakinduReserveTo {
	void reserveTo(final int targetID, final ConnectionDirection direction);
}
