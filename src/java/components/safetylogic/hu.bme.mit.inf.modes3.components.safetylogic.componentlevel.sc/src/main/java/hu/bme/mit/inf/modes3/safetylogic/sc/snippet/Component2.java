package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

public class Component2 {

	private SectionComponent S18 = new SectionComponent();

	private SectionComponent S24 = new SectionComponent();

	private SectionComponent S31 = new SectionComponent();

	private SectionComponent S29 = new SectionComponent();

	private TurnoutComponent T2 = new TurnoutComponent();

	public Component2() {
		S18.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S31.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S31.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				S31.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		S24.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				S29.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S29.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				S29.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S31.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T2.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
				S18.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T2.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S18.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T2.raiseReleaseFromLeft();
			}

			@Override
			public void onReleaseRightRaised() {
				S18.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S29.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S24.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				T2.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S24.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T2.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S24.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				T2.raiseReleaseFromRight();
			}

			@Override
			public void onStopRaised() {
			}
		});

		T2.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S31.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
				S29.raiseReserveFromRight();
			}

			@Override
			public void onReserveBottomRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S31.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S29.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				S31.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S29.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
			}
		});
	}

	public SectionComponent getS18() {
		return S18;
	}

	public SectionComponent getS24() {
		return S24;
	}

	public SectionComponent getS31() {
		return S31;
	}

	public SectionComponent getS29() {
		return S29;
	}

	public TurnoutComponent getT2() {
		return T2;
	}

	private boolean areAllEventQueuesEmpty() {
		return S18.isEventQueueEmpty() && S24.isEventQueueEmpty() && S31.isEventQueueEmpty() && S29.isEventQueueEmpty()
				&& T2.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		S18.changeEventQueue();
		S24.changeEventQueue();
		S31.changeEventQueue();
		S29.changeEventQueue();
		T2.changeEventQueue();
		S18.runCycle();
		S24.runCycle();
		S31.runCycle();
		S29.runCycle();
		T2.runCycle();
	}
}