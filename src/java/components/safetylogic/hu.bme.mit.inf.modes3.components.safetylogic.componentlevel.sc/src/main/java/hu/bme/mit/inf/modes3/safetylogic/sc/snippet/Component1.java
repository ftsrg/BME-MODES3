package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component1 extends AbstractYakinduStatechartComponent {

	private SectionComponent S12 = new SectionComponent(12);

	private SectionComponent S15 = new SectionComponent(15);

	private TurnoutComponent T1 = new TurnoutComponent(14);

	private RemoteElement S24;
	private RemoteElement S1;
	private RemoteElement S11;

	public Component1(IYakinduMessageHandler networkAdapter) {
		setupIds();
		S24 = new RemoteElement(24, ConnectionDirection.LEFT, networkAdapter);
		S1 = new RemoteElement(1, ConnectionDirection.RIGHT, networkAdapter);
		S11 = new RemoteElement(11, ConnectionDirection.RIGHT, networkAdapter);

		S12.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S1.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				T1.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S1.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T1.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S1.releaseToRemote();
			}

			@Override
			public void onReleaseRightRaised() {
				T1.raiseReleaseFromLeft();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S15.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T1.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S24.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T1.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S24.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T1.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
				S24.releaseToRemote();
			}

			@Override
			public void onStopRaised() {
			}
		});

		T1.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S12.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S15.raiseReserveFromLeft();
			}

			@Override
			public void onReserveBottomRaised() {
				S11.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S12.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S15.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				S11.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S12.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S15.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				S11.releaseToRemote();
			}
		});
	}

	/**
	 * @depreacted used only for test purposes
	 */
	@Deprecated
	public void mockSectionComponent(String refID, SectionComponent mock) {
		switch (refID) {
		case "S12":
			S12 = mock;
			ids.put(12, S12);
			break;
		case "S15":
			S15 = mock;
			ids.put(15, S15);
			break;
		}
	}

	/**
	 * @depreacted used only for test purposes
	 */
	@Deprecated
	public void mockTurnoutComponent(String refID, TurnoutComponent mock) {
		switch (refID) {
		case "T1":
			T1 = mock;
			ids.put(1, T1);
			break;
		}
	}

	private boolean areAllEventQueuesEmpty() {
		return S12.isEventQueueEmpty() && S15.isEventQueueEmpty() && T1.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		S12.changeEventQueue();
		S15.changeEventQueue();
		T1.changeEventQueue();
		S12.runCycle();
		S15.runCycle();
		T1.runCycle();
	}

	@Override
	protected void setupIds() {
		ids.put(T1.getId(), T1);
		ids.put(S12.getId(), S12);
		ids.put(S15.getId(), S15);
	}

}
