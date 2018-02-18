package hu.bme.mit.inf.safetylogic.event

import com.google.common.collect.ImmutableBiMap
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelPackage
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.utils.conf.LocomotivesConfiguration
import hu.bme.mit.inf.safetylogic.patterns.CurrentlyConnectedMatcher
import hu.bme.mit.inf.safetylogic.patterns.NextSectionMatcher
import hu.bme.mit.inf.safetylogic.patterns.ThreeConnectedRailRoadPartsMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainTrailingTurnoutMatcher
import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl
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
	val trainNameMapping = (new ImmutableBiMap.Builder<String, Integer> => [
		putAll(LocomotivesConfiguration.INSTANCE.locomotivesWithNameAndId)
	]).build

	new(ILoggerFactory factory) {
		logger = factory.getLogger('ModelUtil')
		resourceSet = new ResourceSetImpl
		resource = loadModel
		model = resource.modelFromResource
		engine = ViatraQueryEngine.on(new EMFScope(resource))
		model.sections.filter[it instanceof Segment].map[it as Segment].forEach[it.isEnabled = true]
	}

	override getEnabledTrains() {
		synchronized (model) {
			model.trains.filter [
				if(it.currentlyOn instanceof Segment) (currentlyOn as Segment).isEnabled else true
			]
		}
	}

	override getSegment(int segmentId) {
		synchronized (model) {
			model.sections.findFirst[id == segmentId]
		}
	}

	override addNewTrain() {
		synchronized (model) {
			val train = RailRoadModelFactory.eINSTANCE.createTrain => [it.id = getNewTrainID]
			model.trains.add(train)
			return train
		}
	}

	def private getNewTrainID() {
		val nextTrainId = trainNameMapping.values.findFirst[potentialId| !model.trains.map[id].contains(potentialId)] 
		if(nextTrainId !== null){
			return nextTrainId
		}
		
		logger.error("There can't be this much trains on the track")
		model.trains.clear
		throw new RuntimeException("There can't be this much trains on the track")
	}

	def override removeTrain(Train t) {
		synchronized (model) {
			model.trains.remove(t)
		}
	}

	override getCurrentlyConnected(RailRoadElement what) {
		synchronized (model) {
			CurrentlyConnectedMatcher.on(engine).getAllValuesOfconnectedTo(what)
		}
	}

	override getTrailings() {
		synchronized (model) {
			TrainTrailingTurnoutMatcher.on(engine).getAllMatches
		}
	}

	override getHits() {
		synchronized (model) {
			TrainHitsAnotherTrainMatcher.on(engine).getAllMatches
		}
	}

	def private loadSectionResource() {
		RailRoadModelPackage.eINSTANCE.class
		
		// EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		val model = ModelUtil.getResourceAsStream("/instance.railroadmodel")
		val res = new XMIResourceImpl(); 
		res.load(model, null)
		res
	}

	def loadModel() {
		val resource = loadSectionResource
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

	override Iterable<Turnout> getTurnouts() {
		synchronized (model) {
			model.sections.filter[it instanceof Turnout].map[it as Turnout]
		}
	}

	override Iterable<Segment> getSegments() {
		synchronized (model) {
			model.sections.filter[it instanceof Segment].map[it as Segment]
		}
	}

	override getSections() {
		synchronized (model) {
			model.sections
		}
	}

	override getTrains() {
		synchronized (model) {
			model.trains
		}
	}

	override getNextSection(RailRoadElement old, RailRoadElement current) {
		return NextSectionMatcher.on(engine).getAllMatches(old, current, null).head.next
	}

	override ensureIds(List<Pair<RailRoadElement, ComputerVisionInformation>> pairs) {
//		pairs.filter[value.tracked && trainNameMapping.keySet.contains(value.name)].forEach[ pair|
//			val section = model.sections.findFirst[id === pair.key.id]
//			val train = model.trains.findFirst[it.currentlyOn === section]
//			train.id = trainNameMapping.get(pair.value.name)
//			logger.info('''A train got a new ID from the CV information. updated train on «train.currentlyOn» to ID «train.id»''')
//		]
	}

}
