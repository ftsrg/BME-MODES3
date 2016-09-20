package hu.bme.mit.inf.modes3.components.safetylogic.sc.linkage

import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.LayoutConfigurationLoader
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.SectionConfiguration
import hu.bme.mit.inf.modes3.components.safetylogic.sc.conf.gson.TurnoutConfiguration
import hu.bme.mit.inf.modes3.components.safetylogic.sc.factory.YakinduStatechartComponentFactory
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.YakinduHandlerHolder
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection
import java.util.List
import java.util.Map
import org.junit.Assert
import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito
import org.yakindu.scr.section.ISectionStatemachine
import org.yakindu.scr.turnout.ITurnoutStatemachine

/**
 * Validating that the layout initialization matches the layout configuration file.
 * 
 * The validation is done before registering the statemachines to  the track status 
 * information providers (e.g. which section/turnout is occupied) and the network 
 * message transmitters from network to statecharts. 
 */
 @Ignore
class LayoutConfigurationValidationTest {

	@Test
	def test() {
		val layout = LayoutConfigurationLoader.loadLayoutConfiguration("conf/layout.json")

		layout.components.forEach [ component |
			{
				val comp = LayoutConfigurationLoader.getLayoutConfigurationForComponent(layout, component.componentName)

				println()
				println()
				println("Validating component configuration: " + component.componentName)
				println()

				val fact = new YakinduStatechartComponentFactory
				fact.initializeSectionAndTurnoutStatecharts(comp, null, Mockito.mock(YakinduHandlerHolder))

				val turnoutConfigurations = comp.turnouts
				val localTurnouts = fact.localTurnouts

				// turnout configurations
				validateTurnoutConfigurations(turnoutConfigurations, localTurnouts)

				val sectionConfigurations = comp.sections
				val localSections = fact.localSections

				// section configurations
				validateSectionConfigurations(sectionConfigurations, localSections)
			}
		]

	}

	protected def void validateTurnoutConfigurations(List<TurnoutConfiguration> turnoutConfigurations, Map<Integer, ITurnoutStatemachine> localTurnouts) {
		println("Validating turnout configurations")

		turnoutConfigurations.forEach [ turnoutConf |
			{
				println("Turnout " + turnoutConf.occupancyId)

				val localTurnout = localTurnouts.get(turnoutConf.occupancyId)
				val sciProtocolListeners = localTurnout.getSCIProtocol.listeners

				sciProtocolListeners.forEach [ listener |
					if(listener instanceof LinkedTurnoutStatemachine) {
						val turnoutStmtWrap = listener as LinkedTurnoutStatemachine
						val ntew = turnoutStmtWrap.nextTrackElement
						val weSeeItFrom = ntew.weSeeItFrom
						val itReceivesOurMessagesFrom = ntew.itReceivesOurMessagesFrom
						if(weSeeItFrom.equals(ConnectionDirection.DIVERGENT)) {
							println("Connects from " + ConnectionDirection.DIVERGENT + "; It receives our messages from " + itReceivesOurMessagesFrom + "; target type " +
								turnoutStmtWrap.nextTrackElement.nextTrackElement.class.simpleName)
							Assert.assertEquals(turnoutConf.divergent.itReceivesOurMessagesFrom, itReceivesOurMessagesFrom)
						} else if(weSeeItFrom.equals(ConnectionDirection.STRAIGHT)) {
							println("Connects from " + ConnectionDirection.STRAIGHT + "; It receives our messages from " + itReceivesOurMessagesFrom + "; target type " +
								turnoutStmtWrap.nextTrackElement.nextTrackElement.class.simpleName)
							Assert.assertEquals(turnoutConf.straight.itReceivesOurMessagesFrom, itReceivesOurMessagesFrom)
						} else if(weSeeItFrom.equals(ConnectionDirection.TOP)) {
							println("Connects from " + ConnectionDirection.TOP + "; It receives our messages from " + itReceivesOurMessagesFrom + "; target type " +
								turnoutStmtWrap.nextTrackElement.nextTrackElement.class.simpleName)
							Assert.assertEquals(turnoutConf.top.itReceivesOurMessagesFrom, itReceivesOurMessagesFrom)
						}
					}
				]
			}
		]
	}

	protected def void validateSectionConfigurations(List<SectionConfiguration> sectionConfigurations, Map<Integer, ISectionStatemachine> localSections) {
		println("Validating section configurations")

		sectionConfigurations.forEach [ sectionConf |
			{
				println("Section " + sectionConf.occupancyId)

				val localSection = localSections.get(sectionConf.occupancyId)
				val sciSectionListeners = localSection.getSCISection.listeners

				// the enable/disable section handler is registered
				Assert.assertFalse(sciSectionListeners.isEmpty)

				val sciProtocolListeners = localSection.getSCIProtocol.listeners
				sciProtocolListeners.forEach [ listener |
					if(listener instanceof LinkedSectionStatemachine) {
						val sectionStmtWrap = listener as LinkedSectionStatemachine
						val ntew = sectionStmtWrap.nextTrackElement
						val weSeeItFrom = ntew.weSeeItFrom
						val itReceivesOurMessagesFrom = ntew.itReceivesOurMessagesFrom
						if(weSeeItFrom.equals(ConnectionDirection.CW)) {
							println("Connects from " + ConnectionDirection.CW + "; It receives our messages from " + itReceivesOurMessagesFrom + "; target type " +
								sectionStmtWrap.nextTrackElement.nextTrackElement.class.simpleName)
							Assert.assertEquals(sectionConf.cw.itReceivesOurMessagesFrom, itReceivesOurMessagesFrom)
						} else if(weSeeItFrom.equals(ConnectionDirection.CCW)) {
							println("Connects from " + ConnectionDirection.CCW + "; It receives our messages from " + itReceivesOurMessagesFrom + "; target type " +
								sectionStmtWrap.nextTrackElement.nextTrackElement.class.simpleName)
							Assert.assertEquals(sectionConf.ccw.itReceivesOurMessagesFrom, itReceivesOurMessagesFrom)
						}
					}
				]
			}
		]
	}
}
