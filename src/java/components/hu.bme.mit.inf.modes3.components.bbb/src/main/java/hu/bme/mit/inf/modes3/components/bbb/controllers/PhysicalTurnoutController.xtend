package hu.bme.mit.inf.modes3.components.bbb.controllers

import hu.bme.mit.inf.modes3.components.bbb.config.ExpanderConfigInterpreter
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.InputStateListener
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioNotConfiguratedException
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

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

	private final static int TURNOUT_IMPULSE_WIDTH = 200;

	val Logger logger

	new(ExpanderConfigInterpreter pinout, String expander, ILoggerFactory factory) {
		logger = factory.getLogger(PhysicalTurnoutController.name);
		val String[] pins = pinout.getHeaderPins(expander);
		try {
			straightControl = GpioManager.getGpio(pins.get(0), Gpio.Direction.OUT);
			divergentControl = GpioManager.getGpio(pins.get(1), Gpio.Direction.OUT);

			straightState = GpioManager.getGpio(pins.get(2), Gpio.Direction.IN);
			divergentState = GpioManager.getGpio(pins.get(3), Gpio.Direction.IN);
		} catch (GpioNotConfiguratedException ex) {
			// TODO this exception should be handled correctly!
			logger.debug("GPIO pin could not be setted!", ex);
		}

		// adding input listeners for state gpios as well
		straightState.addInputStateListener(new InputStateListener() {

			override levelStateChanged(Level newLevel) {
				logger.info('''level state changed on straight sense: «newLevel»''');
			}

		});

		divergentState.addInputStateListener(new InputStateListener() {

			override levelStateChanged(Level newLevel) {
				logger.info('''level state changed on divergent sense: «newLevel»''');
			}

		});
	}

	def setTurnoutState(TurnoutState state) {

		try {

			switch state {
				case DIVERGENT: {
					divergentControl.impulse(TURNOUT_IMPULSE_WIDTH, false);
				}
				case STRAIGHT: {
					straightControl.impulse(TURNOUT_IMPULSE_WIDTH, false);
				}
			}
		} catch (Exception ex) {
			// TODO this exception should be handled correctly!
			logger.debug("Exception during turnout switching!", ex);
		}

	}
}
