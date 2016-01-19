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

        private List<SCITurnoutListener> listeners = new LinkedList<SCITurnoutListener>();

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
                throw new IllegalStateException(
                        "Illegal event value acces. Event PassingAllowedFrom is not raised!");
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
                throw new IllegalStateException(
                        "Illegal event value acces. Event PassingDeniedFrom is not raised!");
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
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemPassageAllowedFrom is not raised!");
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
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemPassageDeniedFrom is not raised!");
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

        private boolean sectionLockFrom;

        private long sectionLockFromValue;

        @Override
        public void raiseSectionLockFrom(long value) {
            sectionLockFrom = true;
            sectionLockFromValue = value;
        }

        protected long getSectionLockFromValue() {
            if (!sectionLockFrom) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionLockFrom is not raised!");
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
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemSectionLockFrom is not raised!");
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
                throw new IllegalStateException(
                        "Illegal event value acces. Event RemShortSectionLockFrom is not raised!");
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
        }
    }

    protected SCITurnoutImpl sCITurnout;

    private boolean initialized = false;

    public enum State {

        main_region_CheckDivergentBeforeSwitch, main_region_BecomesDivergent, main_region_CheckStraightBeforeSwitch, main_region_BecomesStraight, main_region_DivergentTurnout, main_region_DivergentTurnout_r1_ProtocolDivergent, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent, main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent, main_region_DivergentTurnout_r2_HandlerDivergent, main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock, main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock, main_region_StraightTurnout, main_region_StraightTurnout_r1_ProtocolStraight, main_region_StraightTurnout_r1_ProtocolStraight_r1_Init, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide, main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight, main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop, main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight, main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight, main_region_StraightTurnout_r2_HandlerStraight, main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock, main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock, $NullState$
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

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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
                        .ordinal() <= State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock
                        .ordinal();
            case main_region_DivergentTurnout_r1_ProtocolDivergent:
                return stateVector[0].ordinal() >= State.main_region_DivergentTurnout_r1_ProtocolDivergent.ordinal()
                        && stateVector[0]
                        .ordinal() <= State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent
                        .ordinal();
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
            case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
                return stateVector[0] == State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent;
            case main_region_DivergentTurnout_r2_HandlerDivergent:
                return stateVector[1].ordinal() >= State.main_region_DivergentTurnout_r2_HandlerDivergent.ordinal()
                        && stateVector[1]
                        .ordinal() <= State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock
                        .ordinal();
            case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                return stateVector[1] == State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                return stateVector[1] == State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
            case main_region_StraightTurnout:
                return stateVector[0].ordinal() >= State.main_region_StraightTurnout.ordinal() && stateVector[0]
                        .ordinal() <= State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock
                        .ordinal();
            case main_region_StraightTurnout_r1_ProtocolStraight:
                return stateVector[0].ordinal() >= State.main_region_StraightTurnout_r1_ProtocolStraight.ordinal()
                        && stateVector[0]
                        .ordinal() <= State.main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight
                        .ordinal();
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight;
            case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
                return stateVector[0] == State.main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight;
            case main_region_StraightTurnout_r2_HandlerStraight:
                return stateVector[1].ordinal() >= State.main_region_StraightTurnout_r2_HandlerStraight.ordinal()
                        && stateVector[1]
                        .ordinal() <= State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock
                        .ordinal();
            case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                return stateVector[1] == State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                return stateVector[1] == State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
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

            nextStateIndex = 0;
            stateVector[0] = State.main_region_BecomesDivergent;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

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
        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
    }

    /* The reactions of state CheckStraightBeforeSwitch. */
    private void react_main_region_CheckStraightBeforeSwitch() {
        if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_BecomesStraight;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

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
        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
    }

    /* The reactions of state Init. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_0();
            } else {
                if (sCITurnout.sectionLockFromOtherHalfIN) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent;
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_2();
                    } else {
                        if (sCITurnout.remSectionLockFromOtherHalfIN) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_5();
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_7();
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckNeighbourTurnout. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide;
            } else {
                if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckOtherSide. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.passingAllowedFromOtherHalfIN) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.passingDeniedFromOtherHalfIN) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CLocalDivergent. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_1();
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent;
                            } else {
                                if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseSectionLockedTo(
                                            sCISections.dIVERGENT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CNeighbourTurnout. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if ((sCITurnout.getRemPassageAllowedFromValue() == sCISections.dIVERGENT)
                    || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingAllowedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.remSectionLockFromOtherHalfIN) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout;
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout;
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckLocalDivergent. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent;
                    } else {
                        if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent;
                        } else {
                            if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_3();
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

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
                    } else {
                        if (sCITurnout.passingDeniedFromOtherHalfIN) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                        } else {
                            if (sCITurnout.isOccupied) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
                            } else {
                                if (sCITurnout.passingAllowedFromOtherHalfIN) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_4();
                                }
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

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.dIVERGENT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.dIVERGENT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_6();
                } else {
                    if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(
                                        sCISections.dIVERGENT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                            } else {
                                if (sCITurnout.sectionLockFromOtherHalfIN) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state ShortCheckDivergent. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[0]) {
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            sCITurnout.raiseSectionLockedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckStraightBeforeSwitch;
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

                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_8();
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.dIVERGENT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent;
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.dIVERGENT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(
                                    sCISections.dIVERGENT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent;
                        } else {
                            if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent;
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
        } else {
            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

                nextStateIndex = 1;
                stateVector[1] = State.main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);
                }
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

    /* The reactions of state Init. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_Init() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_0();
            } else {
                if (sCITurnout.sectionLockFromOtherHalfIN) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedWithReplyTo(
                            sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight;
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_2();
                    } else {
                        if (sCITurnout.remSectionLockFromOtherHalfIN) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_5();
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_7();
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckNeighbourTurnout. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionLockFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide;
            } else {
                if (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckOtherSide. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.passingAllowedFromOtherHalfIN) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseSectionAllowedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.passingDeniedFromOtherHalfIN) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CLocalStraight. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_1();
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight;
                            } else {
                                if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raiseSectionLockedTo(
                                            sCISections.sTRAIGHT);

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CNeighbourTurnout. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if ((sCITurnout.getRemPassageAllowedFromValue() == sCISections.sTRAIGHT)
                    || (sCITurnout.getRemPassageDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingAllowedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.remSectionLockFromOtherHalfIN) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout;
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout;
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout;
                        } else {
                            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckLocalStraight. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight;
                } else {
                    if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight;
                    } else {
                        if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight;
                        } else {
                            if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_3();
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

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
            } else {
                if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
                } else {
                    if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
                    } else {
                        if (sCITurnout.passingDeniedFromOtherHalfIN) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                        } else {
                            if (sCITurnout.isOccupied) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseRemPassageDeniedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
                            } else {
                                if (sCITurnout.passingAllowedFromOtherHalfIN) {
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

    /* The reactions of state CheckStraight. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_6();
                } else {
                    if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight;
                    } else {
                        if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseRemPassageDeniedTo(
                                    sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight;
                        } else {
                            if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raiseSectionLockedTo(
                                        sCISections.sTRAIGHT);

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight;
                            } else {
                                if (sCITurnout.sectionLockFromOtherHalfIN) {
                                    nextStateIndex = 0;
                                    stateVector[0] = State.$NullState$;

                                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                                    nextStateIndex = 0;
                                    stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state ShortCheckStraight. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[0]) {
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
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

            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.dIVERGENT);

            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CheckDivergentBeforeSwitch;
        } else {
            if (sCITurnout.isOccupied || (sCITurnout.getPassingDeniedFromValue() == sCISections.sTRAIGHT)) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
            } else {
                if (sCITurnout.getPassingAllowedFromValue() == sCISections.sTRAIGHT) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_8();
                } else {
                    if (sCITurnout.getRemSectionLockFromValue() == sCISections.sTRAIGHT) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight;
                    } else {
                        if (sCITurnout.getSectionLockFromValue() == sCISections.sTRAIGHT) {
                            nextStateIndex = 0;
                            stateVector[0] = State.$NullState$;

                            sCITurnout.raiseSectionLockedTo(sCISections.sTRAIGHT);

                            nextStateIndex = 0;
                            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight;
                        } else {
                            if (sCITurnout.remSectionLockFromOtherHalfIN || sCITurnout.sectionLockFromOtherHalfIN) {
                                nextStateIndex = 0;
                                stateVector[0] = State.$NullState$;

                                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                                nextStateIndex = 0;
                                stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight;
                            }
                        }
                    }
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
            if (sCITurnout.getRemShortSectionLockFromValue() == sCISections.dIVERGENT) {
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

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_0() {
        if (sCITurnout.id == 135) {
            sCITurnout.raiseSectionLockFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_1() {
        if (sCITurnout.id == 135) {
            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout;
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
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_3() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseRemSectionLockFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop;
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
        if (sCITurnout.isOccupied) {
            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_6() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_7() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.dIVERGENT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1__choice_8() {
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
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_0() {
        if (sCITurnout.id == 134) {
            sCITurnout.raiseSectionLockFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_1() {
        if (sCITurnout.id == 134) {
            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseRemPassageRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_2() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseSectionLockedWithReplyTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_3() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseRemSectionLockFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop;
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
        if (sCITurnout.isOccupied) {
            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_6() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_7() {
        if (sCITurnout.isOccupied) {
            sCITurnout.raiseRemPassageDeniedTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_Init;
        } else {
            sCITurnout.raiseLockRequestTo(sCISections.sTRAIGHT);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight;
        }
    }

    /* The reactions of state null. */
    private void react_main_region_StraightTurnout_r1_ProtocolStraight_r1__choice_8() {
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
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_Init();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckNeighbourTurnout();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckOtherSide();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CLocalDivergent();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CNeighbourTurnout();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckLocalDivergent();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckTop();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_CheckDivergent();
                    break;
                case main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent:
                    react_main_region_DivergentTurnout_r1_ProtocolDivergent_r1_ShortCheckDivergent();
                    break;
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    react_main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock();
                    break;
                case main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    react_main_region_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_Init:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_Init();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckNeighbourTurnout();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckOtherSide();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CLocalStraight();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CNeighbourTurnout();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckLocalStraight();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckTop();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_CheckStraight();
                    break;
                case main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight:
                    react_main_region_StraightTurnout_r1_ProtocolStraight_r1_ShortCheckStraight();
                    break;
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    react_main_region_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock();
                    break;
                case main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    react_main_region_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock();
                    break;
                default:
                // $NullState$
            }
        }

        clearEvents();
    }
}
