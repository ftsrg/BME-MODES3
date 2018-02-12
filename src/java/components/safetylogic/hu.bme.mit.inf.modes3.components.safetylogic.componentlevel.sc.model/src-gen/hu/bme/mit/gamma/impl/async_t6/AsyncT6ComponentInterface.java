package hu.bme.mit.gamma.impl.async_t6;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface AsyncT6ComponentInterface {
	
	ProtocolInterface.Provided getS27ProtocolProvidedCW();
	SectionControlInterface.Provided getS22ControlProvided();
	TrainInterface.Provided getS22TrainProvided();
	TrainInterface.Provided getT6TrainProvided();
	ProtocolInterface.Required getS27ProtocolRequiredCW();
	ProtocolInterface.Provided getS22ProtocolProvidedCW();
	TrainInterface.Provided getS27TrainProvided();
	SectionControlInterface.Provided getS27ControlProvided();
	ProtocolInterface.Required getS17ProtocolRequiredCCW();
	TurnoutControlInterface.Provided getT6TurnoutProvided();
	ProtocolInterface.Required getS22ProtocolRequiredCW();
	SectionControlInterface.Provided getS17ControlProvided();
	TrainInterface.Provided getS17TrainProvided();
	ProtocolInterface.Provided getS17ProtocolProvidedCCW();
	TrainInterface.Provided getS23TrainProvided();
	SectionControlInterface.Provided getS23ControlProvided();
	
	
} 
