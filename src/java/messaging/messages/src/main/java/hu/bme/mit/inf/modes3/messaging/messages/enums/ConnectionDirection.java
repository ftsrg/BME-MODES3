package hu.bme.mit.inf.modes3.messaging.messages.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * The connection directions between two track element (segment).
 * 
 * @author benedekh
 */
public enum ConnectionDirection {

	/**
	 * clockwise
	 */
	CW(0), 
	/**
	 * counter-clockwise
	 */
	CCW(1),
	/**
	 * top (see {@link hu.bme.mit.inf.modes3.utils.conf.layout.SegmentDirection})
	 */
	TOP(3),
	/**
	 * straight (see {@link hu.bme.mit.inf.modes3.utils.conf.layout.SegmentDirection})
	 */
	STRAIGHT(4),
	/**
	 * divergent (see {@link hu.bme.mit.inf.modes3.utils.conf.layout.SegmentDirection})
	 */
	DIVERGENT(5),
	/**
	 * the direction is unspecified
	 */
	UNSPECIFIED(2);

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
	
	/**
	 * @param value the direction in the yakindu model
	 * @return the connection direction as an enum
	 */
	public static ConnectionDirection getDirectionByValue(int value) {
		return enumByYakinduValue.get(value);
	}

	/**
	 * @return the value of the connection direction in yakindu
	 */
	public int getValueInYakindu() {
		return valueInYakindu;
	}

}