package hu.bme.mit.inf.modes3.test

import hu.bme.mit.inf.modes3.components.bbb.main.BBBComponent
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.RailRoadModel
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Segment
import hu.bme.mit.inf.modes3.components.safetylogic.systemlevel.model.RailRoadModel.Turnout
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import java.util.HashSet
import org.slf4j.ILoggerFactory

class BBBModelComponent extends BBBComponent {
	new(CommunicationStack stack, RailRoadModel model, ILoggerFactory factory) {
		super(stack, new ISegmentControllerStrategy() {
			override getManagedSections() {
				synchronized(model) {
					new HashSet<Integer> => [addAll(model.sections.map[id])]
				}
			}

			override controllerManagesSection(int sectionId) {
				true
			}

			override enableSection(int sectionId) {
				synchronized(model) {
					(model.sections.findFirst[id == sectionId] as Segment).isEnabled = true
				}
			}

			override disableSection(int sectionId) {
				synchronized(model) {
					(model.sections.findFirst[id == sectionId] as Segment).isEnabled = false
				}
			}

			override getSectionStatus(int sectionId) {
				synchronized(model) {
					val railRoadElementWithSectionId = model.sections.findFirst[id == sectionId]
					if(railRoadElementWithSectionId instanceof Turnout) return SegmentState.ENABLED // TODO error handling like this should be a must have
					if((railRoadElementWithSectionId as Segment).isEnabled) SegmentState.ENABLED else SegmentState.DISABLED

				}
			}
		}, new ITurnoutControllerStrategy() {

			override getTurnoutStatus(int turnoutId) {
				synchronized(model) {
					if((model.sections.findFirst[id == turnoutId] as Turnout).isCurrentlyDivergent) TurnoutState.DIVERGENT else TurnoutState.STRAIGHT
				}
			}

			override setTurnoutStraight(int turnoutId) {
				synchronized(model) {
					(model.sections.findFirst[id == turnoutId] as Turnout).currentlyDivergent = true
				}
			}

			override setTurnoutDivergent(int turnoutId) {
				synchronized(model) {
					(model.sections.findFirst[id == turnoutId] as Turnout).currentlyDivergent = false
				}
			}

			override controllerManagesTurnout(int turnoutId) {

				true
			}

			override getManagedTurnouts() {
				synchronized(model) {
					new HashSet<Integer> => [addAll(model.sections.filter[it instanceof Turnout].map[id])]
				}
			}
		}, factory)
	}

}
