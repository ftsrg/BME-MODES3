package hu.bme.mit.inf.master.bbb.utils;

public class HexConversionUtil {
	
	public static String fromNumber(int number) {
		return "0x" + String.format("%02x", number).toUpperCase();
	}
	
	public static int fromString(String str) {
		String trimmed = str.substring(2);
		return Integer.parseInt(trimmed, 16);
	}
}
