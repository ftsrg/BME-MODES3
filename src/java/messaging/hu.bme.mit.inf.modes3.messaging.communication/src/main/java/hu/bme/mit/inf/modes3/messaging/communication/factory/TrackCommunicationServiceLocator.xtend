package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.communication.command.SendAllStatusCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.TrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.computervision.ComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.computervision.IComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed.TrainReferenceSpeedState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackCommunicationServiceLocator {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	val MessagingService messagingService

	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementStateSender trackElementStateSender
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementCommander trackElementCommander
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementCommandCallback trackElementCommandCallback
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementStateRegistry trackElementStateRegistry
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val TrainReferenceSpeedState trainReferenceSpeedState
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val SendAllStatusCommandCallback sendAllStatusCallback
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val IComputerVisionCallback computerVisionCallback

	new(MessagingService messagingService, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.messagingService = messagingService
		messagingService.start

		trackElementStateSender = new TrackElementStateSender(messagingService, factory)
		trackElementCommander = new TrackElementCommander(messagingService, factory)
		trackElementCommandCallback = new TrackElementCommandCallback(messagingService.dispatcher, factory)
		trackElementStateRegistry = new TrackElementStateRegistry(messagingService.dispatcher, factory)
		trainReferenceSpeedState = new TrainReferenceSpeedState(messagingService.dispatcher, factory)
		sendAllStatusCallback = new SendAllStatusCommandCallback(messagingService.dispatcher, factory)
		computerVisionCallback = new ComputerVisionCallback(messagingService.dispatcher, factory)
	}
}
