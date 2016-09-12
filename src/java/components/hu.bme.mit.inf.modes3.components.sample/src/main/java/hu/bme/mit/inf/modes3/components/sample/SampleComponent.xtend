package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.components.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack

class SampleComponent extends AbstractCommunicationComponent {

	val knownSegments = 1 ..< 10
	val TrackCommunicationServiceLocator trackCommunication

	new(CommunicationStack communicationStack) {
		super(communicationStack)
		trackCommunication = new TrackCommunicationServiceLocator(super.communication)
	}

	def turnOffAll() {
		for (i : knownSegments) {
			trackCommunication.trackElementCommander.sendSegmentCommand(i, SegmentState.DISABLED)
		}
	}

	def getStateOfAll() {
		for (i : knownSegments) {
			processState(trackCommunication.trackElementStateRegistry.getSegmentState(i), i)
		}
	}

	def void processState(SegmentState state, int id) {
		println(
			'''Segment #«id» is «switch(state){case ENABLED: 'Enabled' case DISABLED: "Disabled"}»'''
		)
	}

}
