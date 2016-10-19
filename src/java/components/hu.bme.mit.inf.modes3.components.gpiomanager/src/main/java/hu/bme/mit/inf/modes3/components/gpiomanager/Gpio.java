/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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

    public interface InputStateListener {

        public void levelStateChanged(Level newLevel);

    }

    private static final String TAG = "GPIO";

    private static final String GPIO_BASE_FOLDER = "/sys/class/gpio/";

    private final int _pin;

    private final Direction _direction;

    private final ArrayList<InputStateListener> listeners = new ArrayList<>();

    private String _gpioFolder;

    private Level _level;

    private volatile boolean _isInputListenerRunning = false;

    private Timer _inputListener;

    public Gpio(int pin, Direction direction) throws IOException, GpioNotConfiguratedException {
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

        switch (this._direction) {
            case IN:
                // setup edge detection as well
                executeCommand("both", _gpioFolder + "edge");

                setupInputChangeListening();
                break;
            case OUT:
                // set level immediately to low
                this.setLevel(Level.LOW);
                break;
        }

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

    public final Level getLevel() {
        return _level;
    }

    public final void invertLevel() throws IOException {
        if (_level == Level.HIGH) {
            setLevel(Level.LOW);
        } else {
            setLevel(Level.HIGH);
        }
    }

    public final void impulse(int milliseconds, boolean nonBlocking)
            throws InterruptedException, IOException {
        if (nonBlocking) {
            Thread impulse = new Thread(() -> {
                try {
                    this.invertLevel();
                    Thread.sleep(milliseconds);
                    this.invertLevel();
                } catch (InterruptedException | IOException ex) {
                    Logger.error(TAG, "Exception during impulse: %s.", ex.getMessage());
                }

            });
            impulse.start();
        } else {
            invertLevel();
            Thread.sleep(milliseconds);
            invertLevel();
        }
    }

    public final void addInputStateListener(InputStateListener listener) {
        this.listeners.add(listener);
    }

    public final void removeInputStateListener(InputStateListener listener) {
        this.listeners.remove(listener);
    }

    private void executeCommand(String value, String targetFile) throws IOException {
        Logger.info(TAG, "Trying to write \"%s\" to %s", value, targetFile);
        try (BufferedWriter w = new BufferedWriter(new FileWriter(targetFile))) {
            w.append(value);
            w.newLine();
            w.flush();
        }
        Logger.info(TAG, "Succeeded!");
    }

    private class InputStateChangeListenerTask extends TimerTask {

        @Override
        public void run() {
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(_gpioFolder + "value"))) {
                    Level newLevel = reader.readLine().equals("1") ? Level.HIGH : Level.LOW;
                    if (!newLevel.equals(_level)) {
                        Logger.info(TAG, "Pin state changed! Pin: %d Value: %s", _pin, newLevel.toString());
                        _level = newLevel;
                        listeners.stream().forEach((listener) -> {
                            listener.levelStateChanged(_level);
                        });
                    }
                }

            } catch (FileNotFoundException ex) {
                Logger.error(TAG, "Pin #%d's value file not found!", _pin);
                Logger.error(TAG, ex.getMessage());
            } catch (IOException ex) {
                Logger.error(TAG, "IO error during file read on pin #%d", _pin);
                Logger.error(TAG, ex.getMessage());
            }
        }

    }

    private void setupInputChangeListening() throws IOException {
        if (!_isInputListenerRunning) {
            _isInputListenerRunning = true;
            _inputListener = new Timer();
            _inputListener.schedule(new InputStateChangeListenerTask(), 0, 50);
        }
    }

    public final void cleanup() throws IOException, InterruptedException {
        // unexport gpio pin
        try {
            if (_isInputListenerRunning) {
                Logger.info(TAG, "Stopping listening service for pin #%d", _pin);
                _inputListener.cancel();
                _isInputListenerRunning = false;
                Logger.info(TAG, "Listening service for pin #%d stopped.", _pin);
            }
            executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "unexport");
        } catch (IOException ex) {
            Logger.error(TAG, "Pin unexport failed! Pin: %d", _pin);
            throw ex;
        }
    }

}
