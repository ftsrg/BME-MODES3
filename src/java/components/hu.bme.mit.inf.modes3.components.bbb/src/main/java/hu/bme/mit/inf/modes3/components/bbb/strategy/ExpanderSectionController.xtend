package hu.bme.mit.inf.modes3.components.bbb.strategy;

import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import io.silverspoon.bulldog.core.Signal
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * The section controller part of the embedded controller. Through it the
 * referred sections can be managed.
 * 
 * @author hegyibalint, benedekh
 */
class ExpanderSectionController extends AbstractControllerStrategy implements ISegmentControllerStrategy { //TODO refactor this extend @benedekh

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) static val Logger logger = LoggerFactory.getLogger(
		ExpanderSectionController)

	// the actual embedded controller which manages the sections
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var ExpanderControllerConfiguration controllerConf;

	// the sections statuses based on the section ID
	@Accessors(#[PROTECTED_GETTER, PROTECTED_SETTER]) var ConcurrentMap<String, SegmentState> sectionStatus;

	new() {
		try {
			controllerConf = new ExpanderControllerConfiguration
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}

		sectionStatus = new ConcurrentHashMap
		// enable all sections
		for (sec : controllerConf.getAllSection) {
			onEnableSection(HexConversionUtil.fromString(sec))
		}
	}

	override getManagedSections() {
		controllerConf.allSection
	}

	override onGetSectionStatus(int sectionId) {
		sectionStatus.get(HexConversionUtil.fromNumber(sectionId))
	}

	override onEnableSection(int sectionId) {
		val sectionExpander = controllerConf.getSectionExpander(sectionId);
		this.setPinLevel(sectionExpander.get(0), Signal.High)
		this.setPinLevel(sectionExpander.get(1), Signal.High)
		this.setPinLevel(sectionExpander.get(2), Signal.High)
		this.setPinLevel(sectionExpander.get(3), Signal.High)
		sectionStatus.put(HexConversionUtil.fromNumber(sectionId), SegmentState.ENABLED)
	}

	override onDisableSection(int sectionId) {
		val sectionExpander = controllerConf.getSectionExpander(sectionId)
		this.setPinLevel(sectionExpander.get(0), Signal.Low)
		this.setPinLevel(sectionExpander.get(1), Signal.Low)
		this.setPinLevel(sectionExpander.get(2), Signal.Low)
		this.setPinLevel(sectionExpander.get(3), Signal.Low)
		sectionStatus.put(HexConversionUtil.fromNumber(sectionId), SegmentState.DISABLED)
	}

	override controllerManagesSection(int sectionId) {
		controllerConf.controllerManagesSection(sectionId)
	}
	
	override protected onGetTurnoutStatus(int turnoutId) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected onSetTurnoutStraight(int turnoutId) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected onSetTurnoutDivergent(int turnoutId) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}
