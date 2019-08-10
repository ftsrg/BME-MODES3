package hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter

import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.messages.status.ComputerVisionObjectPositionsMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.DccOperationsStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.Marker
import hu.bme.mit.inf.modes3.messaging.messages.status.PhysicalObject
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.ThreeDPosition
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutReferenceStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TurnoutStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TwoDPosition
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufEnumTransformator
import hu.bme.mit.inf.modes3.messaging.proto.messages.ComputerVisionObjectPositions
import hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperationsCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperationsState
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentState
import hu.bme.mit.inf.modes3.messaging.proto.messages.SendAllStatus
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeed
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutReferenceState
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutState
import java.util.Map

/**
 * Converts the messages between protobuf specific representation and 
 * general representation (that is used by the applications which are 
 * built on the communication layer).
 * 
 * @author benedekh
 */
class ProtobufToInternalConverter {

	/**
	 * Converts a {@link DccOperationsCommand} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(DccOperationsCommand protoMessage) {
		val dccOperations = ProtobufEnumTransformator::toGeneral(protoMessage.dccOperations)
		new hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand(dccOperations)
	}

	/**
	 * Converts a {@link SegmentCommand} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(SegmentCommand protoMessage) {
		val segmentId = protoMessage.segmentID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand(segmentId, state)
	}

	/**
	 * Converts a {@link TrainReferenceSpeedCommand} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(TrainReferenceSpeedCommand protoMessage) {
		val trainId = protoMessage.trainID
		val referenceSpeed = protoMessage.referenceSpeed
		val direction = ProtobufEnumTransformator::toGeneral(protoMessage.direction)
		new hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand(trainId, referenceSpeed, direction)
	}

	/**
	 * Converts a {@link TurnoutCommand} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(TurnoutCommand protoMessage) {
		val turnoutId = protoMessage.turnoutID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand(turnoutId, state)
	}

	/**
	 * Converts a {@link SegmentState} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(SegmentState protoMessage) {
		val segmentId = protoMessage.segmentID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new SegmentStateMessage(segmentId, state)
	}

	/**
	 * Converts a {@link TrainReferenceSpeed} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(TrainReferenceSpeed protoMessage) {
		val trainId = protoMessage.trainID
		val referenceSpeed = protoMessage.referenceSpeed
		val direction = ProtobufEnumTransformator::toGeneral(protoMessage.direction)
		new TrainReferenceSpeedMessage(trainId, referenceSpeed, direction)
	}

	/**
	 * Converts a {@link TurnoutState} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(TurnoutState protoMessage) {
		val turnoutId = protoMessage.turnoutID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new TurnoutStateMessage(turnoutId, state)
	}

	/**
	 * Converts a {@link TurnoutReferenceState} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(TurnoutReferenceState protoMessage) {
		val turnoutId = protoMessage.turnoutID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new TurnoutReferenceStateMessage(turnoutId, state)
	}

	/**
	 * Converts a {@link SegmentOccupancy} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(SegmentOccupancy protoMessage) {
		val segmentId = protoMessage.segmentID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new SegmentOccupancyMessage(segmentId, state)
	}

	/**
	 * Converts a {@link DccOperationsState} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(DccOperationsState protoMessage) {
		val dccOperations = ProtobufEnumTransformator::toGeneral(protoMessage.dccOperations)
		new DccOperationsStateMessage(dccOperations)
	}

	/**
	 * Converts a {@link SendAllStatus} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(SendAllStatus protoMessage) {
		new SendAllStatusCommand
	}

	/**
	 * Converts a {@link ComputerVisionObjectPositions} message to general representation.
	 * 
	 * @param protoMessage to be converted to general representation
	 * @return the message converted to general representation
	 */
	def convertToInternalMessage(ComputerVisionObjectPositions protoMessage) {
		val Map<String, PhysicalObject> physicalObjects = protoMessage.physicalObjectsMap.mapValues [ physicalObjectEntry |
			new PhysicalObject(physicalObjectEntry.name, physicalObjectEntry.markersMap.mapValues [ markersEntry |
				new Marker(markersEntry.name, new ThreeDPosition(
					markersEntry.realposition.x,
					markersEntry.realposition.y,
					markersEntry.realposition.z
				), markersEntry.screenPositionsList.map[new TwoDPosition(it.x, it.y)], markersEntry.trackedList)
			])
		]

		val timestamp = protoMessage.timestamp
		val frameIndex = protoMessage.frameindex

		new ComputerVisionObjectPositionsMessage(physicalObjects, timestamp, frameIndex)
	}

}
