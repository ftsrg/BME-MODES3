package hu.bme.mit.inf.modes3.components.dashboard.comm.json;

import com.google.gson.Gson;

/**
 * The message for the speed sensor
 * 
 * @author zsoltmazlo
 */
public class SpeedSensorMessage {

	private String sender;
	private long time;
	private String type;
	private double speed;

	public SpeedSensorMessage(String sender, long time, String type, double speed) {
		this.sender = sender;
		this.time = time;
		this.type = type;
		this.speed = speed;
	}

	public String getSender() {
		return sender;
	}

	public long getTime() {
		return time;
	}

	public String getType() {
		return type;
	}

	public double getSpeed() {
		return speed;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

}
