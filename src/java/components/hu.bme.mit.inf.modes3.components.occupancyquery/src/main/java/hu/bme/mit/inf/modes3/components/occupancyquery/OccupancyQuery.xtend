package hu.bme.mit.inf.modes3.components.occupancyquery

import com.fazecast.jSerialComm.SerialPort
import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.components.util.jopt.ArgumentRegistry
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import org.slf4j.ILoggerFactory

class OccupancyQuery extends AbstractRailRoadCommunicationComponent {

	val ArgumentRegistry registry

	val int[] occupancy = newIntArrayOfSize(8)
	val SegmentOccupancy[] states = newArrayOfSize(32)

	new(CommunicationStack stack, ILoggerFactory factory, ArgumentRegistry registry) {
		super(stack, factory)
		this.registry = registry
	}
	
	def setOccupancy(int segmentID, SegmentOccupancy occupancy) {
		if (states.get(segmentID) != occupancy) {
			states.set(segmentID, occupancy);
			logger.info('''«segmentID+1» «occupancy»''')
			locator.trackElementStateSender.sendSegmentOccupation(segmentID+1, occupancy);		
		}
	}

	def processOccupancy() {
		for (i : 0..30) {
			var byteIndex = 7 - i / 8;
			var byteOffset = i % 8;
			
			var stateInt = (occupancy.get(byteIndex) >> byteOffset).bitwiseAnd(0x01);
			if (stateInt == 0) {
				setOccupancy(i, SegmentOccupancy.FREE)
			} else {
				setOccupancy(i, SegmentOccupancy.OCCUPIED)
			}
		}		
	}

	override run() {
		// Open up a serial 
		val serial = SerialPort.getCommPort(registry.getParameterStringValue('serial'))
		serial.baudRate = 9600
		serial.openPort()

		while (true) {
			for (i : 0..occupancy.size - 2) {
				occupancy.set(i, occupancy.get(i + 1))
			}
			occupancy.set(7, serial.inputStream.read)
			
			var headerFound = true
			for (i: 0..3) {
				 headerFound = headerFound && (occupancy.get(i) == 0xFF)
			}
			if (headerFound) {
				processOccupancy()
			}
		}
	}

}
