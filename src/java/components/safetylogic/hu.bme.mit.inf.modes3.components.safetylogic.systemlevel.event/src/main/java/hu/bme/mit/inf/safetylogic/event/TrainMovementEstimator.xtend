package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener

class TrainMovementEstimator implements ISegmentOccupancyChangeListener {

	val IModelInteractor model
	val INotifiable notifiable
	
	new(IModelInteractor model, INotifiable notifiable){
		this.model = model
		this.notifiable = notifiable
	}
	
	
	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
//		println('segmentoccupancychanged on ' + id)
		val enabledTrains = model.getEnabledTrains
		if(newValue == SegmentOccupancy.OCCUPIED) {
			val changedSection = model.getSegment(id)
			val possibleTrainPositions = model.getCurrentlyConnected(changedSection)
			var train = enabledTrains.findFirst[possibleTrainPositions.contains(it.currentlyOn)]
			if(train == null) { // There is not even a train nearby, so it must have been put there recently
				train = model.addNewTrain
			}
			train.previouslyOn = train.currentlyOn
			train.currentlyOn = changedSection
		} else if(newValue == SegmentOccupancy.FREE) {
			val train = enabledTrains.findFirst[it.currentlyOn.id == id]
			if(train != null) { // The train has been removed manually
				model.removeTrain(train)
			}
		}
		notifiable.onUpdate
	}

}
