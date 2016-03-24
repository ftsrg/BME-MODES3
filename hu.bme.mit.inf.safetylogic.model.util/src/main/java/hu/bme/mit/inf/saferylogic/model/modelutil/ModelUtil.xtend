package hu.bme.mit.inf.saferylogic.model.modelutil

import hu.bme.mit.inf.safetylogic.model.railroadmodel.EnglishTurnout
import hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelFactory
import hu.bme.mit.inf.safetylogic.model.railroadmodel.ModelPackage
import hu.bme.mit.inf.safetylogic.model.railroadmodel.SectionModel
import hu.bme.mit.inf.safetylogic.model.railroadmodel.TrainModel
import hu.bme.mit.inf.safetylogic.model.railroadmodel.Turnout
import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

class ModelUtil {
	static extension ModelFactory factory = ModelFactory.eINSTANCE

	def static loadReadySectionModel() {
		//EPackage.Registry.INSTANCE.put(ModelPackage.eNS_URI, ModelPackage.eINSTANCE);
		ModelPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("kv", new XMIResourceFactoryImpl());

		val resourceSet = new ResourceSetImpl();
		val resource = resourceSet.createResource(URI.createURI("SectionModel.kv"));
		val stream = ModelUtil.getResourceAsStream("/SectionModel.kv")
		resource.load(stream, new HashMap<Object, Object>)

		val sectionModel = resource.contents.head as SectionModel
		return sectionModel
	}
	
	def static addTrain(TrainModel tm , int id ){
		var train = createTrain
		train.id = id
		tm.trains.add(train)
		return train
	}

	def static createReadySectionModel() {
		var sectionModel = createSectionModel
		for (var i = 1; i != 7; i++) {
			if(i != 4 && i!= 9) { // 4 is the english turnout, and 9 is the blind track
				var turnout = createTurnout
				turnout.id = i
				sectionModel.sections.add(turnout)
			}
		}

		for (var i = 8; i != 24; i++) {
			if(i != 0x12 && i != 0xF && i != 0x11) {
				var section = createSection
				section.id = i
				sectionModel.sections.add(section)
			}
		}

		//Blind track
		var blindTrack = createBlindTrack
		blindTrack.id = 9
		blindTrack.counterClockwise = sectionModel.getTurnoutByID(1)
//		sectionModel.getTurnoutByID(1).clockwise = blindTrack
		sectionModel.sections.add(blindTrack)
		
		
		var turnerF = createTurn
		turnerF.id = 0xF
		var turner11 = createTurn
		turner11.id = 0x11
		sectionModel.sections.add(turnerF)
		sectionModel.sections.add(turner11)

		// English turnout
//		var turnout4 = getTurnoutByID(sectionModel, 0x4)
//		var turnout7 = getTurnoutByID(sectionModel, 0x7)
//		var section15 = getSectionByID(sectionModel, 0x15)
//		var section10 = getSectionByID(sectionModel, 0x10)
//		var sectionE = getSectionByID(sectionModel, 0xE)
//		var section16 = getSectionByID(sectionModel, 0x16)
//
//		turnout4.clockwise = turnout7
//		turnout7.counterClockwise = turnout4
//		turnout4.counterClockwise = section15
//		turnout4.notConnectedSection = section10
//		turnout7.clockwise = sectionE
//		turnout7.notConnectedSection = section16
//
//		section15.clockwise = turnout4
//		section10.clockwise = turnout4
//		sectionE.counterClockwise = turnout7
//		section16.counterClockwise = turnout7
		// English Turnout
		var englishTurnout = createEnglishTurnout
		englishTurnout.id = 4;
		var section15 = getSectionByID(sectionModel, 0x15)
		var section10 = getSectionByID(sectionModel, 0x10)
		var sectionE = getSectionByID(sectionModel, 0xE)
		var section16 = getSectionByID(sectionModel, 0x16)

		englishTurnout.clockwise = section16
		section16.counterClockwise = englishTurnout

		englishTurnout.counterClockwise = section15
		section15.clockwise = englishTurnout

		englishTurnout.notConnectedClockwiseSection = sectionE
		sectionE.counterClockwise = englishTurnout

		englishTurnout.notConnectedSection = section10
		section10.clockwise = englishTurnout

		englishTurnout.twoSectionsInClockwiseDirection = false

		sectionModel.sections.add(englishTurnout)

		// Standard turnouts				
		connectSectionToTurnout(sectionModel, 0x1, 0xE, 0x9, 0xD, true)
		connectSectionToTurnout(sectionModel, 0x2, 0xC, 0x16, 0xF, false)
		connectSectionToTurnout(sectionModel, 0x3, 0x8, 0xB, 0x17, true)
		connectSectionToTurnout(sectionModel, 0x5, 0x10, 0xA, 0x11, false)
		connectSectionToTurnout(sectionModel, 0x6, 0x15, 0x13, 0x14, false)

		// Other sections
		connectSectionToSection(sectionModel, 0xC, 0xA)
		connectSectionToSection(sectionModel, 0xD, 0x8)
		connectSectionToSection(sectionModel, 0x17, 0x14)
		connectSectionToSection(sectionModel, 0xB, 0x13)

		// Turner part
		var sec11 = getSectionByID(sectionModel, 0x11)
		var secF = getSectionByID(sectionModel, 0xF)

		sec11.counterClockwise = secF
		secF.counterClockwise = sec11

		// Check for model consistency
//		root.sections.filter[sec|sec.clockwise == null].forEach[sec|println("Clockwise is missing: " + sec.id.toHexa)]
//		root.sections.filter[sec|sec.counterClockwise == null].forEach [ sec |	println("Counterclockwise is missing: " + sec.id.toHexa)]
		// Print the newly generated map
//		println(root.toGraphViz)
		return sectionModel
	}

	def static createReadyTrainModel(SectionModel sectionModel) {
		var trainModel = createTrainModel

		// Add the trains
		var train1 = createTrain
		var train2 = createTrain
		var train3 = createTrain

		train1.id = 0
		train2.id = 1
		train3.id = 2

		trainModel.trains.add(train1)
		trainModel.trains.add(train2)
		trainModel.trains.add(train3)

		return trainModel;
	}

	def static String toGraphViz(SectionModel root) {
		'''
			digraph{
				«FOR sec : root.sections»
					«sec.id.toHexa» -> «sec.clockwise?.id.toHexa»[label="clockwise"];
					«sec.id.toHexa» -> «sec.counterClockwise?.id.toHexa»[label="counterClockwise"];
					«IF sec instanceof Turnout»
						«IF sec.isTwoSectionsInClockwiseDirection»
							«sec.id.toHexa» -> «sec.notConnectedSection.id.toHexa»[label="currentlyNotConnectedClockwise"]
						«ELSE»
							«sec.id.toHexa» -> «sec.notConnectedSection.id.toHexa»[label="currentlyNotConnectedCounterclockwise"]
						«ENDIF»
					«ENDIF»
				«ENDFOR»
			}
		'''
	}

	def static String toHexa(int a) {
		String.format("%X", a)
	}

	def static connectSectionToTurnout(SectionModel model, int turnoutID, int topSection, int straightSection, int divergentsection, boolean twoSectionsInClockwiseDirection) {
		var turnout = getTurnoutByID(model, turnoutID)
		var top = getSectionByID(model, topSection)
		var straight = getSectionByID(model, straightSection);
		var divergent = getSectionByID(model, divergentsection)

		turnout.twoSectionsInClockwiseDirection = twoSectionsInClockwiseDirection

		if(twoSectionsInClockwiseDirection) {
			turnout.counterClockwise = top
			top.clockwise = turnout
			turnout.clockwise = straight
			straight.counterClockwise = turnout
			turnout.notConnectedSection = divergent
			divergent.counterClockwise = turnout
		} else {
			turnout.clockwise = top
			top.counterClockwise = turnout
			turnout.counterClockwise = straight
			straight.clockwise = turnout
			turnout.notConnectedSection = divergent
			divergent.clockwise = turnout
		}

	}

	def static getSectionByID(SectionModel model, int id) {
		model.sections.findFirst[sec|sec.id == id]
	}

	def static getTurnoutByID(SectionModel model, int id) {
		model.sections.findFirst[sec|sec.id == id] as Turnout
	}

	def static connectSectionToSection(SectionModel model, int clockwise, int counterClockwise) {
		var a = getSectionByID(model, clockwise)
		var b = getSectionByID(model, counterClockwise)
		a.clockwise = b
		b.counterClockwise = a
	}

	def static switchTurnout(Turnout t) {
		if(t.twoSectionsInClockwiseDirection) {
			var cw = t.clockwise
			t.clockwise = t.notConnectedSection
			t.notConnectedSection = cw
		} else {
			var ccw = t.counterClockwise
			t.counterClockwise = t.notConnectedSection
			t.notConnectedSection = ccw
		}
	}

	def static getEnglishTurnout(SectionModel model) {
		return model.sections.findFirst[sec|sec.id == 4] as EnglishTurnout
	}

	def static switchEnglishTurnout(Turnout turnout) {
		var englishTurnout = turnout as EnglishTurnout
		var temp = englishTurnout.clockwise
		englishTurnout.clockwise = englishTurnout.notConnectedClockwiseSection
		englishTurnout.notConnectedClockwiseSection = temp
	}

}
