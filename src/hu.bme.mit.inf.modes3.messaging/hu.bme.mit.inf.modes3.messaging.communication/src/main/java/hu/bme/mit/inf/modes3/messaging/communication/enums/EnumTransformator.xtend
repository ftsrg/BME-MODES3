package hu.bme.mit.inf.modes3.messaging.communication.enums

import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentOccupancyValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateValue
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateValue

class EnumTransformator {
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
			case DIVERGENT: TurnoutStateValue.DIVERGENT
			case STRAIGHT: TurnoutStateValue.STRAIGHT
		}
	}

	def static SegmentOccupancy toGeneral(SegmentOccupancyValue state) {
		switch (state) {
			case FREE: SegmentOccupancy.FREE
			case OCCUPIED: SegmentOccupancy.OCCUPIED
			case UNRECOGNIZED: SegmentOccupancy.OCCUPIED // TODO log
		}
	}

	def static SegmentState toGeneral(SegmentStateValue state) {
		switch (state) {
			case ENABLED: SegmentState.ENABLED
			case DISABLED: SegmentState.DISABLED
			case UNRECOGNIZED: SegmentState.ENABLED //TODO log
		}
	}

	def static TurnoutState toGeneral(TurnoutStateValue state) {
		switch (state) {
			case DIVERGENT: TurnoutState.DIVERGENT
			case STRAIGHT: TurnoutState.STRAIGHT
			case UNRECOGNIZED: TurnoutState.STRAIGHT // TODO log
		}
	}
}
