package hu.bme.mit.gamma.impl.section;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface SectionStatechartInterface {
	
	ProtocolInterface.Required getProtocolRequiredCCW();
	TrainInterface.Provided getTrainProvided();
	SectionControlInterface.Provided getSectionControlProvided();
	ProtocolInterface.Provided getProtocolProvidedCW();
	ProtocolInterface.Required getProtocolRequiredCW();
	ProtocolInterface.Provided getProtocolProvidedCCW();
	
	void runCycle();
	
} 
