package hu.bme.mit.inf.modes3.utils.conf.layout

import hu.bme.mit.inf.modes3.utils.common.gson.GsonLoader
import java.util.Collections
import java.util.Map
import java.util.Set
import org.eclipse.xtend.lib.annotations.Data

import static extension hu.bme.mit.inf.modes3.utils.common.extensions.MapExtensions.flatMap
import static extension hu.bme.mit.inf.modes3.utils.common.extensions.MapExtensions.map
import static extension hu.bme.mit.inf.modes3.utils.common.extensions.SetExtensions.asIntegerSet

class LayoutConfiguration {

	@Data
	private static class LayoutConfigurationData {
		private Set<Integer> segments
		private Set<Integer> sections
		private Map<String, Set<Integer>> turnoutsSegmentIds // map turnout ID to segment IDs (the turnout's occupancy can be sensed by this segment)
		private Map<Integer, Integer> turnoutIdBySegmentId // map segment ID to turnout ID (the turnout's occupancy can be sensed by this segment)
		private Map<String, Set<Integer>> turnoutsResponsibilities // which turnout is responsible for which sections
		private Map<String, TurnoutVicinity> turnoutVicinities
		private Map<String, SectionVicinity> sectionVicinities
	}

	public static val INSTANCE = new LayoutConfiguration
	private static val LAYOUT_CONFIG = "layout.json"

	private val LayoutConfigurationData layout

	private new() {
		val LayoutConfigurationData loadedConfiguration = GsonLoader.loadTypeFromInputStream(LayoutConfigurationData, class.classLoader.getResourceAsStream(LAYOUT_CONFIG))

		val inverseMapping = loadedConfiguration.turnoutsSegmentIds.flatMap([key, value|value -> Integer.valueOf(key)])

		layout = new LayoutConfigurationData(loadedConfiguration.segments, loadedConfiguration.sections, loadedConfiguration.turnoutsSegmentIds, inverseMapping, loadedConfiguration.turnoutsResponsibilities, loadedConfiguration.turnoutVicinities, loadedConfiguration.sectionVicinities)
	}

	def getSections() {
		asUnmodifiableSet(layout.sections)
	}

	def getSegments() {
		asUnmodifiableSet(layout.segments)
	}

	def getTurnoutIds() {
		asUnmodifiableSet(layout.turnoutsSegmentIds.keySet.asIntegerSet)
	}

	/**
	 * @return the segment IDs which belong to the turnouts, aka the turnouts occupancies can be sensed by these segment IDs
	 */
	def getTurnoutSegmentIds() {
		asUnmodifiableSet(layout.turnoutsSegmentIds.values.flatten.toSet)
	}

	/**
	 * @return the segment IDs which belong to a particular turnout, aka the (particular) turnout's occupancy can be sensed by these segment IDs. If such turnout ID cannot be found, then returns null. 
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
	 * @return section IDs that are controlled by any turnout
	 */
	def getControlledSectionIds() {
		asUnmodifiableSet(layout.turnoutsResponsibilities.values.flatten.toSet)
	}

	/**
	 * @return the vicinity of the section
	 */
	def getSectionVicinity(int sectionId) {
		layout.sectionVicinities.get(String.valueOf(sectionId))
	}

	/**
	 * @return IDs of sections which are neighbours of sectionId (param), such that their owner turnout
	 * ID is different from the sectionId's (param) owner turnout
	 */
	def getNeighbourSectionIds(int sectionId) {
		val sectionVicinity = getSectionVicinity(sectionId)
		val ownerTurnout = sectionVicinity.ownerTurnout
		val neighbourIDs = newHashSet
		#[sectionVicinity.cw, sectionVicinity.ccw].filter[it !== null].forEach [
			val neighbourSection = getSectionVicinity(it)
			if(neighbourSection === null) {
				val turnoutId = getTurnoutIdFromSegmentId(it)
				if(turnoutId != ownerTurnout) {
					neighbourIDs.add(it)
				} else {
					val turnoutVicinity = getTurnoutVicinity(turnoutId)
					#[turnoutVicinity.divergent, turnoutVicinity.straight, turnoutVicinity.facing].forEach[forEach[addNeighbourIfOwnerIsDifferent(it, ownerTurnout, neighbourIDs)]]
				}
			} else {
				addNeighbourIfOwnerIsDifferent(it, ownerTurnout, neighbourIDs)
			}
		]
		return neighbourIDs
	}

	private def addNeighbourIfOwnerIsDifferent(int neighbourSectionId, int respectiveOwnerId, Set<Integer> neighbourIDs) {
		val neighbourOwner = getSectionVicinity(neighbourSectionId)?.ownerTurnout
		if(neighbourOwner !== null && neighbourOwner != respectiveOwnerId) {
			neighbourIDs.add(neighbourSectionId)
		}
	}

	/**
	 * get the IDs of the segments that are connected, if the turnout's direction is the given direction
	 */
	def getConnectedSegmentsByTurnoutVicinities(int turnoutId, SegmentDirection direction) {
		val supportedDirections = #{SegmentDirection.STRAIGHT, SegmentDirection.DIVERGENT}
		if(!supportedDirections.contains(direction)) {
			return null
		}

		val vicinities = layout.turnoutVicinities.get(String.valueOf(turnoutId))
		val strOrDivSegments = getTurnoutVicinitySegmentsByDirection(turnoutId, direction)
		val turnoutSegmentItself = getSegmentIdsOfTurnout(turnoutId)

		val segmentIds = newHashSet
		segmentIds.addAll(strOrDivSegments)
		segmentIds.addAll(vicinities.facing)
		segmentIds.addAll(turnoutSegmentItself)

		segmentIds
	}

	/**
	 * @return the vicinity of the turnout: which segment is connected from which direction to the turnout
	 */
	def getTurnoutVicinity(int turnoutId) {
		layout.turnoutVicinities.get(String.valueOf(turnoutId))
	}

	/**
	 * Get the IDs of segments which are in the vicinity of a turnout and connect to the turnout from the specified direction.
	 */
	def getTurnoutVicinitySegmentsByDirection(int turnoutId, SegmentDirection direction) {
		val turnoutVicinity = getTurnoutVicinity(turnoutId)
		switch (direction) {
			case TURNOUT_ITSELF: getSegmentIdsOfTurnout(turnoutId)
			case STRAIGHT: turnoutVicinity.straight
			case DIVERGENT: turnoutVicinity.divergent
			case FACING: turnoutVicinity.facing
		}
	}

	private def <T> asUnmodifiableSet(Set<T> set) {
		Collections.unmodifiableSet(set)
	}

	private def <T, U> asUnmodifiableMap(Map<T, U> map) {
		Collections.unmodifiableMap(map)
	}

	private def convertKeysToInteger(Map<String, Set<Integer>> map) {
		map.map([key, value|Integer.valueOf(key) -> value])
	}

}
