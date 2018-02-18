package hu.bme.mit.gamma.impl.t3;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;

public interface T3ComponentInterface {
	
	ProtocolInterface.Provided getS30ProtocolProvidedCCW();
	TurnoutControlInterface.Provided getT3_1TurnoutProvided();
	TrainInterface.Provided getT3_1TrainProvided();
	SectionControlInterface.Provided getS19ControlProvided();
	ProtocolInterface.Provided getS19ProtocolProvidedCW();
	ProtocolInterface.Required getS19ProtocolRequiredCW();
	ProtocolInterface.Required getS26ProtocolRequiredCCW();
	ProtocolInterface.Required getS30ProtocolRequiredCCW();
	TrainInterface.Provided getS26TrainProvided();
	TrainInterface.Provided getT3_2TrainProvided();
	SectionControlInterface.Provided getS26ControlProvided();
	ProtocolInterface.Provided getS20ProtocolProvidedCW();
	TrainInterface.Provided getS30TrainProvided();
	SectionControlInterface.Provided getS20ControlProvided();
	TrainInterface.Provided getS20TrainProvided();
	TrainInterface.Provided getS19TrainProvided();
	TurnoutControlInterface.Provided getT3_2TurnoutProvided();
	SectionControlInterface.Provided getS30ControlProvided();
	ProtocolInterface.Required getS20ProtocolRequiredCW();
	ProtocolInterface.Provided getS26ProtocolProvidedCCW();
	
	void runCycle();
	void runFullCycle();
	
} 
