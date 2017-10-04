package hu.bme.mit.inf.modes3.components.touchboard.controller.trackelement

import hu.bme.mit.inf.modes3.components.touchboard.ui.ThreadSafeNode
import hu.bme.mit.inf.modes3.components.touchboard.wrapper.ITouchboardWrapper
import hu.bme.mit.inf.modes3.messaging.messages.enums.TurnoutState
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class TurnoutEventHandler {

	static val STRAIGHT = "straight"
	static val DIVERGENT = "divergent"

	val Logger logger
	val ThreadSafeNode node

	val ITouchboardWrapper touchboardWrapper
	
	new(ITouchboardWrapper touchboardWrapper, ThreadSafeNode node, ILoggerFactory loggerFactory) {
		this.logger = loggerFactory.getLogger(this.class.name)
		this.node = node
		this.touchboardWrapper = touchboardWrapper
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
			val state = touchboardWrapper.getTurnoutState(turnoutId)
			val newState = getTurnoutOppositeState(state)

			touchboardWrapper.sendTurnoutCommandWithTurnoutId(turnoutId, newState)
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
