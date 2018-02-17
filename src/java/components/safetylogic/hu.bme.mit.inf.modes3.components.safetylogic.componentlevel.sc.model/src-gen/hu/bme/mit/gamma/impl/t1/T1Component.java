	package hu.bme.mit.gamma.impl.t1;

	import java.util.List;
	import org.yakindu.scr.ITimer;
	
	import hu.bme.mit.gamma.impl.interfaces.*;
	import hu.bme.mit.gamma.impl.section.*;
	import hu.bme.mit.gamma.impl.turnout.*;
	
	public class T1Component implements T1ComponentInterface {			
		// Component instances
		private SectionStatechart S15 = new SectionStatechart();
		private TurnoutStatechart T1 = new TurnoutStatechart();
		private SectionStatechart S12 = new SectionStatechart();
		// Port instances
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
		
		public T1Component() {
			init();
		}
		
		/** Enters the contained statemachines recursively. Should be used only be the container (composite system) class. */
		public void enter() {
			S15.enter();
			T1.enter();
			S12.enter();
		}
		
		/** Creates the channel mappings and enters the wrapped statemachines. */
		private void init() {
			// Registration of simple channels
			T1.getProtocolProvidedStraight().registerListener(S12.getProtocolRequiredCW());
			S12.getProtocolRequiredCW().registerListener(T1.getProtocolProvidedStraight());
			S12.getProtocolProvidedCW().registerListener(T1.getProtocolRequiredStraight());
			T1.getProtocolRequiredStraight().registerListener(S12.getProtocolProvidedCW());
			T1.getProtocolProvidedTop().registerListener(S15.getProtocolRequiredCCW());
			S15.getProtocolRequiredCCW().registerListener(T1.getProtocolProvidedTop());
			S15.getProtocolProvidedCCW().registerListener(T1.getProtocolRequiredTop());
			T1.getProtocolRequiredTop().registerListener(S15.getProtocolProvidedCCW());
			// Registration of broadcast channels
			enter();
		}
		
		// Inner classes representing Ports
		public class T1ProtocolProvidedDivergent implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCanGo() {
				T1.getProtocolProvidedDivergent().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				T1.getProtocolProvidedDivergent().raiseCannotGo();
			}
			
			@Override
			public void raiseRelease() {
				T1.getProtocolProvidedDivergent().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				T1.getProtocolProvidedDivergent().raiseReserve();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				T1.getProtocolProvidedDivergent().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return T1.getProtocolProvidedDivergent().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T1ProtocolProvidedDivergent getT1ProtocolProvidedDivergent() {
			return t1ProtocolProvidedDivergent;
		}
		
		public class T1ProtocolRequiredDivergent implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCanGo() {
				return T1.getProtocolRequiredDivergent().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return T1.getProtocolRequiredDivergent().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return T1.getProtocolRequiredDivergent().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return T1.getProtocolRequiredDivergent().isRaisedReserve();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				T1.getProtocolRequiredDivergent().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return T1.getProtocolRequiredDivergent().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T1ProtocolRequiredDivergent getT1ProtocolRequiredDivergent() {
			return t1ProtocolRequiredDivergent;
		}
		
		public class S15ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCanGo() {
				S15.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				S15.getProtocolProvidedCW().raiseCannotGo();
			}
			
			@Override
			public void raiseRelease() {
				S15.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S15.getProtocolProvidedCW().raiseReserve();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S15.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S15.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S15ProtocolProvidedCW getS15ProtocolProvidedCW() {
			return s15ProtocolProvidedCW;
		}
		
		public class S15ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCanGo() {
				return S15.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S15.getProtocolRequiredCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S15.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S15.getProtocolRequiredCW().isRaisedReserve();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S15.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S15.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S15ProtocolRequiredCW getS15ProtocolRequiredCW() {
			return s15ProtocolRequiredCW;
		}
		
		public class S12ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCanGo() {
				S12.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				S12.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			@Override
			public void raiseRelease() {
				S12.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S12.getProtocolProvidedCCW().raiseReserve();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S12.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S12.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S12ProtocolProvidedCCW getS12ProtocolProvidedCCW() {
			return s12ProtocolProvidedCCW;
		}
		
		public class S12ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCanGo() {
				return S12.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S12.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S12.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S12.getProtocolRequiredCCW().isRaisedReserve();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S12.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S12.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S12ProtocolRequiredCCW getS12ProtocolRequiredCCW() {
			return s12ProtocolRequiredCCW;
		}
		
		public class S15ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S15.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S15.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S15.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S15.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S15.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S15ControlProvided getS15ControlProvided() {
			return s15ControlProvided;
		}
		
		public class T1TurnoutProvided implements TurnoutControlInterface.Provided {
		
			@Override
			public void raiseTurnoutStraight() {
				T1.getTurnoutControlProvided().raiseTurnoutStraight();
			}
			
			@Override
			public void raiseTurnoutDivergent() {
				T1.getTurnoutControlProvided().raiseTurnoutDivergent();
			}
			
			
			@Override
			public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
				T1.getTurnoutControlProvided().registerListener(listener);
			}
			
			@Override
			public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
				return T1.getTurnoutControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T1TurnoutProvided getT1TurnoutProvided() {
			return t1TurnoutProvided;
		}
		
		public class S12ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S12.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S12.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S12.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S12.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S12.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S12ControlProvided getS12ControlProvided() {
			return s12ControlProvided;
		}
		
		public class S15TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				S15.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S15.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S15.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S15.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S15TrainProvided getS15TrainProvided() {
			return s15TrainProvided;
		}
		
		public class T1TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				T1.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				T1.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				T1.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return T1.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T1TrainProvided getT1TrainProvided() {
			return t1TrainProvided;
		}
		
		public class S12TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				S12.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S12.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S12.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S12.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S12TrainProvided getS12TrainProvided() {
			return s12TrainProvided;
		}
		
		/** Changes the event and process queues of all component instances. Should be used only be the container (composite system) class. */
		public void changeEventQueues() {
			S15.changeEventQueues();
			T1.changeEventQueues();
			S12.changeEventQueues();
		}
		
		/** Returns whether all event queues of the contained component instances are empty. 
		Should be used only be the container (composite system) class. */
		public boolean isEventQueueEmpty() {
			return S15.isEventQueueEmpty() && T1.isEventQueueEmpty() && S12.isEventQueueEmpty();
		}
		
		/** Initiates cycle runs until all event queues of component instances are empty. */
		@Override
		public void runFullCycle() {
			do {
				runCycle();
			}
			while (!isEventQueueEmpty());
		}
		
		/** Changes event queues and initiates a cycle run.
			This should be the execution point from an asynchronous component. */
		@Override
		public void runCycle() {
			// Changing the insert and process queues for all synchronous subcomponents
			changeEventQueues();
			// Composite type-dependent behavior
			runComponent();
		}
		
		/** Initiates a cycle run without changing the event queues.
		 * Should be used only be the container (composite system) class. */
		public void runComponent() {
			S15.runComponent();
			T1.runComponent();
			S12.runComponent();
		}

		/** Setter for the timer e.g., a virtual timer. */
		public void setTimer(ITimer timer) {
			S15.setTimer(timer);
			S12.setTimer(timer);
		}
		
		/**  Getter for component instances, e.g. enabling to check their states. */
		public SectionStatechart getS15() {
			return S15;
		}
		
		public TurnoutStatechart getT1() {
			return T1;
		}
		
		public SectionStatechart getS12() {
			return S12;
		}
		
	}
