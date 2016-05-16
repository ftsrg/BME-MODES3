package hu.bme.mit.inf.master.bbb.utils;

/**
 * Helper class for converting HEX string to integer and vice versa.
 *
 * @author hegyibalint
 */
public class HexConversionUtil {

    /**
     * Convert the parameter number to HEX String.
     *
     * @param number to be converted
     * @return the HEX String representation of the nubmer
     */
    public static String fromNumber(int number) {
        return "0x" + String.format("%02x", number).toUpperCase();
    }

    /**
     * Convert the parameter HEX String (starting with 0x) to int number.
     *
     * @param str to be converted
     * @return the integer representation of the HEX String
     */
    public static int fromString(String str) {
        String trimmed = str.substring(2);
        return Integer.parseInt(trimmed, 16);
    }
}
