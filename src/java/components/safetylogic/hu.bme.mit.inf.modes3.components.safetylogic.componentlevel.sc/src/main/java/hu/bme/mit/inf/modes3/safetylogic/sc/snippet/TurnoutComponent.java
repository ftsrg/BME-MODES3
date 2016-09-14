package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.yakindu.scr.turnout.ITurnoutStatemachine.SCITurnoutListener;
import org.yakindu.scr.turnout.SynchronizedTurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

interface TurnoutComponentInterface {

	void raiseReserveResultFromLeft(boolean value);

	void raiseReleaseFromBottom();

	void raiseReserveFromLeft();

	void raiseReleaseFromRight();

	void raiseReserveFromRight();

	void raiseSwitch();

	void raiseReserveResultFromBottom(boolean value);

	void raiseReserveFromBottom();

	void raiseReleaseFromLeft();

	void raiseReserveResultFromRight(boolean value);
}

public class TurnoutComponent implements TurnoutComponentInterface {
	// The wrapped Yakindu statemachine
	private SynchronizedTurnoutStatemachine turnoutStatemachine = new SynchronizedTurnoutStatemachine();

	// Indicates which queue is active in this synchronization turn
	private boolean chooseList = true;
	// Event queues for the synchronization of statecharts
	private Queue<Message> eventQueue1 = new ConcurrentLinkedQueue<>();
	private Queue<Message> eventQueue2 = new ConcurrentLinkedQueue<>();

	public TurnoutComponent(int id) {
		// Initializing and entering the wrapped statemachine
		turnoutStatemachine.getSCITurnout().setId(id);
		turnoutStatemachine.init();
		turnoutStatemachine.enter();
	}
	
	public int getId(){
		return turnoutStatemachine.getSCITurnout().getId();
	}

	void changeEventQueue() {
		chooseList = !chooseList;
	}

	boolean isEventQueueEmpty() {
		return getInsertQueue().isEmpty();
	}

	private Queue<Message> getInsertQueue() {
		if (chooseList) {
			return eventQueue1;
		}
		return eventQueue2;
	}

	private Queue<Message> getProcessQueue() {
		return getInsertQueue() == eventQueue1 ? eventQueue2 : eventQueue1;
	}

	void runCycle() {
		Queue<Message> eventQueue = getProcessQueue();
		while (!eventQueue.isEmpty()) {
			Message event = eventQueue.remove();
			switch (event.getEvent()) {
			case "reserveResultFromLeft":
				turnoutStatemachine.getSCITurnout().raiseReserveResultFromLeft((Boolean) event.getValue());
				break;
			case "releaseFromBottom":
				turnoutStatemachine.getSCITurnout().raiseReleaseFromBottom();
				break;
			case "reserveFromLeft":
				turnoutStatemachine.getSCITurnout().raiseReserveFromLeft();
				break;
			case "releaseFromRight":
				turnoutStatemachine.getSCITurnout().raiseReleaseFromRight();
				break;
			case "reserveFromRight":
				turnoutStatemachine.getSCITurnout().raiseReserveFromRight();
				break;
			case "reserveResultFromBottom":
				turnoutStatemachine.getSCITurnout().raiseReserveResultFromBottom((Boolean) event.getValue());
				break;
			case "reserveFromBottom":
				turnoutStatemachine.getSCITurnout().raiseReserveFromBottom();
				break;
			case "switch":
				turnoutStatemachine.getSCITurnout().raiseSwitch();
				break;
			case "releaseFromLeft":
				turnoutStatemachine.getSCITurnout().raiseReleaseFromLeft();
				break;
			case "reserveResultFromRight":
				turnoutStatemachine.getSCITurnout().raiseReserveResultFromRight((Boolean) event.getValue());
				break;
			default:
				throw new IllegalArgumentException("No such event!");
			}
		}
		turnoutStatemachine.runCycle();
	}

	public void raiseReserveResultFromLeft(boolean value) {
		getInsertQueue().add(new Message("reserveResultFromLeft", value));
	}

	public void raiseReleaseFromBottom() {
		getInsertQueue().add(new Message("releaseFromBottom", null));
	}

	public void raiseReserveFromLeft() {
		getInsertQueue().add(new Message("reserveFromLeft", null));
	}

	public void raiseReleaseFromRight() {
		getInsertQueue().add(new Message("releaseFromRight", null));
	}

	public void raiseReserveFromRight() {
		getInsertQueue().add(new Message("reserveFromRight", null));
	}

	public void raiseSwitch() {
		getInsertQueue().add(new Message("switch", null));
	}

	public void raiseReserveResultFromBottom(boolean value) {
		getInsertQueue().add(new Message("reserveResultFromBottom", value));
	}

	public void raiseReserveFromBottom() {
		getInsertQueue().add(new Message("reserveFromBottom", null));
	}

	public void raiseReleaseFromLeft() {
		getInsertQueue().add(new Message("releaseFromLeft", null));
	}

	public void raiseReserveResultFromRight(boolean value) {
		getInsertQueue().add(new Message("reserveResultFromRight", value));
	}

	List<SCITurnoutListener> getSCITurnoutListeners() {
		return turnoutStatemachine.getSCITurnout().getListeners();
	}

	public boolean isStateActive(State state) {
		return turnoutStatemachine.isStateActive(state);
	}

}
