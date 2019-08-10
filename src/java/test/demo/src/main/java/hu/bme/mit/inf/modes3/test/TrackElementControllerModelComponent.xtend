package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.slf4j.ILoggerFactory

/**
 * A show-case (demo) to show how the model-based simulation of the track works.
 * Simulates how the segment and the turnout commands influence the model.
 * 
 * @author baloghlaszlo
 */
class TrackElementControllerModelComponent extends AbstractCommunicationComponent implements ISegmentCommandListener, ITurnoutCommandListener {

	RailRoadModel model
	Iterable<Segment> segments
	Iterable<Turnout> turnouts

	/**
	 * @param messagingService the messaging service to the railway track
	 * @param model the model of the model railway track
	 * @param factory the logger factory
	 */
	new(MessagingService messagingService, RailRoadModel model, ILoggerFactory factory) {
		super(messagingService, factory);
		println('''Initialization started''')

		this.model = model
		segments = model.sections.filter[it instanceof Segment].map[it as Segment]
		turnouts = model.sections.filter[it instanceof Turnout].map[it as Turnout]

		locator.trackElementCommandCallback.segmentCommandListener = this
		locator.trackElementCommandCallback.turnoutCommandListener = this
		println('''callbacks registered''')
	}

	override onSegmentCommand(int id, SegmentState state) {
		synchronized (model) {
			println('''SegmentCommand recieved, id=«id» state=«state.name»''')
			segments.findFirst[it.id == id].isEnabled = (state == SegmentState.ENABLED)
		}
	}

	override onTurnoutCommand(int id, TurnoutState state) {
		synchronized (model) {
			turnouts.findFirst[it.id == id].currentlyDivergent = (state == TurnoutState.DIVERGENT)
		}
	}

	override run() {
		// Left blank intentionally
	}

}
