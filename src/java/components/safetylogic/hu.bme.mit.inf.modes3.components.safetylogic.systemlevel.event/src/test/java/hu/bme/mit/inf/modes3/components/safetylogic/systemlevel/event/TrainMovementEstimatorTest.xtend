package hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.event

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.safetylogic.event.INotifiable
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.TrainMovementEstimator
import org.junit.Before
import org.junit.Test
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory
import org.junit.Assert
import org.junit.Ignore
import org.slf4j.helpers.NOPLoggerFactory

class TrainMovementEstimatorTest {
	var TrainMovementEstimator estimator
	val modelUtil = new ModelUtil

	@Before
	def void before() {
		estimator = new TrainMovementEstimator(
			modelUtil,
			new INotifiable() {
				override onUpdate() {
					// Left blank intentionally
				}
			}, (new NOPLoggerFactory).getLogger('TrainMovementEstimator')
		)
	}

	private def void move(int from, int to) {
		estimator.onSegmentOccupancyChange(to, SegmentOccupancy.FREE, SegmentOccupancy.OCCUPIED)
		estimator.onSegmentOccupancyChange(from, SegmentOccupancy.OCCUPIED, SegmentOccupancy.FREE)
	}

	@Ignore
	@Test
	def void trainMovementEstimatorTest() {
		val train = RailRoadModelFactory.eINSTANCE.createTrain => [id = 0; currentlyOn = modelUtil.getSegment(1)]
		modelUtil.model.trains.add(train)
		estimator.onSegmentOccupancyChange(1, SegmentOccupancy.FREE, SegmentOccupancy.OCCUPIED)
		move(1, 12)
		Assert.assertEquals(train.currentlyOn.id, 12)
		move(12, 14)
		Assert.assertEquals(train.currentlyOn.id, 14)
		move(14, 15)
		Assert.assertEquals(train.currentlyOn.id, 15)
		move(15, 24)
		Assert.assertEquals(train.currentlyOn.id, 24)
	}
}
