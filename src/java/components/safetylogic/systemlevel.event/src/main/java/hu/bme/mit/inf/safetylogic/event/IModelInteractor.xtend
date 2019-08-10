package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadElement
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Train
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.state.computervision.interfaces.ComputerVisionInformation
import hu.bme.mit.inf.safetylogic.patterns.TrainHitsAnotherTrainMatch
import hu.bme.mit.inf.safetylogic.patterns.TrainTrailingTurnoutMatch
import java.util.Collection
import java.util.List
import java.util.Set

/**
 * An interface to interact with the model.
 * 
 * @author baloghlaszlo
 */
interface IModelInteractor {
	
	/**
	 * @return the enabled trains
	 */
	def Iterable<Train> getEnabledTrains()
	
	/**
	 * @return creates a new train on the track
	 */
	def Train addNewTrain()
	
	/**
	 * @param id the ID of the segment
	 * @return the railroad element that represents the seegmetn
	 */
	def RailRoadElement getSegment(int id)
	
	/**
	 * Removes the train from the model.
	 * 
	 * @param t the train to be removed
	 */
	def void removeTrain(Train t)
	
	/**
	 * @param element the railroad element whose neighbours are being searched
	 * @return the railroad elements that are currently connected to the given element
	 */
	def Set<RailRoadElement> getCurrentlyConnected(RailRoadElement element)
	
	/**
	 * @return the segments
	 */
	def Iterable<Segment> getSegments()
	
	/**
	 * @return the tunrouts
	 */
	def Iterable<Turnout> getTurnouts()
	
	/**
	 * @return the sections (railroad elements)
	 */
	def Iterable<RailRoadElement> getSections()
	
	/**
	 * @return the trains
	 */
	def Iterable<Train> getTrains()
	
	/**
	 * @param old the previous railroad element
	 * @param current the current railroad element
	 * 
	 * @return the following railroad element depending on the direction of movement
	 */
	def RailRoadElement getNextSection(RailRoadElement old, RailRoadElement current)
	
	/**
	 * @return the pattern mathces when a train trails a turnout
	 */
	def Collection<TrainTrailingTurnoutMatch> getTrailings()
	/**
	 * @return the pattern matches when two trains collide into each other
	 */ 
	def Collection<TrainHitsAnotherTrainMatch> getHits()
	
	def void ensureIds(List<Pair<RailRoadElement, ComputerVisionInformation>> pairs)
	
	
}