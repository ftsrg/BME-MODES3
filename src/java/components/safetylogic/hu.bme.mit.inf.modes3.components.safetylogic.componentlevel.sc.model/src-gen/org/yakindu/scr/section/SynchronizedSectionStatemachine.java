package org.yakindu.scr.section;
import java.util.List;

import org.yakindu.scr.section.SectionStatemachine.State;

/**
 * Runnable wrapper of SectionStatemachine. This wrapper provides a thread-safe
 * instance of the state machine.
 * 
 * Please report bugs and issues...
 */

public class SynchronizedSectionStatemachine implements ISectionStatemachine {
	
	/**
	 * The core state machine is simply wrapped and the event processing will be
	 * delegated to that state machine instance. This instance will be created
	 * implicitly.
	 */
	protected SectionStatemachine statemachine = new SectionStatemachine();
	
	/**
	 * Interface object for SCISection
	 */		
	protected class SynchronizedSCISection implements SCISection {
		
		public long getLatestReserveDirection() {
			synchronized(statemachine) {
				return statemachine.getSCISection().getLatestReserveDirection();
			}
		}
		
		public void setLatestReserveDirection(final long value) {
			synchronized(statemachine) {
				statemachine.getSCISection().setLatestReserveDirection(value);
			}
		}
		
	};
	
	protected SCISection sCISection;
	
	/**
	 * Interface object for SCISectionControlProvided
	 */		
	protected class SynchronizedSCISectionControlProvided implements SCISectionControlProvided {
		
		public List<SCISectionControlProvidedListener> getListeners() {
			synchronized(statemachine) {
				return statemachine.getSCISectionControlProvided().getListeners();
			}
		}
		
		public void raiseRestartProtocol() {
			
			synchronized (statemachine) {
				statemachine.getSCISectionControlProvided().raiseRestartProtocol();
				statemachine.runCycle();
			}
		}
		
		public boolean isRaisedEnableSection() {
			synchronized(statemachine) {
				return statemachine.getSCISectionControlProvided().isRaisedEnableSection();
			}
		}
		
		public boolean isRaisedDisableSection() {
			synchronized(statemachine) {
				return statemachine.getSCISectionControlProvided().isRaisedDisableSection();
			}
		}
		
	};
	
	protected SCISectionControlProvided sCISectionControlProvided;
	
	/**
	 * Interface object for SCIProtocolProvidedCW
	 */		
	protected class SynchronizedSCIProtocolProvidedCW implements SCIProtocolProvidedCW {
		
		public void raiseReserve() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCW().raiseReserve();
				statemachine.runCycle();
			}
		}
		
		public void raiseCanGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCW().raiseCanGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseCannotGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCW().raiseCannotGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseRelease() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCW().raiseRelease();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIProtocolProvidedCW sCIProtocolProvidedCW;
	
	/**
	 * Interface object for SCIProtocolProvidedCCW
	 */		
	protected class SynchronizedSCIProtocolProvidedCCW implements SCIProtocolProvidedCCW {
		
		public void raiseReserve() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCCW().raiseReserve();
				statemachine.runCycle();
			}
		}
		
		public void raiseCanGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCCW().raiseCanGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseCannotGo() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCCW().raiseCannotGo();
				statemachine.runCycle();
			}
		}
		
		public void raiseRelease() {
			
			synchronized (statemachine) {
				statemachine.getSCIProtocolProvidedCCW().raiseRelease();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIProtocolProvidedCCW sCIProtocolProvidedCCW;
	
	/**
	 * Interface object for SCIProtocolRequiredCW
	 */		
	protected class SynchronizedSCIProtocolRequiredCW implements SCIProtocolRequiredCW {
		
		public List<SCIProtocolRequiredCWListener> getListeners() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCW().getListeners();
			}
		}
		
		public boolean isRaisedReserve() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCW().isRaisedReserve();
			}
		}
		
		public boolean isRaisedCanGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCW().isRaisedCanGo();
			}
		}
		
		public boolean isRaisedCannotGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCW().isRaisedCannotGo();
			}
		}
		
		public boolean isRaisedRelease() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCW().isRaisedRelease();
			}
		}
		
	};
	
	protected SCIProtocolRequiredCW sCIProtocolRequiredCW;
	
	/**
	 * Interface object for SCIProtocolRequiredCCW
	 */		
	protected class SynchronizedSCIProtocolRequiredCCW implements SCIProtocolRequiredCCW {
		
		public List<SCIProtocolRequiredCCWListener> getListeners() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCCW().getListeners();
			}
		}
		
		public boolean isRaisedReserve() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCCW().isRaisedReserve();
			}
		}
		
		public boolean isRaisedCanGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCCW().isRaisedCanGo();
			}
		}
		
		public boolean isRaisedCannotGo() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCCW().isRaisedCannotGo();
			}
		}
		
		public boolean isRaisedRelease() {
			synchronized(statemachine) {
				return statemachine.getSCIProtocolRequiredCCW().isRaisedRelease();
			}
		}
		
	};
	
	protected SCIProtocolRequiredCCW sCIProtocolRequiredCCW;
	
	/**
	 * Interface object for SCITrainProvided
	 */		
	protected class SynchronizedSCITrainProvided implements SCITrainProvided {
		
		public void raiseOccupy() {
			
			synchronized (statemachine) {
				statemachine.getSCITrainProvided().raiseOccupy();
				statemachine.runCycle();
			}
		}
		
		public void raiseUnoccupy() {
			
			synchronized (statemachine) {
				statemachine.getSCITrainProvided().raiseUnoccupy();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCITrainProvided sCITrainProvided;
	
	/**
	 * Interface object for SCIDirection
	 */		
	protected class SynchronizedSCIDirection implements SCIDirection {
		
		public long getCW() {
			synchronized(statemachine) {
				return statemachine.getSCIDirection().getCW();
			}
		}
		
		public long getCCW() {
			synchronized(statemachine) {
				return statemachine.getSCIDirection().getCCW();
			}
		}
		
		public long getUNSPECIFIED() {
			synchronized(statemachine) {
				return statemachine.getSCIDirection().getUNSPECIFIED();
			}
		}
		
	};
	
	protected SCIDirection sCIDirection;
	
	public SynchronizedSectionStatemachine() {
		sCISection = new SynchronizedSCISection();
		sCISectionControlProvided = new SynchronizedSCISectionControlProvided();
		sCIProtocolProvidedCW = new SynchronizedSCIProtocolProvidedCW();
		sCIProtocolProvidedCCW = new SynchronizedSCIProtocolProvidedCCW();
		sCIProtocolRequiredCW = new SynchronizedSCIProtocolRequiredCW();
		sCIProtocolRequiredCCW = new SynchronizedSCIProtocolRequiredCCW();
		sCITrainProvided = new SynchronizedSCITrainProvided();
		sCIDirection = new SynchronizedSCIDirection();
	}
	
	public synchronized SCISection getSCISection() {
		return sCISection;
	}
	public synchronized SCISectionControlProvided getSCISectionControlProvided() {
		return sCISectionControlProvided;
	}
	public synchronized SCIProtocolProvidedCW getSCIProtocolProvidedCW() {
		return sCIProtocolProvidedCW;
	}
	public synchronized SCIProtocolProvidedCCW getSCIProtocolProvidedCCW() {
		return sCIProtocolProvidedCCW;
	}
	public synchronized SCIProtocolRequiredCW getSCIProtocolRequiredCW() {
		return sCIProtocolRequiredCW;
	}
	public synchronized SCIProtocolRequiredCCW getSCIProtocolRequiredCCW() {
		return sCIProtocolRequiredCCW;
	}
	public synchronized SCITrainProvided getSCITrainProvided() {
		return sCITrainProvided;
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
