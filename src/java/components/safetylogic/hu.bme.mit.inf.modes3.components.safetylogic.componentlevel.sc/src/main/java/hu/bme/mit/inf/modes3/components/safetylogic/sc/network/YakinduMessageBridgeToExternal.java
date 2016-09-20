package hu.bme.mit.inf.modes3.components.safetylogic.sc.network;

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

	protected final MessagingService mms;

	public YakinduMessageBridgeToExternal(MessagingService _mms) {
		this.mms = _mms;
	}

	public void reserveTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(YakinduReserveTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build());
	}

	public void releaseTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(YakinduReleaseTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build());
	}

	public void canGoTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(YakinduCanGoTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build());
	}

	public void cannotGoTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(YakinduCannotGoTo.newBuilder().setTargetID(targetID).setDirection(ConnectionDirectionConverter.toProtobufDirection(direction)).build());
	}

}
