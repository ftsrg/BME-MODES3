package hu.bme.mit.inf.modes3.components.trackelementcontroller.config;

import hu.bme.mit.inf.modes3.components.util.gson.GsonLoader
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Stores the pinout header addresses of the BeagleBone Black embedded
 * controller.
 * 
 * The actual configuration file is located at
 * src/main/resources/conf/pinouts.json
 * 
 * @author hegyibalint
 */
class ExpanderConfigInterpreter {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) static var Logger logger

	// the pinout header addresses of the BeagleBone Black embedded controller.
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var Map<String, String[]> headers

	/**
	 * @return the pinout header configuration
	 * @throws Exception if an error happens
	 */
	static def ExpanderConfigInterpreter loadPinoutConfig(ILoggerFactory factory) {
		logger = factory.getLogger(ExpanderConfigInterpreter.name)

		try {
			GsonLoader.loadTypeFromInputStream(ExpanderConfigInterpreter,
				ExpanderConfigInterpreter.classLoader.getResourceAsStream("pinouts.json"))
		} catch (Exception ex) {
			logger.error(ex.message, ex)
			throw ex
		}
	}

	def String[] getHeaderPins(String headerName) {
		val pins = headers.get(headerName.replaceAll("[HL]", ""))

		if (headerName.endsWith('L')) {
			#[pins.get(0), pins.get(2)]
		} else if (headerName.endsWith('H')) {
			#[pins.get(1), pins.get(3)]
		} else {
			pins
		}

	}
}
