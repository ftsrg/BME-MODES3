package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler;

public class YakinduHandlerHolder {

	protected IYakinduReleaseTo releaseToSender;
	protected IYakinduReserveTo reserveToSender;
	protected IYakinduCanGoTo canGoToSender;
	protected IYakinduCannotGoTo cannotGoToSender;

	public YakinduHandlerHolder(IYakinduReleaseTo releaseToSender, IYakinduReserveTo reserveToSender, IYakinduCanGoTo canGoToSender,
			IYakinduCannotGoTo cannotGoToSender) {
		this.releaseToSender = releaseToSender;
		this.reserveToSender = reserveToSender;
		this.canGoToSender = canGoToSender;
		this.cannotGoToSender = cannotGoToSender;
	}

	public IYakinduReleaseTo getReleaseToSender() {
		return releaseToSender;
	}

	public void setReleaseToSender(IYakinduReleaseTo releaseToSender) {
		this.releaseToSender = releaseToSender;
	}

	public IYakinduReserveTo getReserveToSender() {
		return reserveToSender;
	}

	public void setReserveToSender(IYakinduReserveTo reserveToSender) {
		this.reserveToSender = reserveToSender;
	}

	public IYakinduCanGoTo getCanGoToSender() {
		return canGoToSender;
	}

	public void setCanGoToSender(IYakinduCanGoTo canGoToSender) {
		this.canGoToSender = canGoToSender;
	}

	public IYakinduCannotGoTo getCannotGoToSender() {
		return cannotGoToSender;
	}

	public void setCannotGoToSender(IYakinduCannotGoTo cannotGoToSender) {
		this.cannotGoToSender = cannotGoToSender;
	}

}
