	package hu.bme.mit.gamma.impl.t5;

	import java.util.List;
	import hu.bme.mit.gamma.impl.interfaces.*;
	import hu.bme.mit.gamma.impl.section.*;
	import hu.bme.mit.gamma.impl.turnout.*;
	
	public class T5Component implements T5ComponentInterface {			
		// Component instances
		private SectionStatechart S11 = new SectionStatechart();
		private SectionStatechart S10 = new SectionStatechart();
		private TurnoutStatechart T5 = new TurnoutStatechart();
		private SectionStatechart S08 = new SectionStatechart();
		private SectionStatechart S13 = new SectionStatechart();
		// Port instances
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
		private S11TrainRequired s11TrainRequired = new S11TrainRequired();
		private S10TrainRequired s10TrainRequired = new S10TrainRequired();
		private T5TrainRequired t5TrainRequired = new T5TrainRequired();
		private S08TrainRequired s08TrainRequired = new S08TrainRequired();
		private S13TrainRequired s13TrainRequired = new S13TrainRequired();
		
		public T5Component() {
			init();
		}
		
		/** Enters the contained statemachines recursively. Should be used only be the container (composite system) class. */
		public void enter() {
			S11.enter();
			S10.enter();
			T5.enter();
			S08.enter();
			S13.enter();
		}
		
		/** Creates the channel mappings and enters the wrapped statemachines. */
		private void init() {
			// Registration of simple channels
			S13.getProtocolProvidedCW().registerListener(S08.getProtocolRequiredCCW());
			S08.getProtocolRequiredCCW().registerListener(S13.getProtocolProvidedCW());
			S08.getProtocolProvidedCW().registerListener(T5.getProtocolRequiredTop());
			T5.getProtocolRequiredTop().registerListener(S08.getProtocolProvidedCW());
			T5.getProtocolProvidedStraight().registerListener(S11.getProtocolRequiredCCW());
			S11.getProtocolRequiredCCW().registerListener(T5.getProtocolProvidedStraight());
			S11.getProtocolProvidedCCW().registerListener(T5.getProtocolRequiredStraight());
			T5.getProtocolRequiredStraight().registerListener(S11.getProtocolProvidedCCW());
			S10.getProtocolProvidedCCW().registerListener(T5.getProtocolRequiredDivergent());
			T5.getProtocolRequiredDivergent().registerListener(S10.getProtocolProvidedCCW());
			T5.getProtocolProvidedDivergent().registerListener(S10.getProtocolRequiredCCW());
			S10.getProtocolRequiredCCW().registerListener(T5.getProtocolProvidedDivergent());
			S08.getProtocolProvidedCCW().registerListener(S13.getProtocolRequiredCW());
			S13.getProtocolRequiredCW().registerListener(S08.getProtocolProvidedCCW());
			T5.getProtocolProvidedTop().registerListener(S08.getProtocolRequiredCW());
			S08.getProtocolRequiredCW().registerListener(T5.getProtocolProvidedTop());
			// Registration of broadcast channels
			enter();
		}
		
		// Inner classes representing Ports
		public class S11ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCannotGo() {
				S11.getProtocolProvidedCW().raiseCannotGo();
			}
			
			@Override
			public void raiseCanGo() {
				S11.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseRelease() {
				S11.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S11.getProtocolProvidedCW().raiseReserve();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S11.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S11.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S11ProtocolProvidedCW getS11ProtocolProvidedCW() {
			return s11ProtocolProvidedCW;
		}
		
		public class S11ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCannotGo() {
				return S11.getProtocolRequiredCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S11.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S11.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S11.getProtocolRequiredCW().isRaisedReserve();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S11.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S11.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S11ProtocolRequiredCW getS11ProtocolRequiredCW() {
			return s11ProtocolRequiredCW;
		}
		
		public class S10ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCannotGo() {
				S10.getProtocolProvidedCW().raiseCannotGo();
			}
			
			@Override
			public void raiseCanGo() {
				S10.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseRelease() {
				S10.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S10.getProtocolProvidedCW().raiseReserve();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S10.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S10.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S10ProtocolProvidedCW getS10ProtocolProvidedCW() {
			return s10ProtocolProvidedCW;
		}
		
		public class S10ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCannotGo() {
				return S10.getProtocolRequiredCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S10.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S10.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S10.getProtocolRequiredCW().isRaisedReserve();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S10.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S10.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S10ProtocolRequiredCW getS10ProtocolRequiredCW() {
			return s10ProtocolRequiredCW;
		}
		
		public class S13ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCannotGo() {
				S13.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			@Override
			public void raiseCanGo() {
				S13.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseRelease() {
				S13.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseReserve() {
				S13.getProtocolProvidedCCW().raiseReserve();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S13.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S13.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S13ProtocolProvidedCCW getS13ProtocolProvidedCCW() {
			return s13ProtocolProvidedCCW;
		}
		
		public class S13ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCannotGo() {
				return S13.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S13.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S13.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedReserve() {
				return S13.getProtocolRequiredCCW().isRaisedReserve();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S13.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S13.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S13ProtocolRequiredCCW getS13ProtocolRequiredCCW() {
			return s13ProtocolRequiredCCW;
		}
		
		public class S11ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S11.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S11.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S11.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S11.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S11.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S11.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S11.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S11ControlProvided getS11ControlProvided() {
			return s11ControlProvided;
		}
		
		public class S10ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S10.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S10.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S10.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S10.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S10.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S10.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S10.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S10ControlProvided getS10ControlProvided() {
			return s10ControlProvided;
		}
		
		public class T5TurnoutProvided implements TurnoutInterface.Provided {
		
			@Override
			public void raiseTurnoutDivergent() {
				T5.getTurnout().raiseTurnoutDivergent();
			}
			
			@Override
			public void raiseTurnoutStraight() {
				T5.getTurnout().raiseTurnoutStraight();
			}
			
			
			@Override
			public void registerListener(TurnoutInterface.Listener.Provided listener) {
				T5.getTurnout().registerListener(listener);
			}
			
			@Override
			public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
				return T5.getTurnout().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T5TurnoutProvided getT5TurnoutProvided() {
			return t5TurnoutProvided;
		}
		
		public class S08ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S08.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S08.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S08.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S08.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S08.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S08.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S08.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S08ControlProvided getS08ControlProvided() {
			return s08ControlProvided;
		}
		
		public class S13ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S13.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S13.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S13.getControlProvided().getDisableSectionValue();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S13.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S13.getControlProvided().getEnableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S13.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S13.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S13ControlProvided getS13ControlProvided() {
			return s13ControlProvided;
		}
		
		public class S11TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S11.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S11.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S11.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S11.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S11TrainRequired getS11TrainRequired() {
			return s11TrainRequired;
		}
		
		public class S10TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S10.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S10.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S10.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S10.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S10TrainRequired getS10TrainRequired() {
			return s10TrainRequired;
		}
		
		public class T5TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				T5.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				T5.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				T5.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return T5.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T5TrainRequired getT5TrainRequired() {
			return t5TrainRequired;
		}
		
		public class S08TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S08.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S08.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S08.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S08.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S08TrainRequired getS08TrainRequired() {
			return s08TrainRequired;
		}
		
		public class S13TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S13.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S13.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S13.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S13.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S13TrainRequired getS13TrainRequired() {
			return s13TrainRequired;
		}
		
		/** Changes the event and process queues of all component instances. Should be used only be the container (composite system) class. */
		public void changeEventQueues() {
			S11.changeEventQueues();
			S10.changeEventQueues();
			T5.changeEventQueues();
			S08.changeEventQueues();
			S13.changeEventQueues();
		}
		
		/** Returns whether all event queues of the contained component instances are empty. 
		Should be used only be the container (composite system) class. */
		public boolean isEventQueueEmpty() {
			return S11.isEventQueueEmpty() && S10.isEventQueueEmpty() && T5.isEventQueueEmpty() && S08.isEventQueueEmpty() && S13.isEventQueueEmpty();
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
			S11.runComponent();
			S10.runComponent();
			T5.runComponent();
			S08.runComponent();
			S13.runComponent();
		}

		
		/**  Getter for component instances, e.g. enabling to check their states. */
		public SectionStatechart getS11() {
			return S11;
		}
		
		public SectionStatechart getS10() {
			return S10;
		}
		
		public TurnoutStatechart getT5() {
			return T5;
		}
		
		public SectionStatechart getS08() {
			return S08;
		}
		
		public SectionStatechart getS13() {
			return S13;
		}
		
	}
