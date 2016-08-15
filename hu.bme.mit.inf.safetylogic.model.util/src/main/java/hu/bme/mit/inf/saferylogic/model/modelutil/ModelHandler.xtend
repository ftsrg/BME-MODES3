package hu.bme.mit.inf.saferylogic.model.modelutil

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Turnout

class ModelHandler {
	private RailRoadModel model;
//	static extension ModelFactory factory = ModelFactory.eINSTANCE
	
	def getElementById(int id){
		return model.sections.findFirst[it.id == id]
	}	
	
	def switchTurnout(int id){
		var objectById = getElementById(id)
		if(!(objectById instanceof Turnout)){
			throw new RuntimeException("Can't switch a non-turnout element"); //TODO add a new exception class
		}
		(objectById as Turnout).currentlyDivergent = !(objectById as Turnout).currentlyDivergent
	}
}
