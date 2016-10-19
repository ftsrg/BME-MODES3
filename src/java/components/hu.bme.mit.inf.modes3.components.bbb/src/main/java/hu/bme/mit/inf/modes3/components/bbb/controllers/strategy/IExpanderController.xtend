package hu.bme.mit.inf.modes3.components.bbb.controllers.strategy

import hu.bme.mit.inf.modes3.components.bbb.controllers.TurnoutPinChangedHandler
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

interface IExpanderController {
	def void setSegmentExpanderLevel(String expanderID, SegmentState state)
	def void setTurnoutExpanderLevel(String expanderID, TurnoutState state)
	
	def void setTurnoutExpanderChangedHandler(TurnoutPinChangedHandler handler)
}
