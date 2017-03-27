package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.safetylogic.patterns.TrainCutsTurnoutMatch
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatch
import java.util.Collection
import java.util.Set

interface IModelInteractor {
	def Iterable<Train> getEnabledTrains()
	def Train addNewTrain()
	def RailRoadElement getSegment(int id)
	def void removeTrain(Train t)
	def Set<RailRoadElement> getCurrentlyConnected(RailRoadElement element)
	def Iterable<Segment> getSegments()
	def Iterable<Turnout> getTurnouts()
	def Iterable<RailRoadElement> getSections()
	def Iterable<Train> getTrains()
	
		
	def Collection<TrainCutsTurnoutMatch> getCuts() 
	def Collection<TrainHitsAnotherTrainMatch> getHits()
}