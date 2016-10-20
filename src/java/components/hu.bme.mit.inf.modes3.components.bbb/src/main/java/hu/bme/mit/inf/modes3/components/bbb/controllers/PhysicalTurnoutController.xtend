package hu.bme.mit.inf.modes3.components.bbb.controllers

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.InputStateListener
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.bbb.config.Pinout
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

class PhysicalTurnoutController {

	/**
	 * for each turnout controller, we have to use four gpio pins:
	 * two for control the turnout itself, and other two to get info
	 * about the current state
	 */
	Gpio straightControl;

	Gpio divergentControl;

	Gpio straightState;

	Gpio divergentState;

	new(Pinout pinout, String expander) {
		val String[] pins = pinout.getHeaderPins(expander);
		straightControl = GpioManager.getGpio(pins.get(0), Gpio.Direction.OUT);
		divergentControl = GpioManager.getGpio(pins.get(1), Gpio.Direction.OUT);

		straightState = GpioManager.getGpio(pins.get(2), Gpio.Direction.IN);
		divergentState = GpioManager.getGpio(pins.get(3), Gpio.Direction.IN);
		
		// adding inputlisteners for state gpios as well
		
		straightState.addInputStateListener(new InputStateListener() {
			
			override levelStateChanged(Level newLevel) {
				System.out.println('level state changed on straight sense: '+newLevel.toString);
			}
			
		});
		
		divergentState.addInputStateListener(new InputStateListener() {
			
			override levelStateChanged(Level newLevel) {
				System.out.println('level state changed on divergent sense: '+newLevel.toString);
			}
			
		});
	}
	
	def setTurnoutState(TurnoutState state) {
		
		switch state {
			case DIVERGENT: {
				divergentControl.impulse(1000, false);
			}
			
			case STRAIGHT: {
				straightControl.impulse(1000, false);
			}
		}
	}

}
