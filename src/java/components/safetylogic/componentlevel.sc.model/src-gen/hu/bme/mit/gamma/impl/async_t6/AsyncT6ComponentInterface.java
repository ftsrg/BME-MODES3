package hu.bme.mit.gamma.impl.async_t6;

import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface AsyncT6ComponentInterface {
	
	TrainInterface.Provided getS17TrainProvided();
	ProtocolInterface.Provided getS27ProtocolProvidedCW();
	TrainInterface.Provided getS23TrainProvided();
	SectionControlInterface.Provided getS23ControlProvided();
	TrainInterface.Provided getS22TrainProvided();
	ProtocolInterface.Required getS17ProtocolRequiredCCW();
	ProtocolInterface.Required getS27ProtocolRequiredCW();
	TrainInterface.Provided getS27TrainProvided();
	ProtocolInterface.Provided getS17ProtocolProvidedCCW();
	ProtocolInterface.Provided getS22ProtocolProvidedCW();
	SectionControlInterface.Provided getS22ControlProvided();
	TurnoutControlInterface.Provided getT6TurnoutProvided();
	SectionControlInterface.Provided getS27ControlProvided();
	ProtocolInterface.Required getS22ProtocolRequiredCW();
	TrainInterface.Provided getT6TrainProvided();
	SectionControlInterface.Provided getS17ControlProvided();
	
	
} 
