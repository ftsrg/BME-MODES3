/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager.main;

/**
 *
 * @author zsoltmazlo
 */
public class GpioNotConfiguratedException extends Exception {

    public GpioNotConfiguratedException() {
    }

    public GpioNotConfiguratedException(String message) {
        super(message);
    }

    public GpioNotConfiguratedException(String message, Throwable cause) {
        super(message, cause);
    }

    public GpioNotConfiguratedException(Throwable cause) {
        super(cause);
    }

    public GpioNotConfiguratedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
