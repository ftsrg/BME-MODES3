package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc

import hu.bme.mit.gamma.impl.async_t1.AsyncT1Component
import hu.bme.mit.gamma.impl.async_t2.AsyncT2Component
import hu.bme.mit.gamma.impl.async_t3.AsyncT3Component
import hu.bme.mit.gamma.impl.async_t4.AsyncT4Component
import hu.bme.mit.gamma.impl.async_t5.AsyncT5Component
import hu.bme.mit.gamma.impl.async_t6.AsyncT6Component
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.comm.dispatcher.IYakinduMessageSender
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.IYakinduProtocolDispatcher
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.IYakinduProtocolRestarter
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.PortWithDirection
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.SectionEnablednessAdapter
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.SegmentOccupancyNotifier
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.TurnoutDirectionNotifier
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.YakinduProtocolAdapter
import hu.bme.mit.inf.modes3.messaging.communication.command.trackelement.interfaces.ITrackElementCommander
import hu.bme.mit.inf.modes3.messaging.communication.state.trackelement.interfaces.ITrackElementStateRegistry
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

import static hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.ConnectionDirection.*

class SafetyLogicInitializer {
	val Logger logger
	val ILoggerFactory loggerFactory

	val IYakinduProtocolRestarter protocolRestarter
	val IYakinduProtocolDispatcher protocolDispatcher

	val IYakinduMessageSender messageSender

	val ITrackElementCommander commander
	val ITrackElementStateRegistry stateRegistry

	new(ILoggerFactory factory, IYakinduProtocolRestarter protocolRestarter, IYakinduProtocolDispatcher protocolDispatcher, IYakinduMessageSender messageSender, ITrackElementCommander commander, ITrackElementStateRegistry stateRegistry) {
		this.logger = factory.getLogger(class.name)
		this.loggerFactory = factory

		this.protocolRestarter = protocolRestarter
		this.protocolDispatcher = protocolDispatcher
		this.messageSender = messageSender
		this.commander = commander
		this.stateRegistry = stateRegistry
	}

	def init(int turnoutID) {
		val component = switch (turnoutID) {
			case 1: initT1
			case 2: initT2
			case 3: initT3
			case 4: initT4
			case 5: initT5
			case 6: initT6
		}
		logger.debug('''SafetyLogic is «IF component === null»not«ENDIF» initialized for turnout (ID=«turnoutID»)''')
		return component
	}

	private def initT1() {
		val component = new AsyncT1Component

		// turnout vicinity
		val t1 = 1
		val t1Occupancy = 14
		val s12 = 12
		val s15 = 15

		// neighbours
		val s1 = 1
		val s11 = 11
		val s24 = 24

		// segments train interfaces
		new SegmentOccupancyNotifier(loggerFactory, t1Occupancy, component.t1TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s12, component.s12TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s15, component.s15TrainProvided, stateRegistry)

		// turnout control interface
		new TurnoutDirectionNotifier(loggerFactory, t1, component.t1TurnoutProvided, stateRegistry)

		// sections control interfaces
		val s12ControlProvider = component.s12ControlProvided
		s12ControlProvider.registerListener(new SectionEnablednessAdapter(s12, commander))
		protocolRestarter.registerSection(s12ControlProvider)

		val s15ControlProvider = component.s15ControlProvided
		s15ControlProvider.registerListener(new SectionEnablednessAdapter(s15, commander))
		protocolRestarter.registerSection(s15ControlProvider)

		// turnout protocol interfaces
		component.t1ProtocolRequiredDivergent.registerListener(new YakinduProtocolAdapter(s11, DIVERGENT, messageSender))
		protocolDispatcher.registerSegment(t1Occupancy, new PortWithDirection(CW, component.t1ProtocolProvidedDivergent))

		// section protocol interfaces
		component.s12ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s1, CCW, messageSender))
		protocolDispatcher.registerSegment(s12, new PortWithDirection(CW, component.s12ProtocolProvidedCCW))

		component.s15ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s24, CW, messageSender))
		protocolDispatcher.registerSegment(s15, new PortWithDirection(CCW, component.s15ProtocolProvidedCW))

		return component
	}

	private def initT2() {
		val component = new AsyncT2Component

		// turnout vicinity
		val t2Occupancy = 28
		val t2 = 2
		val s18 = 18
		val s24 = 24
		val s29 = 29
		val s31 = 31

		// neighbours
		val s30 = 30
		val s6 = 6
		val s15 = 15

		// segments train interfaces
		new SegmentOccupancyNotifier(loggerFactory, t2Occupancy, component.t2TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s18, component.s18TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s24, component.s24TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s29, component.s29TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s31, component.s31TrainProvided, stateRegistry)

		// turnout control interface
		new TurnoutDirectionNotifier(loggerFactory, t2, component.t2TurnoutProvided, stateRegistry)

		// sections control interfaces
		val s18ControlProvider = component.s18ControlProvided
		s18ControlProvider.registerListener(new SectionEnablednessAdapter(s18, commander))
		protocolRestarter.registerSection(s18ControlProvider)

		val s24ControlProvider = component.s24ControlProvided
		s24ControlProvider.registerListener(new SectionEnablednessAdapter(s24, commander))
		protocolRestarter.registerSection(s24ControlProvider)

		val s29ControlProvider = component.s29ControlProvided
		s29ControlProvider.registerListener(new SectionEnablednessAdapter(s29, commander))
		protocolRestarter.registerSection(s29ControlProvider)

		val s31ControlProvider = component.s31ControlProvided
		s31ControlProvider.registerListener(new SectionEnablednessAdapter(s31, commander))
		protocolRestarter.registerSection(s31ControlProvider)

		// turnout protocol interfaces
		component.t2ProtocolRequiredDivergent.registerListener(new YakinduProtocolAdapter(s30, DIVERGENT, messageSender))
		protocolDispatcher.registerSegment(t2Occupancy, new PortWithDirection(CCW, component.t2ProtocolProvidedDivergent))

		// section protocol interfaces
		component.s18ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s6, CW, messageSender))
		protocolDispatcher.registerSegment(s18, new PortWithDirection(CCW, component.s18ProtocolProvidedCW))

		component.s24ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s15, CCW, messageSender))
		protocolDispatcher.registerSegment(s24, new PortWithDirection(CW, component.s24ProtocolProvidedCCW))

		return component
	}

	private def initT3() {
		val component = new AsyncT3Component

		// turnout vicinity
		val t3_1Occupancy = 25
		val t3_2Occupancy = 32
		val t3 = 3
		val s19 = 19
		val s20 = 20
		val s26 = 26
		val s30 = 30

		// neighbours
		val s7 = 7
		val s13 = 13
		val s27 = 27
		val s28 = 28

		// segments train interfaces
		new SegmentOccupancyNotifier(loggerFactory, t3_1Occupancy, component.t3_1TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, t3_2Occupancy, component.t3_2TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s19, component.s19TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s20, component.s20TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s26, component.s26TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s30, component.s30TrainProvided, stateRegistry)

		// turnout control interface
		new TurnoutDirectionNotifier(loggerFactory, t3, component.t3_1TurnoutProvided, stateRegistry)
		new TurnoutDirectionNotifier(loggerFactory, t3, component.t3_2TurnoutProvided, stateRegistry)

		// sections control interfaces
		val s19ControlProvider = component.s19ControlProvided
		s19ControlProvider.registerListener(new SectionEnablednessAdapter(s19, commander))
		protocolRestarter.registerSection(s19ControlProvider)

		val s20ControlProvider = component.s20ControlProvided
		s20ControlProvider.registerListener(new SectionEnablednessAdapter(s20, commander))
		protocolRestarter.registerSection(s20ControlProvider)

		val s26ControlProvider = component.s26ControlProvided
		s26ControlProvider.registerListener(new SectionEnablednessAdapter(s26, commander))
		protocolRestarter.registerSection(s26ControlProvider)

		val s30ControlProvider = component.s30ControlProvided
		s30ControlProvider.registerListener(new SectionEnablednessAdapter(s30, commander))
		protocolRestarter.registerSection(s30ControlProvider)

		// section protocol interfaces
		component.s19ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s7, CW, messageSender))
		protocolDispatcher.registerSegment(s19, new PortWithDirection(CCW, component.s19ProtocolProvidedCW))

		component.s20ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s13, CW, messageSender))
		protocolDispatcher.registerSegment(s20, new PortWithDirection(CCW, component.s20ProtocolProvidedCW))

		component.s26ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s27, CCW, messageSender))
		protocolDispatcher.registerSegment(s26, new PortWithDirection(CW, component.s26ProtocolProvidedCCW))

		component.s30ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s28, CCW, messageSender))
		protocolDispatcher.registerSegment(s30, new PortWithDirection(DIVERGENT, component.s30ProtocolProvidedCCW))

		return component
	}

	private def initT4() {
		val component = new AsyncT4Component

		// turnout vicinity
		val t4Occupancy = 3
		val t4 = 4
		val s1 = 1
		val s2 = 2
		val s4 = 4
		val s5 = 5
		val s6 = 6
		val s7 = 7

		// neighbours
		val s12 = 12
		val s18 = 18
		val s19 = 19

		// segments train interfaces
		new SegmentOccupancyNotifier(loggerFactory, t4Occupancy, component.t4TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s1, component.s01TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s2, component.s02TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s4, component.s04TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s5, component.s05TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s6, component.s06TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s7, component.s07TrainProvided, stateRegistry)

		// turnout control interface
		new TurnoutDirectionNotifier(loggerFactory, t4, component.t4TurnoutProvided, stateRegistry)

		// sections control interfaces
		val s01ControlProvider = component.s01ControlProvided
		s01ControlProvider.registerListener(new SectionEnablednessAdapter(s1, commander))
		protocolRestarter.registerSection(s01ControlProvider)

		val s02ControlProvider = component.s02ControlProvided
		s02ControlProvider.registerListener(new SectionEnablednessAdapter(s2, commander))
		protocolRestarter.registerSection(s02ControlProvider)

		val s04ControlProvider = component.s04ControlProvided
		s04ControlProvider.registerListener(new SectionEnablednessAdapter(s4, commander))
		protocolRestarter.registerSection(s04ControlProvider)

		val s05ControlProvider = component.s05ControlProvided
		s05ControlProvider.registerListener(new SectionEnablednessAdapter(s5, commander))
		protocolRestarter.registerSection(s05ControlProvider)

		val s06ControlProvider = component.s06ControlProvided
		s06ControlProvider.registerListener(new SectionEnablednessAdapter(s6, commander))
		protocolRestarter.registerSection(s06ControlProvider)

		val s07ControlProvider = component.s07ControlProvided
		s07ControlProvider.registerListener(new SectionEnablednessAdapter(s7, commander))
		protocolRestarter.registerSection(s07ControlProvider)

		// section protocol interfaces
		component.s01ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s12, CW, messageSender))
		protocolDispatcher.registerSegment(s1, new PortWithDirection(CCW, component.s01ProtocolProvidedCW))

		component.s06ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s18, CCW, messageSender))
		protocolDispatcher.registerSegment(s6, new PortWithDirection(CW, component.s06ProtocolProvidedCCW))

		component.s07ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s19, CCW, messageSender))
		protocolDispatcher.registerSegment(s7, new PortWithDirection(CW, component.s07ProtocolProvidedCCW))

		return component
	}

	private def initT5() {
		val component = new AsyncT5Component

		// turnout vicinity
		val t5Occupancy = 9
		val t5 = 5
		val s8 = 8
		val s10 = 10
		val s11 = 11
		val s13 = 13

		// neighbours
		val s14 = 14
		val s17 = 17
		val s20 = 20

		// segments train interfaces
		new SegmentOccupancyNotifier(loggerFactory, t5Occupancy, component.t5TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s8, component.s08TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s10, component.s10TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s11, component.s11TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s13, component.s13TrainProvided, stateRegistry)

		// turnout control interface
		new TurnoutDirectionNotifier(loggerFactory, t5, component.t5TurnoutProvided, stateRegistry)

		// sections control interfaces		
		val s08ControlProvider = component.s08ControlProvided
		s08ControlProvider.registerListener(new SectionEnablednessAdapter(s8, commander))
		protocolRestarter.registerSection(s08ControlProvider)

		val s10ControlProvider = component.s10ControlProvided
		s10ControlProvider.registerListener(new SectionEnablednessAdapter(s10, commander))
		protocolRestarter.registerSection(s10ControlProvider)

		val s11ControlProvider = component.s11ControlProvided
		s11ControlProvider.registerListener(new SectionEnablednessAdapter(s11, commander))
		protocolRestarter.registerSection(s11ControlProvider)

		val s13ControlProvider = component.s13ControlProvided
		s13ControlProvider.registerListener(new SectionEnablednessAdapter(s13, commander))
		protocolRestarter.registerSection(s13ControlProvider)

		// section protocol interfaces
		component.s10ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s17, CW, messageSender))
		protocolDispatcher.registerSegment(s10, new PortWithDirection(CCW, component.s10ProtocolProvidedCW))

		component.s11ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s14, CW, messageSender))
		protocolDispatcher.registerSegment(s11, new PortWithDirection(DIVERGENT, component.s11ProtocolProvidedCW))

		component.s13ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s20, CCW, messageSender))
		protocolDispatcher.registerSegment(s13, new PortWithDirection(CW, component.s13ProtocolProvidedCCW))

		return component
	}

	private def initT6() {
		val component = new AsyncT6Component

		// turnout vicinity
		val t6Occupancy = 21
		val t6 = 6
		val s17 = 17
		val s22 = 22
		val s23 = 23
		val s27 = 27

		// neighbours
		val s10 = 10
		val s26 = 26

		// segments train interfaces
		new SegmentOccupancyNotifier(loggerFactory, t6Occupancy, component.t6TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s17, component.s17TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s22, component.s22TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s23, component.s23TrainProvided, stateRegistry)
		new SegmentOccupancyNotifier(loggerFactory, s27, component.s27TrainProvided, stateRegistry)

		// turnout control interface
		new TurnoutDirectionNotifier(loggerFactory, t6, component.t6TurnoutProvided, stateRegistry)

		// sections control interfaces		
		val s17ControlProvider = component.s17ControlProvided
		s17ControlProvider.registerListener(new SectionEnablednessAdapter(s17, commander))
		protocolRestarter.registerSection(s17ControlProvider)

		val s22ControlProvider = component.s22ControlProvided
		s22ControlProvider.registerListener(new SectionEnablednessAdapter(s22, commander))
		protocolRestarter.registerSection(s22ControlProvider)

		val s23ControlProvider = component.s23ControlProvided
		s23ControlProvider.registerListener(new SectionEnablednessAdapter(s23, commander))
		protocolRestarter.registerSection(s23ControlProvider)

		val s27ControlProvider = component.s27ControlProvided
		s27ControlProvider.registerListener(new SectionEnablednessAdapter(s27, commander))
		protocolRestarter.registerSection(s27ControlProvider)

		// section protocol interfaces
		component.s17ProtocolRequiredCCW.registerListener(new YakinduProtocolAdapter(s10, CCW, messageSender))
		protocolDispatcher.registerSegment(s17, new PortWithDirection(CW, component.s17ProtocolProvidedCCW))

		component.s22ProtocolRequiredCW.registerListener(new ProtocolInterface.Listener.Required() {

			override raiseCanGo() {
			}

			override raiseCannotGo() {
			}

			override raiseRelease() {
			}

			override raiseReserve() {
				// S22 is a dead end, don't go there
				component.s22ProtocolProvidedCW.raiseCannotGo
			}

		})

		component.s27ProtocolRequiredCW.registerListener(new YakinduProtocolAdapter(s26, CW, messageSender))
		protocolDispatcher.registerSegment(s27, new PortWithDirection(CCW, component.s27ProtocolProvidedCW))

		return component
	}
}
