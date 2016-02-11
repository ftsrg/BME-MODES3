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

        private boolean remShortPassageRequestTo;

        private long remShortPassageRequestToValue;

        @Override
        public boolean isRaisedRemShortPassageRequestTo() {
            return remShortPassageRequestTo;
        }

        protected void raiseRemShortPassageRequestTo(long value) {
            remShortPassageRequestTo = true;
            remShortPassageRequestToValue = value;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemShortPassageRequestToRaised(value);
            }
        }

        @Override
        public long getRemShortPassageRequestToValue() {
            if (!remShortPassageRequestTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemShortPassageRequestTo is not raised!");
            }
            return remShortPassageRequestToValue;
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

        private boolean topExists;

        @Override
        public boolean getTopExists() {
            return topExists;
        }

        @Override
        public void setTopExists(boolean value) {
            this.topExists = value;
        }

        private boolean divergentExists;

        @Override
        public boolean getDivergentExists() {
            return divergentExists;
        }

        @Override
        public void setDivergentExists(boolean value) {
            this.divergentExists = value;
        }

        private boolean straightExists;

        @Override
        public boolean getStraightExists() {
            return straightExists;
        }

        @Override
        public void setStraightExists(boolean value) {
            this.straightExists = value;
        }

        private boolean remDivergentIsPrior;

        @Override
        public boolean getRemDivergentIsPrior() {
            return remDivergentIsPrior;
        }

        @Override
        public void setRemDivergentIsPrior(boolean value) {
            this.remDivergentIsPrior = value;
        }

        private boolean remStraightIsPrior;

        @Override
        public boolean getRemStraightIsPrior() {
            return remStraightIsPrior;
        }

        @Override
        public void setRemStraightIsPrior(boolean value) {
            this.remStraightIsPrior = value;
        }

        private boolean remTopIsPrior;

        @Override
        public boolean getRemTopIsPrior() {
            return remTopIsPrior;
        }

        @Override
        public void setRemTopIsPrior(boolean value) {
            this.remTopIsPrior = value;
        }

        protected void clearEvents() {
            turnoutStraight = false;
            turnoutDivergent = false;
            passingAllowedFrom = false;
            passingDeniedFrom = false;
            remPassageAllowedFrom = false;
            remPassageDeniedFrom = false;
            sectionLockFrom = false;
            remSectionLockFrom = false;
        }

        protected void clearOutEvents() {
            sectionAllowedTo = false;
            sectionLockedTo = false;
            sectionLockedWithReplyTo = false;
            lockRequestTo = false;
            remShortPassageRequestTo = false;
            remPassageAllowedTo = false;
            remPassageDeniedTo = false;
            remPassageRequestTo = false;
        }
    }

    protected SCITurnoutImpl sCITurnout;

    private boolean initialized = false;

    public enum State {

        main_region_StraightTurnout, main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock, main_region_StraightTurnout_HandlerStraight_WithReceivedLock, main_region_StraightTurnout_SectionLockFromStraight_Init, main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop, main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr, main_region_StraightTurnout_SectionLockFromStraight_SendBackShort, main_region_StraightTurnout_SectionLockFromStraight_RespFromTop, main_region_StraightTurnout_SectionLockFromTop_Init, main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr, main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop, main_region_StraightTurnout_SectionLockFromTop_RespFromStr, main_region_StraightTurnout_RemSectionLockFromStraight_Init, main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight, main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop, main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection, main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop, main_region_StraightTurnout_RemSectionLockFromTop_Init, main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection, main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection, main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight, main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight, main_region_DivergentTurnout, main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock, main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock, main_region_DivergentTurnout_SectionLockFromDivergent_Init, main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop, main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv, main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop, main_region_DivergentTurnout_SectionLockFromTop_Init, main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent, main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop, main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent, main_region_DivergentTurnout_RemSectionLockFromDivergent_Init, main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent, main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop, main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop, main_region_DivergentTurnout_RemSectionLockFromTop_Init, main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection, main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection, main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent, $NullState$
    };

    private final State[] stateVector = new State[5];

    private int nextStateIndex;

    public TurnoutStatemachine() {

        sCISections = new SCISectionsImpl();
        sCITurnout = new SCITurnoutImpl();
    }

    @Override
    public void init() {
        this.initialized = true;
        for (int i = 0; i < 5; i++) {
            stateVector[i] = State.$NullState$;
        }

        clearEvents();
        clearOutEvents();

        sCISections.setSTRAIGHT(0);

        sCISections.setDIVERGENT(1);

        sCISections.setTOP(2);

        sCITurnout.setId(0);

        sCITurnout.setIsOccupied(false);

        sCITurnout.setTopExists(false);

        sCITurnout.setDivergentExists(false);

        sCITurnout.setStraightExists(false);

        sCITurnout.setRemDivergentIsPrior(false);

        sCITurnout.setRemStraightIsPrior(false);

        sCITurnout.setRemTopIsPrior(false);
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
        stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
    }

    @Override
    public void exit() {
        switch (stateVector[0]) {
            case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
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

            default:
                break;
        }

        switch (stateVector[1]) {
            case main_region_StraightTurnout_SectionLockFromStraight_Init:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_SendBackShort:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromStraight_RespFromTop:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[2]) {
            case main_region_StraightTurnout_SectionLockFromTop_Init:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_StraightTurnout_SectionLockFromTop_RespFromStr:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromTop_Init:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent:
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

            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[4]) {
            case main_region_StraightTurnout_RemSectionLockFromTop_Init:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromTop_Init:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
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
                || stateVector[4] != State.$NullState$;
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
            case main_region_StraightTurnout:
                return stateVector[0].ordinal() >= State.main_region_StraightTurnout.ordinal() && stateVector[0]
                        .ordinal() <= State.main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight
                        .ordinal();
            case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                return stateVector[0] == State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;
            case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                return stateVector[0] == State.main_region_StraightTurnout_HandlerStraight_WithReceivedLock;
            case main_region_StraightTurnout_SectionLockFromStraight_Init:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_Init;
            case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop;
            case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr;
            case main_region_StraightTurnout_SectionLockFromStraight_SendBackShort:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_SendBackShort;
            case main_region_StraightTurnout_SectionLockFromStraight_RespFromTop:
                return stateVector[1] == State.main_region_StraightTurnout_SectionLockFromStraight_RespFromTop;
            case main_region_StraightTurnout_SectionLockFromTop_Init:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromTop_Init;
            case main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr;
            case main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop;
            case main_region_StraightTurnout_SectionLockFromTop_RespFromStr:
                return stateVector[2] == State.main_region_StraightTurnout_SectionLockFromTop_RespFromStr;
            case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight;
            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop;
            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection;
            case main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop:
                return stateVector[3] == State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop;
            case main_region_StraightTurnout_RemSectionLockFromTop_Init:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
            case main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection;
            case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection;
            case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight;
            case main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight:
                return stateVector[4] == State.main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight;
            case main_region_DivergentTurnout:
                return stateVector[0].ordinal() >= State.main_region_DivergentTurnout.ordinal() && stateVector[0]
                        .ordinal() <= State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent.ordinal();
            case main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock:
                return stateVector[0] == State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;
            case main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock:
                return stateVector[0] == State.main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock;
            case main_region_DivergentTurnout_SectionLockFromDivergent_Init:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
            case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop;
            case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv;
            case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop:
                return stateVector[1] == State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop;
            case main_region_DivergentTurnout_SectionLockFromTop_Init:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromTop_Init;
            case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent;
            case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop;
            case main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent:
                return stateVector[2] == State.main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop;
            case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop:
                return stateVector[3] == State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop;
            case main_region_DivergentTurnout_RemSectionLockFromTop_Init:
                return stateVector[4] == State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
            case main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection:
                return stateVector[4] == State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection;
            case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection:
                return stateVector[4] == State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection;
            case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent:
                return stateVector[4] == State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent;
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

                case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_SendBackShort:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_RespFromTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_StraightTurnout_SectionLockFromTop_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromTop_RespFromStr:
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

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_StraightTurnout_RemSectionLockFromTop_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_Init;

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithReceivedLock;
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);
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

                case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_SendBackShort:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromStraight_RespFromTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_StraightTurnout_SectionLockFromTop_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_SectionLockFromTop_RespFromStr:
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

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_StraightTurnout_RemSectionLockFromTop_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_Init;

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
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

    /* The reactions of state RespFromRemTop. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
            }
        }
    }

    /* The reactions of state RespFromRemStr. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
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

    /* The reactions of state SendBackShort. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_SendBackShort() {
        if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
        } else {
            if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
            }
        }
    }

    /* The reactions of state RespFromTop. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight_RespFromTop() {
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr;
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_SectionLockFromTop_Init() {
        if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            react_main_region_StraightTurnout_SectionLockFromTop__choice_0();
        }
    }

    /* The reactions of state RespFromRemStr. */
    private void react_main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 2;
                stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;
            }
        }
    }

    /* The reactions of state RespFromRemTop. */
    private void react_main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseSectionAllowedTo(sCISections.tOP);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 2;
                stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;
            }
        }
    }

    /* The reactions of state RespFromStr. */
    private void react_main_region_StraightTurnout_SectionLockFromTop_RespFromStr() {
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

                nextStateIndex = 2;
                stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop;
            }
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

    /* The reactions of state CheckStraight. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight() {
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
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_3();
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_2();
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
                }
            }
        }
    }

    /* The reactions of state CheckTopSection. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection() {
        if (sCITurnout.isOccupied || sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_2();
            }
        }
    }

    /* The reactions of state CheckRemTop. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_2();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop_Init() {
        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromTop__choice_0();
        }
    }

    /* The reactions of state CheckTopSection. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromTop__choice_1();
            }
        }
    }

    /* The reactions of state CheckStraightSection. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromTop__choice_2();
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromTop__choice_3();
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
                }
            }
        }
    }

    /* The reactions of state CheckStraight. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight() {
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_StraightTurnout_RemSectionLockFromTop__choice_2();
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
                }
            }
        }
    }

    /* The reactions of state CheckRemStraight. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_StraightTurnout_RemSectionLockFromTop__choice_2();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 4;
                stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
            }
        }
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

                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_DivergentTurnout_SectionLockFromTop_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent:
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

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_DivergentTurnout_RemSectionLockFromTop_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        } else {
            if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                react_main_region_DivergentTurnout_HandlerDivergent__choice_0();
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);
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

                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[2]) {
                case main_region_DivergentTurnout_SectionLockFromTop_Init:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent:
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

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_DivergentTurnout_RemSectionLockFromTop_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_Init;

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_Init;

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
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

    /* The reactions of state RespFromRemTop. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
            }
        }
    }

    /* The reactions of state RespFromRemDiv. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
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

    /* The reactions of state RespFromTop. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_Init;
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_SectionLockFromTop_Init() {
        if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            react_main_region_DivergentTurnout_SectionLockFromTop__choice_0();
        }
    }

    /* The reactions of state RespFromRemDivergent. */
    private void react_main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 2;
                stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_Init;
            }
        }
    }

    /* The reactions of state RespFromRemTop. */
    private void react_main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop() {
        if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseSectionAllowedTo(sCISections.tOP);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_Init;
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 2;
                stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_Init;
            }
        }
    }

    /* The reactions of state RespFromDivergent. */
    private void react_main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 2;
                stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_Init;
            }
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

    /* The reactions of state CheckDivergent. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent() {
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
        if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_3();
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_2();
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
                }
            }
        }
    }

    /* The reactions of state CheckRemTop. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop() {
        if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_2();
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop_Init() {
        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_0();
        }
    }

    /* The reactions of state CheckTopSection. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection() {
        if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_1();
            }
        }
    }

    /* The reactions of state CheckDivergenSection. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_2();
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_3();
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
                }
            }
        }
    }

    /* The reactions of state CheckDivergent. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent() {
        if (sCITurnout.isOccupied || sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_2();
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_SectionLockFromStraight__choice_0() {
        if (sCITurnout.id != 129 && sCITurnout.topExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_RespFromTop;
        } else {
            if (sCITurnout.id != 129 && !sCITurnout.topExists) {
                sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop;
            } else {
                sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_SectionLockFromStraight_SendBackShort;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_SectionLockFromTop__choice_0() {
        if (sCITurnout.straightExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_RespFromStr;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            if (!sCITurnout.isOccupied && sCITurnout.straightExists) {
                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.straightExists) {
                    sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_1() {
        if (!sCITurnout.isOccupied && sCITurnout.topExists) {
            sCITurnout.raiseLockRequestTo(sCISections.tOP);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop;
        } else {
            if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                sCITurnout.raiseRemShortPassageRequestTo(sCISections.tOP);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop;
            } else {
                if (sCITurnout.isOccupied) {
                    sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
                }
            }
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
    private void react_main_region_StraightTurnout_RemSectionLockFromStraight__choice_3() {
        if (!(!sCITurnout.remStraightIsPrior || sCITurnout.isOccupied)) {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
        } else {
            if (!sCITurnout.remStraightIsPrior || sCITurnout.isOccupied) {
                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_StraightTurnout_RemSectionLockFromStraight_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        } else {
            if (!sCITurnout.isOccupied && sCITurnout.topExists) {
                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

                nextStateIndex = 4;
                stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.sTRAIGHT);

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop__choice_1() {
        if (!sCITurnout.isOccupied && sCITurnout.straightExists) {
            sCITurnout.raiseLockRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection;
        } else {
            if (sCITurnout.isOccupied) {
                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 4;
                stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.straightExists) {
                    sCITurnout.raiseRemShortPassageRequestTo(
                            sCISections.sTRAIGHT);

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_RemSectionLockFromTop__choice_3() {
        if (!sCITurnout.remTopIsPrior || sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
        } else {
            if (!(!sCITurnout.remTopIsPrior || sCITurnout.isOccupied)) {
                sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 4;
                stateVector[4] = State.main_region_StraightTurnout_RemSectionLockFromTop_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_HandlerDivergent__choice_0() {
        if (sCITurnout.id == 130) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithoutReceivedLock;
        } else {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_HandlerDivergent_WithReceivedLock;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_SectionLockFromDivergent__choice_0() {
        if (sCITurnout.topExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_SectionLockFromTop__choice_0() {
        if (sCITurnout.divergentExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent;
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
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_1() {
        if (!sCITurnout.isOccupied && sCITurnout.topExists) {
            sCITurnout.raiseLockRequestTo(sCISections.tOP);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop;
        } else {
            if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                sCITurnout.raiseRemShortPassageRequestTo(sCISections.tOP);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop;
            } else {
                if (sCITurnout.isOccupied) {
                    sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
                }
            }
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
    private void react_main_region_DivergentTurnout_RemSectionLockFromDivergent__choice_3() {
        if (!(!sCITurnout.remDivergentIsPrior || sCITurnout.isOccupied)) {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

            nextStateIndex = 3;
            stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
        } else {
            if (!sCITurnout.remDivergentIsPrior || sCITurnout.isOccupied) {
                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 3;
                stateVector[3] = State.main_region_DivergentTurnout_RemSectionLockFromDivergent_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_0() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            if (!sCITurnout.isOccupied && sCITurnout.topExists) {
                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

                nextStateIndex = 4;
                stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.dIVERGENT);

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_1() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_RemSectionLockFromTop__choice_3() {
        if (!sCITurnout.remTopIsPrior || sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 4;
            stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
        } else {
            if (!(!sCITurnout.remTopIsPrior || sCITurnout.isOccupied)) {
                sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 4;
                stateVector[4] = State.main_region_DivergentTurnout_RemSectionLockFromTop_Init;
            }
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
                case main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock:
                    react_main_region_StraightTurnout_HandlerStraight_WithoutReceivedLock();
                    break;
                case main_region_StraightTurnout_HandlerStraight_WithReceivedLock:
                    react_main_region_StraightTurnout_HandlerStraight_WithReceivedLock();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_Init:
                    react_main_region_StraightTurnout_SectionLockFromStraight_Init();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop:
                    react_main_region_StraightTurnout_SectionLockFromStraight_RespFromRemTop();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr:
                    react_main_region_StraightTurnout_SectionLockFromStraight_RespFromRemStr();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_SendBackShort:
                    react_main_region_StraightTurnout_SectionLockFromStraight_SendBackShort();
                    break;
                case main_region_StraightTurnout_SectionLockFromStraight_RespFromTop:
                    react_main_region_StraightTurnout_SectionLockFromStraight_RespFromTop();
                    break;
                case main_region_StraightTurnout_SectionLockFromTop_Init:
                    react_main_region_StraightTurnout_SectionLockFromTop_Init();
                    break;
                case main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr:
                    react_main_region_StraightTurnout_SectionLockFromTop_RespFromRemStr();
                    break;
                case main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop:
                    react_main_region_StraightTurnout_SectionLockFromTop_RespFromRemTop();
                    break;
                case main_region_StraightTurnout_SectionLockFromTop_RespFromStr:
                    react_main_region_StraightTurnout_SectionLockFromTop_RespFromStr();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_Init:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_Init();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckStraight();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckTop();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckTopSection();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop:
                    react_main_region_StraightTurnout_RemSectionLockFromStraight_CheckRemTop();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromTop_Init:
                    react_main_region_StraightTurnout_RemSectionLockFromTop_Init();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection:
                    react_main_region_StraightTurnout_RemSectionLockFromTop_CheckTopSection();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection:
                    react_main_region_StraightTurnout_RemSectionLockFromTop_CheckStraightSection();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight:
                    react_main_region_StraightTurnout_RemSectionLockFromTop_CheckStraight();
                    break;
                case main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight:
                    react_main_region_StraightTurnout_RemSectionLockFromTop_CheckRemStraight();
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
                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop:
                    react_main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemTop();
                    break;
                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv:
                    react_main_region_DivergentTurnout_SectionLockFromDivergent_RespFromRemDiv();
                    break;
                case main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop:
                    react_main_region_DivergentTurnout_SectionLockFromDivergent_RespFromTop();
                    break;
                case main_region_DivergentTurnout_SectionLockFromTop_Init:
                    react_main_region_DivergentTurnout_SectionLockFromTop_Init();
                    break;
                case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent:
                    react_main_region_DivergentTurnout_SectionLockFromTop_RespFromRemDivergent();
                    break;
                case main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop:
                    react_main_region_DivergentTurnout_SectionLockFromTop_RespFromRemTop();
                    break;
                case main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent:
                    react_main_region_DivergentTurnout_SectionLockFromTop_RespFromDivergent();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_Init:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_Init();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckDivergent();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckTop();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop:
                    react_main_region_DivergentTurnout_RemSectionLockFromDivergent_CheckRemTop();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromTop_Init:
                    react_main_region_DivergentTurnout_RemSectionLockFromTop_Init();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection:
                    react_main_region_DivergentTurnout_RemSectionLockFromTop_CheckTopSection();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection:
                    react_main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergenSection();
                    break;
                case main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent:
                    react_main_region_DivergentTurnout_RemSectionLockFromTop_CheckDivergent();
                    break;
                default:
                // $NullState$
            }
        }

        clearEvents();
    }
}
