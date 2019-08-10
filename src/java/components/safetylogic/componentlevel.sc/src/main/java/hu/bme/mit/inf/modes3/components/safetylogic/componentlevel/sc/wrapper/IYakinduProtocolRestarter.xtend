package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface

/**
 * An interface to restart the Yakindu protocol.
 * 
 * @author benedekh
 */
interface IYakinduProtocolRestarter {
	/**
	 * Registers a section by its interface.
	 * 
	 * @param section the section to be registered
	 */
	def void registerSection(SectionControlInterface.Provided section)
}