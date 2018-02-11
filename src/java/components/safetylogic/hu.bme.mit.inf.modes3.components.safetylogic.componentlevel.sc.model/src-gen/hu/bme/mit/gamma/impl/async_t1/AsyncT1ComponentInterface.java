package hu.bme.mit.gamma.impl.async_t1;

import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.ControlInterface;

public interface AsyncT1ComponentInterface {
	
	TrainInterface.Required getT1TrainRequired();
	ProtocolInterface.Provided getS15ProtocolProvidedCW();
	TrainInterface.Required getS15TrainRequired();
	TurnoutInterface.Provided getT1TurnoutProvided();
	ControlInterface.Provided getS15ControlProvided();
	TrainInterface.Required getS12TrainRequired();
	ProtocolInterface.Provided getS12ProtocolProvidedCCW();
	ProtocolInterface.Required getS15ProtocolRequiredCW();
	ProtocolInterface.Required getT1ProtocolRequiredDivergent();
	ProtocolInterface.Required getS12ProtocolRequiredCCW();
	ProtocolInterface.Provided getT1ProtocolProvidedDivergent();
	ControlInterface.Provided getS12ControlProvided();
	
	
} 
