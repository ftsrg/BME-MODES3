package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

interface IYakinduProtocolDispatcher {
	def void registerSegment(int segmentID, PortWithDirection portToBeNotified)
}