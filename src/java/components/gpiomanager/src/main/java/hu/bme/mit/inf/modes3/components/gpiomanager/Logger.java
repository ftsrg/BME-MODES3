/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager;

/**
 * A logger utility class
 * 
 * @author zsoltmazlo
 */
public class Logger {

	/**
	 * Log an INFO level message to the standard output.
	 * 
	 * @param TAG prefix of the message
	 * @param formatString the format string for the message
	 * @param arguments the content of the message
	 */
    public static void info(String TAG, String formatString, Object... arguments) {
        System.out.println(TAG + " - " + String.format(formatString, arguments));
    }
    
    /**
	 * Log an ERROR level message to the standard output.
	 * 
	 * @param TAG prefix of the message
	 * @param formatString the format string for the message
	 * @param arguments the content of the message
	 */
    public static void error(String TAG, String formatString, Object... arguments) {
        System.err.println(TAG + " - " + String.format(formatString, arguments));
    }
    
}
