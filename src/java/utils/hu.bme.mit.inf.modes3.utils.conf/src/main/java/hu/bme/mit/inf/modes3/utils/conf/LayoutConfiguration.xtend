package hu.bme.mit.inf.modes3.utils.conf

import hu.bme.mit.inf.modes3.components.util.gson.GsonLoader
import java.util.AbstractMap.SimpleEntry
import java.util.Collections
import java.util.Map
import java.util.Set
import java.util.stream.Collectors
import org.eclipse.xtend.lib.annotations.Data

class LayoutConfiguration {

	@Data
	private static class LayoutConfigurationData {
		private Set<String> segments
		private Set<String> sections
		private Map<String, Set<String>> turnoutsWithSegmentIds
		private Map<String, String> turnoutIdBySegmentId
	}

	public static val INSTANCE = new LayoutConfiguration
	private static val LAYOUT_CONFIG = "layout.json"

	private var LayoutConfigurationData layout

	private new() {
		val LayoutConfigurationData loadedConfiguration = GsonLoader.loadTypeFromInputStream(LayoutConfigurationData,
			LayoutConfiguration.classLoader.getResourceAsStream(LAYOUT_CONFIG))

		val inverseMapping = loadedConfiguration.turnoutsWithSegmentIds.entrySet.stream
								.flatMap(entry | entry.value.stream.map[new SimpleEntry(it, entry.key)]) // reverse the key-value mapping for each entry
								.collect(Collectors::toMap([it.key], [it.value]))

		layout = new LayoutConfigurationData(loadedConfiguration.segments, loadedConfiguration.sections,
			loadedConfiguration.turnoutsWithSegmentIds, inverseMapping)
	}

	def getSections() {
		asUnmodifiableSet(layout.sections)
	}

	def getSegments() {
		asUnmodifiableSet(layout.segments)
	}

	def getTurnoutIds() {
		asUnmodifiableSet(layout.turnoutsWithSegmentIds.keySet)
	}

	def getTurnoutSegmentIds() {
		asUnmodifiableSet(layout.turnoutsWithSegmentIds.values.stream.flatMap[it.stream].collect(Collectors::toSet))
	}

	def getTurnoutIdFromSegmentId(String segmentId) {
		layout.turnoutIdBySegmentId.get(segmentId)
	}

	def getSegmentIdsOfTurnout(String turnoutId) {
		layout.turnoutsWithSegmentIds.get(turnoutId)
	}

	def getSectionsAsInteger() {
		asIntegerSet(getSections)
	}

	def getSegmentsAsInteger() {
		asIntegerSet(getSegments)
	}

	def getTurnoutIdsAsInteger() {
		asIntegerSet(getTurnoutIds)
	}

	def getTurnoutSegmentIdsAsInteger() {
		asIntegerSet(getTurnoutSegmentIds)
	}

	def getSegmentIdsOfTurnoutAsInteger(String turnoutId) {
		asIntegerSet(getSegmentIdsOfTurnout(turnoutId))
	}

	def getTurnoutIdFromSegmentIdAsInteger(String segmentId) {
		Integer.valueOf(getTurnoutIdFromSegmentId(segmentId))
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

	private def asIntegerSet(Set<String> set) {
		set.stream.map[Integer.valueOf(it)].collect(Collectors::toSet)
	}

}
