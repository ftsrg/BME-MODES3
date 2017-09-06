package hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.reference

import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TurnoutReferenceStateRegistry implements ITurnoutReferenceStateRegistry {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	val turnoutReferenceStates = new ConcurrentHashMap<Integer, TurnoutState>

	@Accessors(#[PACKAGE_GETTER, PACKAGE_SETTER]) val TurnoutReferenceStateCallback turnoutReferenceStateCallback
	@Accessors(#[PRIVATE_GETTER,
		PUBLIC_SETTER]) var ITurnoutReferenceStateChangeListener turnoutReferenceStateChangeListener

	new(AbstractMessageDispatcher dispatcher, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		turnoutReferenceStateCallback = new TurnoutReferenceStateCallback(dispatcher,
			new ITurnoutReferenceStateListener() {
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
			})
	}

	override getTurnoutReferenceState(int id) {
		turnoutReferenceStates.get(id)
	}

}
