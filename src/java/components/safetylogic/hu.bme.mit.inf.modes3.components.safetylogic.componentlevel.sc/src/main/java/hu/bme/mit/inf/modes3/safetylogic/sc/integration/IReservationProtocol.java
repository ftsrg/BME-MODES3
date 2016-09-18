package hu.bme.mit.inf.modes3.safetylogic.sc.integration;

public interface IReservationProtocol {

	void raiseReserveFrom(int value);

	void raiseCanGoFrom(int value);

	void raiseCannotGoFrom(int value);

	void raiseReleaseFrom(int value);

}
