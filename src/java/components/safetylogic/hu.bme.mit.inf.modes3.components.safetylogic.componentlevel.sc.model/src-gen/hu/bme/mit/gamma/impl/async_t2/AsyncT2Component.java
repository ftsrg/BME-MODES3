package hu.bme.mit.gamma.impl.async_t2;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;

import hu.bme.mit.gamma.impl.t2.*;

public class AsyncT2Component implements Runnable, AsyncT2ComponentInterface {			
	// Thread running this wrapper instance
	private Thread thread;
	// Wrapped synchronous instance
	private T2Component t2Component = new T2Component();
	// Control port instances
	// Wrapped port instances
	private S24ProtocolProvidedCCW s24ProtocolProvidedCCW = new S24ProtocolProvidedCCW();
	private S24ProtocolRequiredCCW s24ProtocolRequiredCCW = new S24ProtocolRequiredCCW();
	private T2ProtocolProvidedDivergent t2ProtocolProvidedDivergent = new T2ProtocolProvidedDivergent();
	private T2ProtocolRequiredDivergent t2ProtocolRequiredDivergent = new T2ProtocolRequiredDivergent();
	private S18ProtocolProvidedCW s18ProtocolProvidedCW = new S18ProtocolProvidedCW();
	private S18ProtocolRequiredCW s18ProtocolRequiredCW = new S18ProtocolRequiredCW();
	private S24ControlProvided s24ControlProvided = new S24ControlProvided();
	private S29ControlProvided s29ControlProvided = new S29ControlProvided();
	private T2TurnoutProvided t2TurnoutProvided = new T2TurnoutProvided();
	private S31ControlProvided s31ControlProvided = new S31ControlProvided();
	private S18ControlProvided s18ControlProvided = new S18ControlProvided();
	private S24TrainRequired s24TrainRequired = new S24TrainRequired();
	private S29TrainRequired s29TrainRequired = new S29TrainRequired();
	private T2TrainRequired t2TrainRequired = new T2TrainRequired();
	private S31TrainRequired s31TrainRequired = new S31TrainRequired();
	private S18TrainRequired s18TrainRequired = new S18TrainRequired();
	// Clocks
	// Main queue
	private LinkedBlockingMultiQueue<String, Event> __asyncQueue = new LinkedBlockingMultiQueue<String, Event>();
	// Subqueues
	private LinkedBlockingMultiQueue<String, Event>.SubQueue messages;
	
	public AsyncT2Component() {
		init();
	}
	
	/** Enters the wrapped component. Should be used only be the container (composite system) class. */
	public void enter() {
		t2Component.enter();
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
	public class S24ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S24ProtocolProvidedCCW.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S24ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S24ProtocolProvidedCCW.release", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S24ProtocolProvidedCCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t2Component.getS24ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getS24ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S24ProtocolProvidedCCW getS24ProtocolProvidedCCW() {
		return s24ProtocolProvidedCCW;
	}
	
	public class S24ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedReserve() {
			return t2Component.getS24ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t2Component.getS24ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t2Component.getS24ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t2Component.getS24ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t2Component.getS24ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getS24ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S24ProtocolRequiredCCW getS24ProtocolRequiredCCW() {
		return s24ProtocolRequiredCCW;
	}
	
	public class T2ProtocolProvidedDivergent implements ProtocolInterface.Provided {
		
		@Override
		public void raiseReserve() {
			messages.offer(new Event("T2ProtocolProvidedDivergent.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("T2ProtocolProvidedDivergent.canGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("T2ProtocolProvidedDivergent.release", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("T2ProtocolProvidedDivergent.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t2Component.getT2ProtocolProvidedDivergent().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getT2ProtocolProvidedDivergent().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T2ProtocolProvidedDivergent getT2ProtocolProvidedDivergent() {
		return t2ProtocolProvidedDivergent;
	}
	
	public class T2ProtocolRequiredDivergent implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedReserve() {
			return t2Component.getT2ProtocolRequiredDivergent().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t2Component.getT2ProtocolRequiredDivergent().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t2Component.getT2ProtocolRequiredDivergent().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t2Component.getT2ProtocolRequiredDivergent().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t2Component.getT2ProtocolRequiredDivergent().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getT2ProtocolRequiredDivergent().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T2ProtocolRequiredDivergent getT2ProtocolRequiredDivergent() {
		return t2ProtocolRequiredDivergent;
	}
	
	public class S18ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S18ProtocolProvidedCW.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S18ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S18ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S18ProtocolProvidedCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t2Component.getS18ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getS18ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S18ProtocolProvidedCW getS18ProtocolProvidedCW() {
		return s18ProtocolProvidedCW;
	}
	
	public class S18ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedReserve() {
			return t2Component.getS18ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t2Component.getS18ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t2Component.getS18ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t2Component.getS18ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t2Component.getS18ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getS18ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S18ProtocolRequiredCW getS18ProtocolRequiredCW() {
		return s18ProtocolRequiredCW;
	}
	
	public class S24ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S24ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t2Component.getS24ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t2Component.getS24ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t2Component.getS24ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t2Component.getS24ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t2Component.getS24ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getS24ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S24ControlProvided getS24ControlProvided() {
		return s24ControlProvided;
	}
	
	public class S29ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S29ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t2Component.getS29ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t2Component.getS29ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t2Component.getS29ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t2Component.getS29ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t2Component.getS29ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getS29ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S29ControlProvided getS29ControlProvided() {
		return s29ControlProvided;
	}
	
	public class T2TurnoutProvided implements TurnoutInterface.Provided {
		
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T2TurnoutProvided.turnoutDivergent", null));
		}
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T2TurnoutProvided.turnoutStraight", null));
		}
		
		
		@Override
		public void registerListener(TurnoutInterface.Listener.Provided listener) {
			t2Component.getT2TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getT2TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T2TurnoutProvided getT2TurnoutProvided() {
		return t2TurnoutProvided;
	}
	
	public class S31ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S31ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t2Component.getS31ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t2Component.getS31ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t2Component.getS31ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t2Component.getS31ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t2Component.getS31ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getS31ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S31ControlProvided getS31ControlProvided() {
		return s31ControlProvided;
	}
	
	public class S18ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S18ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t2Component.getS18ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t2Component.getS18ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t2Component.getS18ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t2Component.getS18ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t2Component.getS18ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t2Component.getS18ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S18ControlProvided getS18ControlProvided() {
		return s18ControlProvided;
	}
	
	public class S24TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S24TrainRequired.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S24TrainRequired.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t2Component.getS24TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getS24TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S24TrainRequired getS24TrainRequired() {
		return s24TrainRequired;
	}
	
	public class S29TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S29TrainRequired.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S29TrainRequired.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t2Component.getS29TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getS29TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S29TrainRequired getS29TrainRequired() {
		return s29TrainRequired;
	}
	
	public class T2TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T2TrainRequired.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T2TrainRequired.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t2Component.getT2TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getT2TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T2TrainRequired getT2TrainRequired() {
		return t2TrainRequired;
	}
	
	public class S31TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S31TrainRequired.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S31TrainRequired.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t2Component.getS31TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getS31TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S31TrainRequired getS31TrainRequired() {
		return s31TrainRequired;
	}
	
	public class S18TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S18TrainRequired.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S18TrainRequired.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t2Component.getS18TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t2Component.getS18TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S18TrainRequired getS18TrainRequired() {
		return s18TrainRequired;
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
			case "S24ProtocolProvidedCCW.reserve":
				t2Component.getS24ProtocolProvidedCCW().raiseReserve();
			break;
			case "S24ProtocolProvidedCCW.canGo":
				t2Component.getS24ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S24ProtocolProvidedCCW.release":
				t2Component.getS24ProtocolProvidedCCW().raiseRelease();
			break;
			case "S24ProtocolProvidedCCW.cannotGo":
				t2Component.getS24ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "T2ProtocolProvidedDivergent.reserve":
				t2Component.getT2ProtocolProvidedDivergent().raiseReserve();
			break;
			case "T2ProtocolProvidedDivergent.canGo":
				t2Component.getT2ProtocolProvidedDivergent().raiseCanGo();
			break;
			case "T2ProtocolProvidedDivergent.release":
				t2Component.getT2ProtocolProvidedDivergent().raiseRelease();
			break;
			case "T2ProtocolProvidedDivergent.cannotGo":
				t2Component.getT2ProtocolProvidedDivergent().raiseCannotGo();
			break;
			case "S18ProtocolProvidedCW.reserve":
				t2Component.getS18ProtocolProvidedCW().raiseReserve();
			break;
			case "S18ProtocolProvidedCW.canGo":
				t2Component.getS18ProtocolProvidedCW().raiseCanGo();
			break;
			case "S18ProtocolProvidedCW.release":
				t2Component.getS18ProtocolProvidedCW().raiseRelease();
			break;
			case "S18ProtocolProvidedCW.cannotGo":
				t2Component.getS18ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S24ControlProvided.restartProtocol":
				t2Component.getS24ControlProvided().raiseRestartProtocol();
			break;
			case "S29ControlProvided.restartProtocol":
				t2Component.getS29ControlProvided().raiseRestartProtocol();
			break;
			case "T2TurnoutProvided.turnoutDivergent":
				t2Component.getT2TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "T2TurnoutProvided.turnoutStraight":
				t2Component.getT2TurnoutProvided().raiseTurnoutStraight();
			break;
			case "S31ControlProvided.restartProtocol":
				t2Component.getS31ControlProvided().raiseRestartProtocol();
			break;
			case "S18ControlProvided.restartProtocol":
				t2Component.getS18ControlProvided().raiseRestartProtocol();
			break;
			case "S24TrainRequired.unoccupy":
				t2Component.getS24TrainRequired().raiseUnoccupy();
			break;
			case "S24TrainRequired.occupy":
				t2Component.getS24TrainRequired().raiseOccupy();
			break;
			case "S29TrainRequired.unoccupy":
				t2Component.getS29TrainRequired().raiseUnoccupy();
			break;
			case "S29TrainRequired.occupy":
				t2Component.getS29TrainRequired().raiseOccupy();
			break;
			case "T2TrainRequired.unoccupy":
				t2Component.getT2TrainRequired().raiseUnoccupy();
			break;
			case "T2TrainRequired.occupy":
				t2Component.getT2TrainRequired().raiseOccupy();
			break;
			case "S31TrainRequired.unoccupy":
				t2Component.getS31TrainRequired().raiseUnoccupy();
			break;
			case "S31TrainRequired.occupy":
				t2Component.getS31TrainRequired().raiseOccupy();
			break;
			case "S18TrainRequired.unoccupy":
				t2Component.getS18TrainRequired().raiseUnoccupy();
			break;
			case "S18TrainRequired.occupy":
				t2Component.getS18TrainRequired().raiseOccupy();
			break;
			default:
				throw new IllegalArgumentException("No such event!");
		}
	}
	
	private void performControlActions(Event event) {
		String[] eventName = event.getEvent().split("\\.");
		// Any trigger
		t2Component.runFullCycle();
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
	
	public T2Component getT2Component() {
		return t2Component;
	}
	
	
}
