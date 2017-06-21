package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.computervision.ComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed.TrainReferenceSpeedState
import hu.bme.mit.inf.modes3.messaging.communication.update.SendAllStatusCallback
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import hu.bme.mit.inf.modes3.messaging.communication.computervision.IComputerVisionCallback

class TrackCommunicationServiceLocator {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	val CommunicationStack stack
	
	val TrackElementStateSender tess
	val TrackElementCommander tec
	val TrackElementCommandCallback tecc
	val TrackElementStateRegistry tsr
	val TrainReferenceSpeedState trss 
	val SendAllStatusCallback sasc
	val ComputerVisionCallback cvc

	new(CommunicationStack _stack, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		stack = _stack
		stack.start

		tess = new TrackElementStateSender(stack.mms, factory)
		tec = new TrackElementCommander(stack.mms, factory)
		tecc = new TrackElementCommandCallback(stack.dispatcher as ProtobufMessageDispatcher, factory)
		tsr = new TrackElementStateRegistry(stack.dispatcher as ProtobufMessageDispatcher, factory)
		trss = new TrainReferenceSpeedState(stack.dispatcher as ProtobufMessageDispatcher, factory)
		sasc = new SendAllStatusCallback(stack.dispatcher as ProtobufMessageDispatcher, factory)
		cvc = new ComputerVisionCallback(stack.dispatcher as ProtobufMessageDispatcher, factory)
	}

	def ITrackElementStateSender getTrackElementStateSender() {
		return tess
	}

	def ITrackElementCommander getTrackElementCommander() {
		return tec
	}

	def ITrackElementCommandCallback getTrackElementCommandCallback() {
		return tecc
	}

	def ITrackElementStateRegistry getTrackElementStateRegistry() {
		return tsr
	}
	
	def TrainReferenceSpeedState getTrainReferenceSpeedState(){
		return trss
	}
	
	def SendAllStatusCallback getSendAllStatusCallback(){
		return sasc
	}
	
	def IComputerVisionCallback getComputerVisionCallback(){
		return cvc
	}
}
