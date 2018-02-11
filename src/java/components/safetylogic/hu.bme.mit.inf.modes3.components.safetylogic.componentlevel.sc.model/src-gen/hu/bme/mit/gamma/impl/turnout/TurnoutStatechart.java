package hu.bme.mit.gamma.impl.turnout;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

import hu.bme.mit.gamma.impl.event.*;
import hu.bme.mit.gamma.impl.interfaces.*;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCIProtocolRequiredDivergentListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCIProtocolRequiredTopListener;
import org.yakindu.scr.turnout.ITurnoutStatemachine.SCIProtocolRequiredStraightListener;
import org.yakindu.scr.turnout.TurnoutStatemachine;
import org.yakindu.scr.turnout.TurnoutStatemachine.State;

public class TurnoutStatechart implements TurnoutStatechartInterface {
	// The wrapped Yakindu statemachine
	private TurnoutStatemachine turnoutStatemachine = new TurnoutStatemachine();
	// Port instances
	private ProtocolProvidedTop protocolProvidedTop = new ProtocolProvidedTop();
	private TrainRequired trainRequired = new TrainRequired();
	private ProtocolRequiredDivergent protocolRequiredDivergent = new ProtocolRequiredDivergent();
	private ProtocolProvidedStraight protocolProvidedStraight = new ProtocolProvidedStraight();
	private Turnout turnout = new Turnout();
	private ProtocolRequiredTop protocolRequiredTop = new ProtocolRequiredTop();
	private ProtocolRequiredStraight protocolRequiredStraight = new ProtocolRequiredStraight();
	private ProtocolProvidedDivergent protocolProvidedDivergent = new ProtocolProvidedDivergent();
	// Indicates which queues are active in this cycle
	private boolean insertQueue = true;
	private boolean processQueue = false;
	// Event queues for the synchronization of statecharts
	private Queue<Event> eventQueue1 = new LinkedList<Event>();
	private Queue<Event> eventQueue2 = new LinkedList<Event>();
	
	public TurnoutStatechart() {
		// Initializing and entering the wrapped statemachine
		turnoutStatemachine.init();
		turnoutStatemachine.enter();
	}
	
	/** Enters the statemachine. Should be used only be the container (composite system) class. */
	public void enter() {
		turnoutStatemachine.enter();
	}
	
	/** Changes the event queues of the component instance. Should be used only be the container (composite system) class. */
	public void changeEventQueues() {
		insertQueue = !insertQueue;
		processQueue = !processQueue;
	}
	
	/** Changes the event queues to which the events are put. Should be used only be a cascade container (composite system) class. */
	public void changeInsertQueue() {
	    insertQueue = !insertQueue;
	}
	
	/** Returns whether the eventQueue containing incoming messages is empty. Should be used only be the container (composite system) class. */
	public boolean isEventQueueEmpty() {
		return getInsertQueue().isEmpty();
	}
	
	/** Returns the event queue into which events should be put in the particular cycle. */
	private Queue<Event> getInsertQueue() {
		if (insertQueue) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	/** Returns the event queue from which events should be inspected in the particular cycle. */
	private Queue<Event> getProcessQueue() {
		if (processQueue) {
			return eventQueue1;
		}
		return eventQueue2;
	}
	
	/** Changes event queues and initiating a cycle run. */
	@Override
	public void runCycle() {
		changeEventQueues();
		runComponent();
	}
	
	/** Changes the insert queue and initiates a run. */
	public void runAndRechangeInsertQueue() {
		// First the insert queue is changed back, so self-event sending can work
	    changeInsertQueue();
	    runComponent();
	}
	
	/** Initiates a cycle run without changing the event queues. It is needed if this component is contained (wrapped) by another component.
	Should be used only be the container (composite system) class. */
	public void runComponent() {
		Queue<Event> eventQueue = getProcessQueue();
		while (!eventQueue.isEmpty()) {
				Event event = eventQueue.remove();
				switch (event.getEvent()) {
					case "ProtocolProvidedTop.Release": 
						turnoutStatemachine.getSCIProtocolProvidedTop().raiseRelease();
					break;
					case "ProtocolProvidedTop.Reserve": 
						turnoutStatemachine.getSCIProtocolProvidedTop().raiseReserve();
					break;
					case "ProtocolProvidedTop.CanGo": 
						turnoutStatemachine.getSCIProtocolProvidedTop().raiseCanGo();
					break;
					case "ProtocolProvidedTop.CannotGo": 
						turnoutStatemachine.getSCIProtocolProvidedTop().raiseCannotGo();
					break;
					case "TrainRequired.Occupy": 
						turnoutStatemachine.getSCITrainRequired().raiseOccupy();
					break;
					case "TrainRequired.Unoccupy": 
						turnoutStatemachine.getSCITrainRequired().raiseUnoccupy();
					break;
					case "ProtocolProvidedStraight.Release": 
						turnoutStatemachine.getSCIProtocolProvidedStraight().raiseRelease();
					break;
					case "ProtocolProvidedStraight.Reserve": 
						turnoutStatemachine.getSCIProtocolProvidedStraight().raiseReserve();
					break;
					case "ProtocolProvidedStraight.CanGo": 
						turnoutStatemachine.getSCIProtocolProvidedStraight().raiseCanGo();
					break;
					case "ProtocolProvidedStraight.CannotGo": 
						turnoutStatemachine.getSCIProtocolProvidedStraight().raiseCannotGo();
					break;
					case "Turnout.TurnoutDivergent": 
						turnoutStatemachine.getSCITurnout().raiseTurnoutDivergent();
					break;
					case "Turnout.TurnoutStraight": 
						turnoutStatemachine.getSCITurnout().raiseTurnoutStraight();
					break;
					case "ProtocolProvidedDivergent.Release": 
						turnoutStatemachine.getSCIProtocolProvidedDivergent().raiseRelease();
					break;
					case "ProtocolProvidedDivergent.Reserve": 
						turnoutStatemachine.getSCIProtocolProvidedDivergent().raiseReserve();
					break;
					case "ProtocolProvidedDivergent.CanGo": 
						turnoutStatemachine.getSCIProtocolProvidedDivergent().raiseCanGo();
					break;
					case "ProtocolProvidedDivergent.CannotGo": 
						turnoutStatemachine.getSCIProtocolProvidedDivergent().raiseCannotGo();
					break;
					default:
						throw new IllegalArgumentException("No such event!");
				}
		}
		turnoutStatemachine.runCycle();
	}    		
	
	// Inner classes representing Ports
	public class ProtocolProvidedTop implements ProtocolInterface.Provided {
		private List<ProtocolInterface.Listener.Provided> registeredListeners = new LinkedList<ProtocolInterface.Listener.Provided>();

		@Override
		public void raiseRelease() {
			getInsertQueue().add(new Event("ProtocolProvidedTop.Release", null));
		}
		
		@Override
		public void raiseReserve() {
			getInsertQueue().add(new Event("ProtocolProvidedTop.Reserve", null));
		}
		
		@Override
		public void raiseCanGo() {
			getInsertQueue().add(new Event("ProtocolProvidedTop.CanGo", null));
		}
		
		@Override
		public void raiseCannotGo() {
			getInsertQueue().add(new Event("ProtocolProvidedTop.CannotGo", null));
		}

		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolProvidedTop getProtocolProvidedTop() {
		return protocolProvidedTop;
	}
	
	public class TrainRequired implements TrainInterface.Required {
		private List<TrainInterface.Listener.Required> registeredListeners = new LinkedList<TrainInterface.Listener.Required>();

		@Override
		public void raiseOccupy() {
			getInsertQueue().add(new Event("TrainRequired.Occupy", null));
		}
		
		@Override
		public void raiseUnoccupy() {
			getInsertQueue().add(new Event("TrainRequired.Unoccupy", null));
		}

		@Override
		public void registerListener(TrainInterface.Listener.Required listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<TrainInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public TrainRequired getTrainRequired() {
		return trainRequired;
	}
	
	public class ProtocolRequiredDivergent implements ProtocolInterface.Required {
		private List<ProtocolInterface.Listener.Required> registeredListeners = new LinkedList<ProtocolInterface.Listener.Required>();


		@Override
		public boolean isRaisedRelease() {
			return turnoutStatemachine.getSCIProtocolRequiredDivergent().isRaisedRelease();
		}
		@Override
		public boolean isRaisedReserve() {
			return turnoutStatemachine.getSCIProtocolRequiredDivergent().isRaisedReserve();
		}
		@Override
		public boolean isRaisedCanGo() {
			return turnoutStatemachine.getSCIProtocolRequiredDivergent().isRaisedCanGo();
		}
		@Override
		public boolean isRaisedCannotGo() {
			return turnoutStatemachine.getSCIProtocolRequiredDivergent().isRaisedCannotGo();
		}
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			registeredListeners.add(listener);
			//turnoutStatemachine.getSCIProtocolRequiredDivergent().getListeners().clear();
			turnoutStatemachine.getSCIProtocolRequiredDivergent().getListeners().add(new SCIProtocolRequiredDivergentListener() {
				@Override
				public void onReleaseRaised() {
					listener.raiseRelease();
				}
				
				@Override
				public void onReserveRaised() {
					listener.raiseReserve();
				}
				
				@Override
				public void onCanGoRaised() {
					listener.raiseCanGo();
				}
				
				@Override
				public void onCannotGoRaised() {
					listener.raiseCannotGo();
				}
			});
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolRequiredDivergent getProtocolRequiredDivergent() {
		return protocolRequiredDivergent;
	}
	
	public class ProtocolProvidedStraight implements ProtocolInterface.Provided {
		private List<ProtocolInterface.Listener.Provided> registeredListeners = new LinkedList<ProtocolInterface.Listener.Provided>();

		@Override
		public void raiseRelease() {
			getInsertQueue().add(new Event("ProtocolProvidedStraight.Release", null));
		}
		
		@Override
		public void raiseReserve() {
			getInsertQueue().add(new Event("ProtocolProvidedStraight.Reserve", null));
		}
		
		@Override
		public void raiseCanGo() {
			getInsertQueue().add(new Event("ProtocolProvidedStraight.CanGo", null));
		}
		
		@Override
		public void raiseCannotGo() {
			getInsertQueue().add(new Event("ProtocolProvidedStraight.CannotGo", null));
		}

		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolProvidedStraight getProtocolProvidedStraight() {
		return protocolProvidedStraight;
	}
	
	public class Turnout implements TurnoutInterface.Provided {
		private List<TurnoutInterface.Listener.Provided> registeredListeners = new LinkedList<TurnoutInterface.Listener.Provided>();

		@Override
		public void raiseTurnoutDivergent() {
			getInsertQueue().add(new Event("Turnout.TurnoutDivergent", null));
		}
		
		@Override
		public void raiseTurnoutStraight() {
			getInsertQueue().add(new Event("Turnout.TurnoutStraight", null));
		}

		@Override
		public void registerListener(TurnoutInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public Turnout getTurnout() {
		return turnout;
	}
	
	public class ProtocolRequiredTop implements ProtocolInterface.Required {
		private List<ProtocolInterface.Listener.Required> registeredListeners = new LinkedList<ProtocolInterface.Listener.Required>();


		@Override
		public boolean isRaisedRelease() {
			return turnoutStatemachine.getSCIProtocolRequiredTop().isRaisedRelease();
		}
		@Override
		public boolean isRaisedReserve() {
			return turnoutStatemachine.getSCIProtocolRequiredTop().isRaisedReserve();
		}
		@Override
		public boolean isRaisedCanGo() {
			return turnoutStatemachine.getSCIProtocolRequiredTop().isRaisedCanGo();
		}
		@Override
		public boolean isRaisedCannotGo() {
			return turnoutStatemachine.getSCIProtocolRequiredTop().isRaisedCannotGo();
		}
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			registeredListeners.add(listener);
			//turnoutStatemachine.getSCIProtocolRequiredTop().getListeners().clear();
			turnoutStatemachine.getSCIProtocolRequiredTop().getListeners().add(new SCIProtocolRequiredTopListener() {
				@Override
				public void onReleaseRaised() {
					listener.raiseRelease();
				}
				
				@Override
				public void onReserveRaised() {
					listener.raiseReserve();
				}
				
				@Override
				public void onCanGoRaised() {
					listener.raiseCanGo();
				}
				
				@Override
				public void onCannotGoRaised() {
					listener.raiseCannotGo();
				}
			});
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolRequiredTop getProtocolRequiredTop() {
		return protocolRequiredTop;
	}
	
	public class ProtocolRequiredStraight implements ProtocolInterface.Required {
		private List<ProtocolInterface.Listener.Required> registeredListeners = new LinkedList<ProtocolInterface.Listener.Required>();


		@Override
		public boolean isRaisedRelease() {
			return turnoutStatemachine.getSCIProtocolRequiredStraight().isRaisedRelease();
		}
		@Override
		public boolean isRaisedReserve() {
			return turnoutStatemachine.getSCIProtocolRequiredStraight().isRaisedReserve();
		}
		@Override
		public boolean isRaisedCanGo() {
			return turnoutStatemachine.getSCIProtocolRequiredStraight().isRaisedCanGo();
		}
		@Override
		public boolean isRaisedCannotGo() {
			return turnoutStatemachine.getSCIProtocolRequiredStraight().isRaisedCannotGo();
		}
		@Override
		public void registerListener(ProtocolInterface.Listener.Required listener) {
			registeredListeners.add(listener);
			//turnoutStatemachine.getSCIProtocolRequiredStraight().getListeners().clear();
			turnoutStatemachine.getSCIProtocolRequiredStraight().getListeners().add(new SCIProtocolRequiredStraightListener() {
				@Override
				public void onReleaseRaised() {
					listener.raiseRelease();
				}
				
				@Override
				public void onReserveRaised() {
					listener.raiseReserve();
				}
				
				@Override
				public void onCanGoRaised() {
					listener.raiseCanGo();
				}
				
				@Override
				public void onCannotGoRaised() {
					listener.raiseCannotGo();
				}
			});
		}
		
		@Override
		public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolRequiredStraight getProtocolRequiredStraight() {
		return protocolRequiredStraight;
	}
	
	public class ProtocolProvidedDivergent implements ProtocolInterface.Provided {
		private List<ProtocolInterface.Listener.Provided> registeredListeners = new LinkedList<ProtocolInterface.Listener.Provided>();

		@Override
		public void raiseRelease() {
			getInsertQueue().add(new Event("ProtocolProvidedDivergent.Release", null));
		}
		
		@Override
		public void raiseReserve() {
			getInsertQueue().add(new Event("ProtocolProvidedDivergent.Reserve", null));
		}
		
		@Override
		public void raiseCanGo() {
			getInsertQueue().add(new Event("ProtocolProvidedDivergent.CanGo", null));
		}
		
		@Override
		public void raiseCannotGo() {
			getInsertQueue().add(new Event("ProtocolProvidedDivergent.CannotGo", null));
		}

		@Override
		public void registerListener(ProtocolInterface.Listener.Provided listener) {
			registeredListeners.add(listener);
		}
		
		@Override
		public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
			return registeredListeners;
		}

	}
	
	@Override
	public ProtocolProvidedDivergent getProtocolProvidedDivergent() {
		return protocolProvidedDivergent;
	}
	
	/** Checks whether the wrapped statemachine is in the given state. */
	public boolean isStateActive(State state) {
		return turnoutStatemachine.isStateActive(state);
	}
	
	
}
