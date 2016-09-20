package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelPackage
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Train
import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatcher
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher

class ModelUtil implements IModelInteractor {
	@Accessors(PUBLIC_GETTER) val Resource resource
	@Accessors(PUBLIC_GETTER) val RailRoadModel model
	var ViatraQueryEngine engine
	var newTrainId = 999

	new() {
		resource = loadModel
		model = resource.modelFromResource
		engine = ViatraQueryEngine.on(new EMFScope(resource))
		model.sections.filter[it instanceof Segment].map[it as Segment].forEach[it.isEnabled = true]
	}

	def override getEnabledTrains(){
		model.trains.filter[
			if (it.currentlyOn instanceof Segment) (currentlyOn as Segment).isEnabled 
			else true
		]
	}
	
	def override getSegment(int segmentId){
		model.sections.findFirst[id == segmentId]
	}
	
	def override addNewTrain(){
		val train = RailRoadModelFactory.eINSTANCE.createTrain => [it.id = newTrainId++]
		model.trains.add(train)
		return train
	}
	
	def override removeTrain(Train t){
		model.trains.remove(t)
	}
	
	public override getCurrentlyConnected(RailRoadElement what) {
		CurrentlyConnectedMatcher.on(engine).getAllValuesOfconnectedTo(what)
	}
	
	package def getCuts() {
		TrainCutsTurnoutMatcher.on(engine).getAllMatches
	}

	package def getHits() {
		TrainHitsAnotherTrainMatcher.on(engine).getAllMatches
	}

	def private static loadSectionResource() {
		// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		RailRoadModelPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("railroadmodel", new XMIResourceFactoryImpl());

		val resourceSet = new ResourceSetImpl();
		resourceSet.getResource(URI.createURI("instance.railroadmodel"), true);
	}

	def static loadModel() {
		val resource = ModelUtil.loadSectionResource
		ModelUtil.createAllPaths(resource)
		return resource;

	}

	def private static createAllPaths(Resource modelResource) {
		// get all matches of the pattern
		// initialization
		// phase 1: (managed) ViatraQueryEngine
		val ViatraQueryEngine engine = ViatraQueryEngine.on(new EMFScope(modelResource))
		// phase 2: the matcher itself
		val matcher = ThreeConnectedRailRoadPartsMatcher.on(engine)

		val paths = getModelFromResource(modelResource).paths
		// get all matches of the pattern
		matcher.getAllMatches().forEach [
			val path = RailRoadModelFactory.eINSTANCE.createPath
			path.via = it.middle as RailRoadElement
			path.from = it.one as RailRoadElement
			path.to = it.other as RailRoadElement
			paths.add(path)
		]

		return modelResource
	}

	def static getModelFromResource(Resource resource) {
		resource.contents.head as RailRoadModel
	}

	
}
