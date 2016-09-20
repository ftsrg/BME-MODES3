package hu.bme.mit.inf.modes3.components.safetylogic.sc.network;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

	private static final Logger logger = LoggerFactory.getLogger(YakinduMessageDispatcher.class);

	protected MessageHandler<YakinduReleaseToOrBuilder> releaseToHandler;
	protected MessageHandler<YakinduReserveToOrBuilder> reserveToHandler;
	protected MessageHandler<YakinduCanGoToOrBuilder> canGoToHandler;
	protected MessageHandler<YakinduCannotGoToOrBuilder> cannotGoToHandler;

	@Override
	public void dispatchMessage(byte[] rawMessage) {
		try {
			Message message = Message.parseFrom(rawMessage);
			switch (message.getType()) {
			case YAKINDU_RELEASE_TO:
				if (releaseToHandler != null)
					releaseToHandler.handleMessage(message.getYakinduReleaseTo());
			case YAKINDU_CAN_GO_TO:
				if (canGoToHandler != null)
					canGoToHandler.handleMessage(message.getYakinduCanGoTo());
			case YAKINDU_CANNOT_GO_TO:
				if (cannotGoToHandler != null)
					cannotGoToHandler.handleMessage(message.getYakinduCannotGoTo());
			case YAKINDU_RESERVE_TO:
				if (reserveToHandler != null)
					reserveToHandler.handleMessage(message.getYakinduReserveTo());
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
