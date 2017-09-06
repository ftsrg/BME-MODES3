package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateListener
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference.interfaces.ITurnoutReferenceStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TurnoutReferenceStateRegistry implements ITurnoutReferenceStateRegistry {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	val turnoutReferenceStates = new ConcurrentHashMap<Integer, TurnoutState>

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val ITurnoutReferenceStateCallback turnoutReferenceStateCallback
	@Accessors(#[PRIVATE_GETTER,
		PUBLIC_SETTER]) var ITurnoutReferenceStateChangeListener turnoutReferenceStateChangeListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		turnoutReferenceStateCallback = new TurnoutReferenceStateCallback(dispatcher)
		turnoutReferenceStateCallback.turnoutReferenceStateListener = new ITurnoutReferenceStateListener() {

			override onTurnoutReferenceState(int id, TurnoutState state) {
				logger.trace('''TurnoutReferenceState message arrived id=«id», state=«state»''')
				val previousReferenceState = turnoutReferenceStates.get(id)
				if (previousReferenceState === null || previousReferenceState != state) {
					logger.
						trace('''TurnoutReferenceState is different from the cached value id=«id», state = «state»''')
					turnoutReferenceStateChangeListener?.onTurnoutReferenceStateChange(id, previousReferenceState,
						state)
					turnoutReferenceStates.put(id, state)
				}
			}

		}
	}

	override getTurnoutReferenceState(int id) {
		if (turnoutReferenceStates.get(id) === null) {
			logger.
				trace('''The registry was asked for the reference state of Turnout #«id» but there is no information in the cache, default «TurnoutState.DIVERGENT» state is used instead''')
			turnoutReferenceStates.put(id, TurnoutState.DIVERGENT)
		}
		turnoutReferenceStates.get(id)
	}

}
