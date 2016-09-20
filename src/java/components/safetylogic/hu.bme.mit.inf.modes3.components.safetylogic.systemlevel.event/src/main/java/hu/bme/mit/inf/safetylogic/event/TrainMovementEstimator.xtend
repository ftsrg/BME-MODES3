package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import org.slf4j.Logger

class TrainMovementEstimator implements ISegmentOccupancyChangeListener {

	val IModelInteractor model
	val INotifiable notifiable
	val Logger logger
	
	new(IModelInteractor model, INotifiable notifiable, Logger logger){
		this.model = model
		this.notifiable = notifiable
		this.logger = logger
	}
	
	
	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		logger.info('''Segment occupancy changed on «id»''')
		val enabledTrains = model.getEnabledTrains
		if(newValue == SegmentOccupancy.OCCUPIED) {
			val changedSection = model.getSegment(id)
			val possibleTrainPositions = model.getCurrentlyConnected(changedSection)
			var train = enabledTrains.findFirst[possibleTrainPositions.contains(it.currentlyOn)]
			if(train == null) { // There is not even a train nearby, so it must have been put there recently
				train = model.addNewTrain
				logger.info('''New train estimated on «changedSection.id»''')
			}
			train.previouslyOn = train.currentlyOn
			train.currentlyOn = changedSection
		} else if(newValue == SegmentOccupancy.FREE) {
			val train = enabledTrains.findFirst[it.currentlyOn.id == id]
			if(train != null) { // The train has been removed manually
				logger.info('''Old train removed from «train.id»''')
				model.removeTrain(train)
			}
		}
		notifiable.onUpdate
	}

}
