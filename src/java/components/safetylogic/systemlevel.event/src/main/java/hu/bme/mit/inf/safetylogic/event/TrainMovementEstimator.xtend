package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ISegmentOccupancyChangeListener
import hu.bme.mit.inf.modes3.messaging.messages.enums.SegmentOccupancy
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainMovementEstimator implements ISegmentOccupancyChangeListener, INotifiable {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	val IModelInteractor model
	val INotifiable notifiable
	val Map<RailRoadElement, Long> freedSections
	val Poller poller

	new(IModelInteractor model, INotifiable notifiable, ILoggerFactory factory) {
		this.model = model
		this.notifiable = notifiable
		this.logger = factory.getLogger(this.class.name)
		this.freedSections = new HashMap<RailRoadElement, Long>
		this.poller = new Poller(this)
		poller.start
	}

	private def print(SegmentOccupancy value) {
		switch(value){
			case FREE: 'FREE'
			case OCCUPIED: 'OCCUPIED'
			default: 'NULL'
		}
	}

	def synchronized checkFreedSections() {
		val time = System.currentTimeMillis
		val freedLongTimeAgo = freedSections.filter[freedSection, timeStamp|timeStamp < (time - 5000)]
		if (freedLongTimeAgo.size == 0) {
			return
		}

		val removeKeys = new HashSet<RailRoadElement>
		freedLongTimeAgo.forEach [ freedSection, timeStamp |
			val train = model.enabledTrains.findFirst[it.currentlyOn == freedSection]
			if (train !== null) {
				logger.info('''Old train #«train.id» removed from «train.currentlyOn.id»''')
				model.removeTrain(train)
			}
			removeKeys.add(freedSection)
		]

		removeKeys.forEach[freedSections.remove(it)]
	}

	def synchronized threadSafeOnSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {

		logger.info('''Segment occupancy changed on «id» from «oldValue.print» to «newValue.print»''')
		val enabledTrains = model.enabledTrains
		var changedSegment = model.getSegment(id)

		if (newValue == SegmentOccupancy.OCCUPIED) {

			if (freedSections.keySet.contains(changedSegment)) {
				freedSections.remove(changedSegment)
			}

			if (model.trains.map[currentlyOn].toList.contains(changedSegment)) { // If there is a train already on the section which got occupied 
				return // We simply ignore this as this is a multiple message which we already received
			}

			val possibleTrainPositions = model.getCurrentlyConnected(changedSegment)
			var train = enabledTrains.findFirst[possibleTrainPositions.contains(it.currentlyOn)] // Search for an enabled train in one of the connected railroad elements
			if (train === null) { // There is no enabled train nearby
				train = model.trains.findFirst[possibleTrainPositions.contains(it.currentlyOn)] // Search for a disabled train, it must have moved somehow
				if (train === null) { // There are not even disabled trains nearby
					train = model.addNewTrain
					train.currentlyOn = changedSegment
					logger.info('''New train estimated on «changedSegment.id». The new train's ID is «train.id»''')
					return
				}
			}
			
			  
			if (changedSegment instanceof Turnout) { // If we move on a turnout
				val next = nextSegment(train.currentlyOn, changedSegment) // We skip the turnout as a railroadelement, as the train can not be stopped on it
				logger.info('''Train arrived on turnout «changedSegment.id» so it is moved to «next.id»''')
				train.previouslyOn = changedSegment
				train.currentlyOn = next
				return
			}
			
			logger.info('''Train moved from «train.currentlyOn.id» to «changedSegment.id»''')
			train.previouslyOn = train.currentlyOn // Set the previous on the model
			train.currentlyOn = changedSegment // And update the train position
		} else if (newValue == SegmentOccupancy.FREE) {
			freedSections.put(model.getSegment(id), System.currentTimeMillis)
		}
		this.onUpdate
		notifiable.onUpdate
	}

	def nextSegment(RailRoadElement old, RailRoadElement current) {
		return model.getNextSection(old, current)
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		threadSafeOnSegmentOccupancyChange(id, oldValue, newValue)
	}

	override onUpdate() {
		checkFreedSections
	}

}

class Poller {
	val INotifiable toNotify
	Thread t = null

	new(INotifiable notify) {
		this.toNotify = notify
	}

	def start() {
		if (t !== null) {
			throw new RuntimeException
		}
		t = new Thread(new Runnable() {
			override run() {
				while (true) {
					Thread.sleep(1000)
					toNotify.onUpdate
				}

			}
		})
		t.start
	}
}
