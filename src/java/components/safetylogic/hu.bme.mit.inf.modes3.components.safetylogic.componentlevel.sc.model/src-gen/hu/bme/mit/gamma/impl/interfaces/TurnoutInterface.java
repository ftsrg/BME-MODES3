package hu.bme.mit.gamma.impl.interfaces;

import java.util.List;

public interface TurnoutInterface {
	
	interface Provided extends Listener.Required {
		
		
		void registerListener(Listener.Provided listener);
		List<Listener.Provided> getRegisteredListeners();
	}
	
	interface Required extends Listener.Provided {
		
		public boolean isRaisedTurnoutStraight();
		public boolean isRaisedTurnoutDivergent();
		
		void registerListener(Listener.Required listener);
		List<Listener.Required> getRegisteredListeners();
	}
	
	interface Listener {
		
		interface Provided  {
		}
		
		interface Required   {
			void raiseTurnoutStraight();
			void raiseTurnoutDivergent();
		}
		
	}
} 
