package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder
import java.util.List

class TrainReferenceSpeedClient implements MessageHandler<TrainReferenceSpeedOrBuilder> {
	
	var List<ITrainReferenceSpeedCallback> callbacks = newArrayList()
	
	new(ProtobufMessageDispatcher dispatcher){
		dispatcher.trainReferenceSpeedHandler = this
	}
	
	def addTrainReferenceSpeedCallback(ITrainReferenceSpeedCallback callback){
		this.callbacks.add(callback)
	}
	
	override handleMessage(TrainReferenceSpeedOrBuilder message) {
		for(ITrainReferenceSpeedCallback callback: this.callbacks) {
			callback.onTrainReferenceSpeed(message.trainID, message.referenceSpeed, message.direction)	
		}
	}
	
	
}
