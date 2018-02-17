package hu.bme.mit.gamma.impl.async_t6;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import org.yakindu.scr.ITimer;

import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;

import hu.bme.mit.gamma.impl.t6.*;

public class AsyncT6Component implements Runnable, AsyncT6ComponentInterface {			
	// Thread running this wrapper instance
	private Thread thread;
	// Wrapped synchronous instance
	private T6Component t6Component = new T6Component();
	// Control port instances
	// Wrapped port instances
	private S17ProtocolProvidedCCW s17ProtocolProvidedCCW = new S17ProtocolProvidedCCW();
	private S17ProtocolRequiredCCW s17ProtocolRequiredCCW = new S17ProtocolRequiredCCW();
	private S22ProtocolProvidedCW s22ProtocolProvidedCW = new S22ProtocolProvidedCW();
	private S22ProtocolRequiredCW s22ProtocolRequiredCW = new S22ProtocolRequiredCW();
	private S27ProtocolProvidedCW s27ProtocolProvidedCW = new S27ProtocolProvidedCW();
	private S27ProtocolRequiredCW s27ProtocolRequiredCW = new S27ProtocolRequiredCW();
	private S17ControlProvided s17ControlProvided = new S17ControlProvided();
	private T6TurnoutProvided t6TurnoutProvided = new T6TurnoutProvided();
	private S22ControlProvided s22ControlProvided = new S22ControlProvided();
	private S23ControlProvided s23ControlProvided = new S23ControlProvided();
	private S27ControlProvided s27ControlProvided = new S27ControlProvided();
	private S17TrainProvided s17TrainProvided = new S17TrainProvided();
	private T6TrainProvided t6TrainProvided = new T6TrainProvided();
	private S22TrainProvided s22TrainProvided = new S22TrainProvided();
	private S23TrainProvided s23TrainProvided = new S23TrainProvided();
	private S27TrainProvided s27TrainProvided = new S27TrainProvided();
	// Clocks
	// Main queue
	private LinkedBlockingMultiQueue<String, Event> __asyncQueue = new LinkedBlockingMultiQueue<String, Event>();
	// Subqueues
	private LinkedBlockingMultiQueue<String, Event>.SubQueue messages;
	
	public AsyncT6Component() {
		init();
	}
	
	/** Enters the wrapped component. Should be used only be the container (composite system) class. */
	public void enter() {
		t6Component.enter();
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
	public class S17ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S17ProtocolProvidedCCW.release", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S17ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S17ProtocolProvidedCCW.reserve", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S17ProtocolProvidedCCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t6Component.getS17ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS17ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S17ProtocolProvidedCCW getS17ProtocolProvidedCCW() {
		return s17ProtocolProvidedCCW;
	}
	
	public class S17ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t6Component.getS17ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t6Component.getS17ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t6Component.getS17ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t6Component.getS17ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t6Component.getS17ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t6Component.getS17ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S17ProtocolRequiredCCW getS17ProtocolRequiredCCW() {
		return s17ProtocolRequiredCCW;
	}
	
	public class S22ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S22ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S22ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S22ProtocolProvidedCW.reserve", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S22ProtocolProvidedCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t6Component.getS22ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS22ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S22ProtocolProvidedCW getS22ProtocolProvidedCW() {
		return s22ProtocolProvidedCW;
	}
	
	public class S22ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t6Component.getS22ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t6Component.getS22ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t6Component.getS22ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t6Component.getS22ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t6Component.getS22ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t6Component.getS22ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S22ProtocolRequiredCW getS22ProtocolRequiredCW() {
		return s22ProtocolRequiredCW;
	}
	
	public class S27ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S27ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S27ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S27ProtocolProvidedCW.reserve", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S27ProtocolProvidedCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t6Component.getS27ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS27ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S27ProtocolProvidedCW getS27ProtocolProvidedCW() {
		return s27ProtocolProvidedCW;
	}
	
	public class S27ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t6Component.getS27ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t6Component.getS27ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t6Component.getS27ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t6Component.getS27ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t6Component.getS27ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t6Component.getS27ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S27ProtocolRequiredCW getS27ProtocolRequiredCW() {
		return s27ProtocolRequiredCW;
	}
	
	public class S17ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S17ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t6Component.getS17ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t6Component.getS17ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t6Component.getS17ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS17ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S17ControlProvided getS17ControlProvided() {
		return s17ControlProvided;
	}
	
	public class T6TurnoutProvided implements TurnoutControlInterface.Provided {
		
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T6TurnoutProvided.turnoutStraight", null));
		}
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T6TurnoutProvided.turnoutDivergent", null));
		}
		
		
		@Override
		public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
			t6Component.getT6TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getT6TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T6TurnoutProvided getT6TurnoutProvided() {
		return t6TurnoutProvided;
	}
	
	public class S22ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S22ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t6Component.getS22ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t6Component.getS22ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t6Component.getS22ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS22ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S22ControlProvided getS22ControlProvided() {
		return s22ControlProvided;
	}
	
	public class S23ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S23ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t6Component.getS23ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t6Component.getS23ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t6Component.getS23ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS23ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S23ControlProvided getS23ControlProvided() {
		return s23ControlProvided;
	}
	
	public class S27ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S27ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t6Component.getS27ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t6Component.getS27ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t6Component.getS27ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS27ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S27ControlProvided getS27ControlProvided() {
		return s27ControlProvided;
	}
	
	public class S17TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S17TrainProvided.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S17TrainProvided.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t6Component.getS17TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS17TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S17TrainProvided getS17TrainProvided() {
		return s17TrainProvided;
	}
	
	public class T6TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T6TrainProvided.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T6TrainProvided.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t6Component.getT6TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getT6TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T6TrainProvided getT6TrainProvided() {
		return t6TrainProvided;
	}
	
	public class S22TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S22TrainProvided.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S22TrainProvided.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t6Component.getS22TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS22TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S22TrainProvided getS22TrainProvided() {
		return s22TrainProvided;
	}
	
	public class S23TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S23TrainProvided.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S23TrainProvided.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t6Component.getS23TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS23TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S23TrainProvided getS23TrainProvided() {
		return s23TrainProvided;
	}
	
	public class S27TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S27TrainProvided.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S27TrainProvided.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t6Component.getS27TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t6Component.getS27TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S27TrainProvided getS27TrainProvided() {
		return s27TrainProvided;
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
			case "S17ProtocolProvidedCCW.release":
				t6Component.getS17ProtocolProvidedCCW().raiseRelease();
			break;
			case "S17ProtocolProvidedCCW.canGo":
				t6Component.getS17ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S17ProtocolProvidedCCW.reserve":
				t6Component.getS17ProtocolProvidedCCW().raiseReserve();
			break;
			case "S17ProtocolProvidedCCW.cannotGo":
				t6Component.getS17ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S22ProtocolProvidedCW.release":
				t6Component.getS22ProtocolProvidedCW().raiseRelease();
			break;
			case "S22ProtocolProvidedCW.canGo":
				t6Component.getS22ProtocolProvidedCW().raiseCanGo();
			break;
			case "S22ProtocolProvidedCW.reserve":
				t6Component.getS22ProtocolProvidedCW().raiseReserve();
			break;
			case "S22ProtocolProvidedCW.cannotGo":
				t6Component.getS22ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S27ProtocolProvidedCW.release":
				t6Component.getS27ProtocolProvidedCW().raiseRelease();
			break;
			case "S27ProtocolProvidedCW.canGo":
				t6Component.getS27ProtocolProvidedCW().raiseCanGo();
			break;
			case "S27ProtocolProvidedCW.reserve":
				t6Component.getS27ProtocolProvidedCW().raiseReserve();
			break;
			case "S27ProtocolProvidedCW.cannotGo":
				t6Component.getS27ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S17ControlProvided.restartProtocol":
				t6Component.getS17ControlProvided().raiseRestartProtocol();
			break;
			case "T6TurnoutProvided.turnoutStraight":
				t6Component.getT6TurnoutProvided().raiseTurnoutStraight();
			break;
			case "T6TurnoutProvided.turnoutDivergent":
				t6Component.getT6TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "S22ControlProvided.restartProtocol":
				t6Component.getS22ControlProvided().raiseRestartProtocol();
			break;
			case "S23ControlProvided.restartProtocol":
				t6Component.getS23ControlProvided().raiseRestartProtocol();
			break;
			case "S27ControlProvided.restartProtocol":
				t6Component.getS27ControlProvided().raiseRestartProtocol();
			break;
			case "S17TrainProvided.occupy":
				t6Component.getS17TrainProvided().raiseOccupy();
			break;
			case "S17TrainProvided.unoccupy":
				t6Component.getS17TrainProvided().raiseUnoccupy();
			break;
			case "T6TrainProvided.occupy":
				t6Component.getT6TrainProvided().raiseOccupy();
			break;
			case "T6TrainProvided.unoccupy":
				t6Component.getT6TrainProvided().raiseUnoccupy();
			break;
			case "S22TrainProvided.occupy":
				t6Component.getS22TrainProvided().raiseOccupy();
			break;
			case "S22TrainProvided.unoccupy":
				t6Component.getS22TrainProvided().raiseUnoccupy();
			break;
			case "S23TrainProvided.occupy":
				t6Component.getS23TrainProvided().raiseOccupy();
			break;
			case "S23TrainProvided.unoccupy":
				t6Component.getS23TrainProvided().raiseUnoccupy();
			break;
			case "S27TrainProvided.occupy":
				t6Component.getS27TrainProvided().raiseOccupy();
			break;
			case "S27TrainProvided.unoccupy":
				t6Component.getS27TrainProvided().raiseUnoccupy();
			break;
			default:
				throw new IllegalArgumentException("No such event!");
		}
	}
	
	private void performControlActions(Event event) {
		String[] eventName = event.getEvent().split("\\.");
		// Any trigger
		t6Component.runFullCycle();
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
	
	public T6Component getT6Component() {
		return t6Component;
	}
	
	public void setTimer(ITimer timer) {
		t6Component.setTimer(timer);
	}
	
}
