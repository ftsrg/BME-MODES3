package hu.bme.mit.inf.modes3.components.bbb.controllers

import hu.bme.mit.inf.modes3.components.bbb.config.Configuration
import hu.bme.mit.inf.modes3.components.bbb.config.Pinout
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio.InputStateListener
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.Gpio.Level
import hu.bme.mit.inf.modes3.components.bbb.gpiomanager.GpioManager
import java.util.List
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState

abstract class TurnoutPinChangedHandler {

	List<String> turnoutExpanders;
	List<List<String>> turnoutPins;

	def void handleTurnoutPinChange(TurnoutState state);

	def void resolveExpanders(Configuration config) {
		turnoutExpanders.addAll(config.turnoutExpanders);
	}

	def void resolveExpanderPins(Pinout pinout) {
		turnoutExpanders.forEach [ expander |
			turnoutPins.add(pinout.getHeaderPins(expander));
		]
	}

	def void registerGpios() {
		turnoutPins.forEach [ turnout |
			GpioManager.setGpio(turnout.get(2), Gpio.Direction.IN).addInputStateListener(new InputStateListener {
				override levelStateChanged(Level newLevel) {
					if(newLevel == Gpio.Level.HIGH)
						handleTurnoutPinChange(TurnoutState.STRAIGHT);
				}
			})

			GpioManager.setGpio(turnout.get(3), Gpio.Direction.IN).addInputStateListener(new InputStateListener {
				override levelStateChanged(Level newLevel) {
					if(newLevel == Gpio.Level.HIGH)
						handleTurnoutPinChange(TurnoutState.DIVERGENT);
				}
			})
		]
	}

}
