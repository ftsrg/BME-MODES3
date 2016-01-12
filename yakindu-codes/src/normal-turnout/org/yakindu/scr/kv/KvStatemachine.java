package org.yakindu.scr.kv;

import java.util.LinkedList;
import java.util.List;

public class KvStatemachine implements IKvStatemachine {

    private boolean lockRequestToTop;

    private boolean lockRequestToDivergent;

    private boolean lockRequestToStraight;

    private boolean sectionAllowedToTop;

    private boolean sectionAllowedToDivergent;

    private boolean sectionAllowedToStraight;

    private boolean sectionLockedToTop;

    private boolean sectionLockedToStraight;

    private boolean sectionLockedToDivergent;

    private boolean sectionLockedWithReplyToTop;

    private boolean sectionLockedWithReplyToStraight;

    private boolean sectionLockedWithReplyToDivergent;

    private boolean sectionLockFromTop;

    private boolean sectionLockFromDivergent;

    private boolean sectionLockFromStraight;

    private boolean passingAllowedFromTop;

    private boolean passingAllowedFromDivergent;

    private boolean passingAllowedFromStraight;

    private boolean passingDeniedFromTop;

    private boolean passingDeniedFromDivergent;

    private boolean passingDeniedFromStraight;

    private boolean responseFromDescendant;

    private boolean dSsectionLockFromTop;

    private boolean dSsectionLockFromStraight;

    private boolean dSremSectionLockFromTop;

    private boolean dSremSectionLockFromStraight;

    private boolean dDsectionLockFromTop;

    private boolean dDsectionLockFromDivergent;

    private boolean dDremSectionLockFromTop;

    private boolean dDremSectionLockFromDivergent;

    private final class SCISectionsImpl implements SCISections {

        private List<SCISectionsListener> listeners = new LinkedList<SCISectionsListener>();

        public List<SCISectionsListener> getListeners() {
            return listeners;
        }

        private boolean revokeLock;
        private boolean revokeLockRaised;

        public void raiseRevokeLock() {
            revokeLockRaised = true;
        }

        private boolean topOccupied;

        public void raiseTopOccupied() {
            topOccupied = true;
        }

        private boolean divergentOccupied;

        public void raiseDivergentOccupied() {
            divergentOccupied = true;
        }

        private boolean straightOccupied;

        public void raiseStraightOccupied() {
            straightOccupied = true;
        }

        private boolean topFree;

        public void raiseTopFree() {
            topFree = true;
        }

        private boolean divergentFree;

        public void raiseDivergentFree() {
            divergentFree = true;
        }

        private boolean straightFree;

        public void raiseStraightFree() {
            straightFree = true;
        }

        private boolean enableSection;

        private long enableSectionValue;

        public boolean isRaisedEnableSection() {
            return enableSection;
        }

        private void raiseEnableSection(long value) {
            enableSection = true;
            enableSectionValue = value;
            for (SCISectionsListener listener : listeners) {
                listener.onEnableSectionRaised(value);
            }
        }

        public long getEnableSectionValue() {
            if (!enableSection) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event EnableSection is not raised!");
            }
            return enableSectionValue;
        }

        private boolean disableSection;

        private long disableSectionValue;

        public boolean isRaisedDisableSection() {
            return disableSection;
        }

        private void raiseDisableSection(long value) {
            disableSection = true;
            disableSectionValue = value;
            for (SCISectionsListener listener : listeners) {
                listener.onDisableSectionRaised(value);
            }
        }

        public long getDisableSectionValue() {
            if (!disableSection) {
                throw new IllegalStateException(
                        "Illegal event value acces. Event DisableSection is not raised!");
            }
            return disableSectionValue;
        }

        private boolean remPassageRequestToTop;

        public boolean isRaisedRemPassageRequestToTop() {
            return remPassageRequestToTop;
        }

        private void raiseRemPassageRequestToTop() {
            remPassageRequestToTop = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageRequestToTopRaised();
            }
        }

        private boolean remPassageRequestToDivergent;

        public boolean isRaisedRemPassageRequestToDivergent() {
            return remPassageRequestToDivergent;
        }

        private void raiseRemPassageRequestToDivergent() {
            remPassageRequestToDivergent = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageRequestToDivergentRaised();
            }
        }

        private boolean remPassageRequestToStraight;

        public boolean isRaisedRemPassageRequestToStraight() {
            return remPassageRequestToStraight;
        }

        private void raiseRemPassageRequestToStraight() {
            remPassageRequestToStraight = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageRequestToStraightRaised();
            }
        }

        private boolean remShortPassageRequestToTop;

        public boolean isRaisedRemShortPassageRequestToTop() {
            return remShortPassageRequestToTop;
        }

        private void raiseRemShortPassageRequestToTop() {
            remShortPassageRequestToTop = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemShortPassageRequestToTopRaised();
            }
        }

        private boolean remShortPassageRequestToStraight;

        public boolean isRaisedRemShortPassageRequestToStraight() {
            return remShortPassageRequestToStraight;
        }

        private void raiseRemShortPassageRequestToStraight() {
            remShortPassageRequestToStraight = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemShortPassageRequestToStraightRaised();
            }
        }

        private boolean remPassageAllowedToTop;

        public boolean isRaisedRemPassageAllowedToTop() {
            return remPassageAllowedToTop;
        }

        private void raiseRemPassageAllowedToTop() {
            remPassageAllowedToTop = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageAllowedToTopRaised();
            }
        }

        private boolean remPassageAllowedToDivergent;

        public boolean isRaisedRemPassageAllowedToDivergent() {
            return remPassageAllowedToDivergent;
        }

        private void raiseRemPassageAllowedToDivergent() {
            remPassageAllowedToDivergent = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageAllowedToDivergentRaised();
            }
        }

        private boolean remPassageAllowedToStraight;

        public boolean isRaisedRemPassageAllowedToStraight() {
            return remPassageAllowedToStraight;
        }

        private void raiseRemPassageAllowedToStraight() {
            remPassageAllowedToStraight = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageAllowedToStraightRaised();
            }
        }

        private boolean remPassageDeniedToTop;

        public boolean isRaisedRemPassageDeniedToTop() {
            return remPassageDeniedToTop;
        }

        private void raiseRemPassageDeniedToTop() {
            remPassageDeniedToTop = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageDeniedToTopRaised();
            }
        }

        private boolean remPassageDeniedToDivergent;

        public boolean isRaisedRemPassageDeniedToDivergent() {
            return remPassageDeniedToDivergent;
        }

        private void raiseRemPassageDeniedToDivergent() {
            remPassageDeniedToDivergent = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageDeniedToDivergentRaised();
            }
        }

        private boolean remPassageDeniedToStraight;

        public boolean isRaisedRemPassageDeniedToStraight() {
            return remPassageDeniedToStraight;
        }

        private void raiseRemPassageDeniedToStraight() {
            remPassageDeniedToStraight = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageDeniedToStraightRaised();
            }
        }

        private boolean remPassageDeniedToAll;

        public boolean isRaisedRemPassageDeniedToAll() {
            return remPassageDeniedToAll;
        }

        private void raiseRemPassageDeniedToAll() {
            remPassageDeniedToAll = true;
            for (SCISectionsListener listener : listeners) {
                listener.onRemPassageDeniedToAllRaised();
            }
        }

        private boolean remPassageAllowedFromTop;

        public void raiseRemPassageAllowedFromTop() {
            remPassageAllowedFromTop = true;
        }

        private boolean remPassageAllowedFromDivergent;

        public void raiseRemPassageAllowedFromDivergent() {
            remPassageAllowedFromDivergent = true;
        }

        private boolean remPassageAllowedFromStraight;

        public void raiseRemPassageAllowedFromStraight() {
            remPassageAllowedFromStraight = true;
        }

        private boolean remPassageDeniedFromTop;

        public void raiseRemPassageDeniedFromTop() {
            remPassageDeniedFromTop = true;
        }

        private boolean remPassageDeniedFromDivergent;

        public void raiseRemPassageDeniedFromDivergent() {
            remPassageDeniedFromDivergent = true;
        }

        private boolean remPassageDeniedFromStraight;

        public void raiseRemPassageDeniedFromStraight() {
            remPassageDeniedFromStraight = true;
        }

        public void clearEvents() {
            topOccupied = false;
            divergentOccupied = false;
            straightOccupied = false;
            topFree = false;
            divergentFree = false;
            straightFree = false;
            remPassageAllowedFromTop = false;
            remPassageAllowedFromDivergent = false;
            remPassageAllowedFromStraight = false;
            remPassageDeniedFromTop = false;
            remPassageDeniedFromDivergent = false;
            remPassageDeniedFromStraight = false;
        }

        public void clearOutEvents() {
            enableSection = false;
            disableSection = false;
            remPassageRequestToTop = false;
            remPassageRequestToDivergent = false;
            remPassageRequestToStraight = false;
            remShortPassageRequestToTop = false;
            remShortPassageRequestToStraight = false;
            remPassageAllowedToTop = false;
            remPassageAllowedToDivergent = false;
            remPassageAllowedToStraight = false;
            remPassageDeniedToTop = false;
            remPassageDeniedToDivergent = false;
            remPassageDeniedToStraight = false;
            remPassageDeniedToAll = false;
        }
    }

    private SCISectionsImpl sCISections;

    private final class SCITurnoutImpl implements SCITurnout {

        private boolean turnoutDivergent;

        public void raiseTurnoutDivergent() {
            turnoutDivergent = true;
        }

        private boolean turnoutStraight;

        public void raiseTurnoutStraight() {
            turnoutStraight = true;
        }

        private boolean remSectionLockFromTop;

        public void raiseRemSectionLockFromTop() {
            remSectionLockFromTop = true;
        }

        private boolean remSectionLockFromDivergent;

        public void raiseRemSectionLockFromDivergent() {
            remSectionLockFromDivergent = true;
        }

        private boolean remSectionLockFromStraight;

        public void raiseRemSectionLockFromStraight() {
            remSectionLockFromStraight = true;
        }

        private long turnoutId;

        public long getTurnoutId() {
            return turnoutId;
        }

        public void setTurnoutId(long value) {
            this.turnoutId = value;
        }

        private long turnoutSectionId;

        public long getTurnoutSectionId() {
            return turnoutSectionId;
        }

        public void setTurnoutSectionId(long value) {
            this.turnoutSectionId = value;
        }

        private boolean isOccupied;

        public boolean getIsOccupied() {
            return isOccupied;
        }

        public void setIsOccupied(boolean value) {
            this.isOccupied = value;
        }

        private boolean remTopIsPrior;

        public boolean getRemTopIsPrior() {
            return remTopIsPrior;
        }

        public void setRemTopIsPrior(boolean value) {
            this.remTopIsPrior = value;
        }

        private boolean remDivergentIsPrior;

        public boolean getRemDivergentIsPrior() {
            return remDivergentIsPrior;
        }

        public void setRemDivergentIsPrior(boolean value) {
            this.remDivergentIsPrior = value;
        }

        private boolean remStraightIsPrior;

        public boolean getRemStraightIsPrior() {
            return remStraightIsPrior;
        }

        public void setRemStraightIsPrior(boolean value) {
            this.remStraightIsPrior = value;
        }

        public void clearEvents() {
            turnoutDivergent = false;
            turnoutStraight = false;
            remSectionLockFromTop = false;
            remSectionLockFromDivergent = false;
            remSectionLockFromStraight = false;
        }

    }

    private SCITurnoutImpl sCITurnout;

    private final class SCISectionTopImpl implements SCISectionTop {

        private long sectionId;

        public long getSectionId() {
            return sectionId;
        }

        public void setSectionId(long value) {
            this.sectionId = value;
        }

    }

    private SCISectionTopImpl sCISectionTop;

    private final class SCISectionStraightImpl implements SCISectionStraight {

        private long sectionId;

        public long getSectionId() {
            return sectionId;
        }

        public void setSectionId(long value) {
            this.sectionId = value;
        }

    }

    private SCISectionStraightImpl sCISectionStraight;

    private final class SCISectionDivergentImpl implements SCISectionDivergent {

        private long sectionId;

        public long getSectionId() {
            return sectionId;
        }

        public void setSectionId(long value) {
            this.sectionId = value;
        }

    }

    private SCISectionDivergentImpl sCISectionDivergent;

    public enum State {

        main_region_CS, main_region_CS_SectionTop_FreeSection, main_region_CS_SectionTop_FreeSection_r1_EnableSection, main_region_CS_SectionTop_FreeSection_r1_LockedWithReply, main_region_CS_SectionTop_FreeSection_r1_PreEnableSection, main_region_CS_SectionTop_OccupiedSection, main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock, main_region_CS_SectionTop_OccupiedSection_r1_EnableSection, main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked, main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock, main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked, main_region_CS_SectionStraight_FreeSection, main_region_CS_SectionStraight_FreeSection_r1_EnableSection, main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply, main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection, main_region_CS_SectionStraight_OccupiedSection, main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock, main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection, main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked, main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock, main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked, main_region_CS_SectionDivergent_FreeSection, main_region_CS_SectionDivergent_FreeSection_r1_EnableSection, main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply, main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection, main_region_CS_SectionDivergent_OccupiedSection, main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock, main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection, main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked, main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock, main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked, main_region_CS_Turnout_StraightTurnout, main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight, main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock, main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort, main_region_CS_Turnout_DivergentTurnout, main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent, main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock, main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection, $NullState$
    };

    private final State[] stateVector = new State[6];

    private int nextStateIndex;

    static {
    }

    public KvStatemachine() {

        sCISections = new SCISectionsImpl();
        sCITurnout = new SCITurnoutImpl();
        sCISectionTop = new SCISectionTopImpl();
        sCISectionStraight = new SCISectionStraightImpl();
        sCISectionDivergent = new SCISectionDivergentImpl();
    }

    public void init() {
        for (int i = 0; i < 6; i++) {
            stateVector[i] = State.$NullState$;
        }

        clearEvents();
        clearOutEvents();

        sCITurnout.turnoutId = 0;

        sCITurnout.turnoutSectionId = 0;

        sCITurnout.isOccupied = false;

        sCITurnout.remTopIsPrior = false;

        sCITurnout.remDivergentIsPrior = false;

        sCITurnout.remStraightIsPrior = false;

        sCISectionTop.sectionId = 0;

        sCISectionStraight.sectionId = 0;

        sCISectionDivergent.sectionId = 0;
    }

    public void enter() {
        entryAction();

        nextStateIndex = 0;
        stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;

        nextStateIndex = 2;
        stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;

        nextStateIndex = 5;
        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
    }

    public void exit() {
        switch (stateVector[0]) {
            case main_region_CS_SectionTop_FreeSection_r1_EnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_FreeSection_r1_LockedWithReply:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_FreeSection_r1_PreEnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[1]) {
            case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[2]) {
            case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[3]) {
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[4]) {
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[5]) {
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection:
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;
                break;

            default:
                break;
        }

        exitAction();
    }

    /**
     * This method resets the incoming events (time events included).
     */
    private void clearEvents() {
        sCISections.clearEvents();
        sCITurnout.clearEvents();
        sectionLockFromTop = false;
        sectionLockFromDivergent = false;
        sectionLockFromStraight = false;
        passingAllowedFromTop = false;
        passingAllowedFromDivergent = false;
        passingAllowedFromStraight = false;
        passingDeniedFromTop = false;
        passingDeniedFromDivergent = false;
        passingDeniedFromStraight = false;
        dSsectionLockFromTop = false;
        dSsectionLockFromStraight = false;
        dSremSectionLockFromTop = false;
        dSremSectionLockFromStraight = false;
        dDsectionLockFromTop = false;
        dDsectionLockFromDivergent = false;
        dDremSectionLockFromTop = false;
        dDremSectionLockFromDivergent = false;

    }

    /**
     * This method resets the outgoing events.
     */
    private void clearOutEvents() {
        sCISections.clearOutEvents();
    }

    /**
     * Returns true if the given state is currently active otherwise false.
     */
    public boolean isStateActive(State state) {
        switch (state) {
            case main_region_CS:
                return stateVector[0].ordinal() >= State.main_region_CS
                        .ordinal()
                        && stateVector[0].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection
                        .ordinal();
            case main_region_CS_SectionTop_FreeSection:
                return stateVector[0].ordinal() >= State.main_region_CS_SectionTop_FreeSection
                        .ordinal()
                        && stateVector[0].ordinal() <= State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection
                        .ordinal();
            case main_region_CS_SectionTop_FreeSection_r1_EnableSection:
                return stateVector[0] == State.main_region_CS_SectionTop_FreeSection_r1_EnableSection;
            case main_region_CS_SectionTop_FreeSection_r1_LockedWithReply:
                return stateVector[0] == State.main_region_CS_SectionTop_FreeSection_r1_LockedWithReply;
            case main_region_CS_SectionTop_FreeSection_r1_PreEnableSection:
                return stateVector[0] == State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;
            case main_region_CS_SectionTop_OccupiedSection:
                return stateVector[0].ordinal() >= State.main_region_CS_SectionTop_OccupiedSection
                        .ordinal()
                        && stateVector[0].ordinal() <= State.main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked
                        .ordinal();
            case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                return stateVector[0] == State.main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock;
            case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                return stateVector[0] == State.main_region_CS_SectionTop_OccupiedSection_r1_EnableSection;
            case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                return stateVector[0] == State.main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked;
            case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                return stateVector[0] == State.main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock;
            case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                return stateVector[0] == State.main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked;
            case main_region_CS_SectionStraight_FreeSection:
                return stateVector[1].ordinal() >= State.main_region_CS_SectionStraight_FreeSection
                        .ordinal()
                        && stateVector[1].ordinal() <= State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection
                        .ordinal();
            case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                return stateVector[1] == State.main_region_CS_SectionStraight_FreeSection_r1_EnableSection;
            case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                return stateVector[1] == State.main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply;
            case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                return stateVector[1] == State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
            case main_region_CS_SectionStraight_OccupiedSection:
                return stateVector[1].ordinal() >= State.main_region_CS_SectionStraight_OccupiedSection
                        .ordinal()
                        && stateVector[1].ordinal() <= State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked
                        .ordinal();
            case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                return stateVector[1] == State.main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock;
            case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                return stateVector[1] == State.main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection;
            case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                return stateVector[1] == State.main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked;
            case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                return stateVector[1] == State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
            case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                return stateVector[1] == State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
            case main_region_CS_SectionDivergent_FreeSection:
                return stateVector[2].ordinal() >= State.main_region_CS_SectionDivergent_FreeSection
                        .ordinal()
                        && stateVector[2].ordinal() <= State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection
                        .ordinal();
            case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                return stateVector[2] == State.main_region_CS_SectionDivergent_FreeSection_r1_EnableSection;
            case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                return stateVector[2] == State.main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply;
            case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                return stateVector[2] == State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
            case main_region_CS_SectionDivergent_OccupiedSection:
                return stateVector[2].ordinal() >= State.main_region_CS_SectionDivergent_OccupiedSection
                        .ordinal()
                        && stateVector[2].ordinal() <= State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked
                        .ordinal();
            case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                return stateVector[2] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                return stateVector[2] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                return stateVector[2] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                return stateVector[2] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                return stateVector[2] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
            case main_region_CS_Turnout_StraightTurnout:
                return stateVector[3].ordinal() >= State.main_region_CS_Turnout_StraightTurnout
                        .ordinal()
                        && stateVector[3].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight:
                return stateVector[3].ordinal() >= State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight
                        .ordinal()
                        && stateVector[3].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                return stateVector[3] == State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight:
                return stateVector[4].ordinal() >= State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight
                        .ordinal()
                        && stateVector[4].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight:
                return stateVector[5].ordinal() >= State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight
                        .ordinal()
                        && stateVector[5].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort:
                return stateVector[5] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort;
            case main_region_CS_Turnout_DivergentTurnout:
                return stateVector[3].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout
                        .ordinal()
                        && stateVector[3].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent:
                return stateVector[3].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent
                        .ordinal()
                        && stateVector[3].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                return stateVector[3] == State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent:
                return stateVector[4].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent
                        .ordinal()
                        && stateVector[4].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent:
                return stateVector[5].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent
                        .ordinal()
                        && stateVector[5].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection:
                return stateVector[5] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection;
            default:
                return false;
        }
    }

    public SCISections getSCISections() {
        return sCISections;
    }

    public SCITurnout getSCITurnout() {
        return sCITurnout;
    }

    public SCISectionTop getSCISectionTop() {
        return sCISectionTop;
    }

    public SCISectionStraight getSCISectionStraight() {
        return sCISectionStraight;
    }

    public SCISectionDivergent getSCISectionDivergent() {
        return sCISectionDivergent;
    }

    private void raiseLockRequestToTop() {
        lockRequestToTop = true;
    }

    private void raiseLockRequestToDivergent() {
        lockRequestToDivergent = true;
    }

    private void raiseLockRequestToStraight() {
        lockRequestToStraight = true;
    }

    private void raiseSectionAllowedToTop() {
        sectionAllowedToTop = true;
    }

    private void raiseSectionAllowedToDivergent() {
        sectionAllowedToDivergent = true;
    }

    private void raiseSectionAllowedToStraight() {
        sectionAllowedToStraight = true;
    }

    private void raiseSectionLockedToTop() {
        sectionLockedToTop = true;
    }

    private void raiseSectionLockedToStraight() {
        sectionLockedToStraight = true;
    }

    private void raiseSectionLockedToDivergent() {
        sectionLockedToDivergent = true;
    }

    private void raiseSectionLockedWithReplyToTop() {
        sectionLockedWithReplyToTop = true;
    }

    private void raiseSectionLockedWithReplyToStraight() {
        sectionLockedWithReplyToStraight = true;
    }

    private void raiseSectionLockedWithReplyToDivergent() {
        sectionLockedWithReplyToDivergent = true;
    }

    private void raiseSectionLockFromTop() {
        sectionLockFromTop = true;
    }

    private void raiseSectionLockFromDivergent() {
        sectionLockFromDivergent = true;
    }

    private void raiseSectionLockFromStraight() {
        sectionLockFromStraight = true;
    }

    private void raisePassingAllowedFromTop() {
        passingAllowedFromTop = true;
    }

    private void raisePassingAllowedFromDivergent() {
        passingAllowedFromDivergent = true;
    }

    private void raisePassingAllowedFromStraight() {
        passingAllowedFromStraight = true;
    }

    private void raisePassingDeniedFromTop() {
        passingDeniedFromTop = true;
    }

    private void raisePassingDeniedFromDivergent() {
        passingDeniedFromDivergent = true;
    }

    private void raisePassingDeniedFromStraight() {
        passingDeniedFromStraight = true;
    }

    private void raiseResponseFromDescendant() {
        responseFromDescendant = true;
    }

    private void raiseDSsectionLockFromTop() {
        dSsectionLockFromTop = true;
    }

    private void raiseDSsectionLockFromStraight() {
        dSsectionLockFromStraight = true;
    }

    private void raiseDSremSectionLockFromTop() {
        dSremSectionLockFromTop = true;
    }

    private void raiseDSremSectionLockFromStraight() {
        dSremSectionLockFromStraight = true;
    }

    private void raiseDDsectionLockFromTop() {
        dDsectionLockFromTop = true;
    }

    private void raiseDDsectionLockFromDivergent() {
        dDsectionLockFromDivergent = true;
    }

    private void raiseDDremSectionLockFromTop() {
        dDremSectionLockFromTop = true;
    }

    private void raiseDDremSectionLockFromDivergent() {
        dDremSectionLockFromDivergent = true;
    }

    /* Entry action for statechart 'kv'. */
    private void entryAction() {
    }

    /* Exit action for state 'kv'. */
    private void exitAction() {
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionTop_FreeSection_r1_EnableSection() {
        if (sCISections.topOccupied) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToTop) {
                sectionLockedWithReplyToTop = false;

                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                raisePassingAllowedFromTop();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_LockedWithReply;
            } else {
                if (lockRequestToTop) {
                    lockRequestToTop = false;

                    raisePassingAllowedFromTop();
                }
            }
        }
    }

    /* The reactions of state LockedWithReply. */
    private void reactMain_region_CS_SectionTop_FreeSection_r1_LockedWithReply() {
        if (sCISections.topOccupied) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToTop || lockRequestToTop) {
                if (sectionLockedWithReplyToTop) {
                    sectionLockedWithReplyToTop = false;
                }
                if (lockRequestToTop) {
                    lockRequestToTop = false;
                }

                raisePassingAllowedFromTop();
            }
        }
    }

    /* The reactions of state PreEnableSection. */
    private void reactMain_region_CS_SectionTop_FreeSection_r1_PreEnableSection() {
        if (sCISections.topOccupied) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock;
        } else {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCISections.raiseEnableSection(sCISectionTop.sectionId);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_EnableSection;
        }
    }

    /* The reactions of state SendSectionLock. */
    private void reactMain_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock() {
        if (sCISections.topFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;
        } else {
            if (sectionLockedToTop) {
                sectionLockedToTop = false;

                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked;
            } else {
                if (sectionLockedWithReplyToTop) {
                    sectionLockedWithReplyToTop = false;

                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    raisePassingDeniedFromTop();

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionAllowedToTop) {
                        sectionAllowedToTop = false;

                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCISections.raiseEnableSection(sCISectionTop.sectionId);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_EnableSection;
                    } else {
                        if (lockRequestToTop) {
                            lockRequestToTop = false;

                            raisePassingDeniedFromTop();

                            raiseSectionLockFromTop();
                        }

                        if (sCISections.revokeLock) {
                            raiseSectionLockFromTop();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionTop_OccupiedSection_r1_EnableSection() {
        if (sCISections.topFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (sectionLockedWithReplyToTop) {
                    sectionLockedWithReplyToTop = false;

                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    raisePassingDeniedFromTop();

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionLockedToTop) {
                        sectionLockedToTop = false;

                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked;
                    } else {
                        if (lockRequestToTop) {
                            lockRequestToTop = false;

                            raisePassingDeniedFromTop();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state BecomesLocked. */
    private void reactMain_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked() {
        if (sCISections.topFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock || sectionAllowedToTop) {
                if (sectionAllowedToTop) {
                    sectionAllowedToTop = false;
                }

                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (lockRequestToTop || sectionLockedWithReplyToTop) {
                    if (sectionLockedWithReplyToTop) {
                        sectionLockedWithReplyToTop = false;
                    }
                    if (lockRequestToTop) {
                        lockRequestToTop = false;
                    }

                    raisePassingDeniedFromTop();

                    sCISections.raiseDisableSection(sCISectionTop.sectionId);
                }
            }
        }
    }

    /* The reactions of state PreSendSectionLock. */
    private void reactMain_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock() {
        if (sCISections.topFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            raiseSectionLockFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock;
        }
    }

    /* The reactions of state PreBecomesLocked. */
    private void reactMain_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked() {
        if (sCISections.topFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromTop();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCISections.raiseDisableSection(sCISectionTop.sectionId);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked;
        }
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionStraight_FreeSection_r1_EnableSection() {
        if (sCISections.straightOccupied) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToStraight) {
                sectionLockedWithReplyToStraight = false;

                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                raisePassingAllowedFromStraight();

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply;
            } else {
                if (lockRequestToStraight) {
                    lockRequestToStraight = false;

                    raisePassingAllowedFromStraight();
                }
            }
        }
    }

    /* The reactions of state LockedWithReply. */
    private void reactMain_region_CS_SectionStraight_FreeSection_r1_LockedWithReply() {
        if (sCISections.straightOccupied) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToStraight || lockRequestToStraight) {
                if (sectionLockedWithReplyToStraight) {
                    sectionLockedWithReplyToStraight = false;
                }
                if (lockRequestToStraight) {
                    lockRequestToStraight = false;
                }

                raisePassingAllowedFromStraight();
            }
        }
    }

    /* The reactions of state PreEnableSection. */
    private void reactMain_region_CS_SectionStraight_FreeSection_r1_PreEnableSection() {
        if (sCISections.straightOccupied) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
        } else {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCISections.raiseEnableSection(sCISectionStraight.sectionId);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_EnableSection;
        }
    }

    /* The reactions of state SendSectionLock. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock() {
        if (sCISections.straightFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            if (sectionLockedToStraight) {
                sectionLockedToStraight = false;

                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
            } else {
                if (sectionLockedWithReplyToStraight) {
                    sectionLockedWithReplyToStraight = false;

                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;

                    raisePassingDeniedFromStraight();

                    nextStateIndex = 1;
                    stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionAllowedToStraight) {
                        sectionAllowedToStraight = false;

                        nextStateIndex = 1;
                        stateVector[1] = State.$NullState$;

                        sCISections
                                .raiseEnableSection(sCISectionStraight.sectionId);

                        nextStateIndex = 1;
                        stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection;
                    } else {
                        if (lockRequestToStraight) {
                            lockRequestToStraight = false;

                            raisePassingDeniedFromStraight();

                            raiseSectionLockFromStraight();
                        }

                        if (sCISections.revokeLock) {
                            raiseSectionLockFromStraight();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_EnableSection() {
        if (sCISections.straightFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (sectionLockedWithReplyToStraight) {
                    sectionLockedWithReplyToStraight = false;

                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;

                    raisePassingDeniedFromStraight();

                    nextStateIndex = 1;
                    stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionLockedToStraight) {
                        sectionLockedToStraight = false;

                        nextStateIndex = 1;
                        stateVector[1] = State.$NullState$;

                        nextStateIndex = 1;
                        stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
                    } else {
                        if (lockRequestToStraight) {
                            lockRequestToStraight = false;

                            raisePassingDeniedFromStraight();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state BecomesLocked. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked() {
        if (sCISections.straightFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock || sectionAllowedToStraight) {
                if (sectionAllowedToStraight) {
                    sectionAllowedToStraight = false;
                }

                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (lockRequestToStraight || sectionLockedWithReplyToStraight) {
                    if (sectionLockedWithReplyToStraight) {
                        sectionLockedWithReplyToStraight = false;
                    }
                    if (lockRequestToStraight) {
                        lockRequestToStraight = false;
                    }

                    raisePassingDeniedFromStraight();

                    sCISections
                            .raiseDisableSection(sCISectionStraight.sectionId);
                }
            }
        }
    }

    /* The reactions of state PreSendSectionLock. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock() {
        if (sCISections.straightFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            raiseSectionLockFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock;
        }
    }

    /* The reactions of state PreBecomesLocked. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked() {
        if (sCISections.straightFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCISections.raiseDisableSection(sCISectionStraight.sectionId);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked;
        }
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionDivergent_FreeSection_r1_EnableSection() {
        if (sCISections.divergentOccupied) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToDivergent) {
                sectionLockedWithReplyToDivergent = false;

                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                raisePassingAllowedFromDivergent();

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply;
            } else {
                if (lockRequestToDivergent) {
                    lockRequestToDivergent = false;

                    raisePassingAllowedFromDivergent();
                }
            }
        }
    }

    /* The reactions of state LockedWithReply. */
    private void reactMain_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply() {
        if (sCISections.divergentOccupied) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToDivergent || lockRequestToDivergent) {
                if (sectionLockedWithReplyToDivergent) {
                    sectionLockedWithReplyToDivergent = false;
                }
                if (lockRequestToDivergent) {
                    lockRequestToDivergent = false;
                }

                raisePassingAllowedFromDivergent();
            }
        }
    }

    /* The reactions of state PreEnableSection. */
    private void reactMain_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection() {
        if (sCISections.divergentOccupied) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
        } else {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCISections.raiseEnableSection(sCISectionDivergent.sectionId);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_EnableSection;
        }
    }

    /* The reactions of state SendSectionLock. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock() {
        if (sCISections.divergentFree) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            if (sectionLockedToDivergent) {
                sectionLockedToDivergent = false;

                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
            } else {
                if (sectionLockedWithReplyToDivergent) {
                    sectionLockedWithReplyToDivergent = false;

                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;

                    raisePassingDeniedFromDivergent();

                    nextStateIndex = 2;
                    stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionAllowedToDivergent) {
                        if (sectionAllowedToDivergent) {
                            sectionAllowedToDivergent = false;
                        }

                        nextStateIndex = 2;
                        stateVector[2] = State.$NullState$;

                        sCISections
                                .raiseEnableSection(
                                        sCISectionDivergent.sectionId);

                        nextStateIndex = 2;
                        stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection;
                    } else {
                        if (lockRequestToDivergent) {
                            lockRequestToDivergent = false;

                            raisePassingDeniedFromDivergent();

                            raiseSectionLockFromDivergent();
                        }

                        if (sCISections.revokeLock) {
                            raiseSectionLockFromDivergent();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection() {
        if (sCISections.divergentFree) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (sectionLockedWithReplyToDivergent) {
                    sectionLockedWithReplyToDivergent = false;

                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;

                    raisePassingDeniedFromDivergent();

                    nextStateIndex = 2;
                    stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionLockedToDivergent) {
                        sectionLockedToDivergent = false;

                        nextStateIndex = 2;
                        stateVector[2] = State.$NullState$;

                        nextStateIndex = 2;
                        stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
                    } else {
                        if (lockRequestToDivergent) {
                            lockRequestToDivergent = false;

                            raisePassingDeniedFromDivergent();
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state BecomesLocked. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked() {
        if (sCISections.divergentFree) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock || sectionAllowedToDivergent) {
                if (sectionAllowedToDivergent) {
                    sectionAllowedToDivergent = false;
                }

                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (lockRequestToDivergent || sectionLockedWithReplyToDivergent) {
                    if (sectionLockedWithReplyToDivergent) {
                        sectionLockedWithReplyToDivergent = false;
                    }
                    if (lockRequestToDivergent) {
                        lockRequestToDivergent = false;
                    }

                    raisePassingDeniedFromDivergent();

                    sCISections
                            .raiseDisableSection(sCISectionDivergent.sectionId);
                }
            }
        }
    }

    /* The reactions of state PreSendSectionLock. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock() {
        if (sCISections.divergentFree) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            raiseSectionLockFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock;
        }
    }

    /* The reactions of state PreBecomesLocked. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked() {
        if (sCISections.divergentFree) {
            switch (stateVector[2]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCISections.raiseDisableSection(sCISectionDivergent.sectionId);

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked;
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[3]) {
                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionAllowedToDivergent();

            raiseSectionLockedToStraight();

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock;

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (sectionLockFromStraight) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                raiseDSsectionLockFromStraight();

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
            } else {
                if (sectionLockFromTop) {
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;

                    raiseDSsectionLockFromTop();

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                } else {
                    if (sCITurnout.remSectionLockFromStraight) {
                        nextStateIndex = 3;
                        stateVector[3] = State.$NullState$;

                        raiseDSremSectionLockFromStraight();

                        nextStateIndex = 3;
                        stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                    } else {
                        if (sCITurnout.remSectionLockFromTop) {
                            nextStateIndex = 3;
                            stateVector[3] = State.$NullState$;

                            raiseDSremSectionLockFromTop();

                            nextStateIndex = 3;
                            stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OneLockReceived. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[3]) {
                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionAllowedToDivergent();

            raiseSectionLockedToStraight();

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock;

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (responseFromDescendant) {
                responseFromDescendant = false;

                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromStraight) {
                    raiseSectionLockedToStraight();
                }

                if (sectionLockFromTop) {
                    raiseSectionLockedToTop();
                }

                if (sCITurnout.remSectionLockFromStraight) {
                    sCISections.raiseRemPassageDeniedToStraight();
                }

                if (sCITurnout.remSectionLockFromTop) {
                    sCISections.raiseRemPassageDeniedToTop();
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock() {
        if (sCITurnout.remSectionLockFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            raiseSectionLockedWithReplyToDivergent();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
        } else {
            if (sectionLockFromDivergent) {
                raiseSectionLockedToDivergent();
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock() {
        if (passingAllowedFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageAllowedToDivergent();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
        } else {
            if (passingDeniedFromDivergent) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToDivergent();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromDivergent) {
                    raiseSectionLockedToDivergent();
                }
            }
        }
    }

    /* The reactions of state PreWithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock() {
        nextStateIndex = 4;
        stateVector[4] = State.$NullState$;

        raiseSectionLockedToDivergent();

        nextStateIndex = 4;
        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
    }

    /* The reactions of state Init. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init() {
        if (dSsectionLockFromStraight) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            if (sCITurnout.turnoutId != 129 && sCISectionTop.sectionId > -1) {
                raiseSectionLockedWithReplyToTop();

                sCISections.raiseRemPassageRequestToStraight();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr;
            } else {
                if (sCITurnout.turnoutId != 129
                        && sCISectionTop.sectionId == -1) {
                    sCISections.raiseRemPassageRequestToTop();

                    sCISections.raiseRemPassageRequestToStraight();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr;
                } else {
                    if (sCITurnout.turnoutId == 129) {
                        sCISections.raiseRemPassageRequestToTop();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort;
                    }
                }
            }
        } else {
            if (dSsectionLockFromTop) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                if (sCISectionStraight.sectionId > -1) {
                    raiseSectionLockedWithReplyToStraight();

                    sCISections.raiseRemPassageRequestToTop();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop;
                } else {
                    sCISections.raiseRemPassageRequestToStraight();

                    sCISections.raiseRemPassageRequestToTop();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop;
                }
            } else {
                if (dSremSectionLockFromStraight) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        if (!sCITurnout.isOccupied
                                && sCISectionStraight.sectionId > -1) {
                            raiseSectionLockedWithReplyToStraight();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight;
                        } else {
                            if (!sCITurnout.isOccupied
                                    && sCISectionStraight.sectionId == -1) {
                                raiseSectionLockedWithReplyToTop();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight;
                            }
                        }
                    }
                } else {
                    if (dSremSectionLockFromTop) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (sCITurnout.isOccupied) {
                            sCISections.raiseRemPassageDeniedToTop();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        } else {
                            if (!sCITurnout.isOccupied
                                    && sCISectionTop.sectionId > -1) {
                                raiseSectionLockedWithReplyToTop();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection;
                            } else {
                                if (!sCITurnout.isOccupied
                                        && sCISectionTop.sectionId == -1) {
                                    raiseSectionLockedWithReplyToStraight();

                                    nextStateIndex = 5;
                                    stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state RespFromTopAndStr. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr() {
        if (passingDeniedFromTop || sCISections.remPassageDeniedFromTop
                || sCISections.remPassageDeniedFromStraight) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionLockedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingAllowedFromTop || sCISections.remPassageAllowedFromTop
                    || sCISections.remPassageAllowedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived;
            }
        }
    }

    /* The reactions of state OnePassageAllowedReceived. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived() {
        if (passingAllowedFromTop || sCISections.remPassageAllowedFromTop
                || sCISections.remPassageAllowedFromStraight) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionAllowedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingDeniedFromTop || sCISections.remPassageDeniedFromTop
                    || sCISections.remPassageDeniedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                raiseSectionLockedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            }
        }
    }

    /* The reactions of state RespFromStrAndTop. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop() {
        if (passingDeniedFromStraight || sCISections.remPassageDeniedFromTop
                || sCISections.remPassageDeniedFromStraight) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionLockedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingAllowedFromStraight
                    || sCISections.remPassageAllowedFromTop
                    || sCISections.remPassageAllowedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd;
            }
        }
    }

    /* The reactions of state OnePassAllowedRecvd. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd() {
        if (passingAllowedFromStraight || sCISections.remPassageAllowedFromTop
                || sCISections.remPassageAllowedFromStraight) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionAllowedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingDeniedFromStraight
                    || sCISections.remPassageDeniedFromTop
                    || sCISections.remPassageDeniedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                raiseSectionLockedToTop();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            }
        }
    }

    /* The reactions of state CheckStraight. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            } else {
                if (passingAllowedFromTop) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    }
                } else {
                    if (passingAllowedFromStraight) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (sCITurnout.isOccupied) {
                            sCISections.raiseRemPassageDeniedToStraight();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        } else {
                            if (!sCITurnout.isOccupied
                                    && sCISectionTop.sectionId > -1) {
                                raiseLockRequestToTop();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop;
                            } else {
                                if (!sCITurnout.isOccupied
                                        && sCISectionTop.sectionId == -1) {
                                    sCISections
                                            .raiseRemShortPassageRequestToTop();

                                    nextStateIndex = 5;
                                    stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop;
                                }
                            }
                        }
                    } else {
                        if (passingDeniedFromTop) {
                            nextStateIndex = 5;
                            stateVector[5] = State.$NullState$;

                            raiseSectionLockedToTop();

                            sCISections.raiseRemPassageDeniedToStraight();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sCISections.remPassageDeniedFromTop) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            } else {
                if (sCISections.remPassageAllowedFromTop
                        || passingAllowedFromTop) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    }
                } else {
                    if (passingDeniedFromTop) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (!sCITurnout.remStraightIsPrior
                                || sCITurnout.isOccupied) {
                            sCISections.raiseRemPassageDeniedToStraight();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        } else {
                            if (!(!sCITurnout.remStraightIsPrior || sCITurnout.isOccupied)) {
                                sCISections.raiseRemPassageAllowedToStraight();

                                raiseSectionLockedToTop();

                                raiseResponseFromDescendant();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTopSection. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection() {
        if (passingDeniedFromTop) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                raiseSectionLockedToStraight();

                sCISections.raiseRemPassageDeniedToTop();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            } else {
                if (passingAllowedFromStraight) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    }
                } else {
                    if (passingAllowedFromTop) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (!sCITurnout.isOccupied
                                && sCISectionStraight.sectionId > -1) {
                            raiseLockRequestToStraight();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection;
                        } else {
                            if (sCITurnout.isOccupied) {
                                sCISections.raiseRemPassageDeniedToTop();

                                raiseResponseFromDescendant();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                            } else {
                                if (!sCITurnout.isOccupied
                                        && sCISectionStraight.sectionId == -1) {
                                    sCISections
                                            .raiseRemShortPassageRequestToStraight();

                                    nextStateIndex = 5;
                                    stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection;
                                }
                            }
                        }
                    } else {
                        if (sCITurnout.isOccupied) {
                            nextStateIndex = 5;
                            stateVector[5] = State.$NullState$;

                            sCISections.raiseRemPassageDeniedToTop();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckStraightSection. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sCISections.remPassageDeniedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToTop();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            } else {
                if (sCISections.remPassageAllowedFromStraight
                        || passingAllowedFromStraight) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    }
                } else {
                    if (passingDeniedFromStraight) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (!(!sCITurnout.remTopIsPrior || sCITurnout.isOccupied)) {
                            sCISections.raiseRemPassageAllowedToTop();

                            raiseSectionLockedToStraight();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        } else {
                            if (!sCITurnout.remTopIsPrior
                                    || sCITurnout.isOccupied) {
                                sCISections.raiseRemPassageDeniedToTop();

                                raiseResponseFromDescendant();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state SendBackShort. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort() {
        if (sCISections.remPassageAllowedFromTop) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionAllowedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sCISections.remPassageDeniedFromTop) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                raiseSectionLockedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[3]) {
                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionAllowedToStraight();

            raiseSectionLockedToDivergent();

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sectionLockFromDivergent) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                raiseDDsectionLockFromDivergent();

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
            } else {
                if (sectionLockFromTop) {
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;

                    raiseDDsectionLockFromTop();

                    nextStateIndex = 3;
                    stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                } else {
                    if (sCITurnout.remSectionLockFromDivergent) {
                        nextStateIndex = 3;
                        stateVector[3] = State.$NullState$;

                        raiseDDremSectionLockFromDivergent();

                        nextStateIndex = 3;
                        stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                    } else {
                        if (sCITurnout.remSectionLockFromTop) {
                            nextStateIndex = 3;
                            stateVector[3] = State.$NullState$;

                            raiseDDremSectionLockFromTop();

                            nextStateIndex = 3;
                            stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OneLockReceived. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[3]) {
                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[5]) {
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection:
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionAllowedToStraight();

            raiseSectionLockedToDivergent();

            sCISections.raiseRemPassageDeniedToAll();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (responseFromDescendant) {
                responseFromDescendant = false;

                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromDivergent) {
                    raiseSectionLockedToDivergent();
                }

                if (sectionLockFromTop) {
                    raiseSectionLockedToTop();
                }

                if (sCITurnout.remSectionLockFromDivergent) {
                    sCISections.raiseRemPassageDeniedToDivergent();
                }

                if (sCITurnout.remSectionLockFromTop) {
                    sCISections.raiseRemPassageDeniedToTop();
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock() {
        if (sCITurnout.remSectionLockFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            if (sCITurnout.turnoutId == 130) {
                sCISections.raiseRemPassageDeniedToStraight();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            } else {
                raiseSectionLockedWithReplyToStraight();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
            }
        } else {
            if (sectionLockFromStraight) {
                raiseSectionLockedToStraight();
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock() {
        if (passingAllowedFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageAllowedToStraight();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToStraight();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromStraight) {
                    raiseSectionLockedToStraight();
                }
            }
        }
    }

    /* The reactions of state PreWithoutRececivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock() {
        nextStateIndex = 4;
        stateVector[4] = State.$NullState$;

        raiseSectionLockedToStraight();

        nextStateIndex = 4;
        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
    }

    /* The reactions of state Init. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init() {
        if (dDsectionLockFromDivergent) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            if (sCISectionTop.sectionId > -1) {
                raiseSectionLockedWithReplyToTop();

                sCISections.raiseRemPassageRequestToDivergent();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv;
            } else {
                sCISections.raiseRemPassageRequestToTop();

                sCISections.raiseRemPassageRequestToDivergent();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv;
            }
        } else {
            if (dDsectionLockFromTop) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                if (sCISectionDivergent.sectionId > -1) {
                    raiseSectionLockedWithReplyToDivergent();

                    sCISections.raiseRemPassageRequestToTop();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop;
                } else {
                    sCISections.raiseRemPassageRequestToDivergent();

                    sCISections.raiseRemPassageRequestToTop();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop;
                }
            } else {
                if (dDremSectionLockFromDivergent) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        raiseSectionLockedWithReplyToDivergent();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent;
                    }
                } else {
                    if (dDremSectionLockFromTop) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (sCITurnout.isOccupied) {
                            sCISections.raiseRemPassageDeniedToTop();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                        } else {
                            if (!sCITurnout.isOccupied
                                    && sCISectionTop.sectionId > -1) {
                                raiseSectionLockedWithReplyToTop();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection;
                            } else {
                                if (!sCITurnout.isOccupied
                                        && sCISectionTop.sectionId == -1) {
                                    raiseSectionLockedWithReplyToDivergent();

                                    nextStateIndex = 5;
                                    stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state RespFromTopAndDiv. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv() {
        if (passingDeniedFromTop || sCISections.remPassageDeniedFromTop
                || sCISections.remPassageDeniedFromDivergent) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionLockedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingAllowedFromTop || sCISections.remPassageAllowedFromTop
                    || sCISections.remPassageAllowedFromDivergent) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived;
            }
        }
    }

    /* The reactions of state OnePassageAllowedReceived. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived() {
        if (passingAllowedFromTop || sCISections.remPassageAllowedFromTop
                || sCISections.remPassageAllowedFromDivergent) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionAllowedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingDeniedFromTop || sCISections.remPassageDeniedFromTop
                    || sCISections.remPassageDeniedFromDivergent) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                raiseSectionLockedToDivergent();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            }
        }
    }

    /* The reactions of state RespFromDivAndTop. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop() {
        if (passingDeniedFromDivergent || sCISections.remPassageDeniedFromTop
                || sCISections.remPassageDeniedFromDivergent) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionLockedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingAllowedFromDivergent
                    || sCISections.remPassageAllowedFromTop
                    || sCISections.remPassageAllowedFromDivergent) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd;
            }
        }
    }

    /* The reactions of state OnePassAllowedRecvd. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd() {
        if (passingAllowedFromDivergent || sCISections.remPassageAllowedFromTop
                || sCISections.remPassageAllowedFromDivergent) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            raiseSectionAllowedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingDeniedFromDivergent
                    || sCISections.remPassageDeniedFromTop
                    || sCISections.remPassageDeniedFromDivergent) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                raiseSectionLockedToTop();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            }
        }
    }

    /* The reactions of state CheckDivergent. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingDeniedFromDivergent) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToDivergent();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            } else {
                if (passingAllowedFromDivergent) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        if (!sCITurnout.isOccupied
                                && sCISectionTop.sectionId > -1) {
                            raiseLockRequestToTop();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop;
                        } else {
                            if (!sCITurnout.isOccupied
                                    && sCISectionTop.sectionId == -1) {
                                sCISections.raiseRemShortPassageRequestToTop();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (sCISections.remPassageDeniedFromTop) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToDivergent();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            } else {
                if (sCISections.remPassageAllowedFromTop
                        || passingAllowedFromTop) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    }
                } else {
                    if (passingDeniedFromTop) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (!sCITurnout.remDivergentIsPrior
                                || sCITurnout.isOccupied) {
                            sCISections.raiseRemPassageDeniedToDivergent();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                        } else {
                            if (!(!sCITurnout.remDivergentIsPrior || sCITurnout.isOccupied)) {
                                sCISections.raiseRemPassageAllowedToDivergent();

                                raiseSectionLockedToTop();

                                raiseResponseFromDescendant();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTopSection. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection() {
        if (passingDeniedFromTop || passingDeniedFromDivergent) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingAllowedFromDivergent) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                if (sCITurnout.isOccupied) {
                    sCISections.raiseRemPassageDeniedToTop();

                    raiseResponseFromDescendant();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                } else {
                    sCISections.raiseRemPassageAllowedToTop();

                    raiseResponseFromDescendant();

                    nextStateIndex = 5;
                    stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                }
            } else {
                if (passingAllowedFromTop) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        raiseLockRequestToDivergent();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection;
                    }
                } else {
                    if (sCITurnout.isOccupied) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        sCISections.raiseRemPassageDeniedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    }
                }
            }
        }
    }

    /* The reactions of state CheckDivergentSection. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 5;
            stateVector[5] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToTop();

            raiseResponseFromDescendant();

            nextStateIndex = 5;
            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (sCISections.remPassageDeniedFromStraight) {
                nextStateIndex = 5;
                stateVector[5] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToTop();

                raiseResponseFromDescendant();

                nextStateIndex = 5;
                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            } else {
                if (passingAllowedFromDivergent) {
                    nextStateIndex = 5;
                    stateVector[5] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToTop();

                        raiseResponseFromDescendant();

                        nextStateIndex = 5;
                        stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    }
                } else {
                    if (passingDeniedFromDivergent) {
                        nextStateIndex = 5;
                        stateVector[5] = State.$NullState$;

                        if (!(!sCITurnout.remTopIsPrior || sCITurnout.isOccupied)) {
                            sCISections.raiseRemPassageAllowedToTop();

                            raiseSectionLockedToDivergent();

                            raiseResponseFromDescendant();

                            nextStateIndex = 5;
                            stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                        } else {
                            if (!sCITurnout.remTopIsPrior
                                    || sCITurnout.isOccupied) {
                                sCISections.raiseRemPassageDeniedToTop();

                                raiseResponseFromDescendant();

                                nextStateIndex = 5;
                                stateVector[5] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                            }
                        }
                    }
                }
            }
        }
    }

    public void runCycle() {

        clearOutEvents();

        for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

            switch (stateVector[nextStateIndex]) {
                case main_region_CS_SectionTop_FreeSection_r1_EnableSection:
                    reactMain_region_CS_SectionTop_FreeSection_r1_EnableSection();
                    break;
                case main_region_CS_SectionTop_FreeSection_r1_LockedWithReply:
                    reactMain_region_CS_SectionTop_FreeSection_r1_LockedWithReply();
                    break;
                case main_region_CS_SectionTop_FreeSection_r1_PreEnableSection:
                    reactMain_region_CS_SectionTop_FreeSection_r1_PreEnableSection();
                    break;
                case main_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock:
                    reactMain_region_CS_SectionTop_OccupiedSection_r1_SendSectionLock();
                    break;
                case main_region_CS_SectionTop_OccupiedSection_r1_EnableSection:
                    reactMain_region_CS_SectionTop_OccupiedSection_r1_EnableSection();
                    break;
                case main_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked:
                    reactMain_region_CS_SectionTop_OccupiedSection_r1_BecomesLocked();
                    break;
                case main_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock:
                    reactMain_region_CS_SectionTop_OccupiedSection_r1_PreSendSectionLock();
                    break;
                case main_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked:
                    reactMain_region_CS_SectionTop_OccupiedSection_r1_PreBecomesLocked();
                    break;
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    reactMain_region_CS_SectionStraight_FreeSection_r1_EnableSection();
                    break;
                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    reactMain_region_CS_SectionStraight_FreeSection_r1_LockedWithReply();
                    break;
                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    reactMain_region_CS_SectionStraight_FreeSection_r1_PreEnableSection();
                    break;
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    reactMain_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock();
                    break;
                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    reactMain_region_CS_SectionStraight_OccupiedSection_r1_EnableSection();
                    break;
                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    reactMain_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked();
                    break;
                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    reactMain_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock();
                    break;
                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    reactMain_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked();
                    break;
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    reactMain_region_CS_SectionDivergent_FreeSection_r1_EnableSection();
                    break;
                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    reactMain_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply();
                    break;
                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    reactMain_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection();
                    break;
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    reactMain_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock();
                    break;
                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    reactMain_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection();
                    break;
                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    reactMain_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked();
                    break;
                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    reactMain_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock();
                    break;
                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    reactMain_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                    reactMain_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                    reactMain_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                    reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromTopAndStr();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassageAllowedReceived();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_RespFromStrAndTop();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_OnePassAllowedRecvd();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTopSection();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraightSection();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_SendBackShort();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                    reactMain_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                    reactMain_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                    reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromTopAndDiv();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassageAllowedReceived();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_RespFromDivAndTop();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_OnePassAllowedRecvd();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTop();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckTopSection();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergentSection();
                    break;
                default:
                // $NullState$
            }
        }

        clearEvents();

        if (sCISections.revokeLock) {
            sCISections.revokeLock = false;
        }
        if (sCISections.revokeLockRaised) {
            sCISections.revokeLockRaised = false;
            sCISections.revokeLock = true;
            runCycle();
        }
    }
}
