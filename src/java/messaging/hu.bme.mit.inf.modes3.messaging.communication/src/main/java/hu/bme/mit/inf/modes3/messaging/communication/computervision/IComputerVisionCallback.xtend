package hu.bme.mit.inf.modes3.messaging.communication.computervision

import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.IComputerVisionListener

interface IComputerVisionCallback {
	def void setComputerVisionListener(IComputerVisionListener listener, long timestamp, long frameindex)
}