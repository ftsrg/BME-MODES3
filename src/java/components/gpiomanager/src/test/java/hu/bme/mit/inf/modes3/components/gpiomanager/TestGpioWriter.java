package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestGpioWriter implements CommandWriter {

	private static final String TAG = "GPIOTestWriter";

	private Map<String, String> infos;

	public TestGpioWriter() {
		infos = new HashMap<String, String>();
	}

	@Override
	public void executeCommand(String value, String targetFile) throws IOException {
		Logger.info(TAG, "Trying to write \"%s\" to %s", value, targetFile);
//		try (BufferedWriter w = new BufferedWriter(new FileWriter("testData"))) {
		try {
			infos.put(targetFile.substring(targetFile.lastIndexOf("/") + 1), value);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		Logger.info(TAG, "Succeeded!");

	}

	public Map<String, String> getInfos() {
		return infos;
	}

}
