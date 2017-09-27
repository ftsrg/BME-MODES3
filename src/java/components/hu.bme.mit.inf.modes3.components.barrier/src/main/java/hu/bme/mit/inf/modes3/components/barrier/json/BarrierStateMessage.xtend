package hu.bme.mit.inf.modes3.components.barrier.json

import com.google.gson.Gson
import org.eclipse.xtend.lib.annotations.Data

@Data
class BarrierStateMessage {
	String state

	def serialize() {
		val gson = new Gson
		val str = gson.toJson(this)
		return str.bytes
	}
}
