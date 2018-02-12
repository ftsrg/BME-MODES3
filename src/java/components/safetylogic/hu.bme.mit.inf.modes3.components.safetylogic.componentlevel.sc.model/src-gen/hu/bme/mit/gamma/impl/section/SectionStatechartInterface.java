package hu.bme.mit.gamma.impl.section;

import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface SectionStatechartInterface {
	
	TrainInterface.Provided getTrainProvided();
	ProtocolInterface.Provided getProtocolProvidedCCW();
	ProtocolInterface.Required getProtocolRequiredCW();
	ProtocolInterface.Provided getProtocolProvidedCW();
	SectionControlInterface.Provided getSectionControlProvided();
	ProtocolInterface.Required getProtocolRequiredCCW();
	
	void runCycle();
	
} 
