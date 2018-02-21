package hu.bme.mit.inf.modes3.messaging.communication.yakindu

import hu.bme.mit.inf.modes3.messaging.communication.yakindu.interfaces.IYakinduMessageSender
import hu.bme.mit.inf.modes3.messaging.messages.enums.ConnectionDirection
import hu.bme.mit.inf.modes3.messaging.messages.yakindu.YakinduMessageType
import hu.bme.mit.inf.modes3.messaging.messages.yakindu.YakinduProtocolMessage
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService
import org.eclipse.xtend.lib.annotations.Accessors
import org.slf4j.ILoggerFactory
import org.slf4j.Logger

class YakinduMessageSender implements IYakinduMessageSender {
	@Accessors(#[PROTECTED_GETTER, PRIVATE_SETTER]) val Logger logger
	var protected MessagingService mms

	new(MessagingService mms, ILoggerFactory factory) {
		this.logger = factory.getLogger(class.name)
		this.mms = mms
	}

	override canGoTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(new YakinduProtocolMessage(targetID, direction, YakinduMessageType.CAN_GO_TO))
		logger.debug('''YakinduCanGoTo message sent with id=«targetID» direction=«direction»''')
	}

	override cannotGoTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(new YakinduProtocolMessage(targetID, direction, YakinduMessageType.CANNOT_GO_TO))
		logger.debug('''YakinduCannotGoTo message sent with id=«targetID» direction=«direction»''')
	}

	override reserveTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(new YakinduProtocolMessage(targetID, direction, YakinduMessageType.RESERVE_TO))
		logger.debug('''YakinduReserveTo message sent with id=«targetID» direction=«direction»''')
	}

	override releaseTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(new YakinduProtocolMessage(targetID, direction, YakinduMessageType.RELEASE_TO))
		logger.debug('''YakinduReleaseTo message sent with id=«targetID» direction=«direction»''')
	}

}
