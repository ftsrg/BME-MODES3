package hu.bme.mit.inf.modes3.components.leapmotion.processor;

import hu.bme.mit.inf.modes3.messaging.proto.messages.ComplexGestures.ComplexGesture;

/**
 * A processor to consume the detected gestures.
 * 
 * @author pappist
 */
public interface IGestureProcessor {
	
	/**
	 * Process the detected gestures.
	 * 
	 * @param gesture the detected gesture
	 */
	public void process(ComplexGesture gesture);
	
}
