package hu.bme.mit.inf.modes3.transports.zeromq

import hu.bme.mit.inf.modes3.transports.common.ITransport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.zeromq.ZMQ

class ZMQTransport implements ITransport {
	
	val ctx = ZMQ.context(1)
	var ZMQ.Socket pub
	var ZMQ.Socket sub
	
	override connect() {
		pub = ctx.socket(ZMQ.PUB)
	}
	
	override receiveMessage() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override sendMessage(byte[] message) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}