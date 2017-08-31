package hu.bme.mit.inf.modes3.components.sample

import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.slf4j.ILoggerFactory

class SampleComponent extends AbstractCommunicationComponent {

	val knownSegments = 1 ..< 10

	new(CommunicationStack communicationStack, ILoggerFactory factory) {
		super(communicationStack, factory)
	}

	def turnOffAll() {
		for (i : knownSegments) {
			locator.trackElementCommander.sendSegmentCommand(i, SegmentState.DISABLED)
		}
	}

	def getStateOfAll() {
		for (i : knownSegments) {
			processState(locator.trackElementStateRegistry.getSegmentState(i), i)
		}
	}

	def void processState(SegmentState state, int id) {
		println(
			'''Segment #«id» is «switch(state){case ENABLED: 'Enabled' case DISABLED: "Disabled"}»'''
		)
	}
	
	
	//The 'main' method of the sample component
	override run() {
		turnOffAll
		
	}

}
