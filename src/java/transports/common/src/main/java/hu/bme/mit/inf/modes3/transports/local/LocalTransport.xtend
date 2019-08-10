package hu.bme.mit.inf.modes3.transports.local

import hu.bme.mit.inf.modes3.transports.common.Transport
import java.util.ArrayList
import java.util.Collections
import java.util.concurrent.LinkedBlockingQueue

/**
 * A synchronized list based in-memory transport layer that maintains the connections within the same JVM.
 * Recommended to be used in tests to remove the dependency of an acutal physical transport layer. 
 * 
 * @author baloghlaszlo
 */
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
