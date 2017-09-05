package hu.bme.mit.inf.modes3.messaging.proto.dispatcher

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter.InternalToProtobufConverter
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter.ProtobufToInternalConverter
import hu.bme.mit.inf.modes3.messaging.proto.messages.Message
import hu.bme.mit.inf.modes3.messaging.proto.messages.MessageType
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class ProtobufMessageDispatcher extends AbstractMessageDispatcher {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	val InternalToProtobufConverter internalToProtobufConverter
	val ProtobufToInternalConverter protobufToInternalConverter

	new(ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		internalToProtobufConverter = new InternalToProtobufConverter
		protobufToInternalConverter = new ProtobufToInternalConverter
	}

	override dispatchMessage(byte[] raw_message) {
		try {
			val message = Message.parseFrom(raw_message)
			switch (message.type as MessageType) {
				case MessageType.SEGMENT_COMMAND: {
					val protoMessage = message.segmentCommand
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					segmentCommandHandler?.handleMessage(internalMessage)
				}
				case MessageType.SEGMENT_STATE: {
					val protoMessage = message.segmentState
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					segmentStateHandler?.handleMessage(internalMessage)
				}
				case MessageType.TRAIN_CURRENT_SEGMENT: {
					val protoMessage = message.trainCurrentSegment
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					trainCurrentSegmentHandler?.handleMessage(internalMessage)
				}
				case MessageType.TRAIN_CURRENT_SPEED: {
					val protoMessage = message.trainCurrentSpeed
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					trainCurrentSpeedHandler?.handleMessage(internalMessage)
				}
				case MessageType.TRAIN_FUNCTION_COMMAND: {
					val protoMessage = message.trainFunctionCommand
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					trainFunctionCommandHandler?.handleMessage(internalMessage)
				}
				case MessageType.TRAIN_REFERENCE_SPEED: {
					val protoMessage = message.trainReferenceSpeed
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					trainReferenceSpeedHandler?.handleMessage(internalMessage)
				}
				case MessageType.TRAIN_REFERENCE_SPEED_COMMAND: {
					val protoMessage = message.trainReferenceSpeedCommand
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					trainReferenceSpeedCommandHandler?.handleMessage(internalMessage)
				}
				case MessageType.TURNOUT_COMMAND: {
					val protoMessage = message.turnoutCommand
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					turnoutCommandHandler?.handleMessage(internalMessage)
				}
				case MessageType.TURNOUT_STATE: {
					val protoMessage = message.turnoutState
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					turnoutStateHandler?.handleMessage(internalMessage)
				}
				case MessageType.SEGMENT_OCCUPANCY: {
					val protoMessage = message.segmentOccupancy
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					segmentOccupancyHandler?.handleMessage(internalMessage)
				}
				case MessageType.DCC_OPERATIONS_STATE: {
					val protoMessage = message.dccOperationsState
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					dccOperationStateHandler?.handleMessage(internalMessage)
				}
				case MessageType.SEND_ALL_STATUS: {
					val protoMessage = message.allStatus
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					sendAllStatusHandler?.handleMessage(internalMessage)
				}
				case MessageType.COMPUTER_VISION_OBJECT_POSITIONS: {
					val protoMessage = message.computerVisionObjectPositions
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					computerVisionObjectPositionsHandler?.handleMessage(internalMessage)
				}
				default: {
					logger.warn('''Unknown message type: «message.type»''')
				}
			}
		} catch (Exception e) {
			logger.error(e.message, e)
		}
	}

	override convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			internalToProtobufConverter.convertToProtobufMessage(message).toByteArray
		} catch (Exception e) {
			logger.error(e.message, e)
			throw new IllegalArgumentException(e)
		}
	}
}
