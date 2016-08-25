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

class SafetyLogic {

	protected var ViatraQueryEngine engine;
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
		if(b) {
			1
		} else {
			0
		}
	}

	private def print(TrainCutsTurnoutMatch match) {
		'''CUT: «match.offender.id» «match.victim.id»'''
	}

	private def print(TrainHitsAnotherTrainMatch match) {
		'''HIT: «match.offender.id» «match.victim.id»'''
	}

	def start() {
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
//													val train1Position = model.sections.findFirst[id == 24]
//													val train1Previous = model.sections.findFirst[id == 15]
//													val train2Position = model.sections.findFirst[id == 29]
//													val train2Previous = model.sections.findFirst[id == 28]
													val currentTurnouts = #[turnout1State, turnout2State, turnout3State, turnout4State, turnout5State, turnout6State, turnout7State]
													for (var i = 0; i != 6; i++) {
														val ii = i;
														(model.sections.findFirst[id == turnouts.get(ii)] as Turnout).currentlyDivergent = currentTurnouts.get(i)
													}

													train1.currentlyOn = train1Position
													train1.previouslyOn = train1Previous
													train2.currentlyOn = train2Position
													train2.previouslyOn = train2Previous

													writer.println(
														'''test #«testNmbr++»	«turnout1State.boolAsInt» «turnout2State.boolAsInt
														» «turnout3State.boolAsInt» «turnout4State.boolAsInt» «turnout5State.boolAsInt
														» «turnout6State.boolAsInt» «turnout7State.boolAsInt» «
														train1.currentlyOn.id» «train1.previouslyOn.id» «train2.currentlyOn.id» «train2.previouslyOn.id
														» «FOR cut : cuts»«cut.print»«ENDFOR»	«FOR hit : hits»«hit.print»«ENDFOR»'''
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
