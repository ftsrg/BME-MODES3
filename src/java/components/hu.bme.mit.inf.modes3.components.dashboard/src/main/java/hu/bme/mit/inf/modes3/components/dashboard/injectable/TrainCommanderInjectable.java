package hu.bme.mit.inf.modes3.components.dashboard.injectable;

import java.lang.reflect.Type;

import org.atmosphere.cpr.AtmosphereConfig;
import org.atmosphere.inject.Injectable;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;

public class TrainCommanderInjectable implements Injectable<ITrainCommander>{

	ITrainCommander tec;
	
	public TrainCommanderInjectable() {
		tec = DashboardManager.INSTANCE.getLocator().getTrainCommander();
	}

	@Override
	public boolean supportedType(Type t) {
		return (t instanceof Class) && ITrainCommander.class.equals((Class) t);
	}

	@Override
	public ITrainCommander injectable(AtmosphereConfig config) {
		return tec;
	}

}
