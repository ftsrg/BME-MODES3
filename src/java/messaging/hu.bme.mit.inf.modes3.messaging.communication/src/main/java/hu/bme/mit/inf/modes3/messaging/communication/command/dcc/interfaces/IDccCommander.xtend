package hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces

interface IDccCommander {

	def void startEntireRailRoad()

	def void stopEntireRailRoad()

	def void stopTrains()
}
