package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.components.common.AbstractRailRoadCommunicationComponent
import hu.bme.mit.inf.modes3.messaging.communication.enums.SegmentState
import hu.bme.mit.inf.modes3.messaging.communication.enums.TurnoutState
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITurnoutStateChangeListener
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Segment
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Train
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.Turnout
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory

class SafetyLogic extends AbstractRailRoadCommunicationComponent implements INotifiable {

	@Accessors(PUBLIC_GETTER) protected ModelUtil model //XXX IModelInteractor should be the static type

	new(CommunicationStack stack, ILoggerFactory factory) {
		super(stack, factory)
		model = new ModelUtil
	}

	override void run() {
		locator.trackElementStateRegistry.segmentOccupancyChangeListener = new TrainMovementEstimator(model, this)
		locator.trackElementStateRegistry.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				(model.model.sections.findFirst[it.id == id] as Turnout).currentlyDivergent = (newValue == TurnoutState.DIVERGENT)
				refreshSafetyLogicState
			}
		}
	}

	def public void refreshSafetyLogicState() {
		model.cuts.forEach [ cut |
			(model.model.sections.findFirst[id == (cut.victim as Train).currentlyOn.id] as Segment).isEnabled = false
		]

		model.hits.forEach [ hit |
			(model.model.sections.findFirst[id == (hit.victim as Train).currentlyOn.id] as Segment).isEnabled = false
		]

		model.model.sections.filter[it instanceof Segment].map[it as Segment].forEach [
			if(isEnabled == false) 
				locator.trackElementCommander.sendSegmentCommand(it.id, SegmentState.DISABLED) 
			else 
				locator.trackElementCommander.sendSegmentCommand(it.id, SegmentState.ENABLED)
		]
	}
	
	override onUpdate() {
		refreshSafetyLogicState
	}
	
}