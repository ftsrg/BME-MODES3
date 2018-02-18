package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comparators

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface.Provided
import java.util.Comparator

class ProvidedSectionControlInterfaceComparator implements Comparator<SectionControlInterface.Provided> {

	val comparator = new HashCodeComparator

	override compare(Provided o1, Provided o2) {
		comparator.compare(o1, o2)
	}

}
