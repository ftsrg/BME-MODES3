package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher.IYakinduMessageSender
import hu.bme.mit.inf.modes3.utils.conf.layout.whole.ConnectionDirection
import java.util.Map
import java.util.Set
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListSet
import org.eclipse.xtend.lib.annotations.Data

class YakinduProtocolDispatcher implements IYakinduProtocolDispatcher, IYakinduMessageSender {

	val Map<Integer, Set<PortWithDirection>> segmentsToBeNotified = new ConcurrentHashMap

	override registerSegment(int segmentID, PortWithDirection portToBeNotified) {
		var Set<PortWithDirection> ports = segmentsToBeNotified.get(segmentID)
		if(ports === null) {
			synchronized(ports) {
				if(ports === null) {
					ports = new ConcurrentSkipListSet
					segmentsToBeNotified.put(segmentID, ports)
				}
			}
		}
		ports.add(portToBeNotified)
	}

	override canGoTo(int targetID, ConnectionDirection direction) {
		getTargetPort(targetID, direction)?.raiseCanGo
	}

	override cannotGoTo(int targetID, ConnectionDirection direction) {
		getTargetPort(targetID, direction)?.raiseCannotGo
	}

	override releaseTo(int targetID, ConnectionDirection direction) {
		getTargetPort(targetID, direction)?.raiseRelease
	}

	override reserveTo(int targetID, ConnectionDirection direction) {
		getTargetPort(targetID, direction)?.raiseReserve
	}

	private def getTargetPort(int targetID, ConnectionDirection direction) {
		segmentsToBeNotified.get(targetID)?.findFirst[it.direction == direction]?.providedPort
	}
}

@Data
class PortWithDirection {
	ConnectionDirection direction
	ProtocolInterface.Provided providedPort
}
