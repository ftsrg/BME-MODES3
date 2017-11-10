package hu.bme.mit.inf.modes3.components.safetylogic.sc.network;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCanGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduCannotGoTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReleaseTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler.IYakinduReserveTo;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionConverter;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCanGoTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCannotGoTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo;

public class YakinduMessageBridgeToExternal implements IYakinduReserveTo, IYakinduCanGoTo, IYakinduCannotGoTo, IYakinduReleaseTo {

	protected final Logger logger;
	
	protected final MessagingService mms;

	public YakinduMessageBridgeToExternal(MessagingService _mms, ILoggerFactory factory) {
		this.mms = _mms;
		this.logger = factory.getLogger(this.getClass().getName());
	}

	public void reserveTo(int targetID, ConnectionDirection direction) {
		YakinduReserveTo message = YakinduReserveTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build();
		logger.debug(message + " forwarded to MessagingService");
		mms.sendMessage(message);
	}

	public void releaseTo(int targetID, ConnectionDirection direction) {
		YakinduReleaseTo message = YakinduReleaseTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build();
		logger.debug(message + " forwarded to MessagingService");
		mms.sendMessage(message);
	}

	public void canGoTo(int targetID, ConnectionDirection direction) {
		YakinduCanGoTo message = YakinduCanGoTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build();
		logger.debug(message + " forwarded to MessagingService");
		mms.sendMessage(message);
	}

	public void cannotGoTo(int targetID, ConnectionDirection direction) {
		YakinduCannotGoTo message = YakinduCannotGoTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build();
		logger.debug(message + " forwarded to MessagingService");
		mms.sendMessage(message);
	}

}
