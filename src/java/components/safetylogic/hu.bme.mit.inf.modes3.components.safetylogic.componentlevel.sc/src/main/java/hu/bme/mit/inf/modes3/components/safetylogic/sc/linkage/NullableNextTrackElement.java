package hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage;

import org.slf4j.ILoggerFactory;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionHolder;

public class NullableNextTrackElement extends NextTrackElementWrapper {

	public NullableNextTrackElement(ILoggerFactory factory) {
		super(new ConnectionDirectionHolder(ConnectionDirection.UNSPECIFIED, ConnectionDirection.UNSPECIFIED), factory);
		super.nextTrackElement = this;
	}

	@Override
	public void raiseReserveFrom(int value) {
		// intentionally left blank
	}

	@Override
	public void raiseCanGoFrom(int value) {
		// intentionally left blank
	}

	@Override
	public void raiseCannotGoFrom(int value) {
		// intentionally left blank
	}

	@Override
	public void raiseReleaseFrom(int value) {
		// intentionally left blank
	}

}
