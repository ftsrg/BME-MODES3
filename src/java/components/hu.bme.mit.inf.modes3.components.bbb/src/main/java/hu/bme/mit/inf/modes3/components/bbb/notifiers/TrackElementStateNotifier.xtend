package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.BoardWrapper
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.components.bbb.strategy.ITurnoutControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Encapsulates a SectionStateNotifier along with a TurnoutStateNotifier so that instantiating
 * this class can send status information about the sections and turnouts to the network.
 * 
 * @author benedekh
 */
class TrackElementStateNotifier {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	// notifier which polls the sections states regularly
	protected var SectionStateNotifier sectionStateNotifier

	// notifier which polls the turnouts states regularly
	protected var TurnoutStateNotifier turnoutStateNotifier

	// thread that runs the section notifier
	protected var Thread sectionStateNotifierThread

	// thread that runs the turnout notifier
	protected var Thread turnoutStateNotifierThread

	new(TrackCommunicationServiceLocator locator, ISegmentControllerStrategy sectionController, ITurnoutControllerStrategy turnoutController, ILoggerFactory factory) {
		sectionStateNotifier = new SectionStateNotifier(locator.trackElementStateSender, sectionController, factory)
		turnoutStateNotifier = new TurnoutStateNotifier(locator.trackElementStateSender, turnoutController, factory)

		this.logger = factory.getLogger(this.class.name)
	}

	new(TrackCommunicationServiceLocator locator, ILoggerFactory factory) {
		val board = new BoardWrapper(factory)
		sectionStateNotifier = new SectionStateNotifier(locator.trackElementStateSender, new ExpanderSectionController(board, factory), factory)
		turnoutStateNotifier = new TurnoutStateNotifier(locator.trackElementStateSender, new ExpanderTurnoutController(board, factory), factory)

		this.logger = factory.getLogger(this.class.name)
	}

	protected new(SectionStateNotifier _sectionStateNotifier, TurnoutStateNotifier _turnoutStateNotifier, ILoggerFactory factory) {
		sectionStateNotifier = _sectionStateNotifier
		turnoutStateNotifier = _turnoutStateNotifier

		this.logger = factory.getLogger(this.class.name)
	}

	/**
	 * Starts the section and turnout state notifier threads.
	 */
	def start() {
		sectionStateNotifierThread = new Thread(sectionStateNotifier)
		sectionStateNotifierThread.start

		turnoutStateNotifierThread = new Thread(turnoutStateNotifier)
		turnoutStateNotifierThread.start
	}

	/**
	 * Stops the section and turnout state notifier threads.
	 */
	def interrupt() {
		interruptThread(sectionStateNotifierThread)
		interruptThread(turnoutStateNotifierThread)
	}

	/**
	 * Stops the referred thread.
	 */
	private def interruptThread(Thread thread) {
		try {
			thread.interrupt
		} catch(SecurityException ex) {
			logger.error(ex.message, ex)
		}
	}

}
