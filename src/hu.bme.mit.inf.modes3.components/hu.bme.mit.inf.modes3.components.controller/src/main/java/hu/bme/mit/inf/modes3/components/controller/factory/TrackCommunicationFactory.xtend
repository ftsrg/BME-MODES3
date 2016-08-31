package hu.bme.mit.inf.modes3.components.controller.factory

import hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommandCallback
import hu.bme.mit.inf.modes3.components.controller.command.TrackElementCommander
import hu.bme.mit.inf.modes3.components.controller.state.TrackElementStateSender
import hu.bme.mit.inf.modes3.components.controller.state.TrackElementStateRegistry
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.components.controller.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.components.controller.state.interfaces.ITrackElementStateSender

class TrackCommunicationFactory {
	
	def ITrackElementStateSender createTrackElementStateSender(){
		return new TrackElementStateSender
	}
	
	def ITrackElementCommander createTrackElementCommander(){
		return new TrackElementCommander
	}
	
	def ITrackElementCommandCallback createTrackElementCommandCallback(){
		return new TrackElementCommandCallback
	}
	
	def ITrackElementStateRegistry createTrackElementStateRegistry(){
		return new TrackElementStateRegistry
	}
}
