package hu.bme.mit.inf.modes3.utils.common.extensions

import java.util.Set

/**
 * Extension methods of {@link Set}.
 * 
 * @author benedekh
 */
class SetExtensions {

	/**
	 * @param set the values to be converted to Integer.
	 * @return each value of the parameters Set converted to Integer
	 */
	def static asIntegerSet(Set<String> set) {
		set.map[Integer.valueOf(it)].toSet
	}

	/**
	 * @param set the values to be converted to String.
	 * @return each value of the parameters Set converted to String
	 */
	def static asStringSet(Set<Integer> set) {
		set.map[String.valueOf(it)].toSet
	}
}
