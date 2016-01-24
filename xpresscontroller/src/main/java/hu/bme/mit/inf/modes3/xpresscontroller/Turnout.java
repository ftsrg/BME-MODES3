package hu.bme.mit.inf.modes3.xpresscontroller;

public enum Turnout {
	TURNOUT_1("T0081"), TURNOUT_2("T0082"), TURNOUT_3("T0083"), TURNOUT_4("T0086"), TURNOUT_5("T0084"), TURNOUT_6("T0085"), TURNOUT_7("T0087");
	
	private final String address;
	
	Turnout(final String address) {
		this.address = address;
	}
	
	public String getAddress() { return address; }
};
