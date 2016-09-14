package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component5 extends AbstractYakinduStatechartComponent  {

	private SectionComponent S10 = new SectionComponent(10);

	private SectionComponent S8 = new SectionComponent(8);

	private SectionComponent S11 = new SectionComponent(11);

	private TurnoutComponent T5 = new TurnoutComponent(9);

	private SectionComponent S13 = new SectionComponent(13);
	
	private RemoteElement T1;
	private RemoteElement S17;
	private RemoteElement S20;

	public Component5(IYakinduMessageHandler networkAdapter) {
		setupIds();
		T1 = new RemoteElement(14, ConnectionDirection.BOTTOM, networkAdapter);
		S17 = new RemoteElement(17, ConnectionDirection.LEFT, networkAdapter);
		S20 = new RemoteElement(20, ConnectionDirection.LEFT, networkAdapter);
		
		S10.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T5.raiseReserveFromBottom();
			}

			@Override
			public void onReserveRightRaised() {
				S17.reserveToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T5.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S17.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T5.raiseReleaseFromBottom();
			}

			@Override
			public void onReleaseRightRaised() {
				S17.releaseToRemote();
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
				T1.releaseToRemote();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T5.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T1.reserveResultToRemote(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T5.raiseReleaseFromLeft();
			}

			@Override
			public void onReleaseRightRaised() {
				T1.releaseToRemote();
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
				S20.reserveToRemote();
			}

			@Override
			public void onReserveRightRaised() {
				S8.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S20.reserveResultToRemote(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S8.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S20.releaseToRemote();
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

	@Override
	protected void setupIds() {
		ids.put(T5.getId(), T5);
		ids.put(S10.getId(), S10);
		ids.put(S8.getId(), S8);
		ids.put(S11.getId(), S11);
		ids.put(S13.getId(), S13);
	}
}
