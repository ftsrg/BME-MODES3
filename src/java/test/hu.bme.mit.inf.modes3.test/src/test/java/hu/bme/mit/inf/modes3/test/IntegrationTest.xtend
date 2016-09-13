package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.bbb.handlers.TrackElementCommandDispatcher
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import org.junit.Test
import hu.bme.mit.inf.modes3.components.bbb.notifiers.TrackElementStateChangeNotifier

class IntegrationTest {
	val sl = new SafetyLogic(CommunicationStack::createLocalStack)
	val slThread = new Thread(sl)
	
	
	val bbbThread = new Thread(new Runnable(){
		
		override run() {
			val bbb = new TrackElementCommandDispatcher(CommunicationStack::createLocalStack)
			val bbb1 = new TrackElementStateChangeNotifier(CommunicationStack::createLocalStack)
//			val bbb2 = 
		}
		
	})

	@Test def void integrationTest(){
		
		slThread.start
		
		bbbThread.start
		
	}
}