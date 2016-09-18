package org.yakindu.scr.section;

import java.util.LinkedList;
import java.util.List;

public class SectionStatemachine implements ISectionStatemachine {

	protected class SCISectionImpl implements SCISection {

		private List<SCISectionListener> listeners = new LinkedList<SCISectionListener>();

		public List<SCISectionListener> getListeners() {
			return listeners;
		}

		private boolean enableSection;

		private int enableSectionValue;

		public boolean isRaisedEnableSection() {
			return enableSection;
		}

		protected void raiseEnableSection(int value) {
			enableSection = true;
			enableSectionValue = value;
			for (SCISectionListener listener : listeners) {
				listener.onEnableSectionRaised(value);
			}
		}

		public int getEnableSectionValue() {
			if (!enableSection)
				throw new IllegalStateException("Illegal event value access. Event EnableSection is not raised!");
			return enableSectionValue;
		}

		private boolean disableSection;

		private int disableSectionValue;

		public boolean isRaisedDisableSection() {
			return disableSection;
		}

		protected void raiseDisableSection(int value) {
			disableSection = true;
			disableSectionValue = value;
			for (SCISectionListener listener : listeners) {
				listener.onDisableSectionRaised(value);
			}
		}

		public int getDisableSectionValue() {
			if (!disableSection)
				throw new IllegalStateException("Illegal event value access. Event DisableSection is not raised!");
			return disableSectionValue;
		}

		private int id;

		public int getId() {
			return id;
		}

		public void setId(int value) {
			this.id = value;
		}

		private int latestReserveDirection;

		public int getLatestReserveDirection() {
			return latestReserveDirection;
		}

		public void setLatestReserveDirection(int value) {
			this.latestReserveDirection = value;
		}

		private int negatedReserveDirection;

		public int getNegatedReserveDirection() {
			return negatedReserveDirection;
		}

		public void setNegatedReserveDirection(int value) {
			this.negatedReserveDirection = value;
		}

		protected void clearEvents() {
		}

		protected void clearOutEvents() {
			enableSection = false;
			disableSection = false;
		}
	}

	protected SCISectionImpl sCISection;

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

		private boolean restartProtocol;

		public void raiseRestartProtocol() {
			restartProtocol = true;
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
			restartProtocol = false;
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

		public int getCW() {
			return cW;
		}

		public int getCCW() {
			return cCW;
		}

		public int getUNSPECIFIED() {
			return uNSPECIFIED;
		}

	}

	protected SCIDirectionImpl sCIDirection;

	private boolean initialized = false;

	public enum State {
		_1_Free, _1_Reserved, _1_Occupied, _1_Stop, _1_Locking_protocol, _1_Locking_protocol_inner_region_WaitForFirstResponse, _1_Locking_protocol_inner_region_WaitForSecondResponse, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public SectionStatemachine() {

		sCISection = new SCISectionImpl();
		sCIProtocol = new SCIProtocolImpl();
		sCITrain = new SCITrainImpl();
		sCIDirection = new SCIDirectionImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCISection.setId(0);

		sCISection.setLatestReserveDirection(0);

		sCISection.setNegatedReserveDirection(0);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException("The state machine needs to be initialized first by calling the init() function.");

		sCISection.raiseEnableSection(sCISection.id);

		sCISection.setLatestReserveDirection(sCIDirection.uNSPECIFIED);

		sCISection.setNegatedReserveDirection(sCIDirection.uNSPECIFIED);

		nextStateIndex = 0;
		stateVector[0] = State._1_Free;
	}

	public void exit() {
		switch (stateVector[0]) {
		case _1_Free:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case _1_Reserved:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case _1_Occupied:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case _1_Stop:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case _1_Locking_protocol_inner_region_WaitForFirstResponse:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		case _1_Locking_protocol_inner_region_WaitForSecondResponse:
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			break;

		default:
			break;
		}
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
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
		sCISection.clearEvents();
		sCIProtocol.clearEvents();
		sCITrain.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCISection.clearOutEvents();
		sCIProtocol.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
		case _1_Free:
			return stateVector[0] == State._1_Free;
		case _1_Reserved:
			return stateVector[0] == State._1_Reserved;
		case _1_Occupied:
			return stateVector[0] == State._1_Occupied;
		case _1_Stop:
			return stateVector[0] == State._1_Stop;
		case _1_Locking_protocol:
			return stateVector[0].ordinal() >= State._1_Locking_protocol.ordinal()
					&& stateVector[0].ordinal() <= State._1_Locking_protocol_inner_region_WaitForSecondResponse.ordinal();
		case _1_Locking_protocol_inner_region_WaitForFirstResponse:
			return stateVector[0] == State._1_Locking_protocol_inner_region_WaitForFirstResponse;
		case _1_Locking_protocol_inner_region_WaitForSecondResponse:
			return stateVector[0] == State._1_Locking_protocol_inner_region_WaitForSecondResponse;
		default:
			return false;
		}
	}

	public SCISection getSCISection() {
		return sCISection;
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

	/* The reactions of state Free. */
	private void react__1_Free() {
		if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cW)) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIProtocol.raiseCanGoTo(sCIDirection.cCW);

			sCISection.setLatestReserveDirection(sCIDirection.cW);

			sCISection.setNegatedReserveDirection(sCIDirection.cCW);

			nextStateIndex = 0;
			stateVector[0] = State._1_Reserved;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cCW)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIProtocol.raiseCanGoTo(sCIDirection.cW);

				sCISection.setLatestReserveDirection(sCIDirection.cCW);

				sCISection.setNegatedReserveDirection(sCIDirection.cW);

				nextStateIndex = 0;
				stateVector[0] = State._1_Reserved;
			} else {
				if (sCITrain.occupy) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIProtocol.raiseReserveTo(sCIDirection.cCW);

					nextStateIndex = 0;
					stateVector[0] = State._1_Locking_protocol_inner_region_WaitForFirstResponse;
				}
			}
		}
	}

	/* The reactions of state Reserved. */
	private void react__1_Reserved() {
		if (sCITrain.occupy) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIProtocol.raiseReserveTo(sCIDirection.cCW);

			nextStateIndex = 0;
			stateVector[0] = State._1_Locking_protocol_inner_region_WaitForFirstResponse;
		} else {
			if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCISection.latestReserveDirection)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseEnableSection(sCISection.id);

				sCISection.setLatestReserveDirection(sCIDirection.uNSPECIFIED);

				sCISection.setNegatedReserveDirection(sCIDirection.uNSPECIFIED);

				nextStateIndex = 0;
				stateVector[0] = State._1_Free;
			} else {
				if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCISection.latestReserveDirection)) {
					sCIProtocol.raiseCanGoTo(sCISection.negatedReserveDirection);
				}

				if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() != sCISection.latestReserveDirection)) {
					sCIProtocol.raiseCanGoTo(sCISection.negatedReserveDirection);
				}
			}
		}
	}

	/* The reactions of state Occupied. */
	private void react__1_Occupied() {
		if (sCITrain.unoccupy) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIProtocol.raiseReleaseTo(sCIDirection.cW);

			sCIProtocol.raiseReleaseTo(sCIDirection.cCW);

			sCISection.raiseEnableSection(sCISection.id);

			sCISection.setLatestReserveDirection(sCIDirection.uNSPECIFIED);

			sCISection.setNegatedReserveDirection(sCIDirection.uNSPECIFIED);

			nextStateIndex = 0;
			stateVector[0] = State._1_Free;
		} else {
			if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.cCW)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISection.raiseDisableSection(sCISection.id);

				nextStateIndex = 0;
				stateVector[0] = State._1_Stop;
			} else {
				if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.cW)) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCISection.raiseDisableSection(sCISection.id);

					nextStateIndex = 0;
					stateVector[0] = State._1_Stop;
				} else {
					if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cCW)) {
						sCIProtocol.raiseCanGoTo(sCIDirection.cW);
					}

					if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cW)) {
						sCIProtocol.raiseCanGoTo(sCIDirection.cCW);
					}

					if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.cCW)) {
						sCIProtocol.raiseReserveTo(sCIDirection.cW);
					}

					if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.cW)) {
						sCIProtocol.raiseReserveTo(sCIDirection.cCW);
					}
				}
			}
		}
	}

	/* The reactions of state Stop. */
	private void react__1_Stop() {
		if (sCITrain.unoccupy) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIProtocol.raiseReleaseTo(sCIDirection.cW);

			sCIProtocol.raiseReleaseTo(sCIDirection.cCW);

			sCISection.raiseEnableSection(sCISection.id);

			sCISection.setLatestReserveDirection(sCIDirection.uNSPECIFIED);

			sCISection.setNegatedReserveDirection(sCIDirection.uNSPECIFIED);

			nextStateIndex = 0;
			stateVector[0] = State._1_Free;
		} else {
			if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.cCW)) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCIProtocol.raiseReserveTo(sCIDirection.cCW);

				nextStateIndex = 0;
				stateVector[0] = State._1_Locking_protocol_inner_region_WaitForFirstResponse;
			} else {
				if ((sCIProtocol.releaseFrom) && (sCIProtocol.getReleaseFromValue() == sCIDirection.cW)) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIProtocol.raiseReserveTo(sCIDirection.cCW);

					nextStateIndex = 0;
					stateVector[0] = State._1_Locking_protocol_inner_region_WaitForFirstResponse;
				} else {
					if (sCIProtocol.restartProtocol) {
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;

						sCIProtocol.raiseReserveTo(sCIDirection.cCW);

						nextStateIndex = 0;
						stateVector[0] = State._1_Locking_protocol_inner_region_WaitForFirstResponse;
					} else {
						if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cCW)) {
							sCIProtocol.raiseCannotGoTo(sCIDirection.cW);
						}

						if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cW)) {
							sCIProtocol.raiseCannotGoTo(sCIDirection.cCW);
						}
					}
				}
			}
		}
	}

	/* The reactions of state WaitForFirstResponse. */
	private void react__1_Locking_protocol_inner_region_WaitForFirstResponse() {
		if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cCW)) {
			switch (stateVector[0]) {
			case _1_Locking_protocol_inner_region_WaitForFirstResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case _1_Locking_protocol_inner_region_WaitForSecondResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			sCIProtocol.raiseCannotGoTo(sCIDirection.cW);

			sCISection.raiseDisableSection(sCISection.id);

			nextStateIndex = 0;
			stateVector[0] = State._1_Stop;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cW)) {
				switch (stateVector[0]) {
				case _1_Locking_protocol_inner_region_WaitForFirstResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case _1_Locking_protocol_inner_region_WaitForSecondResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default:
					break;
				}

				sCIProtocol.raiseCannotGoTo(sCIDirection.cCW);

				sCISection.raiseDisableSection(sCISection.id);

				nextStateIndex = 0;
				stateVector[0] = State._1_Stop;
			} else {
				if ((sCIProtocol.canGoFrom) && (sCIProtocol.getCanGoFromValue() == sCIDirection.cW)) {
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;

					sCIProtocol.raiseReserveTo(sCIDirection.cW);

					nextStateIndex = 0;
					stateVector[0] = State._1_Locking_protocol_inner_region_WaitForSecondResponse;
				} else {
					if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.cW)) {
						switch (stateVector[0]) {
						case _1_Locking_protocol_inner_region_WaitForFirstResponse:
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case _1_Locking_protocol_inner_region_WaitForSecondResponse:
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						default:
							break;
						}

						sCIProtocol.raiseReserveTo(sCIDirection.cW);

						sCISection.raiseDisableSection(sCISection.id);

						nextStateIndex = 0;
						stateVector[0] = State._1_Stop;
					}
				}
			}
		}
	}

	/* The reactions of state WaitForSecondResponse. */
	private void react__1_Locking_protocol_inner_region_WaitForSecondResponse() {
		if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cCW)) {
			switch (stateVector[0]) {
			case _1_Locking_protocol_inner_region_WaitForFirstResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case _1_Locking_protocol_inner_region_WaitForSecondResponse:
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default:
				break;
			}

			sCIProtocol.raiseCannotGoTo(sCIDirection.cW);

			sCISection.raiseDisableSection(sCISection.id);

			nextStateIndex = 0;
			stateVector[0] = State._1_Stop;
		} else {
			if ((sCIProtocol.reserveFrom) && (sCIProtocol.getReserveFromValue() == sCIDirection.cW)) {
				switch (stateVector[0]) {
				case _1_Locking_protocol_inner_region_WaitForFirstResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				case _1_Locking_protocol_inner_region_WaitForSecondResponse:
					nextStateIndex = 0;
					stateVector[0] = State.$NullState$;
					break;

				default:
					break;
				}

				sCIProtocol.raiseCannotGoTo(sCIDirection.cCW);

				sCISection.raiseDisableSection(sCISection.id);

				nextStateIndex = 0;
				stateVector[0] = State._1_Stop;
			} else {
				if ((sCIProtocol.canGoFrom) && (sCIProtocol.getCanGoFromValue() == sCIDirection.cCW)) {
					switch (stateVector[0]) {
					case _1_Locking_protocol_inner_region_WaitForFirstResponse:
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					case _1_Locking_protocol_inner_region_WaitForSecondResponse:
						nextStateIndex = 0;
						stateVector[0] = State.$NullState$;
						break;

					default:
						break;
					}

					sCISection.raiseEnableSection(sCISection.id);

					nextStateIndex = 0;
					stateVector[0] = State._1_Occupied;
				} else {
					if ((sCIProtocol.cannotGoFrom) && (sCIProtocol.getCannotGoFromValue() == sCIDirection.cCW)) {
						switch (stateVector[0]) {
						case _1_Locking_protocol_inner_region_WaitForFirstResponse:
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						case _1_Locking_protocol_inner_region_WaitForSecondResponse:
							nextStateIndex = 0;
							stateVector[0] = State.$NullState$;
							break;

						default:
							break;
						}

						sCISection.raiseDisableSection(sCISection.id);

						nextStateIndex = 0;
						stateVector[0] = State._1_Stop;
					}
				}
			}
		}
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException("The state machine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
			case _1_Free:
				react__1_Free();
				break;
			case _1_Reserved:
				react__1_Reserved();
				break;
			case _1_Occupied:
				react__1_Occupied();
				break;
			case _1_Stop:
				react__1_Stop();
				break;
			case _1_Locking_protocol_inner_region_WaitForFirstResponse:
				react__1_Locking_protocol_inner_region_WaitForFirstResponse();
				break;
			case _1_Locking_protocol_inner_region_WaitForSecondResponse:
				react__1_Locking_protocol_inner_region_WaitForSecondResponse();
				break;
			default:
				// $NullState$
			}
		}

		clearEvents();
	}
}
