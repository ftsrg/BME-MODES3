package hu.bme.mit.inf.modes3.messaging.mms;

import com.google.protobuf.GeneratedMessageV3;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.SegmentStateHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TrainCurrentSegmentHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TrainCurrentSpeedHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TrainReferenceSpeedHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.TurnoutStateHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegment;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeed;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeed;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControl;
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport;
import java.util.Arrays;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class MessagingService {
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private SegmentStateHandler segmentStateHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TrainCurrentSegmentHandler trainCurrentSegmentHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TrainCurrentSpeedHandler trainCurrentSpeedHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TrainReferenceSpeedHandler trainReferenceSpeedHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TurnoutStateHandler turnoutStateHandler = null;
  
  public void start() {
    try {
      final ZMQTransport transport = new ZMQTransport();
      transport.connect();
      while ((!Thread.currentThread().isInterrupted())) {
        {
          Thread.sleep(1000);
          byte[] _receiveMessage = transport.receiveMessage();
          final Message message = Message.parseFrom(_receiveMessage);
          Message.MessageType _type = message.getType();
          if (_type != null) {
            switch (_type) {
              case SEGMENT_CONTROL:
                SegmentControl _segmentControl = message.getSegmentControl();
                this.dispatchMessage(_segmentControl);
                break;
              case SEGMENT_STATE:
                SegmentState _segmentState = message.getSegmentState();
                this.dispatchMessage(_segmentState);
                break;
              case TRAIN_CURRENT_SEGMENT:
                TrainCurrentSegment _trainCurrentSegment = message.getTrainCurrentSegment();
                this.dispatchMessage(_trainCurrentSegment);
                break;
              case TRAIN_CURRENT_SPEED:
                TrainCurrentSpeed _trainCurrentSpeed = message.getTrainCurrentSpeed();
                this.dispatchMessage(_trainCurrentSpeed);
                break;
              case TRAIN_DIRECTION_CONTROL:
                TrainDirectionControl _trainDirectionControl = message.getTrainDirectionControl();
                this.dispatchMessage(_trainDirectionControl);
                break;
              case TRAIN_FUNCTION_CONTROL:
                TrainFunctionControl _trainFunctionControl = message.getTrainFunctionControl();
                this.dispatchMessage(_trainFunctionControl);
                break;
              case TRAIN_REFERENCE_SPEED:
                TrainReferenceSpeed _trainReferenceSpeed = message.getTrainReferenceSpeed();
                this.dispatchMessage(_trainReferenceSpeed);
                break;
              case TRAIN_REFERENCE_SPEED_CONTROL:
                TrainReferenceSpeedControl _trainReferenceSpeedControl = message.getTrainReferenceSpeedControl();
                this.dispatchMessage(_trainReferenceSpeedControl);
                break;
              case TURNOUT_CONTROL:
                TurnoutControl _turnoutControl = message.getTurnoutControl();
                this.dispatchMessage(_turnoutControl);
                break;
              case TURNOUT_STATE:
                TurnoutControl _turnoutControl_1 = message.getTurnoutControl();
                this.dispatchMessage(_turnoutControl_1);
                break;
              default:
                InputOutput.<String>println("Oops");
                break;
            }
          } else {
            InputOutput.<String>println("Oops");
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Object _dispatchMessage(final SegmentControl message) {
    return null;
  }
  
  protected Object _dispatchMessage(final SegmentState message) {
    return null;
  }
  
  protected Object _dispatchMessage(final TrainCurrentSegment message) {
    return null;
  }
  
  protected Object _dispatchMessage(final TrainCurrentSpeed message) {
    return null;
  }
  
  protected Object _dispatchMessage(final TrainDirectionControl message) {
    return null;
  }
  
  public Object dispatchMessage(final GeneratedMessageV3 message) {
    if (message instanceof SegmentControl) {
      return _dispatchMessage((SegmentControl)message);
    } else if (message instanceof SegmentState) {
      return _dispatchMessage((SegmentState)message);
    } else if (message instanceof TrainCurrentSegment) {
      return _dispatchMessage((TrainCurrentSegment)message);
    } else if (message instanceof TrainCurrentSpeed) {
      return _dispatchMessage((TrainCurrentSpeed)message);
    } else if (message instanceof TrainDirectionControl) {
      return _dispatchMessage((TrainDirectionControl)message);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(message).toString());
    }
  }
  
  @Pure
  protected SegmentStateHandler getSegmentStateHandler() {
    return this.segmentStateHandler;
  }
  
  public void setSegmentStateHandler(final SegmentStateHandler segmentStateHandler) {
    this.segmentStateHandler = segmentStateHandler;
  }
  
  @Pure
  protected TrainCurrentSegmentHandler getTrainCurrentSegmentHandler() {
    return this.trainCurrentSegmentHandler;
  }
  
  public void setTrainCurrentSegmentHandler(final TrainCurrentSegmentHandler trainCurrentSegmentHandler) {
    this.trainCurrentSegmentHandler = trainCurrentSegmentHandler;
  }
  
  @Pure
  protected TrainCurrentSpeedHandler getTrainCurrentSpeedHandler() {
    return this.trainCurrentSpeedHandler;
  }
  
  public void setTrainCurrentSpeedHandler(final TrainCurrentSpeedHandler trainCurrentSpeedHandler) {
    this.trainCurrentSpeedHandler = trainCurrentSpeedHandler;
  }
  
  @Pure
  protected TrainReferenceSpeedHandler getTrainReferenceSpeedHandler() {
    return this.trainReferenceSpeedHandler;
  }
  
  public void setTrainReferenceSpeedHandler(final TrainReferenceSpeedHandler trainReferenceSpeedHandler) {
    this.trainReferenceSpeedHandler = trainReferenceSpeedHandler;
  }
  
  @Pure
  protected TurnoutStateHandler getTurnoutStateHandler() {
    return this.turnoutStateHandler;
  }
  
  public void setTurnoutStateHandler(final TurnoutStateHandler turnoutStateHandler) {
    this.turnoutStateHandler = turnoutStateHandler;
  }
}
