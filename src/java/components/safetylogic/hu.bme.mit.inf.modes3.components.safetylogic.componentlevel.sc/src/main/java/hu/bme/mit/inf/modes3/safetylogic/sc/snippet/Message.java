package hu.bme.mit.inf.modes3.safetylogic.sc.snippet;

class Message {

	private String event;

	private Object value;

	public Message(String event, Object value) {
		this.event = event;
		this.value = value;
	}

	public String getEvent() {
		return event;
	}

	public Object getValue() {
		return value;
	}

}
