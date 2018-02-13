package hu.bme.mit.gamma.impl.t4;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface T4ComponentInterface {
	
	ProtocolInterface.Provided getS07ProtocolProvidedCCW();
	SectionControlInterface.Provided getS02ControlProvided();
	ProtocolInterface.Provided getS06ProtocolProvidedCCW();
	SectionControlInterface.Provided getS01ControlProvided();
	SectionControlInterface.Provided getS06ControlProvided();
	TrainInterface.Provided getT4TrainProvided();
	SectionControlInterface.Provided getS05ControlProvided();
	ProtocolInterface.Required getS07ProtocolRequiredCCW();
	SectionControlInterface.Provided getS04ControlProvided();
	ProtocolInterface.Required getS06ProtocolRequiredCCW();
	TrainInterface.Provided getS04TrainProvided();
	TrainInterface.Provided getS05TrainProvided();
	SectionControlInterface.Provided getS07ControlProvided();
	ProtocolInterface.Required getS01ProtocolRequiredCW();
	TurnoutControlInterface.Provided getT4TurnoutProvided();
	TrainInterface.Provided getS01TrainProvided();
	TrainInterface.Provided getS07TrainProvided();
	TrainInterface.Provided getS06TrainProvided();
	ProtocolInterface.Provided getS01ProtocolProvidedCW();
	TrainInterface.Provided getS02TrainProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
