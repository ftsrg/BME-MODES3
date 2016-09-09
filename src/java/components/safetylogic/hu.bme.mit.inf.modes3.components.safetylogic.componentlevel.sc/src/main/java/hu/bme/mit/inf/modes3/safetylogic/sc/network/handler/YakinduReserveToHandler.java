package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveToOrBuilder;
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator;

public class YakinduReserveToHandler implements MessageHandler<YakinduReserveToOrBuilder> {
  private IYakinduMessageHandler handler;
  
  public YakinduReserveToHandler(final IYakinduMessageHandler _handler) {
    this.handler = _handler;
  }
  
  @Override
  public void handleMessage(final YakinduReserveToOrBuilder message) {
    int _targetID = message.getTargetID();
    YakinduConnectionDirection _direction = message.getDirection();
    ConnectionDirection _internalDirection = ConnectionDirectionTransformator.toInternalDirection(_direction);
    this.handler.reserveTo(_targetID, _internalDirection);
  }
}
