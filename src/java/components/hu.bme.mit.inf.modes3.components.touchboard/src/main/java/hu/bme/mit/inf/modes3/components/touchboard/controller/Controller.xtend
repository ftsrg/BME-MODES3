package hu.bme.mit.inf.modes3.components.touchboard.controller

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import java.util.Map
import java.util.TreeMap
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.regex.Pattern
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Scene
import javafx.scene.control.Button
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class Controller extends AbstractRailRoadCommunicationComponent implements ISegmentOccupancyChangeListener, ISegmentStateChangeListener, ITurnoutStateChangeListener {

	val ILoggerFactory loggerFactory
	val Logger logger
	val ExecutorService executor

	var ITrackElementStateRegistry trackElementStateRegistry
	var ITrackElementCommander trackElementCommander

	var Map<Integer, SegmentEventHandler> segments
	var Map<Integer, TurnoutEventHandler> turnouts

	new(CommunicationStack stack, ILoggerFactory loggerFactory) {
		super(stack, loggerFactory)

		this.loggerFactory = loggerFactory
		logger = loggerFactory.getLogger(Controller.name)
		executor = Executors.newCachedThreadPool

		trackElementStateRegistry = locator.trackElementStateRegistry
		trackElementCommander = locator.trackElementCommander

		trackElementStateRegistry.segmentOccupancyChangeListener = this
		trackElementStateRegistry.segmentStateChangeListener = this
		trackElementStateRegistry.turnoutStateChangeListener = this
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		val segment = segments?.get(id)
		switch (newValue) {
			case OCCUPIED:
				segment?.setOccupied
			case FREE:
				segment?.setFree
		}
	}

	override onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue) {
		val segment = segments?.get(id)
		switch (newValue) {
			case ENABLED:
				segment?.setEnabled
			case DISABLED:
				segment?.setDisabled
		}
	}

	override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		val turnout = turnouts?.get(id)
		switch (newValue) {
			case STRAIGHT:
				turnout?.setStraight
			case DIVERGENT:
				turnout?.setDivergent
			case ILLEGAL: {
			}
		}
	}

	@FXML def void handleTurnoutPress(ActionEvent event) {
		executor.execute(new Runnable() {
			override run() {
				try {
					val turnoutId = getSourceId(event)
					turnouts.get(turnoutId)?.onTurnoutClicked
				} catch (Exception ex) {
					logger.error(ex.message, ex)
				}
			}
		})
	}

	@FXML def void handleSegmentPress(ActionEvent event) {
		executor.execute(new Runnable() {
			override run() {
				try {
					val segmentId = getSourceId(event)
					segments.get(segmentId)?.onSegmentClicked
				} catch (Exception ex) {
					logger.error(ex.message, ex)
				}
			}
		})
	}

	def void setScene(Scene scene) {
		initializeSegments(scene)
		initializeTurnouts(scene)
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

	private def initializeSegments(Scene scene) {
		segments = new TreeMap
		for (i : 1 ..< 32) {
			val node = scene.lookup("#segment_" + i)
			val eventHandler = new SegmentEventHandler(loggerFactory, new ThreadSafeNode(node, i),
				trackElementStateRegistry, trackElementCommander)
			segments.put(i, eventHandler)
		}
	}

	private def initializeTurnouts(Scene scene) {
		turnouts = new TreeMap
		for (i : 1 ..< 7) {
			val node = scene.lookup("#turnout_" + i)
			val eventHandler = new TurnoutEventHandler(loggerFactory, new ThreadSafeNode(node, i),
				trackElementStateRegistry, trackElementCommander)
			turnouts.put(i, eventHandler)
		}
	}

	override run() {
		Thread.currentThread.join
	}

}
