package hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc

import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.bridge.ISafetyLogicBridge
import hu.bme.mit.inf.modes3.components.safetylogic.componentlevel.sc.wrapper.YakinduProtocolRestarter
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class SafetyLogic implements ISafetyLogic {

	@Accessors(PUBLIC_SETTER) var ISafetyLogicBridge safetyLogicBridge

	val ILoggerFactory factory
	val Logger logger

	val int turnoutID

	var Runnable component
	var Runnable protocolRestarter

	val ExecutorService executor

	new(int turnoutID, ILoggerFactory factory) {
		this.factory = factory
		this.logger = factory.getLogger(class.name)
		this.turnoutID = turnoutID
		this.executor = Executors.newFixedThreadPool(2)
	}

	override setSafetyLogicBridge(ISafetyLogicBridge safetyLogicBridge) {
		this.safetyLogicBridge = safetyLogicBridge

		val yakinduProtocolRestarter = new YakinduProtocolRestarter(factory)
		protocolRestarter = yakinduProtocolRestarter

		val commander = safetyLogicBridge.trackElementCommander
		val trackElementStateRegistry = safetyLogicBridge.trackElementStateRegistry
		val protocolDispatcher = safetyLogicBridge.yakinduProtocolDispatcher

		val slInitializer = new SafetyLogicInitializer(yakinduProtocolRestarter, protocolDispatcher, safetyLogicBridge, commander, trackElementStateRegistry)
		component = slInitializer.init(turnoutID)
	}

	override run() {
		executor.execute(component)
		executor.execute(protocolRestarter)
	// Thread.currentThread.join
	}

}
