package hu.bme.mit.gamma.impl.t5;

import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface T5ComponentInterface {
	
	SectionControlInterface.Provided getS08ControlProvided();
	TrainInterface.Provided getT5TrainProvided();
	ProtocolInterface.Required getS11ProtocolRequiredCW();
	TrainInterface.Provided getS10TrainProvided();
	ProtocolInterface.Provided getS13ProtocolProvidedCCW();
	SectionControlInterface.Provided getS11ControlProvided();
	TrainInterface.Provided getS13TrainProvided();
	TurnoutControlInterface.Provided getT5TurnoutProvided();
	SectionControlInterface.Provided getS13ControlProvided();
	TrainInterface.Provided getS11TrainProvided();
	ProtocolInterface.Required getS13ProtocolRequiredCCW();
	SectionControlInterface.Provided getS10ControlProvided();
	ProtocolInterface.Required getS10ProtocolRequiredCW();
	TrainInterface.Provided getS08TrainProvided();
	ProtocolInterface.Provided getS11ProtocolProvidedCW();
	ProtocolInterface.Provided getS10ProtocolProvidedCW();
	
	void runCycle();
	void runFullCycle();
	
} 
