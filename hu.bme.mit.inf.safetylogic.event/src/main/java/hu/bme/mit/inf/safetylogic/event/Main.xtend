package hu.bme.mit.inf.safetylogic.event

import hu.bme.mit.inf.mqtt.common.network.MQTTConfiguration
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher
import hu.bme.mit.inf.mqtt.common.network.MQTTPublisherSubscriber
import hu.bme.mit.inf.safetylogic.event.receiver.CVReceiver

class Main {	
	val config = new MQTTConfiguration("192.168.1.2")
	val mqtt = new MQTTPublisherSubscriber(config)
	val dispatcher = new MQTTPublishSubscribeDispatcher(mqtt)
	
	var CVReceiver receiver
	var Safetylogic sl


	static def main(String[] args) {
		val main = new Main
		main.setUp
		main.start
	}

	def void setUp() {
		sl = new Safetylogic(dispatcher);
		receiver = new CVReceiver(dispatcher, sl);
	}

	def void start() {
		while (true) {
			Thread.sleep(1000);
		}
	}

}
