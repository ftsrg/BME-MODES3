package hu.bme.mit.inf.modes3.messaging.messages.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public enum ConnectionDirection {

	CW(0), CCW(1), TOP(3), STRAIGHT(4), DIVERGENT(5), UNSPECIFIED(2);

	private static Map<Integer, ConnectionDirection> enumByYakinduValue;

	static {
		enumByYakinduValue = new TreeMap<>();
		Arrays.stream(ConnectionDirection.values())
				.forEach(enumValue -> enumByYakinduValue.put(enumValue.valueInYakindu, enumValue));
	}

	private int valueInYakindu;

	private ConnectionDirection(int value) {
		this.valueInYakindu = value;
	}

	public static ConnectionDirection getDirectionByValue(int value) {
		return enumByYakinduValue.get(value);
	}

	public int getValueInYakindu() {
		return valueInYakindu;
	}

}