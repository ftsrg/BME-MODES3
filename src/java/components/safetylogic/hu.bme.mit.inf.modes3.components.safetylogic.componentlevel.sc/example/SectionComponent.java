import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
    	
import org.yakindu.scr.section.ISectionStatemachine.SCISectionListener;
import org.yakindu.scr.TimerService;
import org.yakindu.scr.section.SectionStatemachine;
import org.yakindu.scr.section.SectionStatemachine.State;

interface SectionComponentInterface {
	
	void raiseReset( );
	
	void raiseReserveFromRight( );
	
	void raiseReserveFromLeft( );
	
	void raiseRelease( );
	
	void raiseReserveResult(boolean value);
	
	void raiseOccupy( );
	
	void raiseUnoccupy( );
}

public class SectionComponent implements SectionComponentInterface {
	// The wrapped Yakindu statemachine
	private SectionStatemachine sectionStatemachine = new SectionStatemachine();
	
	// Indicates which queue is active in this synchronization turn
	private boolean chooseList = true;
	// Event queues for the synchronization of statecharts
	private Queue<Message> eventQueue1 = new LinkedList<Message>();
	private Queue<Message> eventQueue2 = new LinkedList<Message>();
	
	public SectionComponent() {
		// Initializing and entering the wrapped statemachine
		sectionStatemachine.setTimer(new TimerService());
		sectionStatemachine.init();
		sectionStatemachine.enter();
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
	   			case "reserveFromLeft":
	   				sectionStatemachine.getSCISection().raiseReserveFromLeft();
	   				break; 
	   			case "release":
	   				sectionStatemachine.getSCISection().raiseRelease();
	   				break; 
	   			case "reserveResult":
	   				sectionStatemachine.getSCISection().raiseReserveResult((Boolean) event.getValue());
	   				break; 
	   			case "reset":
	   				sectionStatemachine.getSCISection().raiseReset();
	   				break; 
	   			case "reserveFromRight":
	   				sectionStatemachine.getSCISection().raiseReserveFromRight();
	   				break; 
	   			case "occupy":
	   				sectionStatemachine.getSCISection().raiseOccupy();
	   				break; 
	   			case "unoccupy":
	   				sectionStatemachine.getSCISection().raiseUnoccupy();
	   				break; 
	   			default:
	   				throw new IllegalArgumentException("No such event!");
	   		}
	   }
	   sectionStatemachine.runCycle();
	}
	
	public void raiseReset( ) {
		getInsertQueue().add(new Message("reset", null));
	}
	
	public void raiseReserveFromRight( ) {
		getInsertQueue().add(new Message("reserveFromRight", null));
	}
	
	public void raiseReserveFromLeft( ) {
		getInsertQueue().add(new Message("reserveFromLeft", null));
	}
	
	public void raiseRelease( ) {
		getInsertQueue().add(new Message("release", null));
	}
	
	public void raiseReserveResult(boolean value) {
		getInsertQueue().add(new Message("reserveResult", value));
	}
	
	public void raiseOccupy( ) {
		getInsertQueue().add(new Message("occupy", null));
	}
	
	public void raiseUnoccupy( ) {
		getInsertQueue().add(new Message("unoccupy", null));
	}
	
	List<SCISectionListener> getSCISectionListeners() {
		return sectionStatemachine.getSCISection().getListeners();
	}
	
	public boolean isStateActive(State state) {
		return sectionStatemachine.isStateActive(state);
	}
	
}
