package hu.bme.mit.inf.modes3.bbb.strategy;

import hu.bme.mit.inf.modes3.bbb.utils.HexConversionUtil
import hu.bme.mit.inf.modes3.components.bbb.conf.ExpanderControllerConfiguration
import hu.bme.mit.inf.modes3.components.bbb.conf.IControllerConfiguration
import hu.bme.mit.inf.modes3.components.controller.enums.SegmentState
import io.silverspoon.bulldog.core.Signal
import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * The section controller part of the embedded controller. Through it the
 * referred sections can be managed.
 *
 * @author hegyibalint, benedekh
 */
class ExpanderSectionController extends AbstractControllerStrategy implements IControllerConfiguration {

    // the actual embedded controller which manages the sections
    @Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var ExpanderControllerConfiguration controllerConf;

    // the sections statuses based on the section ID
    @Accessors(PROTECTED_GETTER, PROTECTED_SETTER) var Map<String, SegmentState> sectionStatus;

    new() {
        try {
            controllerConf = new ExpanderControllerConfiguration
        } catch (Exception ex) {
			// TODO
        }
        
        sectionStatus = new ConcurrentHashMap
        for (String sec : controllerConf.getAllSection) {
            onEnableSection(HexConversionUtil.fromString(sec))
        }
    }

    /**
     * @return the most recent section status information
     */
    def getSectionsWithStatus() {
       sectionStatus.entrySet 
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
        // TODO publish section status 
        // publishSectionStatus(sectionId, SectionStatus.ENABLED);
    }

    override onDisableSection(int sectionId) {
        val sectionExpander = controllerConf.getSectionExpander(sectionId)
        this.setPinLevel(sectionExpander.get(0), Signal.Low)
        this.setPinLevel(sectionExpander.get(1), Signal.Low)
        this.setPinLevel(sectionExpander.get(2), Signal.Low)
        this.setPinLevel(sectionExpander.get(3), Signal.Low)
        sectionStatus.put(HexConversionUtil.fromNumber(sectionId), SegmentState.DISABLED)
        // TODO publish section status
        // publishSectionStatus(sectionId, DISABLED);
    }

    override controllerManagesSection(int sectionId) {
        controllerConf.controllerManagesSection(sectionId)
    }

   override controllerManagesTurnout(int turnoutId) {
        throw new UnsupportedOperationException(
                "ExpanderSectionController does not support turnout operations");
    }

    override onGetTurnoutStatus(int turnoutId) {
        throw new UnsupportedOperationException(
                "ExpanderSectionController does not support turnout operations");
    }
}
