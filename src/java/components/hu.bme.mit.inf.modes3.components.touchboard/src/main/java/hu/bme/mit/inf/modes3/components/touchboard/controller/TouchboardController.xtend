package hu.bme.mit.inf.modes3.components.touchboard.controller

import hu.bme.mit.inf.modes3.components.touchboard.bridge.ITouchboardBridge
import hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement.SegmentEventHandler
import hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement.TurnoutEventHandler
import hu.bme.mit.inf.modes3.components.touchboard.controller.train.Direction
import hu.bme.mit.inf.modes3.components.touchboard.controller.train.SpeedPercentageUtil
import hu.bme.mit.inf.modes3.components.touchboard.controller.train.TrainEventHandler
import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import hu.bme.mit.inf.modes3.utils.conf.LocomotivesConfiguration
import java.util.Map
import java.util.TreeMap
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.regex.Pattern
import javafx.event.ActionEvent
import javafx.fxml.FXML
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.ToggleButton
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TouchboardController implements ITouchboardController {

	val ILoggerFactory loggerFactory
	val Logger logger
	val ExecutorService executor

	val Map<Integer, TrainEventHandler> trains
	var Map<Integer, SegmentEventHandler> segments
	var Map<Integer, TurnoutEventHandler> turnouts

	var ITouchboardBridge touchboardBridge

	new(ILoggerFactory loggerFactory) {
		this.loggerFactory = loggerFactory
		this.logger = loggerFactory.getLogger(TouchboardController.name)
		this.executor = Executors.newCachedThreadPool
		this.trains = new TreeMap
	}

	override setTouchboardBridge(ITouchboardBridge touchboardBridge) {
		this.touchboardBridge = touchboardBridge
		LocomotivesConfiguration.INSTANCE.locomotiveIds.forEach [
			trains.put(it, new TrainEventHandler(it, touchboardBridge.trainCommander))
		]
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

	@FXML def void onTurnoutPress(ActionEvent event) {
		executeHandler(new Runnable() {
			override run() {
				val srcId = getSourceId(event)
				val turnoutId = getNumberFromSourceId(srcId)
				turnouts.get(turnoutId)?.onTurnoutClicked
			}
		})
	}

	@FXML def void onSegmentPress(ActionEvent event) {
		executeHandler(new Runnable() {
			override run() {
				val srcId = getSourceId(event)
				val segmentId = getNumberFromSourceId(srcId)
				segments.get(segmentId)?.onSegmentClicked
			}
		})
	}

	@FXML def void onEnableAllSegment(ActionEvent event) {
		onSetSectionState(new SegmentStateSetter() {
			override onSetSegmentState(SegmentEventHandler handler) {
				handler.onEnableSegment
			}
		})
	}

	@FXML def void onDisableAllSegment(ActionEvent event) {
		onSetSectionState(new SegmentStateSetter() {
			override onSetSegmentState(SegmentEventHandler handler) {
				handler.onDisableSegment
			}
		})
	}

	@FXML def void onTrainDirectionChange(ActionEvent event) {
		executeHandler(
			new Runnable() {
				override run() {
					val isSelected = (event.source as ToggleButton).selected
					val direction = if(isSelected) Direction.BACKWARD else Direction.FORWARD
					val srcId = getSourceId(event)
					val trainId = getTrainIdFromSourceId(srcId)
					trains.get(trainId)?.setDirection(direction)
				}
			}
		)
	}

	@FXML def void onTrainSpeedChange(ActionEvent event) {
		executeHandler(
			new Runnable() {
				override run() {
					val srcId = getSourceId(event)
					val trainId = getTrainIdFromSourceId(srcId)
					val speedPercentageStr = srcId.split("_").get(1)
					val speedPercentageInt = getNumbersFromString(speedPercentageStr)
					val speedPercentage = SpeedPercentageUtil.toSpeedPercentage(speedPercentageInt)
					trains.get(trainId)?.setSpeedPercentage(speedPercentage)
				}
			}
		)
	}

	def void setScene(Scene scene) {
		initializeSegments(scene)
		initializeTurnouts(scene)
		touchboardBridge.sendAllStatusCommand
	}

	private def void executeHandler(Runnable handler) {
		executor.execute(new Runnable() {
			override run() {
				try {
					handler.run
				} catch (Exception ex) {
					logger.error(ex.message, ex)
				}
			}
		})
	}

	private def int getTrainIdFromSourceId(String srcId) {
		try {
			val trainName = srcId.split("_").get(0)
			return LocomotivesConfiguration.INSTANCE.getLocomotiveIdByName(trainName)
		} catch (Exception ex) {
			throw new IllegalArgumentException('''Source ID («srcId») does not contain a valid train name.''', ex)
		}
	}

	private def int getNumberFromSourceId(String srcId) {
		try {
			return getNumbersFromString(srcId)
		} catch (Exception ex) {
			throw new IllegalArgumentException('''Source ID («srcId») does not contain a number.''', ex)
		}
	}

	private def getSourceId(ActionEvent event) {
		try {
			val eventSrc = event.source
			switch (eventSrc) {
				Node: eventSrc.id
				default: throw new Exception
			}
		} catch (Exception ex) {
			throw new IllegalArgumentException('''Event («event») does not have a source ID.''', ex)
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
		LayoutConfiguration.INSTANCE.segments.forEach [
			val node = scene.lookup("#segment_" + it)
			val eventHandler = new SegmentEventHandler(touchboardBridge, new ThreadSafeNode(node, it), loggerFactory)
			segments.put(it, eventHandler)
		]
	}

	private def initializeTurnouts(Scene scene) {
		turnouts = new TreeMap
		LayoutConfiguration.INSTANCE.turnoutIds.forEach [
			val node = scene.lookup("#turnout_" + it)
			val eventHandler = new TurnoutEventHandler(touchboardBridge, new ThreadSafeNode(node, it), loggerFactory)
			turnouts.put(it, eventHandler)
		]
	}

	private interface SegmentStateSetter {
		def void onSetSegmentState(SegmentEventHandler handler)
	}

	private def onSetSectionState(SegmentStateSetter stateSetter) {
		executeHandler(new Runnable() {
			override run() {
				val turnoutSegments = LayoutConfiguration.INSTANCE.turnoutSegmentIds
				segments.forEach [ segmentId, handler |
					if (!turnoutSegments.contains(segmentId)) {
						stateSetter.onSetSegmentState(handler)
					}
				]
			}
		})
	}

	override run() {
		Thread.currentThread.join
	}

}
