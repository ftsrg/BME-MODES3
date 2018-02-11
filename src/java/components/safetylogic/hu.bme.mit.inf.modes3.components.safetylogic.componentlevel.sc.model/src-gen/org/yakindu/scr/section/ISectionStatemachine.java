package org.yakindu.scr.section;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ISectionStatemachine extends IStatemachine {

	public interface SCISection {
	
		public static final long id = 0;
	
		public long getId();
		
		public long getLatestReserveDirection();
		
		public void setLatestReserveDirection(long value);
		
		public long getNegatedReserveDirection();
		
		public void setNegatedReserveDirection(long value);
		
	}
	
	public SCISection getSCISection();
	
	public interface SCIControlProvided {
	
		public void raiseRestartProtocol();
		
		public boolean isRaisedEnableSection();
		
		public long getEnableSectionValue();
		
		public boolean isRaisedDisableSection();
		
		public long getDisableSectionValue();
		
	public List<SCIControlProvidedListener> getListeners();
	}
	
	public interface SCIControlProvidedListener {
	
		public void onEnableSectionRaised(long value);
		public void onDisableSectionRaised(long value);
		}
	
	public SCIControlProvided getSCIControlProvided();
	
	public interface SCIProtocolProvidedCW {
	
		public void raiseReserve();
		
		public void raiseCanGo();
		
		public void raiseCannotGo();
		
		public void raiseRelease();
		
	}
	
	public SCIProtocolProvidedCW getSCIProtocolProvidedCW();
	
	public interface SCIProtocolProvidedCCW {
	
		public void raiseReserve();
		
		public void raiseCanGo();
		
		public void raiseCannotGo();
		
		public void raiseRelease();
		
	}
	
	public SCIProtocolProvidedCCW getSCIProtocolProvidedCCW();
	
	public interface SCIProtocolRequiredCW {
	
		public boolean isRaisedReserve();
		
		public boolean isRaisedCanGo();
		
		public boolean isRaisedCannotGo();
		
		public boolean isRaisedRelease();
		
	public List<SCIProtocolRequiredCWListener> getListeners();
	}
	
	public interface SCIProtocolRequiredCWListener {
	
		public void onReserveRaised();
		public void onCanGoRaised();
		public void onCannotGoRaised();
		public void onReleaseRaised();
		}
	
	public SCIProtocolRequiredCW getSCIProtocolRequiredCW();
	
	public interface SCIProtocolRequiredCCW {
	
		public boolean isRaisedReserve();
		
		public boolean isRaisedCanGo();
		
		public boolean isRaisedCannotGo();
		
		public boolean isRaisedRelease();
		
	public List<SCIProtocolRequiredCCWListener> getListeners();
	}
	
	public interface SCIProtocolRequiredCCWListener {
	
		public void onReserveRaised();
		public void onCanGoRaised();
		public void onCannotGoRaised();
		public void onReleaseRaised();
		}
	
	public SCIProtocolRequiredCCW getSCIProtocolRequiredCCW();
	
	public interface SCITrainRequired {
	
		public void raiseOccupy();
		
		public void raiseUnoccupy();
		
	}
	
	public SCITrainRequired getSCITrainRequired();
	
	public interface SCIDirection {
	
		public static final long cW = 0;
	
		public static final long cCW = 1;
	
		public static final long uNSPECIFIED = 2;
	
		public long getCW();
		
		public long getCCW();
		
		public long getUNSPECIFIED();
		
	}
	
	public SCIDirection getSCIDirection();
	
}
