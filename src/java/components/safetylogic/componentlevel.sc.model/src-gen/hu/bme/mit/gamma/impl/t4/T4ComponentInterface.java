package hu.bme.mit.gamma.impl.t4;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface T4ComponentInterface {
	
	ProtocolInterface.Required getS07ProtocolRequiredCCW();
	TrainInterface.Provided getS07TrainProvided();
	SectionControlInterface.Provided getS01ControlProvided();
	SectionControlInterface.Provided getS06ControlProvided();
	ProtocolInterface.Required getS01ProtocolRequiredCW();
	ProtocolInterface.Provided getS07ProtocolProvidedCCW();
	ProtocolInterface.Provided getS06ProtocolProvidedCCW();
	TrainInterface.Provided getS04TrainProvided();
	ProtocolInterface.Provided getS01ProtocolProvidedCW();
	TrainInterface.Provided getT4TrainProvided();
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
	
	void runCycle();
	void runFullCycle();
	
} 
