package hu.bme.mit.inf.modes3.messaging.proto.dispatcher.converter

import hu.bme.mit.inf.modes3.messaging.messages.command.SendAllStatusCommand
import hu.bme.mit.inf.modes3.messaging.messages.status.ComputerVisionObjectPositionsMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.DccOperationsStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.Marker
import hu.bme.mit.inf.modes3.messaging.messages.status.PhysicalObject
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentOccupancyMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.SegmentStateMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.ThreeDPosition
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSegmentMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainCurrentSpeedMessage
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainReferenceSpeedMessage
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
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainCurrentSegment
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainCurrentSpeed
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainFunctionCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainFunctionState
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeed
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeedCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutCommand
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutState
import java.util.Map
import hu.bme.mit.inf.modes3.messaging.messages.status.TrainFunctionStateMessage

class ProtobufToInternalConverter {

	def convertToInternalMessage(DccOperationsCommand protoMessage) {
		val dccOperations = ProtobufEnumTransformator::toGeneral(protoMessage.dccOperations)
		new hu.bme.mit.inf.modes3.messaging.messages.command.DccOperationsCommand(dccOperations)
	}

	def convertToInternalMessage(SegmentCommand protoMessage) {
		val segmentId = protoMessage.segmentID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new hu.bme.mit.inf.modes3.messaging.messages.command.SegmentCommand(segmentId, state)
	}

	def convertToInternalMessage(TrainFunctionCommand protoMessage) {
		val trainId = protoMessage.trainID
		val trainFunction = ProtobufEnumTransformator::toGeneral(protoMessage.trainFunctionValue)
		new hu.bme.mit.inf.modes3.messaging.messages.command.TrainFunctionCommand(trainId, trainFunction)
	}

	def convertToInternalMessage(TrainReferenceSpeedCommand protoMessage) {
		val trainId = protoMessage.trainID
		val referenceSpeed = protoMessage.referenceSpeed
		val direction = ProtobufEnumTransformator::toGeneral(protoMessage.direction)
		new hu.bme.mit.inf.modes3.messaging.messages.command.TrainReferenceSpeedCommand(trainId, referenceSpeed,
			direction)
	}

	def convertToInternalMessage(TurnoutCommand protoMessage) {
		val turnoutId = protoMessage.turnoutID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new hu.bme.mit.inf.modes3.messaging.messages.command.TurnoutCommand(turnoutId, state)
	}

	def convertToInternalMessage(SegmentState protoMessage) {
		val segmentId = protoMessage.segmentID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new SegmentStateMessage(segmentId, state)
	}

	def convertToInternalMessage(TrainCurrentSegment protoMessage) {
		val trainId = protoMessage.trainID
		val segmentId = protoMessage.segmentID
		new TrainCurrentSegmentMessage(trainId, segmentId)
	}

	def convertToInternalMessage(TrainCurrentSpeed protoMessage) {
		val trainId = protoMessage.trainID
		val currentSpeed = protoMessage.currentSpeed
		val direction = ProtobufEnumTransformator::toGeneral(protoMessage.direction)
		new TrainCurrentSpeedMessage(trainId, currentSpeed, direction)
	}

	def convertToInternalMessage(TrainReferenceSpeed protoMessage) {
		val trainId = protoMessage.trainID
		val referenceSpeed = protoMessage.referenceSpeed
		val direction = ProtobufEnumTransformator::toGeneral(protoMessage.direction)
		new TrainReferenceSpeedMessage(trainId, referenceSpeed, direction)
	}

	def convertToInternalMessage(TurnoutState protoMessage) {
		val turnoutId = protoMessage.turnoutID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new TurnoutStateMessage(turnoutId, state)
	}

	def convertToInternalMessage(SegmentOccupancy protoMessage) {
		val segmentId = protoMessage.segmentID
		val state = ProtobufEnumTransformator::toGeneral(protoMessage.state)
		new SegmentOccupancyMessage(segmentId, state)
	}

	def convertToInternalMessage(DccOperationsState protoMessage) {
		val dccOperations = ProtobufEnumTransformator::toGeneral(protoMessage.dccOperations)
		new DccOperationsStateMessage(dccOperations)
	}

	def convertToInternalMessage(TrainFunctionState protoMessage) {
		val trainId = protoMessage.trainID
		val trainFunction = ProtobufEnumTransformator::toGeneral(protoMessage.trainFunctionValue)
		new TrainFunctionStateMessage(trainId, trainFunction)
	}

	def convertToInternalMessage(SendAllStatus protoMessage) {
		new SendAllStatusCommand
	}

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
