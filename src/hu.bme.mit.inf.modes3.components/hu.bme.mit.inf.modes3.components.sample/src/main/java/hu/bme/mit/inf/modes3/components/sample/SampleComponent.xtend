package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.components.common.AbstractComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState

class SampleComponent extends AbstractComponent {
	val knownSegments = 1 ..< 10

	def turnOffAll() {
		for (i : knownSegments) {
			communication.trackElementCommander.sendSegmentCommand(i, SegmentState.DISABLED)
		}
	}


	def getStateOfAll() {
		for (i : knownSegments) {
			processState(communication.trackElementStateRegistry.getSegmentState(i), i)
		}
	}

	def void processState(SegmentState state, int id) {
		println(
			'''Segment #«id» is «switch(state){case ENABLED: 'Enabled' case DISABLED: "Disabled"}»'''
		)
	}

}
