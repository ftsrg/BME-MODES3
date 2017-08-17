package hu.bme.mit.inf.modes3.components.touchboard

import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import java.util.Map
import java.util.TreeMap
import java.util.regex.Pattern
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Scene
import javafx.scene.control.Button
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class Controller {

	val ILoggerFactory loggerFactory
	val Logger logger

	var ITrackElementStateRegistry trackElementStateRegistry
	var ITrackElementCommander trackElementCommander

	var Map<Integer, SegmentEventHandler> segments
	var Map<Integer, TurnoutEventHandler> turnouts

	new(ILoggerFactory loggerFactory, ArgumentRegistry argumentRegistry) {
		this.loggerFactory = loggerFactory
		logger = loggerFactory.getLogger(Controller.name)

		// TODO inject MQTTStack arguments here
		// val mqttStack = CommunicationStackFactory::createMQTTStack(argumentRegistry, loggerFactory)
		val dummyStack = CommunicationStackFactory::createDummyStack(loggerFactory)
		val service = new TrackCommunicationServiceLocator(dummyStack, loggerFactory)
		trackElementStateRegistry = service.trackElementStateRegistry
		trackElementCommander = service.trackElementCommander
		
		// TODO async event listeners: occupancy, segment status change, turnout status change
	}

	def void setScene(Scene scene) {
		initializeSegments(scene)
		initializeTurnouts(scene)
	}

	def initializeSegments(Scene scene) {
		segments = new TreeMap
		for (i : 1 ..< 32) {
			println("#segment_" + i)
			val node = scene.lookup("#segment_" + i)
			println(node)
			val eventHandler = new SegmentEventHandler(loggerFactory, new ThreadSafeNode(node, i),
				trackElementStateRegistry, trackElementCommander)
			segments.put(i, eventHandler)
		}
	}

	def initializeTurnouts(Scene scene) {
		turnouts = new TreeMap
		for (i : 1 ..< 7) {
			val node = scene.lookup("#turnout_" + i)
			val eventHandler = new TurnoutEventHandler(loggerFactory, new ThreadSafeNode(node, i),
				trackElementStateRegistry, trackElementCommander)
			turnouts.put(i, eventHandler)
		}
	}

	@FXML def void handleTurnoutPress(ActionEvent event) {
		try {
			val turnoutId = getSourceId(event)
			turnouts.get(turnoutId)?.onTurnoutClicked
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	@FXML def void handleSegmentPress(ActionEvent event) {
		try {
			val segmentId = getSourceId(event)
			segments.get(segmentId)?.onSegmentClicked
		} catch (Exception ex) {
			logger.error(ex.message, ex)
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
