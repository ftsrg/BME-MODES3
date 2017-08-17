package hu.bme.mit.inf.modes3.components.touchboard

import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import java.util.regex.Pattern
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.control.Button
import org.slf4j.Logger
import org.slf4j.impl.SimpleLoggerFactory

class Controller2 {

	private val Logger logger
	private val ITrackElementStateRegistry trackElementStateRegistry
	private val ITrackElementCommander trackElementCommander

	new() {
		val loggerFactory = new SimpleLoggerFactory
		logger = loggerFactory.getLogger(Controller.name)

		// TODO inject MQTTStack arguments here
		// val argumentRegistry = new ArgumentRegistry(loggerFactory)
		// val mqttStack = CommunicationStackFactory::createMQTTStack(argumentRegistry, loggerFactory)
		val dummyStack = CommunicationStackFactory::createDummyStack(loggerFactory)
		val service = new TrackCommunicationServiceLocator(dummyStack, loggerFactory)
		trackElementStateRegistry = service.trackElementStateRegistry
		trackElementCommander = service.trackElementCommander
	}

	@FXML def void handleTurnoutPress(ActionEvent event) {
		try {
			val turnoutId = getSourceId(event)
			val state = trackElementStateRegistry.getTurnoutState(turnoutId)
			val newState = getTurnoutOppositeState(state)
			trackElementCommander.sendTurnoutCommand(turnoutId, newState)
			logger.info('''Turnout «turnoutId» is «newState»''')
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	@FXML def void handleSegmentPress(ActionEvent event) {
		try {
			val segmentId = getSourceId(event)
			val state = trackElementStateRegistry.getSegmentState(segmentId)
			val newState = getSegmentOppositeState(state)
			trackElementCommander.sendSegmentCommand(segmentId, newState)
			logger.info('''Segment «segmentId» is «newState»''')
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	private def getTurnoutOppositeState(TurnoutState state) {
		switch (state) {
			case STRAIGHT:
				TurnoutState.DIVERGENT
			case DIVERGENT:
				TurnoutState.STRAIGHT
			case ILLEGAL:
				TurnoutState.ILLEGAL
		}
	}

	private def getSegmentOppositeState(SegmentState state) {
		switch (state) {
			case ENABLED:
				SegmentState.DISABLED
			case DISABLED:
				SegmentState.ENABLED
		}
	}

	private def int getSourceId(ActionEvent event) throws IllegalArgumentException{
		try {
			val eventSrc = event.source
			if (eventSrc instanceof Button) {
				val btnId = (eventSrc as Button).id
				getNumbersFromString(btnId)
			} else {
				throw new Exception("Event source is not a Button.")
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException("Source ID does not exist.", ex)
		}
	}

	private def int getNumbersFromString(String str) {
		val matcher = Pattern.compile("\\d+").matcher(str)
		matcher.find
		val match = matcher.group
		Integer.parseInt(match)
	}

}
