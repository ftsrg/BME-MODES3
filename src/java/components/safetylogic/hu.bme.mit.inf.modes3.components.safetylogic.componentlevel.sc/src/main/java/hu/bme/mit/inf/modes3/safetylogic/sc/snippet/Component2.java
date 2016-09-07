package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import java.util.HashMap;
import java.util.Map;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component2 implements IYakinduMessageHandler {

	private SectionComponent S31 = new SectionComponent();

	private SectionComponent S18 = new SectionComponent();

	private SectionComponent S29 = new SectionComponent();

	private TurnoutComponent T2 = new TurnoutComponent();

	private SectionComponent S24 = new SectionComponent();

	private Map<Integer, Object> ids = new HashMap<Integer, Object>();

	private RemoteElement S15 = new RemoteElement(24, ConnectionDirection.LEFT, ConnectionDirection.RIGHT);

	public Component2() {
		setupIds();
		// S15.setAdapter(adapter);
		S31.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				T2.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S18.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T2.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S18.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T2.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
				S18.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		S18.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S31.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S31.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				S31.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
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
				T2.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S24.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T2.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S24.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				T2.raiseReleaseFromLeft();
			}

			@Override
			public void onStopRaised() {
			}
		});

		T2.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				S29.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				S31.raiseReserveFromLeft();
			}

			@Override
			public void onReserveBottomRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S29.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S31.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				S29.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				S31.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
			}
		});

		S24.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				S15.reserveTo(15, ConnectionDirection.LEFT);
			}

			@Override
			public void onReserveRightRaised() {
				S29.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				S15.reserveResultTo(15, ConnectionDirection.LEFT, value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S29.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				S15.releaseTo(15, ConnectionDirection.LEFT);
			}

			@Override
			public void onReleaseRightRaised() {
				S29.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});
	}

	public SectionComponent getS31() {
		return S31;
	}

	public SectionComponent getS18() {
		return S18;
	}

	public SectionComponent getS29() {
		return S29;
	}

	public TurnoutComponent getT2() {
		return T2;
	}

	public SectionComponent getS24() {
		return S24;
	}

	private boolean areAllEventQueuesEmpty() {
		return S31.isEventQueueEmpty() && S18.isEventQueueEmpty() && S29.isEventQueueEmpty() && T2.isEventQueueEmpty()
				&& S24.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		S31.changeEventQueue();
		S18.changeEventQueue();
		S29.changeEventQueue();
		T2.changeEventQueue();
		S24.changeEventQueue();
		S31.runCycle();
		S18.runCycle();
		S29.runCycle();
		T2.runCycle();
		S24.runCycle();
	}

	private void setupIds() {
		ids.put(24, S24);
		ids.put(29, S29);
		ids.put(31, S31);
		ids.put(18, S18);
		ids.put(28, T2);
	}

	@Override
	public void reserveTo(int targetID, ConnectionDirection direction) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			switch (direction) {
			case RIGHT:
				section.raiseReserveFromRight();
				break;
			case LEFT:
				section.raiseReserveFromLeft();
				break;
			default:
				throw new IllegalArgumentException(
						"This section cannot be reserved from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case LEFT:
				turnout.raiseReserveFromLeft();
				break;
			default:
				throw new IllegalArgumentException(
						"This turnout cannot be reserved from " + direction + ": " + targetID + ".");
			}
		} else {
			throw new IllegalArgumentException("No such id in this component: " + targetID + ".");
		}
	}

	@Override
	public void releaseTo(int targetID, ConnectionDirection direction) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			switch (direction) {
			case RIGHT:
			case LEFT:
				section.raiseRelease();
				break;
			default:
				throw new IllegalAccessError(
						"This section cannot be released from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case LEFT:
				turnout.raiseReleaseFromLeft();
				break;
			default:
				throw new IllegalArgumentException(
						"This turnout cannot be released from " + direction + ": " + targetID + ".");
			}
		} else {
			throw new IllegalArgumentException("No such id in this component: " + targetID + ".");
		}
	}

	@Override
	public void reserveResultTo(int targetID, ConnectionDirection direction, boolean result) {
		Object target = ids.get(targetID);
		if (target instanceof SectionComponent) {
			SectionComponent section = (SectionComponent) target;
			switch (direction) {
			case RIGHT:
			case LEFT:
				section.raiseReserveResult(result);
				break;
			default:
				throw new IllegalArgumentException(
						"This section cannot get a reserve result from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case LEFT:
				turnout.raiseReserveResultFromLeft(result);
				break;
			default:
				throw new IllegalArgumentException(
						"This turnout cannot get a reserve result from " + direction + ": " + targetID + ".");
			}
		} else {
			throw new IllegalArgumentException("No such id in this component: " + targetID + ".");
		}
	}

}
