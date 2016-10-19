package hu.bme.mit.inf.modes3.components.bbb.controllers

import hu.bme.mit.inf.modes3.components.bbb.config.Pinout
import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio
import hu.bme.mit.inf.modes3.components.gpiomanager.GpioManager
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState

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
	
	new(Pinout pinout, String expander) {
		val String[] pins = pinout.getHeaderPins(expander);
		appControl = GpioManager.getGpio(pins.get(0), Gpio.Direction.OUT);
		pruControl = GpioManager.getGpio(pins.get(1), Gpio.Direction.OUT);
	}
	
	def setSegmentState(SegmentState state) {
		
		switch state {
			case ENABLED: {
				appControl.level = Gpio.Level.HIGH
				pruControl.level = Gpio.Level.HIGH				
			}
				
			case DISABLED:{
				appControl.level = Gpio.Level.LOW
				pruControl.level = Gpio.Level.LOW
			}
				
		}
	}
	
}