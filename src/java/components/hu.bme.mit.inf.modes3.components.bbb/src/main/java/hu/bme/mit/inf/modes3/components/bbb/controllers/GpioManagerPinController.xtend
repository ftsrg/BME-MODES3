package hu.bme.mit.inf.modes3.components.bbb.controllers

import hu.bme.mit.inf.modes3.components.bbb.Signal
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.IPinController
import hu.bme.mit.inf.modes3.components.bbb.controllers.strategy.ITurnoutPinChangedHandler
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio.Direction
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio.InputStateListener
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio.Level
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.GpioManager
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class GpioManagerPinController implements IPinController {
	
	val Logger logger
	var ITurnoutPinChangedHandler turnoutChangeHandler = null
	
	new (ILoggerFactory factory) {
		logger = factory.getLogger(class.name)
				
        GpioManager.setGpioMapping("resources/gpio.json");
	}
	
	override setPinLevel(String pin, Signal level) {
		logger.debug('''Pin «pin» set to «level.name»''')
		
		val gpio = GpioManager.setGpio(pin, Direction.OUT)
		switch (level) {
			case HIGH: gpio.level = Gpio.Level.HIGH
			case LOW: gpio.level = Gpio.Level.LOW
		}
	}
	
	override pinImpulse(String pin, int ms) {
		logger.debug('''Pin «pin» impulse with width of «ms»ms''')
		GpioManager.setGpio(pin, Direction.OUT).impulse(ms, true);
	}
	
	override getPinLevel(String pin) {
		val gpio = GpioManager.setGpio(pin, Direction.IN)
		if (gpio.level == Gpio.Level.HIGH) {
			return Signal.HIGH
		} else {
			return Signal.LOW
		}
	}
	
	override setTurnoutSensePins(String pinDiv, String pinStr) {
		logger.info('''Registering pins div:«pinDiv» str:«pinStr» as turnout sense''')
		
		GpioManager.setGpio(pinDiv, Gpio.Direction.IN).addInputStateListener(new InputStateListener {
			override levelStateChanged(Level newLevel) {
				if (newLevel == Gpio.Level.HIGH)
					turnoutChangeHandler?.handleTurnoutPinChange(true, false);
			}
		})
		
		GpioManager.setGpio(pinStr, Gpio.Direction.IN).addInputStateListener(new InputStateListener {
			override levelStateChanged(Level newLevel) {
				if (newLevel == Gpio.Level.HIGH)
					turnoutChangeHandler?.handleTurnoutPinChange(false, true);
			}
		})
	}
	
	override setTurnoutPinChangedHandler(ITurnoutPinChangedHandler handler) {
		turnoutChangeHandler = handler
	}
	
}