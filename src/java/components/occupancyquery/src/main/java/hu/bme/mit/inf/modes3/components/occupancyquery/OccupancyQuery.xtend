package hu.bme.mit.inf.modes3.components.occupancyquery

import com.fazecast.jSerialComm.SerialPort
import hu.bme.mit.inf.modes3.components.occupancyquery.bridge.IOccupancyQueryBridge
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * The occupancy query application that receives the occupancies of the
 * segments (of the railway track) and broadcasts this information on the communication
 * network.
 * 
 * Each bit of the vector represents a segment on the railway track. If the bit is
 * 1 then the segment is occupied, if 0 then it is free. The ID of the segment corresponds
 * to the index of the bit in the vector.
 * 
 * The correct message format received from the SOC controller is the following:
 * byte 1  2  3  4  5  6  7  8 
 * data FF FF FF FF DD DD DD DD
 * 
 * Where D marks the useful data
 * 
 * Because the 32nd segment is not connected anywhere, we can use this to signal
 * the packet by sending 4 consecutive 0xFF byte.
 * 
 * @author baloghlaszlo, zsoltmazlo, benedekh
 **/
class OccupancyQuery implements IOccupancyQuery {

	// The registry holding the application parameters
	val ArgumentRegistry registry

	// Wrapper around the component
	@Accessors(PUBLIC_SETTER) var IOccupancyQueryBridge occupancyQueryBridge

	val Logger logger

	// The byte vector storing the incoming data
	val int[] occupancy = newIntArrayOfSize(8)
	// The occupancy vector containing the current status
	val SegmentOccupancy[] states = newArrayOfSize(32)

	/**
	 * @param registry the command-line arguments of the application
	 * @param loggerFactory the logger factory
	 */
	new(ArgumentRegistry registry, ILoggerFactory factory) {
		this.registry = registry
		this.logger = factory.getLogger(this.class.name)
	}

    /**
     * Updates and broadcasts the occupancy of the given segment based on the latest status.
     * 
     * @param segmentID the ID of the segment on the track
     * @param occupancy the latest occupancy status of the segment
     */
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
			occupancyQueryBridge.sendSegmentOccupation(segmentID + 1, occupancy);
		}
	}

    /**
     * Processes the segment occupancy that are received in a raw format from the sensor and
     * translates these occupancies for objects in Java.
     */
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

	/**
	 * Reads and processes the segment occupancies from the sensor.
	 */
	override run() {
		// Opens up a serial port, given by the -serial application parameter 
		val serial = SerialPort.getCommPort(registry.getParameterStringValue('serial'))
		serial.baudRate = 115200
		serial.openPort

		while (true) {
			// Shift all the bytes towards the zero index by one
			for (i : 0 .. occupancy.size - 2) {
				occupancy.set(i, occupancy.get(i + 1))
			}
			// Set the 7th byte with the fresh value read from the serial port
			occupancy.set(7, serial.inputStream.read)

			// Check if the first 4 byte is the header (0xFF 0xFF 0xFF 0xFF)
			var headerFound = true
			for (i : 0 .. 3) {
				headerFound = headerFound && (occupancy.get(i) == 0xFF)
			}
			// And if so, process the occupancy vector
			if (headerFound) {
				processOccupancy
			}
		}
	}

}
