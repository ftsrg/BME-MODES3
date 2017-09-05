package hu.bme.mit.inf.modes3.messaging.communication.state.train.function

import hu.bme.mit.inf.modes3.messaging.communication.state.train.function.interfaces.ITrainFunctionListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainFunction
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher
import org.eclipse.xtend.lib.annotations.Accessors

package class TrainFunctionCallback implements ITrainFunctionListener {
	@Accessors(#[PROTECTED_GETTER, PUBLIC_SETTER]) var ITrainFunctionListener stateListener

	new(AbstractMessageDispatcher dispatcher, ITrainFunctionListener stateListener) {
		this.stateListener = stateListener
		val trainFunctionClient = new TrainFunctionClient(this)
		dispatcher.trainFunctionStateHandler = trainFunctionClient
	}

	override onTrainFunction(int trainId, TrainFunction trainFunction) {
		stateListener?.onTrainFunction(trainId, trainFunction)
	}
}
