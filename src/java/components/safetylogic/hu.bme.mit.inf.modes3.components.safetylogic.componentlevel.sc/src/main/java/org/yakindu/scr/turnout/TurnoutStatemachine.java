package org.yakindu.scr.turnout;

import java.util.LinkedList;
import java.util.List;

public class TurnoutStatemachine implements ITurnoutStatemachine {

	protected class SCITurnoutImpl implements SCITurnout {

		private List<SCITurnoutListener> listeners = new LinkedList<SCITurnoutListener>();

		public List<SCITurnoutListener> getListeners() {
			return listeners;
		}

		private boolean switchEvent;

		public void raiseSwitch() {
			switchEvent = true;
		}

		private boolean reserveFromLeft;

		public void raiseReserveFromLeft() {
			reserveFromLeft = true;
		}

		private boolean reserveFromRight;

		public void raiseReserveFromRight() {
			reserveFromRight = true;
		}

		private boolean reserveFromBottom;

		public void raiseReserveFromBottom() {
			reserveFromBottom = true;
		}

		private boolean reserveResultFromLeft;

		private boolean reserveResultFromLeftValue;

		public void raiseReserveResultFromLeft(boolean value) {
			reserveResultFromLeft = true;
			reserveResultFromLeftValue = value;
		}

		protected boolean getReserveResultFromLeftValue() {
			if (!reserveResultFromLeft)
				throw new IllegalStateException(
						"Illegal event value access. Event ReserveResultFromLeft is not raised!");
			return reserveResultFromLeftValue;
		}

		private boolean reserveResultFromRight;

		private boolean reserveResultFromRightValue;

		public void raiseReserveResultFromRight(boolean value) {
			reserveResultFromRight = true;
			reserveResultFromRightValue = value;
		}

		protected boolean getReserveResultFromRightValue() {
			if (!reserveResultFromRight)
				throw new IllegalStateException(
						"Illegal event value access. Event ReserveResultFromRight is not raised!");
			return reserveResultFromRightValue;
		}

		private boolean reserveResultFromBottom;

		private boolean reserveResultFromBottomValue;

		public void raiseReserveResultFromBottom(boolean value) {
			reserveResultFromBottom = true;
			reserveResultFromBottomValue = value;
		}

		protected boolean getReserveResultFromBottomValue() {
			if (!reserveResultFromBottom)
				throw new IllegalStateException(
						"Illegal event value access. Event ReserveResultFromBottom is not raised!");
			return reserveResultFromBottomValue;
		}

		private boolean releaseFromLeft;

		public void raiseReleaseFromLeft() {
			releaseFromLeft = true;
		}

		private boolean releaseFromRight;

		public void raiseReleaseFromRight() {
			releaseFromRight = true;
		}

		private boolean releaseFromBottom;

		public void raiseReleaseFromBottom() {
			releaseFromBottom = true;
		}

		private boolean reserveLeft;

		public boolean isRaisedReserveLeft() {
			return reserveLeft;
		}

		protected void raiseReserveLeft() {
			reserveLeft = true;
			for (SCITurnoutListener listener : listeners) {
				listener.onReserveLeftRaised();
			}
		}

		private boolean reserveRight;

		public boolean isRaisedReserveRight() {
			return reserveRight;
		}

		protected void raiseReserveRight() {
			reserveRight = true;
			for (SCITurnoutListener listener : listeners) {
				listener.onReserveRightRaised();
			}
		}

		private boolean reserveBottom;

		public boolean isRaisedReserveBottom() {
			return reserveBottom;
		}

		protected void raiseReserveBottom() {
			reserveBottom = true;
			for (SCITurnoutListener listener : listeners) {
				listener.onReserveBottomRaised();
			}
		}

		private boolean reserveResultToLeft;

		private boolean reserveResultToLeftValue;

		public boolean isRaisedReserveResultToLeft() {
			return reserveResultToLeft;
		}

		protected void raiseReserveResultToLeft(boolean value) {
			reserveResultToLeft = true;
			reserveResultToLeftValue = value;
			for (SCITurnoutListener listener : listeners) {
				listener.onReserveResultToLeftRaised(value);
			}
		}

		public boolean getReserveResultToLeftValue() {
			if (!reserveResultToLeft)
				throw new IllegalStateException("Illegal event value access. Event ReserveResultToLeft is not raised!");
			return reserveResultToLeftValue;
		}

		private boolean reserveResultToRight;

		private boolean reserveResultToRightValue;

		public boolean isRaisedReserveResultToRight() {
			return reserveResultToRight;
		}

		protected void raiseReserveResultToRight(boolean value) {
			reserveResultToRight = true;
			reserveResultToRightValue = value;
			for (SCITurnoutListener listener : listeners) {
				listener.onReserveResultToRightRaised(value);
			}
		}

		public boolean getReserveResultToRightValue() {
			if (!reserveResultToRight)
				throw new IllegalStateException(
						"Illegal event value access. Event ReserveResultToRight is not raised!");
			return reserveResultToRightValue;
		}

		private boolean reserveResultToBottom;

		private boolean reserveResultToBottomValue;

		public boolean isRaisedReserveResultToBottom() {
			return reserveResultToBottom;
		}

		protected void raiseReserveResultToBottom(boolean value) {
			reserveResultToBottom = true;
			reserveResultToBottomValue = value;
			for (SCITurnoutListener listener : listeners) {
				listener.onReserveResultToBottomRaised(value);
			}
		}

		public boolean getReserveResultToBottomValue() {
			if (!reserveResultToBottom)
				throw new IllegalStateException(
						"Illegal event value access. Event ReserveResultToBottom is not raised!");
			return reserveResultToBottomValue;
		}

		private boolean releaseLeft;

		public boolean isRaisedReleaseLeft() {
			return releaseLeft;
		}

		protected void raiseReleaseLeft() {
			releaseLeft = true;
			for (SCITurnoutListener listener : listeners) {
				listener.onReleaseLeftRaised();
			}
		}

		private boolean releaseRight;

		public boolean isRaisedReleaseRight() {
			return releaseRight;
		}

		protected void raiseReleaseRight() {
			releaseRight = true;
			for (SCITurnoutListener listener : listeners) {
				listener.onReleaseRightRaised();
			}
		}

		private boolean releaseBottom;

		public boolean isRaisedReleaseBottom() {
			return releaseBottom;
		}

		protected void raiseReleaseBottom() {
			releaseBottom = true;
			for (SCITurnoutListener listener : listeners) {
				listener.onReleaseBottomRaised();
			}
		}

		private long id;

		public long getId() {
			return id;
		}

		public void setId(long value) {
			this.id = value;
		}

		private long count;

		public long getCount() {
			return count;
		}

		public void setCount(long value) {
			this.count = value;
		}

		protected void clearEvents() {
			switchEvent = false;
			reserveFromLeft = false;
			reserveFromRight = false;
			reserveFromBottom = false;
			reserveResultFromLeft = false;
			reserveResultFromRight = false;
			reserveResultFromBottom = false;
			releaseFromLeft = false;
			releaseFromRight = false;
			releaseFromBottom = false;
		}

		protected void clearOutEvents() {
			reserveLeft = false;
			reserveRight = false;
			reserveBottom = false;
			reserveResultToLeft = false;
			reserveResultToRight = false;
			reserveResultToBottom = false;
			releaseLeft = false;
			releaseRight = false;
			releaseBottom = false;
		}
	}

	protected SCITurnoutImpl sCITurnout;

	private boolean initialized = false;

	public enum State {
		main_region_Straight, main_region_Straight_listening_to_left_Waiting, main_region_Straight_listening_to_left_ReservationFromLeft, main_region_Straight_listening_to_right_Waiting, main_region_Straight_listening_to_right_ReservationFromRight, main_region_Divergent, main_region_Divergent_listening_to_bottom_Waiting, main_region_Divergent_listening_to_bottom_ReservationFromBottom, main_region_Divergent_listening_to_right_Waiting, main_region_Divergent_listening_to_right_ReservationFromRight, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public TurnoutStatemachine() {

		sCITurnout = new SCITurnoutImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCITurnout.setId(0);

		sCITurnout.setCount(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$;
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
		sCITurnout.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCITurnout.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
		case main_region_Straight:
			return stateVector[0].ordinal() >= State.main_region_Straight.ordinal() && stateVector[0]
					.ordinal() <= State.main_region_Straight_listening_to_right_ReservationFromRight.ordinal();
		case main_region_Straight_listening_to_left_Waiting:
			return stateVector[0] == State.main_region_Straight_listening_to_left_Waiting;
		case main_region_Straight_listening_to_left_ReservationFromLeft:
			return stateVector[0] == State.main_region_Straight_listening_to_left_ReservationFromLeft;
		case main_region_Straight_listening_to_right_Waiting:
			return stateVector[1] == State.main_region_Straight_listening_to_right_Waiting;
		case main_region_Straight_listening_to_right_ReservationFromRight:
			return stateVector[1] == State.main_region_Straight_listening_to_right_ReservationFromRight;
		case main_region_Divergent:
			return stateVector[0].ordinal() >= State.main_region_Divergent.ordinal() && stateVector[0]
					.ordinal() <= State.main_region_Divergent_listening_to_right_ReservationFromRight.ordinal();
		case main_region_Divergent_listening_to_bottom_Waiting:
			return stateVector[0] == State.main_region_Divergent_listening_to_bottom_Waiting;
		case main_region_Divergent_listening_to_bottom_ReservationFromBottom:
			return stateVector[0] == State.main_region_Divergent_listening_to_bottom_ReservationFromBottom;
		case main_region_Divergent_listening_to_right_Waiting:
			return stateVector[1] == State.main_region_Divergent_listening_to_right_Waiting;
		case main_region_Divergent_listening_to_right_ReservationFromRight:
			return stateVector[1] == State.main_region_Divergent_listening_to_right_ReservationFromRight;
		default:
			return false;
		}
	}

	public SCITurnout getSCITurnout() {
		return sCITurnout;
	}

	private boolean check_main_region_Straight_tr0_tr0() {
		return (sCITurnout.switchEvent) && (sCITurnout.count == 0);
	}

	private boolean check_main_region_Straight_lr0_lr0() {
		return sCITurnout.reserveFromBottom;
	}

	private boolean check_main_region_Straight_listening_to_left_Waiting_tr0_tr0() {
		return sCITurnout.reserveFromLeft;
	}

	private boolean check_main_region_Straight_listening_to_left_Waiting_lr0_lr0() {
		return sCITurnout.releaseFromLeft;
	}

	private boolean check_main_region_Straight_listening_to_left_ReservationFromLeft_tr0_tr0() {
		return (sCITurnout.reserveResultFromRight) && (sCITurnout.getReserveResultFromRightValue() == false);
	}

	private boolean check_main_region_Straight_listening_to_left_ReservationFromLeft_tr1_tr1() {
		return (sCITurnout.reserveResultFromRight) && (sCITurnout.getReserveResultFromRightValue() == true);
	}

	private boolean check_main_region_Straight_listening_to_right_Waiting_tr0_tr0() {
		return sCITurnout.reserveFromRight;
	}

	private boolean check_main_region_Straight_listening_to_right_Waiting_lr0_lr0() {
		return sCITurnout.releaseFromRight;
	}

	private boolean check_main_region_Straight_listening_to_right_ReservationFromRight_tr0_tr0() {
		return (sCITurnout.reserveResultFromLeft) && (sCITurnout.getReserveResultFromLeftValue() == false);
	}

	private boolean check_main_region_Straight_listening_to_right_ReservationFromRight_tr1_tr1() {
		return (sCITurnout.reserveResultFromLeft) && (sCITurnout.getReserveResultFromLeftValue() == true);
	}

	private boolean check_main_region_Divergent_tr0_tr0() {
		return (sCITurnout.switchEvent) && (sCITurnout.count == 0);
	}

	private boolean check_main_region_Divergent_lr0_lr0() {
		return sCITurnout.reserveFromLeft;
	}

	private boolean check_main_region_Divergent_listening_to_bottom_Waiting_tr0_tr0() {
		return sCITurnout.reserveFromBottom;
	}

	private boolean check_main_region_Divergent_listening_to_bottom_Waiting_lr0_lr0() {
		return sCITurnout.releaseFromBottom;
	}

	private boolean check_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr0_tr0() {
		return (sCITurnout.reserveResultFromRight) && (sCITurnout.getReserveResultFromRightValue() == false);
	}

	private boolean check_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr1_tr1() {
		return (sCITurnout.reserveResultFromRight) && (sCITurnout.getReserveResultFromRightValue() == true);
	}

	private boolean check_main_region_Divergent_listening_to_right_Waiting_tr0_tr0() {
		return sCITurnout.reserveFromRight;
	}

	private boolean check_main_region_Divergent_listening_to_right_Waiting_lr0_lr0() {
		return sCITurnout.releaseFromRight;
	}

	private boolean check_main_region_Divergent_listening_to_right_ReservationFromRight_tr0_tr0() {
		return (sCITurnout.reserveResultFromBottom) && (sCITurnout.getReserveResultFromBottomValue() == false);
	}

	private boolean check_main_region_Divergent_listening_to_right_ReservationFromRight_tr1_tr1() {
		return (sCITurnout.reserveResultFromBottom) && (sCITurnout.getReserveResultFromBottomValue() == true);
	}

	private void effect_main_region_Straight_tr0() {
		exitSequence_main_region_Straight();

		enterSequence_main_region_Divergent_default();
	}

	private void effect_main_region_Straight_lr0_lr0() {
		sCITurnout.raiseReserveResultToBottom(false);
	}

	private void effect_main_region_Straight_listening_to_left_Waiting_tr0() {
		exitSequence_main_region_Straight_listening_to_left_Waiting();

		sCITurnout.raiseReserveRight();

		sCITurnout.setCount(sCITurnout.count + 1);

		enterSequence_main_region_Straight_listening_to_left_ReservationFromLeft_default();
	}

	private void effect_main_region_Straight_listening_to_left_Waiting_lr0_lr0() {
		sCITurnout.raiseReleaseRight();

		sCITurnout.setCount(sCITurnout.count - 1);
	}

	private void effect_main_region_Straight_listening_to_left_ReservationFromLeft_tr0() {
		exitSequence_main_region_Straight_listening_to_left_ReservationFromLeft();

		sCITurnout.raiseReserveResultToLeft(false);

		enterSequence_main_region_Straight_listening_to_left_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_left_ReservationFromLeft_tr1() {
		exitSequence_main_region_Straight_listening_to_left_ReservationFromLeft();

		sCITurnout.raiseReserveResultToLeft(true);

		enterSequence_main_region_Straight_listening_to_left_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_right_Waiting_tr0() {
		exitSequence_main_region_Straight_listening_to_right_Waiting();

		sCITurnout.raiseReserveLeft();

		sCITurnout.setCount(sCITurnout.count + 1);

		enterSequence_main_region_Straight_listening_to_right_ReservationFromRight_default();
	}

	private void effect_main_region_Straight_listening_to_right_Waiting_lr0_lr0() {
		sCITurnout.raiseReleaseLeft();

		sCITurnout.setCount(sCITurnout.count - 1);
	}

	private void effect_main_region_Straight_listening_to_right_ReservationFromRight_tr0() {
		exitSequence_main_region_Straight_listening_to_right_ReservationFromRight();

		sCITurnout.raiseReserveResultToRight(false);

		enterSequence_main_region_Straight_listening_to_right_Waiting_default();
	}

	private void effect_main_region_Straight_listening_to_right_ReservationFromRight_tr1() {
		exitSequence_main_region_Straight_listening_to_right_ReservationFromRight();

		sCITurnout.raiseReserveResultToRight(true);

		enterSequence_main_region_Straight_listening_to_right_Waiting_default();
	}

	private void effect_main_region_Divergent_tr0() {
		exitSequence_main_region_Divergent();

		enterSequence_main_region_Straight_default();
	}

	private void effect_main_region_Divergent_lr0_lr0() {
		sCITurnout.raiseReserveResultToLeft(false);
	}

	private void effect_main_region_Divergent_listening_to_bottom_Waiting_tr0() {
		exitSequence_main_region_Divergent_listening_to_bottom_Waiting();

		sCITurnout.raiseReserveRight();

		sCITurnout.setCount(sCITurnout.count + 1);

		enterSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom_default();
	}

	private void effect_main_region_Divergent_listening_to_bottom_Waiting_lr0_lr0() {
		sCITurnout.raiseReleaseRight();

		sCITurnout.setCount(sCITurnout.count - 1);
	}

	private void effect_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr0() {
		exitSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom();

		sCITurnout.raiseReserveResultToBottom(false);

		enterSequence_main_region_Divergent_listening_to_bottom_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr1() {
		exitSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom();

		sCITurnout.raiseReserveResultToBottom(true);

		enterSequence_main_region_Divergent_listening_to_bottom_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_right_Waiting_tr0() {
		exitSequence_main_region_Divergent_listening_to_right_Waiting();

		sCITurnout.raiseReserveBottom();

		sCITurnout.setCount(sCITurnout.count + 1);

		enterSequence_main_region_Divergent_listening_to_right_ReservationFromRight_default();
	}

	private void effect_main_region_Divergent_listening_to_right_Waiting_lr0_lr0() {
		sCITurnout.raiseReleaseBottom();

		sCITurnout.setCount(sCITurnout.count - 1);
	}

	private void effect_main_region_Divergent_listening_to_right_ReservationFromRight_tr0() {
		exitSequence_main_region_Divergent_listening_to_right_ReservationFromRight();

		sCITurnout.raiseReserveResultToRight(false);

		enterSequence_main_region_Divergent_listening_to_right_Waiting_default();
	}

	private void effect_main_region_Divergent_listening_to_right_ReservationFromRight_tr1() {
		exitSequence_main_region_Divergent_listening_to_right_ReservationFromRight();

		sCITurnout.raiseReserveResultToRight(true);

		enterSequence_main_region_Divergent_listening_to_right_Waiting_default();
	}

	/* 'default' enter sequence for state Straight */
	private void enterSequence_main_region_Straight_default() {
		enterSequence_main_region_Straight_listening_to_left_default();

		enterSequence_main_region_Straight_listening_to_right_default();
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Straight_listening_to_left_Waiting_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_left_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromLeft */
	private void enterSequence_main_region_Straight_listening_to_left_ReservationFromLeft_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_left_ReservationFromLeft;
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Straight_listening_to_right_Waiting_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_right_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromRight */
	private void enterSequence_main_region_Straight_listening_to_right_ReservationFromRight_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_right_ReservationFromRight;
	}

	/* 'default' enter sequence for state Divergent */
	private void enterSequence_main_region_Divergent_default() {
		enterSequence_main_region_Divergent_listening_to_bottom_default();

		enterSequence_main_region_Divergent_listening_to_right_default();
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Divergent_listening_to_bottom_Waiting_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divergent_listening_to_bottom_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromBottom */
	private void enterSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divergent_listening_to_bottom_ReservationFromBottom;
	}

	/* 'default' enter sequence for state Waiting */
	private void enterSequence_main_region_Divergent_listening_to_right_Waiting_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Divergent_listening_to_right_Waiting;
	}

	/* 'default' enter sequence for state ReservationFromRight */
	private void enterSequence_main_region_Divergent_listening_to_right_ReservationFromRight_default() {
		nextStateIndex = 1;
		stateVector[1] = State.main_region_Divergent_listening_to_right_ReservationFromRight;
	}

	/* 'default' enter sequence for region main_region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_left */
	private void enterSequence_main_region_Straight_listening_to_left_default() {
		react_main_region_Straight_listening_to_left__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_right */
	private void enterSequence_main_region_Straight_listening_to_right_default() {
		react_main_region_Straight_listening_to_right__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_bottom */
	private void enterSequence_main_region_Divergent_listening_to_bottom_default() {
		react_main_region_Divergent_listening_to_bottom__entry_Default();
	}

	/* 'default' enter sequence for region listening_to_right */
	private void enterSequence_main_region_Divergent_listening_to_right_default() {
		react_main_region_Divergent_listening_to_right__entry_Default();
	}

	/* Default exit sequence for state Straight */
	private void exitSequence_main_region_Straight() {
		exitSequence_main_region_Straight_listening_to_left();

		exitSequence_main_region_Straight_listening_to_right();
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Straight_listening_to_left_Waiting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromLeft */
	private void exitSequence_main_region_Straight_listening_to_left_ReservationFromLeft() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Straight_listening_to_right_Waiting() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromRight */
	private void exitSequence_main_region_Straight_listening_to_right_ReservationFromRight() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Divergent */
	private void exitSequence_main_region_Divergent() {
		exitSequence_main_region_Divergent_listening_to_bottom();

		exitSequence_main_region_Divergent_listening_to_right();
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Divergent_listening_to_bottom_Waiting() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromBottom */
	private void exitSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Waiting */
	private void exitSequence_main_region_Divergent_listening_to_right_Waiting() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state ReservationFromRight */
	private void exitSequence_main_region_Divergent_listening_to_right_ReservationFromRight() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region main_region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Straight_listening_to_left_Waiting:
			exitSequence_main_region_Straight_listening_to_left_Waiting();
			break;

		case main_region_Straight_listening_to_left_ReservationFromLeft:
			exitSequence_main_region_Straight_listening_to_left_ReservationFromLeft();
			break;

		case main_region_Divergent_listening_to_bottom_Waiting:
			exitSequence_main_region_Divergent_listening_to_bottom_Waiting();
			break;

		case main_region_Divergent_listening_to_bottom_ReservationFromBottom:
			exitSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom();
			break;

		default:
			break;
		}

		switch (stateVector[1]) {
		case main_region_Straight_listening_to_right_Waiting:
			exitSequence_main_region_Straight_listening_to_right_Waiting();
			break;

		case main_region_Straight_listening_to_right_ReservationFromRight:
			exitSequence_main_region_Straight_listening_to_right_ReservationFromRight();
			break;

		case main_region_Divergent_listening_to_right_Waiting:
			exitSequence_main_region_Divergent_listening_to_right_Waiting();
			break;

		case main_region_Divergent_listening_to_right_ReservationFromRight:
			exitSequence_main_region_Divergent_listening_to_right_ReservationFromRight();
			break;

		default:
			break;
		}
	}

	/* Default exit sequence for region listening_to_left */
	private void exitSequence_main_region_Straight_listening_to_left() {
		switch (stateVector[0]) {
		case main_region_Straight_listening_to_left_Waiting:
			exitSequence_main_region_Straight_listening_to_left_Waiting();
			break;

		case main_region_Straight_listening_to_left_ReservationFromLeft:
			exitSequence_main_region_Straight_listening_to_left_ReservationFromLeft();
			break;

		default:
			break;
		}
	}

	/* Default exit sequence for region listening_to_right */
	private void exitSequence_main_region_Straight_listening_to_right() {
		switch (stateVector[1]) {
		case main_region_Straight_listening_to_right_Waiting:
			exitSequence_main_region_Straight_listening_to_right_Waiting();
			break;

		case main_region_Straight_listening_to_right_ReservationFromRight:
			exitSequence_main_region_Straight_listening_to_right_ReservationFromRight();
			break;

		default:
			break;
		}
	}

	/* Default exit sequence for region listening_to_bottom */
	private void exitSequence_main_region_Divergent_listening_to_bottom() {
		switch (stateVector[0]) {
		case main_region_Divergent_listening_to_bottom_Waiting:
			exitSequence_main_region_Divergent_listening_to_bottom_Waiting();
			break;

		case main_region_Divergent_listening_to_bottom_ReservationFromBottom:
			exitSequence_main_region_Divergent_listening_to_bottom_ReservationFromBottom();
			break;

		default:
			break;
		}
	}

	/* Default exit sequence for region listening_to_right */
	private void exitSequence_main_region_Divergent_listening_to_right() {
		switch (stateVector[1]) {
		case main_region_Divergent_listening_to_right_Waiting:
			exitSequence_main_region_Divergent_listening_to_right_Waiting();
			break;

		case main_region_Divergent_listening_to_right_ReservationFromRight:
			exitSequence_main_region_Divergent_listening_to_right_ReservationFromRight();
			break;

		default:
			break;
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_left_Waiting() {
		if (check_main_region_Straight_tr0_tr0()) {
			effect_main_region_Straight_tr0();
		} else {
			if (check_main_region_Straight_lr0_lr0()) {
				effect_main_region_Straight_lr0_lr0();
			}

			if (check_main_region_Straight_listening_to_left_Waiting_tr0_tr0()) {
				effect_main_region_Straight_listening_to_left_Waiting_tr0();
			} else {
				if (check_main_region_Straight_listening_to_left_Waiting_lr0_lr0()) {
					effect_main_region_Straight_listening_to_left_Waiting_lr0_lr0();
				}
			}
		}
	}

	/* The reactions of state ReservationFromLeft. */
	private void react_main_region_Straight_listening_to_left_ReservationFromLeft() {
		if (check_main_region_Straight_tr0_tr0()) {
			effect_main_region_Straight_tr0();
		} else {
			if (check_main_region_Straight_lr0_lr0()) {
				effect_main_region_Straight_lr0_lr0();
			}

			if (check_main_region_Straight_listening_to_left_ReservationFromLeft_tr0_tr0()) {
				effect_main_region_Straight_listening_to_left_ReservationFromLeft_tr0();
			} else {
				if (check_main_region_Straight_listening_to_left_ReservationFromLeft_tr1_tr1()) {
					effect_main_region_Straight_listening_to_left_ReservationFromLeft_tr1();
				}
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_right_Waiting() {
		if (check_main_region_Straight_listening_to_right_Waiting_tr0_tr0()) {
			effect_main_region_Straight_listening_to_right_Waiting_tr0();
		} else {
			if (check_main_region_Straight_listening_to_right_Waiting_lr0_lr0()) {
				effect_main_region_Straight_listening_to_right_Waiting_lr0_lr0();
			}
		}
	}

	/* The reactions of state ReservationFromRight. */
	private void react_main_region_Straight_listening_to_right_ReservationFromRight() {
		if (check_main_region_Straight_listening_to_right_ReservationFromRight_tr0_tr0()) {
			effect_main_region_Straight_listening_to_right_ReservationFromRight_tr0();
		} else {
			if (check_main_region_Straight_listening_to_right_ReservationFromRight_tr1_tr1()) {
				effect_main_region_Straight_listening_to_right_ReservationFromRight_tr1();
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_bottom_Waiting() {
		if (check_main_region_Divergent_tr0_tr0()) {
			effect_main_region_Divergent_tr0();
		} else {
			if (check_main_region_Divergent_lr0_lr0()) {
				effect_main_region_Divergent_lr0_lr0();
			}

			if (check_main_region_Divergent_listening_to_bottom_Waiting_tr0_tr0()) {
				effect_main_region_Divergent_listening_to_bottom_Waiting_tr0();
			} else {
				if (check_main_region_Divergent_listening_to_bottom_Waiting_lr0_lr0()) {
					effect_main_region_Divergent_listening_to_bottom_Waiting_lr0_lr0();
				}
			}
		}
	}

	/* The reactions of state ReservationFromBottom. */
	private void react_main_region_Divergent_listening_to_bottom_ReservationFromBottom() {
		if (check_main_region_Divergent_tr0_tr0()) {
			effect_main_region_Divergent_tr0();
		} else {
			if (check_main_region_Divergent_lr0_lr0()) {
				effect_main_region_Divergent_lr0_lr0();
			}

			if (check_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr0_tr0()) {
				effect_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr0();
			} else {
				if (check_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr1_tr1()) {
					effect_main_region_Divergent_listening_to_bottom_ReservationFromBottom_tr1();
				}
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_right_Waiting() {
		if (check_main_region_Divergent_listening_to_right_Waiting_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_right_Waiting_tr0();
		} else {
			if (check_main_region_Divergent_listening_to_right_Waiting_lr0_lr0()) {
				effect_main_region_Divergent_listening_to_right_Waiting_lr0_lr0();
			}
		}
	}

	/* The reactions of state ReservationFromRight. */
	private void react_main_region_Divergent_listening_to_right_ReservationFromRight() {
		if (check_main_region_Divergent_listening_to_right_ReservationFromRight_tr0_tr0()) {
			effect_main_region_Divergent_listening_to_right_ReservationFromRight_tr0();
		} else {
			if (check_main_region_Divergent_listening_to_right_ReservationFromRight_tr1_tr1()) {
				effect_main_region_Divergent_listening_to_right_ReservationFromRight_tr1();
			}
		}
	}

	/* Default react sequence for initial entry */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Straight_default();
	}

	/* Default react sequence for initial entry */
	private void react_main_region_Straight_listening_to_left__entry_Default() {
		enterSequence_main_region_Straight_listening_to_left_Waiting_default();
	}

	/* Default react sequence for initial entry */
	private void react_main_region_Straight_listening_to_right__entry_Default() {
		enterSequence_main_region_Straight_listening_to_right_Waiting_default();
	}

	/* Default react sequence for initial entry */
	private void react_main_region_Divergent_listening_to_bottom__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_bottom_Waiting_default();
	}

	/* Default react sequence for initial entry */
	private void react_main_region_Divergent_listening_to_right__entry_Default() {
		enterSequence_main_region_Divergent_listening_to_right_Waiting_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
			case main_region_Straight_listening_to_left_Waiting:
				react_main_region_Straight_listening_to_left_Waiting();
				break;
			case main_region_Straight_listening_to_left_ReservationFromLeft:
				react_main_region_Straight_listening_to_left_ReservationFromLeft();
				break;
			case main_region_Straight_listening_to_right_Waiting:
				react_main_region_Straight_listening_to_right_Waiting();
				break;
			case main_region_Straight_listening_to_right_ReservationFromRight:
				react_main_region_Straight_listening_to_right_ReservationFromRight();
				break;
			case main_region_Divergent_listening_to_bottom_Waiting:
				react_main_region_Divergent_listening_to_bottom_Waiting();
				break;
			case main_region_Divergent_listening_to_bottom_ReservationFromBottom:
				react_main_region_Divergent_listening_to_bottom_ReservationFromBottom();
				break;
			case main_region_Divergent_listening_to_right_Waiting:
				react_main_region_Divergent_listening_to_right_Waiting();
				break;
			case main_region_Divergent_listening_to_right_ReservationFromRight:
				react_main_region_Divergent_listening_to_right_ReservationFromRight();
				break;
			default:
				// $NullState$
			}
		}

		clearEvents();
	}
}
