package hu.bme.mit.inf.modes3.messaging.mms.dispatcher;

import com.google.protobuf.GeneratedMessageV3;
import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.MessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentControlOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentState;
import hu.bme.mit.inf.modes3.messaging.mms.messages.SegmentStateOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegment;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSegmentOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeed;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainCurrentSpeedOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainDirectionControlOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainFunctionControlOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeed;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedControlOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TrainReferenceSpeedOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControl;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutControlOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutState;
import hu.bme.mit.inf.modes3.messaging.mms.messages.TurnoutStateOrBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ProtobufMessageDispatcher implements MessageDispatcher {
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TrainCurrentSpeedOrBuilder> trainCurrentSpeedHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TrainReferenceSpeedOrBuilder> trainReferenceSpeedHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TrainCurrentSegmentOrBuilder> trainCurrentSegmentHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TurnoutStateOrBuilder> turnoutStateHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<SegmentStateOrBuilder> segmentStateHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TrainDirectionControlOrBuilder> trainDirectionControlHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TrainReferenceSpeedControlOrBuilder> trainReferenceSpeedControlHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TrainFunctionControlOrBuilder> trainFunctionControlHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<TurnoutControlOrBuilder> turnoutControlHandler;
  
  @Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
  private MessageHandler<SegmentControlOrBuilder> segmentControlHandler;
  
  @Override
  public void dispatchMessage(final byte[] raw_message) {
    try {
      final Message message = Message.parseFrom(raw_message);
      Object _type = message.getType();
      final Message.MessageType _switchValue = ((Message.MessageType) _type);
      if (_switchValue != null) {
        switch (_switchValue) {
          case SEGMENT_CONTROL:
            if (this.segmentControlHandler!=null) {
              SegmentControl _segmentControl = message.getSegmentControl();
              this.segmentControlHandler.handleMessage(_segmentControl);
            }
            break;
          case SEGMENT_STATE:
            if (this.segmentStateHandler!=null) {
              SegmentState _segmentState = message.getSegmentState();
              this.segmentStateHandler.handleMessage(_segmentState);
            }
            break;
          case TRAIN_CURRENT_SEGMENT:
            if (this.trainCurrentSegmentHandler!=null) {
              TrainCurrentSegment _trainCurrentSegment = message.getTrainCurrentSegment();
              this.trainCurrentSegmentHandler.handleMessage(_trainCurrentSegment);
            }
            break;
          case TRAIN_CURRENT_SPEED:
            if (this.trainCurrentSpeedHandler!=null) {
              TrainCurrentSpeed _trainCurrentSpeed = message.getTrainCurrentSpeed();
              this.trainCurrentSpeedHandler.handleMessage(_trainCurrentSpeed);
            }
            break;
          case TRAIN_DIRECTION_CONTROL:
            if (this.trainDirectionControlHandler!=null) {
              TrainDirectionControl _trainDirectionControl = message.getTrainDirectionControl();
              this.trainDirectionControlHandler.handleMessage(_trainDirectionControl);
            }
            break;
          case TRAIN_FUNCTION_CONTROL:
            if (this.trainFunctionControlHandler!=null) {
              TrainFunctionControl _trainFunctionControl = message.getTrainFunctionControl();
              this.trainFunctionControlHandler.handleMessage(_trainFunctionControl);
            }
            break;
          case TRAIN_REFERENCE_SPEED:
            if (this.trainReferenceSpeedHandler!=null) {
              TrainReferenceSpeed _trainReferenceSpeed = message.getTrainReferenceSpeed();
              this.trainReferenceSpeedHandler.handleMessage(_trainReferenceSpeed);
            }
            break;
          case TRAIN_REFERENCE_SPEED_CONTROL:
            if (this.trainReferenceSpeedControlHandler!=null) {
              TrainReferenceSpeedControl _trainReferenceSpeedControl = message.getTrainReferenceSpeedControl();
              this.trainReferenceSpeedControlHandler.handleMessage(_trainReferenceSpeedControl);
            }
            break;
          case TURNOUT_CONTROL:
            if (this.turnoutControlHandler!=null) {
              TurnoutControl _turnoutControl = message.getTurnoutControl();
              this.turnoutControlHandler.handleMessage(_turnoutControl);
            }
            break;
          case TURNOUT_STATE:
            if (this.turnoutStateHandler!=null) {
              TurnoutState _turnoutState = message.getTurnoutState();
              this.turnoutStateHandler.handleMessage(_turnoutState);
            }
            break;
          default:
            final Consumer<Object> _function = new Consumer<Object>() {
              @Override
              public void accept(final Object it) {
              }
            };
            Collections.EMPTY_LIST.forEach(_function);
            break;
        }
      } else {
        final Consumer<Object> _function = new Consumer<Object>() {
          @Override
          public void accept(final Object it) {
          }
        };
        Collections.EMPTY_LIST.forEach(_function);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public byte[] convertMessageToRaw(final Object _message) throws ClassCastException {
    return this.internalConvertMessageToRaw(((GeneratedMessageV3) _message));
  }
  
  protected byte[] _internalConvertMessageToRaw(final SegmentControl _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\nsegmentControl cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final SegmentState _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\nsegmentState cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TrainCurrentSegment _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ntrainCurrentSegment cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TrainCurrentSpeed _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ntrainCurrentSpeed cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TrainDirectionControl _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ntrainDirectionControl cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TrainFunctionControl _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ntrainFunctionControl cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TrainReferenceSpeed _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ntrainReferenceSpeed cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TrainReferenceSpeedControl _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\ntrainReferenceSpeedControl cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TurnoutControl _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\nturnoutControl cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  protected byte[] _internalConvertMessageToRaw(final TurnoutState _message) {
    throw new Error("Unresolved compilation problems:"
      + "\ntype cannot be resolved"
      + "\nturnoutState cannot be resolved"
      + "\nbuild cannot be resolved"
      + "\ntoByteArray cannot be resolved");
  }
  
  public byte[] internalConvertMessageToRaw(final GeneratedMessageV3 _message) {
    if (_message instanceof SegmentControl) {
      return _internalConvertMessageToRaw((SegmentControl)_message);
    } else if (_message instanceof SegmentState) {
      return _internalConvertMessageToRaw((SegmentState)_message);
    } else if (_message instanceof TrainCurrentSegment) {
      return _internalConvertMessageToRaw((TrainCurrentSegment)_message);
    } else if (_message instanceof TrainCurrentSpeed) {
      return _internalConvertMessageToRaw((TrainCurrentSpeed)_message);
    } else if (_message instanceof TrainDirectionControl) {
      return _internalConvertMessageToRaw((TrainDirectionControl)_message);
    } else if (_message instanceof TrainFunctionControl) {
      return _internalConvertMessageToRaw((TrainFunctionControl)_message);
    } else if (_message instanceof TrainReferenceSpeed) {
      return _internalConvertMessageToRaw((TrainReferenceSpeed)_message);
    } else if (_message instanceof TrainReferenceSpeedControl) {
      return _internalConvertMessageToRaw((TrainReferenceSpeedControl)_message);
    } else if (_message instanceof TurnoutControl) {
      return _internalConvertMessageToRaw((TurnoutControl)_message);
    } else if (_message instanceof TurnoutState) {
      return _internalConvertMessageToRaw((TurnoutState)_message);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(_message).toString());
    }
  }
  
  @Pure
  protected MessageHandler<TrainCurrentSpeedOrBuilder> getTrainCurrentSpeedHandler() {
    return this.trainCurrentSpeedHandler;
  }
  
  public void setTrainCurrentSpeedHandler(final MessageHandler<TrainCurrentSpeedOrBuilder> trainCurrentSpeedHandler) {
    this.trainCurrentSpeedHandler = trainCurrentSpeedHandler;
  }
  
  @Pure
  protected MessageHandler<TrainReferenceSpeedOrBuilder> getTrainReferenceSpeedHandler() {
    return this.trainReferenceSpeedHandler;
  }
  
  public void setTrainReferenceSpeedHandler(final MessageHandler<TrainReferenceSpeedOrBuilder> trainReferenceSpeedHandler) {
    this.trainReferenceSpeedHandler = trainReferenceSpeedHandler;
  }
  
  @Pure
  protected MessageHandler<TrainCurrentSegmentOrBuilder> getTrainCurrentSegmentHandler() {
    return this.trainCurrentSegmentHandler;
  }
  
  public void setTrainCurrentSegmentHandler(final MessageHandler<TrainCurrentSegmentOrBuilder> trainCurrentSegmentHandler) {
    this.trainCurrentSegmentHandler = trainCurrentSegmentHandler;
  }
  
  @Pure
  protected MessageHandler<TurnoutStateOrBuilder> getTurnoutStateHandler() {
    return this.turnoutStateHandler;
  }
  
  public void setTurnoutStateHandler(final MessageHandler<TurnoutStateOrBuilder> turnoutStateHandler) {
    this.turnoutStateHandler = turnoutStateHandler;
  }
  
  @Pure
  protected MessageHandler<SegmentStateOrBuilder> getSegmentStateHandler() {
    return this.segmentStateHandler;
  }
  
  public void setSegmentStateHandler(final MessageHandler<SegmentStateOrBuilder> segmentStateHandler) {
    this.segmentStateHandler = segmentStateHandler;
  }
  
  @Pure
  protected MessageHandler<TrainDirectionControlOrBuilder> getTrainDirectionControlHandler() {
    return this.trainDirectionControlHandler;
  }
  
  public void setTrainDirectionControlHandler(final MessageHandler<TrainDirectionControlOrBuilder> trainDirectionControlHandler) {
    this.trainDirectionControlHandler = trainDirectionControlHandler;
  }
  
  @Pure
  protected MessageHandler<TrainReferenceSpeedControlOrBuilder> getTrainReferenceSpeedControlHandler() {
    return this.trainReferenceSpeedControlHandler;
  }
  
  public void setTrainReferenceSpeedControlHandler(final MessageHandler<TrainReferenceSpeedControlOrBuilder> trainReferenceSpeedControlHandler) {
    this.trainReferenceSpeedControlHandler = trainReferenceSpeedControlHandler;
  }
  
  @Pure
  protected MessageHandler<TrainFunctionControlOrBuilder> getTrainFunctionControlHandler() {
    return this.trainFunctionControlHandler;
  }
  
  public void setTrainFunctionControlHandler(final MessageHandler<TrainFunctionControlOrBuilder> trainFunctionControlHandler) {
    this.trainFunctionControlHandler = trainFunctionControlHandler;
  }
  
  @Pure
  protected MessageHandler<TurnoutControlOrBuilder> getTurnoutControlHandler() {
    return this.turnoutControlHandler;
  }
  
  public void setTurnoutControlHandler(final MessageHandler<TurnoutControlOrBuilder> turnoutControlHandler) {
    this.turnoutControlHandler = turnoutControlHandler;
  }
  
  @Pure
  protected MessageHandler<SegmentControlOrBuilder> getSegmentControlHandler() {
    return this.segmentControlHandler;
  }
  
  public void setSegmentControlHandler(final MessageHandler<SegmentControlOrBuilder> segmentControlHandler) {
    this.segmentControlHandler = segmentControlHandler;
  }
}
