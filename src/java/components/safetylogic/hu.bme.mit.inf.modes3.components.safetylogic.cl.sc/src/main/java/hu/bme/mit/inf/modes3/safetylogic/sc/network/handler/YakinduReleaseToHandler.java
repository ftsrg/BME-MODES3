package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseToOrBuilder;
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator;

public class YakinduReleaseToHandler implements MessageHandler<YakinduReleaseToOrBuilder> {
  private IYakinduMessageHandler handler;
  
  public YakinduReleaseToHandler(final IYakinduMessageHandler _handler) {
    this.handler = _handler;
  }
  
  @Override
  public void handleMessage(final YakinduReleaseToOrBuilder message) {
    int _targetID = message.getTargetID();
    YakinduConnectionDirection _direction = message.getDirection();
    ConnectionDirection _internalDirection = ConnectionDirectionTransformator.toInternalDirection(_direction);
    this.handler.releaseTo(_targetID, _internalDirection);
  }
}
