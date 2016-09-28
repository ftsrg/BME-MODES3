package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder

class TrainReferenceSpeedClient implements MessageHandler<TrainReferenceSpeedOrBuilder> {
	var ITrainReferenceSpeedCallback callback
	new(ProtobufMessageDispatcher dispatcher){
		dispatcher.trainReferenceSpeedHandler = this
	}
	
	def setTrainReferenceSpeedCallback(ITrainReferenceSpeedCallback callback){
		this.callback = callback
	}
	
	override handleMessage(TrainReferenceSpeedOrBuilder message) {
		callback.onTrainReferenceSpeed(message.trainID, message.referenceSpeed, message.direction)
	}
	
	
}
