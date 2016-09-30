package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainMovementEstimator implements ISegmentOccupancyChangeListener {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	val IModelInteractor model
	val INotifiable notifiable

	new(IModelInteractor model, INotifiable notifiable, ILoggerFactory factory) {
		this.model = model
		this.notifiable = notifiable
		this.logger = factory.getLogger(this.class.name)
	}

	private def print(SegmentOccupancy value) {
		if(value == SegmentOccupancy.FREE) 'FREE' else 'OCCUPIED'
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		logger.info('''Segment occupancy changed on «id» from «oldValue.print» to «newValue.print»''')
		val enabledTrains = model.getEnabledTrains
		if(newValue == SegmentOccupancy.OCCUPIED) {
			val changedSection = model.getSegment(id)
			val possibleTrainPositions = model.getCurrentlyConnected(changedSection)
			var train = enabledTrains.findFirst[possibleTrainPositions.contains(it.currentlyOn)]
			if(train == null) { // There is not even a train nearby, so it must have been put there recently
				train = model.addNewTrain
				logger.info('''New train estimated on «changedSection.id». The new train's ID is «train.id»''')
			} else {
				logger.info('''Train moved from «train.currentlyOn.id» to «changedSection.id»''')
			}
			train.previouslyOn = train.currentlyOn
			train.currentlyOn = changedSection
		} else if(newValue == SegmentOccupancy.FREE) {
			val train = enabledTrains.findFirst[it.currentlyOn.id == id]
			if(train != null) { // The train has been removed manually
				logger.info('''Old train #«train.id» removed from «train.currentlyOn.id»''')
				model.removeTrain(train)
			}
		}
		notifiable.onUpdate
	}

}
