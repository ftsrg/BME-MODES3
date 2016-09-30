package org.yakindu.scr.section;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ISectionStatemachine extends IStatemachine {
	public interface SCISection {
		public boolean isRaisedEnableSection();

		public int getEnableSectionValue();

		public boolean isRaisedDisableSection();

		public int getDisableSectionValue();

		public int getId();

		public void setId(int value);

		public int getLatestReserveDirection();

		public void setLatestReserveDirection(int value);

		public int getNegatedReserveDirection();

		public void setNegatedReserveDirection(int value);

		public List<SCISectionListener> getListeners();

	}

	public interface SCISectionListener {
		public void onEnableSectionRaised(int value);

		public void onDisableSectionRaised(int value);
	}

	public SCISection getSCISection();

	public interface SCIProtocol {
		public void raiseReserveFrom(int value);

		public void raiseCanGoFrom(int value);

		public void raiseCannotGoFrom(int value);

		public void raiseReleaseFrom(int value);

		public void raiseRestartProtocol();

		public boolean isRaisedReserveTo();

		public int getReserveToValue();

		public boolean isRaisedCanGoTo();

		public int getCanGoToValue();

		public boolean isRaisedCannotGoTo();

		public int getCannotGoToValue();

		public boolean isRaisedReleaseTo();

		public int getReleaseToValue();

		public List<SCIProtocolListener> getListeners();

	}

	public interface SCIProtocolListener {
		public void onReserveToRaised(int value);

		public void onCanGoToRaised(int value);

		public void onCannotGoToRaised(int value);

		public void onReleaseToRaised(int value);
	}

	public SCIProtocol getSCIProtocol();

	public interface SCITrain {
		public void raiseOccupy();

		public void raiseUnoccupy();

	}

	public SCITrain getSCITrain();

	public interface SCIDirection {
		public static final int cW = 0;
		public static final int cCW = 1;
		public static final int uNSPECIFIED = 2;

		public int getCW();

		public int getCCW();

		public int getUNSPECIFIED();

	}

	public SCIDirection getSCIDirection();

}
