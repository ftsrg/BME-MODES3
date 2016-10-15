/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author zsoltmazlo
 */
public final class Gpio {

    public enum Level {
        LOW,
        HIGH
    }

    public enum Direction {
        OUT,
        IN
    }
    
    private static final String TAG = "GPIO";

    private static final String GPIO_BASE_FOLDER = "/sys/class/gpio/";

    private final int _pin;
    
    private final Direction _direction;

    private String _gpioFolder;

    private Level _level;

    public Gpio(int pin, Direction direction) throws IOException {
        this._pin = pin;
        this._direction = direction;

        // export gpio pin first
        try {
            executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "export");
        } catch (Exception ex) {
            Logger.error(TAG, "Pin export failed! Pin: %d", _pin);
            throw ex;
        }

        this._gpioFolder = GPIO_BASE_FOLDER + "gpio" + this._pin + "/";

        // set direction of pin
        try {
            executeCommand(this._direction.toString().toLowerCase(), _gpioFolder + "direction");
        } catch (Exception ex) {
            Logger.error(TAG, "Pin direction setup failed! Pin: %d", _pin);
            throw ex;
        }

        // set level immediately to low
        this.setLevel(Level.LOW);
    }

    public final void setLevel(Level level) throws IOException {
        try {
            executeCommand(level == Level.HIGH ? "1" : "0", _gpioFolder + "value");
            this._level = level;
        } catch (IOException ex) {
            Logger.error(TAG, "Level setting failed! Pin: %d", _pin);
            throw ex;
        }
    }
    
    public final void invertLevel() throws IOException {
        if( _level == Level.HIGH ) {
            setLevel(Level.LOW);
        } else {
            setLevel(Level.HIGH);
        }
    }
    
    public final void impulse(int milliseconds) throws InterruptedException, IOException {
        invertLevel();
        Thread.sleep(milliseconds);
        invertLevel();
    }

    private void executeCommand(String value, String targetFile) throws IOException {
        Logger.info(TAG, "Trying to write \"%s\" to %s", value, targetFile);
        try (BufferedWriter w = new BufferedWriter(new FileWriter(targetFile))) {
            w.append(value);
            w.newLine();
            w.flush();
        }
        Logger.info(TAG, "Succeded!");
    }

    public final void cleanup() throws IOException {
        // unexport gpio pin
        try {
            executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "unexport");
        } catch (Exception ex) {
            Logger.error(TAG, "Pin unexport failed! Pin: %d", _pin);
            throw ex;
        }
    }

}
