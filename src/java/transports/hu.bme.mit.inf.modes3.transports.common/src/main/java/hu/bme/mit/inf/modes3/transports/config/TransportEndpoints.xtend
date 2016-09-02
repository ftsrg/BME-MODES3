package hu.bme.mit.inf.modes3.transports.config

import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data



@Data
class TransportEndpoints {
	enum ActiveConfiguration {
		PRODUCTION,
		INTEGRATION,
		INTEGRATION_LOCAL
	}
	
	Map<String, ArrayList<TransportEndpoint>> core = null;

	def static TransportEndpoints loadConfig(ActiveConfiguration selectedConfig) {	
		val gson = new Gson
		val inputReader = new InputStreamReader(TransportEndpoints.getResourceAsStream('''/configs/«selectedConfig.name.toLowerCase».json'''))
		try {
			return gson.fromJson(inputReader, TransportEndpoints)
		} finally {
			inputReader.close
		}
	}

}
