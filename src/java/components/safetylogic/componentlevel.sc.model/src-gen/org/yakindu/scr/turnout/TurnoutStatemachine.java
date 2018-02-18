package org.yakindu.scr.turnout;
import java.util.LinkedList;
import java.util.List;

public class TurnoutStatemachine implements ITurnoutStatemachine {

	protected class SCITurnoutControlProvidedImpl implements SCITurnoutControlProvided {
	
		private boolean turnoutStraight;
		
		public void raiseTurnoutStraight() {
			turnoutStraight = true;
		}
		
		private boolean turnoutDivergent;
		
		public void raiseTurnoutDivergent() {
			turnoutDivergent = true;
		}
		
		protected void clearEvents() {
			turnoutStraight = false;
			turnoutDivergent = false;
		}
	}
	
	protected SCITurnoutControlProvidedImpl sCITurnoutControlProvided;
	
	protected class SCIProtocolProvidedTopImpl implements SCIProtocolProvidedTop {
	
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
	
	protected SCIProtocolProvidedTopImpl sCIProtocolProvidedTop;
	
	protected class SCIProtocolRequiredTopImpl implements SCIProtocolRequiredTop {
	
		private List<SCIProtocolRequiredTopListener> listeners = new LinkedList<SCIProtocolRequiredTopListener>();
		
		public List<SCIProtocolRequiredTopListener> getListeners() {
			return listeners;
		}
		private boolean reserve;
		
		public boolean isRaisedReserve() {
			return reserve;
		}
		
		protected void raiseReserve() {
			reserve = true;
			for (SCIProtocolRequiredTopListener listener : listeners) {
				listener.onReserveRaised();
			}
		}
		
		private boolean canGo;
		
		public boolean isRaisedCanGo() {
			return canGo;
		}
		
		protected void raiseCanGo() {
			canGo = true;
			for (SCIProtocolRequiredTopListener listener : listeners) {
				listener.onCanGoRaised();
			}
		}
		
		private boolean cannotGo;
		
		public boolean isRaisedCannotGo() {
			return cannotGo;
		}
		
		protected void raiseCannotGo() {
			cannotGo = true;
			for (SCIProtocolRequiredTopListener listener : listeners) {
				listener.onCannotGoRaised();
			}
		}
		
		private boolean release;
		
		public boolean isRaisedRelease() {
			return release;
		}
		
		protected void raiseRelease() {
			release = true;
			for (SCIProtocolRequiredTopListener listener : listeners) {
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
	
	protected SCIProtocolRequiredTopImpl sCIProtocolRequiredTop;
	
	protected class SCIProtocolProvidedStraightImpl implements SCIProtocolProvidedStraight {
	
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
	
	protected SCIProtocolProvidedStraightImpl sCIProtocolProvidedStraight;
	
	protected class SCIProtocolRequiredStraightImpl implements SCIProtocolRequiredStraight {
	
		private List<SCIProtocolRequiredStraightListener> listeners = new LinkedList<SCIProtocolRequiredStraightListener>();
		
		public List<SCIProtocolRequiredStraightListener> getListeners() {
			return listeners;
		}
		private boolean reserve;
		
		public boolean isRaisedReserve() {
			return reserve;
		}
		
		protected void raiseReserve() {
			reserve = true;
			for (SCIProtocolRequiredStraightListener listener : listeners) {
				listener.onReserveRaised();
			}
		}
		
		private boolean canGo;
		
		public boolean isRaisedCanGo() {
			return canGo;
		}
		
		protected void raiseCanGo() {
			canGo = true;
			for (SCIProtocolRequiredStraightListener listener : listeners) {
				listener.onCanGoRaised();
			}
		}
		
		private boolean cannotGo;
		
		public boolean isRaisedCannotGo() {
			return cannotGo;
		}
		
		protected void raiseCannotGo() {
			cannotGo = true;
			for (SCIProtocolRequiredStraightListener listener : listeners) {
				listener.onCannotGoRaised();
			}
		}
		
		private boolean release;
		
		public boolean isRaisedRelease() {
			return release;
		}
		
		protected void raiseRelease() {
			release = true;
			for (SCIProtocolRequiredStraightListener listener : listeners) {
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
	
	protected SCIProtocolRequiredStraightImpl sCIProtocolRequiredStraight;
	
	protected class SCIProtocolProvidedDivergentImpl implements SCIProtocolProvidedDivergent {
	
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
	
	protected SCIProtocolProvidedDivergentImpl sCIProtocolProvidedDivergent;
	
	protected class SCIProtocolRequiredDivergentImpl implements SCIProtocolRequiredDivergent {
	
		private List<SCIProtocolRequiredDivergentListener> listeners = new LinkedList<SCIProtocolRequiredDivergentListener>();
		
		public List<SCIProtocolRequiredDivergentListener> getListeners() {
			return listeners;
		}
		private boolean reserve;
		
		public boolean isRaisedReserve() {
			return reserve;
		}
		
		protected void raiseReserve() {
			reserve = true;
			for (SCIProtocolRequiredDivergentListener listener : listeners) {
				listener.onReserveRaised();
			}
		}
		
		private boolean canGo;
		
		public boolean isRaisedCanGo() {
			return canGo;
		}
		
		protected void raiseCanGo() {
			canGo = true;
			for (SCIProtocolRequiredDivergentListener listener : listeners) {
				listener.onCanGoRaised();
			}
		}
		
		private boolean cannotGo;
		
		public boolean isRaisedCannotGo() {
			return cannotGo;
		}
		
		protected void raiseCannotGo() {
			cannotGo = true;
			for (SCIProtocolRequiredDivergentListener listener : listeners) {
				listener.onCannotGoRaised();
			}
		}
		
		private boolean release;
		
		public boolean isRaisedRelease() {
			return release;
		}
		
		protected void raiseRelease() {
			release = true;
			for (SCIProtocolRequiredDivergentListener listener : listeners) {
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
	
	protected SCIProtocolRequiredDivergentImpl sCIProtocolRequiredDivergent;
	
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
	
		public long getTOP() {
			return tOP;
		}
		
		public long getSTRAIGHT() {
			return sTRAIGHT;
		}
		
		public long getDIVERGENT() {
			return dIVERGENT;
		}
		
	}
	
	protected SCIDirectionImpl sCIDirection;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_Straight,
		main_region_Straight_listening_to_top_Waiting,
		main_region_Straight_listening_to_top_ReservationFromTop,
		main_region_Straight_listening_to_straight_Waiting,
		main_region_Straight_listening_to_straight_ReservationFromStraight,
		main_region_Straight_listening_to_occupy_Free,
		main_region_Straight_listening_to_occupy_Occupied,
		main_region_Divergent,
		main_region_Divergent_listening_to_top_Waiting,
		main_region_Divergent_listening_to_top_ReservationFromTop,
		main_region_Divergent_listening_to_divergent_Waiting,
		main_region_Divergent_listening_to_divergent_ReservationFromDivergent,
		main_region_Divergent_listening_to_occupy_Free,
		main_region_Divergent_listening_to_occupy_Occupied,
		$NullState$
	};
	
	private final State[] stateVector = new State[3];
	
	private int nextStateIndex;
	
	
	
	public TurnoutStatemachine() {
		sCITurnoutControlProvided = new SCITurnoutControlProvidedImpl();
		sCIProtocolProvidedTop = new SCIProtocolProvidedTopImpl();
		sCIProtocolRequiredTop = new SCIProtocolRequiredTopImpl();
		sCIProtocolProvidedStraight = new SCIProtocolProvidedStraightImpl();
		sCIProtocolRequiredStraight = new SCIProtocolRequiredStraightImpl();
		sCIProtocolProvidedDivergent = new SCIProtocolProvidedDivergentImpl();
		sCIProtocolRequiredDivergent = new SCIProtocolRequiredDivergentImpl();
		sCITrainProvided = new SCITrainProvidedImpl();
		sCIDirection = new SCIDirectionImpl();
	}
	
	public void init() {
		this.initialized = true;
		
		for (int i = 0; i < 3; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
	
		enterSequence_main_region_default();
	}
	
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$||stateVector[2] != State.$NullState$;
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
		sCITurnoutControlProvided.clearEvents();
		sCIProtocolProvidedTop.clearEvents();
		sCIProtocolRequiredTop.clearEvents();
		sCIProtocolProvidedStraight.clearEvents();
		sCIProtocolRequiredStraight.clearEvents();
		sCIProtocolProvidedDivergent.clearEvents();
		sCIProtocolRequiredDivergent.clearEvents();
		sCITrainProvided.clearEvents();
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
		sCIProtocolRequiredTop.clearOutEvents();
		sCIProtocolRequiredStraight.clearOutEvents();
		sCIProtocolRequiredDivergent.clearOutEvents();
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_Straight:
			return stateVector[0].ordinal() >= State.
					main_region_Straight.ordinal()&& stateVector[0].ordinal() <= State.main_region_Straight_listening_to_occupy_Occupied.ordinal();
		case main_region_Straight_listening_to_top_Waiting:
			return stateVector[0] == State.main_region_Straight_listening_to_top_Waiting;
		case main_region_Straight_listening_to_top_ReservationFromTop:
			return stateVector[0] == State.main_region_Straight_listening_to_top_ReservationFromTop;
		case main_region_Straight_listening_to_straight_Waiting:
			return stateVector[1] == State.main_region_Straight_listening_to_straight_Waiting;
		case main_region_Straight_listening_to_straight_ReservationFromStraight:
			return stateVector[1] == State.main_region_Straight_listening_to_straight_ReservationFromStraight;
		case main_region_Straight_listening_to_occupy_Free:
			return stateVector[2] == State.main_region_Straight_listening_to_occupy_Free;
		case main_region_Straight_listening_to_occupy_Occupied:
			return stateVector[2] == State.main_region_Straight_listening_to_occupy_Occupied;
		case main_region_Divergent:
			return stateVector[0].ordinal() >= State.
					main_region_Divergent.ordinal()&& stateVector[0].ordinal() <= State.main_region_Divergent_listening_to_occupy_Occupied.ordinal();
		case main_region_Divergent_listening_to_top_Waiting:
			return stateVector[0] == State.main_region_Divergent_listening_to_top_Waiting;
		case main_region_Divergent_listening_to_top_ReservationFromTop:
			return stateVector[0] == State.main_region_Divergent_listening_to_top_ReservationFromTop;
		case main_region_Divergent_listening_to_divergent_Waiting:
			return stateVector[1] == State.main_region_Divergent_listening_to_divergent_Waiting;
		case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
			return stateVector[1] == State.main_region_Divergent_listening_to_divergent_ReservationFromDivergent;
		case main_region_Divergent_listening_to_occupy_Free:
			return stateVector[2] == State.main_region_Divergent_listening_to_occupy_Free;
		case main_region_Divergent_listening_to_occupy_Occupied:
			return stateVector[2] == State.main_region_Divergent_listening_to_occupy_Occupied;
		default:
			return false;
		}
	}
	
	public SCITurnoutControlProvided getSCITurnoutControlProvided() {
		return sCITurnoutControlProvided;
	}
	
	public SCIProtocolProvidedTop getSCIProtocolProvidedTop() {
		return sCIProtocolProvidedTop;
	}
	
	public SCIProtocolRequiredTop getSCIProtocolRequiredTop() {
		return sCIProtocolRequiredTop;
	}
	
	public SCIProtocolProvidedStraight getSCIProtocolProvidedStraight() {
		return sCIProtocolProvidedStraight;
	}
	
	public SCIProtocolRequiredStraight getSCIProtocolRequiredStraight() {
		return sCIProtocolRequiredStraight;
	}
	
	public SCIProtocolProvidedDivergent getSCIProtocolProvidedDivergent() {
		return sCIProtocolProvidedDivergent;
	}
	
	public SCIProtocolRequiredDivergent getSCIProtocolRequiredDivergent() {
		return sCIProtocolRequiredDivergent;
	}
	
	public SCITrainProvided getSCITrainProvided() {
		return sCITrainProvided;
	}
	
	public SCIDirection getSCIDirection() {
		return sCIDirection;
	}
	
	private boolean check_main_region_Straight_lr0_lr0() {
		return sCIProtocolProvidedDivergent.reserve;
	}
	
	private boolean check_main_region_Straight_tr0_tr0() {
		return sCITurnoutControlProvided.turnoutDivergent;
	}
	
	private boolean check_main_region_Straight_listening_to_top_Waiting_tr0_tr0() {
		return sCIProtocolProvidedTop.reserve;
	}
	
	private boolean check_main_region_Straight_listening_to_top_ReservationFromTop_tr0_tr0() {
		return sCIProtocolProvidedStraight.cannotGo;
	}
	
	private boolean check_main_region_Straight_listening_to_top_ReservationFromTop_tr1_tr1() {
		return sCIProtocolProvidedStraight.canGo;
	}
	
	private boolean check_main_region_Straight_listening_to_straight_Waiting_tr0_tr0() {
		return sCIProtocolProvidedStraight.reserve;
	}
	
	private boolean check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0_tr0() {
		return sCIProtocolProvidedTop.cannotGo;
	}
	
	private boolean check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1_tr1() {
		return sCIProtocolProvidedTop.canGo;
	}
	
	private boolean check_main_region_Straight_listening_to_occupy_Free_lr0_lr0() {
		return sCIProtocolProvidedStraight.release;
	}
	
	private boolean check_main_region_Straight_listening_to_occupy_Free_lr1_lr1() {
		return sCIProtocolProvidedTop.release;
	}
	
	private boolean check_main_region_Straight_listening_to_occupy_Free_tr0_tr0() {
		return sCITrainProvided.occupy;
	}
	
	private boolean check_main_region_Straight_listening_to_occupy_Occupied_lr0_lr0() {
		return sCIProtocolProvidedStraight.release;
	}
	
	private boolean check_main_region_Straight_listening_to_occupy_Occupied_lr1_lr1() {
		return sCIProtocolProvidedTop.release;
	}
	
	private boolean check_main_region_Straight_listening_to_occupy_Occupied_tr0_tr0() {
		return sCITrainProvided.unoccupy;
	}
	
	private boolean check_main_region_Divergent_lr0_lr0() {
		return sCIProtocolProvidedStraight.reserve;
	}
	
	private boolean check_main_region_Divergent_tr0_tr0() {
		return sCITurnoutControlProvided.turnoutStraight;
	}
	
	private boolean check_main_region_Divergent_listening_to_top_Waiting_tr0_tr0() {
		return sCIProtocolProvidedTop.reserve;
	}
	
	private boolean check_main_region_Divergent_listening_to_top_ReservationFromTop_tr0_tr0() {
		return sCIProtocolProvidedDivergent.cannotGo;
	}
	
	private boolean check_main_region_Divergent_listening_to_top_ReservationFromTop_tr1_tr1() {
		return sCIProtocolProvidedDivergent.canGo;
	}
	
	private boolean check_main_region_Divergent_listening_to_divergent_Waiting_tr0_tr0() {
		return sCIProtocolProvidedDivergent.reserve;
	}
	
	private boolean check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0_tr0() {
		return sCIProtocolProvidedTop.cannotGo;
	}
	
	private boolean check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1_tr1() {
		return sCIProtocolProvidedTop.canGo;
	}
	
	private boolean check_main_region_Divergent_listening_to_occupy_Free_lr0_lr0() {
		return sCIProtocolProvidedDivergent.release;
	}
	
	private boolean check_main_region_Divergent_listening_to_occupy_Free_lr1_lr1() {
		return sCIProtocolProvidedTop.release;
	}
	
	private boolean check_main_region_Divergent_listening_to_occupy_Free_tr0_tr0() {
		return sCITrainProvided.occupy;
	}
	
	private boolean check_main_region_Divergent_listening_to_occupy_Occupied_lr0_lr0() {
		return sCIProtocolProvidedDivergent.release;
	}
	
	private boolean check_main_region_Divergent_listening_to_occupy_Occupied_lr1_lr1() {
		return sCIProtocolProvidedTop.release;
	}
	
	private boolean check_main_region_Divergent_listening_to_occupy_Occupied_tr0_tr0() {
		return sCITrainProvided.unoccupy;
	}
	
	private void effect_main_region_Straight_lr0_lr0() {
		sCIProtocolRequiredDivergent.raiseCannotGo();
	}
	
	private void effect_main_region_Straight_tr0() {
		exitSequence_main_region_Straight();
		sCIProtocolRequiredTop.raiseRelease();
		
		sCIProtocolRequiredDivergent.raiseRelease();
		
		sCIProtocolRequiredStraight.raiseCannotGo();
		
		enterSequence_main_region_Divergent_default();
	}
	
	private void effect_main_region_Straight_listening_to_top_Waiting_tr0() {
		exitSequence_main_region_Straight_listening_to_top_Waiting();
		sCIProtocolRequiredStraight.raiseReserve();
		
		enterSequence_main_region_Straight_listening_to_top_ReservationFromTop_default();
	}
	
	private void effect_main_region_Straight_listening_to_top_ReservationFromTop_tr0() {
		exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();
		sCIProtocolRequiredTop.raiseCannotGo();
		
		enterSequence_main_region_Straight_listening_to_top_Waiting_default();
	}
	
	private void effect_main_region_Straight_listening_to_top_ReservationFromTop_tr1() {
		exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();
		sCIProtocolRequiredTop.raiseCanGo();
		
		enterSequence_main_region_Straight_listening_to_top_Waiting_default();
	}
	
	private void effect_main_region_Straight_listening_to_straight_Waiting_tr0() {
		exitSequence_main_region_Straight_listening_to_straight_Waiting();
		sCIProtocolRequiredTop.raiseReserve();
		
		enterSequence_main_region_Straight_listening_to_straight_ReservationFromStraight_default();
	}
	
	private void effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0() {
		exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();
		sCIProtocolRequiredStraight.raiseCannotGo();
		
		enterSequence_main_region_Straight_listening_to_straight_Waiting_default();
	}
	
	private void effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1() {
		exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();
		sCIProtocolRequiredStraight.raiseCanGo();
		
		enterSequence_main_region_Straight_listening_to_straight_Waiting_default();
	}
	
	private void effect_main_region_Straight_listening_to_occupy_Free_lr0_lr0() {
		sCIProtocolRequiredTop.raiseRelease();
	}
	
	private void effect_main_region_Straight_listening_to_occupy_Free_lr1_lr1() {
		sCIProtocolRequiredStraight.raiseRelease();
	}
	
	private void effect_main_region_Straight_listening_to_occupy_Free_tr0() {
		exitSequence_main_region_Straight_listening_to_occupy_Free();
		enterSequence_main_region_Straight_listening_to_occupy_Occupied_default();
	}
	
	private void effect_main_region_Straight_listening_to_occupy_Occupied_lr0_lr0() {
		sCIProtocolRequiredStraight.raiseReserve();
	}
	
	private void effect_main_region_Straight_listening_to_occupy_Occupied_lr1_lr1() {
		sCIProtocolRequiredTop.raiseReserve();
	}
	
	private void effect_main_region_Straight_listening_to_occupy_Occupied_tr0() {
		exitSequence_main_region_Straight_listening_to_occupy_Occupied();
		enterSequence_main_region_Straight_listening_to_occupy_Free_default();
	}
	
	private void effect_main_region_Divergent_lr0_lr0() {
		sCIProtocolRequiredStraight.raiseCannotGo();
	}
	
	private void effect_main_region_Divergent_tr0() {
		exitSequence_main_region_Divergent();
		sCIProtocolRequiredTop.raiseRelease();
		
		sCIProtocolRequiredStraight.raiseRelease();
		
		sCIProtocolRequiredDivergent.raiseCannotGo();
		
		enterSequence_main_region_Straight_default();
	}
	
	private void effect_main_region_Divergent_listening_to_top_Waiting_tr0() {
		exitSequence_main_region_Divergent_listening_to_top_Waiting();
		sCIProtocolRequiredDivergent.raiseReserve();
		
		enterSequence_main_region_Divergent_listening_to_top_ReservationFromTop_default();
	}
	
	private void effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr0() {
		exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();
		sCIProtocolRequiredTop.raiseCannotGo();
		
		enterSequence_main_region_Divergent_listening_to_top_Waiting_default();
	}
	
	private void effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr1() {
		exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();
		sCIProtocolRequiredTop.raiseCanGo();
		
		enterSequence_main_region_Divergent_listening_to_top_Waiting_default();
	}
	
	private void effect_main_region_Divergent_listening_to_divergent_Waiting_tr0() {
		exitSequence_main_region_Divergent_listening_to_divergent_Waiting();
		sCIProtocolRequiredTop.raiseReserve();
		
		enterSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_default();
	}
	
	private void effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0() {
		exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
		sCIProtocolRequiredDivergent.raiseCannotGo();
		
		enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default();
	}
	
	private void effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1() {
		exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
		sCIProtocolRequiredDivergent.raiseCanGo();
		
		enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default();
	}
	
	private void effect_main_region_Divergent_listening_to_occupy_Free_lr0_lr0() {
		sCIProtocolRequiredTop.raiseRelease();
	}
	
	private void effect_main_region_Divergent_listening_to_occupy_Free_lr1_lr1() {
		sCIProtocolRequiredDivergent.raiseRelease();
	}
	
	private void effect_main_region_Divergent_listening_to_occupy_Free_tr0() {
		exitSequence_main_region_Divergent_listening_to_occupy_Free();
		enterSequence_main_region_Divergent_listening_to_occupy_Occupied_default();
	}
	
	private void effect_main_region_Divergent_listening_to_occupy_Occupied_lr0_lr0() {
		sCIProtocolRequiredDivergent.raiseReserve();
	}
	
	private void effect_main_region_Divergent_listening_to_occupy_Occupied_lr1_lr1() {
		sCIProtocolRequiredTop.raiseReserve();
	}
	
	private void effect_main_region_Divergent_listening_to_occupy_Occupied_tr0() {
		exitSequence_main_region_Divergent_listening_to_occupy_Occupied();
		enterSequence_main_region_Divergent_listening_to_occupy_Free_default();
	}
	
	/* 'default' enter sequence for state Straight */
	private void enterSequence_main_region_Straight_default() {
		enterSequence_main_region_Straight_listening_to_top_default();
		enterSequence_main_region_Straight_listening_to_straight_default();
		enterSequence_main_region_Straight_listening_to_occupy_default();
	}
	
	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Straight_listening_to_top_Waiting_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;
	}
	
	/* 'default' enter sequence for state ReservationFromTop */
	private void enterSequence_main_region_Straight_listening_to_top_ReservationFromTop_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_top_ReservationFromTop;
	}
	
	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Straight_listening_to_straight_Waiting_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;
	}
	
	/* 'default' enter sequence for state ReservationFromStraight */
	private void enterSequence_main_region_Straight_listening_to_straight_ReservationFromStraight_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_straight_ReservationFromStraight;
	}
	
	/* 'default' enter sequence for state Free */
	private void enterSequence_main_region_Straight_listening_to_occupy_Free_default() {
		nextStateIndex = 2;
		stateVector[2] = State.main_region_Straight_listening_to_occupy_Free;
	}
	
	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_region_Straight_listening_to_occupy_Occupied_default() {
		nextStateIndex = 2;
		stateVector[2] = State.main_region_Straight_listening_to_occupy_Occupied;
	}
	
	/* 'default' enter sequence for state Divergent */
	private void enterSequence_main_region_Divergent_default() {
		enterSequence_main_region_Divergent_listening_to_top_default();
		enterSequence_main_region_Divergent_listening_to_divergent_default();
		enterSequence_main_region_Divergent_listening_to_occupy_default();
	}
	
	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Divergent_listening_to_top_Waiting_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divergent_listening_to_top_Waiting;
	}
	
	/* 'default' enter sequence for state ReservationFromTop */
	private void enterSequence_main_region_Divergent_listening_to_top_ReservationFromTop_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divergent_listening_to_top_ReservationFromTop;
	}
	
	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Divergent_listening_to_divergent_Waiting;
	}
	
	/* 'default' enter sequence for state ReservationFromDivergent */
	private void enterSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Divergent_listening_to_divergent_ReservationFromDivergent;
	}
	
	/* 'default' enter sequence for state Free */
	private void enterSequence_main_region_Divergent_listening_to_occupy_Free_default() {
		nextStateIndex = 2;
		stateVector[2] = State.main_region_Divergent_listening_to_occupy_Free;
	}
	
	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_region_Divergent_listening_to_occupy_Occupied_default() {
		nextStateIndex = 2;
		stateVector[2] = State.main_region_Divergent_listening_to_occupy_Occupied;
	}
	
	/* 'default' enter sequence for region main_region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region listening_to_top */
	private void enterSequence_main_region_Straight_listening_to_top_default() {
		react_main_region_Straight_listening_to_top__entry_Default();
	}
	
	/* 'default' enter sequence for region listening_to_straight */
	private void enterSequence_main_region_Straight_listening_to_straight_default() {
		react_main_region_Straight_listening_to_straight__entry_Default();
	}
	
	/* 'default' enter sequence for region listening_to_occupy */
	private void enterSequence_main_region_Straight_listening_to_occupy_default() {
		react_main_region_Straight_listening_to_occupy__entry_Default();
	}
	
	/* 'default' enter sequence for region listening_to_top */
	private void enterSequence_main_region_Divergent_listening_to_top_default() {
		react_main_region_Divergent_listening_to_top__entry_Default();
	}
	
	/* 'default' enter sequence for region listening_to_divergent */
	private void enterSequence_main_region_Divergent_listening_to_divergent_default() {
		react_main_region_Divergent_listening_to_divergent__entry_Default();
	}
	
	/* 'default' enter sequence for region listening_to_occupy */
	private void enterSequence_main_region_Divergent_listening_to_occupy_default() {
		react_main_region_Divergent_listening_to_occupy__entry_Default();
	}
	
	/* Default exit sequence for state Straight */
	private void exitSequence_main_region_Straight() {
		exitSequence_main_region_Straight_listening_to_top();
		exitSequence_main_region_Straight_listening_to_straight();
		exitSequence_main_region_Straight_listening_to_occupy();
	}
	
	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Straight_listening_to_top_Waiting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ReservationFromTop */
	private void exitSequence_main_region_Straight_listening_to_top_ReservationFromTop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Straight_listening_to_straight_Waiting() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state ReservationFromStraight */
	private void exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Free */
	private void exitSequence_main_region_Straight_listening_to_occupy_Free() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state Occupied */
	private void exitSequence_main_region_Straight_listening_to_occupy_Occupied() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state Divergent */
	private void exitSequence_main_region_Divergent() {
		exitSequence_main_region_Divergent_listening_to_top();
		exitSequence_main_region_Divergent_listening_to_divergent();
		exitSequence_main_region_Divergent_listening_to_occupy();
	}
	
	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Divergent_listening_to_top_Waiting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ReservationFromTop */
	private void exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Divergent_listening_to_divergent_Waiting() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state ReservationFromDivergent */
	private void exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state Free */
	private void exitSequence_main_region_Divergent_listening_to_occupy_Free() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state Occupied */
	private void exitSequence_main_region_Divergent_listening_to_occupy_Occupied() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for region main_region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Straight_listening_to_top_Waiting:
			exitSequence_main_region_Straight_listening_to_top_Waiting();
			break;
		case main_region_Straight_listening_to_top_ReservationFromTop:
			exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();
			break;
		case main_region_Divergent_listening_to_top_Waiting:
			exitSequence_main_region_Divergent_listening_to_top_Waiting();
			break;
		case main_region_Divergent_listening_to_top_ReservationFromTop:
			exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case main_region_Straight_listening_to_straight_Waiting:
			exitSequence_main_region_Straight_listening_to_straight_Waiting();
			break;
		case main_region_Straight_listening_to_straight_ReservationFromStraight:
			exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();
			break;
		case main_region_Divergent_listening_to_divergent_Waiting:
			exitSequence_main_region_Divergent_listening_to_divergent_Waiting();
			break;
		case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
			exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
			break;
		default:
			break;
		}
		
		switch (stateVector[2]) {
		case main_region_Straight_listening_to_occupy_Free:
			exitSequence_main_region_Straight_listening_to_occupy_Free();
			break;
		case main_region_Straight_listening_to_occupy_Occupied:
			exitSequence_main_region_Straight_listening_to_occupy_Occupied();
			break;
		case main_region_Divergent_listening_to_occupy_Free:
			exitSequence_main_region_Divergent_listening_to_occupy_Free();
			break;
		case main_region_Divergent_listening_to_occupy_Occupied:
			exitSequence_main_region_Divergent_listening_to_occupy_Occupied();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region listening_to_top */
	private void exitSequence_main_region_Straight_listening_to_top() {
		switch (stateVector[0]) {
		case main_region_Straight_listening_to_top_Waiting:
			exitSequence_main_region_Straight_listening_to_top_Waiting();
			break;
		case main_region_Straight_listening_to_top_ReservationFromTop:
			exitSequence_main_region_Straight_listening_to_top_ReservationFromTop();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region listening_to_straight */
	private void exitSequence_main_region_Straight_listening_to_straight() {
		switch (stateVector[1]) {
		case main_region_Straight_listening_to_straight_Waiting:
			exitSequence_main_region_Straight_listening_to_straight_Waiting();
			break;
		case main_region_Straight_listening_to_straight_ReservationFromStraight:
			exitSequence_main_region_Straight_listening_to_straight_ReservationFromStraight();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region listening_to_occupy */
	private void exitSequence_main_region_Straight_listening_to_occupy() {
		switch (stateVector[2]) {
		case main_region_Straight_listening_to_occupy_Free:
			exitSequence_main_region_Straight_listening_to_occupy_Free();
			break;
		case main_region_Straight_listening_to_occupy_Occupied:
			exitSequence_main_region_Straight_listening_to_occupy_Occupied();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region listening_to_top */
	private void exitSequence_main_region_Divergent_listening_to_top() {
		switch (stateVector[0]) {
		case main_region_Divergent_listening_to_top_Waiting:
			exitSequence_main_region_Divergent_listening_to_top_Waiting();
			break;
		case main_region_Divergent_listening_to_top_ReservationFromTop:
			exitSequence_main_region_Divergent_listening_to_top_ReservationFromTop();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region listening_to_divergent */
	private void exitSequence_main_region_Divergent_listening_to_divergent() {
		switch (stateVector[1]) {
		case main_region_Divergent_listening_to_divergent_Waiting:
			exitSequence_main_region_Divergent_listening_to_divergent_Waiting();
			break;
		case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
			exitSequence_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region listening_to_occupy */
	private void exitSequence_main_region_Divergent_listening_to_occupy() {
		switch (stateVector[2]) {
		case main_region_Divergent_listening_to_occupy_Free:
			exitSequence_main_region_Divergent_listening_to_occupy_Free();
			break;
		case main_region_Divergent_listening_to_occupy_Occupied:
			exitSequence_main_region_Divergent_listening_to_occupy_Occupied();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_top_Waiting() {
		if (check_main_region_Straight_tr0_tr0()) {
			effect_main_region_Straight_tr0();
		} else {
			if (check_main_region_Straight_lr0_lr0()) {
				effect_main_region_Straight_lr0_lr0();
			}
			if (check_main_region_Straight_listening_to_top_Waiting_tr0_tr0()) {
				effect_main_region_Straight_listening_to_top_Waiting_tr0();
			}
		}
	}
	
	/* The reactions of state ReservationFromTop. */
	private void react_main_region_Straight_listening_to_top_ReservationFromTop() {
		if (check_main_region_Straight_tr0_tr0()) {
			effect_main_region_Straight_tr0();
		} else {
			if (check_main_region_Straight_lr0_lr0()) {
				effect_main_region_Straight_lr0_lr0();
			}
			if (check_main_region_Straight_listening_to_top_ReservationFromTop_tr0_tr0()) {
				effect_main_region_Straight_listening_to_top_ReservationFromTop_tr0();
			} else {
				if (check_main_region_Straight_listening_to_top_ReservationFromTop_tr1_tr1()) {
					effect_main_region_Straight_listening_to_top_ReservationFromTop_tr1();
				}
			}
		}
	}
	
	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_straight_Waiting() {
		if (check_main_region_Straight_listening_to_straight_Waiting_tr0_tr0()) {
			effect_main_region_Straight_listening_to_straight_Waiting_tr0();
		}
	}
	
	/* The reactions of state ReservationFromStraight. */
	private void react_main_region_Straight_listening_to_straight_ReservationFromStraight() {
		if (check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0_tr0()) {
			effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr0();
		} else {
			if (check_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1_tr1()) {
				effect_main_region_Straight_listening_to_straight_ReservationFromStraight_tr1();
			}
		}
	}
	
	/* The reactions of state Free. */
	private void react_main_region_Straight_listening_to_occupy_Free() {
		if (check_main_region_Straight_listening_to_occupy_Free_tr0_tr0()) {
			effect_main_region_Straight_listening_to_occupy_Free_tr0();
		} else {
			if (check_main_region_Straight_listening_to_occupy_Free_lr0_lr0()) {
				effect_main_region_Straight_listening_to_occupy_Free_lr0_lr0();
			}
			if (check_main_region_Straight_listening_to_occupy_Free_lr1_lr1()) {
				effect_main_region_Straight_listening_to_occupy_Free_lr1_lr1();
			}
		}
	}
	
	/* The reactions of state Occupied. */
	private void react_main_region_Straight_listening_to_occupy_Occupied() {
		if (check_main_region_Straight_listening_to_occupy_Occupied_tr0_tr0()) {
			effect_main_region_Straight_listening_to_occupy_Occupied_tr0();
		} else {
			if (check_main_region_Straight_listening_to_occupy_Occupied_lr0_lr0()) {
				effect_main_region_Straight_listening_to_occupy_Occupied_lr0_lr0();
			}
			if (check_main_region_Straight_listening_to_occupy_Occupied_lr1_lr1()) {
				effect_main_region_Straight_listening_to_occupy_Occupied_lr1_lr1();
			}
		}
	}
	
	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_top_Waiting() {
		if (check_main_region_Divergent_tr0_tr0()) {
			effect_main_region_Divergent_tr0();
		} else {
			if (check_main_region_Divergent_lr0_lr0()) {
				effect_main_region_Divergent_lr0_lr0();
			}
			if (check_main_region_Divergent_listening_to_top_Waiting_tr0_tr0()) {
				effect_main_region_Divergent_listening_to_top_Waiting_tr0();
			}
		}
	}
	
	/* The reactions of state ReservationFromTop. */
	private void react_main_region_Divergent_listening_to_top_ReservationFromTop() {
		if (check_main_region_Divergent_tr0_tr0()) {
			effect_main_region_Divergent_tr0();
		} else {
			if (check_main_region_Divergent_lr0_lr0()) {
				effect_main_region_Divergent_lr0_lr0();
			}
			if (check_main_region_Divergent_listening_to_top_ReservationFromTop_tr0_tr0()) {
				effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr0();
			} else {
				if (check_main_region_Divergent_listening_to_top_ReservationFromTop_tr1_tr1()) {
					effect_main_region_Divergent_listening_to_top_ReservationFromTop_tr1();
				}
			}
		}
	}
	
	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_divergent_Waiting() {
		if (check_main_region_Divergent_listening_to_divergent_Waiting_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_divergent_Waiting_tr0();
		}
	}
	
	/* The reactions of state ReservationFromDivergent. */
	private void react_main_region_Divergent_listening_to_divergent_ReservationFromDivergent() {
		if (check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr0();
		} else {
			if (check_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1_tr1()) {
				effect_main_region_Divergent_listening_to_divergent_ReservationFromDivergent_tr1();
			}
		}
	}
	
	/* The reactions of state Free. */
	private void react_main_region_Divergent_listening_to_occupy_Free() {
		if (check_main_region_Divergent_listening_to_occupy_Free_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_occupy_Free_tr0();
		} else {
			if (check_main_region_Divergent_listening_to_occupy_Free_lr0_lr0()) {
				effect_main_region_Divergent_listening_to_occupy_Free_lr0_lr0();
			}
			if (check_main_region_Divergent_listening_to_occupy_Free_lr1_lr1()) {
				effect_main_region_Divergent_listening_to_occupy_Free_lr1_lr1();
			}
		}
	}
	
	/* The reactions of state Occupied. */
	private void react_main_region_Divergent_listening_to_occupy_Occupied() {
		if (check_main_region_Divergent_listening_to_occupy_Occupied_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_occupy_Occupied_tr0();
		} else {
			if (check_main_region_Divergent_listening_to_occupy_Occupied_lr0_lr0()) {
				effect_main_region_Divergent_listening_to_occupy_Occupied_lr0_lr0();
			}
			if (check_main_region_Divergent_listening_to_occupy_Occupied_lr1_lr1()) {
				effect_main_region_Divergent_listening_to_occupy_Occupied_lr1_lr1();
			}
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Straight_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_top__entry_Default() {
		enterSequence_main_region_Straight_listening_to_top_Waiting_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_straight__entry_Default() {
		enterSequence_main_region_Straight_listening_to_straight_Waiting_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Straight_listening_to_occupy__entry_Default() {
		enterSequence_main_region_Straight_listening_to_occupy_Free_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_top__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_top_Waiting_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_divergent__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_divergent_Waiting_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region_Divergent_listening_to_occupy__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_occupy_Free_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_Straight_listening_to_top_Waiting:
				react_main_region_Straight_listening_to_top_Waiting();
				break;
			case main_region_Straight_listening_to_top_ReservationFromTop:
				react_main_region_Straight_listening_to_top_ReservationFromTop();
				break;
			case main_region_Straight_listening_to_straight_Waiting:
				react_main_region_Straight_listening_to_straight_Waiting();
				break;
			case main_region_Straight_listening_to_straight_ReservationFromStraight:
				react_main_region_Straight_listening_to_straight_ReservationFromStraight();
				break;
			case main_region_Straight_listening_to_occupy_Free:
				react_main_region_Straight_listening_to_occupy_Free();
				break;
			case main_region_Straight_listening_to_occupy_Occupied:
				react_main_region_Straight_listening_to_occupy_Occupied();
				break;
			case main_region_Divergent_listening_to_top_Waiting:
				react_main_region_Divergent_listening_to_top_Waiting();
				break;
			case main_region_Divergent_listening_to_top_ReservationFromTop:
				react_main_region_Divergent_listening_to_top_ReservationFromTop();
				break;
			case main_region_Divergent_listening_to_divergent_Waiting:
				react_main_region_Divergent_listening_to_divergent_Waiting();
				break;
			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
				react_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
				break;
			case main_region_Divergent_listening_to_occupy_Free:
				react_main_region_Divergent_listening_to_occupy_Free();
				break;
			case main_region_Divergent_listening_to_occupy_Occupied:
				react_main_region_Divergent_listening_to_occupy_Occupied();
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
