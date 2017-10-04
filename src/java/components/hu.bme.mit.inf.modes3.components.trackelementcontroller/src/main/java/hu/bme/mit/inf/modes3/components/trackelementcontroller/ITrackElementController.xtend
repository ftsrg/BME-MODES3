package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.components.trackelementcontroller.wrapper.ITrackElementControllerWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState

interface ITrackElementController extends Runnable {
	def void setTrackElementControllerWrapper(ITrackElementControllerWrapper trackElementControllerWrapper)

	def void onSendAllStatus()

	def void onSegmentCommand(int id, SegmentState state)

	def void onTurnoutCommand(int id, TurnoutState state)
}
