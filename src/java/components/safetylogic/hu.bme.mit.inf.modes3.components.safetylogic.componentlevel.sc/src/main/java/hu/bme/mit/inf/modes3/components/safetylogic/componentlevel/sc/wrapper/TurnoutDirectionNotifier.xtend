package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

class TurnoutDirectionNotifier implements ITurnoutStateChangeListener {

	val int turnoutId
	val TurnoutControlInterface.Provided turnoutToBeNotified

	new(int turnoutId, TurnoutControlInterface.Provided turnoutToBeNotified, ITrackElementStateRegistry stateRegistry) {
		this.turnoutId = turnoutId
		this.turnoutToBeNotified = turnoutToBeNotified
		stateRegistry.registerTurnoutStateChangeListener = this
	}

	override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		if(id == turnoutId) {
			switch (newValue) {
				case STRAIGHT:
					turnoutToBeNotified.raiseTurnoutStraight
				case DIVERGENT:
					turnoutToBeNotified.raiseTurnoutDivergent
				default: {
				}
			}
		}
	}

}
