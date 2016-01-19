package org.yakindu.scr.section;

import java.util.LinkedList;
import java.util.List;

public class SectionStatemachine implements ISectionStatemachine {

    protected class SCISectionImpl implements SCISection {

        private final List<SCISectionListener> listeners = new LinkedList<>();

        @Override
        public List<SCISectionListener> getListeners() {
            return listeners;
        }

        private boolean revokeLock;

        @Override
        public void raiseRevokeLock() {
            revokeLock = true;
        }

        private boolean lockRequestTo;

        private long lockRequestToValue;

        @Override
        public void raiseLockRequestTo(long value) {
            lockRequestTo = true;
            lockRequestToValue = value;
        }

        protected long getLockRequestToValue() {
            if (!lockRequestTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event LockRequestTo is not raised!");
            }
            return lockRequestToValue;
        }

        private boolean sectionLockedWithReplyTo;

        private long sectionLockedWithReplyToValue;

        @Override
        public void raiseSectionLockedWithReplyTo(long value) {
            sectionLockedWithReplyTo = true;
            sectionLockedWithReplyToValue = value;
        }

        protected long getSectionLockedWithReplyToValue() {
            if (!sectionLockedWithReplyTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionLockedWithReplyTo is not raised!");
            }
            return sectionLockedWithReplyToValue;
        }

        private boolean sectionLockedTo;

        private long sectionLockedToValue;

        @Override
        public void raiseSectionLockedTo(long value) {
            sectionLockedTo = true;
            sectionLockedToValue = value;
        }

        protected long getSectionLockedToValue() {
            if (!sectionLockedTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionLockedTo is not raised!");
            }
            return sectionLockedToValue;
        }

        private boolean sectionAllowedTo;

        private long sectionAllowedToValue;

        @Override
        public void raiseSectionAllowedTo(long value) {
            sectionAllowedTo = true;
            sectionAllowedToValue = value;
        }

        protected long getSectionAllowedToValue() {
            if (!sectionAllowedTo) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionAllowedTo is not raised!");
            }
            return sectionAllowedToValue;
        }

        private boolean sectionOccupied;

        @Override
        public void raiseSectionOccupied() {
            sectionOccupied = true;
        }

        private boolean sectionFree;

        @Override
        public void raiseSectionFree() {
            sectionFree = true;
        }

        private boolean enableSection;

        private long enableSectionValue;

        @Override
        public boolean isRaisedEnableSection() {
            return enableSection;
        }

        protected void raiseEnableSection(long value) {
            enableSection = true;
            enableSectionValue = value;
            for (SCISectionListener listener : listeners) {
                listener.onEnableSectionRaised(value);
            }
        }

        @Override
        public long getEnableSectionValue() {
            if (!enableSection) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event EnableSection is not raised!");
            }
            return enableSectionValue;
        }

        private boolean disableSection;

        private long disableSectionValue;

        @Override
        public boolean isRaisedDisableSection() {
            return disableSection;
        }

        protected void raiseDisableSection(long value) {
            disableSection = true;
            disableSectionValue = value;
            for (SCISectionListener listener : listeners) {
                listener.onDisableSectionRaised(value);
            }
        }

        @Override
        public long getDisableSectionValue() {
            if (!disableSection) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event DisableSection is not raised!");
            }
            return disableSectionValue;
        }

        private boolean passingAllowedFrom;

        private long passingAllowedFromValue;

        @Override
        public boolean isRaisedPassingAllowedFrom() {
            return passingAllowedFrom;
        }

        protected void raisePassingAllowedFrom(long value) {
            passingAllowedFrom = true;
            passingAllowedFromValue = value;
            for (SCISectionListener listener : listeners) {
                listener.onPassingAllowedFromRaised(value);
            }
        }

        @Override
        public long getPassingAllowedFromValue() {
            if (!passingAllowedFrom) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event PassingAllowedFrom is not raised!");
            }
            return passingAllowedFromValue;
        }

        private boolean passingDeniedFrom;

        private long passingDeniedFromValue;

        @Override
        public boolean isRaisedPassingDeniedFrom() {
            return passingDeniedFrom;
        }

        protected void raisePassingDeniedFrom(long value) {
            passingDeniedFrom = true;
            passingDeniedFromValue = value;
            for (SCISectionListener listener : listeners) {
                listener.onPassingDeniedFromRaised(value);
            }
        }

        @Override
        public long getPassingDeniedFromValue() {
            if (!passingDeniedFrom) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event PassingDeniedFrom is not raised!");
            }
            return passingDeniedFromValue;
        }

        private boolean sectionLockFrom;

        private long sectionLockFromValue;

        @Override
        public boolean isRaisedSectionLockFrom() {
            return sectionLockFrom;
        }

        protected void raiseSectionLockFrom(long value) {
            sectionLockFrom = true;
            sectionLockFromValue = value;
            for (SCISectionListener listener : listeners) {
                listener.onSectionLockFromRaised(value);
            }
        }

        @Override
        public long getSectionLockFromValue() {
            if (!sectionLockFrom) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event SectionLockFrom is not raised!");
            }
            return sectionLockFromValue;
        }

        private long sTRAIGHT;

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

        private long id;

        @Override
        public long getId() {
            return id;
        }

        @Override
        public void setId(long value) {
            this.id = value;
        }

        private long direction;

        @Override
        public long getDirection() {
            return direction;
        }

        @Override
        public void setDirection(long value) {
            this.direction = value;
        }

        protected void clearEvents() {
            revokeLock = false;
            lockRequestTo = false;
            sectionLockedWithReplyTo = false;
            sectionLockedTo = false;
            sectionAllowedTo = false;
            sectionOccupied = false;
            sectionFree = false;
        }

        protected void clearOutEvents() {
            enableSection = false;
            disableSection = false;
            passingAllowedFrom = false;
            passingDeniedFrom = false;
            sectionLockFrom = false;
        }
    }

    protected SCISectionImpl sCISection;

    private boolean initialized = false;

    public enum State {

        main_region_FreeSection, main_region_FreeSection_r1_EnableSection, main_region_OccupiedSection, main_region_OccupiedSection_r1_SendSectionLock, main_region_OccupiedSection_r1_EnableSection, main_region_OccupiedSection_r1_BecomesLocked, $NullState$
    };

    private final State[] stateVector = new State[1];

    private int nextStateIndex;

    public SectionStatemachine() {

        sCISection = new SCISectionImpl();
    }

    @Override
    public void init() {
        this.initialized = true;
        for (int i = 0; i < 1; i++) {
            stateVector[i] = State.$NullState$;
        }

        clearEvents();
        clearOutEvents();

        sCISection.setSTRAIGHT(0);

        sCISection.setDIVERGENT(1);

        sCISection.setTOP(2);

        sCISection.setId(0);

        sCISection.setDirection(0);
    }

    @Override
    public void enter() {
        if (!initialized) {
            throw new IllegalStateException(
                    "The statemachine needs to be initialized first by calling the init() function.");
        }

        nextStateIndex = 0;
        stateVector[0] = State.main_region_FreeSection_r1_EnableSection;
    }

    @Override
    public void exit() {
        switch (stateVector[0]) {
            case main_region_FreeSection_r1_EnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_OccupiedSection_r1_SendSectionLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_OccupiedSection_r1_EnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_OccupiedSection_r1_BecomesLocked:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
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

        return stateVector[0] != State.$NullState$;
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
        sCISection.clearEvents();

    }

    /**
     * This method resets the outgoing events.
     */
    protected void clearOutEvents() {
        sCISection.clearOutEvents();
    }

    /**
     * Returns true if the given state is currently active otherwise false.
     */
    public boolean isStateActive(State state) {
        switch (state) {
            case main_region_FreeSection:
                return stateVector[0].ordinal() >= State.main_region_FreeSection.ordinal()
                        && stateVector[0].ordinal() <= State.main_region_FreeSection_r1_EnableSection.ordinal();
            case main_region_FreeSection_r1_EnableSection:
                return stateVector[0] == State.main_region_FreeSection_r1_EnableSection;
            case main_region_OccupiedSection:
                return stateVector[0].ordinal() >= State.main_region_OccupiedSection.ordinal()
                        && stateVector[0].ordinal() <= State.main_region_OccupiedSection_r1_BecomesLocked.ordinal();
            case main_region_OccupiedSection_r1_SendSectionLock:
                return stateVector[0] == State.main_region_OccupiedSection_r1_SendSectionLock;
            case main_region_OccupiedSection_r1_EnableSection:
                return stateVector[0] == State.main_region_OccupiedSection_r1_EnableSection;
            case main_region_OccupiedSection_r1_BecomesLocked:
                return stateVector[0] == State.main_region_OccupiedSection_r1_BecomesLocked;
            default:
                return false;
        }
    }

    @Override
    public SCISection getSCISection() {
        return sCISection;
    }

    /* The reactions of state EnableSection. */
    private void react_main_region_FreeSection_r1_EnableSection() {
        if (sCISection.sectionOccupied) {
            switch (stateVector[0]) {
                case main_region_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCISection.raisePassingDeniedFrom(sCISection.direction);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_OccupiedSection_r1_SendSectionLock;
        } else {
            if (sCISection.getSectionLockedWithReplyToValue() == sCISection.direction) {
                sCISection.raisePassingAllowedFrom(sCISection.direction);
            }

            if (sCISection.getLockRequestToValue() == sCISection.direction) {
                sCISection.raisePassingAllowedFrom(sCISection.direction);
            }
        }
    }

    /* The reactions of state SendSectionLock. */
    private void react_main_region_OccupiedSection_r1_SendSectionLock() {
        if (sCISection.sectionFree) {
            switch (stateVector[0]) {
                case main_region_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCISection.raisePassingAllowedFrom(sCISection.direction);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_FreeSection_r1_EnableSection;
        } else {
            if (sCISection.getSectionLockedToValue() == sCISection.direction) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCISection.raiseDisableSection(sCISection.direction);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_OccupiedSection_r1_BecomesLocked;
            } else {
                if (sCISection.getSectionLockedWithReplyToValue() == sCISection.direction) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCISection.raisePassingDeniedFrom(sCISection.direction);

                    sCISection.raiseDisableSection(sCISection.direction);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_OccupiedSection_r1_BecomesLocked;
                } else {
                    if (sCISection.getSectionAllowedToValue() == sCISection.direction) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCISection.raiseEnableSection(sCISection.id);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_OccupiedSection_r1_EnableSection;
                    } else {
                        if (sCISection.getLockRequestToValue() == sCISection.direction) {
                            sCISection.raisePassingDeniedFrom(
                                    sCISection.direction);
                        }

                        if (sCISection.revokeLock) {
                            sCISection.raiseSectionLockFrom(sCISection.direction);
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state EnableSection. */
    private void react_main_region_OccupiedSection_r1_EnableSection() {
        if (sCISection.sectionFree) {
            switch (stateVector[0]) {
                case main_region_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCISection.raisePassingAllowedFrom(sCISection.direction);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_FreeSection_r1_EnableSection;
        } else {
            if (sCISection.revokeLock) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCISection.raiseSectionLockFrom(sCISection.direction);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_OccupiedSection_r1_SendSectionLock;
            } else {
                if (sCISection.getSectionLockedWithReplyToValue() == sCISection.direction) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCISection.raisePassingDeniedFrom(sCISection.direction);

                    sCISection.raiseDisableSection(sCISection.direction);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_OccupiedSection_r1_BecomesLocked;
                } else {
                    if (sCISection.getSectionLockedToValue() == sCISection.direction) {
                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCISection.raiseDisableSection(sCISection.direction);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_OccupiedSection_r1_BecomesLocked;
                    } else {
                        if (sCISection.getLockRequestToValue() == sCISection.direction) {
                            sCISection.raisePassingDeniedFrom(
                                    sCISection.direction);
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state BecomesLocked. */
    private void react_main_region_OccupiedSection_r1_BecomesLocked() {
        if (sCISection.sectionFree) {
            switch (stateVector[0]) {
                case main_region_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            sCISection.raisePassingAllowedFrom(sCISection.direction);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_FreeSection_r1_EnableSection;
        } else {
            if (sCISection.revokeLock) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                sCISection.raiseSectionLockFrom(sCISection.direction);

                nextStateIndex = 0;
                stateVector[0] = State.main_region_OccupiedSection_r1_SendSectionLock;
            } else {
                if (sCISection.getSectionAllowedToValue() == sCISection.direction) {
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    sCISection.raiseSectionLockFrom(sCISection.direction);

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_OccupiedSection_r1_SendSectionLock;
                } else {
                    if (sCISection.getLockRequestToValue() == sCISection.direction) {
                        sCISection.raisePassingDeniedFrom(sCISection.direction);

                        sCISection.raiseDisableSection(sCISection.id);
                    }

                    if (sCISection.getSectionLockedWithReplyToValue() == sCISection.direction) {
                        sCISection.raisePassingDeniedFrom(sCISection.direction);

                        sCISection.raiseDisableSection(sCISection.id);
                    }
                }
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
                case main_region_FreeSection_r1_EnableSection:
                    react_main_region_FreeSection_r1_EnableSection();
                    break;
                case main_region_OccupiedSection_r1_SendSectionLock:
                    react_main_region_OccupiedSection_r1_SendSectionLock();
                    break;
                case main_region_OccupiedSection_r1_EnableSection:
                    react_main_region_OccupiedSection_r1_EnableSection();
                    break;
                case main_region_OccupiedSection_r1_BecomesLocked:
                    react_main_region_OccupiedSection_r1_BecomesLocked();
                    break;
                default:
                // $NullState$
            }
        }

        clearEvents();
    }
}
