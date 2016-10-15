/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.modes3.components.gpiomanager.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author zsoltmazlo
 */
public final class Gpio implements Runnable {

    public enum Level {
        LOW,
        HIGH
    }

    public enum Direction {
        OUT,
        IN
    }

    public interface GpioInputListener {

        public void levelStateChanged(Level newLevel);

    }

    private static final String TAG = "GPIO";

    private static final String GPIO_BASE_FOLDER = "/sys/class/gpio/";

    private final int _pin;

    private final Direction _direction;

    private final ArrayList<GpioInputListener> listeners = new ArrayList<>();

    private String _gpioFolder;

    private Level _level;

    private volatile boolean _isInputListenerRunning = false;

    private Thread _watcher;

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

                setupFileChangeWatching();
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

    public final void impulse(int milliseconds, boolean nonBlocking) throws InterruptedException, IOException {
        if (nonBlocking) {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(() -> {
                try {
                    this.invertLevel();
                    Thread.sleep(milliseconds);
                    this.invertLevel();
                } catch (InterruptedException | IOException ex) {
                    Logger.error(TAG, "Exception during impulse: %s.", ex.getMessage());
                }

            });
        } else {
            invertLevel();
            Thread.sleep(milliseconds);
            invertLevel();
        }
    }

    public final void addGpioInputListener(GpioInputListener listener) {
        this.listeners.add(listener);
    }

    public final void removeGpioListener(GpioInputListener listener) {
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

    private void setupFileChangeWatching() throws IOException {
        _isInputListenerRunning = true;
        _watcher = new Thread(this);
        _watcher.start();
    }

    @Override
    public void run() {

        // unfortunatelly I can't found any working example for checking 
        // value node with libraries, so for first approach I will constantly
        // check the node if changed or not
        String currentValue = "0";
        while (_isInputListenerRunning) {
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(_gpioFolder + "value"))) {
                    String newValue = reader.readLine();
                    if (!newValue.equals(currentValue)) {
                        Logger.info(TAG, "Pin state changed!\nPin: %d\nValue: %s", _pin, newValue);
                        currentValue = newValue;
                        _level = newValue.equals("1") ? Level.HIGH : Level.LOW;
                        listeners.stream().forEach((listener) -> {
                            listener.levelStateChanged(_level);
                        });

                        Thread.sleep(50);
                    }
                } catch (InterruptedException ex) {
                    Logger.error(TAG, ex.getMessage());
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

    public final void cleanup() throws IOException, InterruptedException {
        // unexport gpio pin
        try {
            if (_isInputListenerRunning) {
                Logger.info(TAG, "Stopping watcher service for pin #%d", _pin);
                _isInputListenerRunning = false;
                _watcher.join();
                Logger.info(TAG, "Watcher service for pin #%d stopped.", _pin);
            }
            executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "unexport");
        } catch (InterruptedException | IOException ex) {
            Logger.error(TAG, "Pin unexport failed! Pin: %d", _pin);
            throw ex;
        }
    }

}
