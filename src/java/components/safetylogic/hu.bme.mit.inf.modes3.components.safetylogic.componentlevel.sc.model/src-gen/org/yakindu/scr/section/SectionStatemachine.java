package org.yakindu.scr.section;
import java.util.LinkedList;
import java.util.List;

public class SectionStatemachine implements ISectionStatemachine {

	protected class SCISectionImpl implements SCISection {
	
		private long latestReserveDirection;
		
		public long getLatestReserveDirection() {
			return latestReserveDirection;
		}
		
		public void setLatestReserveDirection(long value) {
			this.latestReserveDirection = value;
		}
		
	}
	
	protected SCISectionImpl sCISection;
	
	protected class SCISectionControlProvidedImpl implements SCISectionControlProvided {
	
		private List<SCISectionControlProvidedListener> listeners = new LinkedList<SCISectionControlProvidedListener>();
		
		public List<SCISectionControlProvidedListener> getListeners() {
			return listeners;
		}
		private boolean restartProtocol;
		
		public void raiseRestartProtocol() {
			restartProtocol = true;
		}
		
		private boolean enableSection;
		
		public boolean isRaisedEnableSection() {
			return enableSection;
		}
		
		protected void raiseEnableSection() {
			enableSection = true;
			for (SCISectionControlProvidedListener listener : listeners) {
				listener.onEnableSectionRaised();
			}
		}
		
		private boolean disableSection;
		
		public boolean isRaisedDisableSection() {
			return disableSection;
		}
		
		protected void raiseDisableSection() {
			disableSection = true;
			for (SCISectionControlProvidedListener listener : listeners) {
				listener.onDisableSectionRaised();
			}
		}
		
		protected void clearEvents() {
			restartProtocol = false;
		}
		protected void clearOutEvents() {
		
		enableSection = false;
		disableSection = false;
		}
		
	}
	
	protected SCISectionControlProvidedImpl sCISectionControlProvided;
	
	protected class SCIProtocolProvidedCWImpl implements SCIProtocolProvidedCW {
	
		private boolean reserve;
		
		public void raiseReserve() {
			reserve = true;
		}
		
		private boolean canGo;
		
		public void raiseCanGo() {
			canGo = true;
		}
		
		private boolean cannotGo;
		
		public void raiseCannotGo() {
			cannotGo = true;
		}
		
		private boolean release;
		
		public void raiseRelease() {
			release = true;
		}
		
		protected void clearEvents() {
			reserve = false;
			canGo = false;
			cannotGo = false;
			release = false;
		}
	}
	
	protected SCIProtocolProvidedCWImpl sCIProtocolProvidedCW;
	
	protected class SCIProtocolProvidedCCWImpl implements SCIProtocolProvidedCCW {
	
		private boolean reserve;
		
		public void raiseReserve() {
			reserve = true;
		}
		
		private boolean canGo;
		
		public void raiseCanGo() {
			canGo = true;
		}
		
		private boolean cannotGo;
		
		public void raiseCannotGo() {
			cannotGo = true;
		}
		
		private boolean release;
		
		public void raiseRelease() {
			release = true;
		}
		
		protected void clearEvents() {
			reserve = false;
			canGo = false;
			cannotGo = false;
			release = false;
		}
	}
	
	protected SCIProtocolProvidedCCWImpl sCIProtocolProvidedCCW;
	
	protected class SCIProtocolRequiredCWImpl implements SCIProtocolRequiredCW {
	
		private List<SCIProtocolRequiredCWListener> listeners = new LinkedList<SCIProtocolRequiredCWListener>();
		
		public List<SCIProtocolRequiredCWListener> getListeners() {
			return listeners;
		}
		private boolean reserve;
		
		public boolean isRaisedReserve() {
			return reserve;
		}
		
		protected void raiseReserve() {
			reserve = true;
			for (SCIProtocolRequiredCWListener listener : listeners) {
				listener.onReserveRaised();
			}
		}
		
		private boolean canGo;
		
		public boolean isRaisedCanGo() {
			return canGo;
		}
		
		protected void raiseCanGo() {
			canGo = true;
			for (SCIProtocolRequiredCWListener listener : listeners) {
				listener.onCanGoRaised();
			}
		}
		
		private boolean cannotGo;
		
		public boolean isRaisedCannotGo() {
			return cannotGo;
		}
		
		protected void raiseCannotGo() {
			cannotGo = true;
			for (SCIProtocolRequiredCWListener listener : listeners) {
				listener.onCannotGoRaised();
			}
		}
		
		private boolean release;
		
		public boolean isRaisedRelease() {
			return release;
		}
		
		protected void raiseRelease() {
			release = true;
			for (SCIProtocolRequiredCWListener listener : listeners) {
				listener.onReleaseRaised();
			}
		}
		
		protected void clearEvents() {
		}
		protected void clearOutEvents() {
		
		reserve = false;
		canGo = false;
		cannotGo = false;
		release = false;
		}
		
	}
	
	protected SCIProtocolRequiredCWImpl sCIProtocolRequiredCW;
	
	protected class SCIProtocolRequiredCCWImpl implements SCIProtocolRequiredCCW {
	
		private List<SCIProtocolRequiredCCWListener> listeners = new LinkedList<SCIProtocolRequiredCCWListener>();
		
		public List<SCIProtocolRequiredCCWListener> getListeners() {
			return listeners;
		}
		private boolean reserve;
		
		public boolean isRaisedReserve() {
			return reserve;
		}
		
		protected void raiseReserve() {
			reserve = true;
			for (SCIProtocolRequiredCCWListener listener : listeners) {
				listener.onReserveRaised();
			}
		}
		
		private boolean canGo;
		
		public boolean isRaisedCanGo() {
			return canGo;
		}
		
		protected void raiseCanGo() {
			canGo = true;
			for (SCIProtocolRequiredCCWListener listener : listeners) {
				listener.onCanGoRaised();
			}
		}
		
		private boolean cannotGo;
		
		public boolean isRaisedCannotGo() {
			return cannotGo;
		}
		
		protected void raiseCannotGo() {
			cannotGo = true;
			for (SCIProtocolRequiredCCWListener listener : listeners) {
				listener.onCannotGoRaised();
			}
		}
		
		private boolean release;
		
		public boolean isRaisedRelease() {
			return release;
		}
		
		protected void raiseRelease() {
			release = true;
			for (SCIProtocolRequiredCCWListener listener : listeners) {
				listener.onReleaseRaised();
			}
		}
		
		protected void clearEvents() {
		}
		protected void clearOutEvents() {
		
		reserve = false;
		canGo = false;
		cannotGo = false;
		release = false;
		}
		
	}
	
	protected SCIProtocolRequiredCCWImpl sCIProtocolRequiredCCW;
	
	protected class SCITrainProvidedImpl implements SCITrainProvided {
	
		private boolean occupy;
		
		public void raiseOccupy() {
			occupy = true;
		}
		
		private boolean unoccupy;
		
		public void raiseUnoccupy() {
			unoccupy = true;
		}
		
		protected void clearEvents() {
			occupy = false;
			unoccupy = false;
		}
	}
	
	protected SCITrainProvidedImpl sCITrainProvided;
	
	protected class SCIDirectionImpl implements SCIDirection {
	
		public long getCW() {
			return cW;
		}
		
		public long getCCW() {
			return cCW;
		}
		
		public long getUNSPECIFIED() {
			return uNSPECIFIED;
		}
		
	}
	
	protected SCIDirectionImpl sCIDirection;
	
	private boolean initialized = false;
	
	public enum State {
		main_Free,
		main_Reserved,
		main_Occupied,
		main_Stop,
		main_Locking_protocol,
		main_Locking_protocol_inner_region_WaitForFirstResponse,
		main_Locking_protocol_inner_region_WaitForSecondResponse,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	
	public SectionStatemachine() {
		sCISection = new SCISectionImpl();
		sCISectionControlProvided = new SCISectionControlProvidedImpl();
		sCIProtocolProvidedCW = new SCIProtocolProvidedCWImpl();
		sCIProtocolProvidedCCW = new SCIProtocolProvidedCCWImpl();
		sCIProtocolRequiredCW = new SCIProtocolRequiredCWImpl();
		sCIProtocolRequiredCCW = new SCIProtocolRequiredCCWImpl();
		sCITrainProvided = new SCITrainProvidedImpl();
		sCIDirection = new SCIDirectionImpl();
	}
	
	public void init() {
		this.initialized = true;
		
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCISection.setLatestReserveDirection(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
	
		enterSequence_main_default();
	}
	
	public void exit() {
		exitSequence_main();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCISectionControlProvided.clearEvents();
		sCIProtocolProvidedCW.clearEvents();
		sCIProtocolProvidedCCW.clearEvents();
		sCIProtocolRequiredCW.clearEvents();
		sCIProtocolRequiredCCW.clearEvents();
		sCITrainProvided.clearEvents();
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
		sCISectionControlProvided.clearOutEvents();
		sCIProtocolRequiredCW.clearOutEvents();
		sCIProtocolRequiredCCW.clearOutEvents();
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_Free:
			return stateVector[0] == State.main_Free;
		case main_Reserved:
			return stateVector[0] == State.main_Reserved;
		case main_Occupied:
			return stateVector[0] == State.main_Occupied;
		case main_Stop:
			return stateVector[0] == State.main_Stop;
		case main_Locking_protocol:
			return stateVector[0].ordinal() >= State.
					main_Locking_protocol.ordinal()&& stateVector[0].ordinal() <= State.main_Locking_protocol_inner_region_WaitForSecondResponse.ordinal();
		case main_Locking_protocol_inner_region_WaitForFirstResponse:
			return stateVector[0] == State.main_Locking_protocol_inner_region_WaitForFirstResponse;
		case main_Locking_protocol_inner_region_WaitForSecondResponse:
			return stateVector[0] == State.main_Locking_protocol_inner_region_WaitForSecondResponse;
		default:
			return false;
		}
	}
	
	public SCISection getSCISection() {
		return sCISection;
	}
	
	public SCISectionControlProvided getSCISectionControlProvided() {
		return sCISectionControlProvided;
	}
	
	public SCIProtocolProvidedCW getSCIProtocolProvidedCW() {
		return sCIProtocolProvidedCW;
	}
	
	public SCIProtocolProvidedCCW getSCIProtocolProvidedCCW() {
		return sCIProtocolProvidedCCW;
	}
	
	public SCIProtocolRequiredCW getSCIProtocolRequiredCW() {
		return sCIProtocolRequiredCW;
	}
	
	public SCIProtocolRequiredCCW getSCIProtocolRequiredCCW() {
		return sCIProtocolRequiredCCW;
	}
	
	public SCITrainProvided getSCITrainProvided() {
		return sCITrainProvided;
	}
	
	public SCIDirection getSCIDirection() {
		return sCIDirection;
	}
	
	private boolean check_main_Free_tr0_tr0() {
		return sCIProtocolProvidedCW.reserve;
	}
	
	private boolean check_main_Free_tr1_tr1() {
		return sCIProtocolProvidedCCW.reserve;
	}
	
	private boolean check_main_Free_tr2_tr2() {
		return sCITrainProvided.occupy;
	}
	
	private boolean check_main_Reserved_lr0_lr0() {
		return (sCIProtocolProvidedCW.reserve) && (sCIDirection.getCW()==sCISection.getLatestReserveDirection());
	}
	
	private boolean check_main_Reserved_lr1_lr1() {
		return (sCIProtocolProvidedCCW.reserve) && (sCIDirection.getCCW()==sCISection.getLatestReserveDirection());
	}
	
	private boolean check_main_Reserved_lr2_lr2() {
		return (sCIProtocolProvidedCW.reserve) && (sCIDirection.getCW()!=sCISection.getLatestReserveDirection());
	}
	
	private boolean check_main_Reserved_lr3_lr3() {
		return (sCIProtocolProvidedCCW.reserve) && (sCIDirection.getCCW()!=sCISection.getLatestReserveDirection());
	}
	
	private boolean check_main_Reserved_tr0_tr0() {
		return sCITrainProvided.occupy;
	}
	
	private boolean check_main_Reserved_tr1_tr1() {
		return (sCIProtocolProvidedCW.release) && (sCIDirection.getCW()==sCISection.getLatestReserveDirection());
	}
	
	private boolean check_main_Reserved_tr2_tr2() {
		return (sCIProtocolProvidedCCW.release) && (sCIDirection.getCCW()==sCISection.getLatestReserveDirection());
	}
	
	private boolean check_main_Occupied_lr1_lr1() {
		return sCIProtocolProvidedCW.reserve;
	}
	
	private boolean check_main_Occupied_lr2_lr2() {
		return sCIProtocolProvidedCCW.reserve;
	}
	
	private boolean check_main_Occupied_lr3_lr3() {
		return sCIProtocolProvidedCCW.release;
	}
	
	private boolean check_main_Occupied_lr4_lr4() {
		return sCIProtocolProvidedCW.release;
	}
	
	private boolean check_main_Occupied_tr0_tr0() {
		return sCITrainProvided.unoccupy;
	}
	
	private boolean check_main_Occupied_tr1_tr1() {
		return sCIProtocolProvidedCCW.cannotGo;
	}
	
	private boolean check_main_Occupied_tr2_tr2() {
		return sCIProtocolProvidedCW.cannotGo;
	}
	
	private boolean check_main_Stop_lr1_lr1() {
		return sCIProtocolProvidedCW.reserve;
	}
	
	private boolean check_main_Stop_lr2_lr2() {
		return sCIProtocolProvidedCCW.reserve;
	}
	
	private boolean check_main_Stop_tr0_tr0() {
		return sCITrainProvided.unoccupy;
	}
	
	private boolean check_main_Stop_tr1_tr1() {
		return sCIProtocolProvidedCCW.release;
	}
	
	private boolean check_main_Stop_tr2_tr2() {
		return sCIProtocolProvidedCW.release;
	}
	
	private boolean check_main_Stop_tr3_tr3() {
		return sCISectionControlProvided.restartProtocol;
	}
	
	private boolean check_main_Locking_protocol_tr0_tr0() {
		return sCIProtocolProvidedCW.reserve;
	}
	
	private boolean check_main_Locking_protocol_tr1_tr1() {
		return sCIProtocolProvidedCCW.reserve;
	}
	
	private boolean check_main_Locking_protocol_tr2_tr2() {
		return sCITrainProvided.unoccupy;
	}
	
	private boolean check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0_tr0() {
		return sCIProtocolProvidedCW.canGo;
	}
	
	private boolean check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1_tr1() {
		return sCIProtocolProvidedCW.cannotGo;
	}
	
	private boolean check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0_tr0() {
		return sCIProtocolProvidedCCW.canGo;
	}
	
	private boolean check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1_tr1() {
		return sCIProtocolProvidedCCW.cannotGo;
	}
	
	private void effect_main_Free_tr0() {
		exitSequence_main_Free();
		sCIProtocolRequiredCW.raiseCanGo();
		
		sCISection.setLatestReserveDirection(SCIDirection.cW);
		
		enterSequence_main_Reserved_default();
	}
	
	private void effect_main_Free_tr1() {
		exitSequence_main_Free();
		sCIProtocolRequiredCCW.raiseCanGo();
		
		sCISection.setLatestReserveDirection(SCIDirection.cCW);
		
		enterSequence_main_Reserved_default();
	}
	
	private void effect_main_Free_tr2() {
		exitSequence_main_Free();
		enterSequence_main_Locking_protocol_default();
	}
	
	private void effect_main_Reserved_lr0_lr0() {
		sCIProtocolRequiredCW.raiseCanGo();
	}
	
	private void effect_main_Reserved_lr1_lr1() {
		sCIProtocolRequiredCCW.raiseCanGo();
	}
	
	private void effect_main_Reserved_lr2_lr2() {
		sCIProtocolRequiredCW.raiseCannotGo();
	}
	
	private void effect_main_Reserved_lr3_lr3() {
		sCIProtocolRequiredCCW.raiseCannotGo();
	}
	
	private void effect_main_Reserved_tr0() {
		exitSequence_main_Reserved();
		enterSequence_main_Locking_protocol_default();
	}
	
	private void effect_main_Reserved_tr1() {
		exitSequence_main_Reserved();
		enterSequence_main_Free_default();
	}
	
	private void effect_main_Reserved_tr2() {
		exitSequence_main_Reserved();
		enterSequence_main_Free_default();
	}
	
	private void effect_main_Occupied_lr1_lr1() {
		sCIProtocolRequiredCW.raiseCanGo();
	}
	
	private void effect_main_Occupied_lr2_lr2() {
		sCIProtocolRequiredCCW.raiseCanGo();
	}
	
	private void effect_main_Occupied_lr3_lr3() {
		sCIProtocolRequiredCCW.raiseReserve();
	}
	
	private void effect_main_Occupied_lr4_lr4() {
		sCIProtocolRequiredCW.raiseReserve();
	}
	
	private void effect_main_Occupied_tr0() {
		exitSequence_main_Occupied();
		sCIProtocolRequiredCW.raiseRelease();
		
		sCIProtocolRequiredCCW.raiseRelease();
		
		enterSequence_main_Free_default();
	}
	
	private void effect_main_Occupied_tr1() {
		exitSequence_main_Occupied();
		enterSequence_main_Stop_default();
	}
	
	private void effect_main_Occupied_tr2() {
		exitSequence_main_Occupied();
		enterSequence_main_Stop_default();
	}
	
	private void effect_main_Stop_lr1_lr1() {
		sCIProtocolRequiredCW.raiseCannotGo();
	}
	
	private void effect_main_Stop_lr2_lr2() {
		sCIProtocolRequiredCCW.raiseCannotGo();
	}
	
	private void effect_main_Stop_tr0() {
		exitSequence_main_Stop();
		sCIProtocolRequiredCW.raiseRelease();
		
		sCIProtocolRequiredCCW.raiseRelease();
		
		enterSequence_main_Free_default();
	}
	
	private void effect_main_Stop_tr1() {
		exitSequence_main_Stop();
		enterSequence_main_Locking_protocol_default();
	}
	
	private void effect_main_Stop_tr2() {
		exitSequence_main_Stop();
		enterSequence_main_Locking_protocol_default();
	}
	
	private void effect_main_Stop_tr3() {
		exitSequence_main_Stop();
		enterSequence_main_Locking_protocol_default();
	}
	
	private void effect_main_Locking_protocol_tr0() {
		exitSequence_main_Locking_protocol();
		sCIProtocolRequiredCW.raiseCannotGo();
		
		enterSequence_main_Stop_default();
	}
	
	private void effect_main_Locking_protocol_tr1() {
		exitSequence_main_Locking_protocol();
		sCIProtocolRequiredCCW.raiseCannotGo();
		
		enterSequence_main_Stop_default();
	}
	
	private void effect_main_Locking_protocol_tr2() {
		exitSequence_main_Locking_protocol();
		enterSequence_main_Free_default();
	}
	
	private void effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0() {
		exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse();
		enterSequence_main_Locking_protocol_inner_region_WaitForSecondResponse_default();
	}
	
	private void effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1() {
		exitSequence_main_Locking_protocol();
		enterSequence_main_Stop_default();
	}
	
	private void effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0() {
		exitSequence_main_Locking_protocol();
		enterSequence_main_Occupied_default();
	}
	
	private void effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1() {
		exitSequence_main_Locking_protocol();
		enterSequence_main_Stop_default();
	}
	
	/* Entry action for state 'Free'. */
	private void entryAction_main_Free() {
		sCISectionControlProvided.raiseEnableSection();
		
		sCISection.setLatestReserveDirection(SCIDirection.uNSPECIFIED);
	}
	
	/* Entry action for state 'Occupied'. */
	private void entryAction_main_Occupied() {
		sCISectionControlProvided.raiseEnableSection();
	}
	
	/* Entry action for state 'Stop'. */
	private void entryAction_main_Stop() {
		sCISectionControlProvided.raiseDisableSection();
	}
	
	/* Entry action for state 'WaitForFirstResponse'. */
	private void entryAction_main_Locking_protocol_inner_region_WaitForFirstResponse() {
		sCIProtocolRequiredCW.raiseReserve();
	}
	
	/* Entry action for state 'WaitForSecondResponse'. */
	private void entryAction_main_Locking_protocol_inner_region_WaitForSecondResponse() {
		sCIProtocolRequiredCCW.raiseReserve();
	}
	
	/* 'default' enter sequence for state Free */
	private void enterSequence_main_Free_default() {
		entryAction_main_Free();
		nextStateIndex = 0;
		stateVector[0] = State.main_Free;
	}
	
	/* 'default' enter sequence for state Reserved */
	private void enterSequence_main_Reserved_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_Reserved;
	}
	
	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_Occupied_default() {
		entryAction_main_Occupied();
		nextStateIndex = 0;
		stateVector[0] = State.main_Occupied;
	}
	
	/* 'default' enter sequence for state Stop */
	private void enterSequence_main_Stop_default() {
		entryAction_main_Stop();
		nextStateIndex = 0;
		stateVector[0] = State.main_Stop;
	}
	
	/* 'default' enter sequence for state Locking protocol */
	private void enterSequence_main_Locking_protocol_default() {
		enterSequence_main_Locking_protocol_inner_region_default();
	}
	
	/* 'default' enter sequence for state WaitForFirstResponse */
	private void enterSequence_main_Locking_protocol_inner_region_WaitForFirstResponse_default() {
		entryAction_main_Locking_protocol_inner_region_WaitForFirstResponse();
		nextStateIndex = 0;
		stateVector[0] = State.main_Locking_protocol_inner_region_WaitForFirstResponse;
	}
	
	/* 'default' enter sequence for state WaitForSecondResponse */
	private void enterSequence_main_Locking_protocol_inner_region_WaitForSecondResponse_default() {
		entryAction_main_Locking_protocol_inner_region_WaitForSecondResponse();
		nextStateIndex = 0;
		stateVector[0] = State.main_Locking_protocol_inner_region_WaitForSecondResponse;
	}
	
	/* 'default' enter sequence for region main */
	private void enterSequence_main_default() {
		react_main__entry_Default();
	}
	
	/* 'default' enter sequence for region inner region */
	private void enterSequence_main_Locking_protocol_inner_region_default() {
		react_main_Locking_protocol_inner_region__entry_Default();
	}
	
	/* Default exit sequence for state Free */
	private void exitSequence_main_Free() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Reserved */
	private void exitSequence_main_Reserved() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Occupied */
	private void exitSequence_main_Occupied() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Stop */
	private void exitSequence_main_Stop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Locking protocol */
	private void exitSequence_main_Locking_protocol() {
		exitSequence_main_Locking_protocol_inner_region();
	}
	
	/* Default exit sequence for state WaitForFirstResponse */
	private void exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state WaitForSecondResponse */
	private void exitSequence_main_Locking_protocol_inner_region_WaitForSecondResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main */
	private void exitSequence_main() {
		switch (stateVector[0]) {
		case main_Free:
			exitSequence_main_Free();
			break;
		case main_Reserved:
			exitSequence_main_Reserved();
			break;
		case main_Occupied:
			exitSequence_main_Occupied();
			break;
		case main_Stop:
			exitSequence_main_Stop();
			break;
		case main_Locking_protocol_inner_region_WaitForFirstResponse:
			exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse();
			break;
		case main_Locking_protocol_inner_region_WaitForSecondResponse:
			exitSequence_main_Locking_protocol_inner_region_WaitForSecondResponse();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region inner region */
	private void exitSequence_main_Locking_protocol_inner_region() {
		switch (stateVector[0]) {
		case main_Locking_protocol_inner_region_WaitForFirstResponse:
			exitSequence_main_Locking_protocol_inner_region_WaitForFirstResponse();
			break;
		case main_Locking_protocol_inner_region_WaitForSecondResponse:
			exitSequence_main_Locking_protocol_inner_region_WaitForSecondResponse();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Free. */
	private void react_main_Free() {
		if (check_main_Free_tr0_tr0()) {
			effect_main_Free_tr0();
		} else {
			if (check_main_Free_tr1_tr1()) {
				effect_main_Free_tr1();
			} else {
				if (check_main_Free_tr2_tr2()) {
					effect_main_Free_tr2();
				}
			}
		}
	}
	
	/* The reactions of state Reserved. */
	private void react_main_Reserved() {
		if (check_main_Reserved_tr0_tr0()) {
			effect_main_Reserved_tr0();
		} else {
			if (check_main_Reserved_tr1_tr1()) {
				effect_main_Reserved_tr1();
			} else {
				if (check_main_Reserved_tr2_tr2()) {
					effect_main_Reserved_tr2();
				} else {
					if (check_main_Reserved_lr0_lr0()) {
						effect_main_Reserved_lr0_lr0();
					}
					if (check_main_Reserved_lr1_lr1()) {
						effect_main_Reserved_lr1_lr1();
					}
					if (check_main_Reserved_lr2_lr2()) {
						effect_main_Reserved_lr2_lr2();
					}
					if (check_main_Reserved_lr3_lr3()) {
						effect_main_Reserved_lr3_lr3();
					}
				}
			}
		}
	}
	
	/* The reactions of state Occupied. */
	private void react_main_Occupied() {
		if (check_main_Occupied_tr0_tr0()) {
			effect_main_Occupied_tr0();
		} else {
			if (check_main_Occupied_tr1_tr1()) {
				effect_main_Occupied_tr1();
			} else {
				if (check_main_Occupied_tr2_tr2()) {
					effect_main_Occupied_tr2();
				} else {
					if (check_main_Occupied_lr1_lr1()) {
						effect_main_Occupied_lr1_lr1();
					}
					if (check_main_Occupied_lr2_lr2()) {
						effect_main_Occupied_lr2_lr2();
					}
					if (check_main_Occupied_lr3_lr3()) {
						effect_main_Occupied_lr3_lr3();
					}
					if (check_main_Occupied_lr4_lr4()) {
						effect_main_Occupied_lr4_lr4();
					}
				}
			}
		}
	}
	
	/* The reactions of state Stop. */
	private void react_main_Stop() {
		if (check_main_Stop_tr0_tr0()) {
			effect_main_Stop_tr0();
		} else {
			if (check_main_Stop_tr1_tr1()) {
				effect_main_Stop_tr1();
			} else {
				if (check_main_Stop_tr2_tr2()) {
					effect_main_Stop_tr2();
				} else {
					if (check_main_Stop_tr3_tr3()) {
						effect_main_Stop_tr3();
					} else {
						if (check_main_Stop_lr1_lr1()) {
							effect_main_Stop_lr1_lr1();
						}
						if (check_main_Stop_lr2_lr2()) {
							effect_main_Stop_lr2_lr2();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state WaitForFirstResponse. */
	private void react_main_Locking_protocol_inner_region_WaitForFirstResponse() {
		if (check_main_Locking_protocol_tr0_tr0()) {
			effect_main_Locking_protocol_tr0();
		} else {
			if (check_main_Locking_protocol_tr1_tr1()) {
				effect_main_Locking_protocol_tr1();
			} else {
				if (check_main_Locking_protocol_tr2_tr2()) {
					effect_main_Locking_protocol_tr2();
				} else {
					if (check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0_tr0()) {
						effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr0();
					} else {
						if (check_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1_tr1()) {
							effect_main_Locking_protocol_inner_region_WaitForFirstResponse_tr1();
						}
					}
				}
			}
		}
	}
	
	/* The reactions of state WaitForSecondResponse. */
	private void react_main_Locking_protocol_inner_region_WaitForSecondResponse() {
		if (check_main_Locking_protocol_tr0_tr0()) {
			effect_main_Locking_protocol_tr0();
		} else {
			if (check_main_Locking_protocol_tr1_tr1()) {
				effect_main_Locking_protocol_tr1();
			} else {
				if (check_main_Locking_protocol_tr2_tr2()) {
					effect_main_Locking_protocol_tr2();
				} else {
					if (check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0_tr0()) {
						effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr0();
					} else {
						if (check_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1_tr1()) {
							effect_main_Locking_protocol_inner_region_WaitForSecondResponse_tr1();
						}
					}
				}
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main__entry_Default() {
		enterSequence_main_Free_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_Locking_protocol_inner_region__entry_Default() {
		enterSequence_main_Locking_protocol_inner_region_WaitForFirstResponse_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_Free:
				react_main_Free();
				break;
			case main_Reserved:
				react_main_Reserved();
				break;
			case main_Occupied:
				react_main_Occupied();
				break;
			case main_Stop:
				react_main_Stop();
				break;
			case main_Locking_protocol_inner_region_WaitForFirstResponse:
				react_main_Locking_protocol_inner_region_WaitForFirstResponse();
				break;
			case main_Locking_protocol_inner_region_WaitForSecondResponse:
				react_main_Locking_protocol_inner_region_WaitForSecondResponse();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
