package hu.bme.mit.inf.modes3.components.bbb.conf;

import hu.bme.mit.inf.modes3.components.bbb.prototypes.Configuration
import hu.bme.mit.inf.modes3.components.bbb.prototypes.Pinout
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
	@Accessors(PACKAGE_GETTER, PACKAGE_SETTER) var Configuration config

	/**
	 * Creates a new pinout and setting configuration based on the TURNOUT_ID
	 * environmental variable.
	 * 
	 * @throws Exception if TURNOUT_ID is not a valid environmental variable
	 */
	new(int turnoutID, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)

		pinout = Pinout.loadPinoutConfig(factory)
		config = Configuration.loadPinoutConfig(turnoutID, factory)
	}

	def controllerManagesTurnout(int turnoutId) {
		config.containsTurnout(turnoutId)
	}

	def controllerManagesSection(int sectionId) {
		config.containsSection(sectionId)
	}

	/**
	 * @return the managed turnouts ID as String
	 */
	def getAllTurnout() {
		config.turnoutNames
	}

	/**
	 * @return the managed sections ID as String
	 */
	def getAllSection() {
		config.sectionNames
	}

	def String[] getSectionExpander(int sectionId) {
		val expander = config.getSectionExpander(sectionId)
		pinout.getHeaderPins(String.valueOf(expander))
	}

	def String[] getTurnoutExpander(int turnoutId) {
		val expander = config.getTurnoutExpander(turnoutId)
		pinout.getHeaderPins(String.valueOf(expander))
	}

}
