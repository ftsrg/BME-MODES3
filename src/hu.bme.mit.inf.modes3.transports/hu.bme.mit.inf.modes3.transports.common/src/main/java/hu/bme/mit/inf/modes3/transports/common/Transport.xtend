package hu.bme.mit.inf.modes3.transports.common

import java.util.List
import com.google.gson.Gson

abstract class Transport {
	 
	def List<String> getEndpoints() {
		val gson = new Gson();
		
		null
		
		//gson.fromJson(Transport.getResourceAsStream('endoints.json'), )
	}
	 
}