package hu.bme.mit.inf.modes3.components.trackelementcontroller.controllers

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioNotConfiguratedException
import hu.bme.mit.inf.modes3.components.trackelementcontroller.config.ExpanderConfigInterpreter
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * The state controller of a segment.
 * It can enable or disable a segment physically through the GPIO ports.
 * Enable/disable means if any train can/cannot move physically on that segment. 
 * 
 * @author hegyibalint
 */
class PhysicalSegmentController {

	/**
	 * for each physical segment controller instance, there should be 
	 * two GPIO instance two serve the control mechanism
	 * 
	 * one instance will represent the application processor control,
	 * and the other one will represent the PRU 
	 * 
	 * currently, there is no PRU activity in control, therefore the application
	 * processor need to act as an PRU also
	 */
	private Gpio appControl;

	private Gpio pruControl;

	val Logger logger

	/**
	 * @param pinout the interpeter of the pinout configuration
	 * @param expander the ID of the expander that controls the segment (physically)
	 * @param factory the logger factory
	 */
	new(ExpanderConfigInterpreter pinout, String expander, ILoggerFactory factory) {
		logger = factory.getLogger(PhysicalSegmentController.name);
		val String[] pins = pinout.getHeaderPins(expander);
		try {
			appControl = GpioManager.getGpio(pins.get(0), Gpio.Direction.OUT);
			pruControl = GpioManager.getGpio(pins.get(1), Gpio.Direction.OUT);

			appControl.level = Gpio.Level.LOW;
			pruControl.level = Gpio.Level.LOW;

		} catch(GpioNotConfiguratedException ex) {
			// TODO this exception should be handled correctly!
			logger.debug("GPIO pin could not be setted!", ex);
		}
	}
	
	/**
	 * Enables/disables the segment physically, depending on the paramter.
	 * 
	 * @param state the state of the segment
	 */
	def setSegmentState(SegmentState state) {
		try {
			switch state {
				case ENABLED: {
					appControl.level = Gpio.Level.HIGH
					pruControl.level = Gpio.Level.HIGH
				}
				case DISABLED: {
					appControl.level = Gpio.Level.LOW
					pruControl.level = Gpio.Level.LOW
				}
			}
		} catch(Exception ex) {
			// TODO this exception should be handled correctly!
			logger.debug("Exception during segment state setting!", ex);
		}
	}

	/**
	 * @return the recent state of the segment
	 */
	def getSegmentState() {
		// segment is only enabled when all of these gpios are HIGH
		if(appControl.level == Gpio.Level.HIGH && pruControl.level == Gpio.Level.HIGH) {
			return SegmentState.ENABLED;
		}

		// otherwise the HW and gate will disable the segment
		return SegmentState.DISABLED;
	}

}
