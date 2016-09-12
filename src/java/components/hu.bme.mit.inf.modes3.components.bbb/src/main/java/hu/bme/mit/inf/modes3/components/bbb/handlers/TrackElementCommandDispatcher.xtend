package hu.bme.mit.inf.modes3.components.bbb.handlers

import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

class TrackElementCommandDispatcher extends AbstractCommunicationComponent{
	
	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) val TrackElementCommandCallback commandCallback
	
	new(CommunicationStack stack){
		super(stack)
		commandCallback = new TrackElementCommandCallback(super.communication.dispatcher as ProtobufMessageDispatcher)
	}
	
}