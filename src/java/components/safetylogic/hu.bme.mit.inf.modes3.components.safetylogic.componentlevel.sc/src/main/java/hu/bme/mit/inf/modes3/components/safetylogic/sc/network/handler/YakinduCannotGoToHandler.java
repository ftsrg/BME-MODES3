package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionConverter;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCannotGoToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;

public class YakinduCannotGoToHandler implements MessageHandler<YakinduCannotGoToOrBuilder> {

	protected final IYakinduCannotGoTo handler;

	public YakinduCannotGoToHandler(final IYakinduCannotGoTo _handler) {
		this.handler = _handler;
	}

	@Override
	public void handleMessage(final YakinduCannotGoToOrBuilder message) {
		int _targetID = message.getTargetID();
		YakinduConnectionDirection _direction = message.getDirection();
		ConnectionDirection _internalDirection = ConnectionDirectionConverter.toInternalDirection(_direction);
		this.handler.cannotGoTo(_targetID, _internalDirection);
	}
}
