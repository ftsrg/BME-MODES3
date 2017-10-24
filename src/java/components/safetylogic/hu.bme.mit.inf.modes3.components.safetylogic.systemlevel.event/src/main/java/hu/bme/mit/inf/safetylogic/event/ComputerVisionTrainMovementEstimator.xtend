package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.IComputerVisionListener
import hu.bme.mit.inf.modes3.utils.conf.LocomotivesConfiguration
import java.util.List
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class ComputerVisionTrainMovementEstimator implements IComputerVisionListener {

	IModelInteractor model
	INotifiable notifiable
	Logger logger
	ComputerVisionEstimator estimator
	boolean extensiveLogging

	new(IModelInteractor model, INotifiable notifiable, ILoggerFactory factory, boolean extensiveLogging) {
		this.extensiveLogging = extensiveLogging
		this.model = model
		this.notifiable = notifiable
		this.logger = factory.getLogger(this.class.name)
		this.estimator = new ComputerVisionEstimator(model)

		// If the model does not have the previously defined three trains on it
		if(!LocomotivesConfiguration::INSTANCE.locomotiveIds.equals(model.trains.map[it.id].toSet)) {

			// Remove all trains
			val trains = model.trains
			trains.forEach[model.removeTrain(it)]

			// And add the correct ones
			// And hope that it will give the correct ID's
			for (var i = 0; i != LocomotivesConfiguration::INSTANCE.locomotiveIds.size; i++) {
				model.addNewTrain
			}

			// If it doesn't give the requested ID's we cry
			if(!LocomotivesConfiguration::INSTANCE.locomotiveIds.equals(model.trains.map[it.id].toSet)) {
				throw new Exception("Something went terribly wrong!")
			}

		}
	}

	override onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp, long frameindex) {
		synchronized(model) {
//			logger.info('''Information size = «information.size»''')
//			logger.info('''<== Computer Vision Detection ==>''')
//			logger.info('''Information : «information»''')
			val allRealCoordinatesAreZero = information.forall[it.realPosition.x === 0 && it.realPosition.y === 0]
			if(allRealCoordinatesAreZero) {
				logger.info('''The Computer vision doesn't see the corners of the table so it gives no valuable information''')
				return
			}
			val estimatedInformation = newHashMap(information.filter[LocomotivesConfiguration::INSTANCE.getLocomotiveIdByName(it.name) !== null && tracked].map[LocomotivesConfiguration::INSTANCE.getLocomotiveIdByName(it.name) -> estimator.getElementByCoordinates(it.realPosition.x, it.realPosition.y)])
//			logger.info('''Estimated information = «FOR estimatedInfo : estimatedInformation.entrySet» Train #«estimatedInfo.key» is on «estimatedInfo.value.id» «ENDFOR»''')
			val neverSeenTrains = model.trains.filter[it.currentlyOn === null && estimatedInformation.get(it.id) !== null].toList()
			if(!neverSeenTrains.empty && extensiveLogging) {
				logger.info('''Never seen trains = 
				«neverSeenTrains»''')
			}

			neverSeenTrains.forEach [
				it.currentlyOn = estimatedInformation.get(it.id)
				logger.info('''Train «LocomotivesConfiguration::INSTANCE.getLocomotiveNameById(it.id)» has arrived at «it.currentlyOn.id»''')
 			]
			val movedTrains = model.trains.filter[estimatedInformation.get(it.id) !== null && it.currentlyOn !== null && it.currentlyOn.id !== estimatedInformation.get(it.id).id].toList()
			if(!movedTrains.empty && extensiveLogging) {
				logger.info('''moved Trains = 
				«movedTrains»''')
			}
			movedTrains.forEach [
				it.previouslyOn = it.currentlyOn
				it.currentlyOn = estimatedInformation.get(it.id)
				logger.info('''Train «LocomotivesConfiguration::INSTANCE.getLocomotiveNameById(it.id)» moved from «it.previouslyOn.id» to «it.currentlyOn.id»''')
			]

			if(movedTrains.size + neverSeenTrains.size != 0) {
				notifiable.onUpdate
			}
		}
	}

}
