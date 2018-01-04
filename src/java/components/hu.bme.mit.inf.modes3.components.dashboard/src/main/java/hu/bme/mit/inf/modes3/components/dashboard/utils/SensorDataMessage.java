package hu.bme.mit.inf.modes3.components.dashboard.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

/**
 * This class is a temporary solution for sending valid messages to the
 * dashboard regarding what we receive from the sensors. If the sensors are
 * sending a new type of message, this class could be removed.
 * 
 * @author zsoltmazlo
 *
 */
public class SensorDataMessage {

	private String locomotiveName;
	private double length;
	private double speed;

	private Map<String, Boolean> fieldsFilled;

	public SensorDataMessage() {
		fieldsFilled = new HashMap<>();
		this.reset();
	}

	public void setLocomotiveName(String locomotiveName) {
		fieldsFilled.put("name", true);
		this.locomotiveName = locomotiveName;
	}

	public void setLength(double length) {
		fieldsFilled.put("length", true);
		this.length = length;
	}

	public void setSpeed(double speed) {
		fieldsFilled.put("speed", true);
		this.speed = speed;
	}

	public void reset() {
		fieldsFilled.put("name", false);

		// in our implementation, we do not care about the length
		fieldsFilled.put("length", true);
		fieldsFilled.put("speed", false);
	}

	/**
	 * @return if every necessary field is filled, then returns with true, otherwise
	 *         false
	 */
	public boolean isObjectReady() {
		return !fieldsFilled.values().contains(false);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
