package hu.bme.mit.inf.json.prototypes;

import com.google.gson.Gson;

import hu.bme.mit.inf.kvcontrol.mqtt.client.data.Section;
import hu.bme.mit.inf.kvcontrol.mqtt.client.data.SectionStatus;

public class TestSerialization {
	
	public static void main(String[] args) {
		Section s = new Section(0x21, SectionStatus.ENABLED);
		Gson gson = new Gson();
		
		String json = gson.toJson(s);
		
	}

}
