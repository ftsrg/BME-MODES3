package hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCanGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCannotGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReleaseTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReserveTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;

public class RemoteTrackElement implements INextTrackElement {

	protected int remoteTrackElementId;

	protected IYakinduReleaseTo releaseToSender;
	protected IYakinduReserveTo reserveToSender;
	protected IYakinduCanGoTo canGoToSender;
	protected IYakinduCannotGoTo cannotGoToSender;

	public RemoteTrackElement(int remoteTrackElementId, IYakinduReleaseTo releaseToSender, IYakinduReserveTo reserveToSender, IYakinduCanGoTo canGoToSender,
			IYakinduCannotGoTo cannotGoToSender) {
		this.remoteTrackElementId = remoteTrackElementId;
		this.releaseToSender = releaseToSender;
		this.reserveToSender = reserveToSender;
		this.canGoToSender = canGoToSender;
		this.cannotGoToSender = cannotGoToSender;
	}

	@Override
	public void raiseReserveFrom(int value) {
		reserveToSender.reserveTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

	@Override
	public void raiseCanGoFrom(int value) {
		canGoToSender.canGoTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		cannotGoToSender.cannotGoTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

	@Override
	public void raiseReleaseFrom(int value) {
		releaseToSender.releaseTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

}
