package org.yakindu.scr.turnout;

import java.util.List;
import org.yakindu.scr.IStatemachine;

public interface ITurnoutStatemachine extends IStatemachine {
	public interface SCITurnout {
		public void raiseTurnoutStraight();

		public void raiseTurnoutDivergent();

		public int getId();

		public void setId(int value);

	}

	public SCITurnout getSCITurnout();

	public interface SCIProtocol {
		public void raiseReserveFrom(int value);

		public void raiseCanGoFrom(int value);

		public void raiseCannotGoFrom(int value);

		public void raiseReleaseFrom(int value);

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
		public static final int tOP = 0;
		public static final int sTRAIGHT = 1;
		public static final int dIVERGENT = 2;
		public static final int uNSPECIFIED = 3;

		public int getTOP();

		public int getSTRAIGHT();

		public int getDIVERGENT();

		public int getUNSPECIFIED();

	}

	public SCIDirection getSCIDirection();

}
