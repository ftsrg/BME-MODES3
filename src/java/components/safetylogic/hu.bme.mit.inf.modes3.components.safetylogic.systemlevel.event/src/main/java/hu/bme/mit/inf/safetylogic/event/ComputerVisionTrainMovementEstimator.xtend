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
	
	new(IModelInteractor model, INotifiable notifiable, ILoggerFactory factory) {
		this.model = model
		this.notifiable = notifiable
		this.logger = factory.getLogger(this.class.name)
		this.estimator = new ComputerVisionEstimator(model)
		
		//If the model does not have the previously defined three trains on it
		if(!LocomotivesConfiguration::INSTANCE.locomotiveIds.equals(model.trains.map[it.id].toSet)){
			
			//Remove all trains
			val trains = model.trains
			trains.forEach[model.removeTrain(it)]
			
			//And add the correct ones
			//And hope that it will give the correct ID's
			for(var i = 0; i != LocomotivesConfiguration::INSTANCE.locomotiveIds.size; i++){
				model.addNewTrain				
			}
			
			//If it doesn't give the requested ID's we cry
			if(!LocomotivesConfiguration::INSTANCE.locomotiveIds.equals(model.trains.map[it.id].toSet)){
				throw new Exception("Something went terribly wrong!")
			}
			
		}		
	}
	
	override onComputerVisionDetection(List<ComputerVisionInformation> information, long timestamp, long frameindex) {
		val estimatedInformation = newHashMap(information.filter[LocomotivesConfiguration::INSTANCE.getLocomotiveIdByName(it.name) != null].map[LocomotivesConfiguration::INSTANCE.getLocomotiveIdByName(it.name) -> estimator.getElementByCoordinates(it.realPosition.x, it.realPosition.y)])
		val movedTrains = model.trains.filter[it.currentlyOn.id != estimatedInformation.get(it.id).id]
		movedTrains.forEach[it.previouslyOn = it.currentlyOn; it.currentlyOn = estimatedInformation.get(it.id)]
		notifiable.onUpdate
	}
		
}