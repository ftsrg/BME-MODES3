package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler

import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection

public interface IYakinduMessageHandler {
	def void reserveTo(int targetID, ConnectionDirection direction)
	def void releaseTo(int targetID, ConnectionDirection direction)
	def void reserveResultTo(int targetID, ConnectionDirection direction, boolean result)
}
