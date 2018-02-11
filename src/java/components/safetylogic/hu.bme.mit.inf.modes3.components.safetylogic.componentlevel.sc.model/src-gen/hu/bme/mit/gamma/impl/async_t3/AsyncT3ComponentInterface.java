package hu.bme.mit.gamma.impl.async_t3;

import hu.bme.mit.gamma.impl.interfaces.ControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;

public interface AsyncT3ComponentInterface {
	
	ControlInterface.Provided getS19ControlProvided();
	TrainInterface.Required getT3_1TrainRequired();
	ProtocolInterface.Required getS26ProtocolRequiredCCW();
	TrainInterface.Required getS19TrainRequired();
	ProtocolInterface.Provided getS26ProtocolProvidedCCW();
	ProtocolInterface.Provided getS30ProtocolProvidedCCW();
	ProtocolInterface.Required getS19ProtocolRequiredCW();
	ControlInterface.Provided getS20ControlProvided();
	ControlInterface.Provided getS26ControlProvided();
	ControlInterface.Provided getS30ControlProvided();
	TrainInterface.Required getS30TrainRequired();
	ProtocolInterface.Provided getS19ProtocolProvidedCW();
	TrainInterface.Required getS26TrainRequired();
	TurnoutInterface.Provided getT3_2TurnoutProvided();
	ProtocolInterface.Required getS30ProtocolRequiredCCW();
	TrainInterface.Required getS20TrainRequired();
	TrainInterface.Required getT3_2TrainRequired();
	ProtocolInterface.Required getS20ProtocolRequiredCW();
	ProtocolInterface.Provided getS20ProtocolProvidedCW();
	TurnoutInterface.Provided getT3_1TurnoutProvided();
	
	
} 
