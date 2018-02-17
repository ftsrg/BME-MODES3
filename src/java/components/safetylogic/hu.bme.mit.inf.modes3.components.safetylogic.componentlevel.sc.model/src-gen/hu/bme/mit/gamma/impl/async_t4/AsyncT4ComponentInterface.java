package hu.bme.mit.gamma.impl.async_t4;

import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface AsyncT4ComponentInterface {
	
	TrainInterface.Provided getS07TrainProvided();
	ProtocolInterface.Required getS07ProtocolRequiredCCW();
	SectionControlInterface.Provided getS06ControlProvided();
	SectionControlInterface.Provided getS01ControlProvided();
	ProtocolInterface.Required getS01ProtocolRequiredCW();
	ProtocolInterface.Provided getS07ProtocolProvidedCCW();
	ProtocolInterface.Provided getS06ProtocolProvidedCCW();
	TrainInterface.Provided getS04TrainProvided();
	TrainInterface.Provided getT4TrainProvided();
	ProtocolInterface.Provided getS01ProtocolProvidedCW();
	SectionControlInterface.Provided getS02ControlProvided();
	SectionControlInterface.Provided getS07ControlProvided();
	ProtocolInterface.Required getS06ProtocolRequiredCCW();
	SectionControlInterface.Provided getS05ControlProvided();
	TrainInterface.Provided getS06TrainProvided();
	TurnoutControlInterface.Provided getT4TurnoutProvided();
	TrainInterface.Provided getS01TrainProvided();
	TrainInterface.Provided getS02TrainProvided();
	SectionControlInterface.Provided getS04ControlProvided();
	TrainInterface.Provided getS05TrainProvided();
	
	
} 
