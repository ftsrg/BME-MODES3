package hu.bme.mit.inf.modes3.utils.conf

import hu.bme.mit.inf.modes3.components.util.gson.GsonLoader
import java.util.Collections
import java.util.HashSet
import java.util.Map
import java.util.Set
import java.util.stream.Collectors
import org.eclipse.xtend.lib.annotations.Data

class LocomotivesConfiguration {

	@Data
	private static class LocomotivesConfigurationData {
		private Map<String, String> locomotiveIds
	}

	public static val INSTANCE = new LocomotivesConfiguration
	private static val LOCOMOTIVES_CONFIG = "locomotives.json"

	private var LocomotivesConfigurationData locomotives

	private new() {
		locomotives = GsonLoader.loadTypeFromInputStream(LocomotivesConfigurationData,
			LocomotivesConfiguration.classLoader.getResourceAsStream(LOCOMOTIVES_CONFIG))
	}

	def getLocomotiveIdByName(String name) {
		locomotives.locomotiveIds.get(name)
	}

	def getLocomotiveNames() {
		asUnmodifiableSet(locomotives.locomotiveIds.keySet)
	}

	def getLocomotiveIds() {
		asUnmodifiableSet(new HashSet<String>(locomotives.locomotiveIds.values))
	}

	def getLocomotivesWithNameAndId() {
		asUnmodifiableMap(locomotives.locomotiveIds)
	}

	def getLocomotiveIdByNameAsInteger(String name) {
		Integer.valueOf(getLocomotiveIdByName(name))
	}

	def getLocomotiveIdsAsInteger() {
		asIntegerSet(getLocomotiveIds)
	}

	def getLocomotivesWithNameAndIdAsInteger() {
		asIntegerValuesMap(getLocomotivesWithNameAndId)
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

	private def <T, U> asUnmodifiableMap(Map<T, U> map) {
		Collections.unmodifiableMap(map)
	}

	private def asIntegerSet(Set<String> set) {
		set.stream().map[Integer.valueOf(it)].collect(Collectors::toSet)
	}

	private def asIntegerValuesMap(Map<String, String> map) {
		map.entrySet.stream.collect(Collectors.toMap([it.key], [Integer.valueOf(it.value)]))
	}
}
