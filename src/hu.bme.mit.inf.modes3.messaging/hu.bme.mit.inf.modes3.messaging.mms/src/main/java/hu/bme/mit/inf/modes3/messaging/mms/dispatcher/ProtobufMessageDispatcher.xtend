package hu.bme.mit.inf.modes3.messaging.mms.dispatcher

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegmentOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeedOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControlOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControlOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControlOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControlOrBuilder
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder
import java.util.Collections
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message.MessageType
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState
import com.google.protobuf.GeneratedMessageV3
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegment
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeed
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeed
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState

class ProtobufMessageDispatcher implements MessageDispatcher {

	// SIGNALS
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainCurrentSpeedOrBuilder> trainCurrentSpeedHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainReferenceSpeedOrBuilder> trainReferenceSpeedHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainCurrentSegmentOrBuilder> trainCurrentSegmentHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TurnoutStateOrBuilder> turnoutStateHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<SegmentStateOrBuilder> segmentStateHandler

	// CONTROLS
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainDirectionControlOrBuilder> trainDirectionControlHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainReferenceSpeedControlOrBuilder> trainReferenceSpeedControlHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TrainFunctionControlOrBuilder> trainFunctionControlHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<TurnoutControlOrBuilder> turnoutControlHandler
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var MessageHandler<SegmentControlOrBuilder> segmentControlHandler

	override dispatchMessage(byte[] raw_message) {
		val message = Message.parseFrom(raw_message)
		switch (message.type as MessageType) {
			case Message.MessageType.SEGMENT_CONTROL: segmentControlHandler?.handleMessage(message.segmentControl)
			case Message.MessageType.SEGMENT_STATE: segmentStateHandler?.handleMessage(message.segmentState)
			case Message.MessageType.TRAIN_CURRENT_SEGMENT: trainCurrentSegmentHandler?.handleMessage(message.trainCurrentSegment)
			case Message.MessageType.TRAIN_CURRENT_SPEED: trainCurrentSpeedHandler?.handleMessage(message.trainCurrentSpeed)
			case Message.MessageType.TRAIN_DIRECTION_CONTROL: trainDirectionControlHandler?.handleMessage(message.trainDirectionControl)
			case Message.MessageType.TRAIN_FUNCTION_CONTROL: trainFunctionControlHandler?.handleMessage(message.trainFunctionControl)
			case Message.MessageType.TRAIN_REFERENCE_SPEED: trainReferenceSpeedHandler?.handleMessage(message.trainReferenceSpeed)
			case Message.MessageType.TRAIN_REFERENCE_SPEED_CONTROL: trainReferenceSpeedControlHandler?.handleMessage(message.trainReferenceSpeedControl)
			case Message.MessageType.TURNOUT_CONTROL: turnoutControlHandler?.handleMessage(message.turnoutControl)
			case Message.MessageType.TURNOUT_STATE: turnoutStateHandler?.handleMessage(message.turnoutState)
			default: Collections.EMPTY_LIST.forEach[] // FIXME: Pls send help, I don't know how to throw void
		}
	}

	override convertMessageToRaw(Object _message) throws ClassCastException {
		return internalConvertMessageToRaw(_message as GeneratedMessageV3);
	}

	def dispatch byte[] internalConvertMessageToRaw(SegmentControl _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.SEGMENT_CONTROL
		message.segmentControl = _message
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

	def dispatch byte[] internalConvertMessageToRaw(TrainDirectionControl _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_DIRECTION_CONTROL
		message.trainDirectionControl = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainFunctionControl _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_FUNCTION_CONTROL
		message.trainFunctionControl = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainReferenceSpeed _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_REFERENCE_SPEED
		message.trainReferenceSpeed = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TrainReferenceSpeedControl _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TRAIN_REFERENCE_SPEED_CONTROL
		message.trainReferenceSpeedControl = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TurnoutControl _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TURNOUT_CONTROL
		message.turnoutControl = _message
		message.build.toByteArray
	}

	def dispatch byte[] internalConvertMessageToRaw(TurnoutState _message) {
		val message = Message.newBuilder
		message.type = Message.MessageType.TURNOUT_STATE
		message.turnoutState = _message
		message.build.toByteArray
	}

}
