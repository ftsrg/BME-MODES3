package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class IntegrationTest {
	val sl = new SafetyLogic(CommunicationStack::createLocalStack)
	val slThread = new Thread(sl)

	val RailRoadModel model = ModelUtil.getModelFromResource(ModelUtil.loadModel)

	val physicalThread = new Thread( new PhyicalEnvironmentSimulation(model))
	
	val arduinoThread = new Thread(new SegmentOccupancyReaderMock(CommunicationStack::createLocalStack, model))
	
	@Mock
	var ExpanderSectionController expander
	
	@Before def void before(){

			
	
	}

//	val bbbThread = new Thread(new BBBComponent(CommunicationStack::createLocalStack, 
//
//		new ExpanderSectionController() {
//			
//		override getManagedSections() {
//			new HashSet<String> => [addAll(model.sections.map[id.toString])]
//		}
//
//		override onGetSectionStatus(int sectionId) {
//			if((model.sections.findFirst[id == sectionId] as Segment).isEnabled) SegmentState.ENABLED else SegmentState.DISABLED
//		}
//
//		override onEnableSection(int sectionId) {
//			(model.sections.findFirst[id == sectionId] as Segment).isEnabled = true
//		}
//
//		override onDisableSection(int sectionId) {
//			(model.sections.findFirst[id == sectionId] as Segment).isEnabled = false
//		}
//
//		override controllerManagesSection(int sectionId) {
//			true
//		}
//
//	}, new ExpanderTurnoutController() {
//
//		override getManagedTurnouts() {
//			new HashSet<String> => [addAll(model.sections.filter[it instanceof Turnout].map[id].map[toString])]
//		}
//
//		override protected onGetTurnoutStatus(int turnoutId) {
//			if((model.sections.findFirst[id == turnoutId] as Turnout).isCurrentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT
//		}
//
//		override controllerManagesTurnout(int turnoutId) {
//			true
//		}
//
//		override protected onSetTurnoutStraight(int turnoutId) {
//			(model.sections.findFirst[id == turnoutId] as Turnout).currentlyDivergent = true			
//		}
//
//		override protected onSetTurnoutDivergent(int turnoutId) {
//			(model.sections.findFirst[id == turnoutId] as Turnout).currentlyDivergent = false
//		}
//
//	}))

	

	@Test def void integrationTest() {
		slThread.start
//		bbbThread.start
		physicalThread.start
		arduinoThread.start
	}
}
