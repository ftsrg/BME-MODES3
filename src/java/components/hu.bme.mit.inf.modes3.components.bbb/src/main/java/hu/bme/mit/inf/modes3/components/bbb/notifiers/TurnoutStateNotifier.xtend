package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Implements a runnable which frequently polls the turnouts status 
 * (STRAIGHT or DIVERGENT) and transfers this to the network so that 
 * everyone who is subscribed can receive it.
 * 
 * @author benedekh
 */
class TurnoutStateNotifier implements Runnable {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) val Logger logger = LoggerFactory.getLogger(TurnoutStateNotifier)

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val SLEEP_MS_BETWEEN_POLLINGS = 50

	// the actuator that can access the referred turnout
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ExpanderTurnoutController turnoutController

	// send turnout state on the network
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ITrackElementStateSender trackElementStateSender

	new(ITrackElementStateSender _trackElementStateSender, ExpanderTurnoutController _turnoutController) {
		trackElementStateSender = _trackElementStateSender
		turnoutController = _turnoutController
	}

	override run() {
		while (!Thread.interrupted) {
			try {
				for (turnoutStr : turnoutController.managedTurnouts) {
					val turnoutId = HexConversionUtil.fromString(turnoutStr)
					val turnoutStatus = turnoutController.getTurnoutStatus(turnoutId)
					trackElementStateSender.sendTurnoutState(turnoutId, turnoutStatus)
				}
				Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
			} catch (InterruptedException ex) {
				logger.error(ex.message, ex)
				Thread.currentThread.interrupt
			}
		}
	}

}
