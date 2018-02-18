package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface

interface IYakinduProtocolRestarter {
	def void registerSection(SectionControlInterface.Provided section)
}