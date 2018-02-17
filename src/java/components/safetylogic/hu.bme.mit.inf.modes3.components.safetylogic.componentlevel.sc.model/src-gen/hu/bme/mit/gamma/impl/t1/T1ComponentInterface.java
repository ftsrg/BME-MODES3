package hu.bme.mit.gamma.impl.t1;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface T1ComponentInterface {
	
	ProtocolInterface.Required getS12ProtocolRequiredCCW();
	TrainInterface.Provided getS12TrainProvided();
	TurnoutControlInterface.Provided getT1TurnoutProvided();
	ProtocolInterface.Provided getT1ProtocolProvidedDivergent();
	ProtocolInterface.Provided getS12ProtocolProvidedCCW();
	SectionControlInterface.Provided getS15ControlProvided();
	TrainInterface.Provided getS15TrainProvided();
	ProtocolInterface.Provided getS15ProtocolProvidedCW();
	ProtocolInterface.Required getT1ProtocolRequiredDivergent();
	SectionControlInterface.Provided getS12ControlProvided();
	ProtocolInterface.Required getS15ProtocolRequiredCW();
	TrainInterface.Provided getT1TrainProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
