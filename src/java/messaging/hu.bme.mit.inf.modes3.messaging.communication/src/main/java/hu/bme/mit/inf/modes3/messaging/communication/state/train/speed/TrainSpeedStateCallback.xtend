package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.ITrainCurrentSpeedListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.ITrainSpeedStateCallback
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.TrainCurrentSpeedClient
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.TrainReferenceSpeedClient
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

package class TrainSpeedStateCallback implements ITrainSpeedStateCallback, ITrainCurrentSpeedListener, ITrainReferenceSpeedListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainCurrentSpeedListener trainCurrentSpeedListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainReferenceSpeedListener trainReferenceSpeedListener

	new(AbstractMessageDispatcher dispatcher) {
		val trainCurrentSpeedClient = new TrainCurrentSpeedClient(this)
		val trainReferenceSpeedClient = new TrainReferenceSpeedClient(this)

		dispatcher.trainCurrentSpeedHandler = trainCurrentSpeedClient
		dispatcher.trainReferenceSpeedHandler = trainReferenceSpeedClient
	}

	override onTrainCurrentSpeed(int id, int speed, TrainDirection direction) {
		trainCurrentSpeedListener?.onTrainCurrentSpeed(id, speed, direction)
	}

	override onTrainReferenceSpeed(int id, int speed, TrainDirection direction) {
		trainReferenceSpeedListener?.onTrainReferenceSpeed(id, speed, direction)
	}

}
