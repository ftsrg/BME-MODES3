package hu.bme.mit.inf.modes3.components.bbb.controllers.strategy

interface ITurnoutPinChangedHandler {
	def void handleTurnoutPinChange(boolean div, boolean str);
}