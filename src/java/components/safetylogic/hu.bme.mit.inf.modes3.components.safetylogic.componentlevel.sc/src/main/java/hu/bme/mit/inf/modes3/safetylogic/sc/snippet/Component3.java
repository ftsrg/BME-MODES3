package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component3 extends AbstractYakinduStatechartComponent {

	private TurnoutComponent T3_1 = new TurnoutComponent(25);

	private TurnoutComponent T3_2 = new TurnoutComponent(32);

	private SectionComponent S19 = new SectionComponent(19);

	private SectionComponent S20 = new SectionComponent(20);

	private SectionComponent S30 = new SectionComponent(30);

	private SectionComponent S26 = new SectionComponent(26);

	private RemoteElement T2;
	private RemoteElement S7;
	private RemoteElement S13;
	private RemoteElement S27;

	public Component3(IYakinduMessageHandler networkAdapter) {
		setupIds();
		T2 = new RemoteElement(28, ConnectionDirection.BOTTOM, networkAdapter);
		S7 = new RemoteElement(7, ConnectionDirection.LEFT, networkAdapter);
		S13 = new RemoteElement(13, ConnectionDirection.LEFT, networkAdapter);
		S27 = new RemoteElement(27, ConnectionDirection.RIGHT, networkAdapter);

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
				S7.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T3_2.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S7.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T3_2.raiseReleaseFromLeft();
			}

			@Override
			public void onReleaseRightRaised() {
				S7.releaseToRemote();
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
				S13.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T3_1.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S13.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T3_1.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
				S13.releaseToRemote();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S30.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T2.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				T3_2.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T2.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T3_2.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T2.releaseToRemote();
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
				S27.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				T3_1.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S27.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T3_1.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S27.releaseToRemote();
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

	@Override
	protected void setupIds() {
		ids.put(T3_1.getId(), T3_1);
		ids.put(T3_2.getId(), T3_2);
		ids.put(S19.getId(), S19);
		ids.put(S20.getId(), S20);
		ids.put(S30.getId(), S30);
		ids.put(S26.getId(), S26);
	}
}
