package hu.bme.mit.gamma.impl.t1;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.ControlInterface;

public interface T1ComponentInterface {
	
	ProtocolInterface.Provided getS15ProtocolProvidedCW();
	TrainInterface.Required getT1TrainRequired();
	TrainInterface.Required getS15TrainRequired();
	TurnoutInterface.Provided getT1TurnoutProvided();
	ControlInterface.Provided getS15ControlProvided();
	ProtocolInterface.Provided getS12ProtocolProvidedCCW();
	TrainInterface.Required getS12TrainRequired();
	ProtocolInterface.Required getS15ProtocolRequiredCW();
	ProtocolInterface.Required getT1ProtocolRequiredDivergent();
	ProtocolInterface.Provided getT1ProtocolProvidedDivergent();
	ProtocolInterface.Required getS12ProtocolRequiredCCW();
	ControlInterface.Provided getS12ControlProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
