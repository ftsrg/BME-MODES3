package hu.bme.mit.inf.modes3.components.bbb.controllers.strategy

import hu.bme.mit.inf.modes3.components.bbb.Signal
import hu.bme.mit.inf.modes3.components.bbb.controllers.TurnoutPinChangedHandler

interface IPinController {
	def void setPinLevel(String pin, Signal level)
	def void pinImpulse(String pin, int ms)
	def Signal getPinLevel(String pin)
	
	def void setTurnoutPinChangedHandler(TurnoutPinChangedHandler handler);
}
