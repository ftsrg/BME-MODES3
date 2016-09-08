package hu.bme.mit.inf.modes3.transports.common

import java.util.ArrayList
import java.util.Collections
import java.util.concurrent.LinkedBlockingQueue

class LocalTransport extends Transport {
	val static subscribers = Collections.synchronizedList(new ArrayList<LocalTransport>) 
	val protected msgs = new LinkedBlockingQueue<byte[]> 
	
	new() {
		super(null)
	}
	
	override connect() {
		subscribers.add(this)
	}
	
	override receiveMessage() {
		msgs.take
	}
	
	override sendMessage(byte[] message) {
		subscribers.forEach[
			msgs.add(message)
		]
	}
	
	override close() {
		subscribers.remove(this)
	}
	
}