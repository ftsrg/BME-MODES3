package hu.bme.mit.inf.safetylogic.event.sl

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.utils.conf.LocomotivesConfiguration
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import hu.bme.mit.inf.safetylogic.event.ComputerVisionTrainMovementEstimator
import hu.bme.mit.inf.safetylogic.event.IModelInteractor
import hu.bme.mit.inf.safetylogic.event.INotifiable
import hu.bme.mit.inf.safetylogic.event.ISegmentDisableStrategy
import hu.bme.mit.inf.safetylogic.event.ISegmentEnableStrategy
import hu.bme.mit.inf.safetylogic.event.ITrainStopStrategy
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.TrackDisableStrategy
import hu.bme.mit.inf.safetylogic.event.TrackEnableStrategy
import hu.bme.mit.inf.safetylogic.event.TrainMovementEstimator
import hu.bme.mit.inf.safetylogic.event.bridge.ISafetyLogicBridge
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * The system-level safety logic application.
 * 
 * @author baloghlaszlo, benedekh
 */
class SafetyLogic implements INotifiable, ISafetyLogic {

	val boolean initializeRailRoad
	val boolean useComputerVision

	@Accessors(PUBLIC_GETTER) protected IModelInteractor model
	val ILoggerFactory factory
	val Logger logger

	static val turnoutToSenseIDMap = LayoutConfiguration.INSTANCE.turnoutIdToSegmentIdsMapping
//	static val senseToTurnoutIDMap = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

	val Set<Train> stoppedTrains = newHashSet

	var List<ISegmentEnableStrategy> segmentEnableStrategies
	var List<ISegmentDisableStrategy> segmentDisableStrategies
	var List<ITrainStopStrategy> trainStopStrategies

	var ISafetyLogicBridge safetyLogicBridge
	
	/**
	 * @param factory the logger factory
	 * @param initializeRailRoad if the railroad should be initialized
	 * @param useComputerVision if true the CV, otherwise the API of the model-railway track will be used will be used as source for information 
	 */
	new(ILoggerFactory factory, boolean initializeRailRoad, boolean useComputerVision) {
		this.factory = factory
		this.logger = factory.getLogger(this.class.name)

		this.initializeRailRoad = initializeRailRoad
		this.useComputerVision = useComputerVision

		logger.info('Construction started')

		model = new ModelUtil(factory)

		model.segments.forEach[isEnabled = true] // Enable all sections virtually first 
		logger.info('Construction finished')
	}

	override setSafetyLogicBridge(ISafetyLogicBridge safetyLogicBridge) {
		this.safetyLogicBridge = safetyLogicBridge

		this.segmentDisableStrategies = #[
			new TrackDisableStrategy(this.safetyLogicBridge.trackElementCommander)
		]
		this.segmentEnableStrategies = #[
			new TrackEnableStrategy(this.safetyLogicBridge.trackElementCommander)
		]
		this.trainStopStrategies = #[ // new XPressInvertDirectionStrategy(this.safetyLogicBridge.trainCommander, this.safetyLogicBridge.trainSpeedStateRegistry, logger)
		]

	}

	private def void initRailRoad() {
		model.turnouts.forEach[currentlyDivergent = false]
		val initSleepTimes = 500
		logger.info('Railroad initialization started, sleep times are ' + initSleepTimes)
		val turnouts = model.turnouts
		val segments = model.segments

		logger.info('Disabling all sections')
		segments.forEach [
			this.safetyLogicBridge.sendSegmentCommand(id, SegmentState.DISABLED)
		]

		Thread.sleep(initSleepTimes)

		logger.info('Setting turnouts to divergent')
		turnouts.forEach [
			this.safetyLogicBridge.sendTurnoutCommand(id, TurnoutState.DIVERGENT)
		]

		Thread.sleep(initSleepTimes)

		logger.info('Setting all turnouts to straight')
		turnouts.forEach [
			this.safetyLogicBridge.sendTurnoutCommand(id, TurnoutState.STRAIGHT)
		]

		Thread.sleep(initSleepTimes)

		logger.info('Enabling all sections')
		segments.forEach [
			this.safetyLogicBridge.sendSegmentCommand(id, SegmentState.ENABLED)
		]

		logger.info('Railroad initialization finished')

	}

	override void run() {

		this.logger.info("Running started...")

		if(initializeRailRoad) {
			initRailRoad
		}

		if(useComputerVision) {
			this.safetyLogicBridge.computerVisionListener = new ComputerVisionTrainMovementEstimator(model, this, factory, false)
		} else {
			this.safetyLogicBridge.segmentOccupancyChangeListener = new TrainMovementEstimator(model, this, factory)
		}

		this.safetyLogicBridge.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				synchronized(model) {
					val senseID = turnoutToSenseIDMap.get(id)
					logger.info('''TurnoutStateChange arrived, id = T«id» (senseid=«senseID») oldState = «oldValue?.name» newState = «newValue.name»''')
					println(model.turnouts.filter[senseID.contains(it.id)].size)
					model.turnouts.filter[senseID.contains(it.id)].forEach [
						it.currentlyDivergent = (newValue == TurnoutState.DIVERGENT)
						logger.info('''Turnout on «senseID» «if(currentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT»''')
					]
					// logger.info('''Turnout States: <«FOR turnout : model.turnouts.map[it as Turnout] SEPARATOR ";\t "»
					// Sense=«turnout.id»,TurnoutID=«senseToTurnoutIDMap.get(turnout.id)»,State=«if(turnout.currentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT»
					// «ENDFOR»>''')
					refreshSafetyLogicState
				}
			}
		}

	}

	/**
	 * Refreshes the safety logic's view of the railroad track.
	 */
	def void refreshSafetyLogicState() {
		logger.info('''Refreshing state: #of trains «model.trains.size», #of trailings «model.trailings.size», #of hits «model.hits.size»''')
		logger.info('''Trains «FOR train : model.trains.filter[currentlyOn !== null]»{ID=«train.id» NAME=«LocomotivesConfiguration::INSTANCE.getLocomotiveNameById(train.id)» ON=«train.currentlyOn.id» PREV=«if(train.previouslyOn === null) "UNDEF" else train.previouslyOn.id»}«ENDFOR»''')

		val offenders = new HashSet<Train>

		model.trailings.forEach [ trailing |
			logger.info('''TRAILING TURNOUT: Train on «trailing.offender.currentlyOn.id» will trail turnout «trailing.victim.id»''')
			offenders.add(trailing.offender)
		]

		model.hits.forEach [ hit |
			logger.info('''HIT: offender on «hit.offender.currentlyOn.id», hits victim on «hit.victim.currentlyOn.id»''')
			offenders.add(hit.offender)
		]

		val trainsToStop = offenders.filter[!stoppedTrains.contains(it)].toList

		trainsToStop.forEach [ train |
			trainStopStrategies.forEach[it.stopTrain(train)]
		]

		val trainsToRelease = stoppedTrains.filter[!offenders.contains(it)].toList
		val sectionsToEnable = trainsToRelease.map[it.currentlyOn].toList
		val sectionsToDisable = trainsToStop.map[it.currentlyOn].toList

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
		if(!sectionsToEnable.empty) {
			logger.info('''SectionToEnable = «FOR enable : sectionsToEnable BEFORE '{' SEPARATOR ', ' AFTER '}'» «enable.id» «ENDFOR»''')
		}
		if(!sectionsToDisable.empty) {
			logger.info('''SectionToDisable = «FOR disable : sectionsToDisable BEFORE '{' SEPARATOR ', ' AFTER '}'» «disable.id» «ENDFOR»''')
		}

		sectionsToEnable.filter[it instanceof Segment].map[it as Segment].forEach [
			it.isEnabled = true
		]
		sectionsToDisable.filter[it instanceof Segment].map[it as Segment].forEach [
			it.isEnabled = false
		]

		if(!stoppedTrains.empty) {
			logger.info('''Old Stopped trains = «FOR stoppedTrain : stoppedTrains BEFORE '{' SEPARATOR ', ' AFTER '}'» NAME=«LocomotivesConfiguration::INSTANCE.getLocomotiveNameById(stoppedTrain.id)» ON=«stoppedTrain.currentlyOn.id» «ENDFOR»''')
		}

		stoppedTrains.clear

		if(trainStopStrategies.empty) {
			stoppedTrains.addAll(offenders.filter[currentlyOn instanceof Segment]) // As if we have no train stopping strategies 			
		} else {
			stoppedTrains.addAll(offenders)
		}

		if(!stoppedTrains.empty) {
			logger.info('''Stopped trains = «FOR stoppedTrain : stoppedTrains BEFORE '{' SEPARATOR ', ' AFTER '}'» NAME=«LocomotivesConfiguration::INSTANCE.getLocomotiveNameById(stoppedTrain.id)» ON=«stoppedTrain.currentlyOn.id» «ENDFOR»''')
		}
	}

	override onUpdate() {
		refreshSafetyLogicState
	}

}
