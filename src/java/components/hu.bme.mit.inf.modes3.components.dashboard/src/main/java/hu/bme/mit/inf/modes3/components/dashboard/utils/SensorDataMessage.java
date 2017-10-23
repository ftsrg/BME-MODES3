package hu.bme.mit.inf.modes3.components.dashboard.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is a temporarly solution for sending valid messages to the
 * dashboard regarding what we receving from the sensors. If the sensors are
 * sending a new type of message, this class could be removed.
 * 
 * @author zsoltmazlo
 *
 */
public class SensorDataMessage {

	public class Wagon {

		private String name;

		private double length;

		public Wagon(String name, double length) {
			super();
			this.name = name;
			this.length = length;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getLength() {
			return length;
		}

		public void setLength(double length) {
			this.length = length;
		}

	}

	private String locomotiveName;

	private double length;

	private double speed;

	private List<Wagon> wagons = new ArrayList<>();

	private Map<String, Boolean> fieldsFilled;

	public SensorDataMessage() {
		fieldsFilled = new HashMap<>();
		this.reset();
	}

	public String getLocomotiveName() {
		return locomotiveName;
	}

	public void setLocomotiveName(String locomotiveName) {
		fieldsFilled.put("name", true);
		this.locomotiveName = locomotiveName;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		fieldsFilled.put("length", true);
		this.length = length;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		fieldsFilled.put("speed", true);
		this.speed = speed;
	}

	public List<Wagon> getWagons() {
		return wagons;
	}

	public void addWagon(Wagon wagon) {
		this.wagons.add(wagon);
	}

	public void reset() {
		fieldsFilled.put("name", false);

		// for in our implementation, we do not care about the length
		fieldsFilled.put("length", true);
		fieldsFilled.put("speed", false);
	}

	/**
	 * This method is returning a boolean flag about the objects state: if any
	 * necessary field is filled with values, then returns with true, in any other
	 * cases it returns with false
	 * 
	 * @return
	 */
	public boolean isObjectReady() {
		boolean isReady = true;
		for (Boolean val : fieldsFilled.values()) {
			isReady = isReady && val;
		}
		return isReady;
	}

}
