package hu.bme.mit.inf.modes3.components.bbb.strategy;

import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import io.silverspoon.bulldog.core.Signal
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * The section controller part of the embedded controller. Through it the
 * referred sections can be managed.
 * 
 * @author hegyibalint, benedekh
 */
class ExpanderSectionController implements ISegmentControllerStrategy {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	// the actual embedded controller which manages the sections
	protected var ExpanderControllerConfiguration controllerConf

	// the sections statuses based on the section ID
	protected var ConcurrentMap<Integer, SegmentState> sectionStatus

	// thread-safe wrapper for the BBB board
	protected var BoardWrapper board

	new(int turnoutID, BoardWrapper boardWrapper, ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)

		board = boardWrapper

		try {
			controllerConf = new ExpanderControllerConfiguration(turnoutID, factory)
		} catch(Exception ex) {
			logger.error(ex.message, ex)
		}

		sectionStatus = new ConcurrentHashMap
		// enable all sections
		for (sec : controllerConf.getAllSection) {
			enableSection(Integer.valueOf(sec))
		}
	}

	override getManagedSections() {
		controllerConf.allSection.map[sectionStr|Integer.valueOf(sectionStr)].toSet
	}

	override getSectionStatus(int sectionId) {
		sectionStatus.get(sectionId)
	}

	override enableSection(int sectionId) {
		logger.debug('''Enable section «sectionId» physically.''')

		val sectionExpanderPins = controllerConf.getSectionExpander(sectionId);
		sectionExpanderPins.forEach[
			board.setPinLevel(it, Signal.High)	
		]

		sectionStatus.put(sectionId, SegmentState.ENABLED)
	}

	override disableSection(int sectionId) {
		logger.debug('''Disable section «sectionId» physically.''')

		val sectionExpanderPins = controllerConf.getSectionExpander(sectionId)
		sectionExpanderPins.forEach[
			board.setPinLevel(it, Signal.Low)	
		]

		sectionStatus.put(sectionId, SegmentState.DISABLED)
	}

	override controllerManagesSection(int sectionId) {
		controllerConf.controllerManagesSection(sectionId)
	}

}
