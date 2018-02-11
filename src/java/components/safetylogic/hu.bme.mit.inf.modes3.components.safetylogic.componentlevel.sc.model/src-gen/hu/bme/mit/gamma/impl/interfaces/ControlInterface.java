package hu.bme.mit.gamma.impl.interfaces;

import java.util.List;

public interface ControlInterface {
	
	interface Provided extends Listener.Required {
		
		public boolean isRaisedEnableSection();
		public long getEnableSectionValue();
		public boolean isRaisedDisableSection();
		public long getDisableSectionValue();
		
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
			void raiseEnableSection(long value);
			void raiseDisableSection(long value);
		}
		
		interface Required   {
			void raiseRestartProtocol();
		}
		
	}
} 
