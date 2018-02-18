package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory

class PhysicalEnvironmentOrchestrator implements Runnable {
	public val RailRoadModel model
	new (RailRoadModel model){
		this.model = model
	}
	
	def createTrain(RailRoadModel model, int sectionId, int trainId){
		RailRoadModelFactory.eINSTANCE.createTrain => [it.currentlyOn = model.sections.findFirst[id == sectionId]; id=trainId]
	}
	
	override run() {
		val sleepTimes = 300
		//TODO this should be read from a config file or something like that.
		val train1 = model.createTrain(15, 1000)
		model.trains.add(train1)
		Thread.sleep(sleepTimes)
		
		train1.currentlyOn = model.sections.findFirst[id == 24]
		Thread.sleep(sleepTimes)
		
		
		val train2 = model.createTrain(28, 2000)
		model.trains.add(train2)
		Thread.sleep(sleepTimes)
		
		train2.currentlyOn = model.sections.findFirst[id == 29]
		
		

	}

	
	
	
}