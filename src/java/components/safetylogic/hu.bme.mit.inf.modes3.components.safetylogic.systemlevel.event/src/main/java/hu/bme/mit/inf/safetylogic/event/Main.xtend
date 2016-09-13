package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.modes3.messaging.communication.factory.CommunicationStack

class Main {	

	public static def void main(String[] args) {
		val sl = new SafetyLogic(CommunicationStack::createProtobufStack)
		sl.run(); //The component will run on the main thread
	}

}
