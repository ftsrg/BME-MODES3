package hu.bme.mit.gamma.impl.section;

import hu.bme.mit.gamma.impl.interfaces.ControlInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;

public interface SectionStatechartInterface {
	
	ControlInterface.Provided getControlProvided();
	ProtocolInterface.Provided getProtocolProvidedCCW();
	TrainInterface.Required getTrainRequired();
	ProtocolInterface.Provided getProtocolProvidedCW();
	ProtocolInterface.Required getProtocolRequiredCCW();
	ProtocolInterface.Required getProtocolRequiredCW();
	
	void runCycle();
	
} 
