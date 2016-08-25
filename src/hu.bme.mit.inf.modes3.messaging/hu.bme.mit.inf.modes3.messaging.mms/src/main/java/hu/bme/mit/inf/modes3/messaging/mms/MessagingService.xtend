package hu.bme.mit.inf.modes3.messaging.mms

import com.google.protobuf.GeneratedMessageV3
import hu.bme.mit.inf.modes3.messaging.mms.handlers.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TrainCurrentSegmentHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TrainCurrentSpeedHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TrainReferenceSpeedHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TurnoutStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegment
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeed
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControl

class MessagingService {
	
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var SegmentStateHandler segmentStateHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainCurrentSegmentHandler trainCurrentSegmentHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainCurrentSpeedHandler trainCurrentSpeedHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainReferenceSpeedHandler trainReferenceSpeedHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TurnoutStateHandler turnoutStateHandler = null;
	
	def start() {
		val transport = new ZMQTransport()
		transport.connect()
		
		while(!Thread.currentThread.isInterrupted) {
			Thread.sleep(1000)
			
			val message = Message.parseFrom(transport.receiveMessage())
			
			switch (message.type) {
				case Message.MessageType.SEGMENT_CONTROL: dispatchMessage(message.segmentControl)
				case Message.MessageType.SEGMENT_STATE: dispatchMessage(message.segmentState)
				case Message.MessageType.TRAIN_CURRENT_SEGMENT: dispatchMessage(message.trainCurrentSegment)
				case Message.MessageType.TRAIN_CURRENT_SPEED: dispatchMessage(message.trainCurrentSpeed)
				case Message.MessageType.TRAIN_DIRECTION_CONTROL: dispatchMessage(message.trainDirectionControl)
				case Message.MessageType.TRAIN_FUNCTION_CONTROL: dispatchMessage(message.trainFunctionControl)
				case Message.MessageType.TRAIN_REFERENCE_SPEED: dispatchMessage(message.trainReferenceSpeed)
				case Message.MessageType.TRAIN_REFERENCE_SPEED_CONTROL: dispatchMessage(message.trainReferenceSpeedControl)
				case Message.MessageType.TURNOUT_CONTROL: dispatchMessage(message.turnoutControl)
				case Message.MessageType.TURNOUT_STATE: dispatchMessage(message.turnoutControl)
				default: println("Oops")
			}
		}
	}

	def dispatch dispatchMessage(SegmentControl message) {
		
	}
	
	def dispatch dispatchMessage(SegmentState message) {
		
	}
	
	def dispatch dispatchMessage(TrainCurrentSegment message) {
		
	}
	
	def dispatch dispatchMessage(TrainCurrentSpeed message) {
		
	}
	
	def dispatch dispatchMessage(TrainDirectionControl message) {
		
	}
		
}