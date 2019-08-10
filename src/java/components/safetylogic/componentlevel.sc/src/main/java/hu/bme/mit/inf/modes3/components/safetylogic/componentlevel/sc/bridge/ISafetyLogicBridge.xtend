package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.IYakinduProtocolDispatcher
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.IYakinduMessageSender

/**
 * The bridge between the component-level safety logic application and the communication network.
 * 
 * @author benedekh
 */
interface ISafetyLogicBridge extends IYakinduMessageSender, IYakinduProtocolDispatcher {
	
	/**
	 * @return the dispatcher of the messages for the Yakindu protocol
	 */
	def IYakinduProtocolDispatcher getYakinduProtocolDispatcher()

	/**
	 * @return the track element commander
	 */
	def ITrackElementCommander getTrackElementCommander()
	
	/**
	 * @return the track element state registry
	 */
	def ITrackElementStateRegistry getTrackElementStateRegistry()
}
