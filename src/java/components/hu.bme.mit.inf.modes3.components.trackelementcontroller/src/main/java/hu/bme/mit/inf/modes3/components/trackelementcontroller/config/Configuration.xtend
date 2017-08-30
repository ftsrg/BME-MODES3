package hu.bme.mit.inf.modes3.components.trackelementcontroller.config;

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader
import java.util.List
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Stores the actual pinout header configuration of the respective
 * BeagleBoneBlack embedded controller, based on the turnout ID.
 * 
 * The actual configuration file is located at
 * src/main/resources/conf/settings.json
 * 
 * @author hegyibalint
 */
class Configuration {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) static var Logger logger

	/**
	 * Stores the managed turnouts ID [key], and the pinout header value through
	 * that turnout's status (divergent/straight) is measurable.
	 */
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var List<String> turnouts

	/**
	 * Stores the managed sections ID [key], and the pinout header value through
	 * that sections are controllable.
	 */
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, String> sections

	/**
	 * The deserialized configuration of the pinout headers, based on the
	 * turnout ID. In this way the managed turnout's and sections pinout header
	 * values are deserialized so the respective actuators can be addressed.
	 * 
	 * @param id the ID of the respective turnout (switch)
	 * @return the pinout configuration
	 * @throws Exception
	 */
	static def Configuration loadPinoutConfig(int id, ILoggerFactory factory) {
		logger = factory.getLogger(ExpanderConfigInterpreter.name)

		val gson = new Gson
		var InputStreamReader isr = null
		var JsonReader reader = null
		try {
			isr = new InputStreamReader(Configuration.classLoader.getResourceAsStream("config.json"))
			reader = new JsonReader(isr)
			var JsonObject config = gson.fromJson(reader, JsonObject)
			gson.fromJson(config.get("t" + Integer.valueOf(id)), typeof(Configuration))
		} catch(Exception ex){
			logger.error(ex.message, ex)
			throw ex
		} finally {
			isr?.close
			reader?.close
		}
	}

	/**
	 * Tells whether this embedded controller manages the referred section.
	 * 
	 * @param sectionId that should be examined if it is managed
	 * @return true if the respective section is managed by this embedded
	 * controller
	 */
	def containsSection(int sectionId) {
		sections.containsKey(sectionId)
	}

	def getSectionNames() {
		sections.keySet
	}

	def getTurnoutExpanders() {
		turnouts
	}

	def getSectionExpander(int sectionID) {
		sections.get(sectionID.toString)
	}
}
