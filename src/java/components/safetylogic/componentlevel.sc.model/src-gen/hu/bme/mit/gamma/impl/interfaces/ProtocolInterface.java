package hu.bme.mit.gamma.impl.interfaces;

import java.util.List;

public interface ProtocolInterface {
	
	interface Provided extends Listener.Required {
		
		
		void registerListener(Listener.Provided listener);
		List<Listener.Provided> getRegisteredListeners();
	}
	
	interface Required extends Listener.Provided {
		
		public boolean isRaisedRelease();
		public boolean isRaisedCanGo();
		public boolean isRaisedCannotGo();
		public boolean isRaisedReserve();
		
		void registerListener(Listener.Required listener);
		List<Listener.Required> getRegisteredListeners();
	}
	
	interface Listener {
		
		interface Provided  {
		}
		
		interface Required   {
			void raiseRelease();
			void raiseCanGo();
			void raiseCannotGo();
			void raiseReserve();
		}
		
	}
} 
