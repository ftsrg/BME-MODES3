	package hu.bme.mit.gamma.impl.t6;

	import java.util.List;
	import org.yakindu.scr.ITimer;
	
	import hu.bme.mit.gamma.impl.interfaces.*;
	import hu.bme.mit.gamma.impl.section.*;
	import hu.bme.mit.gamma.impl.turnout.*;
	
	public class T6Component implements T6ComponentInterface {			
		// Component instances
		private SectionStatechart S17 = new SectionStatechart();
		private TurnoutStatechart T6 = new TurnoutStatechart();
		private SectionStatechart S22 = new SectionStatechart();
		private SectionStatechart S23 = new SectionStatechart();
		private SectionStatechart S27 = new SectionStatechart();
		// Port instances
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
		
		public T6Component() {
			init();
		}
		
		/** Enters the contained statemachines recursively. Should be used only be the container (composite system) class. */
		public void enter() {
			S17.enter();
			T6.enter();
			S22.enter();
			S23.enter();
			S27.enter();
		}
		
		/** Creates the channel mappings and enters the wrapped statemachines. */
		private void init() {
			// Registration of simple channels
			T6.getProtocolProvidedStraight().registerListener(S23.getProtocolRequiredCCW());
			S23.getProtocolRequiredCCW().registerListener(T6.getProtocolProvidedStraight());
			T6.getProtocolProvidedTop().registerListener(S17.getProtocolRequiredCW());
			S17.getProtocolRequiredCW().registerListener(T6.getProtocolProvidedTop());
			S17.getProtocolProvidedCW().registerListener(T6.getProtocolRequiredTop());
			T6.getProtocolRequiredTop().registerListener(S17.getProtocolProvidedCW());
			S27.getProtocolProvidedCCW().registerListener(S23.getProtocolRequiredCW());
			S23.getProtocolRequiredCW().registerListener(S27.getProtocolProvidedCCW());
			S22.getProtocolProvidedCCW().registerListener(T6.getProtocolRequiredDivergent());
			T6.getProtocolRequiredDivergent().registerListener(S22.getProtocolProvidedCCW());
			S23.getProtocolProvidedCW().registerListener(S27.getProtocolRequiredCCW());
			S27.getProtocolRequiredCCW().registerListener(S23.getProtocolProvidedCW());
			T6.getProtocolProvidedDivergent().registerListener(S22.getProtocolRequiredCCW());
			S22.getProtocolRequiredCCW().registerListener(T6.getProtocolProvidedDivergent());
			S23.getProtocolProvidedCCW().registerListener(T6.getProtocolRequiredStraight());
			T6.getProtocolRequiredStraight().registerListener(S23.getProtocolProvidedCCW());
			// Registration of broadcast channels
			enter();
		}
		
		// Inner classes representing Ports
		public class S17ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S17.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseCanGo() {
				S17.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseReserve() {
				S17.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCannotGo() {
				S17.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S17.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S17.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S17ProtocolProvidedCCW getS17ProtocolProvidedCCW() {
			return s17ProtocolProvidedCCW;
		}
		
		public class S17ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S17.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S17.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedReserve() {
				return S17.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S17.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S17.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S17.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S17ProtocolRequiredCCW getS17ProtocolRequiredCCW() {
			return s17ProtocolRequiredCCW;
		}
		
		public class S22ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S22.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseCanGo() {
				S22.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseReserve() {
				S22.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCannotGo() {
				S22.getProtocolProvidedCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S22.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S22.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S22ProtocolProvidedCW getS22ProtocolProvidedCW() {
			return s22ProtocolProvidedCW;
		}
		
		public class S22ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S22.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S22.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedReserve() {
				return S22.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S22.getProtocolRequiredCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S22.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S22.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S22ProtocolRequiredCW getS22ProtocolRequiredCW() {
			return s22ProtocolRequiredCW;
		}
		
		public class S27ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S27.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseCanGo() {
				S27.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseReserve() {
				S27.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCannotGo() {
				S27.getProtocolProvidedCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S27.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S27.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S27ProtocolProvidedCW getS27ProtocolProvidedCW() {
			return s27ProtocolProvidedCW;
		}
		
		public class S27ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S27.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S27.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedReserve() {
				return S27.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S27.getProtocolRequiredCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S27.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S27.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S27ProtocolRequiredCW getS27ProtocolRequiredCW() {
			return s27ProtocolRequiredCW;
		}
		
		public class S17ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S17.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S17.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S17.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S17.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S17.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S17ControlProvided getS17ControlProvided() {
			return s17ControlProvided;
		}
		
		public class T6TurnoutProvided implements TurnoutControlInterface.Provided {
		
			@Override
			public void raiseTurnoutStraight() {
				T6.getTurnoutControlProvided().raiseTurnoutStraight();
			}
			
			@Override
			public void raiseTurnoutDivergent() {
				T6.getTurnoutControlProvided().raiseTurnoutDivergent();
			}
			
			
			@Override
			public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
				T6.getTurnoutControlProvided().registerListener(listener);
			}
			
			@Override
			public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
				return T6.getTurnoutControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T6TurnoutProvided getT6TurnoutProvided() {
			return t6TurnoutProvided;
		}
		
		public class S22ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S22.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S22.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S22.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S22.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S22.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S22ControlProvided getS22ControlProvided() {
			return s22ControlProvided;
		}
		
		public class S23ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S23.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S23.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S23.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S23.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S23.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S23ControlProvided getS23ControlProvided() {
			return s23ControlProvided;
		}
		
		public class S27ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S27.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S27.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S27.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S27.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S27.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S27ControlProvided getS27ControlProvided() {
			return s27ControlProvided;
		}
		
		public class S17TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S17.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S17.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S17.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S17.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S17TrainProvided getS17TrainProvided() {
			return s17TrainProvided;
		}
		
		public class T6TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				T6.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T6.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				T6.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return T6.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T6TrainProvided getT6TrainProvided() {
			return t6TrainProvided;
		}
		
		public class S22TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S22.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S22.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S22.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S22.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S22TrainProvided getS22TrainProvided() {
			return s22TrainProvided;
		}
		
		public class S23TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S23.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S23.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S23.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S23.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S23TrainProvided getS23TrainProvided() {
			return s23TrainProvided;
		}
		
		public class S27TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S27.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S27.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S27.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S27.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S27TrainProvided getS27TrainProvided() {
			return s27TrainProvided;
		}
		
		/** Changes the event and process queues of all component instances. Should be used only be the container (composite system) class. */
		public void changeEventQueues() {
			S17.changeEventQueues();
			T6.changeEventQueues();
			S22.changeEventQueues();
			S23.changeEventQueues();
			S27.changeEventQueues();
		}
		
		/** Returns whether all event queues of the contained component instances are empty. 
		Should be used only be the container (composite system) class. */
		public boolean isEventQueueEmpty() {
			return S17.isEventQueueEmpty() && T6.isEventQueueEmpty() && S22.isEventQueueEmpty() && S23.isEventQueueEmpty() && S27.isEventQueueEmpty();
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
			S17.runComponent();
			T6.runComponent();
			S22.runComponent();
			S23.runComponent();
			S27.runComponent();
		}

		/** Setter for the timer e.g., a virtual timer. */
		public void setTimer(ITimer timer) {
			S17.setTimer(timer);
			S22.setTimer(timer);
			S23.setTimer(timer);
			S27.setTimer(timer);
		}
		
		/**  Getter for component instances, e.g. enabling to check their states. */
		public SectionStatechart getS17() {
			return S17;
		}
		
		public TurnoutStatechart getT6() {
			return T6;
		}
		
		public SectionStatechart getS22() {
			return S22;
		}
		
		public SectionStatechart getS23() {
			return S23;
		}
		
		public SectionStatechart getS27() {
			return S27;
		}
		
	}
