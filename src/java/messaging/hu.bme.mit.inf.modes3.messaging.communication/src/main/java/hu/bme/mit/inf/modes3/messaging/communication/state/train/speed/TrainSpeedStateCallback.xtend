package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces.ITrainSpeedStateListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

package class TrainSpeedStateCallback implements ITrainSpeedStateCallback, ITrainSpeedStateListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainSpeedStateListener trainSpeedStateListener

	new(AbstractMessageDispatcher dispatcher) {
		val trainReferenceSpeedClient = new TrainSpeedStateClient(this)
		dispatcher.trainReferenceSpeedHandler = trainReferenceSpeedClient
	}

	override onTrainSpeedState(int id, int speed, TrainDirection direction) {
		trainSpeedStateListener?.onTrainSpeedState(id, speed, direction)
	}

}
