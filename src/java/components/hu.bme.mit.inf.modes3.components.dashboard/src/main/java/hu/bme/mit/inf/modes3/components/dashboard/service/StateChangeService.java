package hu.bme.mit.inf.modes3.components.dashboard.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.atmosphere.config.service.ManagedService;
import org.atmosphere.config.service.PathParam;
import org.atmosphere.config.service.Singleton;
import org.atmosphere.cpr.MetaBroadcaster;
import org.slf4j.Logger;

import com.google.common.collect.Maps;
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
	private Map<String, SensorDataMessage> sensorDataMessages = new HashMap<>();

	@Inject
	protected MetaBroadcaster metaBroadcaster;

	@PathParam("source")
	protected String source;

	public StateChangeService() {
		sensorDataMessages.put("Bakter01", new SensorDataMessage());
		sensorDataMessages.put("Bakter02", new SensorDataMessage());

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

		// if message received from either of our sensors, then add the new value and if
		// object is ready to send, then send it and reset it
		if (sensorDataMessages.containsKey(message.getSender())) {
			SensorDataMessage m = sensorDataMessages.get(message.getSender());
			m.setSpeed(message.getSpeed());

			if (m.isObjectReady()) {
				String jsonMessage = new Gson().toJson(m);
				metaBroadcaster.broadcastTo("/ws/state/" + SENSOR_STATE, jsonMessage);
				m.reset();
			}
		}

	}

	public void onLengthSensorMessage(LengthSensorMessage message) {

		// if message received from either of our sensors, then add the new value and if
		// object is ready to send, then send it and reset it
		if (sensorDataMessages.containsKey(message.getSender())) {
			SensorDataMessage m = sensorDataMessages.get(message.getSender());
			m.setLength(message.getLength());

			if (m.isObjectReady()) {
				String jsonMessage = new Gson().toJson(m);
				metaBroadcaster.broadcastTo("/ws/state/" + SENSOR_STATE, jsonMessage);
				m.reset();
			}
		}

	}

	public void onTrainSensorMessage(TrainSensorMessage message) {

		// if message received from either of our sensors, then add the new value and if
		// object is ready to send, then send it and reset it
		if (sensorDataMessages.containsKey(message.getSender())) {
			SensorDataMessage m = sensorDataMessages.get(message.getSender());
			m.setLocomotiveName(message.getTrain());

			if (m.isObjectReady()) {
				String jsonMessage = new Gson().toJson(m);
				metaBroadcaster.broadcastTo("/ws/state/" + SENSOR_STATE, jsonMessage);
				m.reset();
			}
		}
	}

}
