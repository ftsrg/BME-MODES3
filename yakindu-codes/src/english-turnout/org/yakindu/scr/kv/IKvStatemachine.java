package org.yakindu.scr.kv;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface IKvStatemachine extends IStatemachine {

    public interface SCISections {

        public void raiseRevokeLock();

        public void raiseDivergentOccupied();

        public void raiseStraightOccupied();

        public void raiseDivergentFree();

        public void raiseStraightFree();

        public boolean isRaisedEnableSection();

        public long getEnableSectionValue();

        public boolean isRaisedDisableSection();

        public long getDisableSectionValue();

        public boolean isRaisedRemPassageRequestToDivergent();

        public boolean isRaisedRemPassageRequestToStraight();

        public boolean isRaisedRemPassageAllowedToDivergent();

        public boolean isRaisedRemPassageAllowedToStraight();

        public boolean isRaisedRemPassageDeniedToDivergent();

        public boolean isRaisedRemPassageDeniedToStraight();

        public boolean isRaisedRemPassageDeniedToAll();

        public void raiseRemPassageAllowedFromDivergent();

        public void raiseRemPassageAllowedFromStraight();

        public void raiseRemPassageDeniedFromDivergent();

        public void raiseRemPassageDeniedFromStraight();

        public List<SCISectionsListener> getListeners();

    }

    public interface SCISectionsListener {

        public void onEnableSectionRaised(long value);

        public void onDisableSectionRaised(long value);

        public void onRemPassageRequestToDivergentRaised();

        public void onRemPassageRequestToStraightRaised();

        public void onRemPassageAllowedToDivergentRaised();

        public void onRemPassageAllowedToStraightRaised();

        public void onRemPassageDeniedToDivergentRaised();

        public void onRemPassageDeniedToStraightRaised();

        public void onRemPassageDeniedToAllRaised();
    }

    public SCISections getSCISections();

    public interface SCITurnout {

        public void raiseTurnoutDivergent();

        public void raiseTurnoutStraight();

        public void raiseRemSectionLockFromDivergent();

        public void raiseRemSectionLockFromStraight();

        public void raiseRemShortSectionLockFromDivergent();

        public void raiseRemShortSectionLockFromStraight();

        public void raiseRemSectionLockFromOtherHalfIN();

        public void raiseSectionLockFromOtherHalfIN();

        public void raisePassingAllowedFromOtherHalfIN();

        public void raisePassingDeniedFromOtherHalfIN();

        public boolean isRaisedRemSectionLockFromOtherHalfOUT();

        public boolean isRaisedSectionLockFromOtherHalfOUT();

        public boolean isRaisedPassingAllowedFromOtherHalfOUT();

        public boolean isRaisedPassingDeniedFromOtherHalfOUT();

        public long getTurnoutId();

        public void setTurnoutId(long value);

        public long getTurnoutSectionId();

        public void setTurnoutSectionId(long value);

        public boolean getIsOccupied();

        public void setIsOccupied(boolean value);

        public List<SCITurnoutListener> getListeners();

    }

    public interface SCITurnoutListener {

        public void onRemSectionLockFromOtherHalfOUTRaised();

        public void onSectionLockFromOtherHalfOUTRaised();

        public void onPassingAllowedFromOtherHalfOUTRaised();

        public void onPassingDeniedFromOtherHalfOUTRaised();
    }

    public SCITurnout getSCITurnout();

    public interface SCISectionStraight {

        public long getSectionId();

        public void setSectionId(long value);

    }

    public SCISectionStraight getSCISectionStraight();

    public interface SCISectionDivergent {

        public long getSectionId();

        public void setSectionId(long value);

    }

    public SCISectionDivergent getSCISectionDivergent();

}
