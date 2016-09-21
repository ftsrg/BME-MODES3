package hu.bme.mit.inf.modes3.components.safetylogic.sc.network;

import java.util.Arrays;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import com.google.protobuf.GeneratedMessageV3;

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message;
import hu.bme.mit.inf.modes3.messaging.mms.messages.MessageType;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCanGoTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCanGoToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCannotGoTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduCannotGoToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveToOrBuilder;

public class YakinduMessageDispatcher implements IMessageDispatcher {

	protected final Logger logger;

	protected MessageHandler<YakinduReleaseToOrBuilder> releaseToHandler;
	protected MessageHandler<YakinduReserveToOrBuilder> reserveToHandler;
	protected MessageHandler<YakinduCanGoToOrBuilder> canGoToHandler;
	protected MessageHandler<YakinduCannotGoToOrBuilder> cannotGoToHandler;

	public YakinduMessageDispatcher(ILoggerFactory factory) {
		this.logger = factory.getLogger(this.getClass().getName());
	}

	@Override
	public void dispatchMessage(byte[] rawMessage) {
		try {
			Message message = Message.parseFrom(rawMessage);
			switch (message.getType()) {
			case YAKINDU_RELEASE_TO:
				if (releaseToHandler != null) {
					logger.debug(message.getType() + " message forwarded to handler.");
					releaseToHandler.handleMessage(message.getYakinduReleaseTo());
				}
				break;
			case YAKINDU_CAN_GO_TO:
				if (canGoToHandler != null) {
					logger.debug(message.getType() + " message forwarded to handler.");
					canGoToHandler.handleMessage(message.getYakinduCanGoTo());
				}
				break;
			case YAKINDU_CANNOT_GO_TO:
				if (cannotGoToHandler != null) {
					logger.debug(message.getType() + " message forwarded to handler.");
					cannotGoToHandler.handleMessage(message.getYakinduCannotGoTo());
				}
				break;
			case YAKINDU_RESERVE_TO:
				if (reserveToHandler != null) {
					logger.debug(message.getType() + " message forwarded to handler.");
					reserveToHandler.handleMessage(message.getYakinduReserveTo());
				}
				break;
			default:
				return;
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

	@Override
	public byte[] convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			GeneratedMessageV3 _message = (GeneratedMessageV3) message;
			if (_message instanceof YakinduReleaseTo) {
				return internalConvertMessageToRaw((YakinduReleaseTo) _message);
			} else if (_message instanceof YakinduCanGoTo) {
				return internalConvertMessageToRaw((YakinduCanGoTo) _message);
			} else if (_message instanceof YakinduCannotGoTo) {
				return internalConvertMessageToRaw((YakinduCannotGoTo) _message);
			} else if (_message instanceof YakinduReserveTo) {
				return internalConvertMessageToRaw((YakinduReserveTo) _message);
			} else {
				throw new IllegalArgumentException("Unhandled parameter types: " + Arrays.<Object>asList(_message).toString());
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}

	private byte[] internalConvertMessageToRaw(YakinduReleaseTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_RELEASE_TO).setYakinduReleaseTo(_message).build().toByteArray();
	}

	private byte[] internalConvertMessageToRaw(YakinduReserveTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_RESERVE_TO).setYakinduReserveTo(_message).build().toByteArray();
	}

	private byte[] internalConvertMessageToRaw(YakinduCanGoTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_CAN_GO_TO).setYakinduCanGoTo(_message).build().toByteArray();
	}

	private byte[] internalConvertMessageToRaw(YakinduCannotGoTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_CANNOT_GO_TO).setYakinduCannotGoTo(_message).build().toByteArray();
	}

	public void setReleaseToHandler(MessageHandler<YakinduReleaseToOrBuilder> releaseToHandler) {
		this.releaseToHandler = releaseToHandler;
	}

	public void setReserveToHandler(MessageHandler<YakinduReserveToOrBuilder> reserveToHandler) {
		this.reserveToHandler = reserveToHandler;
	}

	public void setCanGoToHandler(MessageHandler<YakinduCanGoToOrBuilder> canGoToHandler) {
		this.canGoToHandler = canGoToHandler;
	}

	public void setCannotGoToHandler(MessageHandler<YakinduCannotGoToOrBuilder> cannotGoToHandler) {
		this.cannotGoToHandler = cannotGoToHandler;
	}

}
