package hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement

import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateRegistry
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TurnoutEventHandler {

	static val STRAIGHT = "straight"
	static val DIVERGENT = "divergent"

	val Logger logger
	val ThreadSafeNode node

	val ITrackElementStateRegistry trackElementStateRegistry
	val ITrackElementCommander trackElementCommander
	
	new(ILoggerFactory loggerFactory, ThreadSafeNode node, ITrackElementStateRegistry trackElementStateRegistry,
		ITrackElementCommander trackElementCommander) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.node = node
		this.trackElementStateRegistry = trackElementStateRegistry
		this.trackElementCommander = trackElementCommander
	}

	def setStraight() {
		node.removeCssClass(DIVERGENT)
		node.addCssClass(STRAIGHT)
	}

	def setDivergent() {
		node.removeCssClass(STRAIGHT)
		node.addCssClass(DIVERGENT)
	}

	def onTurnoutClicked() {
		try {
			val turnoutId = node.nodeId
			val state = trackElementStateRegistry.getTurnoutState(turnoutId)
			val newState = getTurnoutOppositeState(state)

			trackElementCommander.sendTurnoutCommandWithTurnoutId(turnoutId, newState)
			updateTurnoutState(newState)

			logger.info('''Turnout «turnoutId» is «newState»''')
		} catch (Exception ex) {
			logger.error(ex.message, ex)
		}
	}

	private def void updateTurnoutState(TurnoutState newState) {
		switch (newState) {
			case STRAIGHT:
				setStraight()
			case DIVERGENT:
				setDivergent()
			case ILLEGAL: {
			}
		}
	}

	private def getTurnoutOppositeState(TurnoutState state) {
		switch (state) {
			case STRAIGHT:
				TurnoutState.DIVERGENT
			case DIVERGENT:
				TurnoutState.STRAIGHT
			case ILLEGAL:
				TurnoutState.ILLEGAL
		}
	}
}
