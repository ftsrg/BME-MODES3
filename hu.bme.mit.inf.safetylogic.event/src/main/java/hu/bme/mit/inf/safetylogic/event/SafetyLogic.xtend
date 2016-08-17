package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Path
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope

class SafetyLogic {

	var ViatraQueryEngine engine;

	def setup(Resource modelResource) {
		engine = ViatraQueryEngine.on(new EMFScope(modelResource))
	}

	def start() {
		val resource = ModelUtil.loadModel()
		setup(resource);
		val model = ModelUtil.getModelFromResource(resource)

		// BOILERPLATE TESTCODE STARTS HERE
		val train1 = RailRoadModelFactory.eINSTANCE.createTrain
		train1.id = 100
		val train2 = RailRoadModelFactory.eINSTANCE.createTrain
		train2.id = 200
		train1.currentlyOn = model.sections.findFirst[it.id == 12]
		train1.previouslyOn = model.sections.findFirst[it.id == 14]
		train2.currentlyOn = model.sections.findFirst[it.id == 1]
//		train2.previouslyOn = model.sections.findFirst[it.id == 14]
		model.trains.add(train1)
		model.trains.add(train2)
		

		model.paths.filter[it.from.id == 14 && it.via.id == 12].forEach [
			println(it.print)
		]

		NextSectionMatcher.on(engine).allMatches.filter[it.old.id == 14 && it.current.id == 12].forEach [
			println("from " + it.old.id + "\t via " + it.current.id + "\t to " + it.next.id)
		]

		val hitMatcher = TrainHitsAnotherTrainMatcher.on(engine)
		if(hitMatcher.allMatches.length == 0) {
			println("NO HIT")
		}
		hitMatcher.allMatches.forEach [
			println("Train #" + it.offender + " will hit train #" + it.victim)
		]

		println(model.paths.length)
		println(model.sections.length)
	// BOILERPLATE TESTCODE FINISHED HERE
	}

	def private print(Path p) {
		'''Path from:«p.from»	via:«p.via»		to:«p.to»'''
	}

}
