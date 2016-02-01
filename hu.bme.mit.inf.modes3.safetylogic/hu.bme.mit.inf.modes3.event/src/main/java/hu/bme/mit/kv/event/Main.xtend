package hu.bme.mit.kv.event

import com.google.gson.Gson
import com.google.gson.JsonObject
import hu.bme.mit.kv.model.modelutil.ModelUtil
import hu.bme.mit.kv.model.railroadmodel.ModelFactory
import hu.bme.mit.kv.model.railroadmodel.Point
import hu.bme.mit.kv.model.railroadmodel.Section
import hu.bme.mit.kv.model.railroadmodel.SectionModel
import hu.bme.mit.kv.model.railroadmodel.Train
import hu.bme.mit.kv.model.railroadmodel.TrainModel
import hu.bme.mit.kv.model.railroadmodel.Turnout
import hu.bme.mit.kv.patterns.TrainGoingToCutTheTurnoutMatcher
import hu.bme.mit.kv.patterns.TrainIsGoingToHitMatcher
import hu.bme.mit.kv.patterns.TrainsNextTurnoutMatcher
import java.net.DatagramPacket
import java.net.DatagramSocket
import kvcontrol.senders.SectionStateRequestSender
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.emf.EMFScope

class Main {
	val Object lock = new Object;

	var Resource resource
	var ResourceSet resourceSet
	var IncQueryEngine queryEngine

	var SectionModel sectionModel // root of the runtime EMF model
	var TrainModel trainModel
	
	static def main(String[] args) {
		val main = new Main
		main.setUp
		main.start
	}

	def void setUp() {
		sectionModel = ModelUtil.loadReadySectionModel
		trainModel = ModelUtil.createReadyTrainModel(sectionModel)

		resourceSet = new ResourceSetImpl()
		resource = resourceSet.createResource(URI.createURI("railroadmodel.kv"))
		resource.contents.add(sectionModel)
		resource.contents.add(trainModel)

		queryEngine = IncQueryEngine.on(new EMFScope(resourceSet))
	}

	def void start() {
		var reader = new TurnoutReader(sectionModel, lock)
		var thread = new Thread(reader);
		thread.start

		val DatagramSocket socket = new DatagramSocket(24000)
		var boolean flag = true

		while (flag) {
			val buffer = newByteArrayOfSize(1024 * 16)
			val sender = new SectionStateRequestSender
			val packet = new DatagramPacket(buffer, buffer.length)

			socket.receive(packet);
			val trimmed = new String(packet.data).trim
			var JsonObject data;
			try {
				parseJsonFromPacket(lock, sectionModel, trainModel, trimmed)
			} catch (Exception e) {
				println("failed to parse json, here is the file : ")
				println(trimmed);
				data = null
			}
			var trainHitMatchers = TrainIsGoingToHitMatcher.on(queryEngine).allMatches
			val cutMatches = TrainGoingToCutTheTurnoutMatcher.on(queryEngine).allMatches
			if (cutMatches.size == 0 && trainHitMatchers.size == 0) {
				// TODO later
			}
			if (cutMatches.size == 0) {
				println("No cut")
			} else {
				for (match : cutMatches) {
					println("Train #" + match.train.id + " is going to cut turnout #" + match.turnout.id)
					match.train.currentlyOn.enabled = false
				}
			}

			if (trainHitMatchers.size == 0) {
				println("No train is going to hit the other");
			}

			for (match : trainHitMatchers) {
				println("Train #" + match.t1.id + " is going to hit train #" + match.t2.id)
				match.t1.currentlyOn.enabled = false
			}

			TrainsNextTurnoutMatcher.on(queryEngine).allMatches.forEach [match |
				println(match.train.id + " -> " + match.turnout.id)
			]
			sectionModel.sections.forEach [
				if(it.enabled == true) sender.enableSection(it.id) else sender.disableSection(it.id)
			]
		}
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

	def Turnout findOccupiedTurnout(Train t, SectionModel sm) {
		val p = ModelFactory.eINSTANCE.createPoint
		p.x = t.x
		p.y = t.y

		val filtered = sm.sections.filter[section|section instanceof Turnout]
		for (Section s : filtered) {
			val turnout = s as Turnout
			if (turnout.rectangle.isPointInside(p)) {
				return turnout
			}
		}

		return null
	}

	def parseJsonFromPacket(Object object, SectionModel model, TrainModel model2, String trimmed) {
		val gson = new Gson();
		val data = gson.fromJson(trimmed, typeof(JsonObject))
		val timestamp = data.get("timestamp").asLong
		val trains = data.get("trains").asJsonArray
		synchronized (lock) {
			for (section : sectionModel.sections) {
				section.enabled = true
			}

			for (i : trains) {
				val jsonTrain = i.asJsonObject
				val id = jsonTrain.get("id").asInt
				val posX = jsonTrain.get("x").asDouble
				val posY = jsonTrain.get("y").asDouble
				val speed = jsonTrain.get("speed").asDouble
				val direction = jsonTrain.get("dir").asString

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

				var Section occupied = findOccupiedTurnout(modelTrain, sectionModel)
				if (occupied == null) { // If it's not on a turnout, it must be on a section
					occupied = findClosestSection(modelTrain, sectionModel)
				}

				println(
					timestamp + "#:\tID = " + modelTrain.id + "\tX = " + modelTrain.x + "\tY = " +
						modelTrain.y + /* "\tspeed = " + speed +  */ "\tdirection = " + modelTrain.isGoingClockwise +
						"\tsection = 0x" + ModelUtil.toHexa(occupied.id))
				modelTrain.currentlyOn = occupied
			}
		}
	}

} 