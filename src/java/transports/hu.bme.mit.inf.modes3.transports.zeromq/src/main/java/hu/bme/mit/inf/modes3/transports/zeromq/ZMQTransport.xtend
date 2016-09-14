package hu.bme.mit.inf.modes3.transports.zeromq

import hu.bme.mit.inf.modes3.transports.common.Transport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.zeromq.ZMQ

class ZMQTransport extends Transport {

	var ZMQ.Context ctx
	var ZMQ.Socket pub
	var ZMQ.Socket sub

	new(TransportConfiguration config) {
		super(config)
	}

	override connect() {
		ctx = ZMQ.context(1);

		pub = ctx.socket(ZMQ.PUB)
		pub.bind('''tcp://*:«config.localEndpoint.pubPort»''')

		val repThread = new Thread(new Runnable {
			override run() {
				val rep = ctx.socket(ZMQ.REP);
				rep.bind('''tcp://*:«config.localEndpoint.repPort»''')
				var endpointCount = config.allEndpoints.core.size - 1
				while(endpointCount > 0) {
					rep.recv()
					rep.send(#[])

					endpointCount--;
				}
				rep.close
			}
		})
		repThread.start

		sub = ctx.socket(ZMQ.SUB)
		this.config.allEndpoints.core.filter[endpoint | endpoint != config.localEndpoint].forEach [ endpoint |
			sub.subscribe(#[])
			sub.connect('''tcp://«endpoint.addr»:«endpoint.pubPort»''')
			
			val req = ctx.socket(ZMQ.REQ);
			println('''Connecting to SYN: «endpoint.addr»:«endpoint.repPort»''')
			req.connect('''tcp://«endpoint.addr»:«endpoint.repPort»''')
			req.send(#[])
			req.recv
			req.close
		]
		
		repThread.join

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
