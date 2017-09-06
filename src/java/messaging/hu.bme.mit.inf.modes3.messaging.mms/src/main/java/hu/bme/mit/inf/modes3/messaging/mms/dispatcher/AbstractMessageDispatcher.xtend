package hu.bme.mit.inf.modes3.messaging.mms.dispatcher

import hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainFunctionCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.status.ComputerVisionObjectPositionsMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.DccOperationsStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSegmentMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSpeedMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.mms.handler.IMessageHandler
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainFunctionStateMessage

abstract class AbstractMessageDispatcher implements IMessageDispatcher {

	// STATUSES
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TrainCurrentSpeedMessage> trainCurrentSpeedHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TrainReferenceSpeedMessage> trainReferenceSpeedHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TrainCurrentSegmentMessage> trainCurrentSegmentHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TrainFunctionStateMessage> trainFunctionStateHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TurnoutStateMessage> turnoutStateHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<SegmentStateMessage> segmentStateHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<SegmentOccupancyMessage> segmentOccupancyHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<DccOperationsStateMessage> dccOperationStateHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<ComputerVisionObjectPositionsMessage> computerVisionObjectPositionsHandler

	// COMMANDS
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TrainReferenceSpeedCommand> trainReferenceSpeedCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TrainFunctionCommand> trainFunctionCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<TurnoutCommand> turnoutCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<SegmentCommand> segmentCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<SendAllStatusCommand> sendAllStatusHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var IMessageHandler<DccOperationsCommand> dccOperationCommandHandler

}
