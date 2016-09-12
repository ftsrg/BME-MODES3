package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

public class Component5 {

	private SectionComponent S10 = new SectionComponent();

	private SectionComponent S8 = new SectionComponent();

	private SectionComponent S11 = new SectionComponent();

	private TurnoutComponent T5 = new TurnoutComponent();

	private SectionComponent S13 = new SectionComponent();

	public Component5() {
		S10.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T5.raiseReserveFromBottom();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T5.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				T5.raiseReleaseFromBottom();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		S8.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S13.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				T5.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S13.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T5.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S13.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				T5.raiseReleaseFromRight();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S11.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T5.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T5.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				T5.raiseReleaseFromLeft();
			}

			@Override
			public void onReleaseRightRaised() {
			}

			@Override
			public void onStopRaised() {
			}
		});

		T5.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S11.raiseReserveFromLeft();
			}

			@Override
			public void onReserveRightRaised() {
				S8.raiseReserveFromRight();
			}

			@Override
			public void onReserveBottomRaised() {
				S10.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S11.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S8.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				S10.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S11.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S8.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				S10.raiseRelease();
			}
		});

		S13.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				S8.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S8.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				S8.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});
	}

	public SectionComponent getS10() {
		return S10;
	}

	public SectionComponent getS8() {
		return S8;
	}

	public SectionComponent getS11() {
		return S11;
	}

	public TurnoutComponent getT5() {
		return T5;
	}

	public SectionComponent getS13() {
		return S13;
	}

	private boolean areAllEventQueuesEmpty() {
		return S10.isEventQueueEmpty() && S8.isEventQueueEmpty() && S11.isEventQueueEmpty() && T5.isEventQueueEmpty()
				&& S13.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		S10.changeEventQueue();
		S8.changeEventQueue();
		S11.changeEventQueue();
		T5.changeEventQueue();
		S13.changeEventQueue();
		S10.runCycle();
		S8.runCycle();
		S11.runCycle();
		T5.runCycle();
		S13.runCycle();
	}
}
