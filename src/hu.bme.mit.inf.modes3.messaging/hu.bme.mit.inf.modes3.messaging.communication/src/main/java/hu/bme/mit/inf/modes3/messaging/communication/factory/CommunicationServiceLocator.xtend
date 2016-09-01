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
import hu.bme.mit.inf.modes3.transports.common.ITransport
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport

//@Data
class CommunicationServiceLocator {
	
	val MessagingService mms =  new MessagingService
	val ITransport transport = new ZMQTransport 
	val ProtobufMessageDispatcher dispatcher = new ProtobufMessageDispatcher
	val tess = new TrackElementStateSender(mms)
	val tec = new TrackElementCommander(mms)
	val tecc  = new TrackElementCommandCallback(dispatcher)
	val tsr =  new TrackElementStateRegistry(dispatcher)
	
	new(){
		mms.start(transport, dispatcher)		
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
