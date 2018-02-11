package hu.bme.mit.gamma.impl.t5;

import hu.bme.mit.gamma.impl.interfaces.ControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;

public interface T5ComponentInterface {
	
	ControlInterface.Provided getS10ControlProvided();
	TrainInterface.Required getT5TrainRequired();
	TurnoutInterface.Provided getT5TurnoutProvided();
	ProtocolInterface.Provided getS13ProtocolProvidedCCW();
	TrainInterface.Required getS11TrainRequired();
	ProtocolInterface.Required getS13ProtocolRequiredCCW();
	ControlInterface.Provided getS11ControlProvided();
	TrainInterface.Required getS13TrainRequired();
	ProtocolInterface.Provided getS11ProtocolProvidedCW();
	ProtocolInterface.Required getS11ProtocolRequiredCW();
	ControlInterface.Provided getS08ControlProvided();
	ProtocolInterface.Required getS10ProtocolRequiredCW();
	TrainInterface.Required getS10TrainRequired();
	ProtocolInterface.Provided getS10ProtocolProvidedCW();
	ControlInterface.Provided getS13ControlProvided();
	TrainInterface.Required getS08TrainRequired();
	
	void runCycle();
	void runFullCycle();
	
} 
