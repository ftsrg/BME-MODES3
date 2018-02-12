package hu.bme.mit.gamma.impl.turnout;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;

public interface TurnoutStatechartInterface {
	
	ProtocolInterface.Provided getProtocolProvidedTop();
	ProtocolInterface.Provided getProtocolProvidedStraight();
	ProtocolInterface.Required getProtocolRequiredStraight();
	ProtocolInterface.Required getProtocolRequiredTop();
	TurnoutControlInterface.Provided getTurnoutControlProvided();
	ProtocolInterface.Provided getProtocolProvidedDivergent();
	ProtocolInterface.Required getProtocolRequiredDivergent();
	TrainInterface.Provided getTrainProvided();
	
	void runCycle();
	
} 
