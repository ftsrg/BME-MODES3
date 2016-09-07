package org.yakindu.scr.section;

import java.util.List;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ISectionStatemachine extends ITimerCallback, IStatemachine {
	public interface SCISection {
		public void raiseReserveFromLeft();

		public void raiseReserveFromRight();

		public void raiseReserveResult(boolean value);

		public void raiseOccupy();

		public void raiseUnoccupy();

		public void raiseReset();

		public void raiseRelease();

		public boolean isRaisedReserveLeft();

		public boolean isRaisedReserveRight();

		public boolean isRaisedReserveResultToLeft();

		public boolean getReserveResultToLeftValue();

		public boolean isRaisedReserveResultToRight();

		public boolean getReserveResultToRightValue();

		public boolean isRaisedReleaseLeft();

		public boolean isRaisedReleaseRight();

		public boolean isRaisedStop();

		public long getId();

		public void setId(long value);

		public long getTimeout();

		public void setTimeout(long value);

		public long getDir();

		public void setDir(long value);

		public List<SCISectionListener> getListeners();

	}

	public interface SCISectionListener {
		public void onReserveLeftRaised();

		public void onReserveRightRaised();

		public void onReserveResultToLeftRaised(boolean value);

		public void onReserveResultToRightRaised(boolean value);

		public void onReleaseLeftRaised();

		public void onReleaseRightRaised();

		public void onStopRaised();
	}

	public SCISection getSCISection();

	public interface SCIDirection {
		public static final long lEFT = 0;
		public static final long rIGHT = 1;

		public long getLEFT();

		public long getRIGHT();

	}

	public SCIDirection getSCIDirection();

}
