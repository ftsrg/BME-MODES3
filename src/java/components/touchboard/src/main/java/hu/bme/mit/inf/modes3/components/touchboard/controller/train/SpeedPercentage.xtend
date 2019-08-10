package hu.bme.mit.inf.modes3.components.touchboard.controller.train

/**
 * The relative speed on a scale of 0-100.
 * Each level grows by 25.
 * 
 * @author benedekh
 */
public enum SpeedPercentage {
	NILL,
	TWENTY_FIVE,
	FIFTY,
	SEVENTY_FIVE,
	HUNDRED
}

/**
 * A utility class to convert between integer and {@link SpeedPercentage}.
 */
public class SpeedPercentageUtil {

	static val MAX_SPEED = 128;

	/**
	 * Converts a {@link SpeedPercentage} to integer.
	 * 
	 * @param percentage the speed percentage
	 * @return the integer representation of a speed percentage between 0 and 100.
	 */
	static def int toSpeed(SpeedPercentage percentage) {
		switch (percentage) {
			case NILL:
				0
			default: {
				return new Double((percentage.toNumber / 100.0) * MAX_SPEED).intValue
			}
		}
	}

	/**
	 * Converts an integer to a {@link SpeedPercentage}
	 * 
	 * @param number integer representation of a speed percentage between 0 and 100.
	 * @return the corresponding speed percentage
	 * @throws IllegalArgumentException if the number is neither 0, 25, 50, 75, 100
	 */
	static def toSpeedPercentage(int number) {
		switch (number) {
			case 0: SpeedPercentage.NILL
			case 25: SpeedPercentage.TWENTY_FIVE
			case 50: SpeedPercentage.FIFTY
			case 75: SpeedPercentage.SEVENTY_FIVE
			case 100: SpeedPercentage.HUNDRED
			default: throw new IllegalArgumentException('''Number («number») is out of value set: [0, 25, 50, 75, 100]''')
		}
	}
	
	private static def toNumber(SpeedPercentage percentage) {
		switch (percentage) {
			case NILL: 0
			case TWENTY_FIVE: 25
			case FIFTY: 50
			case SEVENTY_FIVE: 75
			case HUNDRED: 100
		}
	}
}
