package hu.bme.mit.inf.modes3.components.leapmotion.processor;

import hu.bme.mit.inf.modes3.messaging.proto.messages.ComplexGestures.ComplexGesture;

public interface IGestureProcessor {
	
	public void process(ComplexGesture gesture);
	
}
