package hu.bme.mit.inf.modes3.messaging.mms.dispatcher

import com.google.protobuf.GeneratedMessageV3
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message.MessageType
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentCommandOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegment
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegmentOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeed
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeedOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionCommandOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeed
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedCommandOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutCommandOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder
import org.eclipse.xtend.lib.annotations.Accessors

class ProtobufMessageDispatcher implements IMessageDispatcher {

	// SIGNALS
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainCurrentSpeedOrBuilder> trainCurrentSpeedHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainReferenceSpeedOrBuilder> trainReferenceSpeedHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainCurrentSegmentOrBuilder> trainCurrentSegmentHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TurnoutStateOrBuilder> turnoutStateHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<SegmentStateOrBuilder> segmentStateHandler

	// COMMANDS
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainReferenceSpeedCommandOrBuilder> trainReferenceSpeedCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainFunctionCommandOrBuilder> trainFunctionCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TurnoutCommandOrBuilder> turnoutCommandHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<SegmentCommandOrBuilder> segmentCommandHandler

	override dispatchMessage(byte[] raw_message) {
		val message = Message.parseFrom(raw_message)
		switch (message.type as MessageType) {
			case Message.MessageType.SEGMENT_COMMAND: segmentCommandHandler?.handleMessage(message.segmentCommand)
			case Message.MessageType.SEGMENT_STATE: segmentStateHandler?.handleMessage(message.segmentState)
			case Message.MessageType.TRAIN_CURRENT_SEGMENT: trainCurrentSegmentHandler?.handleMessage(message.trainCurrentSegment)
			case Message.MessageType.TRAIN_CURRENT_SPEED: trainCurrentSpeedHandler?.handleMessage(message.trainCurrentSpeed)
			case Message.MessageType.TRAIN_FUNCTION_COMMAND: trainFunctionCommandHandler?.handleMessage(message.trainFunctionCommand)
			case Message.MessageType.TRAIN_REFERENCE_SPEED: trainReferenceSpeedHandler?.handleMessage(message.trainReferenceSpeed)
			case Message.MessageType.TRAIN_REFERENCE_SPEED_COMMAND: trainReferenceSpeedCommandHandler?.handleMessage(message.trainReferenceSpeedCommand)
			case Message.MessageType.TURNOUT_COMMAND: turnoutCommandHandler?.handleMessage(message.turnoutCommand)
			case Message.MessageType.TURNOUT_STATE: turnoutStateHandler?.handleMessage(message.turnoutState)
			default: return
		}
	}

	override convertMessageToRaw(Object _message) throws IllegalArgumentException {
		try {
			internalConvertMessageToRaw(_message as GeneratedMessageV3);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e.message, e)
		}
	}

	def dispatch byte[] internalConvertMessageToRaw(SegmentCommand _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.SEGMENT_COMMAND
		message.segmentCommand = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(SegmentState _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.SEGMENT_STATE
		message.segmentState = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainCurrentSegment _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_CURRENT_SPEED
		message.trainCurrentSegment = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainCurrentSpeed _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_CURRENT_SPEED
		message.trainCurrentSpeed = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainFunctionCommand _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_FUNCTION_COMMAND
		message.trainFunctionCommand = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainReferenceSpeed _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_REFERENCE_SPEED
		message.trainReferenceSpeed = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainReferenceSpeedCommand _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_REFERENCE_SPEED_COMMAND
		message.trainReferenceSpeedCommand = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TurnoutCommand _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TURNOUT_COMMAND
		message.turnoutCommand = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TurnoutState _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TURNOUT_STATE
		message.turnoutState = _message
		message.build.toByteArray
	}

}
