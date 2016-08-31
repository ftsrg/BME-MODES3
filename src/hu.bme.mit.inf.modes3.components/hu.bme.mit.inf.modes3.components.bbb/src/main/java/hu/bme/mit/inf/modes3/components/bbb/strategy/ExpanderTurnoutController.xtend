package hu.bme.mit.inf.modes3.components.bbb.strategy;

import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.conf.IControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.components.controller.enums.TurnoutState
import io.silverspoon.bulldog.core.Signal
import io.silverspoon.bulldog.core.gpio.DigitalInput
import java.util.HashMap
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The turnout controller part of the embedded controller. Through it the
 * referred turnout can be managed.
 * 
 * @author hegyibalint, benedekh
 */
class ExpanderTurnoutController extends AbstractControllerStrategy implements IControllerConfiguration {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) val Logger logger = LoggerFactory.getLogger(ExpanderTurnoutController)

	// IO map for the input pins (to get turnout direction)
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) val ioMap = new HashMap<String, DigitalInput>(4)

	// the actual embedded controller which manages the turnout
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var ExpanderControllerConfiguration controllerConf

	// the latest turnout statuses (straight / divergent), based on turnout ID
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, TurnoutState> turnoutStatus

	new() {
		try {
			controllerConf = new ExpanderControllerConfiguration
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}

		turnoutStatus = new ConcurrentHashMap

		// initialize digital input pins for the turnout direction
		for (to : controllerConf.getAllTurnout) {
			val pins = controllerConf.getTurnoutExpander(to)
			ioMap.put(pins.get(0), board.getPin(pins.get(0)).^as(DigitalInput))
			ioMap.put(pins.get(1), board.getPin(pins.get(1)).^as(DigitalInput))
		}

	}

	override controllerManagesSection(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onGetSectionStatus(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onEnableSection(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	override protected onDisableSection(int sectionId) {
		throw new UnsupportedOperationException("ExpanderTurnoutController does not support section operations")
	}

	def getManagedTurnouts() {
		controllerConf.allTurnout
	}

	override protected onGetTurnoutStatus(int turnoutId) {
		val turnoutStr = HexConversionUtil.fromNumber(turnoutId)
		val pins = controllerConf.getTurnoutExpander(turnoutStr)

		// decide direction
		var TurnoutState direction = null
		if (ioMap.get(pins.get(0)).read() == Signal.High) {
			direction = TurnoutState.STRAIGHT
		}
		if (ioMap.get(pins.get(1)).read() == Signal.High) {
			direction = TurnoutState.DIVERGENT
		}

		// update stored direction
		turnoutStatus.put(turnoutStr, direction)
		direction
	}

	override controllerManagesTurnout(int turnoutId) {
		controllerConf.controllerManagesTurnout(turnoutId)
	}

	override protected onSetTurnoutStraight(int turnoutId) {
		val turnoutStr = HexConversionUtil.fromNumber(turnoutId)
		val pins = controllerConf.getTurnoutExpander(turnoutStr)
		// TODO implement
		turnoutStatus.put(turnoutStr, TurnoutState.STRAIGHT)
	}

	override protected onSetTurnoutDivergent(int turnoutId) {
		val turnoutStr = HexConversionUtil.fromNumber(turnoutId)
		val pins = controllerConf.getTurnoutExpander(turnoutStr)
		// TODO implement
		turnoutStatus.put(turnoutStr, TurnoutState.DIVERGENT)
	}

}
