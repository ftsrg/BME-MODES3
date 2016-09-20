package hu.bme.mit.inf.modes3.safetylogic.sc.util;

public class ConnectionDirectionHolder {

	protected ConnectionDirection first;
	protected ConnectionDirection second;

	public ConnectionDirectionHolder(ConnectionDirection first, ConnectionDirection second) {
		this.first = first;
		this.second = second;
	}

	public ConnectionDirection getFirst() {
		return first;
	}

	public ConnectionDirection getSecond() {
		return second;
	}



}
