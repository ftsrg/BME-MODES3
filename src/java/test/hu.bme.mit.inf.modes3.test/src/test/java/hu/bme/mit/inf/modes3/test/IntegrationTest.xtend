package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.bbb.main.BBBComponent
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Turnout
import java.util.HashSet
import org.junit.Test

class IntegrationTest {
	val sl = new SafetyLogic(CommunicationStack::createLocalStack)
	val slThread = new Thread(sl)

	val RailRoadModel model = ModelUtil.getModelFromResource(ModelUtil.loadModel)

	val physicalThread = new Thread( new PhyicalEnvironmentSimulation(model))
	
	val arduinoThread = new Thread(new SegmentOccupancyReaderMock(CommunicationStack::createLocalStack, model))

	val bbbThread = new Thread(new BBBComponent(CommunicationStack::createLocalStack, new ISegmentControllerStrategy(){
		override getManagedSections() {
			new HashSet<String> => [addAll(model.sections.map[id.toString])]
		}
		override controllerManagesSection(int sectionId) {
			true
		}
		override enableSection(int sectionId) {
			(model.sections.findFirst[id == sectionId] as Segment).isEnabled = true
		}
		override disableSection(int sectionId) {
			(model.sections.findFirst[id == sectionId] as Segment).isEnabled = false
		}
		override getSectionStatus(int sectionId) {
			if((model.sections.findFirst[id == sectionId] as Segment).isEnabled) SegmentState.ENABLED else SegmentState.DISABLED
		}
		}, new ITurnoutControllerStrategy(){
			override getTurnoutStatus(int turnoutId) {
				if((model.sections.findFirst[id == turnoutId] as Turnout).isCurrentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT
			}
			override setTurnoutStraight(int turnoutId) {
				(model.sections.findFirst[id == turnoutId] as Turnout).currentlyDivergent = true
			}
			override setTurnoutDivergent(int turnoutId) {
				(model.sections.findFirst[id == turnoutId] as Turnout).currentlyDivergent = false
			}
			override controllerManagesTurnout(int turnoutId) {
				true
			}
			override getManagedTurnouts() {
				new HashSet<String> => [addAll(model.sections.filter[it instanceof Turnout].map[id].map[toString])]
			}}))


	@Test def void integrationTest() {
		slThread.start
		bbbThread.start
		physicalThread.start
		arduinoThread.start
		
		Thread.sleep(1000)
	}
}
