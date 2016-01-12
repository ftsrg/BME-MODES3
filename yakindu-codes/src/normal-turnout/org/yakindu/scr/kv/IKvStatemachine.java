package org.yakindu.scr.kv;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface IKvStatemachine extends IStatemachine {

    public interface SCISections {

        public void raiseRevokeLock();

        public void raiseTopOccupied();

        public void raiseDivergentOccupied();

        public void raiseStraightOccupied();

        public void raiseTopFree();

        public void raiseDivergentFree();

        public void raiseStraightFree();

        public boolean isRaisedEnableSection();

        public long getEnableSectionValue();

        public boolean isRaisedDisableSection();

        public long getDisableSectionValue();

        public boolean isRaisedRemPassageRequestToTop();

        public boolean isRaisedRemPassageRequestToDivergent();

        public boolean isRaisedRemPassageRequestToStraight();

        public boolean isRaisedRemShortPassageRequestToTop();

        public boolean isRaisedRemShortPassageRequestToStraight();

        public boolean isRaisedRemPassageAllowedToTop();

        public boolean isRaisedRemPassageAllowedToDivergent();

        public boolean isRaisedRemPassageAllowedToStraight();

        public boolean isRaisedRemPassageDeniedToTop();

        public boolean isRaisedRemPassageDeniedToDivergent();

        public boolean isRaisedRemPassageDeniedToStraight();

        public boolean isRaisedRemPassageDeniedToAll();

        public void raiseRemPassageAllowedFromTop();

        public void raiseRemPassageAllowedFromDivergent();

        public void raiseRemPassageAllowedFromStraight();

        public void raiseRemPassageDeniedFromTop();

        public void raiseRemPassageDeniedFromDivergent();

        public void raiseRemPassageDeniedFromStraight();

        public List<SCISectionsListener> getListeners();

    }

    public interface SCISectionsListener {

        public void onEnableSectionRaised(long value);

        public void onDisableSectionRaised(long value);

        public void onRemPassageRequestToTopRaised();

        public void onRemPassageRequestToDivergentRaised();

        public void onRemPassageRequestToStraightRaised();

        public void onRemShortPassageRequestToTopRaised();

        public void onRemShortPassageRequestToStraightRaised();

        public void onRemPassageAllowedToTopRaised();

        public void onRemPassageAllowedToDivergentRaised();

        public void onRemPassageAllowedToStraightRaised();

        public void onRemPassageDeniedToTopRaised();

        public void onRemPassageDeniedToDivergentRaised();

        public void onRemPassageDeniedToStraightRaised();

        public void onRemPassageDeniedToAllRaised();
    }

    public SCISections getSCISections();

    public interface SCITurnout {

        public void raiseTurnoutDivergent();

        public void raiseTurnoutStraight();

        public void raiseRemSectionLockFromTop();

        public void raiseRemSectionLockFromDivergent();

        public void raiseRemSectionLockFromStraight();

        public long getTurnoutId();

        public void setTurnoutId(long value);

        public long getTurnoutSectionId();

        public void setTurnoutSectionId(long value);

        public boolean getIsOccupied();

        public void setIsOccupied(boolean value);

        public boolean getRemTopIsPrior();

        public void setRemTopIsPrior(boolean value);

        public boolean getRemDivergentIsPrior();

        public void setRemDivergentIsPrior(boolean value);

        public boolean getRemStraightIsPrior();

        public void setRemStraightIsPrior(boolean value);

    }

    public SCITurnout getSCITurnout();

    public interface SCISectionTop {

        public long getSectionId();

        public void setSectionId(long value);

    }

    public SCISectionTop getSCISectionTop();

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
