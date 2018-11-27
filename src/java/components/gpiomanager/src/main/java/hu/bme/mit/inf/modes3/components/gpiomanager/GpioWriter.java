package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GpioWriter implements ICommandWriter {
	private static final String TAG = "GPIOWriter";

	public void executeCommand(String value, String targetFile) throws IOException {
		Logger.info(TAG, "Trying to write \"%s\" to %s", value, targetFile);
		try (BufferedWriter w = new BufferedWriter(new FileWriter(targetFile))) {
			w.append(value);
			w.newLine();
			w.flush();
		}
		Logger.info(TAG, "Succeeded!");
	}

}
