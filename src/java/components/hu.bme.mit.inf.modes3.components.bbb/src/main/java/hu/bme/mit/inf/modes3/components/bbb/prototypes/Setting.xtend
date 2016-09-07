package hu.bme.mit.inf.modes3.components.bbb.prototypes;

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import java.io.InputStreamReader
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Stores the actual pinout header configuration of the respective
 * BeagleBoneBlack embedded controller, based on the turnout ID.
 * 
 * The actual configuration file is located at
 * src/main/resources/conf/settings.json
 * 
 * @author hegyibalint
 */
class Setting {

	/**
	 * Stores the managed turnouts ID [key], and the pinout header value through
	 * that turnout's status (divergent/straight) is measurable.
	 */
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, Integer> turnouts

	/**
	 * Stores the managed sections ID [key], and the pinout header value through
	 * that sections are controllable.
	 */
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, Integer> sections

	/**
	 * The deserialized configuration of the pinout headers, based on the
	 * turnout ID. In this way the managed turnout's and sections pinout header
	 * values are deserialized so the respective actuators can be addressed.
	 * 
	 * @param id the ID of the respective turnout (switch)
	 * @return the pinout configuration
	 * @throws Exception
	 */
	static def Setting loadPinoutConfig(int id) throws Exception {
		val gson = new Gson
		var InputStreamReader isr = null
		try {
			isr = new InputStreamReader(Pinout.classLoader.getResourceAsStream("conf/settings.json"))
			val reader = new JsonReader(isr)
			var JsonObject settings = gson.fromJson(reader, JsonObject)
			settings = settings.get("settings").asJsonObject
			gson.fromJson(settings.get(HexConversionUtil.fromNumber(id)), Setting)
		} finally {
			isr?.close
		}
	}

	/**
	 * Tells whether this embedded controller manages the referred turnout.
	 * 
	 * @param turnoutId that should be examined if it is managed
	 * @return true if the respective turnout is managed by this embedded
	 * controller
	 */
	def containsTurnout(int turnoutId) {
		turnouts.containsKey(HexConversionUtil.fromNumber(turnoutId))
	}

	/**
	 * Tells whether this embedded controller manages the referred section.
	 * 
	 * @param sectionId that should be examined if it is managed
	 * @return true if the respective section is managed by this embedded
	 * controller
	 */
	def containsSection(int sectionId) {
		sections.containsKey(HexConversionUtil.fromNumber(sectionId))
	}

	def getTurnoutNames() {
		turnouts.keySet
	}

	def getSectionNames() {
		sections.keySet
	}

	def getTurnoutPinoutHeaderValue(String turnout) {
		turnouts.get(turnout)
	}

	def getSectionPinoutHeaderValue(String section) {
		sections.get(section)
	}
}
