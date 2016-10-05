package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import java.util.ArrayList
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

class SafetyLogic extends AbstractRailRoadCommunicationComponent implements INotifiable {

	@Accessors(PUBLIC_GETTER) protected ModelUtil model // XXX IModelInteractor should be the static type
	private ILoggerFactory factory

	val List<ISegmentDisableStrategy> segmentDisableStrategies = #[
		new TrackDisableStrategy(locator.trackElementCommander) // BBB Config, like good ol' days!
	]
	var Set<Train> stoppedTrains = new HashSet<Train>

	val List<ITrainStopStrategy> trainStopStrategies = #[]

	val List<ISegmentEnableStrategy> segmentEnableStrategies = #[
		new TrackEnableStrategy(locator.trackElementCommander) // BBB Config, like good ol' days!
	]

	new(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		this.factory = factory
		logger.info('Construction started')
		model = new ModelUtil(factory)
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
		// 9
		model.model.sections.getTurnouts.forEach[currentlyDivergent = false]
		(model.model.sections.findFirst[id == 9] as Turnout).currentlyDivergent = true
		val sleepTimes = 1000
		logger.info('Railroad initialization started, sleep times are ' + sleepTimes)
		val turnouts = model.model.sections.getTurnouts
		turnouts.forEach [
			locator.trackElementCommander.sendTurnoutCommand(id, TurnoutState.STRAIGHT)
		]
		logger.info('All turnout set straight')
		Thread.sleep(sleepTimes)
		turnouts.forEach [
			locator.trackElementCommander.sendTurnoutCommand(id, TurnoutState.DIVERGENT)
		]
		logger.info('All turnout set divergent')
		Thread.sleep(sleepTimes)

		val segments = model.model.sections.getSegments
		segments.forEach [
			locator.trackElementCommander.sendSegmentCommand(id, SegmentState.DISABLED)
		]
		logger.info('Disabling all sections')
		Thread.sleep(sleepTimes)
		segments.forEach [
			locator.trackElementCommander.sendSegmentCommand(id, SegmentState.ENABLED)
		]
		logger.info('Enabling all sections')
		Thread.sleep(sleepTimes)
		logger.info('Railroad initialization finished')
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
		logger.info('''Refreshing state: #of trains «model.model.trains.size», #of cuts «model.cuts.size», #of hits «model.hits.size»''')
		logger.info('''Trains «FOR train : model.model.trains»{ID=«train.id» ON=«train.currentlyOn.id» PREV=«train.previouslyOn?.id»}«ENDFOR»''')
		model.model.sections.filter[it instanceof Segment].map[it as Segment].forEach[isEnabled = true] // Enable all sections virtually first
		val offenders = new HashSet<Train>
		model.cuts.forEach [ cut |
			logger.info('''CUT: victim on «(cut.victim).id» cuts «(cut.offender).currentlyOn.id»''')
			model.getSegment(cut.offender.currentlyOn.id).turn(SegmentState.DISABLED) // disable the trains which cut sections
			offenders.add(cut.offender)
		]

		model.hits.forEach [ hit |
			logger.info('''HIT: offender on «(hit.offender).currentlyOn.id», victim on «(hit.victim).currentlyOn.id»''')
			model.getSegment(hit.offender.currentlyOn.id).turn(SegmentState.DISABLED) // disable the trains which hit another
			offenders.add(hit.offender)
		]

		val trainsToStop = offenders.filter[!stoppedTrains.contains(it)]
		trainsToStop.forEach [ train |
			trainStopStrategies.forEach[it.stopTrain(train)]
		]
		val trainsToRelease = stoppedTrains.filter[!offenders.contains(it)]
		val sectionsToEnable = trainsToRelease.map[it.currentlyOn]
		val sectionsToDisable = trainsToStop.map[it.currentlyOn]

		segmentEnableStrategies.forEach [ strategy |
			sectionsToEnable.forEach [ segment |
				strategy.enableSection(segment.id)
			]
		]
		segmentDisableStrategies.forEach [ strategy |
			sectionsToDisable.forEach [ segment |
				strategy.disableSection(segment.id)
			]
		]
		logger.info('''SectionToEnable = {«FOR enable : sectionsToEnable SEPARATOR ', '» «enable.id» «ENDFOR»}''')
		logger.info('''SectionToDisable = {«FOR disable : sectionsToDisable SEPARATOR ', '» «disable.id» «ENDFOR»}''')

		stoppedTrains = offenders

//		sendMessages()
	}

//	private def void sendMessages() {
//		val sectionsToEnable = model.model.sections.getSegments().filter[isEnabled]
//		val sectionsToDisable = model.model.sections.getSegments().filter[!isEnabled]
//		segmentEnableStrategies.forEach [ strategy |
//			sectionsToEnable.forEach [ segment |
//				strategy.enableSection(segment.id)
//			]
//		]
//		segmentDisableStrategies.forEach [ strategy |
//			sectionsToDisable.forEach [ segment |
//				strategy.disableSection(segment.id)
//			]
//		]
//	}
	override onUpdate() {
		refreshSafetyLogicState
	}

}
