package hu.bme.mit.gamma.impl.async_t3;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;

import hu.bme.mit.gamma.impl.t3.*;

public class AsyncT3Component implements Runnable, AsyncT3ComponentInterface {			
	// Thread running this wrapper instance
	private Thread thread;
	// Wrapped synchronous instance
	private T3Component t3Component = new T3Component();
	// Control port instances
	// Wrapped port instances
	private S20ProtocolProvidedCW s20ProtocolProvidedCW = new S20ProtocolProvidedCW();
	private S20ProtocolRequiredCW s20ProtocolRequiredCW = new S20ProtocolRequiredCW();
	private S19ProtocolProvidedCW s19ProtocolProvidedCW = new S19ProtocolProvidedCW();
	private S19ProtocolRequiredCW s19ProtocolRequiredCW = new S19ProtocolRequiredCW();
	private S26ProtocolProvidedCCW s26ProtocolProvidedCCW = new S26ProtocolProvidedCCW();
	private S26ProtocolRequiredCCW s26ProtocolRequiredCCW = new S26ProtocolRequiredCCW();
	private S30ProtocolProvidedCCW s30ProtocolProvidedCCW = new S30ProtocolProvidedCCW();
	private S30ProtocolRequiredCCW s30ProtocolRequiredCCW = new S30ProtocolRequiredCCW();
	private S20ControlProvided s20ControlProvided = new S20ControlProvided();
	private S19ControlProvided s19ControlProvided = new S19ControlProvided();
	private T3_1TurnoutProvided t3_1TurnoutProvided = new T3_1TurnoutProvided();
	private T3_2TurnoutProvided t3_2TurnoutProvided = new T3_2TurnoutProvided();
	private S26ControlProvided s26ControlProvided = new S26ControlProvided();
	private S30ControlProvided s30ControlProvided = new S30ControlProvided();
	private S20TrainRequired s20TrainRequired = new S20TrainRequired();
	private S19TrainRequired s19TrainRequired = new S19TrainRequired();
	private T3_1TrainRequired t3_1TrainRequired = new T3_1TrainRequired();
	private T3_2TrainRequired t3_2TrainRequired = new T3_2TrainRequired();
	private S26TrainRequired s26TrainRequired = new S26TrainRequired();
	private S30TrainRequired s30TrainRequired = new S30TrainRequired();
	// Clocks
	// Main queue
	private LinkedBlockingMultiQueue<String, Event> __asyncQueue = new LinkedBlockingMultiQueue<String, Event>();
	// Subqueues
	private LinkedBlockingMultiQueue<String, Event>.SubQueue messages;
	
	public AsyncT3Component() {
		init();
	}
	
	/** Enters the wrapped component. Should be used only be the container (composite system) class. */
	public void enter() {
		t3Component.enter();
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
	public class S20ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S20ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S20ProtocolProvidedCW.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S20ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S20ProtocolProvidedCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t3Component.getS20ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS20ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S20ProtocolProvidedCW getS20ProtocolProvidedCW() {
		return s20ProtocolProvidedCW;
	}
	
	public class S20ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t3Component.getS20ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t3Component.getS20ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t3Component.getS20ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t3Component.getS20ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t3Component.getS20ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS20ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S20ProtocolRequiredCW getS20ProtocolRequiredCW() {
		return s20ProtocolRequiredCW;
	}
	
	public class S19ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S19ProtocolProvidedCW.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S19ProtocolProvidedCW.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S19ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S19ProtocolProvidedCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t3Component.getS19ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS19ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S19ProtocolProvidedCW getS19ProtocolProvidedCW() {
		return s19ProtocolProvidedCW;
	}
	
	public class S19ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t3Component.getS19ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t3Component.getS19ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t3Component.getS19ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t3Component.getS19ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t3Component.getS19ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS19ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S19ProtocolRequiredCW getS19ProtocolRequiredCW() {
		return s19ProtocolRequiredCW;
	}
	
	public class S26ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S26ProtocolProvidedCCW.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S26ProtocolProvidedCCW.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S26ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S26ProtocolProvidedCCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t3Component.getS26ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS26ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S26ProtocolProvidedCCW getS26ProtocolProvidedCCW() {
		return s26ProtocolProvidedCCW;
	}
	
	public class S26ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t3Component.getS26ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t3Component.getS26ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t3Component.getS26ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t3Component.getS26ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t3Component.getS26ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS26ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S26ProtocolRequiredCCW getS26ProtocolRequiredCCW() {
		return s26ProtocolRequiredCCW;
	}
	
	public class S30ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S30ProtocolProvidedCCW.release", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S30ProtocolProvidedCCW.reserve", null));
		}
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S30ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S30ProtocolProvidedCCW.cannotGo", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t3Component.getS30ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS30ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S30ProtocolProvidedCCW getS30ProtocolProvidedCCW() {
		return s30ProtocolProvidedCCW;
	}
	
	public class S30ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedRelease() {
			return t3Component.getS30ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t3Component.getS30ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCanGo() {
			return t3Component.getS30ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t3Component.getS30ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t3Component.getS30ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS30ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S30ProtocolRequiredCCW getS30ProtocolRequiredCCW() {
		return s30ProtocolRequiredCCW;
	}
	
	public class S20ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S20ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t3Component.getS20ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t3Component.getS20ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t3Component.getS20ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t3Component.getS20ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t3Component.getS20ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS20ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S20ControlProvided getS20ControlProvided() {
		return s20ControlProvided;
	}
	
	public class S19ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S19ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t3Component.getS19ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t3Component.getS19ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t3Component.getS19ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t3Component.getS19ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t3Component.getS19ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS19ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S19ControlProvided getS19ControlProvided() {
		return s19ControlProvided;
	}
	
	public class T3_1TurnoutProvided implements TurnoutInterface.Provided {
		
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T3_1TurnoutProvided.turnoutStraight", null));
		}
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T3_1TurnoutProvided.turnoutDivergent", null));
		}
		
		
		@Override
		public void registerListener(TurnoutInterface.Listener.Provided listener) {
			t3Component.getT3_1TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getT3_1TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T3_1TurnoutProvided getT3_1TurnoutProvided() {
		return t3_1TurnoutProvided;
	}
	
	public class T3_2TurnoutProvided implements TurnoutInterface.Provided {
		
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T3_2TurnoutProvided.turnoutStraight", null));
		}
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T3_2TurnoutProvided.turnoutDivergent", null));
		}
		
		
		@Override
		public void registerListener(TurnoutInterface.Listener.Provided listener) {
			t3Component.getT3_2TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getT3_2TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T3_2TurnoutProvided getT3_2TurnoutProvided() {
		return t3_2TurnoutProvided;
	}
	
	public class S26ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S26ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t3Component.getS26ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t3Component.getS26ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t3Component.getS26ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t3Component.getS26ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t3Component.getS26ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS26ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S26ControlProvided getS26ControlProvided() {
		return s26ControlProvided;
	}
	
	public class S30ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S30ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t3Component.getS30ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t3Component.getS30ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t3Component.getS30ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t3Component.getS30ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t3Component.getS30ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t3Component.getS30ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S30ControlProvided getS30ControlProvided() {
		return s30ControlProvided;
	}
	
	public class S20TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S20TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S20TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t3Component.getS20TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS20TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S20TrainRequired getS20TrainRequired() {
		return s20TrainRequired;
	}
	
	public class S19TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S19TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S19TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t3Component.getS19TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS19TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S19TrainRequired getS19TrainRequired() {
		return s19TrainRequired;
	}
	
	public class T3_1TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T3_1TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T3_1TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t3Component.getT3_1TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getT3_1TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T3_1TrainRequired getT3_1TrainRequired() {
		return t3_1TrainRequired;
	}
	
	public class T3_2TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T3_2TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T3_2TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t3Component.getT3_2TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getT3_2TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T3_2TrainRequired getT3_2TrainRequired() {
		return t3_2TrainRequired;
	}
	
	public class S26TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S26TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S26TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t3Component.getS26TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS26TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S26TrainRequired getS26TrainRequired() {
		return s26TrainRequired;
	}
	
	public class S30TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S30TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S30TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t3Component.getS30TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t3Component.getS30TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S30TrainRequired getS30TrainRequired() {
		return s30TrainRequired;
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
			case "S20ProtocolProvidedCW.release":
				t3Component.getS20ProtocolProvidedCW().raiseRelease();
			break;
			case "S20ProtocolProvidedCW.reserve":
				t3Component.getS20ProtocolProvidedCW().raiseReserve();
			break;
			case "S20ProtocolProvidedCW.canGo":
				t3Component.getS20ProtocolProvidedCW().raiseCanGo();
			break;
			case "S20ProtocolProvidedCW.cannotGo":
				t3Component.getS20ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S19ProtocolProvidedCW.release":
				t3Component.getS19ProtocolProvidedCW().raiseRelease();
			break;
			case "S19ProtocolProvidedCW.reserve":
				t3Component.getS19ProtocolProvidedCW().raiseReserve();
			break;
			case "S19ProtocolProvidedCW.canGo":
				t3Component.getS19ProtocolProvidedCW().raiseCanGo();
			break;
			case "S19ProtocolProvidedCW.cannotGo":
				t3Component.getS19ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S26ProtocolProvidedCCW.release":
				t3Component.getS26ProtocolProvidedCCW().raiseRelease();
			break;
			case "S26ProtocolProvidedCCW.reserve":
				t3Component.getS26ProtocolProvidedCCW().raiseReserve();
			break;
			case "S26ProtocolProvidedCCW.canGo":
				t3Component.getS26ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S26ProtocolProvidedCCW.cannotGo":
				t3Component.getS26ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S30ProtocolProvidedCCW.release":
				t3Component.getS30ProtocolProvidedCCW().raiseRelease();
			break;
			case "S30ProtocolProvidedCCW.reserve":
				t3Component.getS30ProtocolProvidedCCW().raiseReserve();
			break;
			case "S30ProtocolProvidedCCW.canGo":
				t3Component.getS30ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S30ProtocolProvidedCCW.cannotGo":
				t3Component.getS30ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S20ControlProvided.restartProtocol":
				t3Component.getS20ControlProvided().raiseRestartProtocol();
			break;
			case "S19ControlProvided.restartProtocol":
				t3Component.getS19ControlProvided().raiseRestartProtocol();
			break;
			case "T3_1TurnoutProvided.turnoutStraight":
				t3Component.getT3_1TurnoutProvided().raiseTurnoutStraight();
			break;
			case "T3_1TurnoutProvided.turnoutDivergent":
				t3Component.getT3_1TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "T3_2TurnoutProvided.turnoutStraight":
				t3Component.getT3_2TurnoutProvided().raiseTurnoutStraight();
			break;
			case "T3_2TurnoutProvided.turnoutDivergent":
				t3Component.getT3_2TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "S26ControlProvided.restartProtocol":
				t3Component.getS26ControlProvided().raiseRestartProtocol();
			break;
			case "S30ControlProvided.restartProtocol":
				t3Component.getS30ControlProvided().raiseRestartProtocol();
			break;
			case "S20TrainRequired.occupy":
				t3Component.getS20TrainRequired().raiseOccupy();
			break;
			case "S20TrainRequired.unoccupy":
				t3Component.getS20TrainRequired().raiseUnoccupy();
			break;
			case "S19TrainRequired.occupy":
				t3Component.getS19TrainRequired().raiseOccupy();
			break;
			case "S19TrainRequired.unoccupy":
				t3Component.getS19TrainRequired().raiseUnoccupy();
			break;
			case "T3_1TrainRequired.occupy":
				t3Component.getT3_1TrainRequired().raiseOccupy();
			break;
			case "T3_1TrainRequired.unoccupy":
				t3Component.getT3_1TrainRequired().raiseUnoccupy();
			break;
			case "T3_2TrainRequired.occupy":
				t3Component.getT3_2TrainRequired().raiseOccupy();
			break;
			case "T3_2TrainRequired.unoccupy":
				t3Component.getT3_2TrainRequired().raiseUnoccupy();
			break;
			case "S26TrainRequired.occupy":
				t3Component.getS26TrainRequired().raiseOccupy();
			break;
			case "S26TrainRequired.unoccupy":
				t3Component.getS26TrainRequired().raiseUnoccupy();
			break;
			case "S30TrainRequired.occupy":
				t3Component.getS30TrainRequired().raiseOccupy();
			break;
			case "S30TrainRequired.unoccupy":
				t3Component.getS30TrainRequired().raiseUnoccupy();
			break;
			default:
				throw new IllegalArgumentException("No such event!");
		}
	}
	
	private void performControlActions(Event event) {
		String[] eventName = event.getEvent().split("\\.");
		// Any trigger
		t3Component.runFullCycle();
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
	
	public T3Component getT3Component() {
		return t3Component;
	}
	
	
}
