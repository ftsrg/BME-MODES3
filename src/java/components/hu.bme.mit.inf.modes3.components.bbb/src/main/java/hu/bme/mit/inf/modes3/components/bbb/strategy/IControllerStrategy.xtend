package hu.bme.mit.inf.modes3.components.bbb.strategy

import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import java.util.Set

interface ISegmentControllerStrategy {
	
	/**
	 * Enables the referred section, so trains can move on.
	 * 
	 * @param sectionId the ID of the section to be enabled
	 */
	def void enableSection(int sectionId)

	/**
	 * Disables the referred section, so no train can move on.
	 * 
	 * @param sectionId the ID of the section to be disabled
	 */
	def void disableSection(int sectionId)

	/**
	 * Tells the status (enabled / disabled) of the respective section ID.
	 * 
	 * @param sectionId the ID of the referred section
	 * @return the status of the referred section
	 */
	def SegmentState getSectionStatus(int sectionId)
	
	/**
	 * Tells whether the respective embedded controller manages the referred
	 * turnout.
	 * 
	 * @param turnoutId which shall be checked whether it is managed by the
	 * embedded controller
	 * @return true, if the respective embedded controller manages the turnout
	 */
	def boolean controllerManagesSection(int sectionId)
	
	
	def Set<Integer> getManagedSections()
}

interface ITurnoutControllerStrategy {
	
	/**
	 * Tells the status (straight / divergent) of the respective turnout ID.
	 * 
	 * @param turnoutId the ID of the referred turnout (switch)
	 * @return the status of the referred turnout (switch)
	 */
	def TurnoutState getTurnoutStatus(int turnoutId)

	/**
	 * Sets the referred turnout straight.
	 * 
	 * @param turnoutId the ID of the turnout that shall be set straight
	 */
	def void setTurnoutStraight(int turnoutId)

	/**
	 * Sets the referred turnout divergent.
	 * 
	 * @param turnoutId the ID of the turnout that shall be set divergent
	 */
	def void setTurnoutDivergent(int turnoutId)
	
	/**
	 * Tells whether the respective embedded controller manages the referred
	 * turnout.
	 * 
	 * @param turnoutId which shall be checked whether it is managed by the
	 * embedded controller
	 * @return true, if the respective embedded controller manages the turnout
	 */
	def boolean controllerManagesTurnout(int turnoutId)
	
	def Set<Integer> getManagedTurnouts()
}
