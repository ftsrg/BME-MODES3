package hu.bme.mit.gamma.impl.async_t2;

import hu.bme.mit.gamma.impl.interfaces.TrainInterface;
import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.SectionControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;

public interface AsyncT2ComponentInterface {
	
	TrainInterface.Provided getS29TrainProvided();
	ProtocolInterface.Required getT2ProtocolRequiredDivergent();
	ProtocolInterface.Provided getS24ProtocolProvidedCCW();
	TrainInterface.Provided getT2TrainProvided();
	SectionControlInterface.Provided getS29ControlProvided();
	TrainInterface.Provided getS24TrainProvided();
	TrainInterface.Provided getS31TrainProvided();
	SectionControlInterface.Provided getS18ControlProvided();
	ProtocolInterface.Provided getT2ProtocolProvidedDivergent();
	SectionControlInterface.Provided getS31ControlProvided();
	SectionControlInterface.Provided getS24ControlProvided();
	ProtocolInterface.Required getS24ProtocolRequiredCCW();
	TurnoutControlInterface.Provided getT2TurnoutProvided();
	ProtocolInterface.Provided getS18ProtocolProvidedCW();
	TrainInterface.Provided getS18TrainProvided();
	ProtocolInterface.Required getS18ProtocolRequiredCW();
	
	
} 
