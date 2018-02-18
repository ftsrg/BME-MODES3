package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.event

import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import hu.bme.mit.inf.safetylogic.event.INotifiable
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.TrainMovementEstimator
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.slf4j.helpers.NOPLoggerFactory
import org.slf4j.impl.SimpleLoggerFactory

class TrainMovementEstimatorTest {
	var TrainMovementEstimator estimator
	var ModelUtil modelUtil

	@Before
	def void before() {
		modelUtil = new ModelUtil(new NOPLoggerFactory)
		estimator = new TrainMovementEstimator(
			modelUtil,
			new INotifiable() {
				override onUpdate() {
					// Left blank intentionally
				}
			},
			new SimpleLoggerFactory
		)
	}

	private def void move(int from, int to) {
		estimator.onSegmentOccupancyChange(to, SegmentOccupancy.FREE, SegmentOccupancy.OCCUPIED)
		Thread.sleep(200)
		estimator.onSegmentOccupancyChange(from, SegmentOccupancy.OCCUPIED, SegmentOccupancy.FREE)
	}

	@Test
	def void trainMovementEstimatorTest() {

		Assert.assertEquals(0, modelUtil.model.trains.size)

		estimator.onSegmentOccupancyChange(1, SegmentOccupancy.FREE, SegmentOccupancy.OCCUPIED)
		Assert.assertEquals(1, modelUtil.model.trains.size)
		Assert.assertEquals(1, modelUtil.model.trains.head.currentlyOn.id)

		move(1, 12)
		Thread.sleep(500)
		Assert.assertEquals(1, modelUtil.model.trains.size)
		Assert.assertEquals(12, modelUtil.model.trains.head.currentlyOn.id)

		move(12, 14)
		Assert.assertEquals(1, modelUtil.model.trains.size)
		Assert.assertEquals(14, modelUtil.model.trains.head.currentlyOn.id)

		move(14, 15)
		Assert.assertEquals(1, modelUtil.model.trains.size)
		Assert.assertEquals(15, modelUtil.model.trains.head.currentlyOn.id)

		move(15, 24)
		Assert.assertEquals(1, modelUtil.model.trains.size)
		Assert.assertEquals(24, modelUtil.model.trains.head.currentlyOn.id)
	}
}
