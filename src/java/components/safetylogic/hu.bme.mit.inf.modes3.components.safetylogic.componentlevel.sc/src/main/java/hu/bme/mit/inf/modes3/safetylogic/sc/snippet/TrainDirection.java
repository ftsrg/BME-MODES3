package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

public enum TrainDirection {

	LEFT(0), RIGHT(1);

	protected int value;

	TrainDirection(int value) {
		this.value = value;
	}
}
