package hu.bme.mit.inf.xpresscontroller.jsontypes;

public class Root {
	Train train;
	Turnout turnout;

	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}

	public Turnout getTurnout() {
		return turnout;
	}
	public void setTurnout(Turnout turnout) {
		this.turnout = turnout;
	}
}
