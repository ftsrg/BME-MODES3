package hu.bme.mit.inf.kv.yakindu.control.helper;

import java.util.Collections;
import java.util.List;
import org.yakindu.scr.section.ISectionStatemachine;

/**
 *
 * @author benjo
 */
public class NullSection implements ISectionStatemachine.SCISection {

    public static final NullSection NULL_SECTION = new NullSection();

    private NullSection() {

    }

    @Override
    public void raiseRevokeLock() {
        // intentionally left blank
    }

    @Override
    public void raiseLockRequestTo(long value) {
        // intentionally left blank
    }

    @Override
    public void raiseSectionLockedWithReplyTo(long value) {
        // intentionally left blank
    }

    @Override
    public void raiseSectionLockedTo(long value) {
        // intentionally left blank
    }

    @Override
    public void raiseSectionAllowedTo(long value) {
        // intentionally left blank
    }

    @Override
    public void raiseSectionOccupied() {
        // intentionally left blank
    }

    @Override
    public void raiseSectionFree() {
        // intentionally left blank
    }

    @Override
    public boolean isRaisedEnableSection() {
        // intentionally left blank
        return false;
    }

    @Override
    public long getEnableSectionValue() {
        // intentionally left blank
        return -1;
    }

    @Override
    public boolean isRaisedDisableSection() {
        // intentionally left blank
        return false;
    }

    @Override
    public long getDisableSectionValue() {
        // intentionally left blank
        return -1;
    }

    @Override
    public boolean isRaisedPassingAllowedFrom() {
        // intentionally left blank
        return false;
    }

    @Override
    public long getPassingAllowedFromValue() {
        // intentionally left blank
        return -1;
    }

    @Override
    public boolean isRaisedPassingDeniedFrom() {
        // intentionally left blank
        return false;
    }

    @Override
    public long getPassingDeniedFromValue() {
        // intentionally left blank
        return -1;
    }

    @Override
    public boolean isRaisedSectionLockFrom() {
        // intentionally left blank
        return false;
    }

    @Override
    public long getSectionLockFromValue() {
        // intentionally left blank
        return -1;
    }

    @Override
    public long getSTRAIGHT() {
        // intentionally left blank
        return -1;
    }

    @Override
    public long getDIVERGENT() {
        // intentionally left blank
        return -1;
    }

    @Override
    public long getTOP() {
        // intentionally left blank
        return -1;
    }

    @Override
    public long getId() {
        // intentionally left blank
        return -1;
    }

    @Override
    public void setId(long value) {
        // intentionally left blank
    }

    @Override
    public long getDirection() {
        // intentionally left blank
        return -1;
    }

    @Override
    public void setDirection(long value) {
        // intentionally left blank
    }

    @Override
    public List<ISectionStatemachine.SCISectionListener> getListeners() {
        // intentionally left blank
        return Collections.EMPTY_LIST;
    }

}
