package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelPackage
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatcher
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class ModelUtil implements IModelInteractor {
	@Accessors(PUBLIC_GETTER) val Resource resource
	@Accessors(PUBLIC_GETTER) val ResourceSet resourceSet;
	@Accessors(PUBLIC_GETTER) val RailRoadModel model
	var ViatraQueryEngine engine
	val Logger logger
	val validTrainIDs = #[8,9,10] //8=RED, 9=TAURUS, 10=SNCF

	new(ILoggerFactory factory) {
		logger = factory.getLogger('ModelUtil')
		resourceSet = new ResourceSetImpl()
		resource = loadModel
		model = resource.modelFromResource
		engine = ViatraQueryEngine.on(new EMFScope(resource))
		model.sections.filter[it instanceof Segment].map[it as Segment].forEach[it.isEnabled = true]
	}

	override getEnabledTrains(){
		model.trains.filter[
			if (it.currentlyOn instanceof Segment) (currentlyOn as Segment).isEnabled 
			else true
		]
	}
	
	override getSegment(int segmentId){
		model.sections.findFirst[id == segmentId]
	}
	
	override addNewTrain(){
		val train = RailRoadModelFactory.eINSTANCE.createTrain => [it.id = getNewTrainID]
		model.trains.add(train)
		return train
	}
	
	def private getNewTrainID(){
		for(trainID : validTrainIDs){
			if(model.trains.findFirst[it.id == trainID] == null) return trainID
		}
		logger.error("There can't be this much trains on the track")
		model.trains.clear
		throw new RuntimeException("There can't be this much trains on the track")
	}
	
	def override removeTrain(Train t){
		model.trains.remove(t)
	}
	
	override getCurrentlyConnected(RailRoadElement what) {
		CurrentlyConnectedMatcher.on(engine).getAllValuesOfconnectedTo(what)
	}
	
	override getCuts() {
		TrainCutsTurnoutMatcher.on(engine).getAllMatches
	}

	override getHits() {
		TrainHitsAnotherTrainMatcher.on(engine).getAllMatches
	}

	def private loadSectionResource() {
		// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		RailRoadModelPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("railroadmodel", new XMIResourceFactoryImpl());
		resourceSet.getResource(URI.createURI("instance.railroadmodel"), true);
	}

	def loadModel() {
		val resource =loadSectionResource
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
			path.via = it.middle
			path.from = it.one
			path.to = it.other
			paths.add(path)
		]

		return modelResource
	}

	def static getModelFromResource(Resource resource) {
		resource.contents.head as RailRoadModel
	}
	
	override Iterable<Turnout> getTurnouts(){
		 model.sections.filter[it instanceof Turnout].map[it as Turnout]
	}
	
	override Iterable<Segment> getSegments(){
		 model.sections.filter[it instanceof Segment].map[it as Segment]
	}
	
	override getSections() {
		model.sections
	}
	
	override getTrains() {
		model.trains
	}
	
}
