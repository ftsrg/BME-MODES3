package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comparators.ProvidedSectionControlInterfaceComparator
import java.util.Set
import java.util.concurrent.ConcurrentSkipListSet
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class YakinduProtocolRestarter implements Runnable, IYakinduProtocolRestarter {

	private static val SLEEP_TIME = 500

	val Logger logger
	val Set<SectionControlInterface.Provided> sectionsToBeRestarted

	new(ILoggerFactory factory) {
		this.logger = factory.getLogger(class.name)
		this.sectionsToBeRestarted = new ConcurrentSkipListSet(new ProvidedSectionControlInterfaceComparator)
	}

	override registerSection(SectionControlInterface.Provided section) {
		sectionsToBeRestarted.add(section)
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
