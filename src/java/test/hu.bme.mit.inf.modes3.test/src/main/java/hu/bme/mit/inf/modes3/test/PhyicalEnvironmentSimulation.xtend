package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModelFactory

class PhyicalEnvironmentSimulation implements Runnable {
	public val RailRoadModel model
	new (RailRoadModel model){
		this.model = model
	}
	
	def createTrain(RailRoadModel model, int sectionId, int trainId){
		RailRoadModelFactory.eINSTANCE.createTrain => [it.currentlyOn = model.sections.findFirst[id == sectionId]; id=trainId]
	}
	
	override run() {
		//TODO this should be read from a config file or something like that.
		val train1 = model.createTrain(15, 1000)
		Thread.sleep(100)
		
		train1.currentlyOn = model.sections.findFirst[id == 24]
		Thread.sleep(100)
		
		
		val train2 = model.createTrain(28, 2000)
		Thread.sleep(100)
		
		train2.currentlyOn = model.sections.findFirst[id == 29]
		
		

	}

	
	
	
}