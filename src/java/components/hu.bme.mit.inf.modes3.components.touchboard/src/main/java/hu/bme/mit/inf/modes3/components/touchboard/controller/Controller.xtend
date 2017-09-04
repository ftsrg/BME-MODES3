package hu.bme.mit.inf.modes3.components.touchboard.controller

import hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement.SegmentEventHandler
import hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement.TurnoutEventHandler
import hu.bme.mit.inf.modes3.components.touchboard.controller.train.Direction
import hu.bme.mit.inf.modes3.components.touchboard.controller.train.SpeedPercentageUtil
import hu.bme.mit.inf.modes3.components.touchboard.controller.train.TrainEventHandler
import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentStateChangeListener
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
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

class Controller extends AbstractCommunicationComponent implements ISegmentOccupancyChangeListener, ISegmentStateChangeListener, ITurnoutStateChangeListener {

	val ILoggerFactory loggerFactory
	val Logger logger
	val ExecutorService executor

	var ITrackElementStateRegistry trackElementStateRegistry
	var ITrackElementCommander trackElementCommander

	val Map<Integer, TrainEventHandler> trains
	var Map<Integer, SegmentEventHandler> segments
	var Map<Integer, TurnoutEventHandler> turnouts

	new(MessagingService messagingService, ILoggerFactory loggerFactory) {
		super(messagingService, loggerFactory)

		this.loggerFactory = loggerFactory
		logger = loggerFactory.getLogger(Controller.name)
		executor = Executors.newCachedThreadPool

		trackElementStateRegistry = locator.trackElementStateRegistry
		trackElementCommander = locator.trackElementCommander

		trackElementStateRegistry.segmentOccupancyChangeListener = this
		trackElementStateRegistry.segmentStateChangeListener = this
		trackElementStateRegistry.turnoutStateChangeListener = this

		trains = new TreeMap
		for (id : LocomotivesConfiguration.INSTANCE.locomotiveIds) {
			trains.put(id, new TrainEventHandler(id, trackElementCommander))
		}
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
				val turnoutId = getNumberFromSourceId(event)
				turnouts.get(turnoutId)?.onTurnoutClicked
			}
		})
	}

	@FXML def void onSegmentPress(ActionEvent event) {
		executeHandler(new Runnable() {
			override run() {
				val segmentId = getNumberFromSourceId(event)
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
					val trainId = getTrainIdFromSourceId(event)
					trains.get(trainId)?.setDirection(direction)
				}
			}
		)
	}

	@FXML def void onTrainSpeedChange(ActionEvent event) {
		executeHandler(
			new Runnable() {
				override run() {
					val trainId = getTrainIdFromSourceId(event)
					val speedPercentageInt = getNumberFromSourceId(event)
					val speedPercentage = SpeedPercentageUtil.toSpeedPercentage(speedPercentageInt)
					trains.get(trainId)?.setSpeedPercentage(speedPercentage)
				}
			}
		)
	}

	def void setScene(Scene scene) {
		initializeSegments(scene)
		initializeTurnouts(scene)
		trackElementCommander.sendAllStatusCommand
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

	private def int getTrainIdFromSourceId(ActionEvent event) {
		try {
			val srcId = getSourceId(event)
			val trainName = srcId.split("_").get(0).toLowerCase
			return LocomotivesConfiguration.INSTANCE.getLocomotiveIdByName(trainName)
		} catch (Exception ex) {
			throw new IllegalArgumentException("Source ID does not contain a valid train name.", ex)
		}
	}

	private def int getNumberFromSourceId(ActionEvent event) {
		try {
			val srcId = getSourceId(event)
			return getNumbersFromString(srcId)
		} catch (Exception ex) {
			throw new IllegalArgumentException("Source ID does not contain a number.", ex)
		}
	}

	private def getSourceId(ActionEvent event) {
		try {
			val eventSrc = event.source
			if (eventSrc instanceof Node) {
				return (eventSrc as Node).id
			} else {
				throw new Exception
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
		for (i : LayoutConfiguration.INSTANCE.segments) {
			val node = scene.lookup("#segment_" + i)
			val eventHandler = new SegmentEventHandler(loggerFactory, new ThreadSafeNode(node, i),
				trackElementStateRegistry, trackElementCommander)
			segments.put(i, eventHandler)
		}
	}

	private def initializeTurnouts(Scene scene) {
		turnouts = new TreeMap
		for (i : LayoutConfiguration.INSTANCE.turnoutIds) {
			val node = scene.lookup("#turnout_" + i)
			val eventHandler = new TurnoutEventHandler(loggerFactory, new ThreadSafeNode(node, i),
				trackElementStateRegistry, trackElementCommander)
			turnouts.put(i, eventHandler)
		}
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
