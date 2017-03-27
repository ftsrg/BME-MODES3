package hu.bme.mit.inf.modes3.messaging.communication.trainreferencespeed

import hu.bme.mit.inf.modes3.messaging.communication.enums.EnumTransformator
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.ProtobufMessageDispatcher
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionValue
import java.util.ArrayList
import java.util.Collections
import java.util.List
import java.util.concurrent.ConcurrentHashMap
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainReferenceSpeedState {
	val ProtobufMessageDispatcher dispatcher
	val TrainReferenceSpeedClient client
	val speeds = new ConcurrentHashMap<Integer, Integer>
	val directions = new ConcurrentHashMap<Integer, TrainDirectionValue>
	val Logger logger

	new(ProtobufMessageDispatcher dispatcher, ILoggerFactory factory) {
		logger = factory.getLogger('TrainReferenceSpeedState')
		this.dispatcher = dispatcher
		client = new TrainReferenceSpeedClient(dispatcher)
		client.addTrainReferenceSpeedCallback(new ITrainReferenceSpeedCallback() {

			override onTrainReferenceSpeed(int id, int speed, TrainDirectionValue direction) {
				logger.info('''TrainReferenceSpeed message recieved, id=«id», speed=«speed», direction=«direction»''')
				synchronized (speeds) {
					speeds.put(id, speed);
				}
				synchronized (directions) {
					directions.put(id, direction);
				}
			}
		});
	}

	def addTrainReferenceSpeedCallback(ITrainReferenceSpeedCallback callback) {
		client.addTrainReferenceSpeedCallback(callback);
	}

	def List<Integer> getTrainAddresses() {
		synchronized(speeds) {
			return new ArrayList<Integer>(Collections.list(speeds.keys));	
		}
	}

	def getSpeed(int id) {
		synchronized(speeds) {
			return speeds.get(id);	
		}
	}

	def getDirection(int id) {
		synchronized(directions) {
			return EnumTransformator.toGeneral(directions.get(id));
		}
	}
}
