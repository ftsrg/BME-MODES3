package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.event

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.LocalTransport
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import org.junit.Before
import org.junit.Test
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import org.junit.Assert

class SafetyLogicTest {
	
	MessagingService mms
	LocalTransport transport
	ProtobufMessageDispatcher dispatcher
	SafetyLogic sl
	
	@Before
	def init() {
		mms = new MessagingService
		transport = new LocalTransport
		dispatcher = new  ProtobufMessageDispatcher
		sl = new SafetyLogic(new CommunicationStack(mms, transport, dispatcher))
		sl.start();
	}
	
	
	@Test
	def void safetyLogicRegressionTest(){
		new TrackElementStateSender(mms) => [
			sendSegmentOccupation(15, SegmentOccupancy.OCCUPIED)
			sendSegmentOccupation(24, SegmentOccupancy.OCCUPIED)
			
			sendSegmentOccupation(28, SegmentOccupancy.OCCUPIED)
			sendSegmentOccupation(29, SegmentOccupancy.OCCUPIED)
		]
		
		Assert.assertEquals((sl.model.sections.findFirst[id == 24] as Segment).isEnabled,false)
		Assert.assertEquals((sl.model.sections.findFirst[id == 29] as Segment).isEnabled,false)
		
		
	}
}
