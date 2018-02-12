package hu.bme.mit.gamma.impl.t6;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface T6ComponentInterface {
	
	ProtocolInterface.Provided getS27ProtocolProvidedCW();
	SectionControlInterface.Provided getS22ControlProvided();
	TrainInterface.Provided getT6TrainProvided();
	TrainInterface.Provided getS22TrainProvided();
	ProtocolInterface.Required getS27ProtocolRequiredCW();
	ProtocolInterface.Provided getS22ProtocolProvidedCW();
	TrainInterface.Provided getS27TrainProvided();
	SectionControlInterface.Provided getS27ControlProvided();
	ProtocolInterface.Required getS17ProtocolRequiredCCW();
	ProtocolInterface.Required getS22ProtocolRequiredCW();
	TurnoutControlInterface.Provided getT6TurnoutProvided();
	SectionControlInterface.Provided getS17ControlProvided();
	ProtocolInterface.Provided getS17ProtocolProvidedCCW();
	TrainInterface.Provided getS17TrainProvided();
	TrainInterface.Provided getS23TrainProvided();
	SectionControlInterface.Provided getS23ControlProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
