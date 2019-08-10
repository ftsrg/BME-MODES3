package hu.bme.mit.inf.modes3.messaging.proto.dispatcher

import com.google.protobuf.InvalidProtocolBufferException
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter.InternalToProtobufConverter
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter.ProtobufToInternalConverter
import hu.bme.mit.inf.modes3.messaging.proto.messages.Message
import hu.bme.mit.inf.modes3.messaging.proto.messages.MessageType
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * De-/serializes and dispatches the messages that arrive through protobuf.
 * Each message is dispatched to the corresponding listener.
 * 
 * @author benedekh
 */
class ProtobufMessageDispatcher extends AbstractMessageDispatcher {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger

	val InternalToProtobufConverter internalToProtobufConverter
	val ProtobufToInternalConverter protobufToInternalConverter

	/**
	 * @param factory the logger factory
	 */	
	new(ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		internalToProtobufConverter = new InternalToProtobufConverter
		protobufToInternalConverter = new ProtobufToInternalConverter
	}

	override dispatchMessage(byte[] raw_message) {
		try {
			val message = Message.parseFrom(raw_message)
			switch (message.type) {
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
				case MessageType.TURNOUT_REFERENCE_STATE: {
					val protoMessage = message.turnoutReferenceState
					val internalMessage = protobufToInternalConverter.convertToInternalMessage(protoMessage)
					turnoutReferenceStateHandler?.handleMessage(internalMessage)
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
		} catch (InvalidProtocolBufferException ipbe){
			logger.trace(ipbe.message, ipbe)
		} catch (Exception e) {
			logger.error(e.message, e)
			e.printStackTrace
			
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
