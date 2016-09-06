package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import java.util.Map
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

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
class TurnoutStateChangeNotifier extends TurnoutStateNotifier {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) val Logger logger = LoggerFactory.getLogger(
		TurnoutStateChangeNotifier)

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val Map<String, TurnoutState> latestTurnoutStates

	new(ITrackElementStateSender _trackElementStateSender, ExpanderTurnoutController _turnoutController) {
		super(_trackElementStateSender, _turnoutController)

		latestTurnoutStates = new TreeMap
		for (turnoutStr : turnoutController.managedTurnouts) {
			val turnoutId = HexConversionUtil.fromString(turnoutStr)
			val status = turnoutController.getTurnoutStatus(turnoutId)
			latestTurnoutStates.put(turnoutStr, status)
		}
	}

	override run() {
		while (!Thread.interrupted) {
			try {
				for (turnoutStr : turnoutController.managedTurnouts) {
					val turnoutId = HexConversionUtil.fromString(turnoutStr)
					val status = turnoutController.getTurnoutStatus(turnoutId)
					if (latestTurnoutStates.get(turnoutStr) != status) {
						latestTurnoutStates.put(turnoutStr, status)
						trackElementStateSender.sendTurnoutState(turnoutId, status)
					}
				}
				Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
			} catch (InterruptedException ex) {
				logger.error(ex.message, ex)
				Thread.currentThread.interrupt
			}
		}
	}

}
