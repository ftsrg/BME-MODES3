package hu.bme.mit.inf.modes3.components.bbb.strategy

import hu.bme.mit.inf.modes3.components.bbb.main.HardwareAbstractionLayer
import io.silverspoon.bulldog.core.Signal
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Thread-safe wrapper for the board instance.
 * 
 * @author benedekh
 */
class BoardWrapper implements HardwareAbstractionLayer {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	protected var Process pinProcess;

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.class.name)	
		pinProcess = Runtime.runtime.exec("python /modes3/pinControl.py")
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
 	synchronized override setPinLevel(String pin, Signal level) {
		val os = pinProcess.outputStream
		val bw = new BufferedWriter(new OutputStreamWriter(os))
		
		logger.info('''Pin «pin» set to «level»''')
		logger.info('''Process status: «pinProcess.alive»''')
		logger.info('''«pin»;« if (level == Signal.High) "1" else "0"»''')
		
		bw.write('''«pin»;« if (level == Signal.High) "1" else "0"»''')
		bw.newLine
		bw.flush
		
		val br = new BufferedReader(new InputStreamReader(pinProcess.inputStream))
		logger.info(br.readLine)
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
	synchronized override getPinLevel(String pin) {
		
	}

}
