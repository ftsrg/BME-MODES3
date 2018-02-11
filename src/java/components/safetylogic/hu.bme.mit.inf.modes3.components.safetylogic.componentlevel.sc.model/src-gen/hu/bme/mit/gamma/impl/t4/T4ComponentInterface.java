package hu.bme.mit.gamma.impl.t4;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ControlInterface;

public interface T4ComponentInterface {
	
	ProtocolInterface.Required getS01ProtocolRequiredCW();
	TurnoutInterface.Provided getT4TurnoutProvided();
	ProtocolInterface.Required getS06ProtocolRequiredCCW();
	TrainInterface.Required getT4TrainRequired();
	TrainInterface.Required getS01TrainRequired();
	ProtocolInterface.Provided getS07ProtocolProvidedCCW();
	ControlInterface.Provided getS05ControlProvided();
	TrainInterface.Required getS06TrainRequired();
	ControlInterface.Provided getS04ControlProvided();
	TrainInterface.Required getS07TrainRequired();
	ControlInterface.Provided getS01ControlProvided();
	ProtocolInterface.Required getS07ProtocolRequiredCCW();
	ProtocolInterface.Provided getS01ProtocolProvidedCW();
	TrainInterface.Required getS04TrainRequired();
	ProtocolInterface.Provided getS06ProtocolProvidedCCW();
	ControlInterface.Provided getS06ControlProvided();
	ControlInterface.Provided getS07ControlProvided();
	TrainInterface.Required getS05TrainRequired();
	
	void runCycle();
	void runFullCycle();
	
} 
