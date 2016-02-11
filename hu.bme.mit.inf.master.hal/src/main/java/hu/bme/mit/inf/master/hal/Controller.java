package hu.bme.mit.inf.master.hal;

import java.io.IOException;

import com.google.gson.Gson;

import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Section;
import net.openhft.chronicle.Chronicle;
import net.openhft.chronicle.ChronicleQueueBuilder;
import net.openhft.chronicle.ExcerptTailer;

public class Controller {

	public void start() throws IOException {
		String basePath = System.getProperty("java.io.tmpdir");
		Chronicle halChronicle = ChronicleQueueBuilder.indexed(basePath + "/modes3_hal").build();

		ExcerptTailer reader = halChronicle.createTailer();
		while(!reader.nextIndex());
		
		Gson gson = new Gson();
		while (true) {
			Section section = gson.fromJson(reader.asString().toString(), Section.class);
			reader.finish();
		}
	}

}
