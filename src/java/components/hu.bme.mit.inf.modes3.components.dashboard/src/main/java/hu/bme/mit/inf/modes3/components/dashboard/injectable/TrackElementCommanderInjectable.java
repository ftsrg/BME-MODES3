package hu.bme.mit.inf.modes3.components.dashboard.injectable;

import java.lang.reflect.Type;

import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.inject.Injectable;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander;

public class TrackElementCommanderInjectable implements Injectable<ITrackElementCommander>{

	ITrackElementCommander tec;
	
	public TrackElementCommanderInjectable() {
		tec = DashboardManager.INSTANCE.getLocator().getTrackElementCommander();
	}

	@Override
	public boolean supportedType(Type t) {
		return (t instanceof Class) && ITrackElementCommander.class.equals((Class) t);
	}

	@Override
	public ITrackElementCommander injectable(AtmosphereConfig config) {
		return tec;
	}

}
