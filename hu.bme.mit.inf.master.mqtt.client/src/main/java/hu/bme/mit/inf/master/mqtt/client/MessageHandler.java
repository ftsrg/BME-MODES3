package hu.bme.mit.inf.master.mqtt.client;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.gson.Gson;

import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Payload;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Section;
import hu.bme.mit.inf.master.mqtt.client.handlers.HardwareHandler;
import hu.bme.mit.inf.master.mqtt.client.handlers.YakinduHandler;
import net.openhft.chronicle.Chronicle;
import net.openhft.chronicle.ChronicleQueueBuilder;
import net.openhft.chronicle.ExcerptAppender;
import net.openhft.chronicle.ExcerptTailer;

public class MessageHandler implements MqttCallback {
		
	private Logger logger = Logger.getLogger(Class.class.getName());
	private List<Integer> sectionsNumbers;
	
	HardwareHandler hwHandler;
	YakinduHandler yakinduHandler;
	
	public MessageHandler() throws IOException {
		Map<String, String> env = System.getenv();
		if (!env.containsKey("TURNOUT_ID")) {
			throw new RuntimeException("No TURNOUR_ID environmental variable is set.");
		}
		if (!env.containsKey("SECTIONS")) {
			throw new RuntimeException("No TURNOUR_ID environmental variable is set.");
		}
		
		try {
			String sectionsIDs[] = env.get("SECTIONS").split(";");
			for (String ss : sectionsIDs) {
				sectionsNumbers.add(Integer.parseInt(ss));
			}
		} catch (Exception e) {
			throw new RuntimeException("Cannot parse SECTIONS into integers");
		}
		
		String basePath = System.getProperty("java.io.tmpdir");
	}
	
	public void connectionLost(Throwable cause) {
		Logger logger = Logger.getLogger(this.getClass().getName());
		logger.info("Connection lost");
	}

	public void messageArrived(String topic, MqttMessage message) throws IOException {
		Gson gson = new Gson();
		Payload p = gson.fromJson(new String(message.getPayload()), Payload.class);
		
		switch (p.getCommand()) {
		case LINE_ENABLE:
		case LINE_DISABLE:
			hwHandler.handleWithoutResponse(p.getContent());
			
		case SEND_SECTION_STATUS:
		case SEND_TURNOUT_STATUS:
			
			
		case GET_SECTION_STATUS:
		case GET_TURNOUT_STATUS:
		case IDENTIFY:

		case SEND_OCCUPANCY:
		case GET_OCCUPANCY:
		default:
			break;
		}
	}

	public void deliveryComplete(IMqttDeliveryToken token) { }

}
