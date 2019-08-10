package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comparators

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface.Provided
import java.util.Comparator

/**
 * Compares two {@link ProtocolInterface.Provided} instances by their hash codes. 
 * 
 * @author benedekh
 */
class ProvidedProtocolInterfaceComparator implements Comparator<ProtocolInterface.Provided> {

	val comparator = new HashCodeComparator

	override compare(Provided o1, Provided o2) {
		comparator.compare(o1, o2)
	}

}
