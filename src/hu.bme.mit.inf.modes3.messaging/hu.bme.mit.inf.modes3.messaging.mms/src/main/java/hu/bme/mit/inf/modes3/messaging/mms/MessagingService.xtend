package hu.bme.mit.inf.modes3.messaging.mms

import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.SegmentControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TrainDirectionControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TrainFunctionControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TrainReferenceSpeedControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TurnoutControlHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.SegmentStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TrainCurrentSegmentHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TrainCurrentSpeedHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TrainReferenceSpeedHandler
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TurnoutStateHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport
import java.util.Collections
import org.eclipse.xtend.lib.annotations.Accessors
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl.Builder
import com.google.protobuf.GeneratedMessageV3

class MessagingService {

	// STATUS handlers
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var SegmentStateHandler segmentStateHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainCurrentSegmentHandler trainCurrentSegmentHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainCurrentSpeedHandler trainCurrentSpeedHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainReferenceSpeedHandler trainReferenceSpeedHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TurnoutStateHandler turnoutStateHandler = null;

	// CONTROL handlers
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var SegmentControlHandler segmentControlHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainDirectionControlHandler trainDirectionControlHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainReferenceSpeedControlHandler trainReferenceSpeedControlHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TrainFunctionControlHandler trainFunctionControlHandler = null;
	@Accessors(PUBLIC_SETTER, PROTECTED_GETTER) var TurnoutControlHandler turnoutControlHandler = null;

	def start() {
		val transport = new ZMQTransport()
		transport.connect()

		while(!Thread.currentThread.isInterrupted) {
			try {
				val message = Message.parseFrom(transport.receiveMessage())
				switch (message.type) {
					case Message.MessageType.SEGMENT_CONTROL: segmentControlHandler?.handleSegmentControl(message.segmentControl)
					case Message.MessageType.SEGMENT_STATE: segmentStateHandler?.handleSegmentState(message.segmentState)
					case Message.MessageType.TRAIN_CURRENT_SEGMENT: trainCurrentSegmentHandler?.handleTrainCurrentSegment(message.trainCurrentSegment)
					case Message.MessageType.TRAIN_CURRENT_SPEED: trainCurrentSpeedHandler?.handleTrainCurrentSpeed(message.trainCurrentSpeed)
					case Message.MessageType.TRAIN_DIRECTION_CONTROL: trainDirectionControlHandler?.handleTrainDirectionControl(message.trainDirectionControl)
					case Message.MessageType.TRAIN_FUNCTION_CONTROL: trainFunctionControlHandler?.handleTrainFunctionControl(message.trainFunctionControl)
					case Message.MessageType.TRAIN_REFERENCE_SPEED: trainReferenceSpeedHandler?.handleTrainReferenceSpeed(message.trainReferenceSpeed)
					case Message.MessageType.TRAIN_REFERENCE_SPEED_CONTROL: trainReferenceSpeedControlHandler?.handleTrainReferenceSpeedControl(message.trainReferenceSpeedControl)
					case Message.MessageType.TURNOUT_CONTROL: turnoutControlHandler?.handleTurnoutControl(message.turnoutControl)
					case Message.MessageType.TURNOUT_STATE: turnoutStateHandler?.handleTurnoutState(message.turnoutState)
					default: Collections.EMPTY_LIST.forEach[] // FIXME: Pls send help, I don't know how to throw void
				}
			} catch (Exception e) {
				// This catch is left blank intentionally
			}
			
		}
	}
	
	def sendMessage(GeneratedMessageV3 message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}
