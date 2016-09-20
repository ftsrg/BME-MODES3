package hu.bme.mit.inf.modes3.transports.zeromq

import hu.bme.mit.inf.modes3.transports.common.Transport
import hu.bme.mit.inf.modes3.transports.config.TransportConfiguration
import org.zeromq.ZMQ

class ZMQTransport extends Transport {

	/** The context which manage, and create all of the sockets */
	var ZMQ.Context ctx
	
	/** 
	 * The publisher socket which is used to send message to 
	 * all subscribed endpoints.
	 */
	var ZMQ.Socket pub
	
	/** 
	 * The subscriber socket which is used to receive message from 
	 * all subscribed endpoints.
	 */
	var ZMQ.Socket sub

	new(TransportConfiguration config) {
		super(config)
	}

	/**
	 * Connect to the endpoints 
	 */
	override connect() {
		ctx = ZMQ.context(2);

		pub = ctx.socket(ZMQ.PUB)
		pub.bind('''tcp://*:«config.localEndpoint.pubPort»''')

		sub = ctx.socket(ZMQ.SUB)
		sub.subscribe(#[])
		this.config.allEndpoints.core.filter[endpoint | endpoint != config.localEndpoint].forEach [ endpoint |
			sub.connect('''tcp://«endpoint.addr»:«endpoint.pubPort»''')
		]
		
		/* 
		 * This sleep in needed, because all the subscribed endpoints need to
		 * send a filter message to the publisher side, notifying the publisher
		 * which messages the subsriber needs.
		 * 
		 * For further info, please refer to:
		 * http://zguide.zeromq.org/page:all#Getting-the-Message-Out 
		 */
		Thread.sleep(250)
		println("ZMQ Net is ready")
	}

	/**
	 * Receive a message from any publisher.
	 * 
	 * This call will block, until a message is received.
	 */
	override receiveMessage() {
		return sub.recv
	}

	/**
	 * Send a message to all subsriber.
	 * 
	 * Broadcasts a message to all subsriber. This call will return immediately,
	 * while caching the message internally in the ZMQ socket. The message will
	 * sent out in a non-determined time. 
	 */
	override sendMessage(byte[] message) {
		pub.send(message, 0)
	}

	/**
	 * Close all the sub/pub socket, and terminate the context managing them.
	 */
	override close() {
		pub.close
		sub.close

		ctx.term
	}

}
