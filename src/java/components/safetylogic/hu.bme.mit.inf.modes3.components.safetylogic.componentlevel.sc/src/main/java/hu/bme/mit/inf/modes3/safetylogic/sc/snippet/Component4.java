package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component4 extends AbstractYakinduStatechartComponent {

	private SectionComponent S2 = new SectionComponent(2);

	private SectionComponent S4 = new SectionComponent(4);

	private SectionComponent S7 = new SectionComponent(7);

	private SectionComponent S5 = new SectionComponent(5);

	private SectionComponent S6 = new SectionComponent(6);

	private SectionComponent S1 = new SectionComponent(1);

	private TurnoutComponent T4 = new TurnoutComponent(3);
	
	private RemoteElement S19;
	private RemoteElement S18;
	private RemoteElement S12;

	public Component4(IYakinduMessageHandler networkAdapter) {
		setupIds();
		S19 = new RemoteElement(19, ConnectionDirection.RIGHT, networkAdapter);
		S18 = new RemoteElement(18, ConnectionDirection.RIGHT, networkAdapter);
		S12 = new RemoteElement(12, ConnectionDirection.LEFT, networkAdapter);
		
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
				S19.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				S5.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S19.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S5.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S19.releaseToRemote();
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
				S18.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				S4.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S18.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S4.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S18.releaseToRemote();
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
				S12.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S2.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S12.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S2.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S12.releaseToRemote();
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

	@Override
	protected void setupIds() {
		ids.put(T4.getId(), T4);
		ids.put(S2.getId(), S2);
		ids.put(S4.getId(), S4);
		ids.put(S7.getId(), S7);
		ids.put(S5.getId(), S5);
		ids.put(S6.getId(), S6);
	}
}
