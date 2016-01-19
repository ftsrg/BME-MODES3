package org.yakindu.scr.section;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ISectionStatemachine extends IStatemachine {

    public interface SCISection {

        public void raiseRevokeLock();

        public void raiseLockRequestTo(long value);

        public void raiseSectionLockedWithReplyTo(long value);

        public void raiseSectionLockedTo(long value);

        public void raiseSectionAllowedTo(long value);

        public void raiseSectionOccupied();

        public void raiseSectionFree();

        public boolean isRaisedEnableSection();

        public long getEnableSectionValue();

        public boolean isRaisedDisableSection();

        public long getDisableSectionValue();

        public boolean isRaisedPassingAllowedFrom();

        public long getPassingAllowedFromValue();

        public boolean isRaisedPassingDeniedFrom();

        public long getPassingDeniedFromValue();

        public boolean isRaisedSectionLockFrom();

        public long getSectionLockFromValue();

        public long getSTRAIGHT();

        public long getDIVERGENT();

        public long getTOP();

        public long getId();

        public void setId(long value);

        public long getDirection();

        public void setDirection(long value);

        public List<SCISectionListener> getListeners();

    }

    public interface SCISectionListener {

        public void onEnableSectionRaised(long value);

        public void onDisableSectionRaised(long value);

        public void onPassingAllowedFromRaised(long value);

        public void onPassingDeniedFromRaised(long value);

        public void onSectionLockFromRaised(long value);
    }

    public SCISection getSCISection();

}
