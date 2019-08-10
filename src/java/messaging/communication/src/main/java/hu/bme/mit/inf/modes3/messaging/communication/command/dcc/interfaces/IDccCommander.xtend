package hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces

/**
 * A commander that sends the DCC commands.
 * 
 * @author benedekh
 */
interface IDccCommander {
	
	/**
	 * Sends a start entire railroad command.
	 */
	def void startEntireRailRoad()

	/**
	 * Sends a stop entire railroad command.
	 */
	def void stopEntireRailRoad()

	/**
	 * Sends a stop trains command.
	 */
	def void stopTrains()
}
