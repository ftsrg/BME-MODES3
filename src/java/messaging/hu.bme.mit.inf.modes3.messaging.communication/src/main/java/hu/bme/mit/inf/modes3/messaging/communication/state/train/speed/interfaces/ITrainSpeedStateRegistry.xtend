package hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.interfaces

import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.current.ITrainCurrentSpeedRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedRegistry

interface ITrainSpeedStateRegistry extends ITrainCurrentSpeedRegistry, ITrainReferenceSpeedRegistry {
	
}
