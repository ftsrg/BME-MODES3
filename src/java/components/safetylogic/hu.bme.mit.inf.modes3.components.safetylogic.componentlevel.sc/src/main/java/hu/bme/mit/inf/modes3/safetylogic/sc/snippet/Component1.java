package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import java.util.HashMap;
import java.util.Map;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.section.SectionStatemachine;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;
import org.yakindu.scr.turnout.TurnoutStatemachine;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class Component1 implements IYakinduMessageHandler {

	private SectionComponent S12 = new SectionComponent();

	private SectionComponent S15 = new SectionComponent();

	private TurnoutComponent T1 = new TurnoutComponent();

	private Map<Integer, Object> ids = new HashMap<Integer, Object>();

	private RemoteElement S24 = new RemoteElement(24, ConnectionDirection.RIGHT, ConnectionDirection.LEFT);

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

	public Component1() {
		setupIds();
		// S24.setAdapter(adapter);
		S12.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				T1.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				T1.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
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
				S24.reserveTo(24, ConnectionDirection.RIGHT);
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				T1.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				S24.reserveResultTo(24, ConnectionDirection.RIGHT, value);
			}

			@Override
			public void onReleaseLeftRaised() {
				T1.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
				S24.releaseTo(24, ConnectionDirection.RIGHT);
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
			}
		});
	}

	public SectionComponent getS12() {
		return S12;
	}

	public SectionComponent getS15() {
		return S15;
	}

	public TurnoutComponent getT1() {
		return T1;
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

	private void setupIds() {
		ids.put(12, S12);
		ids.put(14, T1);
		ids.put(15, S15);
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
			case BOTTOM:
				turnout.raiseReserveFromBottom();
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
				throw new IllegalArgumentException(
						"This section cannot be released from " + direction + ": " + targetID + ".");
			}
		} else if (target instanceof TurnoutComponent) {
			TurnoutComponent turnout = (TurnoutComponent) target;
			switch (direction) {
			case BOTTOM:
				turnout.raiseReleaseFromBottom();
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
			case BOTTOM:
				turnout.raiseReserveResultFromBottom(result);
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
