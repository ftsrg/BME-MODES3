package org.yakindu.scr.turnout;
import java.util.List;

import org.yakindu.scr.turnout.TurnoutStatemachine.State;

/**
 * Runnable wrapper of TurnoutStatemachine. This wrapper provides a thread-safe
 * instance of the state machine.
 * 
 * Please report bugs and issues...
 */

public class SynchronizedTurnoutStatemachine implements ITurnoutStatemachine {
	
	/**
	 * The core state machine is simply wrapped and the event processing will be
	 * delegated to that state machine instance. This instance will be created
	 * implicitly.
	 */
	protected TurnoutStatemachine statemachine = new TurnoutStatemachine();
	
	/**
	 * Interface object for SCITurnout
	 */		
	protected class SynchronizedSCITurnout implements SCITurnout {
		
		public void raiseTurnoutStraight() {
			
			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseTurnoutStraight();
				statemachine.runCycle();
			}
		}
		
		public void raiseTurnoutDivergent() {
			
			synchronized (statemachine) {
				statemachine.getSCITurnout().raiseTurnoutDivergent();
				statemachine.runCycle();
			}
		}
		
		public long getId() {
			synchronized(statemachine) {
				return statemachine.getSCITurnout().getId();
			}
		}
		
	};
	
	protected SCITurnout sCITurnout;
	
	/**
	 * Interface object for SCIProtocolProvidedTop
	 */		
	protected class SynchronizedSCIProtocolProvidedTop implements SCIProtocolProvidedTop {
		
		public void raiseReserve() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedTop().raiseReserve();
				statemachine.runCycle();
			}
		}
		
		public void raiseCanGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedTop().raiseCanGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseCannotGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedTop().raiseCannotGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseRelease() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedTop().raiseRelease();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIProtocolProvidedTop sCIProtocolProvidedTop;
	
	/**
	 * Interface object for SCIProtocolRequiredTop
	 */		
	protected class SynchronizedSCIProtocolRequiredTop implements SCIProtocolRequiredTop {
		
		public List<SCIProtocolRequiredTopListener> getListeners() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredTop().getListeners();
			}
		}
		
		public boolean isRaisedReserve() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredTop().isRaisedReserve();
			}
		}
		
		public boolean isRaisedCanGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredTop().isRaisedCanGo();
			}
		}
		
		public boolean isRaisedCannotGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredTop().isRaisedCannotGo();
			}
		}
		
		public boolean isRaisedRelease() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredTop().isRaisedRelease();
			}
		}
		
	};
	
	protected SCIProtocolRequiredTop sCIProtocolRequiredTop;
	
	/**
	 * Interface object for SCIProtocolProvidedStraight
	 */		
	protected class SynchronizedSCIProtocolProvidedStraight implements SCIProtocolProvidedStraight {
		
		public void raiseReserve() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedStraight().raiseReserve();
				statemachine.runCycle();
			}
		}
		
		public void raiseCanGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedStraight().raiseCanGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseCannotGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedStraight().raiseCannotGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseRelease() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedStraight().raiseRelease();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIProtocolProvidedStraight sCIProtocolProvidedStraight;
	
	/**
	 * Interface object for SCIProtocolRequiredStraight
	 */		
	protected class SynchronizedSCIProtocolRequiredStraight implements SCIProtocolRequiredStraight {
		
		public List<SCIProtocolRequiredStraightListener> getListeners() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredStraight().getListeners();
			}
		}
		
		public boolean isRaisedReserve() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredStraight().isRaisedReserve();
			}
		}
		
		public boolean isRaisedCanGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredStraight().isRaisedCanGo();
			}
		}
		
		public boolean isRaisedCannotGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredStraight().isRaisedCannotGo();
			}
		}
		
		public boolean isRaisedRelease() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredStraight().isRaisedRelease();
			}
		}
		
	};
	
	protected SCIProtocolRequiredStraight sCIProtocolRequiredStraight;
	
	/**
	 * Interface object for SCIProtocolProvidedDivergent
	 */		
	protected class SynchronizedSCIProtocolProvidedDivergent implements SCIProtocolProvidedDivergent {
		
		public void raiseReserve() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedDivergent().raiseReserve();
				statemachine.runCycle();
			}
		}
		
		public void raiseCanGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedDivergent().raiseCanGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseCannotGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedDivergent().raiseCannotGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseRelease() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedDivergent().raiseRelease();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIProtocolProvidedDivergent sCIProtocolProvidedDivergent;
	
	/**
	 * Interface object for SCIProtocolRequiredDivergent
	 */		
	protected class SynchronizedSCIProtocolRequiredDivergent implements SCIProtocolRequiredDivergent {
		
		public List<SCIProtocolRequiredDivergentListener> getListeners() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredDivergent().getListeners();
			}
		}
		
		public boolean isRaisedReserve() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredDivergent().isRaisedReserve();
			}
		}
		
		public boolean isRaisedCanGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredDivergent().isRaisedCanGo();
			}
		}
		
		public boolean isRaisedCannotGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredDivergent().isRaisedCannotGo();
			}
		}
		
		public boolean isRaisedRelease() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredDivergent().isRaisedRelease();
			}
		}
		
	};
	
	protected SCIProtocolRequiredDivergent sCIProtocolRequiredDivergent;
	
	/**
	 * Interface object for SCITrainRequired
	 */		
	protected class SynchronizedSCITrainRequired implements SCITrainRequired {
		
		public void raiseOccupy() {
			
			synchronized (statemachine) {
				statemachine.getSCITrainRequired().raiseOccupy();
				statemachine.runCycle();
			}
		}
		
		public void raiseUnoccupy() {
			
			synchronized (statemachine) {
				statemachine.getSCITrainRequired().raiseUnoccupy();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCITrainRequired sCITrainRequired;
	
	/**
	 * Interface object for SCIDirection
	 */		
	protected class SynchronizedSCIDirection implements SCIDirection {
		
		public long getTOP() {
			synchronized(statemachine) {
				return statemachine.getSCIDirection().getTOP();
			}
		}
		
		public long getSTRAIGHT() {
			synchronized(statemachine) {
				return statemachine.getSCIDirection().getSTRAIGHT();
			}
		}
		
		public long getDIVERGENT() {
			synchronized(statemachine) {
				return statemachine.getSCIDirection().getDIVERGENT();
			}
		}
		
	};
	
	protected SCIDirection sCIDirection;
	
	public SynchronizedTurnoutStatemachine() {
		sCITurnout = new SynchronizedSCITurnout();
		sCIProtocolProvidedTop = new SynchronizedSCIProtocolProvidedTop();
		sCIProtocolRequiredTop = new SynchronizedSCIProtocolRequiredTop();
		sCIProtocolProvidedStraight = new SynchronizedSCIProtocolProvidedStraight();
		sCIProtocolRequiredStraight = new SynchronizedSCIProtocolRequiredStraight();
		sCIProtocolProvidedDivergent = new SynchronizedSCIProtocolProvidedDivergent();
		sCIProtocolRequiredDivergent = new SynchronizedSCIProtocolRequiredDivergent();
		sCITrainRequired = new SynchronizedSCITrainRequired();
		sCIDirection = new SynchronizedSCIDirection();
	}
	
	public synchronized SCITurnout getSCITurnout() {
		return sCITurnout;
	}
	public synchronized SCIProtocolProvidedTop getSCIProtocolProvidedTop() {
		return sCIProtocolProvidedTop;
	}
	public synchronized SCIProtocolRequiredTop getSCIProtocolRequiredTop() {
		return sCIProtocolRequiredTop;
	}
	public synchronized SCIProtocolProvidedStraight getSCIProtocolProvidedStraight() {
		return sCIProtocolProvidedStraight;
	}
	public synchronized SCIProtocolRequiredStraight getSCIProtocolRequiredStraight() {
		return sCIProtocolRequiredStraight;
	}
	public synchronized SCIProtocolProvidedDivergent getSCIProtocolProvidedDivergent() {
		return sCIProtocolProvidedDivergent;
	}
	public synchronized SCIProtocolRequiredDivergent getSCIProtocolRequiredDivergent() {
		return sCIProtocolRequiredDivergent;
	}
	public synchronized SCITrainRequired getSCITrainRequired() {
		return sCITrainRequired;
	}
	public synchronized SCIDirection getSCIDirection() {
		return sCIDirection;
	}
	
	/**
	 * init() will be delegated thread-safely to the wrapped state machine.
	 */
	public void init() {
		synchronized(statemachine) {
			statemachine.init();
		}
	}
	
	/**
	 * enter() will be delegated thread-safely to the wrapped state machine.
	 */
	public void enter() {
		synchronized(statemachine) {
			statemachine.enter();
		}
	}
	
	/**
	 * exit() will be delegated thread-safely to the wrapped state machine.
	 */
	public void exit() {
		synchronized(statemachine) {
			statemachine.exit();
		}
	}
	
	/**
	 * isActive() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isActive() {
		synchronized(statemachine) {
			return statemachine.isActive();
		}
	}
	
	/**
	 * isFinal() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isFinal() {
		synchronized(statemachine) {
			return statemachine.isFinal();
		}
	}
	
	/**
	 * isStateActive() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isStateActive(State state) {
		synchronized(statemachine) {
			return statemachine.isStateActive(state);
		}
	}
	
	/**
	 * runCycle() will be delegated thread-safely to the wrapped state machine.
	 */ 
	@Override
	public void runCycle() {
		synchronized (statemachine) {
			statemachine.runCycle();
		}
	}
}
