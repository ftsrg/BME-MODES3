package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import java.util.List
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.helpers.NOPLoggerFactory

class SafetyLogicTest {

	MessagingService mms
	SafetyLogic sl
	val sleepTime = 300

	@Before
	def init() {
		val stack = CommunicationStackFactory::createLocalStack
		mms = stack.mms
		sl = new SafetyLogic(stack, new NOPLoggerFactory)
		sl.run(); // The component will run on the main thread
	}

	@Test
	def void safetyLogicRegressionTest() {
		new TrackElementStateSender(mms, new NOPLoggerFactory) => [
			assertOnlyBlocked(#[]) 
			sendSegmentOccupation(15, SegmentOccupancy.OCCUPIED)
			Thread.sleep(sleepTime)
			
			assertOnlyBlocked(#[]) 
			sendSegmentOccupation(24, SegmentOccupancy.OCCUPIED)
			Thread.sleep(sleepTime)

			assertOnlyBlocked(#[])
			sendSegmentOccupation(28, SegmentOccupancy.OCCUPIED)
			Thread.sleep(sleepTime)

			assertOnlyBlocked(#[24])		
			sendSegmentOccupation(29, SegmentOccupancy.OCCUPIED)
			Thread.sleep(sleepTime)
	
			assertOnlyBlocked(#[24, 29])		
		]

	}
	
	@Test
	def void tooCloseWithoutMovingTest(){
		new TrackElementStateSender(mms, new NOPLoggerFactory) => [
			
		]
	}

	def assertOnlyBlocked(List<Integer> integers) {
		sl.model.sections.forEach [
			if(it instanceof Segment) {
				if(integers.contains(it.id)) {
					Assert.assertEquals('''«it.id» Should be disabled but it is enabled''', false, it.isIsEnabled)
				} else {
					Assert.assertEquals('''«it.id» should be enabled, but it is disabled''', true, it.isIsEnabled)
				}
			}
		]

	}

}
