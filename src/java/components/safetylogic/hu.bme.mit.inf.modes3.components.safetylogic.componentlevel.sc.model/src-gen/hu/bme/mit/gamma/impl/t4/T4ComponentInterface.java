package hu.bme.mit.gamma.impl.t4;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface T4ComponentInterface {
	
	ProtocolInterface.Provided getS01ProtocolProvidedCW();
	SectionControlInterface.Provided getS04ControlProvided();
	TrainInterface.Provided getS07TrainProvided();
	ProtocolInterface.Required getS07ProtocolRequiredCCW();
	TrainInterface.Provided getS06TrainProvided();
	SectionControlInterface.Provided getS06ControlProvided();
	SectionControlInterface.Provided getS07ControlProvided();
	SectionControlInterface.Provided getS05ControlProvided();
	TrainInterface.Provided getS05TrainProvided();
	ProtocolInterface.Provided getS06ProtocolProvidedCCW();
	TrainInterface.Provided getS04TrainProvided();
	ProtocolInterface.Required getS01ProtocolRequiredCW();
	ProtocolInterface.Required getS06ProtocolRequiredCCW();
	TrainInterface.Provided getT4TrainProvided();
	ProtocolInterface.Provided getS07ProtocolProvidedCCW();
	SectionControlInterface.Provided getS01ControlProvided();
	TurnoutControlInterface.Provided getT4TurnoutProvided();
	TrainInterface.Provided getS01TrainProvided();
	
	void runCycle();
	void runFullCycle();
	
} 
