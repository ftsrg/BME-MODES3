package hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter

import hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainFunctionCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.messages.core.InternalMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSegmentMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSpeedMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufEnumTransformator
import hu.bme.mit.inf.modes3.messaging.proto.messages.Message
import hu.bme.mit.inf.modes3.messaging.proto.messages.MessageType
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentState
import hu.bme.mit.inf.modes3.messaging.proto.messages.SendAllStatus
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainCurrentSegment
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainCurrentSpeed
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeed
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutState

class InternalToProtobufConverter {

	def Message convertToProtobufMessage(Object message) {
		internalConvertMessageToRaw(message as InternalMessage)
	}

	def dispatch Message internalConvertMessageToRaw(SegmentCommand message) {
		(Message.newBuilder => [
			type = MessageType.SEGMENT_COMMAND;
			segmentCommand = (hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentCommand.newBuilder => [
				segmentID = message.segmentId;
				state = ProtobufEnumTransformator::toSpecific(message.state)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(SegmentStateMessage message) {
		(Message.newBuilder => [
			type = MessageType.SEGMENT_STATE;
			segmentState = (SegmentState.newBuilder => [
				segmentID = message.segmentId;
				state = ProtobufEnumTransformator::toSpecific(message.state)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TrainCurrentSegmentMessage message) {
		(Message.newBuilder => [
			type = MessageType.TRAIN_CURRENT_SEGMENT;
			trainCurrentSegment = (TrainCurrentSegment.newBuilder => [
				trainID = message.trainId;
				segmentID = message.segmentId
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TrainCurrentSpeedMessage message) {
		(Message.newBuilder => [
			type = MessageType.TRAIN_CURRENT_SPEED;
			trainCurrentSpeed = (TrainCurrentSpeed.newBuilder => [
				trainID = message.trainId;
				currentSpeed = message.currentSpeed;
				direction = ProtobufEnumTransformator::toSpecific(message.direction)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TrainFunctionCommand message) {
		(Message.newBuilder => [
			type = MessageType.TRAIN_FUNCTION_COMMAND;
			trainFunctionCommand = (hu.bme.mit.inf.modes3.messaging.proto.messages.TrainFunctionCommand.newBuilder => [
				trainID = message.trainId;
				trainFunctionValue = ProtobufEnumTransformator::toSpecific(message.trainFunction)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TrainReferenceSpeedMessage message) {
		(Message.newBuilder => [
			type = MessageType.TRAIN_REFERENCE_SPEED;
			trainReferenceSpeed = (TrainReferenceSpeed.newBuilder => [
				trainID = message.trainId;
				referenceSpeed = message.referenceSpeed;
				direction = ProtobufEnumTransformator::toSpecific(message.direction)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TrainReferenceSpeedCommand message) {
		(Message.newBuilder => [
			type = MessageType.TRAIN_REFERENCE_SPEED_COMMAND;
			trainReferenceSpeedCommand = (hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeedCommand.
				newBuilder => [
				trainID = message.trainId;
				referenceSpeed = message.referenceSpeed;
				direction = ProtobufEnumTransformator::toSpecific(message.direction)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TurnoutCommand _message) {
		(Message.newBuilder => [
			type = MessageType.TURNOUT_COMMAND;
			turnoutCommand = (hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutCommand.newBuilder => [
				turnoutID = _message.turnoutId;
				state = ProtobufEnumTransformator::toSpecific(_message.state)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(TurnoutStateMessage _message) {
		(Message.newBuilder => [
			type = MessageType.TURNOUT_STATE;
			turnoutState = (TurnoutState.newBuilder => [
				turnoutID = _message.turnoutId;
				state = ProtobufEnumTransformator::toSpecific(_message.state)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(SegmentOccupancyMessage message) {
		(Message.newBuilder => [
			type = MessageType.SEGMENT_OCCUPANCY;
			segmentOccupancy = (SegmentOccupancy.newBuilder => [
				segmentID = message.segmentId;
				state = ProtobufEnumTransformator::toSpecific(message.state)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(DccOperationsCommand message) {
		(Message.newBuilder => [
			type = MessageType.DCC_OPERATIONS_COMMAND;
			dccOperationsCommand = (hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperationsCommand.newBuilder => [
				dccOperations = ProtobufEnumTransformator::toSpecific(message.dccOperations)
			]).build
		]).build
	}

	def dispatch Message internalConvertMessageToRaw(SendAllStatusCommand message) {
		(Message.newBuilder => [
			type = MessageType.SEND_ALL_STATUS;
			allStatus = SendAllStatus.newBuilder.build
		]).build
	}

}
