package hu.bme.mit.inf.modes3.components.leapmotion.processor.impl;

import hu.bme.mit.inf.modes3.components.leapmotion.processor.IGestureProcessor;
import hu.bme.mit.inf.modes3.messaging.communication.command.interfaces.ITrackElementCommander;

public abstract class GestureBasedCommander implements IGestureProcessor {
	
	protected ITrackElementCommander commander;
	
	public GestureBasedCommander(ITrackElementCommander commander) {
		this.commander = commander;
	}
	
}
