package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.Transport

class CommunicationServiceLocator {
	
	val MessagingService mms 
	val Transport transport
	val ProtobufMessageDispatcher dispatcher 
	val TrackElementStateSender tess
	val TrackElementCommander tec
	val TrackElementCommandCallback tecc
	val TrackElementStateRegistry tsr 
		
	new(CommunicationStack stack) {
		mms = stack.mms
		transport = stack.transport
		dispatcher = stack.dispatcher
		mms.start(transport, dispatcher)
		
		tess = new TrackElementStateSender(mms)		
		tec = new TrackElementCommander(mms)
		tecc  = new TrackElementCommandCallback(dispatcher)
		tsr =  new TrackElementStateRegistry(dispatcher)
	}
	
	def ITrackElementStateSender getTrackElementStateSender(){
		return tess
	}
	
	def ITrackElementCommander getTrackElementCommander(){
		return tec
	}
	
	def ITrackElementCommandCallback getTrackElementCommandCallback(){
		return tecc
	}
	
	def ITrackElementStateRegistry getTrackElementStateRegistry(){
		return tsr
	}
}
