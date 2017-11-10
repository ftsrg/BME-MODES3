package hu.bme.mit.inf.modes3.messaging.proto.dispatcher

import hu.bme.mit.inf.modes3.messaging.messages.enums.DccOperations
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentOccupancyValue
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainDirectionValue
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainFunctionValue
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutStateValue
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ProtobufEnumTransformator {

	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) static var Logger logger = LoggerFactory.getLogger(
		ProtobufEnumTransformator.name)

	def static setLogger(ILoggerFactory factory) {
		logger = factory.getLogger(ProtobufEnumTransformator.name)
	}

	def static SegmentOccupancyValue toSpecific(SegmentOccupancy state) {
		switch (state) {
			case FREE: SegmentOccupancyValue.FREE
			case OCCUPIED: SegmentOccupancyValue.OCCUPIED
		}
	}

	def static SegmentStateValue toSpecific(SegmentState state) {
		switch (state) {
			case ENABLED: SegmentStateValue.ENABLED
			case DISABLED: SegmentStateValue.DISABLED
		}
	}

	def static TurnoutStateValue toSpecific(TurnoutState state) {
		switch (state) {
			case DIVERGENT:
				TurnoutStateValue.DIVERGENT
			case STRAIGHT:
				TurnoutStateValue.STRAIGHT
			case ILLEGAL: {
				logger.warn("TurnoutStateValue is ILLEGAL, default TurnoutStateValue.DIVERGENT is used instead")
				return TurnoutStateValue.DIVERGENT
			}
		}
	}

	def static TrainDirectionValue toSpecific(TrainDirection direction) {
		switch (direction) {
			case FORWARD: TrainDirectionValue.FORWARD
			case BACKWARD: TrainDirectionValue.BACKWARD
		}
	}

	def static TrainFunctionValue toSpecific(TrainFunction function) {
		switch (function) {
			case OFF: TrainFunctionValue.OFF
			case ON: TrainFunctionValue.ON
		}
	}

	def static hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperations toSpecific(DccOperations dccOperations) {
		switch (dccOperations) {
			case NORMAL_OPERATIONS: hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperations.NORMAL_OPERATIONS
			case STOP_ALL_LOCOMOTIVES: hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperations.STOP_ALL_LOCOMOTIVES
			case STOP_OPERATIONS: hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperations.STOP_OPERATIONS
		}
	}

	def static SegmentOccupancy toGeneral(SegmentOccupancyValue state) {
		switch (state) {
			case FREE:
				SegmentOccupancy.FREE
			case OCCUPIED:
				SegmentOccupancy.OCCUPIED
			case UNRECOGNIZED: {
				logger.warn("SegmentOccupancyValue is UNRECOGNIZED, default SegmentOccupancy.OCCUPIED is used instead")
				SegmentOccupancy.OCCUPIED
			}
		}
	}

	def static SegmentState toGeneral(SegmentStateValue state) {
		switch (state) {
			case ENABLED:
				SegmentState.ENABLED
			case DISABLED:
				SegmentState.DISABLED
			case UNRECOGNIZED: {
				logger.warn("SegmentStateValue is UNRECOGNIZED, default SegmentState.ENABLED is used instead")
				SegmentState.ENABLED
			}
		}
	}

	def static TurnoutState toGeneral(TurnoutStateValue state) {
		switch (state) {
			case DIVERGENT:
				TurnoutState.DIVERGENT
			case STRAIGHT:
				TurnoutState.STRAIGHT
			case UNRECOGNIZED: {
				logger.warn("TurnoutStateValue is UNRECOGNIZED, default TurnoutState.STRAIGHT is used instead")
				TurnoutState.STRAIGHT
			}
		}
	}

	def static TrainDirection toGeneral(TrainDirectionValue direction) {
		switch (direction) {
			case FORWARD:
				TrainDirection.FORWARD
			case BACKWARD:
				TrainDirection.BACKWARD
			case UNRECOGNIZED: {
				logger.warn("TrainDirection is UNRECOGNIZED, default trainDirection.FORWARD is used instead")
				TrainDirection.FORWARD
			}
		}
	}

	def static TrainFunction toGeneral(TrainFunctionValue function) {
		switch (function) {
			case OFF:
				TrainFunction.OFF
			case ON:
				TrainFunction.ON
			case UNRECOGNIZED: {
				logger.warn("TrainFunction is UNRECOGNIZED, default trainFunction.OFF is used instead")
				TrainFunction.OFF
			}
		}
	}

	def static DccOperations toGeneral(hu.bme.mit.inf.modes3.messaging.proto.messages.DccOperations dccOperations) {
		switch (dccOperations) {
			case NORMAL_OPERATIONS:
				DccOperations.NORMAL_OPERATIONS
			case STOP_ALL_LOCOMOTIVES:
				DccOperations.STOP_ALL_LOCOMOTIVES
			case STOP_OPERATIONS:
				DccOperations.STOP_OPERATIONS
			case UNRECOGNIZED: {
				logger.warn("DccOperations is UNRECOGNIZED, default dccOperations.NORMAL_OPERATIONS is used instead")
				DccOperations.NORMAL_OPERATIONS
			}
		}
	}
}
