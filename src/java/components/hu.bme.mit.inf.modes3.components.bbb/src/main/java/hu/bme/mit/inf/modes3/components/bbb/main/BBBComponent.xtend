package hu.bme.mit.inf.modes3.components.bbb.main

import hu.bme.mit.inf.modes3.components.bbb.prototypes.Configuration
import hu.bme.mit.inf.modes3.components.bbb.prototypes.Pinout
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import io.silverspoon.bulldog.core.Signal
import java.util.ArrayList
import java.util.HashMap
import org.slf4j.ILoggerFactory

class BBBComponent extends AbstractRailRoadCommunicationComponent {

	val HardwareAbstractionLayer hal = null
	Configuration config
	Pinout pinout
	val int id

	HashMap<String, Signal> pinStatus

	new( int turnoutID, CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		id = turnoutID
		pinStatus = new HashMap<String, Signal>

		config = Configuration::loadPinoutConfig(turnoutID, factory)
		pinout = Pinout::loadPinoutConfig(factory)

		locator.trackElementCommandCallback.segmentCommandListener = new ISegmentCommandListener() {
			override onSegmentCommand(int id, SegmentState state) {
				val pins = pinout.getHeaderPins(config.getSectionExpander(id))
				pins.forEach [
					hal.setPinLevel(it, if(state == SegmentState.ENABLED) Signal.High else Signal.Low)
				]
				locator.trackElementStateSender.sendSegmentState(id, state)
			}
		}
		locator.trackElementCommandCallback.turnoutCommandListener = new ITurnoutCommandListener() {
			override onTurnoutCommand(int id, TurnoutState state) {
				val pins = getPins
				hal.setPinLevel(pins.get(0), if(state == TurnoutState.STRAIGHT) Signal.High else Signal.Low)
				hal.setPinLevel(pins.get(1), if(state != TurnoutState.STRAIGHT) Signal.High else Signal.Low) // TODO @hegyibalint
				locator.trackElementStateSender.sendTurnoutState(id, state)
			}
		}
	}

	def getPins() {
		val pins = new ArrayList<String>
		config.getTurnoutExpanders().forEach [ expander |
			pins.addAll(pinout.getHeaderPins(expander))
		]
		return pins
	}

	override run() {
		val pins = getPins
		while(!Thread.interrupted) {
			val pin = pins.get(2)
			val level = hal.getPinLevel(pin)
			if(pinStatus.get(pin) != level) { // it has changed
				locator.trackElementStateSender.sendTurnoutState(id, if(level==Signal.High) TurnoutState.STRAIGHT else TurnoutState.DIVERGENT )
			}
			pinStatus.put(pin, level)
			Thread.sleep(100)
		}
	}

}
