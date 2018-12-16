package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Direction;

public class GpioProvider {
	public static Gpio getGpioInstance(int pin, Direction direction) throws IOException {
		Gpio _gpio = new Gpio(pin, direction, new GpioWriter(), new GpioReader());
		_gpio.initializeGpio();
		return _gpio;
	}

}