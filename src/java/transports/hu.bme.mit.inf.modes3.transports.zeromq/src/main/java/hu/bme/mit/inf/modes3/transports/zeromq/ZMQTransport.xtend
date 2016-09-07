package hu.bme.mit.inf.modes3.transports.zeromq

import hu.bme.mit.inf.modes3.transports.common.Transport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.zeromq.ZMQ

class ZMQTransport extends Transport {

	val ctx = ZMQ.context(1)
	var ZMQ.Socket pub
	var ZMQ.Socket sub
	private var ZMQ.Socket pub_monitor
	private var ZMQ.Socket sub_monitor

	new(TransportConfiguration config) {
		super(config)
	}

	override connect() {
		pub = ctx.socket(ZMQ.PUB)
		pub.bind('''tcp://*:«config.localEndpoint.port»''')
		pub.monitor("inproc://pub.monitor", ZMQ.EVENT_ALL)

		sub = ctx.socket(ZMQ.SUB)
		sub.subscribe(#[])
		sub.monitor('inproc://sub.monitor', ZMQ.EVENT_ALL)

		pub_monitor = ctx.socket(ZMQ.PAIR)
		pub_monitor.connect('inproc://pub.monitor')
		
		sub_monitor = ctx.socket(ZMQ.PAIR)
		sub_monitor.connect('inproc://sub.monitor')

		this.config.allEndpoints.core.filter[endpoint|endpoint != config.localEndpoint].forEach [ endpoint |
			println(''' «config.localEndpoint.addr»:«config.localEndpoint.port» connect to: «endpoint.addr»:«endpoint.port»>''')
			sub.connect('''tcp://«endpoint.addr»:«endpoint.port»''')
		]

		val remoteCoreEndpointCount = config.allEndpoints.core.size - 1

		var pubConnectedCount = 0
		while(remoteCoreEndpointCount != pubConnectedCount) {
			val event = ZMQ.Event.recv(pub_monitor)
			if(event.event.bitwiseAnd(ZMQ.EVENT_ACCEPTED) != 0) {
				pubConnectedCount++;
			}
		}
		
		var subConnectedCount = 0
		while(remoteCoreEndpointCount != subConnectedCount) {
			val event = ZMQ.Event.recv(sub_monitor)
			if(event.event.bitwiseAnd(ZMQ.EVENT_CONNECTED) != 0) {
				subConnectedCount++;
			}
		}
		
		pub_monitor.linger = 0
		pub_monitor.close
		
		sub_monitor.linger = 0
		sub_monitor.close

		println("ZMQ Net is ready")
	}

	override receiveMessage() {
		return sub.recv
	}

	override sendMessage(byte[] message) {
		pub.send(message, 0)
	}

	override close() {
		pub.close
		sub.close

		ctx.term
	}

}
