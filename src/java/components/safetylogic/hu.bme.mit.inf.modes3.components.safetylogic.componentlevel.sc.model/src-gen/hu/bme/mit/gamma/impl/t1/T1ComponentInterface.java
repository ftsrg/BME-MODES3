package hu.bme.mit.gamma.impl.t1;

import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface T1ComponentInterface {
	
	TurnoutControlInterface.Provided getT1TurnoutProvided();
	ProtocolInterface.Provided getT1ProtocolProvidedDivergent();
	ProtocolInterface.Required getT1ProtocolRequiredDivergent();
	ProtocolInterface.Provided getS12ProtocolProvidedCCW();
	TrainInterface.Provided getS15TrainProvided();
	SectionControlInterface.Provided getS12ControlProvided();
	ProtocolInterface.Provided getS15ProtocolProvidedCW();
	ProtocolInterface.Required getS12ProtocolRequiredCCW();
	ProtocolInterface.Required getS15ProtocolRequiredCW();
	TrainInterface.Provided getT1TrainProvided();
	TrainInterface.Provided getS12TrainProvided();
	SectionControlInterface.Provided getS15ControlProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
