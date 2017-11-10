package org.yakindu.scr.turnout;

import java.util.LinkedList;
import java.util.List;

public class TurnoutStatemachine implements ITurnoutStatemachine {

	protected class SCITurnoutImpl implements SCITurnout {

		private boolean turnoutStraight;

		public void raiseTurnoutStraight() {
			turnoutStraight = true;
		}

		private boolean turnoutDivergent;

		public void raiseTurnoutDivergent() {
			turnoutDivergent = true;
		}

		private int id;

		public int getId() {
			return id;
		}

		public void setId(int value) {
			this.id = value;
		}

		protected void clearEvents() {
			turnoutStraight = false;
			turnoutDivergent = false;
		}

	}

	protected SCITurnoutImpl sCITurnout;

	protected class SCIProtocolImpl implements SCIProtocol {

		private List<SCIProtocolListener> listeners = new LinkedList<SCIProtocolListener>();

		public List<SCIProtocolListener> getListeners() {
			return listeners;
		}

		private boolean reserveFrom;

		private int reserveFromValue;

		public void raiseReserveFrom(int value) {
			reserveFrom = true;
			reserveFromValue = value;
		}

		protected int getReserveFromValue() {
			if (!reserveFrom)
				throw new IllegalStateException("Illegal event value access. Event ReserveFrom is not raised!");
			return reserveFromValue;
		}

		private boolean canGoFrom;

		private int canGoFromValue;

		public void raiseCanGoFrom(int value) {
			canGoFrom = true;
			canGoFromValue = value;
		}

		protected int getCanGoFromValue() {
			if (!canGoFrom)
				throw new IllegalStateException("Illegal event value access. Event CanGoFrom is not raised!");
			return canGoFromValue;
		}

		private boolean cannotGoFrom;

		private int cannotGoFromValue;

		public void raiseCannotGoFrom(int value) {
			cannotGoFrom = true;
			cannotGoFromValue = value;
		}

		protected int getCannotGoFromValue() {
			if (!cannotGoFrom)
				throw new IllegalStateException("Illegal event value access. Event CannotGoFrom is not raised!");
			return cannotGoFromValue;
		}

		private boolean releaseFrom;

		private int releaseFromValue;

		public void raiseReleaseFrom(int value) {
			releaseFrom = true;
			releaseFromValue = value;
		}

		protected int getReleaseFromValue() {
			if (!releaseFrom)
				throw new IllegalStateException("Illegal event value access. Event ReleaseFrom is not raised!");
			return releaseFromValue;
		}

		private boolean reserveTo;

		private int reserveToValue;

		public boolean isRaisedReserveTo() {
			return reserveTo;
		}

		protected void raiseReserveTo(int value) {
			reserveTo = true;
			reserveToValue = value;
			for (SCIProtocolListener listener : listeners) {
				listener.onReserveToRaised(value);
			}
		}

		public int getReserveToValue() {
			if (!reserveTo)
				throw new IllegalStateException("Illegal event value access. Event ReserveTo is not raised!");
			return reserveToValue;
		}

		private boolean canGoTo;

		private int canGoToValue;

		public boolean isRaisedCanGoTo() {
			return canGoTo;
		}

		protected void raiseCanGoTo(int value) {
			canGoTo = true;
			canGoToValue = value;
			for (SCIProtocolListener listener : listeners) {
				listener.onCanGoToRaised(value);
			}
		}

		public int getCanGoToValue() {
			if (!canGoTo)
				throw new IllegalStateException("Illegal event value access. Event CanGoTo is not raised!");
			return canGoToValue;
		}

		private boolean cannotGoTo;

		private int cannotGoToValue;

		public boolean isRaisedCannotGoTo() {
			return cannotGoTo;
		}

		protected void raiseCannotGoTo(int value) {
			cannotGoTo = true;
			cannotGoToValue = value;
			for (SCIProtocolListener listener : listeners) {
				listener.onCannotGoToRaised(value);
			}
		}

		public int getCannotGoToValue() {
			if (!cannotGoTo)
				throw new IllegalStateException("Illegal event value access. Event CannotGoTo is not raised!");
			return cannotGoToValue;
		}

		private boolean releaseTo;

		private int releaseToValue;

		public boolean isRaisedReleaseTo() {
			return releaseTo;
		}

		protected void raiseReleaseTo(int value) {
			releaseTo = true;
			releaseToValue = value;
			for (SCIProtocolListener listener : listeners) {
				listener.onReleaseToRaised(value);
			}
		}

		public int getReleaseToValue() {
			if (!releaseTo)
				throw new IllegalStateException("Illegal event value access. Event ReleaseTo is not raised!");
			return releaseToValue;
		}

		protected void clearEvents() {
			reserveFrom = false;
			canGoFrom = false;
			cannotGoFrom = false;
			releaseFrom = false;
		}

		protected void clearOutEvents() {
			reserveTo = false;
			canGoTo = false;
			cannotGoTo = false;
			releaseTo = false;
		}
	}

	protected SCIProtocolImpl sCIProtocol;

	protected class SCITrainImpl implements SCITrain {

		private boolean occupy;

		public void raiseOccupy() {
			occupy = true;
		}

		private boolean unoccupy;

		public void raiseUnoccupy() {
			unoccupy = true;
		}

		protected void clearEvents() {
			occupy = false;
			unoccupy = false;
		}

	}

	protected SCITrainImpl sCITrain;

	protected class SCIDirectionImpl implements SCIDirection {

		public int getTOP() {
			return tOP;
		}

		public int getSTRAIGHT() {
			return sTRAIGHT;
		}

		public int getDIVERGENT() {
			return dIVERGENT;
		}

		public int getUNSPECIFIED() {
			return uNSPECIFIED;
		}

	}

	protected SCIDirectionImpl sCIDirection;

	private boolean initialized = false;

	public enum State {
		main_region_Straight, main_region_Straight_listening_to_top_Waiting, main_region_Straight_listening_to_top_ReservationFromTop, main_region_Straight_listening_to_straight_Waiting, main_region_Straight_listening_to_straight_ReservationFromStraight, main_region_Straight_listening_to_occupy_Free, main_region_Straight_listening_to_occupy_Occupied, main_region_Straight_listening_to_release_TransferReleases, main_region_Divergent, main_region_Divergent_listening_to_top_Waiting, main_region_Divergent_listening_to_top_ReservationFromTop, main_region_Divergent_listening_to_divergent_Waiting, main_region_Divergent_listening_to_divergent_ReservationFromDivergent, main_region_Divergent_listening_to_occupy_Free, main_region_Divergent_listening_to_occupy_Occupied, main_region_Divergent_listening_to_release_TransferReleases, $NullState$
	};

	private final State[] stateVector = new State[4];

	private int nextStateIndex;

	public TurnoutStatemachine() {

		sCITurnout = new SCITurnoutImpl();
		sCIProtocol = new SCIProtocolImpl();
		sCITrain = new SCITrainImpl();
		sCIDirection = new SCIDirectionImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 4; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCITurnout.setId(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException("The state machine needs to be initialized first by calling the init() function.");

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;

		nextStateIndex = 1;
		stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;

		sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);

		sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

		nextStateIndex = 2;
		stateVector[2] = State.main_region_Straight_listening_to_occupy_Free;

		nextStateIndex = 3;
		stateVector[3] = State.main_region_Straight_listening_to_release_TransferReleases;
	}

	public void exit() {
		switch (stateVector[0]) {
		case main_region_Straight_listening_to_top_Waiting:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_Straight_listening_to_top_ReservationFromTop:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_top_Waiting:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_top_ReservationFromTop:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		default:
			break;
		}

		switch (stateVector[1]) {
		case main_region_Straight_listening_to_straight_Waiting:
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;
			break;

		case main_region_Straight_listening_to_straight_ReservationFromStraight:
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_divergent_Waiting:
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;
			break;

		default:
			break;
		}

		switch (stateVector[2]) {
		case main_region_Straight_listening_to_occupy_Free:
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;
			break;

		case main_region_Straight_listening_to_occupy_Occupied:
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_occupy_Free:
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_occupy_Occupied:
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;
			break;

		default:
			break;
		}

		switch (stateVector[3]) {
		case main_region_Straight_listening_to_release_TransferReleases:
			nextStateIndex = 3;
			stateVector[3] = State.$NullState$;
			break;

		case main_region_Divergent_listening_to_release_TransferReleases:
			nextStateIndex = 3;
			stateVector[3] = State.$NullState$;
			break;

		default:
			break;
		}
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$ || stateVector[1] != State.$NullState$ || stateVector[2] != State.$NullState$
				|| stateVector[3] != State.$NullState$;
	}

	/**
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal()
	 */
	public boolean isFinal() {
		return false;
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCITurnout.clearEvents();
		sCIProtocol.clearEvents();
		sCITrain.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCIProtocol.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
		case main_region_Straight:
			return stateVector[0].ordinal() >= State.main_region_Straight.ordinal()
					&& stateVector[0].ordinal() <= State.main_region_Straight_listening_to_release_TransferReleases.ordinal();
		case main_region_Straight_listening_to_top_Waiting:
			return stateVector[0] == State.main_region_Straight_listening_to_top_Waiting;
		case main_region_Straight_listening_to_top_ReservationFromTop:
			return stateVector[0] == State.main_region_Straight_listening_to_top_ReservationFromTop;
		case main_region_Straight_listening_to_straight_Waiting:
			return stateVector[1] == State.main_region_Straight_listening_to_straight_Waiting;
		case main_region_Straight_listening_to_straight_ReservationFromStraight:
			return stateVector[1] == State.main_region_Straight_listening_to_straight_ReservationFromStraight;
		case main_region_Straight_listening_to_occupy_Free:
			return stateVector[2] == State.main_region_Straight_listening_to_occupy_Free;
		case main_region_Straight_listening_to_occupy_Occupied:
			return stateVector[2] == State.main_region_Straight_listening_to_occupy_Occupied;
		case main_region_Straight_listening_to_release_TransferReleases:
			return stateVector[3] == State.main_region_Straight_listening_to_release_TransferReleases;
		case main_region_Divergent:
			return stateVector[0].ordinal() >= State.main_region_Divergent.ordinal()
					&& stateVector[0].ordinal() <= State.main_region_Divergent_listening_to_release_TransferReleases.ordinal();
		case main_region_Divergent_listening_to_top_Waiting:
			return stateVector[0] == State.main_region_Divergent_listening_to_top_Waiting;
		case main_region_Divergent_listening_to_top_ReservationFromTop:
			return stateVector[0] == State.main_region_Divergent_listening_to_top_ReservationFromTop;
		case main_region_Divergent_listening_to_divergent_Waiting:
			return stateVector[1] == State.main_region_Divergent_listening_to_divergent_Waiting;
		case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
			return stateVector[1] == State.main_region_Divergent_listening_to_divergent_ReservationFromDivergent;
		case main_region_Divergent_listening_to_occupy_Free:
			return stateVector[2] == State.main_region_Divergent_listening_to_occupy_Free;
		case main_region_Divergent_listening_to_occupy_Occupied:
			return stateVector[2] == State.main_region_Divergent_listening_to_occupy_Occupied;
		case main_region_Divergent_listening_to_release_TransferReleases:
			return stateVector[3] == State.main_region_Divergent_listening_to_release_TransferReleases;
		default:
			return false;
		}
	}

	public SCITurnout getSCITurnout() {
		return sCITurnout;
	}

	public SCIProtocol getSCIProtocol() {
		return sCIProtocol;
	}

	public SCITrain getSCITrain() {
		return sCITrain;
	}

	public SCIDirection getSCIDirection() {
		return sCIDirection;
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_top_Waiting() {
		if (sCITurnout.turnoutDivergent) {
			switch (stateVector[0]) {
			case main_region_Straight_listening_to_top_Waiting:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Straight_listening_to_top_ReservationFromTop:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[1]) {
			case main_region_Straight_listening_to_straight_Waiting:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Straight_listening_to_straight_ReservationFromStraight:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[2]) {
			case main_region_Straight_listening_to_occupy_Free:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case main_region_Straight_listening_to_occupy_Occupied:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[3]) {
			case main_region_Straight_listening_to_release_TransferReleases:
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			default:
				break;
			}

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			sCIProtocol.raiseReleaseTo(sCIDirection.dIVERGENT);

			sCIProtocol.raiseCannotGoTo(sCIDirection.sTRAIGHT);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Divergent_listening_to_top_Waiting;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Divergent_listening_to_divergent_Waiting;

			sCIProtocol.raiseReleaseTo(sCIDirection.dIVERGENT);

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Divergent_listening_to_occupy_Free;

			nextStateIndex = 3;
			stateVector[3] = State.main_region_Divergent_listening_to_release_TransferReleases;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.dIVERGENT)) {
				sCIProtocol.raiseCannotGoTo(sCIDirection.dIVERGENT);
			}

			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.tOP)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIProtocol.raiseReserveTo(sCIDirection.sTRAIGHT);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Straight_listening_to_top_ReservationFromTop;
			}
		}
	}

	/* The reactions of state ReservationFromTop. */
	private void react_main_region_Straight_listening_to_top_ReservationFromTop() {
		if (sCITurnout.turnoutDivergent) {
			switch (stateVector[0]) {
			case main_region_Straight_listening_to_top_Waiting:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Straight_listening_to_top_ReservationFromTop:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[1]) {
			case main_region_Straight_listening_to_straight_Waiting:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Straight_listening_to_straight_ReservationFromStraight:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[2]) {
			case main_region_Straight_listening_to_occupy_Free:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case main_region_Straight_listening_to_occupy_Occupied:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[3]) {
			case main_region_Straight_listening_to_release_TransferReleases:
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			default:
				break;
			}

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			sCIProtocol.raiseReleaseTo(sCIDirection.dIVERGENT);

			sCIProtocol.raiseCannotGoTo(sCIDirection.sTRAIGHT);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Divergent_listening_to_top_Waiting;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Divergent_listening_to_divergent_Waiting;

			sCIProtocol.raiseReleaseTo(sCIDirection.dIVERGENT);

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Divergent_listening_to_occupy_Free;

			nextStateIndex = 3;
			stateVector[3] = State.main_region_Divergent_listening_to_release_TransferReleases;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.dIVERGENT)) {
				sCIProtocol.raiseCannotGoTo(sCIDirection.dIVERGENT);
			}

			if ((sCIProtocol.canGoFrom) && (sCIProtocol.getCanGoFromValue() == sCIDirection.sTRAIGHT)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIProtocol.raiseCanGoTo(sCIDirection.tOP);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;
			} else {
				if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.sTRAIGHT)) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIProtocol.raiseCannotGoTo(sCIDirection.tOP);

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;
				}
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Straight_listening_to_straight_Waiting() {
		if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.sTRAIGHT)) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			sCIProtocol.raiseReserveTo(sCIDirection.tOP);

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Straight_listening_to_straight_ReservationFromStraight;
		}
	}

	/* The reactions of state ReservationFromStraight. */
	private void react_main_region_Straight_listening_to_straight_ReservationFromStraight() {
		if ((sCIProtocol.canGoFrom) && (sCIProtocol.getCanGoFromValue() == sCIDirection.tOP)) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			sCIProtocol.raiseCanGoTo(sCIDirection.sTRAIGHT);

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;
		} else {
			if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.tOP)) {
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;

				sCIProtocol.raiseCannotGoTo(sCIDirection.sTRAIGHT);

				nextStateIndex = 1;
				stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;
			}
		}
	}

	/* The reactions of state Free. */
	private void react_main_region_Straight_listening_to_occupy_Free() {
		if (sCITrain.occupy) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			sCIProtocol.raiseReserveTo(sCIDirection.sTRAIGHT);

			sCIProtocol.raiseReserveTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Straight_listening_to_occupy_Occupied;
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_region_Straight_listening_to_occupy_Occupied() {
		if (sCITrain.unoccupy) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Straight_listening_to_occupy_Free;
		}
	}

	/* The reactions of state TransferReleases. */
	private void react_main_region_Straight_listening_to_release_TransferReleases() {
		if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.sTRAIGHT)) {
			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);
		}

		if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.tOP)) {
			sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_top_Waiting() {
		if (sCITurnout.turnoutStraight) {
			switch (stateVector[0]) {
			case main_region_Divergent_listening_to_top_Waiting:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Divergent_listening_to_top_ReservationFromTop:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[1]) {
			case main_region_Divergent_listening_to_divergent_Waiting:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[2]) {
			case main_region_Divergent_listening_to_occupy_Free:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case main_region_Divergent_listening_to_occupy_Occupied:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[3]) {
			case main_region_Divergent_listening_to_release_TransferReleases:
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			default:
				break;
			}

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);

			sCIProtocol.raiseCannotGoTo(sCIDirection.dIVERGENT);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;

			sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Straight_listening_to_occupy_Free;

			nextStateIndex = 3;
			stateVector[3] = State.main_region_Straight_listening_to_release_TransferReleases;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.sTRAIGHT)) {
				sCIProtocol.raiseCannotGoTo(sCIDirection.sTRAIGHT);
			}

			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.tOP)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIProtocol.raiseReserveTo(sCIDirection.dIVERGENT);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Divergent_listening_to_top_ReservationFromTop;
			}
		}
	}

	/* The reactions of state ReservationFromTop. */
	private void react_main_region_Divergent_listening_to_top_ReservationFromTop() {
		if (sCITurnout.turnoutStraight) {
			switch (stateVector[0]) {
			case main_region_Divergent_listening_to_top_Waiting:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Divergent_listening_to_top_ReservationFromTop:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[1]) {
			case main_region_Divergent_listening_to_divergent_Waiting:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[2]) {
			case main_region_Divergent_listening_to_occupy_Free:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case main_region_Divergent_listening_to_occupy_Occupied:
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default:
				break;
			}

			switch (stateVector[3]) {
			case main_region_Divergent_listening_to_release_TransferReleases:
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			default:
				break;
			}

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);

			sCIProtocol.raiseCannotGoTo(sCIDirection.dIVERGENT);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_Straight_listening_to_top_Waiting;

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Straight_listening_to_straight_Waiting;

			sCIProtocol.raiseReleaseTo(sCIDirection.sTRAIGHT);

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Straight_listening_to_occupy_Free;

			nextStateIndex = 3;
			stateVector[3] = State.main_region_Straight_listening_to_release_TransferReleases;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.sTRAIGHT)) {
				sCIProtocol.raiseCannotGoTo(sCIDirection.sTRAIGHT);
			}

			if ((sCIProtocol.canGoFrom) && (sCIProtocol.getCanGoFromValue() == sCIDirection.dIVERGENT)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIProtocol.raiseCanGoTo(sCIDirection.tOP);

				nextStateIndex = 0;
				stateVector[0] = State.main_region_Divergent_listening_to_top_Waiting;
			} else {
				if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.dIVERGENT)) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIProtocol.raiseCannotGoTo(sCIDirection.tOP);

					nextStateIndex = 0;
					stateVector[0] = State.main_region_Divergent_listening_to_top_Waiting;
				}
			}
		}
	}

	/* The reactions of state Waiting. */
	private void react_main_region_Divergent_listening_to_divergent_Waiting() {
		if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.dIVERGENT)) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			sCIProtocol.raiseReserveTo(sCIDirection.tOP);

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Divergent_listening_to_divergent_ReservationFromDivergent;
		}
	}

	/* The reactions of state ReservationFromDivergent. */
	private void react_main_region_Divergent_listening_to_divergent_ReservationFromDivergent() {
		if ((sCIProtocol.canGoFrom) && (sCIProtocol.getCanGoFromValue() == sCIDirection.tOP)) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			sCIProtocol.raiseCanGoTo(sCIDirection.dIVERGENT);

			nextStateIndex = 1;
			stateVector[1] = State.main_region_Divergent_listening_to_divergent_Waiting;
		} else {
			if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.tOP)) {
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;

				sCIProtocol.raiseCannotGoTo(sCIDirection.dIVERGENT);

				nextStateIndex = 1;
				stateVector[1] = State.main_region_Divergent_listening_to_divergent_Waiting;
			}
		}
	}

	/* The reactions of state Free. */
	private void react_main_region_Divergent_listening_to_occupy_Free() {
		if (sCITrain.occupy) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			sCIProtocol.raiseReserveTo(sCIDirection.dIVERGENT);

			sCIProtocol.raiseReserveTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Divergent_listening_to_occupy_Occupied;
		}
	}

	/* The reactions of state Occupied. */
	private void react_main_region_Divergent_listening_to_occupy_Occupied() {
		if (sCITrain.unoccupy) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			sCIProtocol.raiseReleaseTo(sCIDirection.dIVERGENT);

			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);

			nextStateIndex = 2;
			stateVector[2] = State.main_region_Divergent_listening_to_occupy_Free;
		}
	}

	/* The reactions of state TransferReleases. */
	private void react_main_region_Divergent_listening_to_release_TransferReleases() {
		if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.dIVERGENT)) {
			sCIProtocol.raiseReleaseTo(sCIDirection.tOP);
		}

		if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.tOP)) {
			sCIProtocol.raiseReleaseTo(sCIDirection.dIVERGENT);
		}
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException("The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
			case main_region_Straight_listening_to_top_Waiting:
				react_main_region_Straight_listening_to_top_Waiting();
				break;
			case main_region_Straight_listening_to_top_ReservationFromTop:
				react_main_region_Straight_listening_to_top_ReservationFromTop();
				break;
			case main_region_Straight_listening_to_straight_Waiting:
				react_main_region_Straight_listening_to_straight_Waiting();
				break;
			case main_region_Straight_listening_to_straight_ReservationFromStraight:
				react_main_region_Straight_listening_to_straight_ReservationFromStraight();
				break;
			case main_region_Straight_listening_to_occupy_Free:
				react_main_region_Straight_listening_to_occupy_Free();
				break;
			case main_region_Straight_listening_to_occupy_Occupied:
				react_main_region_Straight_listening_to_occupy_Occupied();
				break;
			case main_region_Straight_listening_to_release_TransferReleases:
				react_main_region_Straight_listening_to_release_TransferReleases();
				break;
			case main_region_Divergent_listening_to_top_Waiting:
				react_main_region_Divergent_listening_to_top_Waiting();
				break;
			case main_region_Divergent_listening_to_top_ReservationFromTop:
				react_main_region_Divergent_listening_to_top_ReservationFromTop();
				break;
			case main_region_Divergent_listening_to_divergent_Waiting:
				react_main_region_Divergent_listening_to_divergent_Waiting();
				break;
			case main_region_Divergent_listening_to_divergent_ReservationFromDivergent:
				react_main_region_Divergent_listening_to_divergent_ReservationFromDivergent();
				break;
			case main_region_Divergent_listening_to_occupy_Free:
				react_main_region_Divergent_listening_to_occupy_Free();
				break;
			case main_region_Divergent_listening_to_occupy_Occupied:
				react_main_region_Divergent_listening_to_occupy_Occupied();
				break;
			case main_region_Divergent_listening_to_release_TransferReleases:
				react_main_region_Divergent_listening_to_release_TransferReleases();
				break;
			default:
				// $NullState$
			}
		}

		clearEvents();
	}
}
