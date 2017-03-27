package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentOccupancy
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ISegmentOccupancyChangeListener
import java.util.SortedMap
import java.util.TreeMap
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TrainMovementEstimator implements ISegmentOccupancyChangeListener, INotifiable {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	val IModelInteractor model
	val INotifiable notifiable
	val SortedMap<RailRoadElement, Long> freedSections
	val Poller poller

	new(IModelInteractor model, INotifiable notifiable, ILoggerFactory factory) {
		this.model = model
		this.notifiable = notifiable
		this.logger = factory.getLogger(this.class.name)
		this.freedSections = new TreeMap<RailRoadElement, Long>
		this.poller = new Poller(this)
		poller.start
	}

	private def print(SegmentOccupancy value) {
		if(value == SegmentOccupancy.FREE) 'FREE' else 'OCCUPIED'
	}
	
	def synchronized checkFreedSections(){
		val time = System.currentTimeMillis
		freedSections.filter[freedSection, timeStamp| timeStamp < time - 10000].forEach[freedSection, timeStamp | 
			val train = model.enabledTrains.findFirst[it.currentlyOn == freedSection]
			logger.info('''Old train #«train.id» removed from «train.currentlyOn.id»''')
			model.removeTrain(train)
		]
		
		
	}
	
	def synchronized threadSafeOnSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		logger.info('''Segment occupancy changed on «id» from «oldValue.print» to «newValue.print»''')
		val enabledTrains = model.enabledTrains
		val changedSegment = model.getSegment(id)
		if(newValue == SegmentOccupancy.OCCUPIED) {
			if(freedSections.values.contains(changedSegment)){
				freedSections.remove(changedSegment)
			}
			val possibleTrainPositions = model.getCurrentlyConnected(changedSegment)
			var train = enabledTrains.findFirst[possibleTrainPositions.contains(it.currentlyOn)]
			if(train == null) { // There is not even a train nearby, so it must have been put there recently
				train = model.addNewTrain
				logger.info('''New train estimated on «changedSegment.id». The new train's ID is «train.id»''')
			} else {
				logger.info('''Train moved from «train.currentlyOn.id» to «changedSegment.id»''')
			}
			train.previouslyOn = train.currentlyOn
			train.currentlyOn = changedSegment
		} else if(newValue == SegmentOccupancy.FREE) {
			freedSections.put(model.getSegment(id), System.currentTimeMillis)
		}
		this.onUpdate
		notifiable.onUpdate
	}

	override onSegmentOccupancyChange(int id, SegmentOccupancy oldValue, SegmentOccupancy newValue) {
		threadSafeOnSegmentOccupancyChange(id, oldValue, newValue)
	}
	
	override onUpdate() {
		checkFreedSections
	}

}

class Poller{
	val INotifiable toNotify
	Thread t = null
	new(INotifiable notify){
		this.toNotify = notify
	}
	def start(){
		if(t != null){
			throw new RuntimeException
		}
		t = new Thread(new Runnable(){
			override run() {
				Thread.sleep(1000)
				toNotify.onUpdate
			}
		})
		t.start
	}
}
