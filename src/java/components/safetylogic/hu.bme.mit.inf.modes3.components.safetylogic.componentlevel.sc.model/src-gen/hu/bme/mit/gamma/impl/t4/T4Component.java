	package hu.bme.mit.gamma.impl.t4;

	import java.util.List;
	import hu.bme.mit.gamma.impl.interfaces.*;
	import hu.bme.mit.gamma.impl.section.*;
	import hu.bme.mit.gamma.impl.turnout.*;
	
	public class T4Component implements T4ComponentInterface {			
		// Component instances
		private SectionStatechart S01 = new SectionStatechart();
		private SectionStatechart S02 = new SectionStatechart();
		private TurnoutStatechart T4 = new TurnoutStatechart();
		private SectionStatechart S04 = new SectionStatechart();
		private SectionStatechart S05 = new SectionStatechart();
		private SectionStatechart S06 = new SectionStatechart();
		private SectionStatechart S07 = new SectionStatechart();
		// Port instances
		private S01ProtocolProvidedCW s01ProtocolProvidedCW = new S01ProtocolProvidedCW();
		private S01ProtocolRequiredCW s01ProtocolRequiredCW = new S01ProtocolRequiredCW();
		private S06ProtocolProvidedCCW s06ProtocolProvidedCCW = new S06ProtocolProvidedCCW();
		private S06ProtocolRequiredCCW s06ProtocolRequiredCCW = new S06ProtocolRequiredCCW();
		private S07ProtocolProvidedCCW s07ProtocolProvidedCCW = new S07ProtocolProvidedCCW();
		private S07ProtocolRequiredCCW s07ProtocolRequiredCCW = new S07ProtocolRequiredCCW();
		private S01ControlProvided s01ControlProvided = new S01ControlProvided();
		private T4TurnoutProvided t4TurnoutProvided = new T4TurnoutProvided();
		private S04ControlProvided s04ControlProvided = new S04ControlProvided();
		private S05ControlProvided s05ControlProvided = new S05ControlProvided();
		private S06ControlProvided s06ControlProvided = new S06ControlProvided();
		private S07ControlProvided s07ControlProvided = new S07ControlProvided();
		private S01TrainRequired s01TrainRequired = new S01TrainRequired();
		private T4TrainRequired t4TrainRequired = new T4TrainRequired();
		private S04TrainRequired s04TrainRequired = new S04TrainRequired();
		private S05TrainRequired s05TrainRequired = new S05TrainRequired();
		private S06TrainRequired s06TrainRequired = new S06TrainRequired();
		private S07TrainRequired s07TrainRequired = new S07TrainRequired();
		
		public T4Component() {
			init();
		}
		
		/** Enters the contained statemachines recursively. Should be used only be the container (composite system) class. */
		public void enter() {
			S01.enter();
			S02.enter();
			T4.enter();
			S04.enter();
			S05.enter();
			S06.enter();
			S07.enter();
		}
		
		/** Creates the channel mappings and enters the wrapped statemachines. */
		private void init() {
			// Registration of simple channels
			S05.getProtocolProvidedCW().registerListener(T4.getProtocolRequiredDivergent());
			T4.getProtocolRequiredDivergent().registerListener(S05.getProtocolProvidedCW());
			S05.getProtocolProvidedCCW().registerListener(S07.getProtocolRequiredCW());
			S07.getProtocolRequiredCW().registerListener(S05.getProtocolProvidedCCW());
			S07.getProtocolProvidedCW().registerListener(S05.getProtocolRequiredCCW());
			S05.getProtocolRequiredCCW().registerListener(S07.getProtocolProvidedCW());
			S06.getProtocolProvidedCW().registerListener(S04.getProtocolRequiredCCW());
			S04.getProtocolRequiredCCW().registerListener(S06.getProtocolProvidedCW());
			T4.getProtocolProvidedStraight().registerListener(S04.getProtocolRequiredCW());
			S04.getProtocolRequiredCW().registerListener(T4.getProtocolProvidedStraight());
			S01.getProtocolProvidedCCW().registerListener(S02.getProtocolRequiredCW());
			S02.getProtocolRequiredCW().registerListener(S01.getProtocolProvidedCCW());
			T4.getProtocolProvidedTop().registerListener(S02.getProtocolRequiredCCW());
			S02.getProtocolRequiredCCW().registerListener(T4.getProtocolProvidedTop());
			S04.getProtocolProvidedCCW().registerListener(S06.getProtocolRequiredCW());
			S06.getProtocolRequiredCW().registerListener(S04.getProtocolProvidedCCW());
			S04.getProtocolProvidedCW().registerListener(T4.getProtocolRequiredStraight());
			T4.getProtocolRequiredStraight().registerListener(S04.getProtocolProvidedCW());
			T4.getProtocolProvidedDivergent().registerListener(S05.getProtocolRequiredCW());
			S05.getProtocolRequiredCW().registerListener(T4.getProtocolProvidedDivergent());
			S02.getProtocolProvidedCCW().registerListener(T4.getProtocolRequiredTop());
			T4.getProtocolRequiredTop().registerListener(S02.getProtocolProvidedCCW());
			S02.getProtocolProvidedCW().registerListener(S01.getProtocolRequiredCCW());
			S01.getProtocolRequiredCCW().registerListener(S02.getProtocolProvidedCW());
			// Registration of broadcast channels
			enter();
		}
		
		// Inner classes representing Ports
		public class S01ProtocolProvidedCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCanGo() {
				S01.getProtocolProvidedCW().raiseCanGo();
			}
			
			@Override
			public void raiseReserve() {
				S01.getProtocolProvidedCW().raiseReserve();
			}
			
			@Override
			public void raiseCannotGo() {
				S01.getProtocolProvidedCW().raiseCannotGo();
			}
			
			@Override
			public void raiseRelease() {
				S01.getProtocolProvidedCW().raiseRelease();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S01.getProtocolProvidedCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S01.getProtocolProvidedCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S01ProtocolProvidedCW getS01ProtocolProvidedCW() {
			return s01ProtocolProvidedCW;
		}
		
		public class S01ProtocolRequiredCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCanGo() {
				return S01.getProtocolRequiredCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedReserve() {
				return S01.getProtocolRequiredCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S01.getProtocolRequiredCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S01.getProtocolRequiredCW().isRaisedRelease();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S01.getProtocolRequiredCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S01.getProtocolRequiredCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S01ProtocolRequiredCW getS01ProtocolRequiredCW() {
			return s01ProtocolRequiredCW;
		}
		
		public class S06ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCanGo() {
				S06.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseReserve() {
				S06.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCannotGo() {
				S06.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			@Override
			public void raiseRelease() {
				S06.getProtocolProvidedCCW().raiseRelease();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S06.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S06.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S06ProtocolProvidedCCW getS06ProtocolProvidedCCW() {
			return s06ProtocolProvidedCCW;
		}
		
		public class S06ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCanGo() {
				return S06.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedReserve() {
				return S06.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S06.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S06.getProtocolRequiredCCW().isRaisedRelease();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S06.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S06.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S06ProtocolRequiredCCW getS06ProtocolRequiredCCW() {
			return s06ProtocolRequiredCCW;
		}
		
		public class S07ProtocolProvidedCCW implements ProtocolInterface.Provided {
		
			@Override
			public void raiseCanGo() {
				S07.getProtocolProvidedCCW().raiseCanGo();
			}
			
			@Override
			public void raiseReserve() {
				S07.getProtocolProvidedCCW().raiseReserve();
			}
			
			@Override
			public void raiseCannotGo() {
				S07.getProtocolProvidedCCW().raiseCannotGo();
			}
			
			@Override
			public void raiseRelease() {
				S07.getProtocolProvidedCCW().raiseRelease();
			}
			
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Provided listener) {
				S07.getProtocolProvidedCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Provided> getRegisteredListeners() {
				return S07.getProtocolProvidedCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S07ProtocolProvidedCCW getS07ProtocolProvidedCCW() {
			return s07ProtocolProvidedCCW;
		}
		
		public class S07ProtocolRequiredCCW implements ProtocolInterface.Required {
		
			
			@Override
			public boolean isRaisedCanGo() {
				return S07.getProtocolRequiredCCW().isRaisedCanGo();
			}
			@Override
			public boolean isRaisedReserve() {
				return S07.getProtocolRequiredCCW().isRaisedReserve();
			}
			@Override
			public boolean isRaisedCannotGo() {
				return S07.getProtocolRequiredCCW().isRaisedCannotGo();
			}
			@Override
			public boolean isRaisedRelease() {
				return S07.getProtocolRequiredCCW().isRaisedRelease();
			}
			
			@Override
			public void registerListener(ProtocolInterface.Listener.Required listener) {
				S07.getProtocolRequiredCCW().registerListener(listener);
			}
			
			@Override
			public List<ProtocolInterface.Listener.Required> getRegisteredListeners() {
				return S07.getProtocolRequiredCCW().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S07ProtocolRequiredCCW getS07ProtocolRequiredCCW() {
			return s07ProtocolRequiredCCW;
		}
		
		public class S01ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S01.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S01.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S01.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S01.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S01.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S01.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S01.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S01ControlProvided getS01ControlProvided() {
			return s01ControlProvided;
		}
		
		public class T4TurnoutProvided implements TurnoutInterface.Provided {
		
			@Override
			public void raiseTurnoutStraight() {
				T4.getTurnout().raiseTurnoutStraight();
			}
			
			@Override
			public void raiseTurnoutDivergent() {
				T4.getTurnout().raiseTurnoutDivergent();
			}
			
			
			@Override
			public void registerListener(TurnoutInterface.Listener.Provided listener) {
				T4.getTurnout().registerListener(listener);
			}
			
			@Override
			public List<TurnoutInterface.Listener.Provided> getRegisteredListeners() {
				return T4.getTurnout().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T4TurnoutProvided getT4TurnoutProvided() {
			return t4TurnoutProvided;
		}
		
		public class S04ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S04.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S04.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S04.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S04.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S04.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S04.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S04.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S04ControlProvided getS04ControlProvided() {
			return s04ControlProvided;
		}
		
		public class S05ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S05.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S05.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S05.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S05.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S05.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S05.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S05.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S05ControlProvided getS05ControlProvided() {
			return s05ControlProvided;
		}
		
		public class S06ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S06.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S06.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S06.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S06.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S06.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S06.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S06.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S06ControlProvided getS06ControlProvided() {
			return s06ControlProvided;
		}
		
		public class S07ControlProvided implements ControlInterface.Provided {
		
			@Override
			public void raiseRestartProtocol() {
				S07.getControlProvided().raiseRestartProtocol();
			}
			
			@Override
			public boolean isRaisedEnableSection() {
				return S07.getControlProvided().isRaisedEnableSection();
			}
			@Override
			public long getEnableSectionValue() {
				return S07.getControlProvided().getEnableSectionValue();
			}
			@Override
			public boolean isRaisedDisableSection() {
				return S07.getControlProvided().isRaisedDisableSection();
			}
			@Override
			public long getDisableSectionValue() {
				return S07.getControlProvided().getDisableSectionValue();
			}
			
			@Override
			public void registerListener(ControlInterface.Listener.Provided listener) {
				S07.getControlProvided().registerListener(listener);
			}
			
			@Override
			public List<ControlInterface.Listener.Provided> getRegisteredListeners() {
				return S07.getControlProvided().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S07ControlProvided getS07ControlProvided() {
			return s07ControlProvided;
		}
		
		public class S01TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S01.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S01.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S01.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S01.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S01TrainRequired getS01TrainRequired() {
			return s01TrainRequired;
		}
		
		public class T4TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				T4.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				T4.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				T4.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return T4.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public T4TrainRequired getT4TrainRequired() {
			return t4TrainRequired;
		}
		
		public class S04TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S04.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S04.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S04.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S04.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S04TrainRequired getS04TrainRequired() {
			return s04TrainRequired;
		}
		
		public class S05TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S05.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S05.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S05.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S05.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S05TrainRequired getS05TrainRequired() {
			return s05TrainRequired;
		}
		
		public class S06TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S06.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S06.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S06.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S06.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S06TrainRequired getS06TrainRequired() {
			return s06TrainRequired;
		}
		
		public class S07TrainRequired implements TrainInterface.Required {
		
			@Override
			public void raiseOccupy() {
				S07.getTrainRequired().raiseOccupy();
			}
			
			@Override
			public void raiseUnoccupy() {
				S07.getTrainRequired().raiseUnoccupy();
			}
			
			
			@Override
			public void registerListener(TrainInterface.Listener.Required listener) {
				S07.getTrainRequired().registerListener(listener);
			}
			
			@Override
			public List<TrainInterface.Listener.Required> getRegisteredListeners() {
				return S07.getTrainRequired().getRegisteredListeners();
			}
			
		}
		
		@Override
		public S07TrainRequired getS07TrainRequired() {
			return s07TrainRequired;
		}
		
		/** Changes the event and process queues of all component instances. Should be used only be the container (composite system) class. */
		public void changeEventQueues() {
			S01.changeEventQueues();
			S02.changeEventQueues();
			T4.changeEventQueues();
			S04.changeEventQueues();
			S05.changeEventQueues();
			S06.changeEventQueues();
			S07.changeEventQueues();
		}
		
		/** Returns whether all event queues of the contained component instances are empty. 
		Should be used only be the container (composite system) class. */
		public boolean isEventQueueEmpty() {
			return S01.isEventQueueEmpty() && S02.isEventQueueEmpty() && T4.isEventQueueEmpty() && S04.isEventQueueEmpty() && S05.isEventQueueEmpty() && S06.isEventQueueEmpty() && S07.isEventQueueEmpty();
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
			S01.runComponent();
			S02.runComponent();
			T4.runComponent();
			S04.runComponent();
			S05.runComponent();
			S06.runComponent();
			S07.runComponent();
		}

		
		/**  Getter for component instances, e.g. enabling to check their states. */
		public SectionStatechart getS01() {
			return S01;
		}
		
		public SectionStatechart getS02() {
			return S02;
		}
		
		public TurnoutStatechart getT4() {
			return T4;
		}
		
		public SectionStatechart getS04() {
			return S04;
		}
		
		public SectionStatechart getS05() {
			return S05;
		}
		
		public SectionStatechart getS06() {
			return S06;
		}
		
		public SectionStatechart getS07() {
			return S07;
		}
		
	}
