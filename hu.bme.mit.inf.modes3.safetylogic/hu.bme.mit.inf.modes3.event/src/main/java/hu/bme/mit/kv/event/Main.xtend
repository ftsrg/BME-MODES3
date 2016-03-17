package hu.bme.mit.kv.event

import hu.bme.mit.kv.json.JsonObject
import hu.bme.mit.kv.model.modelutil.ModelUtil
import hu.bme.mit.kv.model.railroadmodel.ModelFactory
import hu.bme.mit.kv.model.railroadmodel.Point
import hu.bme.mit.kv.model.railroadmodel.Section
import hu.bme.mit.kv.model.railroadmodel.SectionModel
import hu.bme.mit.kv.model.railroadmodel.Train
import hu.bme.mit.kv.model.railroadmodel.TrainModel
import hu.bme.mit.kv.model.railroadmodel.Turnout
import hu.bme.mit.kv.queries.InSameRailroadPartMatcher
import hu.bme.mit.kv.queries.NextSectionFromSectionInClockwiseMatcher
import hu.bme.mit.kv.queries.SectionNeighborMatcher
import hu.bme.mit.kv.queries.SectionsInSameRailroadPartAsTrainMatcher
import hu.bme.mit.kv.queries.TrainGoingToCutTheTurnoutMatcher
import hu.bme.mit.kv.queries.TrainIsGoingToHitMatcher
import hu.bme.mit.kv.queries.TrainsNextTurnoutMatcher
import java.util.ArrayList
import java.util.HashMap
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.incquery.runtime.api.IncQueryEngine
import org.eclipse.incquery.runtime.emf.EMFScope
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttAsyncClient
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.junit.Before
import org.junit.Test

//import static kvcontrol.requests.AbstractRequest.*
class Main {



	val Object lock = new Object;

	var Resource resource
	var ResourceSet resourceSet
	var IncQueryEngine queryEngine

	var SectionModel sectionModel // root of the runtime EMF model
	var TrainModel trainModel

	@Before
	def void setUp() {

		sectionModel = ModelUtil.loadReadySectionModel
		trainModel = ModelUtil.createReadyTrainModel(sectionModel)

		val reg = Resource.Factory.Registry.INSTANCE
		val m = reg.getExtensionToFactoryMap()
		m.put("model", new XMIResourceFactoryImpl())

		resourceSet = new ResourceSetImpl()
		resource = resourceSet.createResource(URI.createURI("railroad.model"))
		resource.getContents().add(sectionModel)
		resource.getContents().add(trainModel)

		queryEngine = IncQueryEngine.on(new EMFScope(resourceSet))

	}

	@Test
	def void visualizeGraph() {
		println("=================================")
//		var asd = ResetTransformations.toGraphViz(eventEngine.internalModel)
//		println(asd)
	}

	@Test
	def void modelTest() {
		val train1 = trainModel.trains.get(0);
		val train2 = trainModel.trains.get(1);

		sectionModel.sections.forEach [ firstSection |
			sectionModel.sections.forEach [ secondSection |
				println('''==============''')
				println(''''Train1 : «firstSection.id»; Train2 : «secondSection.id»''')
				train1.currentlyOn = firstSection;
				train2.currentlyOn = secondSection
			]
		]
	}

//	@Test
//	def void serverTest() {
//		AbstractRequest.defaultPort = 8080
//		val sender = new SectionStateRequestSender;
//
//		sectionModel.sections.forEach[section|sender.disableSection(section.id) Thread.sleep(250)]
//
//		Thread.sleep(2000)
//		sectionModel.sections.forEach[section|sender.enableSection(section.id) Thread.sleep(250)]
//
//	}
	def Turnout findOccupiedTurnout(Train t, SectionModel sm) {
		val p = ModelFactory.eINSTANCE.createPoint
		p.x = t.x
		p.y = t.y

		val filtered = sm.sections.filter[section|section instanceof Turnout]
		for (Section s : filtered) {
			val turnout = s as Turnout
			if(turnout.rectangle.isPointInside(p)) {
				return turnout
			}
		}

		return null
	}

	def findClosestPoint(Train t, Section s) {
		var minValue = Double.MAX_VALUE

		for (Point p : s.points) {
			var dist = (t.x - p.x) * (t.x - p.x) + (t.y - p.y) * (t.y - p.y)
			if(minValue > dist) {
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
			if(minDist > dist) {
				minDist = dist
				minSec = s
			}
		}

		return minSec
	}

//	@Test
//	def void turnoutReaderTest() {
////		var turnoutIds = #[0x81, 0x82, 0x83, 0x84, 0x85];
//		var turnoutIds = #[0x86, 0x87];
//		while(true) {
//			for (id : turnoutIds) {
//				println(id + "switch state = " + sender.isTurnoutStraight(id))
//			}
//			Thread.sleep(1000)
//		}
//
//	}
	@Test
	def void patternTest() {
		var train1 = trainModel.trains.findFirst[t|t.id == 1]
		train1.currentlyOn = ModelUtil.getSectionByID(sectionModel, 0xB);
		train1.goingClockwise = true

		var train0 = trainModel.trains.findFirst[t|t.id == 0]
		train0.currentlyOn = ModelUtil.getSectionByID(sectionModel, 0xB);
		train1.goingClockwise = false;

		println("=====================================================");

		for (match : TrainGoingToCutTheTurnoutMatcher.on(queryEngine).allMatches) {
			println("CUT")
		}

		println("=====================================================");

		for (match : TrainsNextTurnoutMatcher.on(queryEngine).allMatches) {
			println("train " + match.train.id + " next turnout = " + match.turnout.id)
		}

		println("=====================================================");

		for (match : SectionsInSameRailroadPartAsTrainMatcher.on(queryEngine).allMatches) {
			println("train " + match.train.id + " is in the same part as seciton " + match.section.id)
		}

		println("=====================================================");

		for (match : InSameRailroadPartMatcher.on(queryEngine).allMatches) {
			println("In same railroad : " + ModelUtil.toHexa(match.section.id) + " with " + ModelUtil.toHexa(match.someSection.id))
		}

		println("=====================================================");

		for (match : SectionNeighborMatcher.on(queryEngine).allMatches) {
			println("Section = " + match.s1.id + " is the neighbor of section = " + match.s2.id)
		}

		println("=====================================================");

		for (match : NextSectionFromSectionInClockwiseMatcher.on(queryEngine).allMatches) {
			println("Section = " + ModelUtil.toHexa(match.section.id) + " the next cw section = " + ModelUtil.toHexa(match.nextSection.id))
		}

	}

	@Test
	def void englishTurnoutTest() {
//		var reader = new TurnoutReader(sectionModel, lock)
//		var thread = new Thread(reader);
//		thread.start
		var englishTurnout = ModelUtil.getEnglishTurnout(sectionModel)
		while(true) {
			println("cw = " + ModelUtil.toHexa(englishTurnout.clockwise.id) + "\tccw = " + ModelUtil.toHexa(englishTurnout.counterClockwise.id) + "\tnot = " + ModelUtil.toHexa(englishTurnout.notConnectedSection.id) + "\tnotcw = " + ModelUtil.toHexa(englishTurnout.notConnectedClockwiseSection.id))
			Thread.sleep(1000)
		}
	}

	@Test
	def void networkTest() {
		val turnoutStates = new ArrayList<Boolean>

		for (var int i = 0; i != 10; i++) {
			turnoutStates.add(true);
		}
		
		val Map<Integer, Integer> englishTurnoutMap = new HashMap<Integer, Integer>
		englishTurnoutMap.put(7, 4); // XXX add this mapping to the model? 

		val client = new MqttAsyncClient('tcp://192.168.1.2', 'SafetyLogic', new MemoryPersistence)
		val MqttConnectOptions connOpts = new MqttConnectOptions
		connOpts.cleanSession = true

		client.callback = new MqttCallback() {

			override connectionLost(Throwable arg0) {
				System.err.println("connection lost");
			}

			override deliveryComplete(IMqttDeliveryToken arg0) {
//				throw new UnsupportedOperationException("TODO: auto-generated method stub")
				// Who the fuck cares?
				println('delivery complete')
			}

			override messageArrived(String topic, MqttMessage msg) throws Exception {
				if(topic.equals('modes3/cv')) {
					processCV(msg)
				} else if(topic.equals('modes3/turnout')) {
					processTurnout(msg)
				} else {
					// WHAT?
				}
				msg.payload.toString
			}

			def processTurnout(MqttMessage message) {
//				if(message.payload.toString.startsWith('X'))
				for(line : message.payload.toString.split('\n')){
					if(line.startsWith('X')){
						var int id = Integer.parseInt(line.substring(2,1))
						var modelId = fromPhysicalID(id)
						if(englishTurnoutMap.keySet.contains(modelId)){
							var remappedId = englishTurnoutMap.get(id);
							ModelUtil.switchEnglishTurnout(ModelUtil.getTurnoutByID(sectionModel, remappedId));
							
						} else {
							ModelUtil.switchTurnout(ModelUtil.getTurnoutByID(sectionModel, modelId));
						}
					}
				}

			}

			def fromPhysicalID(Integer integer) { // XXX This should be in the model too
				switch integer {
					case 81: 1
					case 82: 2
					case 83: 3
					case 86: 4
					case 84: 5
					case 85: 6
					case 87: 7
				}

			}

			def processCV(MqttMessage msg) {
				val trimmed = new String(msg.payload.toString).trim
				var JsonObject data;
				try {
					parseJsonFromPacket(lock, sectionModel, trainModel, trimmed)
				} catch(Exception e) {
					println("failed to parse json, here is the file : ")
					println(trimmed);
					data = null
				}

				var matches = TrainsNextTurnoutMatcher.on(queryEngine).allMatches
				if(matches.size == 0) {
					println("I don't see the next turnout")
				}
				for (match : matches) {
					println("train " + match.train.id + " next turnout = " + match.turnout.id)
				}

				val cutMatches = TrainGoingToCutTheTurnoutMatcher.on(queryEngine).allMatches
				if(cutMatches.size == 0) {
					println("No cut")
				} else {
					for (match : cutMatches) {
						println("CUT on turnout #" + match.turnout.id + " with train #" + match.train.id)
						match.train.currentlyOn.enabled = false
						disableSection(match.train.currentlyOn.id);
					}
				}

				var trainHitMatchers = TrainIsGoingToHitMatcher.on(queryEngine).allMatches
				if(trainHitMatchers.size == 0) {
					println("No train is going to hit the other");
				}

				for (match : trainHitMatchers) {
					println("Train #" + match.t1.id + " is going to hit train #" + match.t2.id)
					match.t1.currentlyOn.enabled = false
					disableSection(match.t1.currentlyOn.id);
				}

				sectionModel.sections.filter[section|section.enabled == true].forEach [
					enableSection(it.id)
				]
			}

			def enableSection(int i) {
				client.publish('modes3/section-control', new MqttMessage((i + ';' + 1).bytes))
			}

			def disableSection(int i) {
				client.publish('modes3/section-control', new MqttMessage((i + ';' + 0).bytes))
			}

		}

		client.connect(connOpts)

		Thread.sleep(500);

		client.subscribe('modes3/cv', 1)
		client.subscribe('modes3/turnout', 1)

	}

	def parseJsonFromPacket(Object object, SectionModel model, TrainModel model2, String trimmed) {
		val data = JsonObject.readFrom(trimmed)
		val timestamp = data.get("timestamp").asLong
		val trains = data.get("trains").asArray
		synchronized(lock) {
			for (section : sectionModel.sections) {
				section.enabled = true
			}

			for (i : trains) {
				val jsonTrain = i.asObject
				val id = jsonTrain.get("id").asInt
				val posX = jsonTrain.get("x").asDouble
				val posY = jsonTrain.get("y").asDouble
				val speed = jsonTrain.get("speed").asDouble
				val direction = jsonTrain.get("dir").asString

				var modelTrain = trainModel.trains.findFirst[t|t.id == id]
				// XXX this should be in somewhere else?
				if(modelTrain == null) {
					modelTrain = ModelUtil.addTrain(trainModel, id);

				}

				modelTrain.x = posX
				modelTrain.y = posY
				if(!direction.toUpperCase.equals("NONE")) {
					modelTrain.goingClockwise = (direction.equals("CW"))
				}

				var Section occupied = findOccupiedTurnout(modelTrain, sectionModel)
				if(occupied == null) { // If it's not on a turnout, it must be on a section
					occupied = findClosestSection(modelTrain, sectionModel)
				}

				println(timestamp + "#:\tID = " + modelTrain.id + "\tX = " + modelTrain.x + "\tY = " + modelTrain.y + "\tspeed = " + speed + "\tdirection = " + modelTrain.isGoingClockwise + "\tsection = 0x" + ModelUtil.toHexa(occupied.id))
				modelTrain.currentlyOn = occupied
			}
		}
	}

}
