package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.event

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class SafetyLogicTest {
	
	MessagingService mms
	SafetyLogic sl
	
	@Before
	def init() {
		val stack = CommunicationStackFactory::createLocalStack
		mms = stack.mms
		sl = new SafetyLogic(stack)
		sl.run(); // The component will run on the main thread
	}
	
	
	@Test
	def void safetyLogicRegressionTest(){
		new TrackElementStateSender(mms) => [
			sendSegmentOccupation(15, SegmentOccupancy.OCCUPIED)
			sendSegmentOccupation(24, SegmentOccupancy.OCCUPIED)
			
			sendSegmentOccupation(28, SegmentOccupancy.OCCUPIED)
			sendSegmentOccupation(29, SegmentOccupancy.OCCUPIED)
		]
		
		Assert.assertEquals((sl.getSegment(24) as Segment).isEnabled,false)
		Assert.assertEquals((sl.getSegment(29) as Segment).isEnabled,false)
		
		
	}
}
