package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Train
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement
import java.util.Set
import org.eclipse.emf.ecore.EObject

interface IModelInteractor {
	def Iterable<Train> getEnabledTrains()
	def Train addNewTrain()
	def RailRoadElement getSegment(int id)
	def void removeTrain(Train t)
	def Set<EObject> getCurrentlyConnected(RailRoadElement element)
}