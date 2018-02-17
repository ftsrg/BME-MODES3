package hu.bme.mit.gamma.impl.turnout;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutControlInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;

public interface TurnoutStatechartInterface {
	
	ProtocolInterface.Required getProtocolRequiredStraight();
	ProtocolInterface.Required getProtocolRequiredDivergent();
	ProtocolInterface.Provided getProtocolProvidedTop();
	TurnoutControlInterface.Provided getTurnoutControlProvided();
	ProtocolInterface.Required getProtocolRequiredTop();
	TrainInterface.Provided getTrainProvided();
	ProtocolInterface.Provided getProtocolProvidedDivergent();
	ProtocolInterface.Provided getProtocolProvidedStraight();
	
	void runCycle();
	
} 
