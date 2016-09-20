package hu.bme.mit.inf.modes3.components.bbb.conf;

import hu.bme.mit.inf.modes3.components.bbb.prototypes.Pinout
import hu.bme.mit.inf.modes3.components.bbb.prototypes.Setting
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * API for the embedded controller.
 * 
 * @author hegyibalint
 */
class ExpanderControllerConfiguration {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	// the pinout header configuration
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) var Pinout pinout

	// contains the managed turnouts and sections ID
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) var Setting setting

	/**
	 * Creates a new pinout and setting configuration based on the TURNOUT_ID
	 * environmental variable.
	 * 
	 * @throws Exception if TURNOUT_ID is not a valid environmental variable
	 */
	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)

		val env = System.getenv
		if(!env.containsKey("TURNOUT_ID")) {
			val ex = new Exception('''There is no TURNOUT_ID environmental variable defined''')
			logger.error(ex.message, ex)
			throw ex
		}
		val controllerID = Integer.valueOf(env.get("TURNOUT_ID"))

		pinout = Pinout.loadPinoutConfig(factory)
		setting = Setting.loadPinoutConfig(controllerID, factory)
	}

	def controllerManagesTurnout(int turnoutId) {
		setting.containsTurnout(turnoutId)
	}

	def controllerManagesSection(int sectionId) {
		setting.containsSection(sectionId)
	}

	/**
	 * @return the managed turnouts ID as String
	 */
	def getAllTurnout() {
		setting.turnoutNames
	}

	/**
	 * @return the managed sections ID as String
	 */
	def getAllSection() {
		setting.sectionNames
	}

	def getSectionExpander(int sectionId) {
		val expander = setting.getSectionPinoutHeaderValue(sectionId)
		pinout.getHeaderPins(String.valueOf(expander))
	}

	def getTurnoutExpander(int turnoutId) {
		val expander = setting.getTurnoutPinoutHeaderValue(turnoutId)
		pinout.getHeaderPins(String.valueOf(expander))
	}

}
