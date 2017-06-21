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

		sub = ctx.socket(ZMQ.SUB)
		sub.subscribe(#[])
		this.config.allEndpoints.core.filter[endpoint | endpoint != config.localEndpoint].forEach [ endpoint |
			sub.connect('''tcp://«endpoint.addr»:«endpoint.pubPort»''')
		]
		
		Thread.sleep(250)

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
