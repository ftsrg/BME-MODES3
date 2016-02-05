package org.yakindu.scr.turnout;

import java.util.LinkedList;
import java.util.List;

public class TurnoutStatemachine implements ITurnoutStatemachine {

    protected class SCISectionsImpl implements SCISections {

        private final List<SCISectionsListener> listeners = new LinkedList<>();

        @Override
        public List<SCISectionsListener> getListeners() {
            return listeners;
        }

        private boolean remPassageDeniedToAll;

        @Override
        public boolean isRaisedRemPassageDeniedToAll() {
            return remPassageDeniedToAll;
        }

        protected void raiseRemPassageDeniedToAll() {
            remPassageDeniedToAll = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageDeniedToAllRaised();
            }
        }

        private long sTRAIGHT;

        @Override
        public long getSTRAIGHT() {
            return sTRAIGHT;
        }

        protected void setSTRAIGHT(long value) {
            this.sTRAIGHT = value;
        }

        private long dIVERGENT;

        @Override
        public long getDIVERGENT() {
            return dIVERGENT;
        }

        protected void setDIVERGENT(long value) {
            this.dIVERGENT = value;
        }

        private long tOP;

        @Override
        public long getTOP() {
            return tOP;
        }

        protected void setTOP(long value) {
            this.tOP = value;
        }

        protected void clearEvents() {
        }

        protected void clearOutEvents() {
            remPassageDeniedToAll = false;
        }
    }

    protected SCISectionsImpl sCISections;

    protected class SCITurnoutImpl implements SCITurnout {

        private final List<SCITurnoutListener> listeners = new LinkedList<>();

        @Override
        public List<SCITurnoutListener> getListeners() {
            return listeners;
        }

        private boolean turnoutStraight;

        @Override
        public void raiseTurnoutStraight() {
            turnoutStraight = true;
        }

        private boolean turnoutDivergent;

        @Override
        public void raiseTurnoutDivergent() {
            turnoutDivergent = true;
        }

        private boolean passingAllowedFrom;

        private long passingAllowedFromValue;

        @Override
        public void raisePassingAllowedFrom(long value) {
            passingAllowedFrom = true;
            passingAllowedFromValue = value;
        }

        protected long getPassingAllowedFromValue() {
            if (!passingAllowedFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return passingAllowedFromValue;
        }

        private boolean passingDeniedFrom;

        private long passingDeniedFromValue;

        @Override
        public void raisePassingDeniedFrom(long value) {
            passingDeniedFrom = true;
            passingDeniedFromValue = value;
        }

        protected long getPassingDeniedFromValue() {
            if (!passingDeniedFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return passingDeniedFromValue;
        }

        private boolean remPassageAllowedFrom;

        private long remPassageAllowedFromValue;

        @Override
        public void raiseRemPassageAllowedFrom(long value) {
            remPassageAllowedFrom = true;
            remPassageAllowedFromValue = value;
        }

        protected long getRemPassageAllowedFromValue() {
            if (!remPassageAllowedFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return remPassageAllowedFromValue;
        }

        private boolean remPassageDeniedFrom;

        private long remPassageDeniedFromValue;

        @Override
        public void raiseRemPassageDeniedFrom(long value) {
            remPassageDeniedFrom = true;
            remPassageDeniedFromValue = value;
        }

        protected long getRemPassageDeniedFromValue() {
            if (!remPassageDeniedFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return remPassageDeniedFromValue;
        }

        private boolean passingAllowedFromOtherHalfIN;

        @Override
        public void raisePassingAllowedFromOtherHalfIN() {
            passingAllowedFromOtherHalfIN = true;
        }

        private boolean passingDeniedFromOtherHalfIN;

        @Override
        public void raisePassingDeniedFromOtherHalfIN() {
            passingDeniedFromOtherHalfIN = true;
        }

        private boolean remPassingAllowedFromOtherHalfIN;

        @Override
        public void raiseRemPassingAllowedFromOtherHalfIN() {
            remPassingAllowedFromOtherHalfIN = true;
        }

        private boolean remPassingDeniedFromOtherHalfIN;

        @Override
        public void raiseRemPassingDeniedFromOtherHalfIN() {
            remPassingDeniedFromOtherHalfIN = true;
        }

        private boolean sectionLockFrom;

        private long sectionLockFromValue;

        @Override
        public void raiseSectionLockFrom(long value) {
            sectionLockFrom = true;
            sectionLockFromValue = value;
        }

        protected long getSectionLockFromValue() {
            if (!sectionLockFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return sectionLockFromValue;
        }

        private boolean remSectionLockFrom;

        private long remSectionLockFromValue;

        @Override
        public void raiseRemSectionLockFrom(long value) {
            remSectionLockFrom = true;
            remSectionLockFromValue = value;
        }

        protected long getRemSectionLockFromValue() {
            if (!remSectionLockFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return remSectionLockFromValue;
        }

        private boolean remShortSectionLockFrom;

        private long remShortSectionLockFromValue;

        @Override
        public void raiseRemShortSectionLockFrom(long value) {
            remShortSectionLockFrom = true;
            remShortSectionLockFromValue = value;
        }

        protected long getRemShortSectionLockFromValue() {
            if (!remShortSectionLockFrom) {
                //throw new IllegalStateException("Illegal event value acces. Event PassingAllowedFrom is not raised!");
                return -1;
            }
            return remShortSectionLockFromValue;
        }

        private boolean sectionLockFromOtherHalfIN;

        @Override
        public void raiseSectionLockFromOtherHalfIN() {
            sectionLockFromOtherHalfIN = true;
        }

        private boolean remSectionLockFromOtherHalfIN;

        @Override
        public void raiseRemSectionLockFromOtherHalfIN() {
            remSectionLockFromOtherHalfIN = true;
        }

        private boolean sectionAllowedTo;

        private long sectionAllowedToValue;

        @Override
        public boolean isRaisedSectionAllowedTo() {
            return sectionAllowedTo;
        }

        protected void raiseSectionAllowedTo(long value) {
            sectionAllowedTo = true;
            sectionAllowedToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onSectionAllowedToRaised(value);
            }
        }

        @Override
        public long getSectionAllowedToValue() {
            if (!sectionAllowedTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionAllowedTo is not raised!");
            }
            return sectionAllowedToValue;
        }

        private boolean lockRequestTo;

        private long lockRequestToValue;

        @Override
        public boolean isRaisedLockRequestTo() {
            return lockRequestTo;
        }

        protected void raiseLockRequestTo(long value) {
            lockRequestTo = true;
            lockRequestToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onLockRequestToRaised(value);
            }
        }

        @Override
        public long getLockRequestToValue() {
            if (!lockRequestTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event LockRequestTo is not raised!");
            }
            return lockRequestToValue;
        }

        private boolean sectionLockedTo;

        private long sectionLockedToValue;

        @Override
        public boolean isRaisedSectionLockedTo() {
            return sectionLockedTo;
        }

        protected void raiseSectionLockedTo(long value) {
            sectionLockedTo = true;
            sectionLockedToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onSectionLockedToRaised(value);
            }
        }

        @Override
        public long getSectionLockedToValue() {
            if (!sectionLockedTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionLockedTo is not raised!");
            }
            return sectionLockedToValue;
        }

        private boolean sectionLockedWithReplyTo;

        private long sectionLockedWithReplyToValue;

        @Override
        public boolean isRaisedSectionLockedWithReplyTo() {
            return sectionLockedWithReplyTo;
        }

        protected void raiseSectionLockedWithReplyTo(long value) {
            sectionLockedWithReplyTo = true;
            sectionLockedWithReplyToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onSectionLockedWithReplyToRaised(value);
            }
        }

        @Override
        public long getSectionLockedWithReplyToValue() {
            if (!sectionLockedWithReplyTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionLockedWithReplyTo is not raised!");
            }
            return sectionLockedWithReplyToValue;
        }

        private boolean remPassageRequestTo;

        private long remPassageRequestToValue;

        @Override
        public boolean isRaisedRemPassageRequestTo() {
            return remPassageRequestTo;
        }

        protected void raiseRemPassageRequestTo(long value) {
            remPassageRequestTo = true;
            remPassageRequestToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemPassageRequestToRaised(value);
            }
        }

        @Override
        public long getRemPassageRequestToValue() {
            if (!remPassageRequestTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemPassageRequestTo is not raised!");
            }
            return remPassageRequestToValue;
        }

        private boolean remPassageAllowedTo;

        private long remPassageAllowedToValue;

        @Override
        public boolean isRaisedRemPassageAllowedTo() {
            return remPassageAllowedTo;
        }

        protected void raiseRemPassageAllowedTo(long value) {
            remPassageAllowedTo = true;
            remPassageAllowedToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemPassageAllowedToRaised(value);
            }
        }

        @Override
        public long getRemPassageAllowedToValue() {
            if (!remPassageAllowedTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemPassageAllowedTo is not raised!");
            }
            return remPassageAllowedToValue;
        }

        private boolean remPassageDeniedTo;

        private long remPassageDeniedToValue;

        @Override
        public boolean isRaisedRemPassageDeniedTo() {
            return remPassageDeniedTo;
        }

        protected void raiseRemPassageDeniedTo(long value) {
            remPassageDeniedTo = true;
            remPassageDeniedToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemPassageDeniedToRaised(value);
            }
        }

        @Override
        public long getRemPassageDeniedToValue() {
            if (!remPassageDeniedTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemPassageDeniedTo is not raised!");
            }
            return remPassageDeniedToValue;
        }

        private boolean sectionLockFromOtherHalfOUT;

        @Override
        public boolean isRaisedSectionLockFromOtherHalfOUT() {
            return sectionLockFromOtherHalfOUT;
        }

        protected void raiseSectionLockFromOtherHalfOUT() {
            sectionLockFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onSectionLockFromOtherHalfOUTRaised();
            }
        }

        private boolean remSectionLockFromOtherHalfOUT;

        @Override
        public boolean isRaisedRemSectionLockFromOtherHalfOUT() {
            return remSectionLockFromOtherHalfOUT;
        }

        protected void raiseRemSectionLockFromOtherHalfOUT() {
            remSectionLockFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemSectionLockFromOtherHalfOUTRaised();
            }
        }

        private boolean passingAllowedFromOtherHalfOUT;

        @Override
        public boolean isRaisedPassingAllowedFromOtherHalfOUT() {
            return passingAllowedFromOtherHalfOUT;
        }

        protected void raisePassingAllowedFromOtherHalfOUT() {
            passingAllowedFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onPassingAllowedFromOtherHalfOUTRaised();
            }
        }

        private boolean passingDeniedFromOtherHalfOUT;

        @Override
        public boolean isRaisedPassingDeniedFromOtherHalfOUT() {
            return passingDeniedFromOtherHalfOUT;
        }

        protected void raisePassingDeniedFromOtherHalfOUT() {
            passingDeniedFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onPassingDeniedFromOtherHalfOUTRaised();
            }
        }

        private boolean remPassingAllowedFromOtherHalfOUT;

        @Override
        public boolean isRaisedRemPassingAllowedFromOtherHalfOUT() {
            return remPassingAllowedFromOtherHalfOUT;
        }

        protected void raiseRemPassingAllowedFromOtherHalfOUT() {
            remPassingAllowedFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemPassingAllowedFromOtherHalfOUTRaised();
            }
        }

        private boolean remPassingDeniedFromOtherHalfOUT;

        @Override
        public boolean isRaisedRemPassingDeniedFromOtherHalfOUT() {
            return remPassingDeniedFromOtherHalfOUT;
        }

        protected void raiseRemPassingDeniedFromOtherHalfOUT() {
            remPassingDeniedFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemPassingDeniedFromOtherHalfOUTRaised();
            }
        }

        private long id;

        @Override
        public long getId() {
            return id;
        }

        @Override
        public void setId(long value) {
            this.id = value;
        }

        private boolean isOccupied;

        @Override
        public boolean getIsOccupied() {
            return isOccupied;
        }

        @Override
        public void setIsOccupied(boolean value) {
            this.isOccupied = value;
        }

        protected void clearEvents() {
            turnoutStraight = false;
            turnoutDivergent = false;
            passingAllowedFrom = false;
            passingDeniedFrom = false;
            remPassageAllowedFrom = false;
            remPassageDeniedFrom = false;
            passingAllowedFromOtherHalfIN = false;
            passingDeniedFromOtherHalfIN = false;
            remPassingAllowedFromOtherHalfIN = false;
            remPassingDeniedFromOtherHalfIN = false;
            sectionLockFrom = false;
            remSectionLockFrom = false;
            remShortSectionLockFrom = false;
            sectionLockFromOtherHalfIN = false;
            remSectionLockFromOtherHalfIN = false;
        }

        protected void clearOutEvents() {
            sectionAllowedTo = false;
            lockRequestTo = false;
            sectionLockedTo = false;
            sectionLockedWithReplyTo = false;
            remPassageRequestTo = false;
            remPassageAllowedTo = false;
            remPassageDeniedTo = false;
            sectionLockFromOtherHalfOUT = false;
            remSectionLockFromOtherHalfOUT = false;
            passingAllowedFromOtherHalfOUT = false;
            passingDeniedFromOtherHalfOUT = false;
            remPassingAllowedFromOtherHalfOUT = false;
            remPassingDeniedFromOtherHalfOUT = false;
        }
    }

    protected SCITurnoutImpl sCITurnout;

    private boolean initialized = false;

    public enum State {

        main_region_CheckDivergentBeforeSwitch, main_region_BecomesDivergent, main_region_CheckStraightBeforeSwitch, main_region_BecomesStraight, main_region_DivergentTurnout, main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock, main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock, main_region_DivergentTurnout_SectionLockFromDivergent_Init, main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout, main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide, main_region_DivergentTurnout_SectionLockFromOtherHalf_Init, main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent, main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout, main_region_DivergentTurnout_RemSectionLockFromDivergent_Init, main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent, main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop, main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init, main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent, main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init, main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent, main_region_StraightTurnout, main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock, main_region_StraightTurnout_HandlerStraight_WithReceivedLock, main_region_StraightTurnout_SectionLockFromStraight_Init, main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout, main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide, main_region_StraightTurnout_SectionLockFromOtherHalf_Init, main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight, main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout, main_region_StraightTurnout_RemSectionLockFromStraight_Init, main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight, main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop, main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init, main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight, main_region_StraightTurnout_RemShortSectionLockFromStraight_Init, main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight, $NullState$
    };

    private final State[] stateVector = new State[6];

    private int nextStateIndex;

    public TurnoutStatemachine() {

        sCISections = new SCISectionsImpl();
        sCITurnout = new SCITurnoutImpl();
    }

    @Override
    public void init() {
        this.initialized = true;
        for (int i = 0; i < 6; i++) {
            stateVector[i] = State.$NullState$;
        }

        clearEvents();
        clearOutEvents();

        sCISections.setSTRAIGHT(0);

        sCISections.setDIVERGENT(1);

        sCISections.setTOP(2);

        sCITurnout.setId(0);

        sCITurnout.setIsOccupied(false);
    }

    @Override
    public void enter() {
        if (!initialized) {
            throw new IllegalStateException(
                    "The statemachine needs to be initialized first by calling the init() function.");
        }

        nextStateIndex = 0;
        stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;

        nextStateIndex = 2;
        stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_Init;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;

        nextStateIndex = 5;
        stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
    }

    @Override
    public void exit() {
        switch (stateVector[0]) {
            case main_region_CheckDivergentBeforeSwitch:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_BecomesDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CheckStraightBeforeSwitch:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_BecomesStraight:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[1]) {
            case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_Init:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[2]) {
            case main_region_DivergentTurnout_SectionLockFromOtherHalf_Init:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromOtherHalf_Init:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[3]) {
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[4]) {
            case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[5]) {
            case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemShortSectionLockFromStraight_Init:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            default:
                break;
        }
    }

    /**
     * @see IStatemachine#isActive()
     */
    @Override
    public boolean isActive() {

        return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$
                || stateVector[2] != State.$NullState$ || stateVector[3] != State.$NullState$
                || stateVector[4] != State.$NullState$ || stateVector[5] != State.$NullState$;
    }

    /**
     * Always returns 'false' since this state machine can never become final.
     *
     * @see IStatemachine#isFinal()
     */
    @Override
    public boolean isFinal() {
        return false;
    }

    /**
     * This method resets the incoming events (time events included).
     */
    protected void clearEvents() {
        sCISections.clearEvents();
        sCITurnout.clearEvents();

    }

    /**
     * This method resets the outgoing events.
     */
    protected void clearOutEvents() {
        sCISections.clearOutEvents();
        sCITurnout.clearOutEvents();
    }

    /**
     * Returns true if the given state is currently active otherwise false.
     */
    public boolean isStateActive(State state) {
        switch (state) {
            case main_region_CheckDivergentBeforeSwitch:
                return stateVector[0] == State.main_region_CheckDivergentBeforeSwitch;
            case main_region_BecomesDivergent:
                return stateVector[0] == State.main_region_BecomesDivergent;
            case main_region_CheckStraightBeforeSwitch:
                return stateVector[0] == State.main_region_CheckStraightBeforeSwitch;
            case main_region_BecomesStraight:
                return stateVector[0] == State.main_region_BecomesStraight;
            case main_region_DivergentTurnout:
                return stateVector[0].ordinal() >= State.main_region_DivergentTurnout.ordinal() && stateVector[0]
                        .ordinal() <= State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent
                        .ordinal();
            case main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock:
                return stateVector[0] == State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;
            case main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock:
                return stateVector[0] == State.main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock;
            case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
            case main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout;
            case main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide;
            case main_region_DivergentTurnout_SectionLockFromOtherHalf_Init:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromOtherHalf_Init;
            case main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent;
            case main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop;
            case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init:
                return stateVector[4] == State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init;
            case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent:
                return stateVector[4] == State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent;
            case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init:
                return stateVector[5] == State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init;
            case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent:
                return stateVector[5] == State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent;
            case main_region_StraightTurnout:
                return stateVector[0].ordinal() >= State.main_region_StraightTurnout.ordinal() && stateVector[0]
                        .ordinal() <= State.main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight
                        .ordinal();
            case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                return stateVector[0] == State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;
            case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                return stateVector[0] == State.main_region_StraightTurnout_HandlerStraight_WithReceivedLock;
            case main_region_StraightTurnout_SectionLockFromStraight_Init:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_Init;
            case main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout;
            case main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide;
            case main_region_StraightTurnout_SectionLockFromOtherHalf_Init:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromOtherHalf_Init;
            case main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight;
            case main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout;
            case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight;
            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop;
            case main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;
            case main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight;
            case main_region_StraightTurnout_RemShortSectionLockFromStraight_Init:
                return stateVector[5] == State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
            case main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight:
                return stateVector[5] == State.main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight;
            default:
                return false;
        }
    }

    @Override
    public SCISections getSCISections() {
        return sCISections;
    }

    @Override
    public SCITurnout getSCITurnout() {
        return sCITurnout;
    }

    /* The reactions of state CheckDivergentBeforeSwitch. */
    private void react_main_region_CheckDivergentBeforeSwitch() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            sCITurnout.raiseRemPassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_BecomesDivergent;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_BecomesDivergent;
            }
        }
    }

    /* The reactions of state BecomesDivergent. */
    private void react_main_region_BecomesDivergent() {
        nextStateIndex = 0;
        stateVector[0] = State.$NullState$;

        sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

        sCISections.raiseRemPassageDeniedToAll();

        nextStateIndex = 0;
        stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;

        nextStateIndex = 2;
        stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromOtherHalf_Init;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init;

        nextStateIndex = 5;
        stateVector[5] = State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init;
    }

    /* The reactions of state CheckStraightBeforeSwitch. */
    private void react_main_region_CheckStraightBeforeSwitch() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            sCITurnout.raiseRemPassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_BecomesStraight;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_BecomesStraight;
            }
        }
    }

    /* The reactions of state BecomesStraight. */
    private void react_main_region_BecomesStraight() {
        nextStateIndex = 0;
        stateVector[0] = State.$NullState$;

        sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

        sCISections.raiseRemPassageDeniedToAll();

        nextStateIndex = 0;
        stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;

        nextStateIndex = 2;
        stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_Init;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;

        nextStateIndex = 5;
        stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
    }

    /* The reactions of state WithoutReceivedLock. */
    private void react_main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_DivergentTurnout_SectionLockFromOtherHalf_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock;
            } else {
                if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);
                    }
                }
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void react_main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_DivergentTurnout_SectionLockFromOtherHalf_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;
            } else {
                if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);
                    }
                }
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent_Init() {
        if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            react_main_region_DivergentTurnout_SectionLockFromDivergent__choice_0();
        }
    }

    /* The reactions of state CheckNeighbourTurnout. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionLockFromOtherHalfOUT();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
            }
        }
    }

    /* The reactions of state CheckOtherSide. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide() {
        if (sCITurnout.passingAllowedFromOtherHalfIN) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
        } else {
            if (sCITurnout.passingDeniedFromOtherHalfIN) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_SectionLockFromOtherHalf_Init() {
        if (sCITurnout.sectionLockFromOtherHalfIN) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent;
        }
    }

    /* The reactions of state CLocalDivergent. */
    private void react_main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent() {
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromOtherHalf_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                react_main_region_DivergentTurnout_SectionLockFromOtherHalf__choice_0();
            }
        }
    }

    /* The reactions of state CNeighbourTurnout. */
    private void react_main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout() {
        if ((sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT)
                || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT)) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromOtherHalf_Init;
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent_Init() {
        if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_0();
        }
    }

    /* The reactions of state CheckLocalDivergent. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_1();
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop() {
        if (sCITurnout.remPassingDeniedFromOtherHalfIN) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            if (sCITurnout.isOccupied) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
            } else {
                if (sCITurnout.remPassingAllowedFromOtherHalfIN) {
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;

                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_2();
                }
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init() {
        if (sCITurnout.remSectionLockFromOtherHalfIN) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf__choice_0();
        }
    }

    /* The reactions of state CheckDivergent. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf__choice_1();
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init() {
        if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent__choice_0();
        }
    }

    /* The reactions of state ShortCheckDivergent. */
    private void react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent__choice_1();
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void react_main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_SectionLockFromStraight_Init:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_StraightTurnout_SectionLockFromOtherHalf_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_StraightTurnout_RemShortSectionLockFromStraight_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithReceivedLock;
            } else {
                if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithReceivedLock;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);
                    }
                }
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void react_main_region_StraightTurnout_HandlerStraight_WithReceivedLock() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_SectionLockFromStraight_Init:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_StraightTurnout_SectionLockFromOtherHalf_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_StraightTurnout_RemShortSectionLockFromStraight_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;
            } else {
                if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);
                    }
                }
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_Init() {
        if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            react_main_region_StraightTurnout_SectionLockFromStraight__choice_0();
        }
    }

    /* The reactions of state CheckNeighbourTurnout. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionLockFromOtherHalfOUT();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
            }
        }
    }

    /* The reactions of state CheckOtherSide. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide() {
        if (sCITurnout.passingAllowedFromOtherHalfIN) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
        } else {
            if (sCITurnout.passingDeniedFromOtherHalfIN) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_SectionLockFromOtherHalf_Init() {
        if (sCITurnout.sectionLockFromOtherHalfIN) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight;
        }
    }

    /* The reactions of state CLocalStraight. */
    private void react_main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight() {
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                react_main_region_StraightTurnout_SectionLockFromOtherHalf__choice_0();
            }
        }
    }

    /* The reactions of state CNeighbourTurnout. */
    private void react_main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout() {
        if ((sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)
                || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_Init;
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight_Init() {
        if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_0();
        }
    }

    /* The reactions of state CheckLocalStraight. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_1();
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop() {
        if (sCITurnout.remPassingDeniedFromOtherHalfIN) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            if (sCITurnout.isOccupied) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
            } else {
                if (sCITurnout.remPassingAllowedFromOtherHalfIN) {
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;

                    react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_2();
                }
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init() {
        if (sCITurnout.remSectionLockFromOtherHalfIN) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromOtherHalf__choice_0();
        }
    }

    /* The reactions of state CheckStraight. */
    private void react_main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromOtherHalf__choice_1();
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_RemShortSectionLockFromStraight_Init() {
        if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            react_main_region_StraightTurnout_RemShortSectionLockFromStraight__choice_0();
        }
    }

    /* The reactions of state ShortCheckStraight. */
    private void react_main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                react_main_region_StraightTurnout_RemShortSectionLockFromStraight__choice_1();
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent__choice_0() {
        if (sCITurnout.id == 135) {
            sCITurnout.raiseSectionLockFromOtherHalfOUT();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_SectionLockFromOtherHalf__choice_0() {
        if (sCITurnout.id == 135) {
            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromOtherHalf_Init;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            sCITurnout.raiseRemSectionLockFromOtherHalfOUT();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init;
        } else {
            sCITurnout.raiseRemPassingAllowedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight__choice_0() {
        if (sCITurnout.id == 134) {
            sCITurnout.raiseSectionLockFromOtherHalfOUT();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_SectionLockFromOtherHalf__choice_0() {
        if (sCITurnout.id == 134) {
            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_Init;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            sCITurnout.raiseRemSectionLockFromOtherHalfOUT();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromOtherHalf__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromOtherHalf__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassingDeniedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;
        } else {
            sCITurnout.raiseRemPassingAllowedFromOtherHalfOUT();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemShortSectionLockFromStraight__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemShortSectionLockFromStraight__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 5;
            stateVector[5] = State.main_region_StraightTurnout_RemShortSectionLockFromStraight_Init;
        }
    }

    @Override
    public void runCycle() {
        if (!initialized) {
            throw new IllegalStateException(
                    "The statemachine needs to be initialized first by calling the init() function.");
        }

        clearOutEvents();

        for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

            switch (stateVector[nextStateIndex]) {
                case main_region_CheckDivergentBeforeSwitch:
                    react_main_region_CheckDivergentBeforeSwitch();
                    break;
                case main_region_BecomesDivergent:
                    react_main_region_BecomesDivergent();
                    break;
                case main_region_CheckStraightBeforeSwitch:
                    react_main_region_CheckStraightBeforeSwitch();
                    break;
                case main_region_BecomesStraight:
                    react_main_region_BecomesStraight();
                    break;
                case main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock:
                    react_main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock();
                    break;
                case main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock:
                    react_main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock();
                    break;
                case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                    react_main_region_DivergentTurnout_SectionLockFromDivergent_Init();
                    break;
                case main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout:
                    react_main_region_DivergentTurnout_SectionLockFromDivergent_CheckNeighbourTurnout();
                    break;
                case main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide:
                    react_main_region_DivergentTurnout_SectionLockFromDivergent_CheckOtherSide();
                    break;
                case main_region_DivergentTurnout_SectionLockFromOtherHalf_Init:
                    react_main_region_DivergentTurnout_SectionLockFromOtherHalf_Init();
                    break;
                case main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent:
                    react_main_region_DivergentTurnout_SectionLockFromOtherHalf_CLocalDivergent();
                    break;
                case main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                    react_main_region_DivergentTurnout_SectionLockFromOtherHalf_CNeighbourTurnout();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_Init();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckLocalDivergent();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init:
                    react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf_Init();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent:
                    react_main_region_DivergentTurnout_RemSectionLockFromOtherHalf_CheckDivergent();
                    break;
                case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init:
                    react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent_Init();
                    break;
                case main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent:
                    react_main_region_DivergentTurnout_RemShortSectionLockFromDivergent_ShortCheckDivergent();
                    break;
                case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                    react_main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock();
                    break;
                case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                    react_main_region_StraightTurnout_HandlerStraight_WithReceivedLock();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_Init:
                    react_main_region_StraightTurnout_SectionLockFromStraight_Init();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout:
                    react_main_region_StraightTurnout_SectionLockFromStraight_CheckNeighbourTurnout();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide:
                    react_main_region_StraightTurnout_SectionLockFromStraight_CheckOtherSide();
                    break;
                case main_region_StraightTurnout_SectionLockFromOtherHalf_Init:
                    react_main_region_StraightTurnout_SectionLockFromOtherHalf_Init();
                    break;
                case main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight:
                    react_main_region_StraightTurnout_SectionLockFromOtherHalf_CLocalStraight();
                    break;
                case main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout:
                    react_main_region_StraightTurnout_SectionLockFromOtherHalf_CNeighbourTurnout();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_Init();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckLocalStraight();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init:
                    react_main_region_StraightTurnout_RemSectionLockFromOtherHalf_Init();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight:
                    react_main_region_StraightTurnout_RemSectionLockFromOtherHalf_CheckStraight();
                    break;
                case main_region_StraightTurnout_RemShortSectionLockFromStraight_Init:
                    react_main_region_StraightTurnout_RemShortSectionLockFromStraight_Init();
                    break;
                case main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight:
                    react_main_region_StraightTurnout_RemShortSectionLockFromStraight_ShortCheckStraight();
                    break;
                default:
                // $NullState$
            }
        }

        clearEvents();
    }
}
