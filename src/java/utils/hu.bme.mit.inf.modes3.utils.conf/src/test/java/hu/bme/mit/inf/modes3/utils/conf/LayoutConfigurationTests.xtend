package hu.bme.mit.inf.modes3.utils.conf

import java.util.stream.Collectors
import org.junit.Assert
import org.junit.Test

class LayoutConfigurationTests {

	@Test def void segmentsTest() {
		val referenceSegments = (1 .. 32).toSet.stream.filter[it != 16].collect(Collectors::toSet)
		val loadedSegments = LayoutConfiguration.INSTANCE.segments
		Assert.assertEquals(referenceSegments, loadedSegments)
	}

	@Test def void sectionsTest() {
		val exclusions = #{3, 9, 14, 16, 21, 25, 28, 32}
		val referenceSections = (1 .. 32).toSet.stream.filter[!exclusions.contains(it)].collect(Collectors::toSet)
		val loadedSections = LayoutConfiguration.INSTANCE.sections
		Assert.assertEquals(referenceSections, loadedSections)
	}

	@Test def void turnoutsTest() {
		val referenceTurnouts = (1 .. 6).toSet
		val loadedTurnouts = LayoutConfiguration.INSTANCE.turnoutIds
		Assert.assertEquals(referenceTurnouts, loadedTurnouts)
	}

	@Test def void turnoutSegmentIdsTest() {
		val referenceSegments = #{3, 9, 14, 21, 25, 28, 32}
		val loadedSegmentIds = LayoutConfiguration.INSTANCE.turnoutSegmentIds
		Assert.assertEquals(referenceSegments, loadedSegmentIds)
	}

	@Test def void unusedSegmentIdTest() {
		val referenceUnusedSegmentId = 16
		val loadedSegments = LayoutConfiguration.INSTANCE.segments
		val loadedSections = LayoutConfiguration.INSTANCE.sections
		val loadedTurnoutSegments = LayoutConfiguration.INSTANCE.turnoutSegmentIds

		Assert.assertFalse(loadedSegments.contains(referenceUnusedSegmentId))
		Assert.assertFalse(loadedSections.contains(referenceUnusedSegmentId))
		Assert.assertFalse(loadedTurnoutSegments.contains(referenceUnusedSegmentId))
	}

	@Test def void oneSegmentBelongsToATurnoutTest() {
		val referenceTurnoutId = 2
		val referenceSegmentId = #{28}
		val loadedSegmentId = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(referenceTurnoutId)
		Assert.assertEquals(referenceSegmentId, loadedSegmentId)
	}

	@Test def void moreSegmentsBelongToATurnoutTest() {
		val referenceTurnoutId = 3
		val referenceSegmentIds = #{25, 32}
		val loadedSegmentIds = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(referenceTurnoutId)
		Assert.assertEquals(referenceSegmentIds, loadedSegmentIds)
	}

	@Test def void turnoutIdFromSegmentIdTest() {
		val referenceSegmentId = 28
		val referenceTurnoutId = 2
		val loadedTurnoutId = LayoutConfiguration.INSTANCE.getTurnoutIdFromSegmentId(referenceSegmentId)
		Assert.assertEquals(referenceTurnoutId, loadedTurnoutId)
	}

	@Test def void turnoutIdFromSegmentIdForTurnoutWithMultipleSegmentsTest() {
		val referenceSegmentIds = #{25, 32}
		val referenceTurnoutId = 3

		referenceSegmentIds.forEach [ referenceSegmentId |
			val loadedTurnoutId = LayoutConfiguration.INSTANCE.getTurnoutIdFromSegmentId(referenceSegmentId)
			Assert.assertEquals(referenceTurnoutId, loadedTurnoutId)
		]
	}

	@Test def void segmentIdToTurnoutIdMappingTest() {
		val referenceSegmentIds = #{25, 32}
		val referenceTurnoutId = 3
		val loadedSegmentIdToTurnoutIdMapping = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

		referenceSegmentIds.forEach [ referenceSegmentId |
			val loadedTurnoutId = loadedSegmentIdToTurnoutIdMapping.get(referenceSegmentId)
			Assert.assertEquals(referenceTurnoutId, loadedTurnoutId)
		]
	}

	@Test def void turnoutIdToSegmentIdMappingTest() {
		val referenceTurnoutId = 3
		val referenceSegmentIds = #{25, 32}

		val loadedSegmentIds = LayoutConfiguration.INSTANCE.turnoutIdToSegmentIdsMapping.get(referenceTurnoutId)
		Assert.assertEquals(referenceSegmentIds, loadedSegmentIds)
	}

}
