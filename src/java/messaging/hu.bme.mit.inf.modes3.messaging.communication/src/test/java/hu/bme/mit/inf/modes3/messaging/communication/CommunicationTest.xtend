package hu.bme.mit.inf.modes3.messaging.communication

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ISegmentCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITurnoutCommandListener
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.helpers.NOPLoggerFactory
import org.junit.Ignore
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory

// FIXME reimplement this test with the new transport

class CommunicationTest {
//	var TrackCommunicationServiceLocator locator
//	val waitTime = 500
//	var ModifiableBool gotMsg
//
//	@Before
//	def void init() {
//		locator = new TrackCommunicationServiceLocator(CommunicationStackFactory::createLocalStack, new NOPLoggerFactory)
//		gotMsg = new ModifiableBool => [bool = false]
//	}
//
//	@Test
//	def void sendSegmentCommandTest() {
//		locator.trackElementCommandCallback.segmentCommandListener = new ISegmentCommandListener() {
//
//			override onSegmentCommand(int id, SegmentState state) {
//				if(id == 1 && state == SegmentState.DISABLED) {
//					gotMsg.bool = true
//				}
//			}
//		}
//
//		locator.trackElementCommander.sendSegmentCommand(1, SegmentState.DISABLED)
//		Thread.sleep(waitTime)
//		Assert.assertEquals(true, gotMsg.bool)
//	}
//
//	// this test always failed during every build, should check later @zsoltmazlo
//	@Ignore
//	@Test
//	def void sendTurnoutCommandTest() {
//		locator.trackElementCommandCallback.turnoutCommandListener = new ITurnoutCommandListener() {
//
//			override onTurnoutCommand(int id, TurnoutState state) {
//				if(id == 1 && state == TurnoutState.STRAIGHT) {
//					gotMsg.bool = true
//				}
//			}
//
//		}
//		locator.trackElementCommander.sendTurnoutCommand(1, TurnoutState.STRAIGHT)
//		Thread.sleep(waitTime)
//		Assert.assertEquals(true, gotMsg.bool)
//	}
//
//	@Test
//	def void sendSegmentStateTest() {
//		locator.trackElementStateRegistry.segmentStateChangeListener = new ISegmentStateChangeListener() {
//			override onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue) {
//				if(id == 1 && newValue == SegmentState.ENABLED) {
//					gotMsg.bool = true
//				}
//			}
//		}
//		locator.trackElementStateSender.sendSegmentState(1, SegmentState.ENABLED)
//		Thread.sleep(waitTime)
//		Assert.assertEquals(true, gotMsg.bool)
//		Assert.assertEquals(locator.trackElementStateRegistry.getSegmentState(1), SegmentState.ENABLED)
//	}
//
//	@Test
//	def void sendTurnoutStateTest() {
//		locator.trackElementStateRegistry.turnoutStateChangeListener = new ITurnoutStateChangeListener() {
//
//			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
//				if(id == 1 && newValue == TurnoutState.STRAIGHT) {
//					gotMsg.bool = true
//				}
//			}
//		}
//		locator.trackElementStateSender.sendTurnoutState(1, TurnoutState.STRAIGHT)
//		Thread.sleep(waitTime)
//		Assert.assertEquals(true, gotMsg.bool)
//		Assert.assertEquals(locator.trackElementStateRegistry.getTurnoutState(1), TurnoutState.STRAIGHT)
//	}
//
//	@Test
//	def void sendOccupancyStateTest() {
//		locator.trackElementStateRegistry.segmentOccupancyChangeListener = new ISegmentOccupancyChangeListener() {
//
//			override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
//				if(id == 1 && newValue == SegmentOccupancy.OCCUPIED) {
//					gotMsg.bool = true
//				}
//			}
//		}
//		locator.trackElementStateSender.sendSegmentOccupation(1, SegmentOccupancy.OCCUPIED)
//		Thread.sleep(waitTime)
//		Assert.assertEquals(true, gotMsg.bool)
//		Assert.assertEquals(locator.trackElementStateRegistry.getSegmentOccupancy(1), SegmentOccupancy.OCCUPIED)
//	}
//
//	@Test
//	def void send() {
//	}
//
//	static class ModifiableBool {
//		var public boolean bool;
//	}
}
