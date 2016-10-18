package hu.bme.mit.inf.modes3.components.dashboard.service;

import javax.inject.Inject;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.Singleton;
import org.atmosphere.cpr.MetaBroadcaster;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeed;

@Singleton
@ManagedService(path = "/ws/trainspeed")
public class TrainSpeedService {
		
	private TrainReferenceSpeed.Builder builder;
	
	public TrainSpeedService() {
		builder = TrainReferenceSpeed.newBuilder().clear();
	}
	
	@Inject
	ITrackElementCommander commander;
	
	@Inject
	protected MetaBroadcaster metaBroadcaster;
	
	@Message
	public void onMessage(String message) {
		try {
			JsonFormat.parser().merge(message, builder.clear());
		} catch (InvalidProtocolBufferException e) {
			DashboardManager.INSTANCE.getLogger().error("Unable to parse TrainReferenceSpeed message: " + message);
			e.printStackTrace();
		}
		TrainReferenceSpeed sm = builder.build();
		commander.setTrainReferenceSpeedAndDirection(sm.getTrainID(), sm.getReferenceSpeed(), TrainDirection.valueOf(sm.getDirection().name()));
		System.out.println(message);
	}
	
}
