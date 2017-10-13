package hu.bme.mit.inf.modes3.components.trackelementcontroller

import hu.bme.mit.inf.modes3.components.bbb.config.Configuration
import org.junit.Test
import org.slf4j.impl.SimpleLoggerFactory

class ConfigurationTest {
	
	@Test
	def void testConfiguration() {
		val factory = new SimpleLoggerFactory
		val logger = factory.getLogger("ASD")
		
		val config = Configuration::loadPinoutConfig(5, factory)
		logger.info(config.getSectionExpander(11));
	}
	
}