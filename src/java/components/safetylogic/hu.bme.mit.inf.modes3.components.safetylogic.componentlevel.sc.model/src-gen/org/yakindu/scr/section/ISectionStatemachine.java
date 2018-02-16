package org.yakindu.scr.section;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ISectionStatemachine extends IStatemachine {

	public interface SCISection {
	
		public long getLatestReserveDirection();
		
		public void setLatestReserveDirection(long value);
		
	}
	
	public SCISection getSCISection();
	
	public interface SCISectionControlProvided {
	
		public void raiseRestartProtocol();
		
		public boolean isRaisedEnableSection();
		
		public boolean isRaisedDisableSection();
		
	public List<SCISectionControlProvidedListener> getListeners();
	}
	
	public interface SCISectionControlProvidedListener {
	
		public void onEnableSectionRaised();
		public void onDisableSectionRaised();
		}
	
	public SCISectionControlProvided getSCISectionControlProvided();
	
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
	
	public interface SCITrainProvided {
	
		public void raiseOccupy();
		
		public void raiseUnoccupy();
		
	}
	
	public SCITrainProvided getSCITrainProvided();
	
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
