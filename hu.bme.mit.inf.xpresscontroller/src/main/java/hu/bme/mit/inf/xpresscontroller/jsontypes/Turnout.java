package hu.bme.mit.inf.xpresscontroller.jsontypes;

public class Turnout {
	int id;
	boolean straight;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean isStraight() {
		return straight;
	}
	public void setStraight(boolean straight) {
		this.straight = straight;
	}
}
