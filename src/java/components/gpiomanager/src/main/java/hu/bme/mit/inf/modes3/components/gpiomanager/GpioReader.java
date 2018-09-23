package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import hu.bme.mit.inf.modes3.components.gpiomanager.Gpio.Level;

public class GpioReader implements CommandReader {

	@Override
	public Level getGpioValue(String targetPath) throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(targetPath))) {
			return reader.readLine().equals("1") ? Level.HIGH : Level.LOW;
		}

	}

}
