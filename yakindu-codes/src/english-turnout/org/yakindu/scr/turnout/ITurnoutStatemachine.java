package org.yakindu.scr.turnout;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ITurnoutStatemachine extends IStatemachine {

    public interface SCISections {

        public boolean isRaisedRemPassageDeniedToAll();

        public long getSTRAIGHT();

        public long getDIVERGENT();

        public long getTOP();

        public List<SCISectionsListener> getListeners();

    }

    public interface SCISectionsListener {

        public void onRemPassageDeniedToAllRaised();
    }

    public SCISections getSCISections();

    public interface SCITurnout {

        public void raiseTurnoutStraight();

        public void raiseTurnoutDivergent();

        public void raisePassingAllowedFrom(long value);

        public void raisePassingDeniedFrom(long value);

        public void raiseRemPassageAllowedFrom(long value);

        public void raiseRemPassageDeniedFrom(long value);

        public void raisePassingAllowedFromOtherHalfIN();

        public void raisePassingDeniedFromOtherHalfIN();

        public void raiseSectionLockFrom(long value);

        public void raiseRemSectionLockFrom(long value);

        public void raiseRemShortSectionLockFrom(long value);

        public void raiseSectionLockFromOtherHalfIN();

        public void raiseRemSectionLockFromOtherHalfIN();

        public boolean isRaisedSectionAllowedTo();

        public long getSectionAllowedToValue();

        public boolean isRaisedLockRequestTo();

        public long getLockRequestToValue();

        public boolean isRaisedSectionLockedTo();

        public long getSectionLockedToValue();

        public boolean isRaisedSectionLockedWithReplyTo();

        public long getSectionLockedWithReplyToValue();

        public boolean isRaisedRemPassageRequestTo();

        public long getRemPassageRequestToValue();

        public boolean isRaisedRemPassageAllowedTo();

        public long getRemPassageAllowedToValue();

        public boolean isRaisedRemPassageDeniedTo();

        public long getRemPassageDeniedToValue();

        public boolean isRaisedSectionLockFromOtherHalfOUT();

        public boolean isRaisedRemSectionLockFromOtherHalfOUT();

        public boolean isRaisedPassingAllowedFromOtherHalfOUT();

        public boolean isRaisedPassingDeniedFromOtherHalfOUT();

        public long getId();

        public void setId(long value);

        public boolean getIsOccupied();

        public void setIsOccupied(boolean value);

        public List<SCITurnoutListener> getListeners();

    }

    public interface SCITurnoutListener {

        public void onSectionAllowedToRaised(long value);

        public void onLockRequestToRaised(long value);

        public void onSectionLockedToRaised(long value);

        public void onSectionLockedWithReplyToRaised(long value);

        public void onRemPassageRequestToRaised(long value);

        public void onRemPassageAllowedToRaised(long value);

        public void onRemPassageDeniedToRaised(long value);

        public void onSectionLockFromOtherHalfOUTRaised();

        public void onRemSectionLockFromOtherHalfOUTRaised();

        public void onPassingAllowedFromOtherHalfOUTRaised();

        public void onPassingDeniedFromOtherHalfOUTRaised();
    }

    public SCITurnout getSCITurnout();

}
