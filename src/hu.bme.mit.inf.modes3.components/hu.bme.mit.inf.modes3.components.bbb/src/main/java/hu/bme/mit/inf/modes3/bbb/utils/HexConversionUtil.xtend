package hu.bme.mit.inf.modes3.bbb.utils;

/**
 * Helper class for converting HEX string to integer and vice versa.
 *
 * @author hegyibalint
 */
class HexConversionUtil {

    /**
     * Convert the parameter number to HEX String.
     *
     * @param number to be converted
     * @return the HEX String representation of the nubmer
     */
    def static fromNumber(int number) {
    	val sb = new StringBuilder("0x")
        sb.append(String.format("%02x", number).toUpperCase())
        sb.toString
    }

    /**
     * Convert the parameter HEX String (starting with 0x) to int number.
     *
     * @param str to be converted
     * @return the integer representation of the HEX String
     */
    def static fromString(String str) {
        val trimmed = str.substring(2)
        Integer.parseInt(trimmed, 16)
    }
}
