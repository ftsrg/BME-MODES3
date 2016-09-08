package hu.bme.mit.inf.modes3.messaging.communication

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.transports.common.LocalTransport
import org.junit.Before
import org.junit.Test
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import org.junit.Assert

class CommunicationTest {
	var TrackCommunicationServiceLocator locator

	@Before
	def void init() {
		locator = new TrackCommunicationServiceLocator(
			new CommunicationStack(new MessagingService, new LocalTransport, new ProtobufMessageDispatcher))
	}

	@Test
	def void sendSegmentCommandTest() {
		val gotMsg = new ModifiableBool => [bool = false]
		locator.trackElementCommandCallback.segmentCommandListener = new ISegmentCommandListener() {

			override onSegmentCommand(int id, SegmentState state) {
				if (id == 1 && state == SegmentState.DISABLED) {
					gotMsg.bool = true
				}
			}

		}

		locator.trackElementCommander.sendSegmentCommand(1, SegmentState.DISABLED)
		Thread.sleep(100)
		Assert.assertEquals(true,gotMsg.bool)
	}

	static class ModifiableBool {
		var boolean bool;
	}
}
