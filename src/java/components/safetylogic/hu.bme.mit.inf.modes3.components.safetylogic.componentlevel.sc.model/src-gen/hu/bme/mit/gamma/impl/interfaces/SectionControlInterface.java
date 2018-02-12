package hu.bme.mit.gamma.impl.interfaces;

import java.util.List;

public interface SectionControlInterface {
	
	interface Provided extends Listener.Required {
		
		public boolean isRaisedDisableSection();
		public boolean isRaisedEnableSection();
		
		void registerListener(Listener.Provided listener);
		List<Listener.Provided> getRegisteredListeners();
	}
	
	interface Required extends Listener.Provided {
		
		public boolean isRaisedRestartProtocol();
		
		void registerListener(Listener.Required listener);
		List<Listener.Required> getRegisteredListeners();
	}
	
	interface Listener {
		
		interface Provided  {
			void raiseDisableSection();
			void raiseEnableSection();
		}
		
		interface Required   {
			void raiseRestartProtocol();
		}
		
	}
} 
