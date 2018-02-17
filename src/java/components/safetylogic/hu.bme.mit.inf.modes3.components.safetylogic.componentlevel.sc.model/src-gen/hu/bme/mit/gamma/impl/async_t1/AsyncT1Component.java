package hu.bme.mit.gamma.impl.async_t1;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import org.yakindu.scr.ITimer;

import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;

import hu.bme.mit.gamma.impl.t1.*;

public class AsyncT1Component implements Runnable, AsyncT1ComponentInterface {			
	// Thread running this wrapper instance
	private Thread thread;
	// Wrapped synchronous instance
	private T1Component t1Component = new T1Component();
	// Control port instances
	// Wrapped port instances
	private T1ProtocolProvidedDivergent t1ProtocolProvidedDivergent = new T1ProtocolProvidedDivergent();
	private T1ProtocolRequiredDivergent t1ProtocolRequiredDivergent = new T1ProtocolRequiredDivergent();
	private S15ProtocolProvidedCW s15ProtocolProvidedCW = new S15ProtocolProvidedCW();
	private S15ProtocolRequiredCW s15ProtocolRequiredCW = new S15ProtocolRequiredCW();
	private S12ProtocolProvidedCCW s12ProtocolProvidedCCW = new S12ProtocolProvidedCCW();
	private S12ProtocolRequiredCCW s12ProtocolRequiredCCW = new S12ProtocolRequiredCCW();
	private S15ControlProvided s15ControlProvided = new S15ControlProvided();
	private T1TurnoutProvided t1TurnoutProvided = new T1TurnoutProvided();
	private S12ControlProvided s12ControlProvided = new S12ControlProvided();
	private S15TrainProvided s15TrainProvided = new S15TrainProvided();
	private T1TrainProvided t1TrainProvided = new T1TrainProvided();
	private S12TrainProvided s12TrainProvided = new S12TrainProvided();
	// Clocks
	// Main queue
	private LinkedBlockingMultiQueue<String, Event> __asyncQueue = new LinkedBlockingMultiQueue<String, Event>();
	// Subqueues
	private LinkedBlockingMultiQueue<String, Event>.SubQueue messages;
	
	public AsyncT1Component() {
		init();
	}
	
	/** Enters the wrapped component. Should be used only be the container (composite system) class. */
	public void enter() {
		t1Component.enter();
	}
	
	/** Creates the subqueues, clocks and enters the wrapped synchronous component. */
	private void init() {
		// Creating subqueues: the negation regarding prioirities is needed,
		// beacase the lbmq defines higher priority with lower integer values
		__asyncQueue.addSubQueue("messages", -(1), 1024);
		messages = __asyncQueue.getSubQueue("messages");
		// Creating clocks
		// Entering the statecharts
		enter();
		// The thread has to be started manually
	}
	
	// Inner classes representing control ports
	
	// Inner classes representing wrapped ports
	public class T1ProtocolProvidedDivergent implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("T1ProtocolProvidedDivergent.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("T1ProtocolProvidedDivergent.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("T1ProtocolProvidedDivergent.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("T1ProtocolProvidedDivergent.reserve", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t1Component.getT1ProtocolProvidedDivergent().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getT1ProtocolProvidedDivergent().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T1ProtocolProvidedDivergent getT1ProtocolProvidedDivergent() {
		return t1ProtocolProvidedDivergent;
	}
	
	public class T1ProtocolRequiredDivergent implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCanGo() {
			return t1Component.getT1ProtocolRequiredDivergent().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t1Component.getT1ProtocolRequiredDivergent().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t1Component.getT1ProtocolRequiredDivergent().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t1Component.getT1ProtocolRequiredDivergent().isRaisedReserve();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t1Component.getT1ProtocolRequiredDivergent().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t1Component.getT1ProtocolRequiredDivergent().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T1ProtocolRequiredDivergent getT1ProtocolRequiredDivergent() {
		return t1ProtocolRequiredDivergent;
	}
	
	public class S15ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S15ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S15ProtocolProvidedCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S15ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S15ProtocolProvidedCW.reserve", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t1Component.getS15ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getS15ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S15ProtocolProvidedCW getS15ProtocolProvidedCW() {
		return s15ProtocolProvidedCW;
	}
	
	public class S15ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCanGo() {
			return t1Component.getS15ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t1Component.getS15ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t1Component.getS15ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t1Component.getS15ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t1Component.getS15ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t1Component.getS15ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S15ProtocolRequiredCW getS15ProtocolRequiredCW() {
		return s15ProtocolRequiredCW;
	}
	
	public class S12ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S12ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S12ProtocolProvidedCCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S12ProtocolProvidedCCW.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S12ProtocolProvidedCCW.reserve", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t1Component.getS12ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getS12ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S12ProtocolProvidedCCW getS12ProtocolProvidedCCW() {
		return s12ProtocolProvidedCCW;
	}
	
	public class S12ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCanGo() {
			return t1Component.getS12ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t1Component.getS12ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t1Component.getS12ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t1Component.getS12ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t1Component.getS12ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t1Component.getS12ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S12ProtocolRequiredCCW getS12ProtocolRequiredCCW() {
		return s12ProtocolRequiredCCW;
	}
	
	public class S15ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S15ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t1Component.getS15ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t1Component.getS15ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t1Component.getS15ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getS15ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S15ControlProvided getS15ControlProvided() {
		return s15ControlProvided;
	}
	
	public class T1TurnoutProvided implements TurnoutControlInterface.Provided {
		
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T1TurnoutProvided.turnoutStraight", null));
		}
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T1TurnoutProvided.turnoutDivergent", null));
		}
		
		
		@Override
		public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
			t1Component.getT1TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getT1TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T1TurnoutProvided getT1TurnoutProvided() {
		return t1TurnoutProvided;
	}
	
	public class S12ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S12ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t1Component.getS12ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t1Component.getS12ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t1Component.getS12ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getS12ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S12ControlProvided getS12ControlProvided() {
		return s12ControlProvided;
	}
	
	public class S15TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S15TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S15TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t1Component.getS15TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getS15TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S15TrainProvided getS15TrainProvided() {
		return s15TrainProvided;
	}
	
	public class T1TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T1TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T1TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t1Component.getT1TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getT1TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T1TrainProvided getT1TrainProvided() {
		return t1TrainProvided;
	}
	
	public class S12TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S12TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S12TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t1Component.getS12TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t1Component.getS12TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S12TrainProvided getS12TrainProvided() {
		return s12TrainProvided;
	}
	
	/** Operation. */
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			try {
				Event event = __asyncQueue.take();		
				if (!isControlEvent(event)) {
					// Event is forwarded to the wrapped component
					forwardEvent(event);
				}
				performControlActions(event);		
			} catch (InterruptedException e) {
				thread.interrupt();
				System.out.println("Interrupted");
			}
		}
	}
	
	private boolean isControlEvent(Event event) {
		return false;
	}
	
	private void forwardEvent(Event event) {
		switch (event.getEvent()) {
			case "T1ProtocolProvidedDivergent.canGo":
				t1Component.getT1ProtocolProvidedDivergent().raiseCanGo();
			break;
			case "T1ProtocolProvidedDivergent.cannotGo":
				t1Component.getT1ProtocolProvidedDivergent().raiseCannotGo();
			break;
			case "T1ProtocolProvidedDivergent.release":
				t1Component.getT1ProtocolProvidedDivergent().raiseRelease();
			break;
			case "T1ProtocolProvidedDivergent.reserve":
				t1Component.getT1ProtocolProvidedDivergent().raiseReserve();
			break;
			case "S15ProtocolProvidedCW.canGo":
				t1Component.getS15ProtocolProvidedCW().raiseCanGo();
			break;
			case "S15ProtocolProvidedCW.cannotGo":
				t1Component.getS15ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S15ProtocolProvidedCW.release":
				t1Component.getS15ProtocolProvidedCW().raiseRelease();
			break;
			case "S15ProtocolProvidedCW.reserve":
				t1Component.getS15ProtocolProvidedCW().raiseReserve();
			break;
			case "S12ProtocolProvidedCCW.canGo":
				t1Component.getS12ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S12ProtocolProvidedCCW.cannotGo":
				t1Component.getS12ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S12ProtocolProvidedCCW.release":
				t1Component.getS12ProtocolProvidedCCW().raiseRelease();
			break;
			case "S12ProtocolProvidedCCW.reserve":
				t1Component.getS12ProtocolProvidedCCW().raiseReserve();
			break;
			case "S15ControlProvided.restartProtocol":
				t1Component.getS15ControlProvided().raiseRestartProtocol();
			break;
			case "T1TurnoutProvided.turnoutStraight":
				t1Component.getT1TurnoutProvided().raiseTurnoutStraight();
			break;
			case "T1TurnoutProvided.turnoutDivergent":
				t1Component.getT1TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "S12ControlProvided.restartProtocol":
				t1Component.getS12ControlProvided().raiseRestartProtocol();
			break;
			case "S15TrainProvided.unoccupy":
				t1Component.getS15TrainProvided().raiseUnoccupy();
			break;
			case "S15TrainProvided.occupy":
				t1Component.getS15TrainProvided().raiseOccupy();
			break;
			case "T1TrainProvided.unoccupy":
				t1Component.getT1TrainProvided().raiseUnoccupy();
			break;
			case "T1TrainProvided.occupy":
				t1Component.getT1TrainProvided().raiseOccupy();
			break;
			case "S12TrainProvided.unoccupy":
				t1Component.getS12TrainProvided().raiseUnoccupy();
			break;
			case "S12TrainProvided.occupy":
				t1Component.getS12TrainProvided().raiseOccupy();
			break;
			default:
				throw new IllegalArgumentException("No such event!");
		}
	}
	
	private void performControlActions(Event event) {
		String[] eventName = event.getEvent().split("\\.");
		// Any trigger
		t1Component.runFullCycle();
		return;
	}
	
	/** Starts this wrapper instance on a thread. */
	public void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	/** Stops the thread running this wrapper instance. */
	public void interrupt() {
		thread.interrupt();
	}
	
	public T1Component getT1Component() {
		return t1Component;
	}
	
	public void setTimer(ITimer timer) {
		t1Component.setTimer(timer);
	}
	
}
