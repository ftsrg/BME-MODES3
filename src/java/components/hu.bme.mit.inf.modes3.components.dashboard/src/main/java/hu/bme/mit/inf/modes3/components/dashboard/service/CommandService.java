package hu.bme.mit.inf.modes3.components.dashboard.service;

import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.SEGMENT_STATE;
import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.TRAIN_SPEED;
import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.TURNOUT_STATE;

import javax.inject.Inject;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.Message;
import org.atmosphere.config.service.PathParam;
import org.atmosphere.config.service.Singleton;
import org.atmosphere.cpr.MetaBroadcaster;
import org.slf4j.Logger;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.proto.dispatcher.ProtobufEnumTransformator;
import hu.bme.mit.inf.modes3.messaging.proto.messages.SegmentState;
import hu.bme.mit.inf.modes3.messaging.proto.messages.TrainReferenceSpeed;
import hu.bme.mit.inf.modes3.messaging.proto.messages.TurnoutState;

@Singleton
@ManagedService(path = "/ws/command/{target}")
public class CommandService {

	Logger logger = DashboardManager.INSTANCE.getLoggerFactory().getLogger(CommandService.class.getName());

	private TrainReferenceSpeed.Builder trainSpeedBuilder;
	private SegmentState.Builder segmentState;
	private TurnoutState.Builder turnoutState;

	public CommandService() {
		trainSpeedBuilder = TrainReferenceSpeed.newBuilder();
		segmentState = SegmentState.newBuilder();
		turnoutState = TurnoutState.newBuilder();
	}

	@Inject
	ITrackElementCommander commander;
	
	@Inject
	ITrainCommander trainCommander;

	@Inject
	protected MetaBroadcaster metaBroadcaster;

	@PathParam("target")
	protected String target;

	@Message
	public void onMessage(String message) {
		try {
			switch (target) {
			case TRAIN_SPEED:
				JsonFormat.parser().merge(message, trainSpeedBuilder.clear());
				TrainReferenceSpeed sm = trainSpeedBuilder.build();
				logger.info("Train speed setup called, id: %d, speed: %d", sm.getTrainID(), sm.getReferenceSpeed());
				trainCommander.setTrainReferenceSpeedAndDirection(sm.getTrainID(), sm.getReferenceSpeed(),
						TrainDirection.valueOf(sm.getDirection().name()));
				break;

			case SEGMENT_STATE:
				JsonFormat.parser().merge(message, segmentState.clear());
				SegmentState ss = segmentState.build();
				commander.sendSegmentCommand(ss.getSegmentID(), ProtobufEnumTransformator.toGeneral(ss.getState()));
				break;
			case TURNOUT_STATE:
				JsonFormat.parser().merge(message, turnoutState.clear());
				TurnoutState ts = turnoutState.build();
				commander.sendTurnoutCommandWithTurnoutId(ts.getTurnoutID(),
						ProtobufEnumTransformator.toGeneral(ts.getState()));
				break;
			default:
				logger.debug("Unrecognized target resource: " + target);
				break;
			}
		} catch (InvalidProtocolBufferException e) {
			DashboardManager.INSTANCE.getLogger().error("Unable to parse message: " + message);
			e.printStackTrace();
		}
	}

}
