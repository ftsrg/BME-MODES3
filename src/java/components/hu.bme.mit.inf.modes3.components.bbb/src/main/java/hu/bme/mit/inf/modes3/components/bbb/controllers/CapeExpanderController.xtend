package hu.bme.mit.inf.modes3.components.bbb.controllers

import hu.bme.mit.inf.modes3.components.bbb.Signal
import hu.bme.mit.inf.modes3.components.bbb.config.Pinout
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.IExpanderController
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.IPinController
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class CapeExpanderController implements IExpanderController {

	Pinout pinout
	IPinController pinController
	Logger logger

	new(IPinController pinController, ILoggerFactory factory) {
		this.pinout = Pinout::loadPinoutConfig(factory)
		this.pinController = pinController
		this.logger = factory.getLogger(this.class.name)
	}

	override setSegmentExpanderLevel(String expanderID, SegmentState state) {
		logger.info('''Expander «expanderID» set to «state.name»''')

		val pins = pinout.getHeaderPins(expanderID)
		pins.forEach[pin|
			pinController.setPinLevel(pin, if (state == SegmentState.ENABLED) Signal.HIGH else Signal.LOW) 
		]
	}

	override setTurnoutExpanderLevel(String expanderID, TurnoutState state) {
		logger.info('''Turnout «expanderID» set to «state.name»''')
		
		val pins = pinout.getHeaderPins(expanderID)
		if (state == TurnoutState.STRAIGHT) {
			pinController.pinImpulse(pins.get(0), 100)
		} else {
			pinController.pinImpulse(pins.get(1), 100)
		}
	}
	
	override setTurnoutExpanderChangedHandler(TurnoutPinChangedHandler handler) {
		handler.resolveExpanderPins(pinout)
		pinController.turnoutPinChangedHandler = handler
	}

}
