package hu.bme.mit.gamma.impl.async_t4;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;

import hu.bme.mit.gamma.impl.t4.*;

public class AsyncT4Component implements Runnable, AsyncT4ComponentInterface {			
	// Thread running this wrapper instance
	private Thread thread;
	// Wrapped synchronous instance
	private T4Component t4Component = new T4Component();
	// Control port instances
	// Wrapped port instances
	private S01ProtocolProvidedCW s01ProtocolProvidedCW = new S01ProtocolProvidedCW();
	private S01ProtocolRequiredCW s01ProtocolRequiredCW = new S01ProtocolRequiredCW();
	private S07ProtocolProvidedCCW s07ProtocolProvidedCCW = new S07ProtocolProvidedCCW();
	private S07ProtocolRequiredCCW s07ProtocolRequiredCCW = new S07ProtocolRequiredCCW();
	private S06ProtocolProvidedCCW s06ProtocolProvidedCCW = new S06ProtocolProvidedCCW();
	private S06ProtocolRequiredCCW s06ProtocolRequiredCCW = new S06ProtocolRequiredCCW();
	private S01ControlProvided s01ControlProvided = new S01ControlProvided();
	private T4TurnoutProvided t4TurnoutProvided = new T4TurnoutProvided();
	private S04ControlProvided s04ControlProvided = new S04ControlProvided();
	private S05ControlProvided s05ControlProvided = new S05ControlProvided();
	private S06ControlProvided s06ControlProvided = new S06ControlProvided();
	private S07ControlProvided s07ControlProvided = new S07ControlProvided();
	private S01TrainRequired s01TrainRequired = new S01TrainRequired();
	private T4TrainRequired t4TrainRequired = new T4TrainRequired();
	private S04TrainRequired s04TrainRequired = new S04TrainRequired();
	private S05TrainRequired s05TrainRequired = new S05TrainRequired();
	private S06TrainRequired s06TrainRequired = new S06TrainRequired();
	private S07TrainRequired s07TrainRequired = new S07TrainRequired();
	// Clocks
	// Main queue
	private LinkedBlockingMultiQueue<String, Event> __asyncQueue = new LinkedBlockingMultiQueue<String, Event>();
	// Subqueues
	private LinkedBlockingMultiQueue<String, Event>.SubQueue messages;
	
	public AsyncT4Component() {
		init();
	}
	
	/** Enters the wrapped component. Should be used only be the container (composite system) class. */
	public void enter() {
		t4Component.enter();
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
	public class S01ProtocolProvidedCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S01ProtocolProvidedCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S01ProtocolProvidedCW.reserve", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S01ProtocolProvidedCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S01ProtocolProvidedCW.release", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t4Component.getS01ProtocolProvidedCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS01ProtocolProvidedCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S01ProtocolProvidedCW getS01ProtocolProvidedCW() {
		return s01ProtocolProvidedCW;
	}
	
	public class S01ProtocolRequiredCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCanGo() {
			return t4Component.getS01ProtocolRequiredCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t4Component.getS01ProtocolRequiredCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t4Component.getS01ProtocolRequiredCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t4Component.getS01ProtocolRequiredCW().isRaisedRelease();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t4Component.getS01ProtocolRequiredCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS01ProtocolRequiredCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S01ProtocolRequiredCW getS01ProtocolRequiredCW() {
		return s01ProtocolRequiredCW;
	}
	
	public class S07ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S07ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S07ProtocolProvidedCCW.reserve", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S07ProtocolProvidedCCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S07ProtocolProvidedCCW.release", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t4Component.getS07ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS07ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S07ProtocolProvidedCCW getS07ProtocolProvidedCCW() {
		return s07ProtocolProvidedCCW;
	}
	
	public class S07ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCanGo() {
			return t4Component.getS07ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t4Component.getS07ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t4Component.getS07ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t4Component.getS07ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t4Component.getS07ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS07ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S07ProtocolRequiredCCW getS07ProtocolRequiredCCW() {
		return s07ProtocolRequiredCCW;
	}
	
	public class S06ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
		@Override
		public void raiseCanGo() {
			messages.offer(new Event("S06ProtocolProvidedCCW.canGo", null));
		}
		@Override
		public void raiseReserve() {
			messages.offer(new Event("S06ProtocolProvidedCCW.reserve", null));
		}
		@Override
		public void raiseCannotGo() {
			messages.offer(new Event("S06ProtocolProvidedCCW.cannotGo", null));
		}
		@Override
		public void raiseRelease() {
			messages.offer(new Event("S06ProtocolProvidedCCW.release", null));
		}
		
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			t4Component.getS06ProtocolProvidedCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS06ProtocolProvidedCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S06ProtocolProvidedCCW getS06ProtocolProvidedCCW() {
		return s06ProtocolProvidedCCW;
	}
	
	public class S06ProtocolRequiredCCW implements ProtocolInterface.Required {
		
		
		@Override
		public boolean isRaisedCanGo() {
			return t4Component.getS06ProtocolRequiredCCW().isRaisedCanGo();
		}
		
		@Override
		public boolean isRaisedReserve() {
			return t4Component.getS06ProtocolRequiredCCW().isRaisedReserve();
		}
		
		@Override
		public boolean isRaisedCannotGo() {
			return t4Component.getS06ProtocolRequiredCCW().isRaisedCannotGo();
		}
		
		@Override
		public boolean isRaisedRelease() {
			return t4Component.getS06ProtocolRequiredCCW().isRaisedRelease();
		}
		
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			t4Component.getS06ProtocolRequiredCCW().registerListener(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS06ProtocolRequiredCCW().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S06ProtocolRequiredCCW getS06ProtocolRequiredCCW() {
		return s06ProtocolRequiredCCW;
	}
	
	public class S01ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S01ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS01ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t4Component.getS01ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS01ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t4Component.getS01ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t4Component.getS01ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS01ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S01ControlProvided getS01ControlProvided() {
		return s01ControlProvided;
	}
	
	public class T4TurnoutProvided implements TurnoutInterface.Provided {
		
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T4TurnoutProvided.turnoutStraight", null));
		}
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T4TurnoutProvided.turnoutDivergent", null));
		}
		
		
		@Override
		public void registerListener(TurnoutInterface.Listener.Provided listener) {
			t4Component.getT4TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getT4TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T4TurnoutProvided getT4TurnoutProvided() {
		return t4TurnoutProvided;
	}
	
	public class S04ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S04ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS04ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t4Component.getS04ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS04ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t4Component.getS04ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t4Component.getS04ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS04ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S04ControlProvided getS04ControlProvided() {
		return s04ControlProvided;
	}
	
	public class S05ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S05ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS05ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t4Component.getS05ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS05ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t4Component.getS05ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t4Component.getS05ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS05ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S05ControlProvided getS05ControlProvided() {
		return s05ControlProvided;
	}
	
	public class S06ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S06ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS06ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t4Component.getS06ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS06ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t4Component.getS06ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t4Component.getS06ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS06ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S06ControlProvided getS06ControlProvided() {
		return s06ControlProvided;
	}
	
	public class S07ControlProvided implements ControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S07ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS07ControlProvided().isRaisedEnableSection();
		}
		@Override
		public long getEnableSectionValue() {
			return t4Component.getS07ControlProvided().getEnableSectionValue();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS07ControlProvided().isRaisedDisableSection();
		}
		@Override
		public long getDisableSectionValue() {
			return t4Component.getS07ControlProvided().getDisableSectionValue();
		}
		
		@Override
		public void registerListener(ControlInterface.Listener.Provided listener) {
			t4Component.getS07ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS07ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S07ControlProvided getS07ControlProvided() {
		return s07ControlProvided;
	}
	
	public class S01TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S01TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S01TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t4Component.getS01TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS01TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S01TrainRequired getS01TrainRequired() {
		return s01TrainRequired;
	}
	
	public class T4TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T4TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T4TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t4Component.getT4TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getT4TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T4TrainRequired getT4TrainRequired() {
		return t4TrainRequired;
	}
	
	public class S04TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S04TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S04TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t4Component.getS04TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS04TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S04TrainRequired getS04TrainRequired() {
		return s04TrainRequired;
	}
	
	public class S05TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S05TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S05TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t4Component.getS05TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS05TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S05TrainRequired getS05TrainRequired() {
		return s05TrainRequired;
	}
	
	public class S06TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S06TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S06TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t4Component.getS06TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS06TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S06TrainRequired getS06TrainRequired() {
		return s06TrainRequired;
	}
	
	public class S07TrainRequired implements TrainInterface.Required {
		
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S07TrainRequired.occupy", null));
		}
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S07TrainRequired.unoccupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			t4Component.getS07TrainRequired().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return t4Component.getS07TrainRequired().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S07TrainRequired getS07TrainRequired() {
		return s07TrainRequired;
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
			case "S01ProtocolProvidedCW.canGo":
				t4Component.getS01ProtocolProvidedCW().raiseCanGo();
			break;
			case "S01ProtocolProvidedCW.reserve":
				t4Component.getS01ProtocolProvidedCW().raiseReserve();
			break;
			case "S01ProtocolProvidedCW.cannotGo":
				t4Component.getS01ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S01ProtocolProvidedCW.release":
				t4Component.getS01ProtocolProvidedCW().raiseRelease();
			break;
			case "S07ProtocolProvidedCCW.canGo":
				t4Component.getS07ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S07ProtocolProvidedCCW.reserve":
				t4Component.getS07ProtocolProvidedCCW().raiseReserve();
			break;
			case "S07ProtocolProvidedCCW.cannotGo":
				t4Component.getS07ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S07ProtocolProvidedCCW.release":
				t4Component.getS07ProtocolProvidedCCW().raiseRelease();
			break;
			case "S06ProtocolProvidedCCW.canGo":
				t4Component.getS06ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S06ProtocolProvidedCCW.reserve":
				t4Component.getS06ProtocolProvidedCCW().raiseReserve();
			break;
			case "S06ProtocolProvidedCCW.cannotGo":
				t4Component.getS06ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S06ProtocolProvidedCCW.release":
				t4Component.getS06ProtocolProvidedCCW().raiseRelease();
			break;
			case "S01ControlProvided.restartProtocol":
				t4Component.getS01ControlProvided().raiseRestartProtocol();
			break;
			case "T4TurnoutProvided.turnoutStraight":
				t4Component.getT4TurnoutProvided().raiseTurnoutStraight();
			break;
			case "T4TurnoutProvided.turnoutDivergent":
				t4Component.getT4TurnoutProvided().raiseTurnoutDivergent();
			break;
			case "S04ControlProvided.restartProtocol":
				t4Component.getS04ControlProvided().raiseRestartProtocol();
			break;
			case "S05ControlProvided.restartProtocol":
				t4Component.getS05ControlProvided().raiseRestartProtocol();
			break;
			case "S06ControlProvided.restartProtocol":
				t4Component.getS06ControlProvided().raiseRestartProtocol();
			break;
			case "S07ControlProvided.restartProtocol":
				t4Component.getS07ControlProvided().raiseRestartProtocol();
			break;
			case "S01TrainRequired.occupy":
				t4Component.getS01TrainRequired().raiseOccupy();
			break;
			case "S01TrainRequired.unoccupy":
				t4Component.getS01TrainRequired().raiseUnoccupy();
			break;
			case "T4TrainRequired.occupy":
				t4Component.getT4TrainRequired().raiseOccupy();
			break;
			case "T4TrainRequired.unoccupy":
				t4Component.getT4TrainRequired().raiseUnoccupy();
			break;
			case "S04TrainRequired.occupy":
				t4Component.getS04TrainRequired().raiseOccupy();
			break;
			case "S04TrainRequired.unoccupy":
				t4Component.getS04TrainRequired().raiseUnoccupy();
			break;
			case "S05TrainRequired.occupy":
				t4Component.getS05TrainRequired().raiseOccupy();
			break;
			case "S05TrainRequired.unoccupy":
				t4Component.getS05TrainRequired().raiseUnoccupy();
			break;
			case "S06TrainRequired.occupy":
				t4Component.getS06TrainRequired().raiseOccupy();
			break;
			case "S06TrainRequired.unoccupy":
				t4Component.getS06TrainRequired().raiseUnoccupy();
			break;
			case "S07TrainRequired.occupy":
				t4Component.getS07TrainRequired().raiseOccupy();
			break;
			case "S07TrainRequired.unoccupy":
				t4Component.getS07TrainRequired().raiseUnoccupy();
			break;
			default:
				throw new IllegalArgumentException("No such event!");
		}
	}
	
	private void performControlActions(Event event) {
		String[] eventName = event.getEvent().split("\\.");
		// Any trigger
		t4Component.runFullCycle();
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
	
	public T4Component getT4Component() {
		return t4Component;
	}
	
	
}
