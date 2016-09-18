package hu.bme.mit.inf.modes3.safetylogic.sc.linkage;

public interface INextTrackElement {

	void raiseReserveFrom(int value);

	void raiseCanGoFrom(int value);

	void raiseCannotGoFrom(int value);

	void raiseReleaseFrom(int value);

}
