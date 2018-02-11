package hu.bme.mit.gamma.impl.t2;

import hu.bme.mit.gamma.impl.interfaces.ControlInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;

public interface T2ComponentInterface {
	
	ControlInterface.Provided getS24ControlProvided();
	ProtocolInterface.Required getS18ProtocolRequiredCW();
	TurnoutInterface.Provided getT2TurnoutProvided();
	TrainInterface.Required getT2TrainRequired();
	TrainInterface.Required getS31TrainRequired();
	TrainInterface.Required getS18TrainRequired();
	ProtocolInterface.Provided getS18ProtocolProvidedCW();
	ProtocolInterface.Required getT2ProtocolRequiredDivergent();
	ControlInterface.Provided getS31ControlProvided();
	ProtocolInterface.Provided getT2ProtocolProvidedDivergent();
	ControlInterface.Provided getS29ControlProvided();
	TrainInterface.Required getS24TrainRequired();
	ProtocolInterface.Provided getS24ProtocolProvidedCCW();
	ProtocolInterface.Required getS24ProtocolRequiredCCW();
	TrainInterface.Required getS29TrainRequired();
	ControlInterface.Provided getS18ControlProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
