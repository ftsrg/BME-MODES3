package hu.bme.mit.inf.modes3.components.bbb.strategy

import io.silverspoon.bulldog.core.Signal
import io.silverspoon.bulldog.core.gpio.DigitalInput
import io.silverspoon.bulldog.core.gpio.DigitalOutput
import io.silverspoon.bulldog.core.platform.Board
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static io.silverspoon.bulldog.core.platform.Platform.createBoard

/**
 * Thread-safe wrapper for the board instance.
 * 
 * @author benedekh
 */
class BoardWrapper {

	private static val Logger logger = LoggerFactory.getLogger(BoardWrapper)

	protected var Board board

	new() {
		try {
			board = createBoard
		} catch(Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	new(Board _board) {
		board = _board
	}

	/**
	 * Thread-safe wrapper for board.getPin(pin).as(DigitalInput) method.
	 * 
	 * pin is the name of the pin on the sheet:
	 * https://insigntech.files.wordpress.com/2013/09/bbb_pinouts.jpg
	 */
	synchronized def getPinAsDigitalInput(String pin) {
		board?.getPin(pin).^as(DigitalInput)
	}

	/**
	 * pin is the name of the pin on the sheet:
	 * https://insigntech.files.wordpress.com/2013/09/bbb_pinouts.jpg
	 * 
	 * e.g. pin == "P8_7", then it is GPIO_22;
	 * 
	 * Otherwise look in the io.silverspoon.bulldog.beagleboneblack.BBBNames
	 * class for possible names.
	 * 
	 * @param pin
	 * @param level HIGH or LOW
	 */
	synchronized def setPinLevel(String pin, Signal level) {
		val output = board?.getPin(pin).^as(DigitalOutput)
		output?.applySignal(level);
	}

	/**
	 * pin is the name of the pin on the sheet:
	 * https://insigntech.files.wordpress.com/2013/09/bbb_pinouts.jpg
	 * 
	 * e.g. pin == "P8_7", then it is GPIO_22;
	 * 
	 * Otherwise look in the io.silverspoon.bulldog.beagleboneblack.BBBNames
	 * class for possible names.
	 * 
	 * @param pin
	 * @return level of the pin: HIGH or LOW
	 */
	synchronized def getPinLevel(String pin) {
		val input = board?.getPin(pin).^as(DigitalInput);
		input?.read
	}

}
