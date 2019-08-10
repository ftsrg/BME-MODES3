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
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A GPIO port of a microcontroller.
 *
 * @author zsoltmazlo
 */
public final class Gpio {

	// the level of the GPIO port
	public enum Level {
		LOW, HIGH
	}

	// the operation direction of the GPIO port
	public enum Direction {
		OUT, IN
	}

	/**
	 * A listener for the changes of the GPIO port.
	 * 
	 * @author zsoltmazlo
	 */
	public interface InputStateListener {

		/**
		 * Event handler that will be invoked, if the level of the GPIO port has changed.
		 * 
		 * @param newLevel the new level of the GPIO port
		 */
		public void levelStateChanged(Level newLevel);

	}

	private static final String TAG = "GPIO";

	private static final String GPIO_BASE_FOLDER = "/sys/class/gpio/";

	private final int _pin;

	private final Direction _direction;

	private final List<InputStateListener> listeners = Collections.synchronizedList(new ArrayList<>());

	private String _gpioFolder;

	private volatile Level _level;

	private volatile boolean _isInputListenerRunning = false;

	private Timer _inputListener;

	private TimerTask _inputListenerTask;

	/**
	 * @param pin the identifier of the GPIO port
	 * @param direction the initial direction of the port
	 * @throws IOException {@link #executeCommand(String, String)}, {@link #setupInputChangeListening()}, {@link #setLevel(Level)}
	 */
	public Gpio(int pin, Direction direction) throws IOException {
		this._pin = pin;
		this._direction = direction;

		// export gpio pin first
		try {
			executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "export");
		} catch (Exception ex) {
			Logger.error(TAG, "Pin export failed! Pin: %d", _pin);

			// if GPIO pin exporting failed, the cause of the failure is the
			// fact that the GPIO has already exported previously
			// in this case, we should unexport it and try to export it again
			// if unexport fails also, there should be something wrong
			try {
				executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "unexport");
				executeCommand(String.valueOf(_pin), GPIO_BASE_FOLDER + "export");
			} catch (Exception ex2) {
				Logger.error(TAG, "Pin re-export failed! Pin: %d", _pin);
				throw ex2;
			}
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

	/**
	 * Sets the level of the GPIO port.
	 * 
	 * @param level the level to be set for the GPIO
	 * @throws IOException {@link #executeCommand(String, String)}
	 */
	public final void setLevel(Level level) throws IOException {
		try {
			executeCommand(level == Level.HIGH ? "1" : "0", _gpioFolder + "value");
			this._level = level;
		} catch (IOException ex) {
			Logger.error(TAG, "Level setting failed! Pin: %d", _pin);
			throw ex;
		}
	}

	/**
	 * @return the level of the GPIO port
	 */
	public final Level getLevel() {
		return _level;
	}

	/**
	 * Inverts the level of the GPIO port.
	 * 
	 * @throws IOException {@link #setLevel(Level)}
	 */
	public final void invertLevel() throws IOException {
		if (_level == Level.HIGH) {
			setLevel(Level.LOW);
		} else {
			setLevel(Level.HIGH);
		}
	}

	/**
	 * Creates an impulse on the GPIO port with a given amount of length in time.
	 * 
	 * @param milliseconds the length of the impulse
	 * @param nonBlocking if the impulse should be created in an asynchronous way
	 * @throws InterruptedException {@link Thread#sleep(long)}
	 * @throws IOException {@link #invertLevel()}
	 */
	public final void impulse(int milliseconds, boolean nonBlocking) throws InterruptedException, IOException {
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

	/**
	 * Registers the listener for the input state change event.
	 * 
	 * @param listener the listener to be registered for the event 
	 */
	public final void addInputStateListener(InputStateListener listener) {
		this.listeners.add(listener);
	}

	/**
	 * Deregisters the listener for the input state change event.
	 * 
	 * @param listener the listener to be deregistered for the even
	 */
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

		/**
		 * Continuously checks the level of the GPIO port and triggers the input state change event if
		 * it has changed.
		 */
		@Override
		public void run() {
			try {
				try (BufferedReader reader = new BufferedReader(new FileReader(_gpioFolder + "value"))) {
					Level newLevel = reader.readLine().equals("1") ? Level.HIGH : Level.LOW;
					if (!newLevel.equals(_level)) {
						Logger.info(TAG, "Pin state changed! Pin: %d Value: %s", _pin, newLevel.toString());
						_level = newLevel;
						listeners.stream().forEach((listener) -> {
							try {
								listener.levelStateChanged(_level);
							} catch (Exception ex) {
								Logger.error(TAG, "Error while notifying the InputStateChangeListener (%s)",
										listener.toString());
								Logger.error(TAG, ex.getMessage());
							}
						});
					}
				}

			} catch (FileNotFoundException ex) {
				Logger.error(TAG, "InputStateChangeListenerTask is aborted, because pin #%d's value file not found!",
						_pin);
				Logger.error(TAG, ex.getMessage());
			} catch (IOException ex) {
				Logger.error(TAG, "InputStateChangeListenerTask is aborted, IO error during file read on pin #%d",
						_pin);
				Logger.error(TAG, ex.getMessage());
			}
		}

	}

	private void setupInputChangeListening() throws IOException {
		if (!_isInputListenerRunning) {
			_isInputListenerRunning = true;
			_inputListener = new Timer();
			_inputListenerTask = new InputStateChangeListenerTask();
			_inputListener.schedule(_inputListenerTask, 0, 50);
		}
	}

	/**
	 * Release the used resources.
	 * 
	 * @throws IOException {@link #executeCommand(String, String)}
	 */
	public final void cleanup() throws IOException {
		// unexport gpio pin
		try {
			if (_isInputListenerRunning) {
				Logger.info(TAG, "Stopping listening service for pin #%d", _pin);
				_inputListenerTask.cancel();
				_inputListener.purge();
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
