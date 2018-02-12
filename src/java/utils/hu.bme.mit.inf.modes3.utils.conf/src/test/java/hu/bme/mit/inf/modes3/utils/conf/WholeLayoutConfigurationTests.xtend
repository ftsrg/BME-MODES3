package hu.bme.mit.inf.modes3.utils.conf

import hu.bme.mit.inf.modes3.utils.conf.layout.whole.ConnectionDirection
import hu.bme.mit.inf.modes3.utils.conf.layout.whole.WholeLayoutConfiguration
import org.junit.Assert
import org.junit.Test

class WholeLayoutConfigurationTests {

	@Test def void loadT1Test() {
		val componentName = "t1"
		val turnoutOccupancyId = 14
		val turnoutNeighboursId = #{12, 11, 15}
		val s12NeighboursId = #{ConnectionDirection.CW -> 14, ConnectionDirection.CCW -> 1}
		val s12NeighboursSeeT1From = #{14 -> ConnectionDirection.STRAIGHT, 1 -> ConnectionDirection.CCW}

		val t1Layout = WholeLayoutConfiguration.INSTANCE.getLayoutConfigurationForComponent(componentName)
		Assert.assertEquals(componentName, t1Layout.componentName)
		Assert.assertEquals(1, t1Layout.turnouts.length)

		val turnout = t1Layout.turnouts.head
		Assert.assertEquals(turnoutOccupancyId, turnout.occupancyId)
		val turnoutNeighbours = #[turnout.straight.occupancyId, turnout.top.occupancyId, turnout.divergent.occupancyId]
		Assert.assertEquals(turnoutNeighboursId, turnoutNeighbours.toSet)

		val s12Model = t1Layout.sections.findFirst[it.occupancyId == 12]
		val s14Model = s12Model.cw
		val s1Model = s12Model.ccw

		val s14ExpectedOccupancyId = s12NeighboursId.get(ConnectionDirection.CW)
		val s1ExpectedOccupancyId = s12NeighboursId.get(ConnectionDirection.CCW)
		Assert.assertEquals(s14ExpectedOccupancyId, s14Model.occupancyId)
		Assert.assertEquals(s1ExpectedOccupancyId, s1Model.occupancyId)

		val s14ExpectedDirection = s12NeighboursSeeT1From.get(14)
		val s1ExpectedDirection = s12NeighboursSeeT1From.get(1)
		Assert.assertEquals(s14ExpectedDirection, s14Model.itReceivesOurMessagesFrom)
		Assert.assertEquals(s1ExpectedDirection, s1Model.itReceivesOurMessagesFrom)
	}
}
