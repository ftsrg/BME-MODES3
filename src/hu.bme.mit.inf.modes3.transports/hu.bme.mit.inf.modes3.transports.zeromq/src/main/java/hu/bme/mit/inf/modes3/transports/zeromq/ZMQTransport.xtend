package hu.bme.mit.inf.modes3.transports.zeromq

import hu.bme.mit.inf.modes3.transports.common.Transport

class ZMQTransport extends Transport {
	
	override byte[] receiveMessage() {
		
	}
	
	override connect() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override sendMessage(byte[] message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}