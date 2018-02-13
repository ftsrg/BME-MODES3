package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface
import java.util.Set
import java.util.concurrent.ConcurrentSkipListSet
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class PeriodicYakinduProtocolRestarter implements Runnable {

	private static val SLEEP_TIME = 50

	val Logger logger
	val Set<SectionControlInterface.Provided> sectionsToBeRestarted = new ConcurrentSkipListSet

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(class.name)
	}

	override run() {
		while(!Thread.interrupted) {
			try {
				sectionsToBeRestarted.forEach [
					try {
						raiseRestartProtocol
					} catch(Exception ex) {
						logger.error(ex.message)
					}
				]
				Thread.sleep(SLEEP_TIME)
			} catch(InterruptedException ex) {
				logger.error(ex.message)
				Thread.currentThread.interrupt
			}
		}
	}

}
