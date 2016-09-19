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
import hu.bme.mit.inf.safetylogic.model.RailRoadModel.RailRoadElement

class SafetyLogic extends AbstractRailRoadCommunicationComponent implements INotifiable {

	@Accessors(PUBLIC_GETTER) protected ModelUtil model //XXX IModelInteractor should be the static type

	new(CommunicationStack stack, ILoggerFactory factory) {

		super(stack, factory)
		logger.info('Construction started')
		model = new ModelUtil
		logger.info('Construction finished')
		
	}

	override void run() {
		this.logger.info("Running started...")
		locator.trackElementStateRegistry.segmentOccupancyChangeListener = new TrainMovementEstimator(model, this)
		locator.trackElementStateRegistry.turnoutStateChangeListener = new ITurnoutStateChangeListener() {

			override onTurnoutStateChange(int id, TurnoutState oldValue, TurnoutState newValue) {
				(model.model.sections.findFirst[it.id == id] as Turnout).currentlyDivergent = (newValue == TurnoutState.DIVERGENT)
				refreshSafetyLogicState
			}
		}
	}

	def public void refreshSafetyLogicState() {
		logger.info('''Refreshing state: #of cuts «model.cuts.size», #of hits «model.hits.size»''')
		model.model.sections.filter[it instanceof Segment].map[it as Segment].forEach[isEnabled = true] //Enable all sections virtually first
		model.cuts.forEach [ cut |
			logger.info('''CUT: victim on «(cut.victim as RailRoadElement).id» cuts «(cut.offender as Train).currentlyOn.id»''')
			(model.model.sections.findFirst[id == (cut.offender as Train).currentlyOn.id] as Segment).isEnabled = false //disable the trains which cut sections
		]

		model.hits.forEach [ hit |
			logger.info('''HIT: offender on «(hit.offender as Train).currentlyOn.id», victim on «(hit.victim as Train).currentlyOn.id»''')
			(model.model.sections.findFirst[id == (hit.offender as Train).currentlyOn.id] as Segment).isEnabled = false //disable the trains which hit another
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