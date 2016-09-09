package hu.bme.mit.inf.modes3.safetylogic.sc.network;

import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo;
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator;

public class YakinduNetworkMessageSender implements IYakinduMessageHandler {

	private MessagingService mms;

	public YakinduNetworkMessageSender(MessagingService _mms) {
		this.mms = _mms;
	}

	public void reserveTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(YakinduReserveTo.newBuilder().setTargetID(targetID)
				.setDirection(ConnectionDirectionTransformator.toProtobufDirection(direction)).build());
	}

	public void releaseTo(int targetID, ConnectionDirection direction) {
		mms.sendMessage(YakinduReleaseTo.newBuilder().setTargetID(targetID)
				.setDirection(ConnectionDirectionTransformator.toProtobufDirection(direction)).build());
	}

	public void reserveResultTo(int targetID, ConnectionDirection direction, boolean result) {
		mms.sendMessage(YakinduReserveResultTo.newBuilder().setTargetID(targetID)
				.setDirection(ConnectionDirectionTransformator.toProtobufDirection(direction)).setResult(result)
				.build());
	}

}
