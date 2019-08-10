package hu.bme.mit.inf.modes3.utils.conf

import hu.bme.mit.inf.modes3.utils.conf.layout.LayoutConfiguration
import hu.bme.mit.inf.modes3.utils.conf.layout.SegmentDirection
import org.junit.Assert
import org.junit.Test

/**
 * Test class of {@link LayoutConfiguration}.
 * 
 * @author benedekh
 */
class LayoutConfigurationTests {
	
	/**
	 * Test if every segment is correctly registered.
	 */
	@Test def void segmentsTest() {
		val referenceSegments = (1 .. 32).filter[it != 16].toSet
		val loadedSegments = LayoutConfiguration.INSTANCE.segments
		Assert.assertEquals(referenceSegments, loadedSegments)
	}

/**
	 * Test if every section is correctly registered.
	 */
	@Test def void sectionsTest() {
		val exclusions = #{3, 9, 14, 16, 21, 25, 28, 32}
		val referenceSections = (1 .. 32).filter[!exclusions.contains(it)].toSet
		val loadedSections = LayoutConfiguration.INSTANCE.sections
		Assert.assertEquals(referenceSections, loadedSections)
	}

	/**
	 * Test if every turnout is correctly registered.
	 */
	@Test def void turnoutsTest() {
		val referenceTurnouts = (1 .. 6).toSet
		val loadedTurnouts = LayoutConfiguration.INSTANCE.turnoutIds
		Assert.assertEquals(referenceTurnouts, loadedTurnouts)
	}

	/**
	 * Test if the turnouts as segments are correctly registered.
	 */
	@Test def void turnoutSegmentIdsTest() {
		val referenceSegments = #{3, 9, 14, 21, 25, 28, 32}
		val loadedSegmentIds = LayoutConfiguration.INSTANCE.turnoutSegmentIds
		Assert.assertEquals(referenceSegments, loadedSegmentIds)
	}

	/**
	 * Test if the unused segment is not registered.
	 */
	@Test def void unusedSegmentIdTest() {
		val referenceUnusedSegmentId = 16
		val loadedSegments = LayoutConfiguration.INSTANCE.segments
		val loadedSections = LayoutConfiguration.INSTANCE.sections
		val loadedTurnoutSegments = LayoutConfiguration.INSTANCE.turnoutSegmentIds

		Assert.assertFalse(loadedSegments.contains(referenceUnusedSegmentId))
		Assert.assertFalse(loadedSections.contains(referenceUnusedSegmentId))
		Assert.assertFalse(loadedTurnoutSegments.contains(referenceUnusedSegmentId))
	}

	/**
	 * Test if a specific segment is correctly registered to its turnout.
	 */
	@Test def void oneSegmentBelongsToATurnoutTest() {
		val referenceTurnoutId = 2
		val referenceSegmentId = #{28}
		val loadedSegmentId = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(referenceTurnoutId)
		Assert.assertEquals(referenceSegmentId, loadedSegmentId)
	}

	/**
	 * Test if more segments that belong to the same turnout are correctly registered.
	 */
	@Test def void moreSegmentsBelongToATurnoutTest() {
		val referenceTurnoutId = 3
		val referenceSegmentIds = #{25, 32}
		val loadedSegmentIds = LayoutConfiguration.INSTANCE.getSegmentIdsOfTurnout(referenceTurnoutId)
		Assert.assertEquals(referenceSegmentIds, loadedSegmentIds)
	}

	/**
	 * Test if turnout identified by its segment ID has the correct turnout ID. 
	 */
	@Test def void turnoutIdFromSegmentIdTest() {
		val referenceSegmentId = 28
		val referenceTurnoutId = 2
		val loadedTurnoutId = LayoutConfiguration.INSTANCE.getTurnoutIdFromSegmentId(referenceSegmentId)
		Assert.assertEquals(referenceTurnoutId, loadedTurnoutId)
	}

	/**
	 * Test if the turnout that consists of more segments has its correct turnout ID.
	 */
	@Test def void turnoutIdFromSegmentIdForTurnoutWithMultipleSegmentsTest() {
		val referenceSegmentIds = #{25, 32}
		val referenceTurnoutId = 3

		referenceSegmentIds.forEach [ referenceSegmentId |
			val loadedTurnoutId = LayoutConfiguration.INSTANCE.getTurnoutIdFromSegmentId(referenceSegmentId)
			Assert.assertEquals(referenceTurnoutId, loadedTurnoutId)
		]
	}
	
	/**
	 * Test if the turnout that consists of more segments has its correct turnout ID.
	 */
	@Test def void segmentIdToTurnoutIdMappingTest() {
		val referenceSegmentIds = #{25, 32}
		val referenceTurnoutId = 3
		val loadedSegmentIdToTurnoutIdMapping = LayoutConfiguration.INSTANCE.segmentIdToTurnoutIdMapping

		referenceSegmentIds.forEach [ referenceSegmentId |
			val loadedTurnoutId = loadedSegmentIdToTurnoutIdMapping.get(referenceSegmentId)
			Assert.assertEquals(referenceTurnoutId, loadedTurnoutId)
		]
	}

	/**
	 * Test if a turnout that consists of more segments have the correct segment IDs.
	 */
	@Test def void turnoutIdToSegmentIdMappingTest() {
		val referenceTurnoutId = 3
		val referenceSegmentIds = #{25, 32}

		val loadedSegmentIds = LayoutConfiguration.INSTANCE.turnoutIdToSegmentIdsMapping.get(referenceTurnoutId)
		Assert.assertEquals(referenceSegmentIds, loadedSegmentIds)
	}

	/**
	 * Test if the turnout has the correct sections registered.
	 */
	@Test def void turnoutControlsSectionsTest() {
		val referenceSectionIds = #{20, 26, 30, 19}
		val loadedSectionIds = LayoutConfiguration.INSTANCE.getControlledSections(3)
		Assert.assertEquals(referenceSectionIds, loadedSectionIds)
	}

	/**
	 * Test if every section of the track is controlled by at least one turnout.
	 */
	@Test def void everySectionIsControlledByAtLeastOneTurnoutTest() {
		val referenceSectionIds = LayoutConfiguration.INSTANCE.sections
		val loadedSectionIds = LayoutConfiguration.INSTANCE.controlledSectionIds
		Assert.assertEquals(referenceSectionIds, loadedSectionIds)
	}
	
	/**
	 * Test if the sections that belong to the turnout #1 from STRAIGHT direction are correctly registered. 
	 */
	@Test def void turnout1VicinitiesStraightTest() {
		val referenceSegmentIds = #{12, 15, 14}
		val controlledSegments = LayoutConfiguration.INSTANCE.getConnectedSegmentsByTurnoutVicinities(1, SegmentDirection.STRAIGHT)
		Assert.assertEquals(referenceSegmentIds, controlledSegments)
	}

	/**
	 * Test if the sections that belong to the turnout #1 from DIVERGENT direction are correctly registered. 
	 */
	@Test def void turnout1VicinitiesDivergentTest() {
		val referenceSegmentIds = #{11, 15, 14}
		val controlledSegments = LayoutConfiguration.INSTANCE.getConnectedSegmentsByTurnoutVicinities(1, SegmentDirection.DIVERGENT)
		Assert.assertEquals(referenceSegmentIds, controlledSegments)
	}

	/**
	 * Test if the sections that belong to the turnout #3 from STRAIGHT direction are correctly registered. 
	 */
	@Test def void turnout3VicinitiesStraightTest() {
		val referenceSegmentIds = #{20, 26, 19, 30, 32, 25}
		val controlledSegments = LayoutConfiguration.INSTANCE.getConnectedSegmentsByTurnoutVicinities(3, SegmentDirection.STRAIGHT)
		Assert.assertEquals(referenceSegmentIds, controlledSegments)
	}

	/**
	 * Test if the sections that belong to the turnout #3 from DIVERGENT direction are correctly registered. 
	 */
	@Test def void turnout3VicinitiesDivergentTest() {
		val referenceSegmentIds = #{20, 30, 25, 32}
		val controlledSegments = LayoutConfiguration.INSTANCE.getConnectedSegmentsByTurnoutVicinities(3, SegmentDirection.DIVERGENT)
		Assert.assertEquals(referenceSegmentIds, controlledSegments)
	}

}
