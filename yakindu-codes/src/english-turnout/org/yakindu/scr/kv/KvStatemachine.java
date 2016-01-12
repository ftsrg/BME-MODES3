package org.yakindu.scr.kv;

import java.util.LinkedList;
import java.util.List;

public class KvStatemachine implements IKvStatemachine {

    private boolean lockRequestToDivergent;

    private boolean lockRequestToStraight;

    private boolean sectionAllowedToDivergent;

    private boolean sectionAllowedToStraight;

    private boolean sectionLockedToStraight;

    private boolean sectionLockedToDivergent;

    private boolean sectionLockedWithReplyToStraight;

    private boolean sectionLockedWithReplyToDivergent;

    private boolean sectionLockFromDivergent;

    private boolean sectionLockFromStraight;

    private boolean passingAllowedFromDivergent;

    private boolean passingAllowedFromStraight;

    private boolean passingDeniedFromDivergent;

    private boolean passingDeniedFromStraight;

    private boolean responseFromDescendant;

    private boolean dSsectionLockFromStraight;

    private boolean dSsectionLockFromOtherHalf;

    private boolean dSremSectionLockFromOtherHalf;

    private boolean dSremSectionLockFromStraight;

    private boolean dSremShortSectionLockFromStraight;

    private boolean dDsectionLockFromDivergent;

    private boolean dDsectionLockFromOtherHalf;

    private boolean dDremSectionLockFromOtherHalf;

    private boolean dDremSectionLockFromDivergent;

    private boolean dDremShortSectionLockFromDivergent;

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

        private boolean divergentOccupied;

        public void raiseDivergentOccupied() {
            divergentOccupied = true;
        }

        private boolean straightOccupied;

        public void raiseStraightOccupied() {
            straightOccupied = true;
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

        private boolean remPassageAllowedFromDivergent;

        public void raiseRemPassageAllowedFromDivergent() {
            remPassageAllowedFromDivergent = true;
        }

        private boolean remPassageAllowedFromStraight;

        public void raiseRemPassageAllowedFromStraight() {
            remPassageAllowedFromStraight = true;
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
            divergentOccupied = false;
            straightOccupied = false;
            divergentFree = false;
            straightFree = false;
            remPassageAllowedFromDivergent = false;
            remPassageAllowedFromStraight = false;
            remPassageDeniedFromDivergent = false;
            remPassageDeniedFromStraight = false;
        }

        public void clearOutEvents() {
            enableSection = false;
            disableSection = false;
            remPassageRequestToDivergent = false;
            remPassageRequestToStraight = false;
            remPassageAllowedToDivergent = false;
            remPassageAllowedToStraight = false;
            remPassageDeniedToDivergent = false;
            remPassageDeniedToStraight = false;
            remPassageDeniedToAll = false;
        }
    }

    private SCISectionsImpl sCISections;

    private final class SCITurnoutImpl implements SCITurnout {

        private List<SCITurnoutListener> listeners = new LinkedList<SCITurnoutListener>();

        public List<SCITurnoutListener> getListeners() {
            return listeners;
        }

        private boolean turnoutDivergent;

        public void raiseTurnoutDivergent() {
            turnoutDivergent = true;
        }

        private boolean turnoutStraight;

        public void raiseTurnoutStraight() {
            turnoutStraight = true;
        }

        private boolean remSectionLockFromDivergent;

        public void raiseRemSectionLockFromDivergent() {
            remSectionLockFromDivergent = true;
        }

        private boolean remSectionLockFromStraight;

        public void raiseRemSectionLockFromStraight() {
            remSectionLockFromStraight = true;
        }

        private boolean remShortSectionLockFromDivergent;

        public void raiseRemShortSectionLockFromDivergent() {
            remShortSectionLockFromDivergent = true;
        }

        private boolean remShortSectionLockFromStraight;

        public void raiseRemShortSectionLockFromStraight() {
            remShortSectionLockFromStraight = true;
        }

        private boolean remSectionLockFromOtherHalfIN;

        public void raiseRemSectionLockFromOtherHalfIN() {
            remSectionLockFromOtherHalfIN = true;
        }

        private boolean sectionLockFromOtherHalfIN;

        public void raiseSectionLockFromOtherHalfIN() {
            sectionLockFromOtherHalfIN = true;
        }

        private boolean passingAllowedFromOtherHalfIN;

        public void raisePassingAllowedFromOtherHalfIN() {
            passingAllowedFromOtherHalfIN = true;
        }

        private boolean passingDeniedFromOtherHalfIN;

        public void raisePassingDeniedFromOtherHalfIN() {
            passingDeniedFromOtherHalfIN = true;
        }

        private boolean remSectionLockFromOtherHalfOUT;

        public boolean isRaisedRemSectionLockFromOtherHalfOUT() {
            return remSectionLockFromOtherHalfOUT;
        }

        private void raiseRemSectionLockFromOtherHalfOUT() {
            remSectionLockFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onRemSectionLockFromOtherHalfOUTRaised();
            }
        }

        private boolean sectionLockFromOtherHalfOUT;

        public boolean isRaisedSectionLockFromOtherHalfOUT() {
            return sectionLockFromOtherHalfOUT;
        }

        private void raiseSectionLockFromOtherHalfOUT() {
            sectionLockFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onSectionLockFromOtherHalfOUTRaised();
            }
        }

        private boolean passingAllowedFromOtherHalfOUT;

        public boolean isRaisedPassingAllowedFromOtherHalfOUT() {
            return passingAllowedFromOtherHalfOUT;
        }

        private void raisePassingAllowedFromOtherHalfOUT() {
            passingAllowedFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onPassingAllowedFromOtherHalfOUTRaised();
            }
        }

        private boolean passingDeniedFromOtherHalfOUT;

        public boolean isRaisedPassingDeniedFromOtherHalfOUT() {
            return passingDeniedFromOtherHalfOUT;
        }

        private void raisePassingDeniedFromOtherHalfOUT() {
            passingDeniedFromOtherHalfOUT = true;
            for (SCITurnoutListener listener : listeners) {
                listener.onPassingDeniedFromOtherHalfOUTRaised();
            }
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

        public void clearEvents() {
            turnoutDivergent = false;
            turnoutStraight = false;
            remSectionLockFromDivergent = false;
            remSectionLockFromStraight = false;
            remShortSectionLockFromDivergent = false;
            remShortSectionLockFromStraight = false;
            remSectionLockFromOtherHalfIN = false;
            sectionLockFromOtherHalfIN = false;
            passingAllowedFromOtherHalfIN = false;
            passingDeniedFromOtherHalfIN = false;
        }

        public void clearOutEvents() {
            remSectionLockFromOtherHalfOUT = false;
            sectionLockFromOtherHalfOUT = false;
            passingAllowedFromOtherHalfOUT = false;
            passingDeniedFromOtherHalfOUT = false;
        }
    }

    private SCITurnoutImpl sCITurnout;

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

        main_region_CS, main_region_CS_SectionStraight_FreeSection, main_region_CS_SectionStraight_FreeSection_r1_EnableSection, main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply, main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection, main_region_CS_SectionStraight_OccupiedSection, main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock, main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection, main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked, main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock, main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked, main_region_CS_SectionDivergent_FreeSection, main_region_CS_SectionDivergent_FreeSection_r1_EnableSection, main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply, main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection, main_region_CS_SectionDivergent_OccupiedSection, main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock, main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection, main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked, main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock, main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked, main_region_CS_Turnout_StraightTurnout, main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight, main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock, main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock, main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight, main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight, main_region_CS_Turnout_DivergentTurnout, main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent, main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock, main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock, main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent, main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent, main_region_CS_Turnout_CheckDivergentBeforeSwitch, main_region_CS_Turnout_BecomesDivergent, main_region_CS_Turnout_CheckStraightBeforeSwitch, main_region_CS_Turnout_BecomesStraight, $NullState$
    };

    private final State[] stateVector = new State[5];

    private int nextStateIndex;

    static {
    }

    public KvStatemachine() {

        sCISections = new SCISectionsImpl();
        sCITurnout = new SCITurnoutImpl();
        sCISectionStraight = new SCISectionStraightImpl();
        sCISectionDivergent = new SCISectionDivergentImpl();
    }

    public void init() {
        for (int i = 0; i < 5; i++) {
            stateVector[i] = State.$NullState$;
        }

        clearEvents();
        clearOutEvents();

        sCITurnout.turnoutId = 0;

        sCITurnout.turnoutSectionId = 0;

        sCITurnout.isOccupied = false;

        sCISectionStraight.sectionId = 0;

        sCISectionDivergent.sectionId = 0;
    }

    public void enter() {
        entryAction();

        nextStateIndex = 0;
        stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;

        nextStateIndex = 1;
        stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;

        nextStateIndex = 2;
        stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
    }

    public void exit() {
        switch (stateVector[0]) {
            case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[1]) {
            case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[2]) {
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_CheckDivergentBeforeSwitch:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_BecomesDivergent:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_CheckStraightBeforeSwitch:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            case main_region_CS_Turnout_BecomesStraight:
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[3]) {
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;
                break;

            default:
                break;
        }

        switch (stateVector[4]) {
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
                break;

            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent:
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;
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
        sectionLockFromDivergent = false;
        sectionLockFromStraight = false;
        passingAllowedFromDivergent = false;
        passingAllowedFromStraight = false;
        passingDeniedFromDivergent = false;
        passingDeniedFromStraight = false;
        dSsectionLockFromStraight = false;
        dSsectionLockFromOtherHalf = false;
        dSremSectionLockFromOtherHalf = false;
        dSremSectionLockFromStraight = false;
        dSremShortSectionLockFromStraight = false;
        dDsectionLockFromDivergent = false;
        dDsectionLockFromOtherHalf = false;
        dDremSectionLockFromOtherHalf = false;
        dDremSectionLockFromDivergent = false;
        dDremShortSectionLockFromDivergent = false;

    }

    /**
     * This method resets the outgoing events.
     */
    private void clearOutEvents() {
        sCISections.clearOutEvents();
        sCITurnout.clearOutEvents();
    }

    /**
     * Returns true if the given state is currently active otherwise false.
     */
    public boolean isStateActive(State state) {
        switch (state) {
            case main_region_CS:
                return stateVector[0].ordinal() >= State.main_region_CS
                        .ordinal()
                        && stateVector[0].ordinal() <= State.main_region_CS_Turnout_BecomesStraight
                        .ordinal();
            case main_region_CS_SectionStraight_FreeSection:
                return stateVector[0].ordinal() >= State.main_region_CS_SectionStraight_FreeSection
                        .ordinal()
                        && stateVector[0].ordinal() <= State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection
                        .ordinal();
            case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                return stateVector[0] == State.main_region_CS_SectionStraight_FreeSection_r1_EnableSection;
            case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                return stateVector[0] == State.main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply;
            case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                return stateVector[0] == State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
            case main_region_CS_SectionStraight_OccupiedSection:
                return stateVector[0].ordinal() >= State.main_region_CS_SectionStraight_OccupiedSection
                        .ordinal()
                        && stateVector[0].ordinal() <= State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked
                        .ordinal();
            case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                return stateVector[0] == State.main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock;
            case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                return stateVector[0] == State.main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection;
            case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                return stateVector[0] == State.main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked;
            case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                return stateVector[0] == State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
            case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                return stateVector[0] == State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
            case main_region_CS_SectionDivergent_FreeSection:
                return stateVector[1].ordinal() >= State.main_region_CS_SectionDivergent_FreeSection
                        .ordinal()
                        && stateVector[1].ordinal() <= State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection
                        .ordinal();
            case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                return stateVector[1] == State.main_region_CS_SectionDivergent_FreeSection_r1_EnableSection;
            case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                return stateVector[1] == State.main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply;
            case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                return stateVector[1] == State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
            case main_region_CS_SectionDivergent_OccupiedSection:
                return stateVector[1].ordinal() >= State.main_region_CS_SectionDivergent_OccupiedSection
                        .ordinal()
                        && stateVector[1].ordinal() <= State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked
                        .ordinal();
            case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                return stateVector[1] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                return stateVector[1] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                return stateVector[1] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                return stateVector[1] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
            case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                return stateVector[1] == State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
            case main_region_CS_Turnout_StraightTurnout:
                return stateVector[2].ordinal() >= State.main_region_CS_Turnout_StraightTurnout
                        .ordinal()
                        && stateVector[2].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight:
                return stateVector[2].ordinal() >= State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight
                        .ordinal()
                        && stateVector[2].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                return stateVector[2] == State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                return stateVector[2] == State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight:
                return stateVector[3].ordinal() >= State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight
                        .ordinal()
                        && stateVector[3].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight:
                return stateVector[4].ordinal() >= State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight
                        .ordinal()
                        && stateVector[4].ordinal() <= State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight
                        .ordinal();
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight;
            case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight:
                return stateVector[4] == State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight;
            case main_region_CS_Turnout_DivergentTurnout:
                return stateVector[2].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout
                        .ordinal()
                        && stateVector[2].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent:
                return stateVector[2].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent
                        .ordinal()
                        && stateVector[2].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                return stateVector[2] == State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                return stateVector[2] == State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent:
                return stateVector[3].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent
                        .ordinal()
                        && stateVector[3].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                return stateVector[3] == State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent:
                return stateVector[4].ordinal() >= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent
                        .ordinal()
                        && stateVector[4].ordinal() <= State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent
                        .ordinal();
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent;
            case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent:
                return stateVector[4] == State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent;
            case main_region_CS_Turnout_CheckDivergentBeforeSwitch:
                return stateVector[2] == State.main_region_CS_Turnout_CheckDivergentBeforeSwitch;
            case main_region_CS_Turnout_BecomesDivergent:
                return stateVector[2] == State.main_region_CS_Turnout_BecomesDivergent;
            case main_region_CS_Turnout_CheckStraightBeforeSwitch:
                return stateVector[2] == State.main_region_CS_Turnout_CheckStraightBeforeSwitch;
            case main_region_CS_Turnout_BecomesStraight:
                return stateVector[2] == State.main_region_CS_Turnout_BecomesStraight;
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

    public SCISectionStraight getSCISectionStraight() {
        return sCISectionStraight;
    }

    public SCISectionDivergent getSCISectionDivergent() {
        return sCISectionDivergent;
    }

    private void raiseLockRequestToDivergent() {
        lockRequestToDivergent = true;
    }

    private void raiseLockRequestToStraight() {
        lockRequestToStraight = true;
    }

    private void raiseSectionAllowedToDivergent() {
        sectionAllowedToDivergent = true;
    }

    private void raiseSectionAllowedToStraight() {
        sectionAllowedToStraight = true;
    }

    private void raiseSectionLockedToStraight() {
        sectionLockedToStraight = true;
    }

    private void raiseSectionLockedToDivergent() {
        sectionLockedToDivergent = true;
    }

    private void raiseSectionLockedWithReplyToStraight() {
        sectionLockedWithReplyToStraight = true;
    }

    private void raiseSectionLockedWithReplyToDivergent() {
        sectionLockedWithReplyToDivergent = true;
    }

    private void raiseSectionLockFromDivergent() {
        sectionLockFromDivergent = true;
    }

    private void raiseSectionLockFromStraight() {
        sectionLockFromStraight = true;
    }

    private void raisePassingAllowedFromDivergent() {
        passingAllowedFromDivergent = true;
    }

    private void raisePassingAllowedFromStraight() {
        passingAllowedFromStraight = true;
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

    private void raiseDSsectionLockFromStraight() {
        dSsectionLockFromStraight = true;
    }

    private void raiseDSsectionLockFromOtherHalf() {
        dSsectionLockFromOtherHalf = true;
    }

    private void raiseDSremSectionLockFromOtherHalf() {
        dSremSectionLockFromOtherHalf = true;
    }

    private void raiseDSremSectionLockFromStraight() {
        dSremSectionLockFromStraight = true;
    }

    private void raiseDSremShortSectionLockFromStraight() {
        dSremShortSectionLockFromStraight = true;
    }

    private void raiseDDsectionLockFromDivergent() {
        dDsectionLockFromDivergent = true;
    }

    private void raiseDDsectionLockFromOtherHalf() {
        dDsectionLockFromOtherHalf = true;
    }

    private void raiseDDremSectionLockFromOtherHalf() {
        dDremSectionLockFromOtherHalf = true;
    }

    private void raiseDDremSectionLockFromDivergent() {
        dDremSectionLockFromDivergent = true;
    }

    private void raiseDDremShortSectionLockFromDivergent() {
        dDremShortSectionLockFromDivergent = true;
    }

    /* Entry action for statechart 'kv'. */
    private void entryAction() {
    }

    /* Exit action for state 'kv'. */
    private void exitAction() {
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionStraight_FreeSection_r1_EnableSection() {
        if (sCISections.straightOccupied) {
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToStraight) {
                sectionLockedWithReplyToStraight = false;

                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                raisePassingAllowedFromStraight();

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply;
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
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
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
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_FreeSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
        } else {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCISections.raiseEnableSection(sCISectionStraight.sectionId);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_EnableSection;
        }
    }

    /* The reactions of state SendSectionLock. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock() {
        if (sCISections.straightFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            if (sectionLockedToStraight) {
                sectionLockedToStraight = false;

                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
            } else {
                if (sectionLockedWithReplyToStraight) {
                    sectionLockedWithReplyToStraight = false;

                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    raisePassingDeniedFromStraight();

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionAllowedToStraight) {
                        sectionAllowedToStraight = false;

                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        sCISections
                                .raiseEnableSection(sCISectionStraight.sectionId);

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection;
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
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock) {
                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (sectionLockedWithReplyToStraight) {
                    sectionLockedWithReplyToStraight = false;

                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;

                    raisePassingDeniedFromStraight();

                    nextStateIndex = 0;
                    stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionLockedToStraight) {
                        sectionLockedToStraight = false;

                        nextStateIndex = 0;
                        stateVector[0] = State.$NullState$;

                        nextStateIndex = 0;
                        stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked;
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
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock || sectionAllowedToStraight) {
                if (sectionAllowedToStraight) {
                    sectionAllowedToStraight = false;
                }

                nextStateIndex = 0;
                stateVector[0] = State.$NullState$;

                nextStateIndex = 0;
                stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock;
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
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            raiseSectionLockFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock;
        }
    }

    /* The reactions of state PreBecomesLocked. */
    private void reactMain_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked() {
        if (sCISections.straightFree) {
            switch (stateVector[0]) {
                case main_region_CS_SectionStraight_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                case main_region_CS_SectionStraight_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 0;
                    stateVector[0] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromStraight();

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 0;
            stateVector[0] = State.$NullState$;

            sCISections.raiseDisableSection(sCISectionStraight.sectionId);

            nextStateIndex = 0;
            stateVector[0] = State.main_region_CS_SectionStraight_OccupiedSection_r1_BecomesLocked;
        }
    }

    /* The reactions of state EnableSection. */
    private void reactMain_region_CS_SectionDivergent_FreeSection_r1_EnableSection() {
        if (sCISections.divergentOccupied) {
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
        } else {
            if (sectionLockedWithReplyToDivergent) {
                sectionLockedWithReplyToDivergent = false;

                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                raisePassingAllowedFromDivergent();

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply;
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
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
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
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_FreeSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_LockedWithReply:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingDeniedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
        } else {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCISections.raiseEnableSection(sCISectionDivergent.sectionId);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_EnableSection;
        }
    }

    /* The reactions of state SendSectionLock. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock() {
        if (sCISections.divergentFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            if (sectionLockedToDivergent) {
                sectionLockedToDivergent = false;

                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
            } else {
                if (sectionLockedWithReplyToDivergent) {
                    sectionLockedWithReplyToDivergent = false;

                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;

                    raisePassingDeniedFromDivergent();

                    nextStateIndex = 1;
                    stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionAllowedToDivergent) {
                        sectionAllowedToDivergent = false;

                        nextStateIndex = 1;
                        stateVector[1] = State.$NullState$;

                        sCISections
                                .raiseEnableSection(
                                        sCISectionDivergent.sectionId);

                        nextStateIndex = 1;
                        stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection;
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
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock) {
                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
            } else {
                if (sectionLockedWithReplyToDivergent) {
                    sectionLockedWithReplyToDivergent = false;

                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;

                    raisePassingDeniedFromDivergent();

                    nextStateIndex = 1;
                    stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
                } else {
                    if (sectionLockedToDivergent) {
                        sectionLockedToDivergent = false;

                        nextStateIndex = 1;
                        stateVector[1] = State.$NullState$;

                        nextStateIndex = 1;
                        stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked;
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
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            if (sCISections.revokeLock || sectionAllowedToDivergent) {
                if (sectionAllowedToDivergent) {
                    sectionAllowedToDivergent = false;
                }

                nextStateIndex = 1;
                stateVector[1] = State.$NullState$;

                nextStateIndex = 1;
                stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock;
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
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            raiseSectionLockFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock;
        }
    }

    /* The reactions of state PreBecomesLocked. */
    private void reactMain_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked() {
        if (sCISections.divergentFree) {
            switch (stateVector[1]) {
                case main_region_CS_SectionDivergent_OccupiedSection_r1_SendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_EnableSection:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreSendSectionLock:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                case main_region_CS_SectionDivergent_OccupiedSection_r1_PreBecomesLocked:
                    nextStateIndex = 1;
                    stateVector[1] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raisePassingAllowedFromDivergent();

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_FreeSection_r1_PreEnableSection;
        } else {
            nextStateIndex = 1;
            stateVector[1] = State.$NullState$;

            sCISections.raiseDisableSection(sCISectionDivergent.sectionId);

            nextStateIndex = 1;
            stateVector[1] = State.main_region_CS_SectionDivergent_OccupiedSection_r1_BecomesLocked;
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[2]) {
                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionLockedWithReplyToDivergent();

            raiseSectionLockedToStraight();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_Turnout_CheckDivergentBeforeSwitch;
        } else {
            if (sectionLockFromStraight) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                raiseDSsectionLockFromStraight();

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
            } else {
                if (sCITurnout.sectionLockFromOtherHalfIN) {
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;

                    raiseDSsectionLockFromOtherHalf();

                    nextStateIndex = 2;
                    stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                } else {
                    if (sCITurnout.remSectionLockFromStraight) {
                        nextStateIndex = 2;
                        stateVector[2] = State.$NullState$;

                        raiseDSremSectionLockFromStraight();

                        nextStateIndex = 2;
                        stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                    } else {
                        if (sCITurnout.remSectionLockFromOtherHalfIN) {
                            nextStateIndex = 2;
                            stateVector[2] = State.$NullState$;

                            raiseDSremSectionLockFromOtherHalf();

                            nextStateIndex = 2;
                            stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                        } else {
                            if (sCITurnout.remShortSectionLockFromStraight) {
                                nextStateIndex = 2;
                                stateVector[2] = State.$NullState$;

                                raiseDSremShortSectionLockFromStraight();

                                nextStateIndex = 2;
                                stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OneLockReceived. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived() {
        if (sCITurnout.turnoutDivergent) {
            switch (stateVector[2]) {
                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_OneLockReceived:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionLockedWithReplyToDivergent();

            raiseSectionLockedToStraight();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_Turnout_CheckDivergentBeforeSwitch;
        } else {
            if (responseFromDescendant) {
                responseFromDescendant = false;

                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromStraight) {
                    raiseSectionLockedToStraight();
                }

                if (sCITurnout.sectionLockFromOtherHalfIN) {
                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();
                }

                if (sCITurnout.remSectionLockFromStraight) {
                    sCISections.raiseRemPassageDeniedToStraight();
                }

                if (sCITurnout.remSectionLockFromOtherHalfIN) {
                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();
                }

                if (sCITurnout.remShortSectionLockFromStraight) {
                    sCISections.raiseRemPassageDeniedToStraight();
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock() {
        if (sCITurnout.remSectionLockFromDivergent) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            raiseSectionLockedWithReplyToDivergent();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
        } else {
            if (sCITurnout.remShortSectionLockFromDivergent) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                raiseSectionLockedWithReplyToDivergent();

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock;
            } else {
                if (sectionLockFromDivergent) {
                    raiseSectionLockedToDivergent();
                }
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithReceivedLock() {
        if (passingAllowedFromDivergent) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCISections.raiseRemPassageAllowedToDivergent();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
        } else {
            if (passingDeniedFromDivergent) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToDivergent();

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromDivergent) {
                    raiseSectionLockedToDivergent();
                }
            }
        }
    }

    /* The reactions of state PreWithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock() {
        nextStateIndex = 3;
        stateVector[3] = State.$NullState$;

        raiseSectionLockedToDivergent();

        nextStateIndex = 3;
        stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_WithoutReceivedLock;
    }

    /* The reactions of state Init. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init() {
        if (dSsectionLockFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            if (sCITurnout.turnoutId == 134) {
                sCITurnout.raiseSectionLockFromOtherHalfOUT();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide;
            } else {
                sCISections.raiseRemPassageRequestToStraight();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout;
            }
        } else {
            if (dSsectionLockFromOtherHalf) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                raiseSectionLockedWithReplyToStraight();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight;
            } else {
                if (dSremSectionLockFromStraight) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        raiseSectionLockedWithReplyToStraight();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight;
                    }
                } else {
                    if (dSremSectionLockFromOtherHalf) {
                        nextStateIndex = 4;
                        stateVector[4] = State.$NullState$;

                        if (sCITurnout.isOccupied) {
                            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                            raiseResponseFromDescendant();

                            nextStateIndex = 4;
                            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                        } else {
                            raiseLockRequestToStraight();

                            nextStateIndex = 4;
                            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight;
                        }
                    } else {
                        if (dSremShortSectionLockFromStraight) {
                            nextStateIndex = 4;
                            stateVector[4] = State.$NullState$;

                            if (sCITurnout.isOccupied) {
                                sCISections.raiseRemPassageDeniedToStraight();

                                raiseResponseFromDescendant();

                                nextStateIndex = 4;
                                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                            } else {
                                raiseLockRequestToStraight();

                                nextStateIndex = 4;
                                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckNeighbourTurnout. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout() {
        if (sCISections.remPassageDeniedFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            raiseSectionLockedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sCISections.remPassageAllowedFromStraight) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCITurnout.raiseSectionLockFromOtherHalfOUT();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide;
            }
        }
    }

    /* The reactions of state CheckOtherSide. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide() {
        if (sCITurnout.passingAllowedFromOtherHalfIN) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            raiseSectionAllowedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sCITurnout.passingDeniedFromOtherHalfIN) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                raiseSectionLockedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            }
        }
    }

    /* The reactions of state CLocalStraight. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight() {
        if (passingDeniedFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingAllowedFromStraight) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                if (sCITurnout.turnoutId == 134) {
                    sCITurnout.raisePassingAllowedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                } else {
                    sCISections.raiseRemPassageRequestToStraight();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout;
                }
            }
        }
    }

    /* The reactions of state CNeighbourTurnout. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout() {
        if (sCISections.remPassageAllowedFromStraight
                || sCISections.remPassageDeniedFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        }
    }

    /* The reactions of state CheckLocalStraight. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            } else {
                if (passingAllowedFromStraight) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        sCITurnout.raiseRemSectionLockFromOtherHalfOUT();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop;
                    }
                }
            }
        }
    }

    /* The reactions of state CheckTop. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (sCITurnout.passingAllowedFromOtherHalfIN) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                if (sCITurnout.isOccupied) {
                    sCISections.raiseRemPassageDeniedToStraight();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                } else {
                    sCISections.raiseRemPassageAllowedToStraight();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                }
            } else {
                if (sCITurnout.passingDeniedFromOtherHalfIN) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCISections.raiseRemPassageDeniedToStraight();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                }
            }
        }
    }

    /* The reactions of state CheckStraight. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight() {
        if (passingDeniedFromStraight) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingAllowedFromStraight) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                if (sCITurnout.isOccupied) {
                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                } else {
                    sCITurnout.raisePassingAllowedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                }
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                }
            }
        }
    }

    /* The reactions of state ShortCheckStraight. */
    private void reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToStraight();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToStraight();

                raiseResponseFromDescendant();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
            } else {
                if (passingAllowedFromStraight) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToStraight();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
                    }
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[2]) {
                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionLockedWithReplyToStraight();

            raiseSectionLockedToDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_Turnout_CheckStraightBeforeSwitch;
        } else {
            if (sectionLockFromDivergent) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                raiseDDsectionLockFromDivergent();

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
            } else {
                if (sCITurnout.sectionLockFromOtherHalfIN) {
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;

                    raiseDDsectionLockFromOtherHalf();

                    nextStateIndex = 2;
                    stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                } else {
                    if (sCITurnout.remSectionLockFromDivergent) {
                        nextStateIndex = 2;
                        stateVector[2] = State.$NullState$;

                        raiseDDremSectionLockFromDivergent();

                        nextStateIndex = 2;
                        stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                    } else {
                        if (sCITurnout.remSectionLockFromOtherHalfIN) {
                            nextStateIndex = 2;
                            stateVector[2] = State.$NullState$;

                            raiseDDremSectionLockFromOtherHalf();

                            nextStateIndex = 2;
                            stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                        } else {
                            if (sCITurnout.remShortSectionLockFromDivergent) {
                                nextStateIndex = 2;
                                stateVector[2] = State.$NullState$;

                                raiseDDremShortSectionLockFromDivergent();

                                nextStateIndex = 2;
                                stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state OneLockReceived. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived() {
        if (sCITurnout.turnoutStraight) {
            switch (stateVector[2]) {
                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_OneLockReceived:
                    nextStateIndex = 2;
                    stateVector[2] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[3]) {
                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock:
                    nextStateIndex = 3;
                    stateVector[3] = State.$NullState$;
                    break;

                default:
                    break;
            }

            switch (stateVector[4]) {
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent:
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;
                    break;

                default:
                    break;
            }

            raiseSectionLockedWithReplyToStraight();

            raiseSectionLockedToDivergent();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_Turnout_CheckStraightBeforeSwitch;
        } else {
            if (responseFromDescendant) {
                responseFromDescendant = false;

                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromDivergent) {
                    raiseSectionLockedToDivergent();
                }

                if (sCITurnout.sectionLockFromOtherHalfIN) {
                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();
                }

                if (sCITurnout.remSectionLockFromDivergent) {
                    sCISections.raiseRemPassageDeniedToDivergent();
                }

                if (sCITurnout.remSectionLockFromOtherHalfIN) {
                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();
                }

                if (sCITurnout.remShortSectionLockFromDivergent) {
                    sCISections.raiseRemPassageDeniedToDivergent();
                }
            }
        }
    }

    /* The reactions of state WithoutReceivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock() {
        if (sCITurnout.remSectionLockFromStraight) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            raiseSectionLockedWithReplyToStraight();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
        } else {
            if (sCITurnout.remShortSectionLockFromStraight) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                raiseSectionLockedWithReplyToStraight();

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock;
            } else {
                if (sectionLockFromStraight) {
                    raiseSectionLockedToStraight();
                }
            }
        }
    }

    /* The reactions of state WithReceivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithReceivedLock() {
        if (passingAllowedFromStraight) {
            nextStateIndex = 3;
            stateVector[3] = State.$NullState$;

            sCISections.raiseRemPassageAllowedToStraight();

            nextStateIndex = 3;
            stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 3;
                stateVector[3] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToStraight();

                nextStateIndex = 3;
                stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
            } else {
                if (sectionLockFromStraight) {
                    raiseSectionLockedToStraight();
                }
            }
        }
    }

    /* The reactions of state PreWithoutRececivedLock. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock() {
        nextStateIndex = 3;
        stateVector[3] = State.$NullState$;

        raiseSectionLockedToStraight();

        nextStateIndex = 3;
        stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_WithoutReceivedLock;
    }

    /* The reactions of state Init. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init() {
        if (dDsectionLockFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            if (sCITurnout.turnoutId == 135) {
                sCITurnout.raiseSectionLockFromOtherHalfOUT();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide;
            } else {
                sCISections.raiseRemPassageRequestToDivergent();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout;
            }
        } else {
            if (dDsectionLockFromOtherHalf) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                raiseSectionLockedWithReplyToDivergent();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent;
            } else {
                if (dDremSectionLockFromDivergent) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        raiseSectionLockedWithReplyToDivergent();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent;
                    }
                } else {
                    if (dDremSectionLockFromOtherHalf) {
                        nextStateIndex = 4;
                        stateVector[4] = State.$NullState$;

                        if (sCITurnout.isOccupied) {
                            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                            raiseResponseFromDescendant();

                            nextStateIndex = 4;
                            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                        } else {
                            raiseLockRequestToDivergent();

                            nextStateIndex = 4;
                            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent;
                        }
                    } else {
                        if (dDremShortSectionLockFromDivergent) {
                            nextStateIndex = 4;
                            stateVector[4] = State.$NullState$;

                            if (sCITurnout.isOccupied) {
                                sCISections.raiseRemPassageDeniedToDivergent();

                                raiseResponseFromDescendant();

                                nextStateIndex = 4;
                                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                            } else {
                                raiseLockRequestToDivergent();

                                nextStateIndex = 4;
                                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent;
                            }
                        }
                    }
                }
            }
        }
    }

    /* The reactions of state CheckNeighbourTurnout. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout() {
        if (sCISections.remPassageDeniedFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            raiseSectionLockedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (sCISections.remPassageAllowedFromDivergent) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCITurnout.raiseSectionLockFromOtherHalfOUT();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide;
            }
        }
    }

    /* The reactions of state CheckOtherSide. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide() {
        if (sCITurnout.passingAllowedFromOtherHalfIN) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            raiseSectionAllowedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (sCITurnout.passingDeniedFromOtherHalfIN) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                raiseSectionLockedToDivergent();

                raiseResponseFromDescendant();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            }
        }
    }

    /* The reactions of state CLocalDivergent. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent() {
        if (passingDeniedFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingAllowedFromDivergent) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                if (sCITurnout.turnoutId == 135) {
                    sCITurnout.raisePassingAllowedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                } else {
                    sCISections.raiseRemPassageRequestToDivergent();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout;
                }
            }
        }
    }

    /* The reactions of state CNeighbourTurnout. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout() {
        if (sCISections.remPassageAllowedFromDivergent
                || sCISections.remPassageDeniedFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        }
    }

    /* The reactions of state CheckLocalDivergent. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingDeniedFromDivergent) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToDivergent();

                raiseResponseFromDescendant();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            } else {
                if (passingAllowedFromDivergent) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        sCITurnout.raiseRemSectionLockFromOtherHalfOUT();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout;
                    }
                }
            }
        }
    }

    /* The reactions of state CheckOtherSideOfTurnout. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (sCITurnout.passingAllowedFromOtherHalfIN) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                if (sCITurnout.isOccupied) {
                    sCISections.raiseRemPassageDeniedToDivergent();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                } else {
                    sCISections.raiseRemPassageAllowedToDivergent();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                }
            } else {
                if (sCITurnout.passingDeniedFromOtherHalfIN) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCISections.raiseRemPassageDeniedToDivergent();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                }
            }
        }
    }

    /* The reactions of state CheckDivergent. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent() {
        if (passingDeniedFromDivergent) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCITurnout.raisePassingDeniedFromOtherHalfOUT();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingAllowedFromDivergent) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                if (sCITurnout.isOccupied) {
                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                } else {
                    sCITurnout.raisePassingAllowedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                }
            } else {
                if (sCITurnout.isOccupied) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                    raiseResponseFromDescendant();

                    nextStateIndex = 4;
                    stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                }
            }
        }
    }

    /* The reactions of state ShortCheckDivergent. */
    private void reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent() {
        if (sCITurnout.isOccupied) {
            nextStateIndex = 4;
            stateVector[4] = State.$NullState$;

            sCISections.raiseRemPassageDeniedToDivergent();

            raiseResponseFromDescendant();

            nextStateIndex = 4;
            stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
        } else {
            if (passingDeniedFromDivergent) {
                nextStateIndex = 4;
                stateVector[4] = State.$NullState$;

                sCISections.raiseRemPassageDeniedToDivergent();

                raiseResponseFromDescendant();

                nextStateIndex = 4;
                stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
            } else {
                if (passingAllowedFromDivergent) {
                    nextStateIndex = 4;
                    stateVector[4] = State.$NullState$;

                    if (sCITurnout.isOccupied) {
                        sCISections.raiseRemPassageDeniedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    } else {
                        sCISections.raiseRemPassageAllowedToDivergent();

                        raiseResponseFromDescendant();

                        nextStateIndex = 4;
                        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
                    }
                }
            }
        }
    }

    /* The reactions of state CheckDivergentBeforeSwitch. */
    private void reactMain_region_CS_Turnout_CheckDivergentBeforeSwitch() {
        if (passingAllowedFromDivergent) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_Turnout_BecomesDivergent;
        } else {
            if (passingDeniedFromDivergent) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_Turnout_BecomesDivergent;
            }
        }
    }

    /* The reactions of state BecomesDivergent. */
    private void reactMain_region_CS_Turnout_BecomesDivergent() {
        nextStateIndex = 2;
        stateVector[2] = State.$NullState$;

        raiseSectionAllowedToDivergent();

        raiseSectionLockedToStraight();

        sCISections.raiseRemPassageDeniedToAll();

        nextStateIndex = 2;
        stateVector[2] = State.main_region_CS_Turnout_DivergentTurnout_r1_DispatchDivergent_r1_WithoutReceivedLock;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_CS_Turnout_DivergentTurnout_r2_HandlerDivergent_r1_PreWithoutRececivedLock;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_Init;
    }

    /* The reactions of state CheckStraightBeforeSwitch. */
    private void reactMain_region_CS_Turnout_CheckStraightBeforeSwitch() {
        if (passingAllowedFromStraight) {
            nextStateIndex = 2;
            stateVector[2] = State.$NullState$;

            sCITurnout.raisePassingAllowedFromOtherHalfOUT();

            nextStateIndex = 2;
            stateVector[2] = State.main_region_CS_Turnout_BecomesStraight;
        } else {
            if (passingDeniedFromStraight) {
                nextStateIndex = 2;
                stateVector[2] = State.$NullState$;

                sCITurnout.raisePassingDeniedFromOtherHalfOUT();

                nextStateIndex = 2;
                stateVector[2] = State.main_region_CS_Turnout_BecomesStraight;
            }
        }
    }

    /* The reactions of state BecomesStraight. */
    private void reactMain_region_CS_Turnout_BecomesStraight() {
        nextStateIndex = 2;
        stateVector[2] = State.$NullState$;

        raiseSectionAllowedToStraight();

        raiseSectionLockedToDivergent();

        sCISections.raiseRemPassageDeniedToAll();

        nextStateIndex = 2;
        stateVector[2] = State.main_region_CS_Turnout_StraightTurnout_r1_DispatchStraight_r1_WithoutReceivedLock;

        nextStateIndex = 3;
        stateVector[3] = State.main_region_CS_Turnout_StraightTurnout_r2_HandlerStraight_r1_PreWithoutReceivedLock;

        nextStateIndex = 4;
        stateVector[4] = State.main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_Init;
    }

    public void runCycle() {

        clearOutEvents();

        for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

            switch (stateVector[nextStateIndex]) {
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
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckNeighbourTurnout();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckOtherSide();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CLocalStraight();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CNeighbourTurnout();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckLocalStraight();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckTop();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_CheckStraight();
                    break;
                case main_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight:
                    reactMain_region_CS_Turnout_StraightTurnout_r3_ProtocolStraight_r1_ShortCheckStraight();
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
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckNeighbourTurnout();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSide();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CLocalDivergent();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CNeighbourTurnout();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckLocalDivergent();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckOtherSideOfTurnout();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_CheckDivergent();
                    break;
                case main_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent:
                    reactMain_region_CS_Turnout_DivergentTurnout_r3_ProtocolDivergent_r1_ShortCheckDivergent();
                    break;
                case main_region_CS_Turnout_CheckDivergentBeforeSwitch:
                    reactMain_region_CS_Turnout_CheckDivergentBeforeSwitch();
                    break;
                case main_region_CS_Turnout_BecomesDivergent:
                    reactMain_region_CS_Turnout_BecomesDivergent();
                    break;
                case main_region_CS_Turnout_CheckStraightBeforeSwitch:
                    reactMain_region_CS_Turnout_CheckStraightBeforeSwitch();
                    break;
                case main_region_CS_Turnout_BecomesStraight:
                    reactMain_region_CS_Turnout_BecomesStraight();
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
