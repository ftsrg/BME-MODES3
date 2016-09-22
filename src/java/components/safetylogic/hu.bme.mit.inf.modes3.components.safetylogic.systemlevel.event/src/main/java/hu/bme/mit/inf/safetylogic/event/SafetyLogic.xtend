package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

class SafetyLogic extends AbstractRailRoadCommunicationComponent implements INotifiable {

	@Accessors(PUBLIC_GETTER) protected ModelUtil model // XXX IModelInteractor should be the static type
	private ILoggerFactory factory

	new(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		this.factory = factory
		logger.info('Construction started')
		model = new ModelUtil
		logger.info('Construction finished')
	}

	private def Iterable<Turnout> getTurnouts(Iterable<RailRoadElement> railRoadElements) {
		railRoadElements.filter[it instanceof Turnout].map[it as Turnout]
	}

	private def Iterable<Segment> getSegments(Iterable<RailRoadElement> railRoadElements) {
		railRoadElements.filter[it instanceof Segment].map[it as Segment]
	}

	private def turn(RailRoadElement element, SegmentState state) {
		if(element instanceof Segment) element.isEnabled = (state == SegmentState.ENABLED)
	}

	private def void initRailRoad() {
		val sleepTimes = 200
		val turnouts = model.model.sections.getTurnouts
		turnouts.forEach [
			locator.trackElementCommander.sendTurnoutCommand(id, TurnoutState.STRAIGHT)
		]
		Thread.sleep(sleepTimes)
		turnouts.forEach [
			locator.trackElementCommander.sendTurnoutCommand(id, TurnoutState.DIVERGENT)
		]
		Thread.sleep(sleepTimes)

		val segments = model.model.sections.getSegments
		segments.forEach [
			locator.trackElementCommander.sendSegmentCommand(id, SegmentState.DISABLED)
		]
		Thread.sleep(sleepTimes)
		segments.forEach [
			locator.trackElementCommander.sendSegmentCommand(id, SegmentState.ENABLED)
		]
		Thread.sleep(sleepTimes)

	}

	override void run() {
		this.logger.info("Running started...")
		locator.trackElementStateRegistry.segmentOccupancyChangeListener = new TrainMovementEstimator(model, this, factory)
		locator.trackElementStateRegistry.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				(model.model.sections.findFirst[it.id == id] as Turnout).currentlyDivergent = (newValue == TurnoutState.DIVERGENT)
				refreshSafetyLogicState
			}
		}

		initRailRoad()
	}

	def public void refreshSafetyLogicState() {
		logger.info('''Refreshing state: #of cuts «model.cuts.size», #of hits «model.hits.size»''')
		model.model.sections.filter[it instanceof Segment].map[it as Segment].forEach[isEnabled = true] // Enable all sections virtually first
		model.cuts.forEach [ cut |
			logger.info('''CUT: victim on «(cut.victim).id» cuts «(cut.offender).currentlyOn.id»''')
			model.getSegment(cut.offender.currentlyOn.id).turn(SegmentState.DISABLED) // disable the trains which cut sections
		]

		model.hits.forEach [ hit |
			logger.info('''HIT: offender on «(hit.offender).currentlyOn.id», victim on «(hit.victim).currentlyOn.id»''')
			model.getSegment(hit.offender.currentlyOn.id).turn(SegmentState.DISABLED) // disable the trains which hit another
		]

		sendMessages()
	}

	private def void sendMessages() {
		model.model.sections.getSegments.forEach [
			if(isEnabled == false)
				locator.trackElementCommander.sendSegmentCommand(it.id, SegmentState.DISABLED)
			else
				locator.trackElementCommander.sendSegmentCommand(it.id, SegmentState.ENABLED)
		]
	}

	override onUpdate() {
		refreshSafetyLogicState
	}

}
