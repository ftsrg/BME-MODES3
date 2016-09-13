package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Turnout
import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatch
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatch
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher
import java.io.PrintWriter
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent

class SafetyLogic extends AbstractRailRoadCommunicationComponent {

	protected var ViatraQueryEngine engine;
	protected var newTrainId = 999
	public var RailRoadModel model //TODO accessors

	new(CommunicationStack stack) {
		super(stack)
	}

	def setup(Resource modelResource) {
		engine = ViatraQueryEngine.on(new EMFScope(modelResource))
	}

	private def getCuts() {
		TrainCutsTurnoutMatcher.on(engine).getAllMatches
	}

	private def getHits() {
		TrainHitsAnotherTrainMatcher.on(engine).getAllMatches
	}

	private def getCurrentlyConnected(RailRoadElement what) {
		CurrentlyConnectedMatcher.on(engine).getAllValuesOfconnectedTo(what)
	}

	private def boolAsInt(Boolean b) {
		if (b) {
			1
		} else {
			0
		}
	}

	private def print(TrainCutsTurnoutMatch match) {
		'''CUT: «(match.offender as Train).id» «(match.victim as Train).id»''' // TODO viatra ticket
	}

	private def print(TrainHitsAnotherTrainMatch match) {
		'''HIT: «(match.offender as Train).id» «(match.victim as Train).id»''' // TODO viatra ticket
	}

	override void run() {
		val resource = ModelUtil.loadModel()
		setup(resource);
		model = ModelUtil.getModelFromResource(resource)
		locator.trackElementStateRegistry.segmentOccupancyChangeListener = new ISegmentOccupancyChangeListener() {
			// FIXME by my current informations, i think this algorithm wont work when the train changes from ccw to cw or the other way around. Or at least it does lose some information which it shouldn't
			// XXX move this to a class, and create unit tests.
			override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
				if (newValue == SegmentOccupancy.OCCUPIED) {
					val changedSection = model.sections.findFirst[it.id == id]
					val possibleTrainPositions = getCurrentlyConnected(changedSection)
					val train = model.trains.findFirst[possibleTrainPositions.contains(it.currentlyOn)]
					if (train == null) { // There is not even a train nearby
						model.trains.add(RailRoadModelFactory.eINSTANCE.createTrain => [it.id = newTrainId++])
					}
					train.previouslyOn = train.currentlyOn
					train.currentlyOn = changedSection
				} else if (newValue == SegmentOccupancy.FREE) {
					val train = model.trains.findFirst[it.currentlyOn.id == id]
					if (train != null) {
						model.trains.remove(train)
					}
				}
				refreshSafetyLogicState
			}

		}

		locator.trackElementStateRegistry.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				(model.sections.findFirst[it.id == id] as Turnout).currentlyDivergent = (newValue ==
					TurnoutState.DIVERGENT)
				refreshSafetyLogicState
			}
		}

	}

	def refreshSafetyLogicState() {
		// TODO enable all sections
		cuts.forEach [ cut |
			(model.sections.findFirst[id == (cut.victim as Train).currentlyOn.id] as Segment).isEnabled = false //TODO viatra ticket
		]

		hits.forEach [ hit |
			(model.sections.findFirst[id == (hit.victim as Train).currentlyOn.id] as Segment).isEnabled = false //TODO viatra ticket
		]

		model.sections.filter[it instanceof Segment].map[it as Segment].forEach [
			if(isEnabled == false) 
				locator.trackElementCommander.sendSegmentCommand(it.id, SegmentState.DISABLED) 
			else 
				locator.trackElementCommander.sendSegmentCommand(it.id, SegmentState.ENABLED)
		]
	}  

	def exhaustiveTest() { // XXX find a use-case for this
		println("Testing started...")

		val resource = ModelUtil.loadModel()
		setup(resource);
		val model = ModelUtil.getModelFromResource(resource)

		val train1 = RailRoadModelFactory.eINSTANCE.createTrain => [id = 100]
		val train2 = RailRoadModelFactory.eINSTANCE.createTrain => [id = 200]
		model.trains.add(train1)
		model.trains.add(train2)

		val turnouts = #[14, 28, 25, 32, 3, 9, 21] // Same as model.sections.filter[it instanceof Turnout].map[id]
		var testNmbr = 1

		val booleans = #[true, false]

		val PrintWriter writer = new PrintWriter("testres.txt", "UTF-8");

		for (turnout1State : booleans) {
			for (turnout2State : booleans) {
				for (turnout3State : booleans) {
					for (turnout4State : booleans) {
						for (turnout5State : booleans) {
							for (turnout6State : booleans) {
								for (turnout7State : booleans) {
									for (train1Position : model.sections) {
										for (train1Previous : train1Position.currentlyConnected) {
											for (train2Position : model.sections.filter[it.id != train1Position.id]) {
												for (train2Previous : train2Position.currentlyConnected) {
													val currentTurnouts = #[turnout1State, turnout2State, turnout3State,
														turnout4State, turnout5State, turnout6State, turnout7State]
													for (var i = 0; i != 6; i++) {
														val ii = i;
														(model.sections.
															findFirst[id == turnouts.get(ii)] as Turnout).currentlyDivergent = currentTurnouts.
															get(i)
													}

													train1.currentlyOn = train1Position
													train1.previouslyOn = train1Previous as RailRoadElement // TODO Viatra ticket
													train2.currentlyOn = train2Position
													train2.previouslyOn = train2Previous as RailRoadElement

													writer.
														println(
															'''test #«testNmbr++»	«turnout1State.boolAsInt» «turnout2State.boolAsInt» «turnout3State.boolAsInt» «turnout4State.boolAsInt» «turnout5State.boolAsInt» «turnout6State.boolAsInt» «turnout7State.boolAsInt» «train1.currentlyOn.id» «train1.previouslyOn.id» «train2.currentlyOn.id» «train2.previouslyOn.id» «FOR cut : cuts»«cut.print»«ENDFOR»	«FOR hit : hits»«hit.print»«ENDFOR»'''
														)
												}
											}
										}
										System.gc
										Thread.sleep(10)
									}
								}
							}
						}
					}
				}
			}
		}
		writer.close
		println("Testing finished")
	}
}
