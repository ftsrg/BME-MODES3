package hu.bme.mit.gamma.impl.turnout;

import hu.bme.mit.gamma.impl.interfaces.ProtocolInterface;
import hu.bme.mit.gamma.impl.interfaces.TurnoutInterface;
import hu.bme.mit.gamma.impl.interfaces.TrainInterface;

public interface TurnoutStatechartInterface {
	
	ProtocolInterface.Provided getProtocolProvidedTop();
	TurnoutInterface.Provided getTurnout();
	ProtocolInterface.Required getProtocolRequiredDivergent();
	ProtocolInterface.Provided getProtocolProvidedStraight();
	ProtocolInterface.Required getProtocolRequiredTop();
	TrainInterface.Required getTrainRequired();
	ProtocolInterface.Provided getProtocolProvidedDivergent();
	ProtocolInterface.Required getProtocolRequiredStraight();
	
	void runCycle();
	
} 
