package hu.bme.mit.inf.modes3.components.bbb.controllers.strategy

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import java.util.List

interface IExpanderController {
	def void setSegmentExpanderLevel(String expanderID, SegmentState state)
	def void setTurnoutExpanderLevel(String expanderID, TurnoutState state)
	
	def void setTurnoutExpanders(List<String> expanders)
	def void setTurnoutExpanderChangedHandler(ITurnoutPinChangedHandler handler)
}
