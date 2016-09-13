package hu.bme.mit.inf.modes3.components.bbb.strategy;

import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import io.silverspoon.bulldog.core.Signal
import io.silverspoon.bulldog.core.gpio.DigitalInput
import java.util.HashMap
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The turnout controller part of the embedded controller. Through it the
 * referred turnout can be managed.
 * 
 * @author hegyibalint, benedekh
 */
class ExpanderTurnoutController implements ITurnoutControllerStrategy {

	private static val Logger logger = LoggerFactory.getLogger(ExpanderTurnoutController)

	// IO map for the input pins (to get turnout direction)
	protected val ioMap = new HashMap<String, DigitalInput>(4)

	// the actual embedded controller which manages the turnout
	protected var ExpanderControllerConfiguration controllerConf

	// the latest turnout statuses (straight / divergent), based on turnout ID
	protected var Map<String, TurnoutState> turnoutStatus

	// thread-safe wrapper for the BBB board
	protected var BoardWrapper board

	new(BoardWrapper boardWrapper) {
		board = boardWrapper

		try {
			controllerConf = new ExpanderControllerConfiguration
		} catch(Exception ex) {
			logger.error(ex.message, ex)
		}

		turnoutStatus = new ConcurrentHashMap

		// initialize digital input pins for the turnout direction
		for (to : controllerConf.getAllTurnout) {
			val pins = controllerConf.getTurnoutExpander(to)
			ioMap.put(pins.get(0), board.getPinAsDigitalInput(pins.get(0)))
			ioMap.put(pins.get(1), board.getPinAsDigitalInput(pins.get(1)))
		}

	}

	override getManagedTurnouts() {
		controllerConf.allTurnout
	}

	override getTurnoutStatus(int turnoutId) {
		val turnoutStr = HexConversionUtil.fromNumber(turnoutId)
		val pins = controllerConf.getTurnoutExpander(turnoutStr)

		// decide direction
		var TurnoutState direction = null
		if(ioMap.get(pins.get(0)).read() == Signal.High) {
			direction = TurnoutState.STRAIGHT
		}
		if(ioMap.get(pins.get(1)).read() == Signal.High) {
			direction = TurnoutState.DIVERGENT
		}

		// update stored direction
		turnoutStatus.put(turnoutStr, direction)
		direction
	}

	override controllerManagesTurnout(int turnoutId) {
		controllerConf.controllerManagesTurnout(turnoutId)
	}

	override setTurnoutStraight(int turnoutId) {
		val turnoutStr = HexConversionUtil.fromNumber(turnoutId)
		val pins = controllerConf.getTurnoutExpander(turnoutStr)
		// TODO implement
		turnoutStatus.put(turnoutStr, TurnoutState.STRAIGHT)
	}

	override setTurnoutDivergent(int turnoutId) {
		val turnoutStr = HexConversionUtil.fromNumber(turnoutId)
		val pins = controllerConf.getTurnoutExpander(turnoutStr)
		// TODO implement
		turnoutStatus.put(turnoutStr, TurnoutState.DIVERGENT)
	}

}
