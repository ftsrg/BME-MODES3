package org.yakindu.scr.section;

import java.util.List;

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

		public boolean isRaisedEnableSection() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedEnableSection();
			}
		}

		public int getEnableSectionValue() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getEnableSectionValue();
			}
		}

		public boolean isRaisedDisableSection() {
			synchronized (statemachine) {
				return statemachine.getSCISection().isRaisedDisableSection();
			}
		}

		public int getDisableSectionValue() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getDisableSectionValue();
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

		public int getLatestReserveDirection() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getLatestReserveDirection();
			}
		}

		public void setLatestReserveDirection(final int value) {
			synchronized (statemachine) {
				statemachine.getSCISection().setLatestReserveDirection(value);
			}
		}

		public int getNegatedReserveDirection() {
			synchronized (statemachine) {
				return statemachine.getSCISection().getNegatedReserveDirection();
			}
		}

		public void setNegatedReserveDirection(final int value) {
			synchronized (statemachine) {
				statemachine.getSCISection().setNegatedReserveDirection(value);
			}
		}

	};

	protected SCISection sCISection;

	/**
	 * Interface object for SCIProtocol
	 */
	protected class SynchronizedSCIProtocol implements SCIProtocol {

		public List<SCIProtocolListener> getListeners() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().getListeners();
			}
		}

		public void raiseReserveFrom(final int value) {

			synchronized (statemachine) {
				statemachine.getSCIProtocol().raiseReserveFrom(value);
				statemachine.runCycle();
			}
		}

		public void raiseCanGoFrom(final int value) {

			synchronized (statemachine) {
				statemachine.getSCIProtocol().raiseCanGoFrom(value);
				statemachine.runCycle();
			}
		}

		public void raiseCannotGoFrom(final int value) {

			synchronized (statemachine) {
				statemachine.getSCIProtocol().raiseCannotGoFrom(value);
				statemachine.runCycle();
			}
		}

		public void raiseReleaseFrom(final int value) {

			synchronized (statemachine) {
				statemachine.getSCIProtocol().raiseReleaseFrom(value);
				statemachine.runCycle();
			}
		}

		public void raiseRestartProtocol() {

			synchronized (statemachine) {
				statemachine.getSCIProtocol().raiseRestartProtocol();
				statemachine.runCycle();
			}
		}

		public boolean isRaisedReserveTo() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().isRaisedReserveTo();
			}
		}

		public int getReserveToValue() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().getReserveToValue();
			}
		}

		public boolean isRaisedCanGoTo() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().isRaisedCanGoTo();
			}
		}

		public int getCanGoToValue() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().getCanGoToValue();
			}
		}

		public boolean isRaisedCannotGoTo() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().isRaisedCannotGoTo();
			}
		}

		public int getCannotGoToValue() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().getCannotGoToValue();
			}
		}

		public boolean isRaisedReleaseTo() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().isRaisedReleaseTo();
			}
		}

		public int getReleaseToValue() {
			synchronized (statemachine) {
				return statemachine.getSCIProtocol().getReleaseToValue();
			}
		}
	};

	protected SCIProtocol sCIProtocol;

	/**
	 * Interface object for SCITrain
	 */
	protected class SynchronizedSCITrain implements SCITrain {

		public void raiseOccupy() {

			synchronized (statemachine) {
				statemachine.getSCITrain().raiseOccupy();
				statemachine.runCycle();
			}
		}

		public void raiseUnoccupy() {

			synchronized (statemachine) {
				statemachine.getSCITrain().raiseUnoccupy();
				statemachine.runCycle();
			}
		}

	};

	protected SCITrain sCITrain;

	/**
	 * Interface object for SCIDirection
	 */
	protected class SynchronizedSCIDirection implements SCIDirection {

		public int getCW() {
			synchronized (statemachine) {
				return statemachine.getSCIDirection().getCW();
			}
		}

		public int getCCW() {
			synchronized (statemachine) {
				return statemachine.getSCIDirection().getCCW();
			}
		}

		public int getUNSPECIFIED() {
			synchronized (statemachine) {
				return statemachine.getSCIDirection().getUNSPECIFIED();
			}
		}

	};

	protected SCIDirection sCIDirection;

	public SynchronizedSectionStatemachine() {
		sCISection = new SynchronizedSCISection();
		sCIProtocol = new SynchronizedSCIProtocol();
		sCITrain = new SynchronizedSCITrain();
		sCIDirection = new SynchronizedSCIDirection();
	}

	public synchronized SCISection getSCISection() {
		return sCISection;
	}

	public synchronized SCIProtocol getSCIProtocol() {
		return sCIProtocol;
	}

	public synchronized SCITrain getSCITrain() {
		return sCITrain;
	}

	public synchronized SCIDirection getSCIDirection() {
		return sCIDirection;
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
