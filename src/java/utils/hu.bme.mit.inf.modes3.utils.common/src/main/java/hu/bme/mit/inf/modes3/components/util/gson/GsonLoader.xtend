package hu.bme.mit.inf.modes3.components.util.gson

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type

class GsonLoader {
	
	static def <T> T loadTypeFromInputStream(Type type, InputStream inputStream){
		val gson = new Gson
		var InputStreamReader isr = null
		var JsonReader reader = null
		try {
			isr = new InputStreamReader(inputStream)
			reader = new JsonReader(isr)
			gson.fromJson(reader, type)
		} finally {
			isr?.close
			reader?.close
		}
	}
}