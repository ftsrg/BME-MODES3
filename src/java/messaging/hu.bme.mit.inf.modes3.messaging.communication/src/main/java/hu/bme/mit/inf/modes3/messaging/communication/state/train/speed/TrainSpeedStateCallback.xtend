package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.ITrainCurrentSpeedListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.TrainCurrentSpeedClient
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedListener
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.TrainReferenceSpeedClient
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

package class TrainSpeedStateCallback implements ITrainCurrentSpeedListener, ITrainReferenceSpeedListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainCurrentSpeedListener currentSpeedListener
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainReferenceSpeedListener referenceSpeedListener

	new(AbstractMessageDispatcher dispatcher, ITrainCurrentSpeedListener currentSpeedListener, ITrainReferenceSpeedListener referenceSpeedListener) {
		this.currentSpeedListener = currentSpeedListener
		this.referenceSpeedListener = referenceSpeedListener
		
		val trainCurrentSpeedClient = new TrainCurrentSpeedClient(this)
		val trainReferenceSpeedClient = new TrainReferenceSpeedClient(this)
		
		dispatcher.trainCurrentSpeedHandler = trainCurrentSpeedClient
		dispatcher.trainReferenceSpeedHandler = trainReferenceSpeedClient
	}
	
	override onTrainCurrentSpeed(int id, int speed, TrainDirection direction) {
		currentSpeedListener?.onTrainCurrentSpeed(id, speed, direction)
	}
	
	override onTrainReferenceSpeed(int id, int speed, TrainDirection direction) {
		referenceSpeedListener?.onTrainReferenceSpeed(id, speed, direction)
	}

}
