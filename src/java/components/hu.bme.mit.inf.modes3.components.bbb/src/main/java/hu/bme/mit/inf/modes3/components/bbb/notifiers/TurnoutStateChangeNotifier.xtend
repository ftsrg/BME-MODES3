package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Map
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

/**
 * Implements a runnable which frequently polls the turnouts status 
 * (STRAIGHT or DIVERGENT) and transfers this to the network so that 
 * everyone who is subscribed can receive it.
 * 
 * This class only transfers the information if the respective turnout's status
 * has changed (e.g. from STRAIGHT to DIVERGENT). Otherwise it does not send any
 * notification on the network.
 * 
 * @author benedekh
 */
package class TurnoutStateChangeNotifier extends TurnoutStateNotifier {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val Map<Integer, TurnoutState> latestTurnoutStates

	new(ITrackElementStateSender _trackElementStateSender, ExpanderTurnoutController _turnoutController, ILoggerFactory factory) {
		super(_trackElementStateSender, _turnoutController, factory)

		latestTurnoutStates = new TreeMap
		for (turnoutId : turnoutController.managedTurnouts) {
			val status = turnoutController.getTurnoutStatus(turnoutId)
			latestTurnoutStates.put(turnoutId, status)
		}
	}

	override run() {
		while(!Thread.interrupted) {
			try {
				for (turnoutId : turnoutController.managedTurnouts) {
					val status = turnoutController.getTurnoutStatus(turnoutId)
					if(latestTurnoutStates.get(turnoutId) != status) {
						latestTurnoutStates.put(turnoutId, status)
						trackElementStateSender.sendTurnoutState(turnoutId, status)
					}
				}
				Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
			} catch(InterruptedException ex) {
				logger.error(ex.message, ex)
				Thread.currentThread.interrupt
			}
		}
	}

}
