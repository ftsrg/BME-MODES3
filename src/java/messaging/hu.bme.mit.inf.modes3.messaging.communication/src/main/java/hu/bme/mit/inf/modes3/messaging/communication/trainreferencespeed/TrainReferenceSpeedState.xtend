package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionValue
import java.util.HashMap
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainReferenceSpeedState {
	val ProtobufMessageDispatcher dispatcher
	val TrainReferenceSpeedClient client
	val speeds = new HashMap<Integer, Integer>
	val directions = new HashMap<Integer, TrainDirectionValue>
	val Logger logger
	
	new(ProtobufMessageDispatcher dispatcher, ILoggerFactory factory){
		logger = factory.getLogger('TrainReferenceSpeedState')
		this.dispatcher = dispatcher
		client = new TrainReferenceSpeedClient(dispatcher)
		client.trainReferenceSpeedCallback = new ITrainReferenceSpeedCallback(){
			
			override onTrainReferenceSpeed(int id, int speed, TrainDirectionValue direction) {
				logger.info('''TrainReferenceSpeed message recieved, id=«id», speed=«speed», direction=«direction»''')
				speeds.put(id, speed)
				directions.put(id, direction)
			}
		}
	}
	def getSpeed(int id){
		return speeds.get(id)
	}	
	
	def getDirection(int id){
		return directions.get(id)
	}
}