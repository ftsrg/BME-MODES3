package hu.bme.mit.inf.modes3.components.dashboard.comm.json;

import com.google.gson.Gson;

/**
 * The message for the train sensor
 * 
 * @author zsoltmazlo
 */
public class TrainSensorMessage {

	private String sender;
	private long time;
	private String type;
	private int counter;
	private String train;

	public TrainSensorMessage(String sender, long time, String type, int counter, String train) {
		this.sender = sender;
		this.time = time;
		this.type = type;
		this.counter = counter;
		this.train = train;
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

	public String getTrain() {
		return train;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}

}
