package snippet;

import java.util.HashMap;
import java.util.Map;

import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;

public class InstanceContainer implements IYakinduMessageHandler {

	private SectionComponent section3 = new SectionComponent();

	private TurnoutComponent turnout = new TurnoutComponent();

	private SectionComponent section2 = new SectionComponent();

	private SectionComponent section4 = new SectionComponent();

	private SectionComponent section1 = new SectionComponent();

	private Map<Integer, Object> ids = new HashMap<Integer, Object>();

	IYakinduMessageHandler messageHandler;

	public InstanceContainer() {
		this.setIds();
		section3.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				turnout.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				section4.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				turnout.raiseReserveResultFromRight(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				section4.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				turnout.raiseReleaseFromRight();
			}

			@Override
			public void onReleaseRightRaised() {
				section4.raiseRelease();
			}

			@Override
			public void onStopRaised() {
			}
		});

		turnout.getSCITurnoutListeners().add(new SCITurnoutListener() {
			@Override
			public void onReserveLeftRaised() {
				section1.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
				section3.raiseReserveFromLeft();
			}

			@Override
			public void onReserveBottomRaised() {
				section2.raiseReserveFromRight();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				section1.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				section3.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToBottomRaised(boolean value) {
				section2.raiseReserveResult(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				section1.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				section3.raiseRelease();
			}

			@Override
			public void onReleaseBottomRaised() {
				section2.raiseRelease();
			}
		});

		section2.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				turnout.raiseReserveFromBottom();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				turnout.raiseReserveResultFromBottom(value);
			}

			@Override
			public void onReleaseLeftRaised() {
			}

			@Override
			public void onReleaseRightRaised() {
				turnout.raiseReleaseFromBottom();
			}

			@Override
			public void onStopRaised() {

			}
		});

		section4.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
				section3.raiseReserveFromRight();
			}

			@Override
			public void onReserveRightRaised() {
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
				section3.raiseReserveResult(value);
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
			}

			@Override
			public void onReleaseLeftRaised() {
				section3.raiseRelease();
			}

			@Override
			public void onReleaseRightRaised() {
				// String targetId;
				// adapter.sendMessage(targetId, new Message("reserveFromLeft",
				// null));
			}

			@Override
			public void onStopRaised() {
			}
		});

		section1.getSCISectionListeners().add(new SCISectionListener() {
			@Override
			public void onReserveLeftRaised() {
			}

			@Override
			public void onReserveRightRaised() {
				turnout.raiseReserveFromLeft();
			}

			@Override
			public void onReserveResultToLeftRaised(boolean value) {
			}

			@Override
			public void onReserveResultToRightRaised(boolean value) {
				turnout.raiseReserveResultFromLeft(value);
			}

			@Override
			public void onReleaseLeftRaised() {
				// TODO kézzel, az ábra alapján
				// messageHandler.releaseTo(targetID, direction);
			}

			@Override
			public void onReleaseRightRaised() {
				turnout.raiseReleaseFromLeft();
			}

			@Override
			public void onStopRaised() {
			}
		});
	}

	public SectionComponent getSection3() {
		return section3;
	}

	public TurnoutComponent getTurnout() {
		return turnout;
	}

	public SectionComponent getSection2() {
		return section2;
	}

	public SectionComponent getSection4() {
		return section4;
	}

	public SectionComponent getSection1() {
		return section1;
	}

	private boolean areAllEventQueuesEmpty() {
		return section3.isEventQueueEmpty() && turnout.isEventQueueEmpty() && section2.isEventQueueEmpty()
				&& section4.isEventQueueEmpty() && section1.isEventQueueEmpty();
	}

	public void runFullCycle() {
		do {
			runOneCycle();
		} while (!areAllEventQueuesEmpty());
	}

	public void runOneCycle() {
		section3.changeEventQueue();
		turnout.changeEventQueue();
		section2.changeEventQueue();
		section4.changeEventQueue();
		section1.changeEventQueue();
		section3.runCycle();
		turnout.runCycle();
		section2.runCycle();
		section4.runCycle();
		section1.runCycle();
	}

	private void setIds() {
		// TODO generate based on the model
	}

	public void addRemoteElement(int id, RemoteElement remote) {
		ids.put(id, remote);
	}

	@Override
	public void reserveTo(int targetID, ConnectionDirection direction) {
		// TODO direction consistency
		Object target = ids.get(targetID);
		if (target instanceof TurnoutComponent) {
			TurnoutComponent turnoutComponent = ((TurnoutComponent) target);
			switch (direction) {
			case LEFT:
				turnoutComponent.raiseReserveFromLeft();
				break;
			case BOTTOM:
				turnoutComponent.raiseReserveFromBottom();
				break;
			case RIGHT:
				turnoutComponent.raiseReserveFromRight();
				break;
			}
		} else if (target instanceof SectionComponent) {
			SectionComponent sectionComponent = ((SectionComponent) target);
			switch (direction) {
			case LEFT:
				sectionComponent.raiseReserveFromLeft();
				break;
			case RIGHT:
				sectionComponent.raiseReserveFromRight();
				break;
			default:
				throw new IllegalArgumentException("Cannot reserve Bottom!");
			}
		} else {
			throw new IllegalArgumentException("No such id!");
		}
	}

	@Override
	public void releaseTo(int targetID, ConnectionDirection direction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reserveResultTo(int targetID, ConnectionDirection direction, boolean result) {
		// TODO Auto-generated method stub

	}
}
