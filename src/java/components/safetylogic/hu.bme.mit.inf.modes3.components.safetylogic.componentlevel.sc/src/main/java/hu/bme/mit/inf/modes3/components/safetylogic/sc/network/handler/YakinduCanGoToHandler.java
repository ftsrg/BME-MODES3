package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionConverter;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCanGoToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;

public class YakinduCanGoToHandler implements MessageHandler<YakinduCanGoToOrBuilder> {

	protected final IYakinduCanGoTo handler;

	public YakinduCanGoToHandler(final IYakinduCanGoTo _handler) {
		this.handler = _handler;
	}

	@Override
	public void handleMessage(final YakinduCanGoToOrBuilder message) {
		int _targetID = message.getTargetID();
		YakinduConnectionDirection _direction = message.getDirection();
		ConnectionDirection _internalDirection = ConnectionDirectionConverter.toInternalDirection(_direction);
		this.handler.canGoTo(_targetID, _internalDirection);
	}
}
