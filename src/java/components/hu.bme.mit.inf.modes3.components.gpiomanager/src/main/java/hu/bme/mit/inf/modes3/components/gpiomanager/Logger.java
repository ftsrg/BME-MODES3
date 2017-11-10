/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager;

/**
 *
 * @author zsoltmazlo
 */
public class Logger {

    public static void info(String TAG, String formatString, Object... arguments) {
        System.out.println(TAG + " - " + String.format(formatString, arguments));
    }
    
    public static void error(String TAG, String formatString, Object... arguments) {
        System.err.println(TAG + " - " + String.format(formatString, arguments));
    }
    
}
