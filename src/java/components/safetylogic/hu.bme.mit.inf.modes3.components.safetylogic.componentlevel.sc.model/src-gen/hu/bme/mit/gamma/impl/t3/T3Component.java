	package hu.bme.mit.gamma.impl.t3;

	import java.util.List;
	import org.yakindu.scr.ITimer;
	
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
		private S20TrainProvided s20TrainProvided = new S20TrainProvided();
		private S19TrainProvided s19TrainProvided = new S19TrainProvided();
		private T3_1TrainProvided t3_1TrainProvided = new T3_1TrainProvided();
		private T3_2TrainProvided t3_2TrainProvided = new T3_2TrainProvided();
		private S26TrainProvided s26TrainProvided = new S26TrainProvided();
		private S30TrainProvided s30TrainProvided = new S30TrainProvided();
		
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
			T3_1.getProtocolProvidedStraight().registerListener(S26.getProtocolRequiredCW());
			S26.getProtocolRequiredCW().registerListener(T3_1.getProtocolProvidedStraight());
			T3_2.getProtocolProvidedDivergent().registerListener(T3_1.getProtocolRequiredDivergent());
			T3_1.getProtocolRequiredDivergent().registerListener(T3_2.getProtocolProvidedDivergent());
			T3_1.getProtocolProvidedTop().registerListener(S20.getProtocolRequiredCCW());
			S20.getProtocolRequiredCCW().registerListener(T3_1.getProtocolProvidedTop());
			S30.getProtocolProvidedCW().registerListener(T3_2.getProtocolRequiredTop());
			T3_2.getProtocolRequiredTop().registerListener(S30.getProtocolProvidedCW());
			T3_2.getProtocolProvidedTop().registerListener(S30.getProtocolRequiredCW());
			S30.getProtocolRequiredCW().registerListener(T3_2.getProtocolProvidedTop());
			S26.getProtocolProvidedCW().registerListener(T3_1.getProtocolRequiredStraight());
			T3_1.getProtocolRequiredStraight().registerListener(S26.getProtocolProvidedCW());
			T3_1.getProtocolProvidedDivergent().registerListener(T3_2.getProtocolRequiredDivergent());
			T3_2.getProtocolRequiredDivergent().registerListener(T3_1.getProtocolProvidedDivergent());
			T3_2.getProtocolProvidedStraight().registerListener(S19.getProtocolRequiredCCW());
			S19.getProtocolRequiredCCW().registerListener(T3_2.getProtocolProvidedStraight());
			S19.getProtocolProvidedCCW().registerListener(T3_2.getProtocolRequiredStraight());
			T3_2.getProtocolRequiredStraight().registerListener(S19.getProtocolProvidedCCW());
			S20.getProtocolProvidedCCW().registerListener(T3_1.getProtocolRequiredTop());
			T3_1.getProtocolRequiredTop().registerListener(S20.getProtocolProvidedCCW());
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
		
		public class S20ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S20.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S20.getSectionControlProvided().isRaisedDisableSection();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S20.getSectionControlProvided().isRaisedEnableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S20.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S20.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S20ControlProvided getS20ControlProvided() {
			return s20ControlProvided;
		}
		
		public class S19ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S19.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S19.getSectionControlProvided().isRaisedDisableSection();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S19.getSectionControlProvided().isRaisedEnableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S19.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S19.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S19ControlProvided getS19ControlProvided() {
			return s19ControlProvided;
		}
		
		public class T3_1TurnoutProvided implements TurnoutControlInterface.Provided {
		
			@Override
			public void raiseTurnoutDivergent() {
				T3_1.getTurnoutControlProvided().raiseTurnoutDivergent();
			}
			
			@Override
			public void raiseTurnoutStraight() {
				T3_1.getTurnoutControlProvided().raiseTurnoutStraight();
			}
			
			
			@Override
			public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
				T3_1.getTurnoutControlProvided().registerListener(listener);
			}
			
			@Override
			public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
				return T3_1.getTurnoutControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_1TurnoutProvided getT3_1TurnoutProvided() {
			return t3_1TurnoutProvided;
		}
		
		public class T3_2TurnoutProvided implements TurnoutControlInterface.Provided {
		
			@Override
			public void raiseTurnoutDivergent() {
				T3_2.getTurnoutControlProvided().raiseTurnoutDivergent();
			}
			
			@Override
			public void raiseTurnoutStraight() {
				T3_2.getTurnoutControlProvided().raiseTurnoutStraight();
			}
			
			
			@Override
			public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
				T3_2.getTurnoutControlProvided().registerListener(listener);
			}
			
			@Override
			public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
				return T3_2.getTurnoutControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_2TurnoutProvided getT3_2TurnoutProvided() {
			return t3_2TurnoutProvided;
		}
		
		public class S26ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S26.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S26.getSectionControlProvided().isRaisedDisableSection();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S26.getSectionControlProvided().isRaisedEnableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S26.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S26.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S26ControlProvided getS26ControlProvided() {
			return s26ControlProvided;
		}
		
		public class S30ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S30.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedDisableSection() {
				return S30.getSectionControlProvided().isRaisedDisableSection();
			}
			@Override
			public boolean isRaisedEnableSection() {
				return S30.getSectionControlProvided().isRaisedEnableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S30.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S30.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S30ControlProvided getS30ControlProvided() {
			return s30ControlProvided;
		}
		
		public class S20TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S20.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S20.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S20.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S20.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S20TrainProvided getS20TrainProvided() {
			return s20TrainProvided;
		}
		
		public class S19TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S19.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S19.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S19.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S19.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S19TrainProvided getS19TrainProvided() {
			return s19TrainProvided;
		}
		
		public class T3_1TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				T3_1.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T3_1.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				T3_1.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return T3_1.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_1TrainProvided getT3_1TrainProvided() {
			return t3_1TrainProvided;
		}
		
		public class T3_2TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				T3_2.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T3_2.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				T3_2.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return T3_2.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T3_2TrainProvided getT3_2TrainProvided() {
			return t3_2TrainProvided;
		}
		
		public class S26TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S26.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S26.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S26.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S26.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S26TrainProvided getS26TrainProvided() {
			return s26TrainProvided;
		}
		
		public class S30TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseOccupy() {
				S30.getTrainProvided().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S30.getTrainProvided().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S30.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S30.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S30TrainProvided getS30TrainProvided() {
			return s30TrainProvided;
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

		/** Setter for the timer e.g., a virtual timer. */
		public void setTimer(ITimer timer) {
			S20.setTimer(timer);
			S19.setTimer(timer);
			S26.setTimer(timer);
			S30.setTimer(timer);
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
