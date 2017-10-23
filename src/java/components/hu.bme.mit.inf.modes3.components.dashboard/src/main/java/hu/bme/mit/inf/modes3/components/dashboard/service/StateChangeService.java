package hu.bme.mit.inf.modes3.components.dashboard.service;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.PathParam;
import org.atmosphere.config.service.Singleton;
import org.atmosphere.cpr.MetaBroadcaster;
import org.slf4j.Logger;

import com.google.gson.Gson;

import hu.bme.mit.inf.modes3.components.dashboard.comm.json.LengthSensorMessage;
import hu.bme.mit.inf.modes3.components.dashboard.comm.json.SpeedSensorMessage;
import hu.bme.mit.inf.modes3.components.dashboard.comm.json.TrainSensorMessage;
import hu.bme.mit.inf.modes3.components.dashboard.main.DashboardManager;
import hu.bme.mit.inf.modes3.components.dashboard.utils.SensorDataMessage;
import hu.bme.mit.inf.modes3.components.dashboard.utils.Utils;
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation;
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITurnoutStateChangeListener;
import hu.bme.mit.inf.modes3.messaging.communication.state.train.speed.reference.ITrainReferenceSpeedListener;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy;
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentState;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TrainDirection;
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState;

import static hu.bme.mit.inf.modes3.components.dashboard.utils.ResourceUtils.SENSOR_STATE;

@Singleton
@ManagedService(path = "/ws/state/{source}")
public class StateChangeService implements ISegmentOccupancyChangeListener, ITurnoutStateChangeListener,
		ISegmentStateChangeListener, ITrainReferenceSpeedListener, IComputerVisionListener {

	Logger logger = DashboardManager.INSTANCE.getLoggerFactory().getLogger(StateChangeService.class.getName());

	List<String> locomotives = Arrays.asList("Taurus", "BR294", "SNCF");

	// two speed value, length and train comes on sensors' channel. Thus, we have to
	// wait all of these to be able to send normal message to the dashboard
	private SensorDataMessage sensorDataMessage = new SensorDataMessage();

	private String sensorDataSender;

	@Inject
	protected MetaBroadcaster metaBroadcaster;

	@PathParam("source")
	protected String source;

	public StateChangeService() {
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setSegmentOccupancyChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setSegmentStateChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrackElementStateRegistry().setTurnoutStateChangeListener(this);
		DashboardManager.INSTANCE.getLocator().getTrainSpeedStateRegistry().addTrainReferenceSpeedListener(this);
		DashboardManager.INSTANCE.getLocator().getComputerVisionCallback().setComputerVisionListener(this);
		DashboardManager.INSTANCE.getSensorsDispatcher().setStateChangeService(this);
	}

	@Override
	public void onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		Utils.sendSegmentOccupancyStateChange(metaBroadcaster, id, newValue);
	}

	@Override
	public void onSegmentStateChange(int id, SegmentState oldValue, SegmentState newValue) {
		Utils.sendSegmentStateChange(metaBroadcaster, id, newValue);
	}

	@Override
	public void onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
		Utils.sendTurnutStateChange(metaBroadcaster, id, newValue);
	}

	@Override
	public void onTrainReferenceSpeed(int id, int speed, TrainDirection direction) {
		Utils.sendTrainReferenceSpeedChange(metaBroadcaster, id, speed, direction);
	}

	@Override
	public void onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp,
			long frameindex) {

		for (ComputerVisionInformation cvInfo : information) {
			if (locomotives.contains(cvInfo.getName())) {
				Utils.sendComputerVisionState(metaBroadcaster, cvInfo);
			}
		}
	}

	public void onSpeedSensorMessage(SpeedSensorMessage message) {

		// yeah, i'm in aware of the fact that this solution will only work with one
		// sensor, but hey, I'm trying my best here.
		if (!message.getSender().equals(sensorDataSender)) {
			// starting a new circle
			sensorDataSender = message.getSender();
			sensorDataMessage.reset();
		}
		sensorDataMessage.setSpeed(message.getSpeed());

		if (sensorDataMessage.isObjectReady()) {
			String jsonMessage = new Gson().toJson(sensorDataMessage);
			metaBroadcaster.broadcastTo("/ws/state/" + SENSOR_STATE, jsonMessage);
		}

	}

	public void onLengthSensorMessage(LengthSensorMessage message) {

		// yeah, i'm in aware of the fact that this solution will only work with one
		// sensor, but hey, I'm trying my best here.
		if (!message.getSender().equals(sensorDataSender)) {
			// starting a new circle
			sensorDataSender = message.getSender();
			sensorDataMessage.reset();
		}
		sensorDataMessage.setLength(message.getLength());

		if (sensorDataMessage.isObjectReady()) {
			String jsonMessage = new Gson().toJson(sensorDataMessage);
			metaBroadcaster.broadcastTo("/ws/state/" + SENSOR_STATE, jsonMessage);
		}

	}

	public void onTrainSensorMessage(TrainSensorMessage message) {

		// yeah, i'm in aware of the fact that this solution will only work with one
		// sensor, but hey, I'm trying my best here.
		if (!message.getSender().equals(sensorDataSender)) {
			// starting a new circle
			sensorDataSender = message.getSender();
			sensorDataMessage.reset();
		}
		sensorDataMessage.setLocomotiveName(message.getTrain());

		if (sensorDataMessage.isObjectReady()) {
			String jsonMessage = new Gson().toJson(sensorDataMessage);
			metaBroadcaster.broadcastTo("/ws/state/" + SENSOR_STATE, jsonMessage);
		}
	}

}
