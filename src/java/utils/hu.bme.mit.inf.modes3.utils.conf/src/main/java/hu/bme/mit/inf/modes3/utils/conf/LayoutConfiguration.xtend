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
		private Set<Integer> segments
		private Set<Integer> sections
		private Map<String, Set<Integer>> turnoutsWithSegmentIds // map turnout ID to segment IDs (the turnout's occupancy can be sensed by this segment)
		private Map<Integer, Integer> turnoutIdBySegmentId // map segment ID to turnout ID (the turnout's occupancy can be sensed by this segment)
	}

	public static val INSTANCE = new LayoutConfiguration
	private static val LAYOUT_CONFIG = "layout.json"

	private var LayoutConfigurationData layout

	private new() {
		val LayoutConfigurationData loadedConfiguration = GsonLoader.loadTypeFromInputStream(LayoutConfigurationData,
			LayoutConfiguration.classLoader.getResourceAsStream(LAYOUT_CONFIG))

		val inverseMapping = loadedConfiguration.turnoutsWithSegmentIds.entrySet.stream.flatMap(
			entry |
				entry.value.stream.map[new SimpleEntry(it, entry.key)]
		).collect(Collectors::toMap([it.key], [Integer.valueOf(it.value)]))

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
		asIntegerSet(asUnmodifiableSet(layout.turnoutsWithSegmentIds.keySet))
	}

	/**
	 * @return the segment IDs which belong to the turnouts, aka the turnouts occupancies can be sensed by these segment IDs
	 */
	def getTurnoutSegmentIds() {
		asUnmodifiableSet(layout.turnoutsWithSegmentIds.values.stream.flatMap[it.stream].collect(Collectors::toSet))
	}

	/**
	 * @return the segment IDs which belong to a particular turnout, aka the (particular) turnout's occupancy can be sensed by these segment IDs. If such turnout ID cannot be found, it returns null. 
	 * E.g. turnout 3 has two segments, segment 25 and 32. By invoking this method with 3, it will return a Set<String> consisting of 25 and 32.
	 */
	def getSegmentIdsOfTurnout(Integer turnoutId) {
		layout.turnoutsWithSegmentIds.get(String.valueOf(turnoutId))
	}

	/**
	 * @return the turnout ID, if its occupancy can be sensed by the segmentId; otherwise it returns null
	 * E.g. segment 25 belongs to turnout 3, so invoking this method by 25 it will return 3.
	 */
	def getTurnoutIdFromSegmentId(Integer segmentId) {
		layout.turnoutIdBySegmentId.get(segmentId)
	}

	/**
	 * @return the TurnoutID -> segmentID mapping for every turnout. Note, that more segments may belong to a turnout. 
	 */
	def getTurnoutIdToSegmentIdsMapping() {
		convertKeysToInteger(asUnmodifiableMap(layout.turnoutsWithSegmentIds))
	}

	/**
	 * @return the SegmentID -> turnout ID mapping for every segment that belongs to a turnout. Note that a particular turnout may belong to more segments.
	 */
	def getSegmentIdToTurnoutIdMapping() {
		asUnmodifiableMap(layout.turnoutIdBySegmentId)
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

	private def <T, U> asUnmodifiableMap(Map<T, U> map) {
		Collections.unmodifiableMap(map)
	}

	private def asIntegerSet(Set<String> set) {
		set.stream.map[Integer.valueOf(it)].collect(Collectors::toSet)
	}

	private def convertKeysToInteger(Map<String, Set<Integer>> map) {
		map.entrySet.stream.map[entry|new SimpleEntry(Integer.valueOf(entry.key), entry.value)].collect(
			Collectors::toMap([it.key], [it.value]))
	}

}
