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

        main_region_StraightTurnout, main_region_StraightTurnout_r1_ProtocolStraight, main_region_StraightTurnout_r1_ProtocolStraight_r1_Init, main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr, main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived, main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop, main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection, main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort, main_region_StraightTurnout_r2_HandlerStraight, main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock, main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock, main_region_DivergentTurnout, main_region_DivergentTurnout_r1_ProtocolDivergent, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection, main_region_DivergentTurnout_r2_HandlerDivergent, main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock, main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock, $NullState$
    };

    private final State[] stateVector = new State[2];

    private int nextStateIndex;

    public TurnoutStatemachine() {

        sCISections = new SCISectionsImpl();
        sCITurnout = new SCITurnoutImpl();
    }

    @Override
    public void init() {
        this.initialized = true;
        for (int i = 0; i < 2; i++) {
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
        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
    }

    @Override
    public void exit() {
        switch (stateVector[0]) {
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[1]) {
            case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
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

        return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
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
                        .ordinal() <= State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock
                        .ordinal();
            case main_region_StraightTurnout_r1_ProtocolStraight:
                return stateVector[0].ordinal() >= State.main_region_StraightTurnout_r1_ProtocolStraight.ordinal()
                        && stateVector[0]
                        .ordinal() <= State.main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort
                        .ordinal();
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort;
            case main_region_StraightTurnout_r2_HandlerStraight:
                return stateVector[1].ordinal() >= State.main_region_StraightTurnout_r2_HandlerStraight.ordinal()
                        && stateVector[1]
                        .ordinal() <= State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock
                        .ordinal();
            case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                return stateVector[1] == State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                return stateVector[1] == State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
            case main_region_DivergentTurnout:
                return stateVector[0].ordinal() >= State.main_region_DivergentTurnout.ordinal() && stateVector[0]
                        .ordinal() <= State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock
                        .ordinal();
            case main_region_DivergentTurnout_r1_ProtocolDivergent:
                return stateVector[0].ordinal() >= State.main_region_DivergentTurnout_r1_ProtocolDivergent.ordinal()
                        && stateVector[0]
                        .ordinal() <= State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection
                        .ordinal();
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection;
            case main_region_DivergentTurnout_r2_HandlerDivergent:
                return stateVector[1].ordinal() >= State.main_region_DivergentTurnout_r2_HandlerDivergent.ordinal()
                        && stateVector[1]
                        .ordinal() <= State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock
                        .ordinal();
            case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                return stateVector[1] == State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                return stateVector[1] == State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
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

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_Init() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_0();
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_1();
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_2();
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_6();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state RespFromTopAndStr. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if ((sCITurnout.getPassingAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived;
            } else {
                if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                } else {
                    if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP
                            || sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr;
                            } else {
                                if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseRemPassageDeniedTo(
                                            sCISections.sTRAIGHT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OnePassageAllowedReceived. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if ((sCITurnout.getPassingAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if ((sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state RespFromStrAndTop. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if ((sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT)
                        || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop;
                            } else {
                                if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP
                                        || sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseSectionLockedTo(
                                            sCISections.tOP);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OnePassAllowedRecvd. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if ((sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if ((sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckDivergent. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)
                    || (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_3();
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent;
                            } else {
                                if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_4();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_4();
                } else {
                    if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_5();
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
                            } else {
                                if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseSectionLockedTo(
                                            sCISections.tOP);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTopSection. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_7();
                } else {
                    if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_8();
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection;
                            } else {
                                if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseRemPassageDeniedTo(
                                            sCISections.sTRAIGHT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection;
                                } else {
                                    if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                                        nextStateIndex = 0;
                                        stateVector[0] = State.$NullState$;

                                        sCITurnout.raiseSectionLockedTo(
                                                sCISections.sTRAIGHT);

                                        sCITurnout.raiseRemPassageDeniedTo(
                                                sCISections.tOP);

                                        nextStateIndex = 0;
                                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckStraightSection. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if ((sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT)
                        || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_8();
                } else {
                    if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_9();
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection;
                            } else {
                                if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseRemPassageDeniedTo(
                                            sCISections.sTRAIGHT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state SendBackShort. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_0();
        } else {
            if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void react_main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock() {
        if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
        } else {
            if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void react_main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);
                }
            }
        }
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_0();
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_1();
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_2();
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_6();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state RespFromTopAndDiv. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if ((sCITurnout.getPassingAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived;
            } else {
                if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                } else {
                    if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP
                            || sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv;
                            } else {
                                if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseRemPassageDeniedTo(
                                            sCISections.dIVERGENT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OnePassageAllowedReceived. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if ((sCITurnout.getPassingAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if ((sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state RespFromDivAndTop. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if ((sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT)
                        || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop;
                            } else {
                                if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP
                                        || sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseSectionLockedTo(
                                            sCISections.tOP);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OnePassAllowedRecvd. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if ((sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP)
                    || (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if ((sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)
                        || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT)) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckDivergent. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_3();
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.tOP)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_4();
                } else {
                    if (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_5();
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
                        } else {
                            if (sCITurnout.getRemSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
                            } else {
                                if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseSectionLockedTo(
                                            sCISections.tOP);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTopSection. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.tOP)
                    || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.tOP) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_7();
                } else {
                    if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_8();
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection;
                            } else {
                                if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseRemPassageDeniedTo(
                                            sCISections.dIVERGENT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckDivergentSection. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[1]) {
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            sCISections.raiseRemPassageDeniedToAll();

            react_main_region__choice_1();
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_8();
                } else {
                    if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_9();
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.tOP) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(sCISections.tOP);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection;
                            } else {
                                if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseRemPassageDeniedTo(
                                            sCISections.dIVERGENT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void react_main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock() {
        if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            react_main_region_DivergentTurnout_r2_HandlerDivergent_r1__choice_0();
        } else {
            if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void react_main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_0() {
        if (sCITurnout.id != 129 && sCITurnout.topExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr;
        } else {
            if (sCITurnout.id != 129 && !sCITurnout.topExists) {
                sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

                sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr;
            } else {
                if (sCITurnout.id == 129) {
                    sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_1() {
        if (sCITurnout.straightExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            if (!sCITurnout.isOccupied && sCITurnout.straightExists) {
                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.straightExists) {
                    sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_3() {
        if (!sCITurnout.isOccupied && sCITurnout.topExists) {
            sCITurnout.raiseLockRequestTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
        } else {
            if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                sCITurnout.raiseRemShortPassageRequestTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
            } else {
                if (sCITurnout.isOccupied) {
                    sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_4() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_5() {
        if (!(!sCITurnout.remStraightIsPrior || sCITurnout.isOccupied)) {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            if (!sCITurnout.remStraightIsPrior || sCITurnout.isOccupied) {
                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_6() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            if (!sCITurnout.isOccupied && sCITurnout.topExists) {
                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_7() {
        if (!sCITurnout.isOccupied && sCITurnout.straightExists) {
            sCITurnout.raiseLockRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection;
        } else {
            if (sCITurnout.isOccupied) {
                sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.straightExists) {
                    sCITurnout.raiseRemShortPassageRequestTo(
                            sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_8() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_9() {
        if (!sCITurnout.remTopIsPrior || sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            if (!(!sCITurnout.remTopIsPrior || sCITurnout.isOccupied)) {
                sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

                sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_0() {
        if (sCITurnout.topExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_1() {
        if (sCITurnout.divergentExists) {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            sCITurnout.raiseRemPassageRequestTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_3() {
        if (!sCITurnout.isOccupied && sCITurnout.topExists) {
            sCITurnout.raiseLockRequestTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
        } else {
            if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                sCITurnout.raiseRemShortPassageRequestTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
            } else {
                if (sCITurnout.isOccupied) {
                    sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_4() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_5() {
        if (!(!sCITurnout.remDivergentIsPrior || sCITurnout.isOccupied)) {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            if (!sCITurnout.remDivergentIsPrior || sCITurnout.isOccupied) {
                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_6() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            if (!sCITurnout.isOccupied && sCITurnout.topExists) {
                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.tOP);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection;
            } else {
                if (!sCITurnout.isOccupied && !sCITurnout.topExists) {
                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection;
                }
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_7() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_8() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_9() {
        if (!sCITurnout.remTopIsPrior || sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            if (!(!sCITurnout.remTopIsPrior || sCITurnout.isOccupied)) {
                sCITurnout.raiseRemPassageAllowedTo(sCISections.tOP);

                sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            }
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r2_HandlerDivergent_r1__choice_0() {
        if (sCITurnout.id == 130) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
        } else {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
        }
    }

    /* The reactions of state null. */
    private void react_main_region__choice_0() {
        if (sCITurnout.id == 130) {
            sCITurnout.raiseSectionLockedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
        } else {
            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
        }
    }

    /* The reactions of state null. */
    private void react_main_region__choice_1() {
        if (sCITurnout.id == 130) {
            sCITurnout.raiseSectionAllowedTo(sCISections.tOP);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
        } else {
            sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;

            nextStateIndex = 1;
            stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
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
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_Init();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromTopAndStr();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassageAllowedReceived();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_RespFromStrAndTop();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_OnePassAllowedRecvd();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckDivergent();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTopSection();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraightSection();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_SendBackShort();
                    break;
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    react_main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock();
                    break;
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    react_main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromTopAndDiv();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassageAllowedReceived();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_RespFromDivAndTop();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_OnePassAllowedRecvd();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTopSection();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergentSection();
                    break;
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    react_main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock();
                    break;
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    react_main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock();
                    break;
                default:
                // $NullState$
            }
        }

        clearEvents();
    }
}
