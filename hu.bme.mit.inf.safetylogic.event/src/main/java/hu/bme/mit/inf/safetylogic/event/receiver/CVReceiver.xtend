package hu.bme.mit.inf.safetylogic.event.receiver

import com.google.gson.Gson
import hu.bme.mit.inf.mqtt.common.network.MQTTPublishSubscribeDispatcher
import hu.bme.mit.inf.mqtt.common.network.MessageFilter
import hu.bme.mit.inf.safetylogic.event.Safetylogic
import hu.bme.mit.inf.safetylogic.event.prototype.CVPayload
import org.eclipse.paho.client.mqttv3.MqttMessage

class CVReceiver implements MessageFilter {
	static final String topic = "modes3/cv"

	val Safetylogic sl
	val Gson gson;
	val MQTTPublishSubscribeDispatcher requestSender

	new(MQTTPublishSubscribeDispatcher requestSender, Safetylogic sl) {
		this.sl = sl
		this.gson = new Gson
		this.requestSender = requestSender
		this.requestSender.subscribe(topic, this)
	}

	override void filteredMessageArrived(MqttMessage message) {
		val payload = gson.fromJson(new String(message.payload), typeof(CVPayload));
		sl.handle(payload)
	}
	
}
