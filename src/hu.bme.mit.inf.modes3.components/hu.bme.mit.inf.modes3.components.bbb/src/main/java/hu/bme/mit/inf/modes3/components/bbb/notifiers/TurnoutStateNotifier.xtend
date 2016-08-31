package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITrackElementStateSender
import org.eclipse.xtend.lib.annotations.Accessors

class TurnoutStateNotifier implements Runnable {

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
			for (turnoutStr : turnoutController.managedTurnouts) {
				val turnoutId = HexConversionUtil.fromString(turnoutStr)
				val turnoutStatus = turnoutController.getTurnoutStatus(turnoutId)
				trackElementStateSender.sendTurnoutState(turnoutId, turnoutStatus)
			}
			Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
		}
	}

}
