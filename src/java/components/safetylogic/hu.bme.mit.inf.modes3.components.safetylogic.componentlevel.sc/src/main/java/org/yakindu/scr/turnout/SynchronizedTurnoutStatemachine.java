package org.yakindu.scr.turnout;

import java.util.List;

import org.yakindu.scr.turnout.TurnoutStatemachine.State;

/**
 * Runnable wrapper of TurnoutStatemachine. This wrapper provides a thread-safe
 * instance of the state machine.
 * 
 * Please report bugs and issues...
 */

public class SynchronizedTurnoutStatemachine implements ITurnoutStatemachine {

	/**
	 * The core state machine is simply wrapped and the event processing will be
	 * delegated to that state machine instance. This instance will be created
	 * implicitly.
	 */
	protected TurnoutStatemachine statemachine = new TurnoutStatemachine();

	/**
	 * Interface object for SCITurnout
	 */
	protected class SynchronizedSCITurnout implements SCITurnout {

		public List<SCITurnoutListener> getListeners() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().getListeners();
			}
		}

		public void raiseSwitch() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseSwitch();
				statemachine.runCycle();
			}
		}

		public void raiseReserveFromLeft() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReserveFromLeft();
				statemachine.runCycle();
			}
		}

		public void raiseReserveFromRight() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReserveFromRight();
				statemachine.runCycle();
			}
		}

		public void raiseReserveFromBottom() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReserveFromBottom();
				statemachine.runCycle();
			}
		}

		public void raiseReserveResultFromLeft(final boolean value) {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReserveResultFromLeft(value);
				statemachine.runCycle();
			}
		}

		public void raiseReserveResultFromRight(final boolean value) {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReserveResultFromRight(value);
				statemachine.runCycle();
			}
		}

		public void raiseReserveResultFromBottom(final boolean value) {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReserveResultFromBottom(value);
				statemachine.runCycle();
			}
		}

		public void raiseReleaseFromLeft() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReleaseFromLeft();
				statemachine.runCycle();
			}
		}

		public void raiseReleaseFromRight() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReleaseFromRight();
				statemachine.runCycle();
			}
		}

		public void raiseReleaseFromBottom() {

			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseReleaseFromBottom();
				statemachine.runCycle();
			}
		}

		public boolean isRaisedReserveLeft() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReserveLeft();
			}
		}

		public boolean isRaisedReserveRight() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReserveRight();
			}
		}

		public boolean isRaisedReserveBottom() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReserveBottom();
			}
		}

		public boolean isRaisedReserveResultToLeft() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReserveResultToLeft();
			}
		}

		public boolean getReserveResultToLeftValue() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().getReserveResultToLeftValue();
			}
		}

		public boolean isRaisedReserveResultToRight() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReserveResultToRight();
			}
		}

		public boolean getReserveResultToRightValue() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().getReserveResultToRightValue();
			}
		}

		public boolean isRaisedReserveResultToBottom() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReserveResultToBottom();
			}
		}

		public boolean getReserveResultToBottomValue() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().getReserveResultToBottomValue();
			}
		}

		public boolean isRaisedReleaseLeft() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReleaseLeft();
			}
		}

		public boolean isRaisedReleaseRight() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReleaseRight();
			}
		}

		public boolean isRaisedReleaseBottom() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().isRaisedReleaseBottom();
			}
		}

		public int getId() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().getId();
			}
		}

		public void setId(final int value) {
			synchronized (statemachine) {
				statemachine.getSCITurnout().setId(value);
			}
		}

		public int getCount() {
			synchronized (statemachine) {
				return statemachine.getSCITurnout().getCount();
			}
		}

		public void setCount(final int value) {
			synchronized (statemachine) {
				statemachine.getSCITurnout().setCount(value);
			}
		}

	};

	protected SCITurnout sCITurnout;

	public SynchronizedTurnoutStatemachine() {
		sCITurnout = new SynchronizedSCITurnout();
	}

	public synchronized SCITurnout getSCITurnout() {
		return sCITurnout;
	}

	/**
	 * init() will be delegated thread-safely to the wrapped state machine.
	 */
	public void init() {
		synchronized (statemachine) {
			statemachine.init();
		}
	}

	/**
	 * enter() will be delegated thread-safely to the wrapped state machine.
	 */
	public void enter() {
		synchronized (statemachine) {
			statemachine.enter();
		}
	}

	/**
	 * exit() will be delegated thread-safely to the wrapped state machine.
	 */
	public void exit() {
		synchronized (statemachine) {
			statemachine.exit();
		}
	}

	/**
	 * isActive() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isActive() {
		synchronized (statemachine) {
			return statemachine.isActive();
		}
	}

	/**
	 * isFinal() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isFinal() {
		synchronized (statemachine) {
			return statemachine.isFinal();
		}
	}

	/**
	 * isStateActive() will be delegated thread-safely to the wrapped state
	 * machine.
	 */
	public boolean isStateActive(State state) {
		synchronized (statemachine) {
			return statemachine.isStateActive(state);
		}
	}

	/**
	 * runCycle() will be delegated thread-safely to the wrapped state machine.
	 */
	@Override
	public void runCycle() {
		synchronized (statemachine) {
			statemachine.runCycle();
		}
	}
}
