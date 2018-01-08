package hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCanGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCannotGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReleaseTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReserveTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;

public class RemoteTrackElement implements INextTrackElement {

	protected final Logger logger;

	protected int remoteTrackElementId;

	protected IYakinduReleaseTo releaseToSender;
	protected IYakinduReserveTo reserveToSender;
	protected IYakinduCanGoTo canGoToSender;
	protected IYakinduCannotGoTo cannotGoToSender;

	public RemoteTrackElement(int remoteTrackElementId, IYakinduReleaseTo releaseToSender, IYakinduReserveTo reserveToSender, IYakinduCanGoTo canGoToSender,
			IYakinduCannotGoTo cannotGoToSender, ILoggerFactory factory) {
		this.remoteTrackElementId = remoteTrackElementId;
		this.releaseToSender = releaseToSender;
		this.reserveToSender = reserveToSender;
		this.canGoToSender = canGoToSender;
		this.cannotGoToSender = cannotGoToSender;
		this.logger = factory.getLogger(this.getClass().getName());
	}

	@Override
	public void raiseReserveFrom(int value) {
		logger.debug("ReserveFrom forwarded to remote with parameter " + value);
		reserveToSender.reserveTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

	@Override
	public void raiseCanGoFrom(int value) {
		logger.debug("CanGoFrom forwarded to remote with parameter " + value);
		canGoToSender.canGoTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		logger.debug("CannotGoFrom forwarded to remote with parameter " + value);
		cannotGoToSender.cannotGoTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

	@Override
	public void raiseReleaseFrom(int value) {
		logger.debug("ReleaseFrom forwarded to remote with parameter " + value);
		releaseToSender.releaseTo(remoteTrackElementId, ConnectionDirection.getDirectionByValue(value));
	}

}
