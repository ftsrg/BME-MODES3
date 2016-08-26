package hu.bme.mit.inf.modes3.messaging.mms;

import com.google.protobuf.GeneratedMessageV3;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.SegmentControlHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TrainDirectionControlHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TrainFunctionControlHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TrainReferenceSpeedControlHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.control.TurnoutControlHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.SegmentStateHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TrainCurrentSegmentHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TrainCurrentSpeedHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TrainReferenceSpeedHandler;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.status.TurnoutStateHandler;
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
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState;
import hu.bme.mit.inf.modes3.transports.zeromq.ZMQTransport;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private SegmentControlHandler segmentControlHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TrainDirectionControlHandler trainDirectionControlHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TrainReferenceSpeedControlHandler trainReferenceSpeedControlHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TrainFunctionControlHandler trainFunctionControlHandler = null;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private TurnoutControlHandler turnoutControlHandler = null;
  
  public void start() {
    final ZMQTransport transport = new ZMQTransport();
    transport.connect();
    while ((!Thread.currentThread().isInterrupted())) {
      try {
        byte[] _receiveMessage = transport.receiveMessage();
        final Message message = Message.parseFrom(_receiveMessage);
        Message.MessageType _type = message.getType();
        if (_type != null) {
          switch (_type) {
            case SEGMENT_CONTROL:
              if (this.segmentControlHandler!=null) {
                SegmentControl _segmentControl = message.getSegmentControl();
                this.segmentControlHandler.handleSegmentControl(_segmentControl);
              }
              break;
            case SEGMENT_STATE:
              if (this.segmentStateHandler!=null) {
                SegmentState _segmentState = message.getSegmentState();
                this.segmentStateHandler.handleSegmentState(_segmentState);
              }
              break;
            case TRAIN_CURRENT_SEGMENT:
              if (this.trainCurrentSegmentHandler!=null) {
                TrainCurrentSegment _trainCurrentSegment = message.getTrainCurrentSegment();
                this.trainCurrentSegmentHandler.handleTrainCurrentSegment(_trainCurrentSegment);
              }
              break;
            case TRAIN_CURRENT_SPEED:
              if (this.trainCurrentSpeedHandler!=null) {
                TrainCurrentSpeed _trainCurrentSpeed = message.getTrainCurrentSpeed();
                this.trainCurrentSpeedHandler.handleTrainCurrentSpeed(_trainCurrentSpeed);
              }
              break;
            case TRAIN_DIRECTION_CONTROL:
              if (this.trainDirectionControlHandler!=null) {
                TrainDirectionControl _trainDirectionControl = message.getTrainDirectionControl();
                this.trainDirectionControlHandler.handleTrainDirectionControl(_trainDirectionControl);
              }
              break;
            case TRAIN_FUNCTION_CONTROL:
              if (this.trainFunctionControlHandler!=null) {
                TrainFunctionControl _trainFunctionControl = message.getTrainFunctionControl();
                this.trainFunctionControlHandler.handleTrainFunctionControl(_trainFunctionControl);
              }
              break;
            case TRAIN_REFERENCE_SPEED:
              if (this.trainReferenceSpeedHandler!=null) {
                TrainReferenceSpeed _trainReferenceSpeed = message.getTrainReferenceSpeed();
                this.trainReferenceSpeedHandler.handleTrainReferenceSpeed(_trainReferenceSpeed);
              }
              break;
            case TRAIN_REFERENCE_SPEED_CONTROL:
              if (this.trainReferenceSpeedControlHandler!=null) {
                TrainReferenceSpeedControl _trainReferenceSpeedControl = message.getTrainReferenceSpeedControl();
                this.trainReferenceSpeedControlHandler.handleTrainReferenceSpeedControl(_trainReferenceSpeedControl);
              }
              break;
            case TURNOUT_CONTROL:
              if (this.turnoutControlHandler!=null) {
                TurnoutControl _turnoutControl = message.getTurnoutControl();
                this.turnoutControlHandler.handleTurnoutControl(_turnoutControl);
              }
              break;
            case TURNOUT_STATE:
              if (this.turnoutStateHandler!=null) {
                TurnoutState _turnoutState = message.getTurnoutState();
                this.turnoutStateHandler.handleTurnoutState(_turnoutState);
              }
              break;
            default:
              final Consumer<Object> _function = (Object it) -> {
              };
              Collections.EMPTY_LIST.forEach(_function);
              break;
          }
        } else {
          final Consumer<Object> _function = (Object it) -> {
          };
          Collections.EMPTY_LIST.forEach(_function);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    }
  }
  
  public void sendMessage(final GeneratedMessageV3 message) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
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
  
  @Pure
  protected SegmentControlHandler getSegmentControlHandler() {
    return this.segmentControlHandler;
  }
  
  public void setSegmentControlHandler(final SegmentControlHandler segmentControlHandler) {
    this.segmentControlHandler = segmentControlHandler;
  }
  
  @Pure
  protected TrainDirectionControlHandler getTrainDirectionControlHandler() {
    return this.trainDirectionControlHandler;
  }
  
  public void setTrainDirectionControlHandler(final TrainDirectionControlHandler trainDirectionControlHandler) {
    this.trainDirectionControlHandler = trainDirectionControlHandler;
  }
  
  @Pure
  protected TrainReferenceSpeedControlHandler getTrainReferenceSpeedControlHandler() {
    return this.trainReferenceSpeedControlHandler;
  }
  
  public void setTrainReferenceSpeedControlHandler(final TrainReferenceSpeedControlHandler trainReferenceSpeedControlHandler) {
    this.trainReferenceSpeedControlHandler = trainReferenceSpeedControlHandler;
  }
  
  @Pure
  protected TrainFunctionControlHandler getTrainFunctionControlHandler() {
    return this.trainFunctionControlHandler;
  }
  
  public void setTrainFunctionControlHandler(final TrainFunctionControlHandler trainFunctionControlHandler) {
    this.trainFunctionControlHandler = trainFunctionControlHandler;
  }
  
  @Pure
  protected TurnoutControlHandler getTurnoutControlHandler() {
    return this.turnoutControlHandler;
  }
  
  public void setTurnoutControlHandler(final TurnoutControlHandler turnoutControlHandler) {
    this.turnoutControlHandler = turnoutControlHandler;
  }
}
