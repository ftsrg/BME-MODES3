package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yakindu.scr.TimerService;
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.section.SectionStatemachine.State;
import org.yakindu.scr.section.SynchronizedSectionStatemachine;

interface SectionComponentInterface {

	void raiseReserveFromLeft();

	void raiseReserveFromRight();

	void raiseOccupy();

	void raiseReserveResult(boolean value);

	void raiseRelease();

	void raiseUnoccupy();

	void raiseReset();
}

public class SectionComponent implements SectionComponentInterface {

	private static final Logger logger = LoggerFactory.getLogger(SectionComponent.class);

	// The wrapped Yakindu statemachine
	private SynchronizedSectionStatemachine sectionStatemachine = new SynchronizedSectionStatemachine();

	// Indicates which queue is active in this synchronization turn
	private boolean chooseList = true;
	// Event queues for the synchronization of statecharts
	private Queue<Message> eventQueue1 = new ConcurrentLinkedQueue<>();
	private Queue<Message> eventQueue2 = new ConcurrentLinkedQueue<>();

	public SectionComponent(int id) {
		// Initializing and entering the wrapped statemachine
		sectionStatemachine.getSCISection().setId(id);
		sectionStatemachine.setTimer(new TimerService());
		sectionStatemachine.init();
		sectionStatemachine.enter();
	}
	
	public int getId(){
		return sectionStatemachine.getSCISection().getId();
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
			case "occupy":
				sectionStatemachine.getSCISection().raiseOccupy();
				break;
			case "reserveResult":
				sectionStatemachine.getSCISection().raiseReserveResult((Boolean) event.getValue());
				break;
			case "release":
				sectionStatemachine.getSCISection().raiseRelease();
				break;
			case "unoccupy":
				sectionStatemachine.getSCISection().raiseUnoccupy();
				break;
			case "reset":
				sectionStatemachine.getSCISection().raiseReset();
				break;
			case "reserveFromLeft":
				sectionStatemachine.getSCISection().raiseReserveFromLeft();
				break;
			case "reserveFromRight":
				sectionStatemachine.getSCISection().raiseReserveFromRight();
				break;
			case "trainDirection":
				if (event.getValue() instanceof TrainDirection) {
					TrainDirection direction = (TrainDirection) event.getValue();
					if (direction.value == 0 || direction.value == 1) {
						sectionStatemachine.getSCISection().setDir(direction.value);
					} else {
						logger.error("Direction can be either LEFT(0) or RIGHT(1), not " + direction);
					}
				}
			default:
				logger.error("No such event! " + event.getEvent());
			}
		}
		sectionStatemachine.runCycle();
	}

	public void raiseReserveFromLeft() {
		getInsertQueue().add(new Message("reserveFromLeft", null));
	}

	public void raiseReserveFromRight() {
		getInsertQueue().add(new Message("reserveFromRight", null));
	}

	public void raiseOccupy() {
		getInsertQueue().add(new Message("occupy", null));
	}

	public void raiseReserveResult(boolean value) {
		getInsertQueue().add(new Message("reserveResult", value));
	}

	public void raiseRelease() {
		getInsertQueue().add(new Message("release", null));
	}

	public void raiseUnoccupy() {
		getInsertQueue().add(new Message("unoccupy", null));
	}

	public void raiseReset() {
		getInsertQueue().add(new Message("reset", null));
	}

	public void setTrainDirection(TrainDirection direction) {
		getInsertQueue().add(new Message("trainDirection", direction));
	}

	List<SCISectionListener> getSCISectionListeners() {
		return sectionStatemachine.getSCISection().getListeners();
	}

	public boolean isStateActive(State state) {
		return sectionStatemachine.isStateActive(state);
	}

}
