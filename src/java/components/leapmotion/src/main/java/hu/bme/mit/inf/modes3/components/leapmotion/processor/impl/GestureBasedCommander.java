package hu.bme.mit.inf.modes3.components.leapmotion.processor.impl;

import hu.bme.mit.inf.modes3.components.leapmotion.processor.IGestureProcessor;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;

/**
 * A commander that sends commands to the trains.
 * 
 * @author pappist
 */
public abstract class GestureBasedCommander implements IGestureProcessor {
	
	protected ITrainCommander commander;
	
	/**
	 * @param commander to sends commands to the trains
	 */
	public GestureBasedCommander(ITrainCommander commander) {
		this.commander = commander;
	}
	
}
