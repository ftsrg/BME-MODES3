package hu.bme.mit.inf.modes3.transports.zeromq

import hu.bme.mit.inf.modes3.transports.common.Transport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.zeromq.ZMQ

class ZMQTransport extends Transport {
	
	val ctx = ZMQ.context(1)
	var ZMQ.Socket pub
	var ZMQ.Socket sub
	
	new(TransportConfiguration config) {
		super(config)
	}
	
	override connect() {
		pub = ctx.socket(ZMQ.PUB)
		pub.bind('''tcp://*:«this.config.localEndpoint.port»''')
		
		sub = ctx.socket(ZMQ.SUB)
		sub.monitor("inproc://sub.monitor", ZMQ.EVENT_ALL)
		
		val monitor = ctx.socket(ZMQ.PAIR)
		monitor.connect('inproc://sub.monitor')

		this.config.allEndpoints.core.keySet.forEach[unit |
			this.config.allEndpoints.core.get(unit).forEach[endpoint |
				sub.connect('''tcp://«unit»:«endpoint.port»''')
			]
		]
		
		
		var remoteCoreEndpointCount = config.allEndpoints.core.values.fold(0, [count, next | count + next.size]) - 1
		
		while(remoteCoreEndpointCount != 0) {
			val event = ZMQ.Event.recv(monitor)
			println(event.address + ' ' + event.event + ' ' + event.value)
			if (event.event.bitwiseAnd(ZMQ.EVENT_CONNECTED) != 0) {
				remoteCoreEndpointCount--
			}
		}
		
		println("ZMQ Net is ready")
	}
	
	override receiveMessage() {
		return sub.recv
	}
	
	override sendMessage(byte[] message) {
		pub.send(message, 0)
	}
	
}