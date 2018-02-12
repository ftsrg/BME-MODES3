package hu.bme.mit.gamma.impl.async_t3;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface AsyncT3ComponentInterface {
	
	ProtocolInterface.Provided getS19ProtocolProvidedCW();
	ProtocolInterface.Required getS26ProtocolRequiredCCW();
	TrainInterface.Provided getS26TrainProvided();
	TrainInterface.Provided getT3_1TrainProvided();
	ProtocolInterface.Provided getS30ProtocolProvidedCCW();
	TurnoutControlInterface.Provided getT3_1TurnoutProvided();
	ProtocolInterface.Provided getS20ProtocolProvidedCW();
	ProtocolInterface.Required getS30ProtocolRequiredCCW();
	SectionControlInterface.Provided getS26ControlProvided();
	ProtocolInterface.Provided getS26ProtocolProvidedCCW();
	TrainInterface.Provided getS19TrainProvided();
	SectionControlInterface.Provided getS20ControlProvided();
	SectionControlInterface.Provided getS19ControlProvided();
	TrainInterface.Provided getT3_2TrainProvided();
	TurnoutControlInterface.Provided getT3_2TurnoutProvided();
	TrainInterface.Provided getS20TrainProvided();
	ProtocolInterface.Required getS20ProtocolRequiredCW();
	ProtocolInterface.Required getS19ProtocolRequiredCW();
	TrainInterface.Provided getS30TrainProvided();
	SectionControlInterface.Provided getS30ControlProvided();
	
	
} 
