package hu.bme.mit.inf.modes3.components.occupancyquery

import com.pi4j.io.serial.Serial
import com.pi4j.io.serial.SerialFactory
import hu.bme.mit.inf.modes3.components.occupancyquery.config.SerialConfigFactory
import java.util.ArrayList
import java.util.Arrays
import java.util.concurrent.LinkedBlockingQueue
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger
import zmq.ZError.IOException

class UARTReader implements IUARTReader, Runnable {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	protected val Serial serial

	protected val Thread bytesProcessor

	protected val received = new LinkedBlockingQueue<byte[]>
	protected val occupancyBytes = new LinkedBlockingQueue<byte[]>

	new(ILoggerFactory factory) {
		logger = factory.getLogger(this.class.name)
		serial = SerialFactory::createInstance
		bytesProcessor = new Thread(new BytesProcesssor(received, occupancyBytes, factory))
		bytesProcessor.start
	}

	def close() {
		try {
			bytesProcessor.interrupt
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

			while(!Thread.interrupted) {
				try {
					val readBytes = serial.read(1)
					logger.info("readBytes " + Arrays.toString(readBytes))
					received.put(readBytes)
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
		occupancyBytes.take
	}

	static class BytesProcesssor implements Runnable {

		protected val Logger logger

		protected val occupancyBuffer = new ArrayList<Byte>

		protected val LinkedBlockingQueue<byte[]> inputQueue
		protected val LinkedBlockingQueue<byte[]> outputQueue

		new(LinkedBlockingQueue<byte[]> received, LinkedBlockingQueue<byte[]> occupancyBytes, ILoggerFactory factory) {
			this.inputQueue = received
			this.outputQueue = occupancyBytes
			this.logger = factory.getLogger(this.class.name)
		}

		override run() {
			var status = UARTProcessStatus.BEFORE_HEADER_END
			var numberOfTimes0xFFDetected = 0

			while(!Thread.interrupted) {
				val recvd = inputQueue.take.get(0)
				switch (status) {
					case BEFORE_HEADER_END: {
						if(recvd.equals(0xFF as byte) && numberOfTimes0xFFDetected < 6) {
							numberOfTimes0xFFDetected++
							logger.info(status + " " + numberOfTimes0xFFDetected)
						} else if(recvd.equals(0xFF as byte) && numberOfTimes0xFFDetected == 6) {
							logger.info(status + " " + numberOfTimes0xFFDetected)
							numberOfTimes0xFFDetected = 0
							status = UARTProcessStatus.LAST_BYTE_OF_HEADER_HAS_TO_COME
						} else {
							numberOfTimes0xFFDetected = 0
						}
					}
					case LAST_BYTE_OF_HEADER_HAS_TO_COME: {
						if(recvd.equals(0xAA as byte)) {
							logger.info("0xAA detected")
							status = UARTProcessStatus.DETECTING_OCCUPANCIES
						} else {
							logger.info("0xAA not detected")
							status = UARTProcessStatus.BEFORE_HEADER_END
						}
					}
					case DETECTING_OCCUPANCIES: {
						if(occupancyBuffer.size < 4) {
							logger.info("adding to occupancy buffer")
							occupancyBuffer.add(recvd)
						} else {
							logger.info("converting occupancy buffer")
							// get occupancyBuffer list as an array
							var buffer = #[new Byte(1 as byte), new Byte(1 as byte), new Byte(1 as byte), new Byte(1 as byte)]
							val occupancies = occupancyBuffer.toArray(buffer)
							// convert from Byte[] to byte[] in xtend
							val convertBuffer = newByteArrayOfSize(occupancies.size)
							for (i : 0 ..< occupancies.size) {
								convertBuffer.set(i, occupancies.get(i))
							}
							// send occupancy bytes
							logger.info("converted buffer: " + Arrays.toString(convertBuffer))
							outputQueue.put(convertBuffer)

							// clear stuff
							occupancyBuffer.clear
							status = UARTProcessStatus.BEFORE_HEADER_END
						}
					}
				}
			}
		}
	}

}
