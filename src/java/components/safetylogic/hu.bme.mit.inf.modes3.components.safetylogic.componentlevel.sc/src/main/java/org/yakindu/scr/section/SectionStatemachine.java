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

		private int id;

		public int getId() {
			return id;
		}

		public void setId(int value) {
			this.id = value;
		}

		private int timeout;

		public int getTimeout() {
			return timeout;
		}

		public void setTimeout(int value) {
			this.timeout = value;
		}

		private int dir;

		public int getDir() {
			return dir;
		}

		public void setDir(int value) {
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

		public int getLEFT() {
			return lEFT;
		}

		public int getRIGHT() {
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
		sCISection.setDir(sCIDirection.rIGHT);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Free;
	}

	public void exit() {
		switch (stateVector[0]) {
		case main_region_Free:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_NotFree_notFree_Stop:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCISection.raiseReleaseLeft();

			sCISection.raiseReleaseRight();
			break;

		case main_region_NotFree_notFree_WaitingForResponse:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 0);
			break;

		case main_region_NotFree_notFree_Occupied:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_NotFree_notFree_Reserved:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_NotFree_notFree_WaitForFirstResponse:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_NotFree_notFree_WaitForSecondResponse:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 1);
			break;

		case main_region_NotFree_notFree_BeforeFirstReserve:
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

	/* The reactions of state Free. */
	private void react_main_region_Free() {
		if (sCISection.occupy) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCISection.raiseReserveLeft();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_NotFree_notFree_WaitForFirstResponse;
		} else {
			if (sCISection.reserveFromLeft) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseReserveResultToLeft(true);

				sCISection.setDir(sCIDirection.rIGHT);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_Reserved;
			} else {
				if (sCISection.reserveFromRight) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCISection.raiseReserveResultToRight(true);

					sCISection.setDir(sCIDirection.lEFT);

					nextStateIndex = 0;
					stateVector[0] = State.main_region_NotFree_notFree_Reserved;
				}
			}
		}
	}

	/* The reactions of state Stop. */
	private void react_main_region_NotFree_notFree_Stop() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		if (sCISection.unoccupy) {
			switch (stateVector[0]) {
			case main_region_NotFree_notFree_Stop:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseReleaseLeft();

				sCISection.raiseReleaseRight();
				break;

			case main_region_NotFree_notFree_WaitingForResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 0);
				break;

			case main_region_NotFree_notFree_Occupied:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_NotFree_notFree_Reserved:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_NotFree_notFree_WaitForFirstResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_NotFree_notFree_WaitForSecondResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 1);
				break;

			case main_region_NotFree_notFree_BeforeFirstReserve:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			sCISection.setDir(sCIDirection.rIGHT);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Free;
		} else {
			if (sCISection.reset) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseReleaseLeft();

				sCISection.raiseReleaseRight();

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_BeforeFirstReserve;
			}
		}
	}

	/* The reactions of state WaitingForResponse. */
	private void react_main_region_NotFree_notFree_WaitingForResponse() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		if ((sCISection.reserveResult) && (sCISection.getReserveResultValue() == false)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 0);

			sCISection.raiseStop();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_NotFree_notFree_Stop;
		} else {
			if ((sCISection.reserveResult) && (sCISection.getReserveResultValue() == true)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 0);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_Occupied;
			} else {
				if (timeEvents[0]) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 0);

					react_main_region_NotFree_notFree__choice_1();
				}
			}
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_region_NotFree_notFree_Occupied() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		if (sCISection.release) {
			switch (stateVector[0]) {
			case main_region_NotFree_notFree_Stop:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseReleaseLeft();

				sCISection.raiseReleaseRight();
				break;

			case main_region_NotFree_notFree_WaitingForResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 0);
				break;

			case main_region_NotFree_notFree_Occupied:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_NotFree_notFree_Reserved:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_NotFree_notFree_WaitForFirstResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_NotFree_notFree_WaitForSecondResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 1);
				break;

			case main_region_NotFree_notFree_BeforeFirstReserve:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			sCISection.raiseReleaseLeft();

			sCISection.raiseReleaseRight();

			sCISection.setDir(sCIDirection.rIGHT);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Free;
		} else {
			if (sCISection.unoccupy) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				react_main_region_NotFree_notFree__choice_0();
			}
		}
	}

	/* The reactions of state Reserved. */
	private void react_main_region_NotFree_notFree_Reserved() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		if (sCISection.occupy) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			react_main_region_NotFree_notFree__choice_1();
		} else {
			if (sCISection.release) {
				switch (stateVector[0]) {
				case main_region_NotFree_notFree_Stop:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCISection.raiseReleaseLeft();

					sCISection.raiseReleaseRight();
					break;

				case main_region_NotFree_notFree_WaitingForResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 0);
					break;

				case main_region_NotFree_notFree_Occupied:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_NotFree_notFree_Reserved:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_NotFree_notFree_WaitForFirstResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case main_region_NotFree_notFree_WaitForSecondResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);
					break;

				case main_region_NotFree_notFree_BeforeFirstReserve:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default:
					break;
				}

				sCISection.setDir(sCIDirection.rIGHT);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Free;
			}
		}
	}

	/* The reactions of state WaitForFirstResponse. */
	private void react_main_region_NotFree_notFree_WaitForFirstResponse() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		if ((sCISection.reserveResult) && (sCISection.getReserveResultValue() == false)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.main_region_NotFree_notFree_Stop;
		} else {
			if ((sCISection.reserveResult) && (sCISection.getReserveResultValue() == true)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseReserveRight();

				timer.setTimer(this, 1, sCISection.timeout, false);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_WaitForSecondResponse;
			}
		}
	}

	/* The reactions of state WaitForSecondResponse. */
	private void react_main_region_NotFree_notFree_WaitForSecondResponse() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		if ((sCISection.reserveResult) && (sCISection.getReserveResultValue() == false)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			timer.unsetTimer(this, 1);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_NotFree_notFree_Stop;
		} else {
			if ((sCISection.reserveResult) && (sCISection.getReserveResultValue() == true)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				timer.unsetTimer(this, 1);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_Occupied;
			} else {
				if (timeEvents[1]) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					timer.unsetTimer(this, 1);

					sCISection.raiseReserveLeft();

					nextStateIndex = 0;
					stateVector[0] = State.main_region_NotFree_notFree_WaitForFirstResponse;
				}
			}
		}
	}

	/* The reactions of state BeforeFirstReserve. */
	private void react_main_region_NotFree_notFree_BeforeFirstReserve() {
		if (sCISection.reserveFromLeft) {
			sCISection.raiseReserveResultToLeft(false);
		}

		if (sCISection.reserveFromRight) {
			sCISection.raiseReserveResultToRight(false);
		}

		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCISection.raiseReserveLeft();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_NotFree_notFree_WaitForFirstResponse;
	}

	/* The reactions of state null. */
	private void react_main_region_NotFree_notFree__choice_0() {
		if (sCISection.dir == sCIDirection.lEFT) {
			sCISection.raiseReleaseRight();

			nextStateIndex = 0;
			stateVector[0] = State.main_region_NotFree_notFree_Reserved;
		} else {
			if (sCISection.dir == sCIDirection.rIGHT) {
				sCISection.raiseReleaseLeft();

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_Reserved;
			}
		}
	}

	/* The reactions of state null. */
	private void react_main_region_NotFree_notFree__choice_1() {
		if (sCISection.dir == sCIDirection.lEFT) {
			sCISection.raiseReserveLeft();

			timer.setTimer(this, 0, sCISection.timeout, false);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_NotFree_notFree_WaitingForResponse;
		} else {
			if (sCISection.dir == sCIDirection.rIGHT) {
				sCISection.raiseReserveRight();

				timer.setTimer(this, 0, sCISection.timeout, false);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_NotFree_notFree_WaitingForResponse;
			}
		}
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
