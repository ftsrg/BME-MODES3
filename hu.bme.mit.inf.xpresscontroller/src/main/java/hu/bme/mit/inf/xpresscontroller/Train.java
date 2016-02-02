package hu.bme.mit.inf.xpresscontroller;

public enum Train {
	TAURUS(9), SNCF(10), DBAG(8);
	
	private final int address;
	
	Train(final int address) {
		this.address = address;
	}
	
	public int getAddress() { return address; }
};