package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

class TurnoutReferenceStateCallback implements ITurnoutReferenceStateCallback, ITurnoutReferenceStateListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITurnoutReferenceStateListener turnoutReferenceStateListener

	new(AbstractMessageDispatcher dispatcher) {
		val referenceStateClient = new TurnoutReferenceStateClient(this)
		dispatcher.turnoutReferenceStateHandler = referenceStateClient
	}

	override onTurnoutReferenceState(int id, TurnoutState state) {
		turnoutReferenceStateListener?.onTurnoutReferenceState(id, state)
	}

}
