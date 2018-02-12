package hu.bme.mit.gamma.impl.async_t2;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface AsyncT2ComponentInterface {
	
	ProtocolInterface.Required getS24ProtocolRequiredCCW();
	ProtocolInterface.Required getT2ProtocolRequiredDivergent();
	ProtocolInterface.Required getS18ProtocolRequiredCW();
	SectionControlInterface.Provided getS24ControlProvided();
	SectionControlInterface.Provided getS29ControlProvided();
	TrainInterface.Provided getS31TrainProvided();
	TurnoutControlInterface.Provided getT2TurnoutProvided();
	TrainInterface.Provided getS18TrainProvided();
	TrainInterface.Provided getS24TrainProvided();
	SectionControlInterface.Provided getS31ControlProvided();
	TrainInterface.Provided getS29TrainProvided();
	ProtocolInterface.Provided getT2ProtocolProvidedDivergent();
	ProtocolInterface.Provided getS24ProtocolProvidedCCW();
	ProtocolInterface.Provided getS18ProtocolProvidedCW();
	SectionControlInterface.Provided getS18ControlProvided();
	TrainInterface.Provided getT2TrainProvided();
	
	
} 
