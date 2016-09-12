package org.yakindu.scr.section;

import java.util.List;

import org.yakindu.scr.ITimer;
import org.yakindu.scr.ITimerCallback;
import org.yakindu.scr.section.SectionStatemachine.State;

/**
 * Runnable wrapper of SectionStatemachine. This wrapper provides a thread-safe
 * instance of the state machine.
 * 
 * Please report bugs and issues...
 */

public class SynchronizedSectionStatemachine implements ISectionStatemachine {

	/**
	 * The core state machine is simply wrapped and the event processing will be
	 * delegated to that state machine instance. This instance will be created
	 * implicitly.
	 */
	protected SectionStatemachine statemachine = new SectionStatemachine();

	/**
	 * Interface object for SCISection
	 */
	protected class SynchronizedSCISection implements SCISection {

		public List<SCISectionListener> getListeners() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getListeners();
			}
		}

		public void raiseReserveFromLeft() {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseReserveFromLeft();
				statemachine.runCycle();
			}
		}

		public void raiseReserveFromRight() {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseReserveFromRight();
				statemachine.runCycle();
			}
		}

		public void raiseReserveResult(final boolean value) {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseReserveResult(value);
				statemachine.runCycle();
			}
		}

		public void raiseOccupy() {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseOccupy();
				statemachine.runCycle();
			}
		}

		public void raiseUnoccupy() {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseUnoccupy();
				statemachine.runCycle();
			}
		}

		public void raiseReset() {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseReset();
				statemachine.runCycle();
			}
		}

		public void raiseRelease() {

			synchronized (statemachine) {
				statemachine.getSCISection().raiseRelease();
				statemachine.runCycle();
			}
		}

		public boolean isRaisedReserveLeft() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedReserveLeft();
			}
		}

		public boolean isRaisedReserveRight() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedReserveRight();
			}
		}

		public boolean isRaisedReserveResultToLeft() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedReserveResultToLeft();
			}
		}

		public boolean getReserveResultToLeftValue() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getReserveResultToLeftValue();
			}
		}

		public boolean isRaisedReserveResultToRight() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedReserveResultToRight();
			}
		}

		public boolean getReserveResultToRightValue() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getReserveResultToRightValue();
			}
		}

		public boolean isRaisedReleaseLeft() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedReleaseLeft();
			}
		}

		public boolean isRaisedReleaseRight() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedReleaseRight();
			}
		}

		public boolean isRaisedStop() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedStop();
			}
		}

		public int getId() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getId();
			}
		}

		public void setId(final int value) {
			synchronized (statemachine) {
				statemachine.getSCISection().setId(value);
			}
		}

		public int getTimeout() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getTimeout();
			}
		}

		public void setTimeout(final int value) {
			synchronized (statemachine) {
				statemachine.getSCISection().setTimeout(value);
			}
		}

		public int getDir() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getDir();
			}
		}

		public void setDir(final int value) {
			synchronized (statemachine) {
				statemachine.getSCISection().setDir(value);
			}
		}

	};

	protected SCISection sCISection;

	/**
	 * Interface object for SCIDirection
	 */
	protected class SynchronizedSCIDirection implements SCIDirection {

		public int getLEFT() {
			synchronized (statemachine) {
				return statemachine.getSCIDirection().getLEFT();
			}
		}

		public int getRIGHT() {
			synchronized (statemachine) {
				return statemachine.getSCIDirection().getRIGHT();
			}
		}

	};

	protected SCIDirection sCIDirection;

	public SynchronizedSectionStatemachine() {
		sCISection = new SynchronizedSCISection();
		sCIDirection = new SynchronizedSCIDirection();
	}

	public synchronized SCISection getSCISection() {
		return sCISection;
	}

	public synchronized SCIDirection getSCIDirection() {
		return sCIDirection;
	}

	/*
	 * ================ TIME EVENT HANDLING ================
	 * 
	 * /** An external timer instance is required.
	 */
	protected ITimer externalTimer;

	/**
	 * Internally we use a timer proxy that queues time events together with
	 * other input events.
	 */
	protected ITimer timerProxy = new ITimer() {
		/** Simply delegate to external timer with a modified callback. */
		@Override
		public void setTimer(ITimerCallback callback, int eventID, long time, boolean isPeriodic) {
			externalTimer.setTimer(SynchronizedSectionStatemachine.this, eventID, time, isPeriodic);
		}

		@Override
		public void unsetTimer(ITimerCallback callback, int eventID) {
			externalTimer.unsetTimer(SynchronizedSectionStatemachine.this, eventID);
		}
	};

	/**
	 * Set the {@link ITimer} for the state machine. It must be set externally
	 * on a timed state machine before a run cycle can be correct executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ITimer timer) {
		synchronized (statemachine) {
			this.externalTimer = timer;
			/* the wrapped state machine uses timer proxy as timer */
			statemachine.setTimer(timerProxy);
		}
	}

	/**
	 * Returns the currently used timer.
	 * 
	 * @return {@link ITimer}
	 */
	public ITimer getTimer() {
		return externalTimer;
	}

	public void timeElapsed(int eventID) {
		synchronized (statemachine) {
			statemachine.timeElapsed(eventID);
		}
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
