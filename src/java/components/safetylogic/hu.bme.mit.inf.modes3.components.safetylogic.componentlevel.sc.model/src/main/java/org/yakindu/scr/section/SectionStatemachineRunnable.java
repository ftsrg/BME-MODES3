package org.yakindu.scr.section;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Runnable wrapper of SectionStatemachine. This wrapper provides a thread-safe,
 * runnable instance of the state machine. The wrapper implements the
 * {@link Runnable} interface and can be started in a thread by the client code.
 * The run method then starts the main event processing loop for this state
 * machine.
 *
 * Please report bugs and issues...
 */

public class SectionStatemachineRunnable extends SynchronizedSectionStatemachine implements Runnable {

	/**
	 * The events are queued using a blocking queue without capacity
	 * restriction. This queue holds Runnable instances that process the events.
	 */
	protected BlockingQueue<Runnable> eventQueue = new LinkedBlockingQueue<Runnable>();

	/**
	 * Interface object for SCISection
	 */
	protected SCISection sCISection = new SynchronizedSCISection() {
	};

	/**
	 * Interface object for SCIProtocol
	 */
	protected SCIProtocol sCIProtocol = new SynchronizedSCIProtocol() {
		public void raiseReserveFrom(final int value) {

			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCIProtocol().raiseReserveFrom(value);
						statemachine.runCycle();
					}
				}
			});
		}

		public void raiseCanGoFrom(final int value) {

			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCIProtocol().raiseCanGoFrom(value);
						statemachine.runCycle();
					}
				}
			});
		}

		public void raiseCannotGoFrom(final int value) {

			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCIProtocol().raiseCannotGoFrom(value);
						statemachine.runCycle();
					}
				}
			});
		}

		public void raiseReleaseFrom(final int value) {

			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCIProtocol().raiseReleaseFrom(value);
						statemachine.runCycle();
					}
				}
			});
		}

		public void raiseRestartProtocol() {
			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCIProtocol().raiseRestartProtocol();
						statemachine.runCycle();
					}
				}
			});
		}

	};

	/**
	 * Interface object for SCITrain
	 */
	protected SCITrain sCITrain = new SynchronizedSCITrain() {
		public void raiseOccupy() {
			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCITrain().raiseOccupy();
						statemachine.runCycle();
					}
				}
			});
		}

		public void raiseUnoccupy() {
			eventQueue.add(new Runnable() {

				@Override
				public void run() {
					synchronized (statemachine) {
						statemachine.getSCITrain().raiseUnoccupy();
						statemachine.runCycle();
					}
				}
			});
		}

	};

	/**
	 * Interface object for SCIDirection
	 */
	protected SCIDirection sCIDirection = new SynchronizedSCIDirection() {
	};

	/**
	 * This method will start the main execution loop for the state machine.
	 * First it will init and enter the state machine implicitly and then will
	 * start processing events from the event queue until the thread is
	 * interrupted.
	 */
	@Override
	public void run() {

		boolean terminate = false;

		while (!(terminate || Thread.currentThread().isInterrupted())) {

			try {

				Runnable eventProcessor = eventQueue.take();
				eventProcessor.run();

			} catch (InterruptedException e) {
				terminate = true;
			}
		}
	}
}
