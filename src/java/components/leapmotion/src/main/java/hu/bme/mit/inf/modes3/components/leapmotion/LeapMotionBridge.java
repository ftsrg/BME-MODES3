package hu.bme.mit.inf.modes3.components.leapmotion;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.zeromq.ZMQ;
import org.zeromq.ZMQException;

import com.google.protobuf.InvalidProtocolBufferException;

import hu.bme.mit.inf.modes3.components.leapmotion.processor.IGestureProcessor;
import hu.bme.mit.inf.modes3.components.leapmotion.processor.impl.TrainSpeedHandler;
import hu.bme.mit.inf.modes3.messaging.communication.factory.MessagingServiceFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TopicFactory;
import hu.bme.mit.inf.modes3.messaging.communication.factory.TrackCommunicationServiceLocator;
import hu.bme.mit.inf.modes3.messaging.mms.MessagingService;
import hu.bme.mit.inf.modes3.messaging.proto.messages.ComplexGestures.ComplexGesture;
import hu.bme.mit.inf.modes3.utils.common.jopt.ArgumentRegistry;

/**
 * A bridge that translates the gestures, that are detected by another device, for train commands.
 * 
 * @author pappist
 */
public class LeapMotionBridge implements Runnable {

	private MessagingService communicationStack;

	private TrackCommunicationServiceLocator locator;
	
	Logger logger;
	
	private ZMQ.Context context;
	private ZMQ.Socket sub;

	private volatile boolean running;
	
	private Set<IGestureProcessor> processors;
	
	/**
	 * @param registry the command-line arguments of the application
	 * @param loggerFactory the logger factory
	 */
	public LeapMotionBridge(ArgumentRegistry registry, ILoggerFactory loggerFactory) {
		Set<String> unparametrizedTopics = TopicFactory.createEveryUnparametrizedTopic();
		communicationStack = MessagingServiceFactory.createStackForTopics(registry, loggerFactory, unparametrizedTopics);
		locator = new TrackCommunicationServiceLocator(communicationStack, loggerFactory);
		logger = loggerFactory.getLogger(this.getClass().getName());
		
		String leapHost = "";
		
		try {
			leapHost = registry.getParameterStringValue("leaphost");
		} catch (IOException e) {
			leapHost = "127.0.0.1";
		}
		
		processors = new HashSet<IGestureProcessor>();
		
		registerDefaults();
		
		context = ZMQ.context(10);
		sub = context.socket(ZMQ.SUB);

		try {
			sub.bind(String.format("tcp://%s:%d", leapHost, 7071));
		} catch (ZMQException ex) {
			sub.connect(String.format("tcp://%s:%d", leapHost, 7071));
		}
		sub.subscribe("gesturestream".getBytes());

		running = true;
	}
	
	/**
	 * Registers the default event handlers to control the trains.
	 */
	protected void registerDefaults() {
		registerProcessor(new TrainSpeedHandler(locator));
	}
	
	/**
	 * Registers the gesture processor.
	 * 
	 * @param processor to be registered
	 */
	public void registerProcessor(IGestureProcessor processor) {
		this.processors.add(processor);
	}
	
	/**
	 * Translates the detected gestures for train commands.
	 */
	@Override
	public void run() {
		System.out.println("Thread started ...");
		while (running) {
			try {
				String topic = new String(sub.recv());
				byte[] data = sub.recv();
				ComplexGesture gesture = ComplexGesture.parseFrom(data);
				processors.forEach(processor-> {
					processor.process(gesture);
				});
			} catch (InvalidProtocolBufferException e) {
				logger.error("Unable to parse gesture message: " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Stops translating the detected gestures.
	 */
	public void stop() {
		running = false;
	}

}
