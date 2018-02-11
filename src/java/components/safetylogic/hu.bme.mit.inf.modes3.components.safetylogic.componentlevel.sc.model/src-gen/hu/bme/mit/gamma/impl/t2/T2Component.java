	package hu.bme.mit.gamma.impl.t2;

	import java.util.List;
	import hu.bme.mit.gamma.impl.interfaces.*;
	import hu.bme.mit.gamma.impl.section.*;
	import hu.bme.mit.gamma.impl.turnout.*;
	
	public class T2Component implements T2ComponentInterface {			
		// Component instances
		private SectionStatechart S24 = new SectionStatechart();
		private SectionStatechart S29 = new SectionStatechart();
		private TurnoutStatechart T2 = new TurnoutStatechart();
		private SectionStatechart S31 = new SectionStatechart();
		private SectionStatechart S18 = new SectionStatechart();
		// Port instances
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
		
		public T2Component() {
			init();
		}
		
		/** Enters the contained statemachines recursively. Should be used only be the container (composite system) class. */
		public void enter() {
			S24.enter();
			S29.enter();
			T2.enter();
			S31.enter();
			S18.enter();
		}
		
		/** Creates the channel mappings and enters the wrapped statemachines. */
		private void init() {
			// Registration of simple channels
			S29.getProtocolProvidedCCW().registerListener(S24.getProtocolRequiredCW());
			S24.getProtocolRequiredCW().registerListener(S29.getProtocolProvidedCCW());
			T2.getProtocolProvidedTop().registerListener(S29.getProtocolRequiredCW());
			S29.getProtocolRequiredCW().registerListener(T2.getProtocolProvidedTop());
			S18.getProtocolProvidedCCW().registerListener(S31.getProtocolRequiredCW());
			S31.getProtocolRequiredCW().registerListener(S18.getProtocolProvidedCCW());
			S24.getProtocolProvidedCW().registerListener(S29.getProtocolRequiredCCW());
			S29.getProtocolRequiredCCW().registerListener(S24.getProtocolProvidedCW());
			S31.getProtocolProvidedCW().registerListener(S18.getProtocolRequiredCCW());
			S18.getProtocolRequiredCCW().registerListener(S31.getProtocolProvidedCW());
			T2.getProtocolProvidedStraight().registerListener(S31.getProtocolRequiredCCW());
			S31.getProtocolRequiredCCW().registerListener(T2.getProtocolProvidedStraight());
			S29.getProtocolProvidedCW().registerListener(T2.getProtocolRequiredTop());
			T2.getProtocolRequiredTop().registerListener(S29.getProtocolProvidedCW());
			S31.getProtocolProvidedCCW().registerListener(T2.getProtocolRequiredStraight());
			T2.getProtocolRequiredStraight().registerListener(S31.getProtocolProvidedCCW());
			// Registration of broadcast channels
			enter();
		}
		
		// Inner classes representing Ports
		public class S24ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseReserve() {
				S24.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S24.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseRelease() {
				S24.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseCannotGo() {
				S24.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S24.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S24.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S24ProtocolProvidedCCW getS24ProtocolProvidedCCW() {
			return s24ProtocolProvidedCCW;
		}
		
		public class S24ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedReserve() {
				return S24.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S24.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S24.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S24.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S24.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S24.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S24ProtocolRequiredCCW getS24ProtocolRequiredCCW() {
			return s24ProtocolRequiredCCW;
		}
		
		public class T2ProtocolProvidedDivergent implements ProtocolInterface.Provided {
		
			@Override
			public void raiseReserve() {
				T2.getProtocolProvidedDivergent().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				T2.getProtocolProvidedDivergent().raiseCanGo();
			}
			
			@Override
			public void raiseRelease() {
				T2.getProtocolProvidedDivergent().raiseRelease();
			}
			
			@Override
			public void raiseCannotGo() {
				T2.getProtocolProvidedDivergent().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				T2.getProtocolProvidedDivergent().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return T2.getProtocolProvidedDivergent().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T2ProtocolProvidedDivergent getT2ProtocolProvidedDivergent() {
			return t2ProtocolProvidedDivergent;
		}
		
		public class T2ProtocolRequiredDivergent implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedReserve() {
				return T2.getProtocolRequiredDivergent().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return T2.getProtocolRequiredDivergent().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return T2.getProtocolRequiredDivergent().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return T2.getProtocolRequiredDivergent().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				T2.getProtocolRequiredDivergent().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return T2.getProtocolRequiredDivergent().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T2ProtocolRequiredDivergent getT2ProtocolRequiredDivergent() {
			return t2ProtocolRequiredDivergent;
		}
		
		public class S18ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseReserve() {
				S18.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCanGo() {
				S18.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseRelease() {
				S18.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseCannotGo() {
				S18.getProtocolProvidedCW().raiseCannotGo();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S18.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S18.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S18ProtocolProvidedCW getS18ProtocolProvidedCW() {
			return s18ProtocolProvidedCW;
		}
		
		public class S18ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedReserve() {
				return S18.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S18.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S18.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S18.getProtocolRequiredCW().isRaisedCannotGo();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S18.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S18.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S18ProtocolRequiredCW getS18ProtocolRequiredCW() {
			return s18ProtocolRequiredCW;
		}
		
		public class S24ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S24.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S24.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S24.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S24.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S24.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S24.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S24.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S24ControlProvided getS24ControlProvided() {
			return s24ControlProvided;
		}
		
		public class S29ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S29.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S29.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S29.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S29.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S29.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S29.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S29.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S29ControlProvided getS29ControlProvided() {
			return s29ControlProvided;
		}
		
		public class T2TurnoutProvided implements TurnoutInterface.Provided {
		
			@Override
			public void raiseTurnoutDivergent() {
				T2.getTurnout().raiseTurnoutDivergent();
			}
			
			@Override
			public void raiseTurnoutStraight() {
				T2.getTurnout().raiseTurnoutStraight();
			}
			
			
			@Override
			public void registerListener(TurnoutInterface.Listener.Provided listener) {
				T2.getTurnout().registerListener(listener);
			}
			
			@Override
			public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
				return T2.getTurnout().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T2TurnoutProvided getT2TurnoutProvided() {
			return t2TurnoutProvided;
		}
		
		public class S31ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S31.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S31.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S31.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S31.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S31.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S31.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S31.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S31ControlProvided getS31ControlProvided() {
			return s31ControlProvided;
		}
		
		public class S18ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S18.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S18.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S18.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S18.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S18.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S18.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S18.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S18ControlProvided getS18ControlProvided() {
			return s18ControlProvided;
		}
		
		public class S24TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S24.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S24.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S24.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S24.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S24TrainRequired getS24TrainRequired() {
			return s24TrainRequired;
		}
		
		public class S29TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S29.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S29.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S29.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S29.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S29TrainRequired getS29TrainRequired() {
			return s29TrainRequired;
		}
		
		public class T2TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				T2.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				T2.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				T2.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return T2.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T2TrainRequired getT2TrainRequired() {
			return t2TrainRequired;
		}
		
		public class S31TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S31.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S31.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S31.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S31.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S31TrainRequired getS31TrainRequired() {
			return s31TrainRequired;
		}
		
		public class S18TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseUnoccupy() {
				S18.getTrainRequired().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S18.getTrainRequired().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S18.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S18.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S18TrainRequired getS18TrainRequired() {
			return s18TrainRequired;
		}
		
		/** Changes the event and process queues of all component instances. Should be used only be the container (composite system) class. */
		public void changeEventQueues() {
			S24.changeEventQueues();
			S29.changeEventQueues();
			T2.changeEventQueues();
			S31.changeEventQueues();
			S18.changeEventQueues();
		}
		
		/** Returns whether all event queues of the contained component instances are empty. 
		Should be used only be the container (composite system) class. */
		public boolean isEventQueueEmpty() {
			return S24.isEventQueueEmpty() && S29.isEventQueueEmpty() && T2.isEventQueueEmpty() && S31.isEventQueueEmpty() && S18.isEventQueueEmpty();
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
			S24.runComponent();
			S29.runComponent();
			T2.runComponent();
			S31.runComponent();
			S18.runComponent();
		}

		
		/**  Getter for component instances, e.g. enabling to check their states. */
		public SectionStatechart getS24() {
			return S24;
		}
		
		public SectionStatechart getS29() {
			return S29;
		}
		
		public TurnoutStatechart getT2() {
			return T2;
		}
		
		public SectionStatechart getS31() {
			return S31;
		}
		
		public SectionStatechart getS18() {
			return S18;
		}
		
	}
