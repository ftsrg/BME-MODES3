package hu.bme.mit.inf.modes3.messaging.communication.factory

import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.DccCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.dcc.interfaces.IDccCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.SendAllStatusCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.TrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISendAllStatusCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.train.TrainCommander
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.ComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.TrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.TrainSpeedStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateRegistry
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrackCommunicationServiceLocator {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	val MessagingService messagingService

	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementStateSender trackElementStateSender
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementCommander trackElementCommander
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrainCommander trainCommander
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val IDccCommander dccCommander
	
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementCommandCallback trackElementCommandCallback
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrackElementStateRegistry trackElementStateRegistry
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ITrainSpeedStateRegistry trainSpeedStateRegistry
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val ISendAllStatusCommandCallback sendAllStatusCallback
	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) val IComputerVisionCallback computerVisionCallback

	new(MessagingService messagingService, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)
		this.messagingService = messagingService
		messagingService.start

		trackElementStateSender = new TrackElementStateSender(messagingService, factory)
		trackElementCommander = new TrackElementCommander(messagingService, factory)
		trainCommander = new TrainCommander(messagingService, factory)
		dccCommander = new DccCommander(messagingService, factory)
		
		trackElementCommandCallback = new TrackElementCommandCallback(messagingService.dispatcher, factory)
		trackElementStateRegistry = new TrackElementStateRegistry(messagingService.dispatcher, factory)
		trainSpeedStateRegistry = new TrainSpeedStateRegistry(messagingService.dispatcher, factory)
		sendAllStatusCallback = new SendAllStatusCommandCallback(messagingService.dispatcher, factory)
		computerVisionCallback = new ComputerVisionCallback(messagingService.dispatcher, factory)
	}
}
