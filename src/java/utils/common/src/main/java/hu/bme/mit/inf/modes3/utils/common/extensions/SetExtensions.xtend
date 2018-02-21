package hu.bme.mit.inf.modes3.utils.common.extensions

import java.util.Set

class SetExtensions {

	def static asIntegerSet(Set<String> set) {
		set.map[Integer.valueOf(it)].toSet
	}

	def static asStringSet(Set<Integer> set) {
		set.map[String.valueOf(it)].toSet
	}
}
