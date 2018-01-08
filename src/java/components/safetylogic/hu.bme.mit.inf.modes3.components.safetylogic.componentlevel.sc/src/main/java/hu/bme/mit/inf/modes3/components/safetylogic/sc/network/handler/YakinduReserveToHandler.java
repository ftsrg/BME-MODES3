package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionConverter;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveToOrBuilder;

public class YakinduReserveToHandler implements MessageHandler<YakinduReserveToOrBuilder> {

	protected final IYakinduReserveTo handler;

	public YakinduReserveToHandler(final IYakinduReserveTo _handler) {
		this.handler = _handler;
	}

	@Override
	public void handleMessage(final YakinduReserveToOrBuilder message) {
		int _targetID = message.getTargetID();
		YakinduConnectionDirection _direction = message.getDirection();
		ConnectionDirection _internalDirection = ConnectionDirectionConverter.toInternalDirection(_direction);
		this.handler.reserveTo(_targetID, _internalDirection);
	}
}
