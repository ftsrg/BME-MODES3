package hu.bme.mit.inf.modes3.components.bbb.notifiers

import hu.bme.mit.inf.modes3.components.bbb.strategy.ISegmentControllerStrategy
import hu.bme.mit.inf.modes3.messaging.communication.state.interfaces.ITrackElementStateSender
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

/**
 * Implements a runnable which frequently polls the sections status 
 * (ENABLED or DISABLED) and transfers this to the network so that 
 * everyone who is subscribed can receive it.
 * 
 * @author benedekh
 */
package class SectionStateNotifier implements Runnable {

	@Accessors(PROTECTED_GETTER, PRIVATE_SETTER) val Logger logger

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val SLEEP_MS_BETWEEN_POLLINGS = 50

	// the actuator that can access the referred section
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ISegmentControllerStrategy sectionController

	// send section state on the network
	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER) val ITrackElementStateSender trackElementStateSender

	new(ITrackElementStateSender _trackElementStateSender, ISegmentControllerStrategy _sectionController, ILoggerFactory factory) {
		trackElementStateSender = _trackElementStateSender
		sectionController = _sectionController

		this.logger = factory.getLogger(this.class.name)
	}

	override run() {
		logger.info('''SectionStateNotifier started''')
		
		while(!Thread.interrupted) {
			try {
				for (sectionId : sectionController.managedSections) {
					val sectionStatus = sectionController.getSectionStatus(sectionId)
					trackElementStateSender.sendSegmentState(sectionId, sectionStatus)
					
					logger.info('''Section ''' + sectionId + ''''s status ''' + sectionStatus + ''' is sent.''')
				}
				Thread.sleep(SLEEP_MS_BETWEEN_POLLINGS)
			} catch(InterruptedException ex) {
				logger.error(ex.message, ex)
				Thread.currentThread.interrupt
			}
		}
	}

}
