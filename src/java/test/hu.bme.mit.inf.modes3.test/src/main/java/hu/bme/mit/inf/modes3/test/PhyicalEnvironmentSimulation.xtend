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
		createTrain(model, 24, 1000)
		createTrain(model, 25, 2000)
		
		for(i : (1 ..< 1000)){
			
			Thread.sleep(50) //TODO sleep?
		}
	}

	
	
	
}