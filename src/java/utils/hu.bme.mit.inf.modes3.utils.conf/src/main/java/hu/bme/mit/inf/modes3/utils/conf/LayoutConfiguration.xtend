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
		private Map<String, Set<Integer>> turnoutsSegmentIds // map turnout ID to segment IDs (the turnout's occupancy can be sensed by this segment)
		private Map<Integer, Integer> turnoutIdBySegmentId // map segment ID to turnout ID (the turnout's occupancy can be sensed by this segment)
		private Map<String, Set<Integer>> turnoutsResponsibilities // which turnout is responsible for which sections
	}

	public static val INSTANCE = new LayoutConfiguration
	private static val LAYOUT_CONFIG = "layout.json"

	private var LayoutConfigurationData layout

	private new() {
		val LayoutConfigurationData loadedConfiguration = GsonLoader.loadTypeFromInputStream(LayoutConfigurationData,
			LayoutConfiguration.classLoader.getResourceAsStream(LAYOUT_CONFIG))

		val inverseMapping = loadedConfiguration.turnoutsSegmentIds.entrySet.stream.flatMap(
			entry |
				entry.value.stream.map[new SimpleEntry(it, entry.key)]
		).collect(Collectors::toMap([it.key], [Integer.valueOf(it.value)]))

		layout = new LayoutConfigurationData(loadedConfiguration.segments, loadedConfiguration.sections,
			loadedConfiguration.turnoutsSegmentIds, inverseMapping, loadedConfiguration.turnoutsResponsibilities)
	}

	def getSections() {
		asUnmodifiableSet(layout.sections)
	}

	def getSegments() {
		asUnmodifiableSet(layout.segments)
	}

	def getTurnoutIds() {
		asUnmodifiableSet(asIntegerSet(layout.turnoutsSegmentIds.keySet))
	}

	/**
	 * @return the segment IDs which belong to the turnouts, aka the turnouts occupancies can be sensed by these segment IDs
	 */
	def getTurnoutSegmentIds() {
		asUnmodifiableSet(layout.turnoutsSegmentIds.values.stream.flatMap[it.stream].collect(Collectors::toSet))
	}

	/**
	 * @return the segment IDs which belong to a particular turnout, aka the (particular) turnout's occupancy can be sensed by these segment IDs. If such turnout ID cannot be found, it returns null. 
	 * E.g. turnout 3 has two segments, segment 25 and 32. By invoking this method with 3, it will return a Set<String> consisting of 25 and 32.
	 */
	def getSegmentIdsOfTurnout(int turnoutId) {
		layout.turnoutsSegmentIds.get(String.valueOf(turnoutId))
	}

	/**
	 * @return the turnout ID, if its occupancy can be sensed by the segmentId; otherwise it returns null
	 * E.g. segment 25 belongs to turnout 3, so invoking this method by 25 it will return 3.
	 */
	def getTurnoutIdFromSegmentId(int segmentId) {
		layout.turnoutIdBySegmentId.get(segmentId)
	}

	/**
	 * @return the TurnoutID -> SegmentID mapping for every turnout. The turnout's occupancy can be sensed by this segment. Note, that more segments may belong to a turnout. 
	 */
	def getTurnoutIdToSegmentIdsMapping() {
		asUnmodifiableMap(convertKeysToInteger(layout.turnoutsSegmentIds))
	}

	/**
	 * @return the SegmentID -> TurnoutID mapping for every segment that belongs to a turnout. The turnout's occupancy can be sensed by this segment. Note that a particular turnout may belong to more segments.
	 */
	def getSegmentIdToTurnoutIdMapping() {
		asUnmodifiableMap(layout.turnoutIdBySegmentId)
	}

	/**
	 * @return sections are controlled by the turnout, identified by its ID
	 */
	def getControlledSections(int turnoutId) {
		asUnmodifiableSet(layout.turnoutsResponsibilities.get(String.valueOf(turnoutId)))
	}

	/**
	 * @return section IDs that are controlled by either turnout
	 */
	def getControlledSectionIds() {
		asUnmodifiableSet(layout.turnoutsResponsibilities.values.flatten.toSet)
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
