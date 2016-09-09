package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;

public class RemoteElement implements IYakinduMessageHandler {

	private int id;

	private ConnectionDirection localDirection;

	private ConnectionDirection remoteDirection;

	private IYakinduMessageHandler adapter;

	public RemoteElement(int id, ConnectionDirection localDirection, ConnectionDirection remoteDirection) {
		this.id = id;
		this.localDirection = localDirection;
		this.remoteDirection = remoteDirection;
		// adapter initialization
	}

	public void setAdapter(IYakinduMessageHandler adapter) {
		this.adapter = adapter;
	}

	public int getId() {
		return id;
	}

	public ConnectionDirection getLocalDirection() {
		return localDirection;
	}

	public ConnectionDirection getRemoteDirection() {
		return remoteDirection;
	}

	@Override
	public void reserveTo(int targetID, ConnectionDirection direction) {
		if (direction == localDirection) {
			adapter.reserveTo(targetID, remoteDirection);
		} else {
			throw new IllegalArgumentException("The reserve is from the wrong direction: " + direction);
		}
	}

	@Override
	public void releaseTo(int targetID, ConnectionDirection direction) {
		if (direction == localDirection) {
			adapter.releaseTo(targetID, remoteDirection);
		} else {
			throw new IllegalArgumentException("The release is from the wrong direction: " + direction);
		}
	}

	@Override
	public void reserveResultTo(int targetID, ConnectionDirection direction, boolean result) {
		if (direction == localDirection) {
			adapter.reserveResultTo(targetID, remoteDirection, result);
		} else {
			throw new IllegalArgumentException("The reserve result is from the wrong direction: " + direction);
		}
	}

}
