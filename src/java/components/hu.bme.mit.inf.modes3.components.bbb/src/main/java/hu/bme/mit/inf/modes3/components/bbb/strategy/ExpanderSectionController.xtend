package hu.bme.mit.inf.modes3.components.bbb.strategy;

import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import io.silverspoon.bulldog.core.Signal
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The section controller part of the embedded controller. Through it the
 * referred sections can be managed.
 * 
 * @author hegyibalint, benedekh
 */
class ExpanderSectionController implements ISegmentControllerStrategy {

	private static val Logger logger = LoggerFactory.getLogger(ExpanderSectionController)

	// the actual embedded controller which manages the sections
	protected var ExpanderControllerConfiguration controllerConf

	// the sections statuses based on the section ID
	protected var ConcurrentMap<String, SegmentState> sectionStatus

	// thread-safe wrapper for the BBB board
	protected var BoardWrapper board

	new(BoardWrapper boardWrapper) {
		board = boardWrapper

		try {
			controllerConf = new ExpanderControllerConfiguration
		} catch(Exception ex) {
			logger.error(ex.message, ex)
		}

		sectionStatus = new ConcurrentHashMap
		// enable all sections
		for (sec : controllerConf.getAllSection) {
			enableSection(HexConversionUtil.fromString(sec))
		}
	}

	override getManagedSections() {
		controllerConf.allSection
	}

	override getSectionStatus(int sectionId) {
		sectionStatus.get(HexConversionUtil.fromNumber(sectionId))
	}

	override enableSection(int sectionId) {
		val sectionExpander = controllerConf.getSectionExpander(sectionId);
		board.setPinLevel(sectionExpander.get(0), Signal.High)
		board.setPinLevel(sectionExpander.get(1), Signal.High)
		board.setPinLevel(sectionExpander.get(2), Signal.High)
		board.setPinLevel(sectionExpander.get(3), Signal.High)
		sectionStatus.put(HexConversionUtil.fromNumber(sectionId), SegmentState.ENABLED)
	}

	override disableSection(int sectionId) {
		val sectionExpander = controllerConf.getSectionExpander(sectionId)
		board.setPinLevel(sectionExpander.get(0), Signal.Low)
		board.setPinLevel(sectionExpander.get(1), Signal.Low)
		board.setPinLevel(sectionExpander.get(2), Signal.Low)
		board.setPinLevel(sectionExpander.get(3), Signal.Low)
		sectionStatus.put(HexConversionUtil.fromNumber(sectionId), SegmentState.DISABLED)
	}

	override controllerManagesSection(int sectionId) {
		controllerConf.controllerManagesSection(sectionId)
	}

}
