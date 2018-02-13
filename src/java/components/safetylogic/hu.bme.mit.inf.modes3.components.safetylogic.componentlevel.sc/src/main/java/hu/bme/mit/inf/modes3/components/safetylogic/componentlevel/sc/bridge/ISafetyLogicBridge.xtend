package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher.IYakinduMessageSender
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.IYakinduProtocolDispatcher
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry

interface ISafetyLogicBridge extends IYakinduMessageSender, IYakinduProtocolDispatcher {
	
	def IYakinduProtocolDispatcher getYakinduProtocolDispatcher()

	def ITrackElementCommander getTrackElementCommander()

	def ITrackElementStateRegistry getTrackElementStateRegistry()
}
