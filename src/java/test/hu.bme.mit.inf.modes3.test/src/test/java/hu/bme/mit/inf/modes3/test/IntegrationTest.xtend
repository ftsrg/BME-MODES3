package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.bbb.main.BBBComponent
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.utils.StateNotifierType
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import org.junit.Test
import hu.bme.mit.inf.safetylogic.event.ModelUtil

class IntegrationTest {
	val sl = new SafetyLogic(CommunicationStack::createLocalStack)
	val slThread = new Thread(sl)
	
	
	val bbbThread = new Thread(new BBBComponent(CommunicationStack::createLocalStack, StateNotifierType.STATE_CHANGE_NOTIFIER, new ExpanderSectionController(){
		
	}, new ExpanderTurnoutController(){
		
	}))
	
	val arduinoThread = new Thread(new SegmentOccupancyReaderMock(CommunicationStack::createLocalStack, ModelUtil.getModelFromResource(ModelUtil.loadModel)))

	@Test def void integrationTest(){
		
		slThread.start
	
		bbbThread.start
		
		arduinoThread.start
	}
}