	package hu.bme.mit.gamma.impl.t6;

	import java.util.List;
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
		private S17TrainRequired s17TrainRequired = new S17TrainRequired();
		private T6TrainRequired t6TrainRequired = new T6TrainRequired();
		private S22TrainRequired s22TrainRequired = new S22TrainRequired();
		private S23TrainRequired s23TrainRequired = new S23TrainRequired();
		private S27TrainRequired s27TrainRequired = new S27TrainRequired();
		
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
			S23.getProtocolProvidedCW().registerListener(S27.getProtocolRequiredCCW());
			S27.getProtocolRequiredCCW().registerListener(S23.getProtocolProvidedCW());
			S17.getProtocolProvidedCW().registerListener(T6.getProtocolRequiredTop());
			T6.getProtocolRequiredTop().registerListener(S17.getProtocolProvidedCW());
			T6.getProtocolProvidedTop().registerListener(S17.getProtocolRequiredCW());
			S17.getProtocolRequiredCW().registerListener(T6.getProtocolProvidedTop());
			T6.getProtocolProvidedDivergent().registerListener(S22.getProtocolRequiredCCW());
			S22.getProtocolRequiredCCW().registerListener(T6.getProtocolProvidedDivergent());
			S23.getProtocolProvidedCCW().registerListener(T6.getProtocolRequiredStraight());
			T6.getProtocolRequiredStraight().registerListener(S23.getProtocolProvidedCCW());
			T6.getProtocolProvidedStraight().registerListener(S23.getProtocolRequiredCCW());
			S23.getProtocolRequiredCCW().registerListener(T6.getProtocolProvidedStraight());
			S22.getProtocolProvidedCCW().registerListener(T6.getProtocolRequiredDivergent());
			T6.getProtocolRequiredDivergent().registerListener(S22.getProtocolProvidedCCW());
			S27.getProtocolProvidedCCW().registerListener(S23.getProtocolRequiredCW());
			S23.getProtocolRequiredCW().registerListener(S27.getProtocolProvidedCCW());
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
			public void raiseReserve() {
				S17.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S17.getProtocolProvidedCCW().raiseCanGo();
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
			public boolean isRaisedReserve() {
				return S17.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S17.getProtocolRequiredCCW().isRaisedCanGo();
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
			public void raiseReserve() {
				S22.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S22.getProtocolProvidedCW().raiseCanGo();
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
			public boolean isRaisedReserve() {
				return S22.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S22.getProtocolRequiredCW().isRaisedCanGo();
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
			public void raiseReserve() {
				S27.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S27.getProtocolProvidedCW().raiseCanGo();
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
			public boolean isRaisedReserve() {
				return S27.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S27.getProtocolRequiredCW().isRaisedCanGo();
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
		
		public class S17ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S17.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S17.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S17.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S17.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S17.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S17.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S17.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S17ControlProvided getS17ControlProvided() {
			return s17ControlProvided;
		}
		
		public class T6TurnoutProvided implements TurnoutInterface.Provided {
		
			@Override
			public void raiseTurnoutDivergent() {
				T6.getTurnout().raiseTurnoutDivergent();
			}
			
			@Override
			public void raiseTurnoutStraight() {
				T6.getTurnout().raiseTurnoutStraight();
			}
			
			
			@Override
			public void registerListener(TurnoutInterface.Listener.Provided listener) {
				T6.getTurnout().registerListener(listener);
			}
			
			@Override
			public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
				return T6.getTurnout().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T6TurnoutProvided getT6TurnoutProvided() {
			return t6TurnoutProvided;
		}
		
		public class S22ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S22.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S22.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S22.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S22.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S22.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S22.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S22.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S22ControlProvided getS22ControlProvided() {
			return s22ControlProvided;
		}
		
		public class S23ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S23.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S23.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S23.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S23.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S23.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S23.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S23.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S23ControlProvided getS23ControlProvided() {
			return s23ControlProvided;
		}
		
		public class S27ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S27.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S27.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S27.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S27.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S27.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S27.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S27.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S27ControlProvided getS27ControlProvided() {
			return s27ControlProvided;
		}
		
		public class S17TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S17.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S17.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S17.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S17.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S17TrainRequired getS17TrainRequired() {
			return s17TrainRequired;
		}
		
		public class T6TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				T6.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T6.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				T6.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return T6.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T6TrainRequired getT6TrainRequired() {
			return t6TrainRequired;
		}
		
		public class S22TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S22.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S22.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S22.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S22.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S22TrainRequired getS22TrainRequired() {
			return s22TrainRequired;
		}
		
		public class S23TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S23.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S23.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S23.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S23.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S23TrainRequired getS23TrainRequired() {
			return s23TrainRequired;
		}
		
		public class S27TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S27.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S27.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S27.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S27.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S27TrainRequired getS27TrainRequired() {
			return s27TrainRequired;
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
