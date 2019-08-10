package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModelFactory

/**
 * A show-case (demo) to show how the model-based simulation of the track works.
 * Simulates the behavior of two trains on the track.
 * 
 * @author baloghlaszlo
 */
class PhysicalEnvironmentOrchestrator implements Runnable {
	public val RailRoadModel model
	
	/**
	 * @param model the model of the model railway track
	 */
	new (RailRoadModel model){
		this.model = model
	}
	
	/**
	 * Creates a train that is on the section denoted by its ID.
	 * 
	 * @param model the model of the model railway track
	 * @param sectionId the ID of the section the rain occupies
	 * @param trainId the ID of the train
	 */
	def createTrain(RailRoadModel model, int sectionId, int trainId){
		RailRoadModelFactory.eINSTANCE.createTrain => [it.currentlyOn = model.sections.findFirst[id == sectionId]; id=trainId]
	}
	
	/**
	 * Simulates the movement of two trains on the track. 
	 */
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