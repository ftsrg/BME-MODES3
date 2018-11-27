package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level;

public interface ICommandReader {
	Level getGpioValue(String targetPath) throws IOException;
}
