package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

public class Component6 {

	private SectionComponent S27 = new SectionComponent();

	private TurnoutComponent T6 = new TurnoutComponent();

	private SectionComponent S17 = new SectionComponent();

	private SectionComponent S23 = new SectionComponent();

	private SectionComponent S22 = new SectionComponent();

	public Component6() {
		S27.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S23.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S23.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				S23.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		T6.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S23.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
				S17.raiseReserveFromRight();
			}

			@Override
			public void onReserveBottomRaised() {
				S22.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S23.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S17.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				S22.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S23.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S17.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				S22.raiseRelease();
			}
		});

		S17.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				T6.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T6.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				T6.raiseReleaseFromRight();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S23.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T6.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
				S27.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T6.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S27.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T6.raiseReleaseFromLeft();
			}

			@Override
			public void onReleaseRightRaised() {
				S27.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S22.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T6.raiseReserveFromBottom();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T6.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				T6.raiseReleaseFromBottom();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});
	}

	public SectionComponent getS27() {
		return S27;
	}

	public TurnoutComponent getT6() {
		return T6;
	}

	public SectionComponent getS17() {
		return S17;
	}

	public SectionComponent getS23() {
		return S23;
	}

	public SectionComponent getS22() {
		return S22;
	}

	private boolean areAllEventQueuesEmpty() {
		return S27.isEventQueueEmpty() && T6.isEventQueueEmpty() && S17.isEventQueueEmpty() && S23.isEventQueueEmpty()
				&& S22.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		S27.changeEventQueue();
		T6.changeEventQueue();
		S17.changeEventQueue();
		S23.changeEventQueue();
		S22.changeEventQueue();
		S27.runCycle();
		T6.runCycle();
		S17.runCycle();
		S23.runCycle();
		S22.runCycle();
	}
}
