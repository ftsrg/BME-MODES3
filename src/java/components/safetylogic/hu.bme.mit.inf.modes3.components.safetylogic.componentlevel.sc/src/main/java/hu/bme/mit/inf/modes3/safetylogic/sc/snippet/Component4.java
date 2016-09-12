package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

public class Component4 {

	private SectionComponent S2 = new SectionComponent();

	private SectionComponent S4 = new SectionComponent();

	private SectionComponent S7 = new SectionComponent();

	private SectionComponent S5 = new SectionComponent();

	private SectionComponent S6 = new SectionComponent();

	private SectionComponent S1 = new SectionComponent();

	private TurnoutComponent T4 = new TurnoutComponent();

	public Component4() {
		S2.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T4.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S1.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T4.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S1.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T4.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
				S1.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S4.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S6.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				T4.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S6.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T4.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S6.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				T4.raiseReleaseFromLeft();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S7.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				S5.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S5.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				S5.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S5.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S7.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				T4.raiseReserveFromBottom();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S7.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T4.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S7.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				T4.raiseReleaseFromBottom();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S6.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				S4.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S4.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				S4.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S1.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S2.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S2.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				S2.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		T4.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S4.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S2.raiseReserveFromLeft();
			}

			@Override
			public void onReserveBottomRaised() {
				S5.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S4.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S2.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				S5.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S4.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S2.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				S5.raiseRelease();
			}
		});
	}

	public SectionComponent getS2() {
		return S2;
	}

	public SectionComponent getS4() {
		return S4;
	}

	public SectionComponent getS7() {
		return S7;
	}

	public SectionComponent getS5() {
		return S5;
	}

	public SectionComponent getS6() {
		return S6;
	}

	public SectionComponent getS1() {
		return S1;
	}

	public TurnoutComponent getT4() {
		return T4;
	}

	private boolean areAllEventQueuesEmpty() {
		return S2.isEventQueueEmpty() && S4.isEventQueueEmpty() && S7.isEventQueueEmpty() && S5.isEventQueueEmpty()
				&& S6.isEventQueueEmpty() && S1.isEventQueueEmpty() && T4.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		S2.changeEventQueue();
		S4.changeEventQueue();
		S7.changeEventQueue();
		S5.changeEventQueue();
		S6.changeEventQueue();
		S1.changeEventQueue();
		T4.changeEventQueue();
		S2.runCycle();
		S4.runCycle();
		S7.runCycle();
		S5.runCycle();
		S6.runCycle();
		S1.runCycle();
		T4.runCycle();
	}
}
