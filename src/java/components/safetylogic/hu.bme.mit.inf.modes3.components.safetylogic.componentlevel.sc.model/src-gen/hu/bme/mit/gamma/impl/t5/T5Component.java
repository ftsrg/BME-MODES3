	package hu.bme.mit.gamma.impl.t5;

	import java.util.List;
	import org.yakindu.scr.ITimer;
	
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
		private S11TrainProvided s11TrainProvided = new S11TrainProvided();
		private S10TrainProvided s10TrainProvided = new S10TrainProvided();
		private T5TrainProvided t5TrainProvided = new T5TrainProvided();
		private S08TrainProvided s08TrainProvided = new S08TrainProvided();
		private S13TrainProvided s13TrainProvided = new S13TrainProvided();
		
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
			S08.getProtocolProvidedCW().registerListener(T5.getProtocolRequiredTop());
			T5.getProtocolRequiredTop().registerListener(S08.getProtocolProvidedCW());
			T5.getProtocolProvidedDivergent().registerListener(S10.getProtocolRequiredCCW());
			S10.getProtocolRequiredCCW().registerListener(T5.getProtocolProvidedDivergent());
			S11.getProtocolProvidedCCW().registerListener(T5.getProtocolRequiredStraight());
			T5.getProtocolRequiredStraight().registerListener(S11.getProtocolProvidedCCW());
			S10.getProtocolProvidedCCW().registerListener(T5.getProtocolRequiredDivergent());
			T5.getProtocolRequiredDivergent().registerListener(S10.getProtocolProvidedCCW());
			T5.getProtocolProvidedTop().registerListener(S08.getProtocolRequiredCW());
			S08.getProtocolRequiredCW().registerListener(T5.getProtocolProvidedTop());
			T5.getProtocolProvidedStraight().registerListener(S11.getProtocolRequiredCCW());
			S11.getProtocolRequiredCCW().registerListener(T5.getProtocolProvidedStraight());
			S08.getProtocolProvidedCCW().registerListener(S13.getProtocolRequiredCW());
			S13.getProtocolRequiredCW().registerListener(S08.getProtocolProvidedCCW());
			S13.getProtocolProvidedCW().registerListener(S08.getProtocolRequiredCCW());
			S08.getProtocolRequiredCCW().registerListener(S13.getProtocolProvidedCW());
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
			public void raiseRelease() {
				S11.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseCanGo() {
				S11.getProtocolProvidedCW().raiseCanGo();
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
			public boolean isRaisedRelease() {
				return S11.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S11.getProtocolRequiredCW().isRaisedCanGo();
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
			public void raiseRelease() {
				S10.getProtocolProvidedCW().raiseRelease();
			}
			
			@Override
			public void raiseCanGo() {
				S10.getProtocolProvidedCW().raiseCanGo();
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
			public boolean isRaisedRelease() {
				return S10.getProtocolRequiredCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S10.getProtocolRequiredCW().isRaisedCanGo();
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
			public void raiseRelease() {
				S13.getProtocolProvidedCCW().raiseRelease();
			}
			
			@Override
			public void raiseCanGo() {
				S13.getProtocolProvidedCCW().raiseCanGo();
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
			public boolean isRaisedRelease() {
				return S13.getProtocolRequiredCCW().isRaisedRelease();
			}
			@Override
			public boolean isRaisedCanGo() {
				return S13.getProtocolRequiredCCW().isRaisedCanGo();
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
		
		public class S11ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S11.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S11.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S11.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S11.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S11.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S11ControlProvided getS11ControlProvided() {
			return s11ControlProvided;
		}
		
		public class S10ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S10.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S10.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S10.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S10.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S10.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S10ControlProvided getS10ControlProvided() {
			return s10ControlProvided;
		}
		
		public class T5TurnoutProvided implements TurnoutControlInterface.Provided {
		
			@Override
			public void raiseTurnoutDivergent() {
				T5.getTurnoutControlProvided().raiseTurnoutDivergent();
			}
			
			@Override
			public void raiseTurnoutStraight() {
				T5.getTurnoutControlProvided().raiseTurnoutStraight();
			}
			
			
			@Override
			public void registerListener(TurnoutControlInterface.Listener.Provided listener) {
				T5.getTurnoutControlProvided().registerListener(listener);
			}
			
			@Override
			public List<TurnoutControlInterface.Listener.Provided> getRegisteredListeners() {
				return T5.getTurnoutControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T5TurnoutProvided getT5TurnoutProvided() {
			return t5TurnoutProvided;
		}
		
		public class S08ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S08.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S08.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S08.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S08.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S08.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S08ControlProvided getS08ControlProvided() {
			return s08ControlProvided;
		}
		
		public class S13ControlProvided implements SectionControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S13.getSectionControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S13.getSectionControlProvided().isRaisedEnableSection();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S13.getSectionControlProvided().isRaisedDisableSection();
			}
			
			@Override
			public void registerListener(SectionControlInterface.Listener.Provided listener) {
				S13.getSectionControlProvided().registerListener(listener);
			}
			
			@Override
			public List<SectionControlInterface.Listener.Provided> getRegisteredListeners() {
				return S13.getSectionControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S13ControlProvided getS13ControlProvided() {
			return s13ControlProvided;
		}
		
		public class S11TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				S11.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S11.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S11.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S11.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S11TrainProvided getS11TrainProvided() {
			return s11TrainProvided;
		}
		
		public class S10TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				S10.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S10.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S10.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S10.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S10TrainProvided getS10TrainProvided() {
			return s10TrainProvided;
		}
		
		public class T5TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				T5.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				T5.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				T5.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return T5.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T5TrainProvided getT5TrainProvided() {
			return t5TrainProvided;
		}
		
		public class S08TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				S08.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S08.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S08.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S08.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S08TrainProvided getS08TrainProvided() {
			return s08TrainProvided;
		}
		
		public class S13TrainProvided implements TrainInterface.Provided {
		
			@Override
			public void raiseUnoccupy() {
				S13.getTrainProvided().raiseUnoccupy();
			}
			
			@Override
			public void raiseOccupy() {
				S13.getTrainProvided().raiseOccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Provided listener) {
				S13.getTrainProvided().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Provided> getRegisteredListeners() {
				return S13.getTrainProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S13TrainProvided getS13TrainProvided() {
			return s13TrainProvided;
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

		/** Setter for the timer e.g., a virtual timer. */
		public void setTimer(ITimer timer) {
			S11.setTimer(timer);
			S10.setTimer(timer);
			S08.setTimer(timer);
			S13.setTimer(timer);
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
