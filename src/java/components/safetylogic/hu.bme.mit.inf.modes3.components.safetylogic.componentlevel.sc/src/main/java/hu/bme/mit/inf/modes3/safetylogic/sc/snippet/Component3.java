package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

public class Component3 {

	private TurnoutComponent T3_1 = new TurnoutComponent();

	private TurnoutComponent T3_2 = new TurnoutComponent();

	private SectionComponent S19 = new SectionComponent();

	private SectionComponent S20 = new SectionComponent();

	private SectionComponent S30 = new SectionComponent();

	private SectionComponent S26 = new SectionComponent();

	public Component3() {
		T3_1.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S26.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S20.raiseReserveFromLeft();
			}

			@Override
			public void onReserveBottomRaised() {
				T3_2.raiseReserveFromBottom();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S26.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S20.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				T3_2.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S26.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S20.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				T3_2.raiseReleaseFromBottom();
			}
		});

		T3_2.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S19.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
				S30.raiseReserveFromRight();
			}

			@Override
			public void onReserveBottomRaised() {
				T3_1.raiseReserveFromBottom();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S19.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S30.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				T3_1.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S19.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S30.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				T3_1.raiseReleaseFromBottom();
			}
		});

		S19.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T3_2.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T3_2.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				T3_2.raiseReleaseFromLeft();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		S20.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T3_1.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T3_1.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				T3_1.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		S30.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				T3_2.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T3_2.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				T3_2.raiseReleaseFromRight();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S26.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				T3_1.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T3_1.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				T3_1.raiseReleaseFromLeft();
			}

			@Override
			public void onStopRaised() {
			}
		});
	}

	public TurnoutComponent getT3_1() {
		return T3_1;
	}

	public TurnoutComponent getT3_2() {
		return T3_2;
	}

	public SectionComponent getS19() {
		return S19;
	}

	public SectionComponent getS20() {
		return S20;
	}

	public SectionComponent getS30() {
		return S30;
	}

	public SectionComponent getS26() {
		return S26;
	}

	private boolean areAllEventQueuesEmpty() {
		return T3_1.isEventQueueEmpty() && T3_2.isEventQueueEmpty() && S19.isEventQueueEmpty()
				&& S20.isEventQueueEmpty() && S30.isEventQueueEmpty() && S26.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		T3_1.changeEventQueue();
		T3_2.changeEventQueue();
		S19.changeEventQueue();
		S20.changeEventQueue();
		S30.changeEventQueue();
		S26.changeEventQueue();
		T3_1.runCycle();
		T3_2.runCycle();
		S19.runCycle();
		S20.runCycle();
		S30.runCycle();
		S26.runCycle();
	}
}
