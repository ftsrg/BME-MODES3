package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class RemoteElement {

	// the LOCAL's id used for sensing the occupation of the referred element
	protected int id;

	// the REMOTE can reach the LOCAL from this direction
	protected ConnectionDirection remoteDirection;

	// forwards calls to the network
	protected IYakinduMessageHandler adapter;

	public RemoteElement(int id, ConnectionDirection remoteDirection, IYakinduMessageHandler adapter) {
		this.id = id;
		this.remoteDirection = remoteDirection;
		this.adapter = adapter;
	}

	public void reserveToRemote() {
		adapter.reserveTo(id, remoteDirection);
	}

	public void releaseToRemote() {
		adapter.releaseTo(id, remoteDirection);
	}

	public void reserveResultToRemote(boolean result) {
		adapter.reserveResultTo(id, remoteDirection, result);
	}
}
