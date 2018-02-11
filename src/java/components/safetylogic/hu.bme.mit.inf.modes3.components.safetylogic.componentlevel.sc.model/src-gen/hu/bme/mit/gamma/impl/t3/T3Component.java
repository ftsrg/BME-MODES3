	package hu.bme.mit.gamma.impl.t3;

	import java.util.List;
	import hu.bme.mit.gamma.impl.interfaces.*;
	import hu.bme.mit.gamma.impl.section.*;
	import hu.bme.mit.gamma.impl.turnout.*;
	
	public class T3Component implements T3ComponentInterface {			
		// Component instances
		private SectionStatechart S20 = new SectionStatechart();
		private SectionStatechart S19 = new SectionStatechart();
		private TurnoutStatechart T3_1 = new TurnoutStatechart();
		private TurnoutStatechart T3_2 = new TurnoutStatechart();
		private SectionStatechart S26 = new SectionStatechart();
		private SectionStatechart S30 = new SectionStatechart();
		// Port instances
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
		
		public T3Component() {
			init();
		}
		
		/** Enters the contained statemachines recursively. Should be used only be the container (composite system) class. */
		public void enter() {
			S20.enter();
			S19.enter();
			T3_1.enter();
			T3_2.enter();
			S26.enter();
			S30.enter();
		}
		
		/** Creates the channel mappings and enters the wrapped statemachines. */
		private void init() {
			// Registration of simple channels
			T3_1.getProtocolProvidedTop().registerListener(S20.getProtocolRequiredCCW());
			S20.getProtocolRequiredCCW().registerListener(T3_1.getProtocolProvidedTop());
			S19.getProtocolProvidedCCW().registerListener(T3_2.getProtocolRequiredStraight());
			T3_2.getProtocolRequiredStraight().registerListener(S19.getProtocolProvidedCCW());
			T3_2.getProtocolProvidedDivergent().registerListener(T3_1.getProtocolRequiredDivergent());
			T3_1.getProtocolRequiredDivergent().registerListener(T3_2.getProtocolProvidedDivergent());
			S26.getProtocolProvidedCW().registerListener(T3_1.getProtocolRequiredStraight());
			T3_1.getProtocolRequiredStraight().registerListener(S26.getProtocolProvidedCW());
			T3_2.getProtocolProvidedTop().registerListener(S30.getProtocolRequiredCW());
			S30.getProtocolRequiredCW().registerListener(T3_2.getProtocolProvidedTop());
			T3_2.getProtocolProvidedStraight().registerListener(S19.getProtocolRequiredCCW());
			S19.getProtocolRequiredCCW().registerListener(T3_2.getProtocolProvidedStraight());
			T3_1.getProtocolProvidedDivergent().registerListener(T3_2.getProtocolRequiredDivergent());
			T3_2.getProtocolRequiredDivergent().registerListener(T3_1.getProtocolProvidedDivergent());
			S30.getProtocolProvidedCW().registerListener(T3_2.getProtocolRequiredTop());
			T3_2.getProtocolRequiredTop().registerListener(S30.getProtocolProvidedCW());
			S20.getProtocolProvidedCCW().registerListener(T3_1.getProtocolRequiredTop());
			T3_1.getProtocolRequiredTop().registerListener(S20.getProtocolProvidedCCW());
			T3_1.getProtocolProvidedStraight().registerListener(S26.getProtocolRequiredCW());
			S26.getProtocolRequiredCW().registerListener(T3_1.getProtocolProvidedStraight());
			// Registration of broadcast channels
			enter();
		}
		
		// Inner classes representing Ports
		public class S20ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S20.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S20.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S20.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				S20.getProtocolProvidedCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S20.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S20.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S20ProtocolProvidedCW getS20ProtocolProvidedCW() {
			return s20ProtocolProvidedCW;
		}
		
		public class S20ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S20.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S20.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S20.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S20.getProtocolRequiredCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S20.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S20.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S20ProtocolRequiredCW getS20ProtocolRequiredCW() {
			return s20ProtocolRequiredCW;
		}
		
		public class S19ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S19.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S19.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S19.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				S19.getProtocolProvidedCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S19.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S19.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S19ProtocolProvidedCW getS19ProtocolProvidedCW() {
			return s19ProtocolProvidedCW;
		}
		
		public class S19ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S19.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S19.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S19.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S19.getProtocolRequiredCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S19.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S19.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S19ProtocolRequiredCW getS19ProtocolRequiredCW() {
			return s19ProtocolRequiredCW;
		}
		
		public class S26ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S26.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S26.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S26.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				S26.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S26.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S26.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S26ProtocolProvidedCCW getS26ProtocolProvidedCCW() {
			return s26ProtocolProvidedCCW;
		}
		
		public class S26ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S26.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S26.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S26.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S26.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S26.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S26.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S26ProtocolRequiredCCW getS26ProtocolRequiredCCW() {
			return s26ProtocolRequiredCCW;
		}
		
		public class S30ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseRelease() {
				S30.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S30.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S30.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseCannotGo() {
				S30.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S30.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S30.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S30ProtocolProvidedCCW getS30ProtocolProvidedCCW() {
			return s30ProtocolProvidedCCW;
		}
		
		public class S30ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedRelease() {
				return S30.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S30.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S30.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S30.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S30.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S30.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S30ProtocolRequiredCCW getS30ProtocolRequiredCCW() {
			return s30ProtocolRequiredCCW;
		}
		
		public class S20ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S20.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S20.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S20.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S20.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S20.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S20.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S20.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S20ControlProvided getS20ControlProvided() {
			return s20ControlProvided;
		}
		
		public class S19ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S19.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S19.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S19.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S19.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S19.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S19.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S19.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S19ControlProvided getS19ControlProvided() {
			return s19ControlProvided;
		}
		
		public class T3_1TurnoutProvided implements TurnoutInterface.Provided {
		
			@Override
			public void raiseTurnoutStraight() {
				T3_1.getTurnout().raiseTurnoutStraight();
			}
			
			@Override
			public void raiseTurnoutDivergent() {
				T3_1.getTurnout().raiseTurnoutDivergent();
			}
			
			
			@Override
			public void registerListener(TurnoutInterface.Listener.Provided listener) {
				T3_1.getTurnout().registerListener(listener);
			}
			
			@Override
			public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
				return T3_1.getTurnout().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_1TurnoutProvided getT3_1TurnoutProvided() {
			return t3_1TurnoutProvided;
		}
		
		public class T3_2TurnoutProvided implements TurnoutInterface.Provided {
		
			@Override
			public void raiseTurnoutStraight() {
				T3_2.getTurnout().raiseTurnoutStraight();
			}
			
			@Override
			public void raiseTurnoutDivergent() {
				T3_2.getTurnout().raiseTurnoutDivergent();
			}
			
			
			@Override
			public void registerListener(TurnoutInterface.Listener.Provided listener) {
				T3_2.getTurnout().registerListener(listener);
			}
			
			@Override
			public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
				return T3_2.getTurnout().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_2TurnoutProvided getT3_2TurnoutProvided() {
			return t3_2TurnoutProvided;
		}
		
		public class S26ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S26.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S26.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S26.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S26.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S26.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S26.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S26.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S26ControlProvided getS26ControlProvided() {
			return s26ControlProvided;
		}
		
		public class S30ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S30.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S30.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S30.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S30.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S30.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S30.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S30.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S30ControlProvided getS30ControlProvided() {
			return s30ControlProvided;
		}
		
		public class S20TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S20.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S20.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S20.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S20.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S20TrainRequired getS20TrainRequired() {
			return s20TrainRequired;
		}
		
		public class S19TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S19.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S19.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S19.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S19.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S19TrainRequired getS19TrainRequired() {
			return s19TrainRequired;
		}
		
		public class T3_1TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				T3_1.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T3_1.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				T3_1.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return T3_1.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_1TrainRequired getT3_1TrainRequired() {
			return t3_1TrainRequired;
		}
		
		public class T3_2TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				T3_2.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T3_2.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				T3_2.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return T3_2.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_2TrainRequired getT3_2TrainRequired() {
			return t3_2TrainRequired;
		}
		
		public class S26TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S26.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S26.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S26.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S26.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S26TrainRequired getS26TrainRequired() {
			return s26TrainRequired;
		}
		
		public class S30TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S30.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S30.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S30.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S30.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S30TrainRequired getS30TrainRequired() {
			return s30TrainRequired;
		}
		
		/** Changes the event and process queues of all component instances. Should be used only be the container (composite system) class. */
		public void changeEventQueues() {
			S20.changeEventQueues();
			S19.changeEventQueues();
			T3_1.changeEventQueues();
			T3_2.changeEventQueues();
			S26.changeEventQueues();
			S30.changeEventQueues();
		}
		
		/** Returns whether all event queues of the contained component instances are empty. 
		Should be used only be the container (composite system) class. */
		public boolean isEventQueueEmpty() {
			return S20.isEventQueueEmpty() && S19.isEventQueueEmpty() && T3_1.isEventQueueEmpty() && T3_2.isEventQueueEmpty() && S26.isEventQueueEmpty() && S30.isEventQueueEmpty();
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
			S20.runComponent();
			S19.runComponent();
			T3_1.runComponent();
			T3_2.runComponent();
			S26.runComponent();
			S30.runComponent();
		}

		
		/**  Getter for component instances, e.g. enabling to check their states. */
		public SectionStatechart getS20() {
			return S20;
		}
		
		public SectionStatechart getS19() {
			return S19;
		}
		
		public TurnoutStatechart getT3_1() {
			return T3_1;
		}
		
		public TurnoutStatechart getT3_2() {
			return T3_2;
		}
		
		public SectionStatechart getS26() {
			return S26;
		}
		
		public SectionStatechart getS30() {
			return S30;
		}
		
	}
