package hu.bme.mit.inf.modes3.utils.conf

import hu.bme.mit.inf.modes3.utils.common.gson.GsonLoader
import java.util.Collections
import java.util.HashSet
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

import static extension hu.bme.mit.inf.modes3.utils.common.extensions.MapExtensions.map

class LocomotivesConfiguration {

	@Data
	private static class LocomotivesConfigurationData {
		private Map<String, Integer> locomotiveIds
	}

	public static val INSTANCE = new LocomotivesConfiguration
	private static val LOCOMOTIVES_CONFIG = "locomotives.json"

	private var LocomotivesConfigurationData locomotives

	private new() {
		locomotives = GsonLoader.loadTypeFromInputStream(LocomotivesConfigurationData,
			LocomotivesConfiguration.classLoader.getResourceAsStream(LOCOMOTIVES_CONFIG))
		lowercaseEveryTrainName
	}

	def getLocomotiveIdByName(String name) {
		val lowercased = if(name.isNullOrEmpty) name else name.toLowerCase
		locomotives.locomotiveIds.get(lowercased)
	}

	def getLocomotiveNames() {
		asUnmodifiableSet(locomotives.locomotiveIds.keySet)
	}

	def getLocomotiveIds() {
		asUnmodifiableSet(new HashSet<Integer>(locomotives.locomotiveIds.values))
	}

	def getLocomotivesWithNameAndId() {
		asUnmodifiableMap(locomotives.locomotiveIds)
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

	private def <T, U> asUnmodifiableMap(Map<T, U> map) {
		Collections.unmodifiableMap(map)
	}

	private def lowercaseEveryTrainName() {
		val lowercasedNames = locomotives.locomotiveIds.map([key, value|key.toLowerCase -> value])
		locomotives.locomotiveIds.clear
		locomotives.locomotiveIds.putAll(lowercasedNames)
	}

}
