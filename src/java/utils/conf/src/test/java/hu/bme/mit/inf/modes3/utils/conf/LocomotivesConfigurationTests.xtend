package hu.bme.mit.inf.modes3.utils.conf

import org.junit.Assert
import org.junit.Test

/**
 * Test class of {@link LocomotivesConfiguration}.
 * 
 * @author benedekh
 */
class LocomotivesConfigurationTests {

	/**
	 * Test if all locomotives are correctly registered by name.
	 */
	@Test def void locomotiveNamesTest() {
		val referenceNames = #{"br294", "sncf", "taurus"}
		val loadedNames = LocomotivesConfiguration.INSTANCE.locomotiveNames
		Assert.assertEquals(referenceNames, loadedNames)
	}

	/**
	 * Test if all locomotives are correctly registered by ID.
	 */
	@Test def void locomotiveIdsTest() {
		val referenceIds = #{8, 9, 10}
		val loadedIds = LocomotivesConfiguration.INSTANCE.locomotiveIds
		Assert.assertEquals(referenceIds, loadedIds)
	}

	/**
	 * Test if all locomotives have the correct name -> ID mapping.
	 */
	@Test def void mappingsTest() {
		val referenceMapping = #{"br294" -> 8, "taurus" -> 9, "sncf" -> 10}
		val loadedMapping = LocomotivesConfiguration.INSTANCE.locomotivesWithNameAndId
		Assert.assertEquals(referenceMapping, loadedMapping)
	}

	/**
	 * Test if a specific train has the correct name -> ID mapping.
	 */
	@Test def void mappingTest() {
		val referenceName = "Taurus"
		val referenceId = 9
		val loadedId = LocomotivesConfiguration.INSTANCE.getLocomotiveIdByName(referenceName)
		Assert.assertEquals(referenceId, loadedId)
	}
}
