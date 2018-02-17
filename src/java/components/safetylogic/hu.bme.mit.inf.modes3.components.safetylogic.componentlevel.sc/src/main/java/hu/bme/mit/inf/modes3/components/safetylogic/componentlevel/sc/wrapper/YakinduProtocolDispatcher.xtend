package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.ConnectionDirection
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher.IYakinduMessageSender
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comparators.ProvidedProtocolInterfaceComparator
import java.util.Map
import java.util.Set
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ConcurrentSkipListSet
import org.eclipse.xtend.lib.annotations.Data
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class YakinduProtocolDispatcher implements IYakinduProtocolDispatcher, IYakinduMessageSender {

	val Logger logger
	val Map<Integer, Set<PortWithDirection>> segmentsToBeNotified

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(class.name)
		this.segmentsToBeNotified = new ConcurrentHashMap
	}

	override registerSegment(int segmentID, PortWithDirection portToBeNotified) {
		var Set<PortWithDirection> ports = segmentsToBeNotified.get(segmentID)
		if(ports === null) {
			synchronized(this) {
				if(ports === null) {
					ports = new ConcurrentSkipListSet
					segmentsToBeNotified.put(segmentID, ports)
				}
			}
		}
		ports.add(portToBeNotified)
	}

	override canGoTo(int targetID, ConnectionDirection direction) {
		logger.debug('''YakinduCanGoTo message received with id=«targetID» direction=«direction»''')
		getTargetPort(targetID, direction)?.raiseCanGo
	}

	override cannotGoTo(int targetID, ConnectionDirection direction) {
		logger.debug('''YakinduCannotGoTo message received with id=«targetID» direction=«direction»''')
		getTargetPort(targetID, direction)?.raiseCannotGo
	}

	override releaseTo(int targetID, ConnectionDirection direction) {
		logger.debug('''YakinduReleaseTo message received with id=«targetID» direction=«direction»''')
		getTargetPort(targetID, direction)?.raiseRelease
	}

	override reserveTo(int targetID, ConnectionDirection direction) {
		logger.debug('''YakinduReserveTo message received with id=«targetID» direction=«direction»''')
		getTargetPort(targetID, direction)?.raiseReserve
	}

	private def getTargetPort(int targetID, ConnectionDirection direction) {
		val targetSegment = segmentsToBeNotified.get(targetID)?.findFirst[it.direction == direction]
		logger.trace('''Yakindu target port was «IF targetSegment === null»not«ENDIF» found with id=«targetID» direction=«direction»''')
		targetSegment?.providedPort
	}
}

@Data
class PortWithDirection implements Comparable<PortWithDirection> {
	ConnectionDirection direction
	ProtocolInterface.Provided providedPort

	override compareTo(PortWithDirection o) {
		val i = direction.compareTo(o.direction)
		if(i != 0) {
			return i
		} else {
			return (new ProvidedProtocolInterfaceComparator).compare(providedPort, o.providedPort)
		}
	}
}
