package hu.bme.mit.inf.modes3.components.common

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationServiceLocator

abstract class AbstractComponent {
	//TODO logger
	protected val communication = new CommunicationServiceLocator
	

}