package hu.bme.mit.inf.modes3.components.bbb.prototypes;

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Stores the pinout header addresses of the BeagleBone Black embedded
 * controller.
 * 
 * The actual configuration file is located at
 * src/main/resources/conf/pinouts.json
 * 
 * @author hegyibalint
 */
class Pinout {

	// the pinout header addresses of the BeagleBone Black embedded controller.
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, String[]> headers

	/**
	 * @return the pinout header configuration
	 * @throws Exception if an error happens
	 */
	static def Pinout loadPinoutConfig() {
		val gson = new Gson
		var InputStreamReader isr = null
		try {
			isr = new InputStreamReader(Pinout.getClassLoader().getResourceAsStream("conf/pinouts.json"))
			val reader = new JsonReader(isr)
			val JsonObject pinout = gson.fromJson(reader, JsonObject)
			gson.fromJson(pinout, Pinout)
		} finally {
			isr?.close
		}
	}
	
	def getHeaderPins(String headerName){
		headers.get(headerName)
	}
}
