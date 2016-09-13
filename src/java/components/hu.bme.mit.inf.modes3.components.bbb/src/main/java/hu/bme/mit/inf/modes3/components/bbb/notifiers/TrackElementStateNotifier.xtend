package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderSectionController
import hu.bme.mit.inf.modes3.components.bbb.strategy.ExpanderTurnoutController
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Encapsulates a SectionStateNotifier along with a TurnoutStateNotifier so that instantiating
 * this class can send status information about the sections and turnouts to the network.
 * 
 * @author benedekh
 */
class TrackElementStateNotifier {

	@Accessors(#[PRIVATE_GETTER, PRIVATE_SETTER]) static val Logger logger = LoggerFactory.getLogger(TrackElementStateNotifier)

	// the message handlers are registered into this service locator that encapsulates the CommunicationStack
	protected val TrackCommunicationServiceLocator serviceLocator

	// notifier which polls the sections states regularly
	protected var SectionStateNotifier sectionStateNotifier

	// notifier which polls the turnouts states regularly
	protected var TurnoutStateNotifier turnoutStateNotifier

	// thread that runs the section notifier
	protected var Thread sectionStateNotifierThread

	// thread that runs the turnout notifier
	protected var Thread turnoutStateNotifierThread

	new(CommunicationStack stack, ExpanderSectionController sectionController, ExpanderTurnoutController turnoutController) {
		serviceLocator = new TrackCommunicationServiceLocator(stack)
		sectionStateNotifier = new SectionStateNotifier(serviceLocator.trackElementStateSender, sectionController)
		turnoutStateNotifier = new TurnoutStateNotifier(serviceLocator.trackElementStateSender, turnoutController)
	}

	new(CommunicationStack stack) {
		this(stack, new ExpanderSectionController, new ExpanderTurnoutController)
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
