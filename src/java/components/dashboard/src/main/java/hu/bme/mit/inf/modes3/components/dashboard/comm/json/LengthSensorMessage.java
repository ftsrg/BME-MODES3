package hu.bme.mit.inf.modes3.components.dashboard.comm.json;

import com.google.gson.Gson;

/**
 * The message for the length sensor
 * 
 * @author zsoltmazlo
 */
public class LengthSensorMessage {

	private String sender;
	private long time;
	private String type;
	private int counter;
	private double length;

	public LengthSensorMessage(String sender, long time, String type, int counter, double length) {
		this.sender = sender;
		this.time = time;
		this.type = type;
		this.counter = counter;
		this.length = length;
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

	public int getCounter() {
		return counter;
	}

	public double getLength() {
		return length;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}

}
