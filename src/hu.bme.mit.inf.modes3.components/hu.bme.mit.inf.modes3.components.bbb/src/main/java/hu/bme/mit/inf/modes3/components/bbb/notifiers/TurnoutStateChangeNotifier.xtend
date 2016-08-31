package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITrackElementStateSender
import java.util.Map
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors

class TurnoutStateChangeNotifier extends TurnoutStateNotifier {

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
			for (turnoutStr : turnoutController.managedTurnouts) {
				val turnoutId = HexConversionUtil.fromString(turnoutStr)
				val status = turnoutController.getTurnoutStatus(turnoutId)
				if (latestTurnoutStates.get(turnoutStr) != status) {
					latestTurnoutStates.put(turnoutStr, status)
					trackElementStateSender.sendTurnoutState(turnoutId, status)
				}
			}
			Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
		}
	}

}
