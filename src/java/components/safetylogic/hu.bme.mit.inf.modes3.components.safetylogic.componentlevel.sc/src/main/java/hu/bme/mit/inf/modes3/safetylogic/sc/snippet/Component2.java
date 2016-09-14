package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component2 extends AbstractYakinduStatechartComponent {

	private SectionComponent S18 = new SectionComponent(18);

	private SectionComponent S24 = new SectionComponent(24);

	private SectionComponent S31 = new SectionComponent(31);

	private SectionComponent S29 = new SectionComponent(29);

	private TurnoutComponent T2 = new TurnoutComponent(28);

	private RemoteElement S15;
	private RemoteElement S30;
	private RemoteElement S6;

	public Component2(IYakinduMessageHandler networkAdapter) {
		setupIds();
		S15 = new RemoteElement(15, ConnectionDirection.RIGHT, networkAdapter);
		S30 = new RemoteElement(30, ConnectionDirection.LEFT, networkAdapter);
		S6 = new RemoteElement(6, ConnectionDirection.LEFT, networkAdapter);

		S18.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S31.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S6.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S31.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S6.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S31.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S6.releaseToRemote();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S24.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S15.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				S29.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S15.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S29.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S15.releaseToRemote();
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
				S30.reserveToRemote();
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
				S30.reserveResultToRemote(value);
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
				S30.releaseToRemote();
			}
		});
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

	@Override
	protected void setupIds() {
		ids.put(T2.getId(), T2);
		ids.put(S18.getId(), S18);
		ids.put(S24.getId(), S24);
		ids.put(S31.getId(), S31);
		ids.put(S29.getId(), S29);
	}
}
