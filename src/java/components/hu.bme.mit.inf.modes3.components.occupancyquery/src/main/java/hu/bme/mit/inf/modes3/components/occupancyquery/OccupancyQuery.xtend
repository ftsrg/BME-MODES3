package hu.bme.mit.inf.modes3.components.occupancyquery

import com.fazecast.jSerialComm.SerialPort
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.common.AbstractCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.utils.conf.LayoutConfiguration
import org.slf4j.ILoggerFactory

/*
 * The correct message format received from the SOC controller is the following:
 * byte 1  2  3  4  5  6  7  8 
 * data FF FF FF FF DD DD DD DD
 * 
 * Where D marks the useful data
 * 
 * Because the 32nd segment is not connected anywhere, we can use this to signal
 * the packet by sending 4 consecutive 0xFF byte.
 * 
 * TODO: Document the data order
 * 
 */

class OccupancyQuery extends AbstractCommunicationComponent {

	// The registry holding the application parameters
	val ArgumentRegistry registry

	// The byte vector storing the incoming data
	val int[] occupancy = newIntArrayOfSize(8)
	// The occupancy vector containing the current status
	val SegmentOccupancy[] states = newArrayOfSize(32)

	new(MessagingService messagingService, ILoggerFactory factory, ArgumentRegistry registry) {
		super(messagingService, factory)
		this.registry = registry
	}
	
	def setOccupancy(int segmentID, SegmentOccupancy occupancy) {
		// If the current occupancy differs from the previously stored state
		if (states.get(segmentID) != occupancy) {
			// Set the correct state
			states.set(segmentID, occupancy);
			
			// Note in the following, one is added to the segmentID, because the segments on the
			// table starts from 1, but the indexing because the arrays here starting at 0

			// Log the change
			logger.info('''«segmentID+1» «occupancy»''')
			// Send out the information
			locator.trackElementStateSender.sendSegmentOccupation(segmentID+1, occupancy);		
		}
	}

	def processOccupancy() {
		for (segmentId : LayoutConfiguration.INSTANCE.segments) {
			// Segment 1 to 32, but on byte level we get them from 0 to 31
			val i = segmentId - 1;
			
			// Because of the data order, we proceed backward, therefore the
			// first segment is in the 8th byte
			var byteIndex = 7 - i / 8;
			// But inside the byte, the correct order is maintained, therefore we
			// can simply calculate the offset
			var byteOffset = i % 8;
			
			// Shift and mask the correct bit, and set the occupancy
			var stateInt = (occupancy.get(byteIndex) >> byteOffset).bitwiseAnd(0x01);
			if (stateInt == 0) {
				setOccupancy(i, SegmentOccupancy.FREE)
			} else {
				setOccupancy(i, SegmentOccupancy.OCCUPIED)
			}
		}		
	}

	override run() {
		// Opens up a serial port, given by the -serial application parameter 
		val serial = SerialPort.getCommPort(registry.getParameterStringValue('serial'))
		serial.baudRate = 115200
		serial.openPort()

		while (true) {
			// Shift all the bytes towards the zero index by one
			for (i : 0..occupancy.size - 2) {
				occupancy.set(i, occupancy.get(i + 1))
			}
			// Set the 7th byte with the fresh value read from the serial port
			occupancy.set(7, serial.inputStream.read)
			
			
			// Check if the first 4 byte is the header (0xFF 0xFF 0xFF 0xFF)
			var headerFound = true
			for (i: 0..3) {
				 headerFound = headerFound && (occupancy.get(i) == 0xFF)
			}
			// And if so, process the occupancy vector
			if (headerFound) {
				processOccupancy()
			}
		}
	}

}
