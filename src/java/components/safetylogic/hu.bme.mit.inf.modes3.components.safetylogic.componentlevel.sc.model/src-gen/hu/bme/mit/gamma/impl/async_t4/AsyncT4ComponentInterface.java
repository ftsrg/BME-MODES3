package hu.bme.mit.gamma.impl.async_t4;

import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ControlInterface;

public interface AsyncT4ComponentInterface {
	
	TurnoutInterface.Provided getT4TurnoutProvided();
	ProtocolInterface.Required getS01ProtocolRequiredCW();
	TrainInterface.Required getT4TrainRequired();
	ProtocolInterface.Required getS06ProtocolRequiredCCW();
	TrainInterface.Required getS01TrainRequired();
	ProtocolInterface.Provided getS07ProtocolProvidedCCW();
	ControlInterface.Provided getS05ControlProvided();
	TrainInterface.Required getS06TrainRequired();
	ControlInterface.Provided getS04ControlProvided();
	TrainInterface.Required getS07TrainRequired();
	ControlInterface.Provided getS01ControlProvided();
	ProtocolInterface.Required getS07ProtocolRequiredCCW();
	TrainInterface.Required getS04TrainRequired();
	ProtocolInterface.Provided getS01ProtocolProvidedCW();
	ProtocolInterface.Provided getS06ProtocolProvidedCCW();
	ControlInterface.Provided getS07ControlProvided();
	ControlInterface.Provided getS06ControlProvided();
	TrainInterface.Required getS05TrainRequired();
	
	
} 
