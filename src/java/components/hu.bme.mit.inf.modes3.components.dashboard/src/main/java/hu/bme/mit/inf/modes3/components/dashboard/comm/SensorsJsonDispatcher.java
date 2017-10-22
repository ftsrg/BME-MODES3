package hu.bme.mit.inf.modes3.components.dashboard.comm;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import com.google.gson.Gson;

import hu.bme.mit.inf.modes3.components.dashboard.comm.json.LengthSensorMessage;
import hu.bme.mit.inf.modes3.components.dashboard.comm.json.SpeedSensorMessage;
import hu.bme.mit.inf.modes3.components.dashboard.comm.json.TrainSensorMessage;
import hu.bme.mit.inf.modes3.components.dashboard.service.StateChangeService;
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.AbstractMessageDispatcher;

public class SensorsJsonDispatcher extends AbstractMessageDispatcher {

	private Logger logger;
	private StateChangeService stateChangeService;

	public SensorsJsonDispatcher(ILoggerFactory loggerFactory) {
		logger = loggerFactory.getLogger(getClass().getName());
	}

	public void setStateChangeService(StateChangeService stateChangeService) {
		this.stateChangeService = stateChangeService;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void dispatchMessage(byte[] rawMessage) {
		String json = "";
		try {
			json = new String(rawMessage);

			Map<String, Object> deserializatedJson = new HashMap<>();
			deserializatedJson = new Gson().fromJson(json, deserializatedJson.getClass());

			String type = (String) deserializatedJson.get("type");
			switch (type) {
			case "Speed":
				SpeedSensorMessage speedMessage = new Gson().fromJson(json, SpeedSensorMessage.class);
				stateChangeService.onSpeedSensorMessage(speedMessage);
				break;
			case "Length":
				LengthSensorMessage lengthMessage = new Gson().fromJson(json, LengthSensorMessage.class);
				stateChangeService.onLengthSensorMessage(lengthMessage);
				break;
			case "Train":
				TrainSensorMessage trainMessage = new Gson().fromJson(json, TrainSensorMessage.class);
				stateChangeService.onTrainSensorMessage(trainMessage);
				break;
			default:
				logger.error("No suitable message type is found for %s%n", type);
			}
		} catch (Exception ex) {
			logger.error("Unable to deserialize json message (%s). Problem is %s %n", json, ex.getMessage());
		}

	}

	@Override
	public byte[] convertMessageToRaw(Object message) throws IllegalArgumentException {
		// left empty on purpose
		return null;
	}

}
