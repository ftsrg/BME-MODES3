package hu.bme.mit.inf.modes3.bbb.utils;

import java.util.Map
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * Helper class for converting HEX string to integer and vice versa.
 * 
 * @author hegyibalint
 */
class HexConversionUtil {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) static val Map<Integer, String> intToStrConversionCache = new TreeMap

	/**
	 * Convert the parameter number to HEX String.
	 * 
	 * @param number to be converted
	 * @return the HEX String representation of the nubmer
	 */
	def static fromNumber(int number) {
		if (!intToStrConversionCache.containsKey(number)) {
			val sb = new StringBuilder("0x")
			sb.append(String.format("%02x", number).toUpperCase)
			intToStrConversionCache.put(number, sb.toString)
		}
		intToStrConversionCache.get(number)
	}

	/**
	 * Convert the parameter HEX String (starting with 0x) to int number.
	 * 
	 * @param str to be converted
	 * @return the integer representation of the HEX String
	 */
	def static fromString(String str) {
		Integer.decode(str)
	}
}
