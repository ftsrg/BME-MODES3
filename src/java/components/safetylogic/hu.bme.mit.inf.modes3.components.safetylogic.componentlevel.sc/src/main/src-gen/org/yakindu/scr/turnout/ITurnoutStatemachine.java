package org.yakindu.scr.turnout;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ITurnoutStatemachine extends IStatemachine {
	public interface SCITurnout {
		public void raiseSwitch();

		public void raiseReserveFromLeft();

		public void raiseReserveFromRight();

		public void raiseReserveFromBottom();

		public void raiseReserveResultFromLeft(boolean value);

		public void raiseReserveResultFromRight(boolean value);

		public void raiseReserveResultFromBottom(boolean value);

		public void raiseReleaseFromLeft();

		public void raiseReleaseFromRight();

		public void raiseReleaseFromBottom();

		public boolean isRaisedReserveLeft();

		public boolean isRaisedReserveRight();

		public boolean isRaisedReserveBottom();

		public boolean isRaisedReserveResultToLeft();

		public boolean getReserveResultToLeftValue();

		public boolean isRaisedReserveResultToRight();

		public boolean getReserveResultToRightValue();

		public boolean isRaisedReserveResultToBottom();

		public boolean getReserveResultToBottomValue();

		public boolean isRaisedReleaseLeft();

		public boolean isRaisedReleaseRight();

		public boolean isRaisedReleaseBottom();

		public long getId();

		public void setId(long value);

		public long getCount();

		public void setCount(long value);

		public List<SCITurnoutListener> getListeners();

	}

	public interface SCITurnoutListener {
		public void onReserveLeftRaised();

		public void onReserveRightRaised();

		public void onReserveBottomRaised();

		public void onReserveResultToLeftRaised(boolean value);

		public void onReserveResultToRightRaised(boolean value);

		public void onReserveResultToBottomRaised(boolean value);

		public void onReleaseLeftRaised();

		public void onReleaseRightRaised();

		public void onReleaseBottomRaised();
	}

	public SCITurnout getSCITurnout();

}
