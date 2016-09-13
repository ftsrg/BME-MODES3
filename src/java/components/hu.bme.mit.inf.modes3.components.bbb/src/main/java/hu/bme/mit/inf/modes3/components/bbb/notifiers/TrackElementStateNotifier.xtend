package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TrackElementStateNotifier {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) static val Logger logger = LoggerFactory.getLogger(TrackElementStateNotifier)

	protected val TrackCommunicationServiceLocator serviceLocator

	protected var SectionStateNotifier sectionStateNotifier

	protected var TurnoutStateNotifier turnoutStateNotifier

	protected var Thread sectionStateNotifierThread

	protected var Thread turnoutStateNotifierThread

	new(CommunicationStack stack, ExpanderSectionController sectionController, ExpanderTurnoutController turnoutController) {
		serviceLocator = new TrackCommunicationServiceLocator(stack)
		sectionStateNotifier = new SectionStateNotifier(serviceLocator.trackElementStateSender, sectionController)
		turnoutStateNotifier = new TurnoutStateNotifier(serviceLocator.trackElementStateSender, turnoutController)
	}

	new(CommunicationStack stack) {
		this(stack, new ExpanderSectionController, new ExpanderTurnoutController)
	}

	def start() {
		sectionStateNotifierThread = new Thread(sectionStateNotifier)
		sectionStateNotifierThread.start

		turnoutStateNotifierThread = new Thread(turnoutStateNotifier)
		turnoutStateNotifierThread.start
	}

	def interrupt() {
		interruptThread(sectionStateNotifierThread)
		interruptThread(turnoutStateNotifierThread)
	}

	private def interruptThread(Thread thread) {
		try {
			thread.interrupt
		} catch(SecurityException ex) {
			logger.error(ex.message, ex)
		}
	}

}
