package hu.bme.mit.gamma.impl.async_t4;

import java.util.Collections;
import java.util.List;

import lbmq.*;
import org.yakindu.scr.ITimer;

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
	private S02ControlProvided s02ControlProvided = new S02ControlProvided();
	private S04ControlProvided s04ControlProvided = new S04ControlProvided();
	private S05ControlProvided s05ControlProvided = new S05ControlProvided();
	private S06ControlProvided s06ControlProvided = new S06ControlProvided();
	private S07ControlProvided s07ControlProvided = new S07ControlProvided();
	private S01TrainProvided s01TrainProvided = new S01TrainProvided();
	private T4TrainProvided t4TrainProvided = new T4TrainProvided();
	private S02TrainProvided s02TrainProvided = new S02TrainProvided();
	private S04TrainProvided s04TrainProvided = new S04TrainProvided();
	private S05TrainProvided s05TrainProvided = new S05TrainProvided();
	private S06TrainProvided s06TrainProvided = new S06TrainProvided();
	private S07TrainProvided s07TrainProvided = new S07TrainProvided();
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
		public void raiseRelease() {
			messages.offer(new Event("S01ProtocolProvidedCW.release", null));
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
		public void raiseCanGo() {
			messages.offer(new Event("S01ProtocolProvidedCW.canGo", null));
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
		public boolean isRaisedRelease() {
			return t4Component.getS01ProtocolRequiredCW().isRaisedRelease();
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
		public boolean isRaisedCanGo() {
			return t4Component.getS01ProtocolRequiredCW().isRaisedCanGo();
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
		public void raiseRelease() {
			messages.offer(new Event("S07ProtocolProvidedCCW.release", null));
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
		public void raiseCanGo() {
			messages.offer(new Event("S07ProtocolProvidedCCW.canGo", null));
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
		public boolean isRaisedRelease() {
			return t4Component.getS07ProtocolRequiredCCW().isRaisedRelease();
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
		public boolean isRaisedCanGo() {
			return t4Component.getS07ProtocolRequiredCCW().isRaisedCanGo();
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
		public void raiseRelease() {
			messages.offer(new Event("S06ProtocolProvidedCCW.release", null));
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
		public void raiseCanGo() {
			messages.offer(new Event("S06ProtocolProvidedCCW.canGo", null));
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
		public boolean isRaisedRelease() {
			return t4Component.getS06ProtocolRequiredCCW().isRaisedRelease();
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
		public boolean isRaisedCanGo() {
			return t4Component.getS06ProtocolRequiredCCW().isRaisedCanGo();
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
	
	public class S01ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S01ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS01ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS01ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t4Component.getS01ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS01ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S01ControlProvided getS01ControlProvided() {
		return s01ControlProvided;
	}
	
	public class T4TurnoutProvided implements TurnoutControlInterface.Provided {
		
		@Override
		public void raiseTurnoutStraight() {
			messages.offer(new Event("T4TurnoutProvided.turnoutStraight", null));
		}
		@Override
		public void raiseTurnoutDivergent() {
			messages.offer(new Event("T4TurnoutProvided.turnoutDivergent", null));
		}
		
		
		@Override
		public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
			t4Component.getT4TurnoutProvided().registerListener(listener);
		}
		
		@Override
		public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getT4TurnoutProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T4TurnoutProvided getT4TurnoutProvided() {
		return t4TurnoutProvided;
	}
	
	public class S02ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S02ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS02ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS02ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t4Component.getS02ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS02ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S02ControlProvided getS02ControlProvided() {
		return s02ControlProvided;
	}
	
	public class S04ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S04ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS04ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS04ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t4Component.getS04ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS04ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S04ControlProvided getS04ControlProvided() {
		return s04ControlProvided;
	}
	
	public class S05ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S05ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS05ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS05ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t4Component.getS05ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS05ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S05ControlProvided getS05ControlProvided() {
		return s05ControlProvided;
	}
	
	public class S06ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S06ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS06ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS06ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t4Component.getS06ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS06ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S06ControlProvided getS06ControlProvided() {
		return s06ControlProvided;
	}
	
	public class S07ControlProvided implements SectionControlInterface.Provided {
		
		@Override
		public void raiseRestartProtocol() {
			messages.offer(new Event("S07ControlProvided.restartProtocol", null));
		}
		
		@Override
		public boolean isRaisedEnableSection() {
			return t4Component.getS07ControlProvided().isRaisedEnableSection();
		}
		
		@Override
		public boolean isRaisedDisableSection() {
			return t4Component.getS07ControlProvided().isRaisedDisableSection();
		}
		
		@Override
		public void registerListener(SectionControlInterface.Listener.Provided listener) {
			t4Component.getS07ControlProvided().registerListener(listener);
		}
		
		@Override
		public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS07ControlProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S07ControlProvided getS07ControlProvided() {
		return s07ControlProvided;
	}
	
	public class S01TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S01TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S01TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getS01TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS01TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S01TrainProvided getS01TrainProvided() {
		return s01TrainProvided;
	}
	
	public class T4TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("T4TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("T4TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getT4TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getT4TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public T4TrainProvided getT4TrainProvided() {
		return t4TrainProvided;
	}
	
	public class S02TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S02TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S02TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getS02TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS02TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S02TrainProvided getS02TrainProvided() {
		return s02TrainProvided;
	}
	
	public class S04TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S04TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S04TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getS04TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS04TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S04TrainProvided getS04TrainProvided() {
		return s04TrainProvided;
	}
	
	public class S05TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S05TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S05TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getS05TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS05TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S05TrainProvided getS05TrainProvided() {
		return s05TrainProvided;
	}
	
	public class S06TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S06TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S06TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getS06TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS06TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S06TrainProvided getS06TrainProvided() {
		return s06TrainProvided;
	}
	
	public class S07TrainProvided implements TrainInterface.Provided {
		
		@Override
		public void raiseUnoccupy() {
			messages.offer(new Event("S07TrainProvided.unoccupy", null));
		}
		@Override
		public void raiseOccupy() {
			messages.offer(new Event("S07TrainProvided.occupy", null));
		}
		
		
		@Override
		public void registerListener(TrainInterface.Listener.Provided listener) {
			t4Component.getS07TrainProvided().registerListener(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
			return t4Component.getS07TrainProvided().getRegisteredListeners();
		}
		
	}
	
	@Override
	public S07TrainProvided getS07TrainProvided() {
		return s07TrainProvided;
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
			case "S01ProtocolProvidedCW.release":
				t4Component.getS01ProtocolProvidedCW().raiseRelease();
			break;
			case "S01ProtocolProvidedCW.reserve":
				t4Component.getS01ProtocolProvidedCW().raiseReserve();
			break;
			case "S01ProtocolProvidedCW.cannotGo":
				t4Component.getS01ProtocolProvidedCW().raiseCannotGo();
			break;
			case "S01ProtocolProvidedCW.canGo":
				t4Component.getS01ProtocolProvidedCW().raiseCanGo();
			break;
			case "S07ProtocolProvidedCCW.release":
				t4Component.getS07ProtocolProvidedCCW().raiseRelease();
			break;
			case "S07ProtocolProvidedCCW.reserve":
				t4Component.getS07ProtocolProvidedCCW().raiseReserve();
			break;
			case "S07ProtocolProvidedCCW.cannotGo":
				t4Component.getS07ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S07ProtocolProvidedCCW.canGo":
				t4Component.getS07ProtocolProvidedCCW().raiseCanGo();
			break;
			case "S06ProtocolProvidedCCW.release":
				t4Component.getS06ProtocolProvidedCCW().raiseRelease();
			break;
			case "S06ProtocolProvidedCCW.reserve":
				t4Component.getS06ProtocolProvidedCCW().raiseReserve();
			break;
			case "S06ProtocolProvidedCCW.cannotGo":
				t4Component.getS06ProtocolProvidedCCW().raiseCannotGo();
			break;
			case "S06ProtocolProvidedCCW.canGo":
				t4Component.getS06ProtocolProvidedCCW().raiseCanGo();
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
			case "S02ControlProvided.restartProtocol":
				t4Component.getS02ControlProvided().raiseRestartProtocol();
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
			case "S01TrainProvided.unoccupy":
				t4Component.getS01TrainProvided().raiseUnoccupy();
			break;
			case "S01TrainProvided.occupy":
				t4Component.getS01TrainProvided().raiseOccupy();
			break;
			case "T4TrainProvided.unoccupy":
				t4Component.getT4TrainProvided().raiseUnoccupy();
			break;
			case "T4TrainProvided.occupy":
				t4Component.getT4TrainProvided().raiseOccupy();
			break;
			case "S02TrainProvided.unoccupy":
				t4Component.getS02TrainProvided().raiseUnoccupy();
			break;
			case "S02TrainProvided.occupy":
				t4Component.getS02TrainProvided().raiseOccupy();
			break;
			case "S04TrainProvided.unoccupy":
				t4Component.getS04TrainProvided().raiseUnoccupy();
			break;
			case "S04TrainProvided.occupy":
				t4Component.getS04TrainProvided().raiseOccupy();
			break;
			case "S05TrainProvided.unoccupy":
				t4Component.getS05TrainProvided().raiseUnoccupy();
			break;
			case "S05TrainProvided.occupy":
				t4Component.getS05TrainProvided().raiseOccupy();
			break;
			case "S06TrainProvided.unoccupy":
				t4Component.getS06TrainProvided().raiseUnoccupy();
			break;
			case "S06TrainProvided.occupy":
				t4Component.getS06TrainProvided().raiseOccupy();
			break;
			case "S07TrainProvided.unoccupy":
				t4Component.getS07TrainProvided().raiseUnoccupy();
			break;
			case "S07TrainProvided.occupy":
				t4Component.getS07TrainProvided().raiseOccupy();
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
	
	public void setTimer(ITimer timer) {
		t4Component.setTimer(timer);
	}
	
}
