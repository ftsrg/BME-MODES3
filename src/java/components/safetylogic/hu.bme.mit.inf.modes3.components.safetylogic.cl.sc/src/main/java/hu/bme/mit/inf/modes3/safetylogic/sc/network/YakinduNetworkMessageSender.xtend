package hu.bme.mit.inf.modes3.safetylogic.sc.network

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultTo
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator

class YakinduNetworkMessageSender implements IYakinduMessageHandler {

	private var MessagingService mms

	new(MessagingService _mms) {
		this.mms = _mms
	}

	override reserveTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage((YakinduReserveTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(direction)
		]).build)
	}

	override releaseTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage((YakinduReleaseTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(direction)
		]).build)
	}

	override reserveResultTo(int targetID, ConnectionDirection direction, boolean result) {
		mms.sendMessage((YakinduReserveResultTo.newBuilder => [
			it.targetID = targetID
			it.direction = ConnectionDirectionTransformator.toProtobufDirection(direction)
			it.result = result
		]).build)
	}

}
