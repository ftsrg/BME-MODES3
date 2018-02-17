package hu.bme.mit.gamma.impl.async_t5;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import org.yakindu.scr.ITimer;

import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;

import hu.bme.mit.gamma.impl.t5.*;

public class AsyncT5Component implements Runnable, AsyncT5ComponentInterface {			
	// Thread running this wrapper instance
	private Thread thread;
	// Wrapped synchronous instance
	private T5Component t5Component = new T5Component();
	// Control port instances
	// Wrapped port instances
	private S11ProtocolProvidedCW s11ProtocolProvidedCW = new S11ProtocolProvidedCW();
	private S11ProtocolRequiredCW s11ProtocolRequiredCW = new S11ProtocolRequiredCW();
	private S10ProtocolProvidedCW s10ProtocolProvidedCW = new S10ProtocolProvidedCW();
	private S10ProtocolRequiredCW s10ProtocolRequiredCW = new S10ProtocolRequiredCW();
	private S13ProtocolProvidedCCW s13ProtocolProvidedCCW = new S13ProtocolProvidedCCW();
	private S13ProtocolRequiredCCW s13ProtocolRequiredCCW = new S13ProtocolRequiredCCW();
	private S11ControlProvided s11ControlProvided = new S11ControlProvided();
	private S10ControlProvided s10ControlProvided = new S10ControlProvided();
	private T5TurnoutProvided t5TurnoutProvided = new T5TurnoutProvided();
	private S08ControlProvided s08ControlProvided = new S08ControlProvided();
	private S13ControlProvided s13ControlProvided = new S13ControlProvided();
	private S11TrainProvided s11TrainProvided = new S11TrainProvided();
	private S10TrainProvided s10TrainProvided = new S10TrainProvided();
	private T5TrainProvided t5TrainProvided = new T5TrainProvided();
	private S08TrainProvided s08TrainProvided = new S08TrainProvided();
	private S13TrainProvided s13TrainProvided = new S13TrainProvided();
	// Clocks
	// Main queue
	private LinkedBlockingMultiQueue<String, Event> __asyncQueue = new LinkedBlockingMultiQueue<String, Event>();
	// Subqueues
	private LinkedBlockingMultiQueue<String, Event>.SubQueue messages;
	
	public AsyncT5Component() {
		init();
	}
	
	/** Enters the wrapped component. Should be used only be the container (composite system) class. */
	public void enter() {
		t5Component.enter();
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
	public class S11ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S11ProtocolProvidedCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S11ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S11ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S11ProtocolProvidedCW.reserve", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t5Component.getS11ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS11ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S11ProtocolProvidedCW getS11ProtocolProvidedCW() {
		return s11ProtocolProvidedCW;
	}
	
	public class S11ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCannotGo() {
			return t5Component.getS11ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t5Component.getS11ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t5Component.getS11ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t5Component.getS11ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t5Component.getS11ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t5Component.getS11ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S11ProtocolRequiredCW getS11ProtocolRequiredCW() {
		return s11ProtocolRequiredCW;
	}
	
	public class S10ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S10ProtocolProvidedCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S10ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S10ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S10ProtocolProvidedCW.reserve", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t5Component.getS10ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS10ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S10ProtocolProvidedCW getS10ProtocolProvidedCW() {
		return s10ProtocolProvidedCW;
	}
	
	public class S10ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCannotGo() {
			return t5Component.getS10ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t5Component.getS10ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t5Component.getS10ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t5Component.getS10ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t5Component.getS10ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t5Component.getS10ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S10ProtocolRequiredCW getS10ProtocolRequiredCW() {
		return s10ProtocolRequiredCW;
	}
	
	public class S13ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S13ProtocolProvidedCCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S13ProtocolProvidedCCW.release", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S13ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S13ProtocolProvidedCCW.reserve", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t5Component.getS13ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS13ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S13ProtocolProvidedCCW getS13ProtocolProvidedCCW() {
		return s13ProtocolProvidedCCW;
	}
	
	public class S13ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCannotGo() {
			return t5Component.getS13ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t5Component.getS13ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t5Component.getS13ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t5Component.getS13ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t5Component.getS13ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t5Component.getS13ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S13ProtocolRequiredCCW getS13ProtocolRequiredCCW() {
		return s13ProtocolRequiredCCW;
	}
	
	public class S11ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S11ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t5Component.getS11ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t5Component.getS11ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t5Component.getS11ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS11ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S11ControlProvided getS11ControlProvided() {
		return s11ControlProvided;
	}
	
	public class S10ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S10ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t5Component.getS10ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t5Component.getS10ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t5Component.getS10ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS10ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S10ControlProvided getS10ControlProvided() {
		return s10ControlProvided;
	}
	
	public class T5TurnoutProvided implements TurnoutControlInterface.Provided {
		
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T5TurnoutProvided.turnoutDivergent", null));
		}
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T5TurnoutProvided.turnoutStraight", null));
		}
		
		
		@Override
		public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
			t5Component.getT5TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getT5TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T5TurnoutProvided getT5TurnoutProvided() {
		return t5TurnoutProvided;
	}
	
	public class S08ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S08ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t5Component.getS08ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t5Component.getS08ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t5Component.getS08ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS08ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S08ControlProvided getS08ControlProvided() {
		return s08ControlProvided;
	}
	
	public class S13ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S13ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t5Component.getS13ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t5Component.getS13ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t5Component.getS13ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS13ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S13ControlProvided getS13ControlProvided() {
		return s13ControlProvided;
	}
	
	public class S11TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S11TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S11TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t5Component.getS11TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS11TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S11TrainProvided getS11TrainProvided() {
		return s11TrainProvided;
	}
	
	public class S10TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S10TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S10TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t5Component.getS10TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS10TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S10TrainProvided getS10TrainProvided() {
		return s10TrainProvided;
	}
	
	public class T5TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T5TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T5TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t5Component.getT5TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getT5TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T5TrainProvided getT5TrainProvided() {
		return t5TrainProvided;
	}
	
	public class S08TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S08TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S08TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t5Component.getS08TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS08TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S08TrainProvided getS08TrainProvided() {
		return s08TrainProvided;
	}
	
	public class S13TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S13TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S13TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t5Component.getS13TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t5Component.getS13TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S13TrainProvided getS13TrainProvided() {
		return s13TrainProvided;
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
			case "S11ProtocolProvidedCW.cannotGo":
				t5Component.getS11ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S11ProtocolProvidedCW.release":
				t5Component.getS11ProtocolProvidedCW().raiseRelease();
			break;
			case "S11ProtocolProvidedCW.canGo":
				t5Component.getS11ProtocolProvidedCW().raiseCanGo();
			break;
			case "S11ProtocolProvidedCW.reserve":
				t5Component.getS11ProtocolProvidedCW().raiseReserve();
			break;
			case "S10ProtocolProvidedCW.cannotGo":
				t5Component.getS10ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S10ProtocolProvidedCW.release":
				t5Component.getS10ProtocolProvidedCW().raiseRelease();
			break;
			case "S10ProtocolProvidedCW.canGo":
				t5Component.getS10ProtocolProvidedCW().raiseCanGo();
			break;
			case "S10ProtocolProvidedCW.reserve":
				t5Component.getS10ProtocolProvidedCW().raiseReserve();
			break;
			case "S13ProtocolProvidedCCW.cannotGo":
				t5Component.getS13ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S13ProtocolProvidedCCW.release":
				t5Component.getS13ProtocolProvidedCCW().raiseRelease();
			break;
			case "S13ProtocolProvidedCCW.canGo":
				t5Component.getS13ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S13ProtocolProvidedCCW.reserve":
				t5Component.getS13ProtocolProvidedCCW().raiseReserve();
			break;
			case "S11ControlProvided.restartProtocol":
				t5Component.getS11ControlProvided().raiseRestartProtocol();
			break;
			case "S10ControlProvided.restartProtocol":
				t5Component.getS10ControlProvided().raiseRestartProtocol();
			break;
			case "T5TurnoutProvided.turnoutDivergent":
				t5Component.getT5TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "T5TurnoutProvided.turnoutStraight":
				t5Component.getT5TurnoutProvided().raiseTurnoutStraight();
			break;
			case "S08ControlProvided.restartProtocol":
				t5Component.getS08ControlProvided().raiseRestartProtocol();
			break;
			case "S13ControlProvided.restartProtocol":
				t5Component.getS13ControlProvided().raiseRestartProtocol();
			break;
			case "S11TrainProvided.unoccupy":
				t5Component.getS11TrainProvided().raiseUnoccupy();
			break;
			case "S11TrainProvided.occupy":
				t5Component.getS11TrainProvided().raiseOccupy();
			break;
			case "S10TrainProvided.unoccupy":
				t5Component.getS10TrainProvided().raiseUnoccupy();
			break;
			case "S10TrainProvided.occupy":
				t5Component.getS10TrainProvided().raiseOccupy();
			break;
			case "T5TrainProvided.unoccupy":
				t5Component.getT5TrainProvided().raiseUnoccupy();
			break;
			case "T5TrainProvided.occupy":
				t5Component.getT5TrainProvided().raiseOccupy();
			break;
			case "S08TrainProvided.unoccupy":
				t5Component.getS08TrainProvided().raiseUnoccupy();
			break;
			case "S08TrainProvided.occupy":
				t5Component.getS08TrainProvided().raiseOccupy();
			break;
			case "S13TrainProvided.unoccupy":
				t5Component.getS13TrainProvided().raiseUnoccupy();
			break;
			case "S13TrainProvided.occupy":
				t5Component.getS13TrainProvided().raiseOccupy();
			break;
			default:
				throw new IllegalArgumentException("No such event!");
		}
	}
	
	private void performControlActions(Event event) {
		String[] eventName = event.getEvent().split("\\.");
		// Any trigger
		t5Component.runFullCycle();
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
	
	public T5Component getT5Component() {
		return t5Component;
	}
	
	public void setTimer(ITimer timer) {
		t5Component.setTimer(timer);
	}
	
}
