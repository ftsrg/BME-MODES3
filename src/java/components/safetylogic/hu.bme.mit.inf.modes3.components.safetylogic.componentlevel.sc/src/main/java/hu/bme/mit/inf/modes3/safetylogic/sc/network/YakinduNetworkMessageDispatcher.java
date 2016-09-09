package hu.bme.mit.inf.modes3.safetylogic.sc.network;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.GeneratedMessageV3;

import hu.bme.mit.inf.modes3.messaging.mms.dispatcher.IMessageDispatcher;
import hu.bme.mit.inf.modes3.messaging.mms.handlers.MessageHandler;
import hu.bme.mit.inf.modes3.messaging.mms.messages.Message;
import hu.bme.mit.inf.modes3.messaging.mms.messages.MessageType;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReleaseToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveResultToOrBuilder;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveTo;
import hu.bme.mit.inf.modes3.messaging.mms.messages.YakinduReserveToOrBuilder;

public class YakinduNetworkMessageDispatcher implements IMessageDispatcher {

	private static final Logger logger = LoggerFactory.getLogger(YakinduNetworkMessageDispatcher.class);

	private MessageHandler<YakinduReleaseToOrBuilder> releaseToHandler;
	private MessageHandler<YakinduReserveToOrBuilder> reserveToHandler;
	private MessageHandler<YakinduReserveResultToOrBuilder> reserveResultToHandler;

	public void dispatchMessage(byte[] rawMessage) {
		try {
			Message message = Message.parseFrom(rawMessage);
			switch (message.getType()) {
			case YAKINDU_RELEASE_TO:
				if (releaseToHandler != null)
					releaseToHandler.handleMessage(message.getYakinduReleaseTo());
			case YAKINDU_RESERVE_RESULT_TO:
				if (reserveResultToHandler != null)
					reserveResultToHandler.handleMessage(message.getYakinduReserveResultTo());
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

	public byte[] convertMessageToRaw(Object message) throws IllegalArgumentException {
		try {
			GeneratedMessageV3 _message = (GeneratedMessageV3) message;
			if (_message instanceof YakinduReleaseTo) {
				return internalConvertMessageToRaw((YakinduReleaseTo) _message);
			} else if (_message instanceof YakinduReserveResultTo) {
				return internalConvertMessageToRaw((YakinduReserveResultTo) _message);
			} else if (_message instanceof YakinduReserveTo) {
				return internalConvertMessageToRaw((YakinduReserveTo) _message);
			} else {
				throw new IllegalArgumentException(
						"Unhandled parameter types: " + Arrays.<Object>asList(_message).toString());
			}
		} catch (ClassCastException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}
	}

	public byte[] internalConvertMessageToRaw(YakinduReleaseTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_RELEASE_TO).setYakinduReleaseTo(_message).build()
				.toByteArray();
	}

	public byte[] internalConvertMessageToRaw(YakinduReserveTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_RESERVE_TO).setYakinduReserveTo(_message).build()
				.toByteArray();
	}

	public byte[] internalConvertMessageToRaw(YakinduReserveResultTo _message) {
		return Message.newBuilder().setType(MessageType.YAKINDU_RESERVE_RESULT_TO).setYakinduReserveResultTo(_message)
				.build().toByteArray();
	}

	public void setReleaseToHandler(MessageHandler<YakinduReleaseToOrBuilder> releaseToHandler) {
		this.releaseToHandler = releaseToHandler;
	}

	public void setReserveToHandler(MessageHandler<YakinduReserveToOrBuilder> reserveToHandler) {
		this.reserveToHandler = reserveToHandler;
	}

	public void setReserveResultToHandler(MessageHandler<YakinduReserveResultToOrBuilder> reserveResultToHandler) {
		this.reserveResultToHandler = reserveResultToHandler;
	}

	protected MessageHandler<YakinduReleaseToOrBuilder> getReleaseToHandler() {
		return releaseToHandler;
	}

	protected MessageHandler<YakinduReserveToOrBuilder> getReserveToHandler() {
		return reserveToHandler;
	}

	protected MessageHandler<YakinduReserveResultToOrBuilder> getReserveResultToHandler() {
		return reserveResultToHandler;
	}

}
