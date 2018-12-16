package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;

public interface ICommandWriter {
	void executeCommand(String value, String targetFile) throws IOException;
}
