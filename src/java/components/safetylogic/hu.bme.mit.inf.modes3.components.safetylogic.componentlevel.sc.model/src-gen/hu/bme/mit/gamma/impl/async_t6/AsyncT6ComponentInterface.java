package hu.bme.mit.gamma.impl.async_t6;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;

public interface AsyncT6ComponentInterface {
	
	ProtocolInterface.Required getS17ProtocolRequiredCCW();
	TrainInterface.Required getS17TrainRequired();
	ControlInterface.Provided getS27ControlProvided();
	ControlInterface.Provided getS22ControlProvided();
	ProtocolInterface.Required getS27ProtocolRequiredCW();
	ProtocolInterface.Required getS22ProtocolRequiredCW();
	ProtocolInterface.Provided getS22ProtocolProvidedCW();
	TrainInterface.Required getS22TrainRequired();
	TurnoutInterface.Provided getT6TurnoutProvided();
	TrainInterface.Required getT6TrainRequired();
	TrainInterface.Required getS27TrainRequired();
	ProtocolInterface.Provided getS27ProtocolProvidedCW();
	ProtocolInterface.Provided getS17ProtocolProvidedCCW();
	ControlInterface.Provided getS23ControlProvided();
	ControlInterface.Provided getS17ControlProvided();
	TrainInterface.Required getS23TrainRequired();
	
	
} 
