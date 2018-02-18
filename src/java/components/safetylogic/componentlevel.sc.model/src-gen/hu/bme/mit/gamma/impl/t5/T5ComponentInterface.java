package hu.bme.mit.gamma.impl.t5;

import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface T5ComponentInterface {
	
	TrainInterface.Provided getS11TrainProvided();
	ProtocolInterface.Provided getS11ProtocolProvidedCW();
	TurnoutControlInterface.Provided getT5TurnoutProvided();
	TrainInterface.Provided getS08TrainProvided();
	TrainInterface.Provided getT5TrainProvided();
	ProtocolInterface.Provided getS10ProtocolProvidedCW();
	ProtocolInterface.Provided getS13ProtocolProvidedCCW();
	ProtocolInterface.Required getS11ProtocolRequiredCW();
	SectionControlInterface.Provided getS13ControlProvided();
	SectionControlInterface.Provided getS08ControlProvided();
	ProtocolInterface.Required getS10ProtocolRequiredCW();
	ProtocolInterface.Required getS13ProtocolRequiredCCW();
	SectionControlInterface.Provided getS11ControlProvided();
	SectionControlInterface.Provided getS10ControlProvided();
	TrainInterface.Provided getS10TrainProvided();
	TrainInterface.Provided getS13TrainProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
