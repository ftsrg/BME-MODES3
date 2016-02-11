package hu.bme.mit.inf.xpresscontroller;

public enum Train {
	DBAG(8), TAURUS(9), SNCF(10);
	
	private final int address;
	
	Train(final int address) {
		this.address = address;
	}
	
	public int getAddress() { return address; }
};