package hu.bme.mit.inf.modes3.components.occupancyquery

import com.pi4j.io.serial.Serial
import com.pi4j.io.serial.SerialFactory
import hu.bme.mit.inf.modes3.components.occupancyquery.config.SerialConfigFactory
import java.util.Arrays
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import zmq.ZError.IOException

class UARTReader implements IUARTReader, Runnable {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	protected val Serial serial
	protected val received = new LinkedBlockingQueue<byte[]>

	new(ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		serial = SerialFactory::createInstance
	}

	def close() {
		try {
			serial.close
			logger.info("serial port closed")
		} catch(IllegalStateException ex) {
			logger.error(ex.message, ex)
		} catch(IOException ex) {
			logger.error(ex.message, ex)
		}
	}

	override run() {
		try {
			serial.open(SerialConfigFactory::createDefaultConfig)
			logger.info("serial port opened")

			while(!Thread.currentThread.interrupted) {
				try {
					val readValues = serial.read(4)
					logger.info("received values: " + Arrays.toString(readValues))
					received.put(readValues)
				} catch(IllegalStateException ex) {
					logger.error(ex.message, ex)
				} catch(IOException ex) {
					logger.error(ex.message, ex)
				}
			}
		} finally {
			close
		}
	}

	override read() {
		received.take
	}

}
