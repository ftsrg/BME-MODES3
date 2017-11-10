package hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces

interface ITrainCommandCallback {
	def void setTrainReferenceSpeedCommandListener(ITrainReferenceSpeedCommandListener listener)
	def void setTrainFunctionCommandListener(ITrainFunctionCommandListener listener)
}
