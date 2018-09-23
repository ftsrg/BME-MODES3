package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level;

public class TestGpioReader implements CommandReader {

	@Override
	public Level getGpioValue(String targetPath) throws IOException {
		return Level.HIGH;
	}

}
