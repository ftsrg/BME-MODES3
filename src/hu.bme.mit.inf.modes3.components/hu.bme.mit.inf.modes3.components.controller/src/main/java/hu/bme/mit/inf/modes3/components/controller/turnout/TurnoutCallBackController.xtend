package hu.bme.mit.inf.modes3.components.controller.turnout

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState

abstract class TurnoutCallBackController extends AbstractComponent {
	override init() {
		val dispatcher = new ProtobufMessageDispatcher
		val turnoutStateListener = new TurnoutStateListener(this)
		val turnoutControlListener = new TurnoutControlListener(this)
		dispatcher.turnoutStateHandler = turnoutStateListener
		dispatcher.turnoutControlHandler = turnoutControlListener
	}

	def void onTurnoutStateInfo(int id, TurnoutStateValue state);
	def void onTurnoutControlInfo(int id, TurnoutStateValue state);
	
	def sendTurnoutControlState(int turnoutId, TurnoutStateValue state){
		mms.sendMessage((TurnoutControl.newBuilder => [
			turnoutID = turnoutId;
			controlState = state
		]).build)
	}
	
	def sendTurnoutControlState(int turnoutId, boolean isDivergent) {
		sendTurnoutControlState(turnoutId, if(isDivergent) TurnoutStateValue.DIVERGENT else TurnoutStateValue.STRAIGHT)
	}
	
	def sendTurnoutStateInfo(int turnoutId, TurnoutStateValue state){
		mms.sendMessage((TurnoutState.newBuilder => [
			turnoutID = turnoutId
			it.state = state
		]).build)
	}
	
	def sendTurnoutStateInfo(int turnoutId, boolean isDivergent){
		sendTurnoutStateInfo(turnoutId, if(isDivergent) TurnoutStateValue.DIVERGENT else TurnoutStateValue.STRAIGHT)
	}
}
