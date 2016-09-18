package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStackFactory
import hu.bme.mit.inf.safetylogic.event.ModelUtil
import hu.bme.mit.inf.safetylogic.event.SafetyLogic
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class IntegrationTest {
	val sl = new SafetyLogic(CommunicationStackFactory::createLocalStack)
	val slThread = new Thread(sl)

	var RailRoadModel model
	var Thread physicalThread
	var Thread arduinoThread
	var Thread bbbThread
	
	@Before def void before(){
		model = ModelUtil.getModelFromResource(ModelUtil.loadModel)
		physicalThread = new Thread(new PhyicalEnvironmentSimulation(model))
		arduinoThread = new Thread(new SegmentOccupancyReaderMock(CommunicationStackFactory::createLocalStack, model))
		bbbThread =  new Thread(new BBBModelComponent(CommunicationStackFactory::createLocalStack, model))
		model.sections.filter[it instanceof Segment].map[it as Segment].forEach[isEnabled = true]
	}

	@Test def void integrationTest() {
		Assert.assertEquals(true, (model.sections.findFirst[id == 24] as Segment).isEnabled)
		Assert.assertEquals(true, (model.sections.findFirst[id == 29] as Segment).isEnabled)
		
		slThread.start
		bbbThread.start
		physicalThread.start
		arduinoThread.start
		Thread.sleep(3000)

		Assert.assertEquals(false, (model.sections.findFirst[id == 24] as Segment).isEnabled)
		Assert.assertEquals(false, (model.sections.findFirst[id == 29] as Segment).isEnabled)
	}
}

