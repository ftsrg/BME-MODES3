package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationServiceLocator
import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack

abstract class AbstractComponent {
	//TODO logger for the AbstractComponent
	protected val CommunicationServiceLocator communication
	
	new(){
		communication = new CommunicationServiceLocator(new CommunicationStack())
	}
	
	new(CommunicationStack stack){
		communication = new CommunicationServiceLocator(stack)
	}
	

}