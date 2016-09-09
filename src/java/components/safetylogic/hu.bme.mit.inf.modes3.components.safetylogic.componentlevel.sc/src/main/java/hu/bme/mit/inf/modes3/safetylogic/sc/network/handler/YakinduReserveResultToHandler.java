package hu.bme.mit.inf.modes3.safetylogic.sc.network.handler;

import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduConnectionDirection;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultToOrBuilder;
import hu.bme.mit.inf.modes3.safetylogic.sc.network.handler.IYakinduMessageHandler;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirection;
import hu.bme.mit.inf.modes3.safetylogic.sc.util.ConnectionDirectionTransformator;

public class YakinduReserveResultToHandler implements MessageHandler<YakinduReserveResultToOrBuilder> {
  private IYakinduMessageHandler handler;
  
  public YakinduReserveResultToHandler(final IYakinduMessageHandler _handler) {
    this.handler = _handler;
  }
  
  @Override
  public void handleMessage(final YakinduReserveResultToOrBuilder message) {
    int _targetID = message.getTargetID();
    YakinduConnectionDirection _direction = message.getDirection();
    ConnectionDirection _internalDirection = ConnectionDirectionTransformator.toInternalDirection(_direction);
    boolean _result = message.getResult();
    this.handler.reserveResultTo(_targetID, _internalDirection, _result);
  }
}
