package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comparators

import java.util.Comparator

/**
 * Compares two {@link Object}s by {@link Object#hashCode()}.
 * 
 * @author benedekh
 */
class HashCodeComparator implements Comparator<Object>{

	override compare(Object o1, Object o2) {
		val o1hash = o1.hashCode
		val o2hash = o2.hashCode
		if(o1hash < o2hash) {
			return -1
		} else if(o1hash > o2hash) {
			return 1
		} else {
			return 0
		}
	}

}
