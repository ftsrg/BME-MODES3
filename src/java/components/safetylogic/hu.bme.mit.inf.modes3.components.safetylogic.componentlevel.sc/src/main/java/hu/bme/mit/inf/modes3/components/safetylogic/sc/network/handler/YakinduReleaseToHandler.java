package hu.bme.mit.inf.modes3.components.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.components.safetylogic.sc.util.ConnectionDirectionConverter;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseToOrBuilder;

public class YakinduReleaseToHandler implements MessageHandler<YakinduReleaseToOrBuilder> {

	protected final IYakinduReleaseTo handler;

	public YakinduReleaseToHandler(final IYakinduReleaseTo _handler) {
		this.handler = _handler;
	}

	@Override
	public void handleMessage(final YakinduReleaseToOrBuilder message) {
		int _targetID = message.getTargetID();
		YakinduConnectionDirection _direction = message.getDirection();
		ConnectionDirection _internalDirection = ConnectionDirectionConverter.toInternalDirection(_direction);
		this.handler.releaseTo(_targetID, _internalDirection);
	}
}
