package hu.bme.mit.inf.modes3.utils.common.gson

import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type

/**
 * Utility class to parse input stream into objects using the GSON notation.
 * 
 * @author benedekh
 */
class GsonLoader {
	
	/**
	 * Deserialize the input stream as a GSON representation of the target type.
	 * 
	 * @param type the type that was serialized in the stream
	 * @param inputStream the stream that has the type serialized
	 * @return the deserialized object
	 */
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
