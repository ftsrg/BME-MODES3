package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.SectionRequestSender
import hu.bme.mit.inf.kvcontrol.mqtt.client.senders.TurnoutRequestSender
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher
import hu.bme.mit.inf.saferylogic.model.modelutil.ModelUtil
import hu.bme.mit.inf.safetylogic.event.prototype.CVPayload
import hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelFactory
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Point
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Section
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Train
import hu.bme.mit.inf.safetylogic.patterns.TrainIsGoingToHitMatcher
import hu.bme.mit.inf.safetylogic.patterns.TrainsNextTurnoutMatcher
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.viatra.query.runtime.api.ViatraQueryEngine
import org.eclipse.viatra.query.runtime.emf.EMFScope
import hu.bme.mit.inf.safetylogic.model.railroadmodel.RailRoadModel

class Safetylogic {
	var Resource resource
	var ResourceSet resourceSet
	var ViatraQueryEngine queryEngine

	var SectionRequestSender srs;
	var TurnoutRequestSender trs;

	var RailRoadModel railRoadModel // root of the runtime EMF model
	var TurnoutReader turnoutReader

	new(MQTTPublishSubscribeDispatcher dispatcher) {
		srs = new SectionRequestSender(dispatcher)
		trs = new TurnoutRequestSender(dispatcher)
		
		railRoadModel = ModelUtil.loadReadySectionModel
		trainModel = ModelUtil.createReadyTrainModel(railRoadModel)
		turnoutReader = new TurnoutReader(railRoadModel, trs)

		val reg = Resource.Factory.Registry.INSTANCE
		val m = reg.getExtensionToFactoryMap()
		m.put("model", new XMIResourceFactoryImpl())

		resourceSet = new ResourceSetImpl()
		resource = resourceSet.createResource(URI.createURI("railroad.model"))
		resource.getContents().add(railRoadModel)
		resource.getContents().add(trainModel)
		
		queryEngine = ViatraQueryEngine.on(new EMFScope(resourceSet))
	}

	def Turnout findOccupiedTurnout(Train t, SectionModel sm) {
		val p = ModelFactory.eINSTANCE.createPoint
		p.x = t.x
		p.y = t.y

		val filtered = sm.sections.filter[section|section instanceof Turnout]
		for (Section s : filtered) {
			val turnout = s as Turnout
			if (ModelUtil::isPointInside(turnout.rectangle, p)) {
				return turnout
			}
		}

		return null
	}

	def findClosestPoint(Train t, Section s) {
		var minValue = Double.MAX_VALUE

		for (Point p : s.points) {
			var dist = (t.x - p.x) * (t.x - p.x) + (t.y - p.y) * (t.y - p.y)
			if (minValue > dist) {
				minValue = dist
			}
		}

		return minValue
	}

	def findClosestSection(Train t, SectionModel sm) {
		var Section minSec
		var minDist = Double.MAX_VALUE

		for (Section s : sm.sections) {
			var dist = findClosestPoint(t, s)
			if (minDist > dist) {
				minDist = dist
				minSec = s
			}
		}

		return minSec
	}
	
	val log = new StringBuilder
	
	def println(StringBuilder log, String what){
		println(what)
		log.append(what)
		log.append("\n")
	}

	def handle(CVPayload payload) {
		turnoutReader.setTurnoutStatuses
		for (train : payload.trains) {
			val id = train.id
			val posX = train.x
			val posY = train.y
			val speed = train.speed
			val direction = train.dir
			var modelTrain = trainModel.trains.findFirst[t|t.id == id]
			// XXX this should be in somewhere else?
			if (modelTrain == null) {
				modelTrain = ModelUtil.addTrain(trainModel, id);
			}
			modelTrain.x = posX
			modelTrain.y = posY
			if (!direction.toUpperCase.equals("NONE")) {
				modelTrain.goingClockwise = (direction.equals("CW"))
			}
			var Section occupied = findOccupiedTurnout(modelTrain, railRoadModel)
			if (occupied == null) { // If it's not on a turnout, it must be on a section
				occupied = findClosestSection(modelTrain, railRoadModel)
			}
			log.println(
				"#:\tID = " + modelTrain.id + "\tX = " + modelTrain.x + "\tY = " + modelTrain.y + "\tspeed = " + speed +
					"\tdirection = " + modelTrain.isGoingClockwise + "\tsection = 0x" + ModelUtil.toHexa(occupied.id))
			modelTrain.currentlyOn = occupied

			val turnoutStates = new ArrayList<Boolean>
			for (i : 0 ..< 10) {
				turnoutStates.add(true)
			}
			val Map<Integer, Integer> englishTurnoutMap = new HashMap<Integer, Integer>
			englishTurnoutMap.put(7, 4); // XXX add this mapping to the model?
		}

		processSafetylogic()
	}

	def processSafetylogic() {
		railRoadModel.sections.forEach[section | 
			section.enabled = true;
		]
		
		var matches = TrainsNextTurnoutMatcher.on(queryEngine).allMatches
		if (matches.size == 0) {
			log.println("I don't see the next turnout")
		}
		for (match : matches) {
			log.println("train " + match.train.id + " next turnout = " + match.turnout.id)
		}
		val cutMatches = TrainGoingToCutTheTurnoutMatcher.on(queryEngine).allMatches
		if (cutMatches.size == 0) {
			log.println("No cut")
		} else {
			for (match : cutMatches) {
				log.println("CUT on turnout #" + match.turnout.id + " with train #" + match.train.id)
				match.train.currentlyOn.enabled = false
				disableSection(match.train.currentlyOn.id);
			}
		}
		var trainHitMatchers = TrainIsGoingToHitMatcher.on(queryEngine).allMatches
		if (trainHitMatchers.size == 0) {
			log.println("No train is going to hit the other");
		}
		for (match : trainHitMatchers) {
			log.println("Train #" + match.t1.id + " is going to hit train #" + match.t2.id)
			match.t1.currentlyOn.enabled = false
			disableSection(match.t1.currentlyOn.id);
		}
		railRoadModel.sections.filter[section|section.enabled == true].forEach [
			val id = it.id
			enableSection(id)
		]
	}

	def enableSection(int i) {
		srs.enableSection(i)
	}

	def disableSection(int i) {
		srs.disableSection(i)
	}
}
