package org.yakindu.scr.section;

import java.util.LinkedList;
import java.util.List;
import org.yakindu.scr.ITimer;

public class SectionStatemachine implements ISectionStatemachine {

	protected class SCISectionImpl implements SCISection {

		private List<SCISectionListener> listeners = new LinkedList<SCISectionListener>();

		public List<SCISectionListener> getListeners() {
			return listeners;
		}

		private boolean reserveFromLeft;

		public void raiseReserveFromLeft() {
			reserveFromLeft = true;
		}

		private boolean reserveFromRight;

		public void raiseReserveFromRight() {
			reserveFromRight = true;
		}

		private boolean reserveResult;

		private boolean reserveResultValue;

		public void raiseReserveResult(boolean value) {
			reserveResult = true;
			reserveResultValue = value;
		}

		protected boolean getReserveResultValue() {
			if (!reserveResult)
				throw new IllegalStateException("Illegal event value access. Event ReserveResult is not raised!");
			return reserveResultValue;
		}

		private boolean occupy;

		public void raiseOccupy() {
			occupy = true;
		}

		private boolean unoccupy;

		public void raiseUnoccupy() {
			unoccupy = true;
		}

		private boolean reset;

		public void raiseReset() {
			reset = true;
		}

		private boolean release;

		public void raiseRelease() {
			release = true;
		}

		private boolean reserveLeft;

		public boolean isRaisedReserveLeft() {
			return reserveLeft;
		}

		protected void raiseReserveLeft() {
			reserveLeft = true;
			for (SCISectionListener listener : listeners) {
				listener.onReserveLeftRaised();
			}
		}

		private boolean reserveRight;

		public boolean isRaisedReserveRight() {
			return reserveRight;
		}

		protected void raiseReserveRight() {
			reserveRight = true;
			for (SCISectionListener listener : listeners) {
				listener.onReserveRightRaised();
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
			for (SCISectionListener listener : listeners) {
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
			for (SCISectionListener listener : listeners) {
				listener.onReserveResultToRightRaised(value);
			}
		}

		public boolean getReserveResultToRightValue() {
			if (!reserveResultToRight)
				throw new IllegalStateException(
						"Illegal event value access. Event ReserveResultToRight is not raised!");
			return reserveResultToRightValue;
		}

		private boolean releaseLeft;

		public boolean isRaisedReleaseLeft() {
			return releaseLeft;
		}

		protected void raiseReleaseLeft() {
			releaseLeft = true;
			for (SCISectionListener listener : listeners) {
				listener.onReleaseLeftRaised();
			}
		}

		private boolean releaseRight;

		public boolean isRaisedReleaseRight() {
			return releaseRight;
		}

		protected void raiseReleaseRight() {
			releaseRight = true;
			for (SCISectionListener listener : listeners) {
				listener.onReleaseRightRaised();
			}
		}

		private boolean stop;

		public boolean isRaisedStop() {
			return stop;
		}

		protected void raiseStop() {
			stop = true;
			for (SCISectionListener listener : listeners) {
				listener.onStopRaised();
			}
		}

		private long id;

		public long getId() {
			return id;
		}

		public void setId(long value) {
			this.id = value;
		}

		private long timeout;

		public long getTimeout() {
			return timeout;
		}

		public void setTimeout(long value) {
			this.timeout = value;
		}

		private long dir;

		public long getDir() {
			return dir;
		}

		public void setDir(long value) {
			this.dir = value;
		}

		protected void clearEvents() {
			reserveFromLeft = false;
			reserveFromRight = false;
			reserveResult = false;
			occupy = false;
			unoccupy = false;
			reset = false;
			release = false;
		}

		protected void clearOutEvents() {
			reserveLeft = false;
			reserveRight = false;
			reserveResultToLeft = false;
			reserveResultToRight = false;
			releaseLeft = false;
			releaseRight = false;
			stop = false;
		}
	}

	protected SCISectionImpl sCISection;

	protected class SCIDirectionImpl implements SCIDirection {

		public long getLEFT() {
			return lEFT;
		}

		public long getRIGHT() {
			return rIGHT;
		}

	}

	protected SCIDirectionImpl sCIDirection;

	private boolean initialized = false;

	public enum State {
		main_region_Free, main_region_NotFree, main_region_NotFree_notFree_Stop, main_region_NotFree_notFree_WaitingForResponse, main_region_NotFree_notFree_Occupied, main_region_NotFree_notFree_Reserved, main_region_NotFree_notFree_WaitForFirstResponse, main_region_NotFree_notFree_WaitForSecondResponse, main_region_NotFree_notFree_BeforeFirstReserve, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private ITimer timer;

	private final boolean[] timeEvents = new boolean[2];

	public SectionStatemachine() {

		sCISection = new SCISectionImpl();
		sCIDirection = new SCIDirectionImpl();
	}

	public void init() {
		this.initialized = true;
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCISection.setId(0);

		sCISection.setTimeout(10);

		sCISection.setDir(sCIDirection.rIGHT);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		if (timer == null) {
			throw new IllegalStateException("timer not set.");
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
		sCISection.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
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
		case main_region_Free:
			return stateVector[0] == State.main_region_Free;
		case main_region_NotFree:
			return stateVector[0].ordinal() >= State.main_region_NotFree.ordinal()
					&& stateVector[0].ordinal() <= State.main_region_NotFree_notFree_BeforeFirstReserve.ordinal();
		case main_region_NotFree_notFree_Stop:
			return stateVector[0] == State.main_region_NotFree_notFree_Stop;
		case main_region_NotFree_notFree_WaitingForResponse:
			return stateVector[0] == State.main_region_NotFree_notFree_WaitingForResponse;
		case main_region_NotFree_notFree_Occupied:
			return stateVector[0] == State.main_region_NotFree_notFree_Occupied;
		case main_region_NotFree_notFree_Reserved:
			return stateVector[0] == State.main_region_NotFree_notFree_Reserved;
		case main_region_NotFree_notFree_WaitForFirstResponse:
			return stateVector[0] == State.main_region_NotFree_notFree_WaitForFirstResponse;
		case main_region_NotFree_notFree_WaitForSecondResponse:
			return stateVector[0] == State.main_region_NotFree_notFree_WaitForSecondResponse;
		case main_region_NotFree_notFree_BeforeFirstReserve:
			return stateVector[0] == State.main_region_NotFree_notFree_BeforeFirstReserve;
		default:
			return false;
		}
	}

	/**
	 * Set the {@link ITimer} for the state machine. It must be set externally
	 * on a timed state machine before a run cycle can be correct executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}

	/**
	 * Returns the currently used timer.
	 * 
	 * @return {@link ITimer}
	 */
	public ITimer getTimer() {
		return timer;
	}

	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}

	public SCISection getSCISection() {
		return sCISection;
	}

	public SCIDirection getSCIDirection() {
		return sCIDirection;
	}

	private boolean check_main_region_Free_tr0_tr0() {
		return sCISection.occupy;
	}

	private boolean check_main_region_Free_tr1_tr1() {
		return sCISection.reserveFromLeft;
	}

	private boolean check_main_region_Free_tr2_tr2() {
		return sCISection.reserveFromRight;
	}

	private boolean check_main_region_NotFree_lr0_lr0() {
		return sCISection.reserveFromLeft;
	}

	private boolean check_main_region_NotFree_lr1_lr1() {
		return sCISection.reserveFromRight;
	}

	private boolean check_main_region_NotFree_notFree_Stop_tr0_tr0() {
		return sCISection.unoccupy;
	}

	private boolean check_main_region_NotFree_notFree_Stop_tr1_tr1() {
		return sCISection.reset;
	}

	private boolean check_main_region_NotFree_notFree_WaitingForResponse_tr0_tr0() {
		return (sCISection.reserveResult) && (sCISection.getReserveResultValue() == false);
	}

	private boolean check_main_region_NotFree_notFree_WaitingForResponse_tr1_tr1() {
		return (sCISection.reserveResult) && (sCISection.getReserveResultValue() == true);
	}

	private boolean check_main_region_NotFree_notFree_WaitingForResponse_tr2_tr2() {
		return timeEvents[0];
	}

	private boolean check_main_region_NotFree_notFree_Occupied_tr0_tr0() {
		return sCISection.release;
	}

	private boolean check_main_region_NotFree_notFree_Occupied_tr1_tr1() {
		return sCISection.unoccupy;
	}

	private boolean check_main_region_NotFree_notFree_Reserved_tr0_tr0() {
		return sCISection.occupy;
	}

	private boolean check_main_region_NotFree_notFree_Reserved_tr1_tr1() {
		return sCISection.release;
	}

	private boolean check_main_region_NotFree_notFree_WaitForFirstResponse_tr0_tr0() {
		return (sCISection.reserveResult) && (sCISection.getReserveResultValue() == false);
	}

	private boolean check_main_region_NotFree_notFree_WaitForFirstResponse_tr1_tr1() {
		return (sCISection.reserveResult) && (sCISection.getReserveResultValue() == true);
	}

	private boolean check_main_region_NotFree_notFree_WaitForSecondResponse_tr0_tr0() {
		return (sCISection.reserveResult) && (sCISection.getReserveResultValue() == false);
	}

	private boolean check_main_region_NotFree_notFree_WaitForSecondResponse_tr1_tr1() {
		return (sCISection.reserveResult) && (sCISection.getReserveResultValue() == true);
	}

	private boolean check_main_region_NotFree_notFree_WaitForSecondResponse_tr2_tr2() {
		return timeEvents[1];
	}

	private boolean check_main_region_NotFree_notFree_BeforeFirstReserve_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_NotFree_notFree__choice_0_tr0_tr0() {
		return sCISection.dir == sCIDirection.lEFT;
	}

	private boolean check_main_region_NotFree_notFree__choice_0_tr1_tr1() {
		return sCISection.dir == sCIDirection.rIGHT;
	}

	private boolean check_main_region_NotFree_notFree__choice_1_tr0_tr0() {
		return sCISection.dir == sCIDirection.lEFT;
	}

	private boolean check_main_region_NotFree_notFree__choice_1_tr1_tr1() {
		return sCISection.dir == sCIDirection.rIGHT;
	}

	private void effect_main_region_Free_tr0() {
		exitSequence_main_region_Free();

		sCISection.raiseReserveLeft();

		enterSequence_main_region_NotFree_notFree_WaitForFirstResponse_default();
	}

	private void effect_main_region_Free_tr1() {
		exitSequence_main_region_Free();

		sCISection.raiseReserveResultToLeft(true);

		sCISection.setDir(sCIDirection.rIGHT);

		enterSequence_main_region_NotFree_default();
	}

	private void effect_main_region_Free_tr2() {
		exitSequence_main_region_Free();

		sCISection.raiseReserveResultToRight(true);

		sCISection.setDir(sCIDirection.lEFT);

		enterSequence_main_region_NotFree_default();
	}

	private void effect_main_region_NotFree_lr0_lr0() {
		sCISection.raiseReserveResultToLeft(false);
	}

	private void effect_main_region_NotFree_lr1_lr1() {
		sCISection.raiseReserveResultToRight(false);
	}

	private void effect_main_region_NotFree_notFree_Stop_tr0() {
		exitSequence_main_region_NotFree();

		enterSequence_main_region_Free_default();
	}

	private void effect_main_region_NotFree_notFree_Stop_tr1() {
		exitSequence_main_region_NotFree_notFree_Stop();

		enterSequence_main_region_NotFree_notFree_BeforeFirstReserve_default();
	}

	private void effect_main_region_NotFree_notFree_WaitingForResponse_tr0() {
		exitSequence_main_region_NotFree_notFree_WaitingForResponse();

		sCISection.raiseStop();

		enterSequence_main_region_NotFree_notFree_Stop_default();
	}

	private void effect_main_region_NotFree_notFree_WaitingForResponse_tr1() {
		exitSequence_main_region_NotFree_notFree_WaitingForResponse();

		enterSequence_main_region_NotFree_notFree_Occupied_default();
	}

	private void effect_main_region_NotFree_notFree_WaitingForResponse_tr2() {
		exitSequence_main_region_NotFree_notFree_WaitingForResponse();

		react_main_region_NotFree_notFree__choice_1();
	}

	private void effect_main_region_NotFree_notFree_Occupied_tr0() {
		exitSequence_main_region_NotFree();

		sCISection.raiseReleaseLeft();

		sCISection.raiseReleaseRight();

		enterSequence_main_region_Free_default();
	}

	private void effect_main_region_NotFree_notFree_Occupied_tr1() {
		exitSequence_main_region_NotFree_notFree_Occupied();

		react_main_region_NotFree_notFree__choice_0();
	}

	private void effect_main_region_NotFree_notFree_Reserved_tr0() {
		exitSequence_main_region_NotFree_notFree_Reserved();

		react_main_region_NotFree_notFree__choice_1();
	}

	private void effect_main_region_NotFree_notFree_Reserved_tr1() {
		exitSequence_main_region_NotFree();

		enterSequence_main_region_Free_default();
	}

	private void effect_main_region_NotFree_notFree_WaitForFirstResponse_tr0() {
		exitSequence_main_region_NotFree_notFree_WaitForFirstResponse();

		enterSequence_main_region_NotFree_notFree_Stop_default();
	}

	private void effect_main_region_NotFree_notFree_WaitForFirstResponse_tr1() {
		exitSequence_main_region_NotFree_notFree_WaitForFirstResponse();

		sCISection.raiseReserveRight();

		enterSequence_main_region_NotFree_notFree_WaitForSecondResponse_default();
	}

	private void effect_main_region_NotFree_notFree_WaitForSecondResponse_tr0() {
		exitSequence_main_region_NotFree_notFree_WaitForSecondResponse();

		enterSequence_main_region_NotFree_notFree_Stop_default();
	}

	private void effect_main_region_NotFree_notFree_WaitForSecondResponse_tr1() {
		exitSequence_main_region_NotFree_notFree_WaitForSecondResponse();

		enterSequence_main_region_NotFree_notFree_Occupied_default();
	}

	private void effect_main_region_NotFree_notFree_WaitForSecondResponse_tr2() {
		exitSequence_main_region_NotFree_notFree_WaitForSecondResponse();

		sCISection.raiseReserveLeft();

		enterSequence_main_region_NotFree_notFree_WaitForFirstResponse_default();
	}

	private void effect_main_region_NotFree_notFree_BeforeFirstReserve_tr0() {
		exitSequence_main_region_NotFree_notFree_BeforeFirstReserve();

		sCISection.raiseReserveLeft();

		enterSequence_main_region_NotFree_notFree_WaitForFirstResponse_default();
	}

	private void effect_main_region_NotFree_notFree__choice_0_tr0() {
		sCISection.raiseReleaseRight();

		enterSequence_main_region_NotFree_notFree_Reserved_default();
	}

	private void effect_main_region_NotFree_notFree__choice_0_tr1() {
		sCISection.raiseReleaseLeft();

		enterSequence_main_region_NotFree_notFree_Reserved_default();
	}

	private void effect_main_region_NotFree_notFree__choice_1_tr0() {
		sCISection.raiseReserveLeft();

		enterSequence_main_region_NotFree_notFree_WaitingForResponse_default();
	}

	private void effect_main_region_NotFree_notFree__choice_1_tr1() {
		sCISection.raiseReserveRight();

		enterSequence_main_region_NotFree_notFree_WaitingForResponse_default();
	}

	/* Entry action for state 'Free'. */
	private void entryAction_main_region_Free() {
		sCISection.setDir(sCIDirection.rIGHT);
	}

	/* Entry action for state 'WaitingForResponse'. */
	private void entryAction_main_region_NotFree_notFree_WaitingForResponse() {

		timer.setTimer(this, 0, sCISection.timeout, false);
	}

	/* Entry action for state 'WaitForSecondResponse'. */
	private void entryAction_main_region_NotFree_notFree_WaitForSecondResponse() {

		timer.setTimer(this, 1, sCISection.timeout, false);
	}

	/* Exit action for state 'Stop'. */
	private void exitAction_main_region_NotFree_notFree_Stop() {
		sCISection.raiseReleaseLeft();

		sCISection.raiseReleaseRight();
	}

	/* Exit action for state 'WaitingForResponse'. */
	private void exitAction_main_region_NotFree_notFree_WaitingForResponse() {
		timer.unsetTimer(this, 0);
	}

	/* Exit action for state 'WaitForSecondResponse'. */
	private void exitAction_main_region_NotFree_notFree_WaitForSecondResponse() {
		timer.unsetTimer(this, 1);
	}

	/* 'default' enter sequence for state Free */
	private void enterSequence_main_region_Free_default() {
		entryAction_main_region_Free();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Free;
	}

	/* 'default' enter sequence for state NotFree */
	private void enterSequence_main_region_NotFree_default() {
		enterSequence_main_region_NotFree_notFree_default();
	}

	/* 'default' enter sequence for state Stop */
	private void enterSequence_main_region_NotFree_notFree_Stop_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_Stop;
	}

	/* 'default' enter sequence for state WaitingForResponse */
	private void enterSequence_main_region_NotFree_notFree_WaitingForResponse_default() {
		entryAction_main_region_NotFree_notFree_WaitingForResponse();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_WaitingForResponse;
	}

	/* 'default' enter sequence for state Occupied */
	private void enterSequence_main_region_NotFree_notFree_Occupied_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_Occupied;
	}

	/* 'default' enter sequence for state Reserved */
	private void enterSequence_main_region_NotFree_notFree_Reserved_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_Reserved;
	}

	/* 'default' enter sequence for state WaitForFirstResponse */
	private void enterSequence_main_region_NotFree_notFree_WaitForFirstResponse_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_WaitForFirstResponse;
	}

	/* 'default' enter sequence for state WaitForSecondResponse */
	private void enterSequence_main_region_NotFree_notFree_WaitForSecondResponse_default() {
		entryAction_main_region_NotFree_notFree_WaitForSecondResponse();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_WaitForSecondResponse;
	}

	/* 'default' enter sequence for state BeforeFirstReserve */
	private void enterSequence_main_region_NotFree_notFree_BeforeFirstReserve_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_BeforeFirstReserve;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* 'default' enter sequence for region notFree */
	private void enterSequence_main_region_NotFree_notFree_default() {
		react_main_region_NotFree_notFree__entry_Default();
	}

	/* Default exit sequence for state Free */
	private void exitSequence_main_region_Free() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state NotFree */
	private void exitSequence_main_region_NotFree() {
		exitSequence_main_region_NotFree_notFree();
	}

	/* Default exit sequence for state Stop */
	private void exitSequence_main_region_NotFree_notFree_Stop() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_NotFree_notFree_Stop();
	}

	/* Default exit sequence for state WaitingForResponse */
	private void exitSequence_main_region_NotFree_notFree_WaitingForResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_NotFree_notFree_WaitingForResponse();
	}

	/* Default exit sequence for state Occupied */
	private void exitSequence_main_region_NotFree_notFree_Occupied() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Reserved */
	private void exitSequence_main_region_NotFree_notFree_Reserved() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state WaitForFirstResponse */
	private void exitSequence_main_region_NotFree_notFree_WaitForFirstResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state WaitForSecondResponse */
	private void exitSequence_main_region_NotFree_notFree_WaitForSecondResponse() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		exitAction_main_region_NotFree_notFree_WaitForSecondResponse();
	}

	/* Default exit sequence for state BeforeFirstReserve */
	private void exitSequence_main_region_NotFree_notFree_BeforeFirstReserve() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_Free:
			exitSequence_main_region_Free();
			break;

		case main_region_NotFree_notFree_Stop:
			exitSequence_main_region_NotFree_notFree_Stop();
			break;

		case main_region_NotFree_notFree_WaitingForResponse:
			exitSequence_main_region_NotFree_notFree_WaitingForResponse();
			break;

		case main_region_NotFree_notFree_Occupied:
			exitSequence_main_region_NotFree_notFree_Occupied();
			break;

		case main_region_NotFree_notFree_Reserved:
			exitSequence_main_region_NotFree_notFree_Reserved();
			break;

		case main_region_NotFree_notFree_WaitForFirstResponse:
			exitSequence_main_region_NotFree_notFree_WaitForFirstResponse();
			break;

		case main_region_NotFree_notFree_WaitForSecondResponse:
			exitSequence_main_region_NotFree_notFree_WaitForSecondResponse();
			break;

		case main_region_NotFree_notFree_BeforeFirstReserve:
			exitSequence_main_region_NotFree_notFree_BeforeFirstReserve();
			break;

		default:
			break;
		}
	}

	/* Default exit sequence for region notFree */
	private void exitSequence_main_region_NotFree_notFree() {
		switch (stateVector[0]) {
		case main_region_NotFree_notFree_Stop:
			exitSequence_main_region_NotFree_notFree_Stop();
			break;

		case main_region_NotFree_notFree_WaitingForResponse:
			exitSequence_main_region_NotFree_notFree_WaitingForResponse();
			break;

		case main_region_NotFree_notFree_Occupied:
			exitSequence_main_region_NotFree_notFree_Occupied();
			break;

		case main_region_NotFree_notFree_Reserved:
			exitSequence_main_region_NotFree_notFree_Reserved();
			break;

		case main_region_NotFree_notFree_WaitForFirstResponse:
			exitSequence_main_region_NotFree_notFree_WaitForFirstResponse();
			break;

		case main_region_NotFree_notFree_WaitForSecondResponse:
			exitSequence_main_region_NotFree_notFree_WaitForSecondResponse();
			break;

		case main_region_NotFree_notFree_BeforeFirstReserve:
			exitSequence_main_region_NotFree_notFree_BeforeFirstReserve();
			break;

		default:
			break;
		}
	}

	/* The reactions of state Free. */
	private void react_main_region_Free() {
		if (check_main_region_Free_tr0_tr0()) {
			effect_main_region_Free_tr0();
		} else {
			if (check_main_region_Free_tr1_tr1()) {
				effect_main_region_Free_tr1();
			} else {
				if (check_main_region_Free_tr2_tr2()) {
					effect_main_region_Free_tr2();
				}
			}
		}
	}

	/* The reactions of state Stop. */
	private void react_main_region_NotFree_notFree_Stop() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		if (check_main_region_NotFree_notFree_Stop_tr0_tr0()) {
			effect_main_region_NotFree_notFree_Stop_tr0();
		} else {
			if (check_main_region_NotFree_notFree_Stop_tr1_tr1()) {
				effect_main_region_NotFree_notFree_Stop_tr1();
			}
		}
	}

	/* The reactions of state WaitingForResponse. */
	private void react_main_region_NotFree_notFree_WaitingForResponse() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		if (check_main_region_NotFree_notFree_WaitingForResponse_tr0_tr0()) {
			effect_main_region_NotFree_notFree_WaitingForResponse_tr0();
		} else {
			if (check_main_region_NotFree_notFree_WaitingForResponse_tr1_tr1()) {
				effect_main_region_NotFree_notFree_WaitingForResponse_tr1();
			} else {
				if (check_main_region_NotFree_notFree_WaitingForResponse_tr2_tr2()) {
					effect_main_region_NotFree_notFree_WaitingForResponse_tr2();
				}
			}
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_region_NotFree_notFree_Occupied() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		if (check_main_region_NotFree_notFree_Occupied_tr0_tr0()) {
			effect_main_region_NotFree_notFree_Occupied_tr0();
		} else {
			if (check_main_region_NotFree_notFree_Occupied_tr1_tr1()) {
				effect_main_region_NotFree_notFree_Occupied_tr1();
			}
		}
	}

	/* The reactions of state Reserved. */
	private void react_main_region_NotFree_notFree_Reserved() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		if (check_main_region_NotFree_notFree_Reserved_tr0_tr0()) {
			effect_main_region_NotFree_notFree_Reserved_tr0();
		} else {
			if (check_main_region_NotFree_notFree_Reserved_tr1_tr1()) {
				effect_main_region_NotFree_notFree_Reserved_tr1();
			}
		}
	}

	/* The reactions of state WaitForFirstResponse. */
	private void react_main_region_NotFree_notFree_WaitForFirstResponse() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		if (check_main_region_NotFree_notFree_WaitForFirstResponse_tr0_tr0()) {
			effect_main_region_NotFree_notFree_WaitForFirstResponse_tr0();
		} else {
			if (check_main_region_NotFree_notFree_WaitForFirstResponse_tr1_tr1()) {
				effect_main_region_NotFree_notFree_WaitForFirstResponse_tr1();
			}
		}
	}

	/* The reactions of state WaitForSecondResponse. */
	private void react_main_region_NotFree_notFree_WaitForSecondResponse() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		if (check_main_region_NotFree_notFree_WaitForSecondResponse_tr0_tr0()) {
			effect_main_region_NotFree_notFree_WaitForSecondResponse_tr0();
		} else {
			if (check_main_region_NotFree_notFree_WaitForSecondResponse_tr1_tr1()) {
				effect_main_region_NotFree_notFree_WaitForSecondResponse_tr1();
			} else {
				if (check_main_region_NotFree_notFree_WaitForSecondResponse_tr2_tr2()) {
					effect_main_region_NotFree_notFree_WaitForSecondResponse_tr2();
				}
			}
		}
	}

	/* The reactions of state BeforeFirstReserve. */
	private void react_main_region_NotFree_notFree_BeforeFirstReserve() {
		if (check_main_region_NotFree_lr0_lr0()) {
			effect_main_region_NotFree_lr0_lr0();
		}

		if (check_main_region_NotFree_lr1_lr1()) {
			effect_main_region_NotFree_lr1_lr1();
		}

		effect_main_region_NotFree_notFree_BeforeFirstReserve_tr0();
	}

	/* The reactions of state null. */
	private void react_main_region_NotFree_notFree__choice_0() {
		if (check_main_region_NotFree_notFree__choice_0_tr0_tr0()) {
			effect_main_region_NotFree_notFree__choice_0_tr0();
		} else {
			if (check_main_region_NotFree_notFree__choice_0_tr1_tr1()) {
				effect_main_region_NotFree_notFree__choice_0_tr1();
			}
		}
	}

	/* The reactions of state null. */
	private void react_main_region_NotFree_notFree__choice_1() {
		if (check_main_region_NotFree_notFree__choice_1_tr0_tr0()) {
			effect_main_region_NotFree_notFree__choice_1_tr0();
		} else {
			if (check_main_region_NotFree_notFree__choice_1_tr1_tr1()) {
				effect_main_region_NotFree_notFree__choice_1_tr1();
			}
		}
	}

	/* Default react sequence for initial entry */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Free_default();
	}

	/* Default react sequence for initial entry */
	private void react_main_region_NotFree_notFree__entry_Default() {
		enterSequence_main_region_NotFree_notFree_Reserved_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
			case main_region_Free:
				react_main_region_Free();
				break;
			case main_region_NotFree_notFree_Stop:
				react_main_region_NotFree_notFree_Stop();
				break;
			case main_region_NotFree_notFree_WaitingForResponse:
				react_main_region_NotFree_notFree_WaitingForResponse();
				break;
			case main_region_NotFree_notFree_Occupied:
				react_main_region_NotFree_notFree_Occupied();
				break;
			case main_region_NotFree_notFree_Reserved:
				react_main_region_NotFree_notFree_Reserved();
				break;
			case main_region_NotFree_notFree_WaitForFirstResponse:
				react_main_region_NotFree_notFree_WaitForFirstResponse();
				break;
			case main_region_NotFree_notFree_WaitForSecondResponse:
				react_main_region_NotFree_notFree_WaitForSecondResponse();
				break;
			case main_region_NotFree_notFree_BeforeFirstReserve:
				react_main_region_NotFree_notFree_BeforeFirstReserve();
				break;
			default:
				// $NullState$
			}
		}

		clearEvents();
	}
}
