package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component6 extends AbstractYakinduStatechartComponent {

	private SectionComponent S27 = new SectionComponent(27);

	private TurnoutComponent T6 = new TurnoutComponent(21);

	private SectionComponent S17 = new SectionComponent(17);

	private SectionComponent S23 = new SectionComponent(23);

	private SectionComponent S22 = new SectionComponent(22);

	private RemoteElement S10;
	private RemoteElement S26;

	public Component6(IYakinduMessageHandler networkAdapter) {
		setupIds();
		S10 = new RemoteElement(10, ConnectionDirection.RIGHT, networkAdapter);
		S26 = new RemoteElement(26, ConnectionDirection.LEFT, networkAdapter);

		S27.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S23.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S26.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S23.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S26.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S23.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S26.releaseToRemote();
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
				S10.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				T6.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S10.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T6.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S10.releaseToRemote();
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
				// connects to nothing
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T6.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				// connects to nothing
			}

			@Override
			public void onReleaseLeftRaised() {
				T6.raiseReleaseFromBottom();
			}

			@Override
			public void onReleaseRightRaised() {
				// connects to nothing
			}

			@Override
			public void onStopRaised() {
			}
		});
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

	@Override
	protected void setupIds() {
		ids.put(T6.getId(), T6);
		ids.put(S27.getId(), S27);
		ids.put(S17.getId(), S17);
		ids.put(S23.getId(), S23);
		ids.put(S22.getId(), S22);
	}
}
