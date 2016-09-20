package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import org.slf4j.Logger

class TrackCommunicationServiceLocator {

	val CommunicationStack stack

	val TrackElementStateSender tess
	val TrackElementCommander tec
	val TrackElementCommandCallback tecc
	val TrackElementStateRegistry tsr
	val Logger logger

	new(CommunicationStack _stack,Logger logger) {
		this.logger = logger
		stack = _stack
		stack.start

		tess = new TrackElementStateSender(stack.mms, logger)
		tec = new TrackElementCommander(stack.mms, logger)
		tecc = new TrackElementCommandCallback(stack.dispatcher as ProtobufMessageDispatcher, logger)
		tsr = new TrackElementStateRegistry(stack.dispatcher as ProtobufMessageDispatcher, logger)
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
}
