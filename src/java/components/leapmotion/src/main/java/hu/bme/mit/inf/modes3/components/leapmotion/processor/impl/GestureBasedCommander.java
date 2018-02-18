package hu.bme.mit.inf.modes3.components.leapmotion.processor.impl;

import hu.bme.mit.inf.modes3.components.leapmotion.processor.IGestureProcessor;
import hu.bme.mit.inf.modes3.messaging.communication.command.train.interfaces.ITrainCommander;

public abstract class GestureBasedCommander implements IGestureProcessor {
	
	protected ITrainCommander commander;
	
	public GestureBasedCommander(ITrainCommander commander) {
		this.commander = commander;
	}
	
}
