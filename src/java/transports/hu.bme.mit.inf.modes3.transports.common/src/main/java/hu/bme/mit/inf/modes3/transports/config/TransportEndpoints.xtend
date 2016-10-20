package hu.bme.mit.inf.modes3.transports.config

import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.List
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.Accessors

@Data
class TransportEndpoints {
	
	enum ActiveConfiguration {
		DEFAULT,
		PRODUCTION,
		INTEGRATION,
		INTEGRATION_LOCAL_2,
		INTEGRATION_LOCAL_3
	}

	@Accessors(PUBLIC_GETTER, PRIVATE_SETTER) ActiveConfiguration activeConfig
	
	List<TransportEndpoint> core
		
	new() {
		core = new ArrayList<TransportEndpoint>
		activeConfig = ActiveConfiguration.DEFAULT
	}
	
	new(List<TransportEndpoint> core){
		this.core = core
		activeConfig = ActiveConfiguration.DEFAULT
	}
	
	new(List<TransportEndpoint> core, ActiveConfiguration config) {
		this.core = core
		activeConfig = config
	}
	
	def static TransportEndpoints loadConfig(String selectedConfigName){
		val gson = new Gson
		val inputReader = new InputStreamReader(TransportEndpoints.getResourceAsStream('''/configs/«selectedConfigName.toLowerCase».json'''))
		try {
			return gson.fromJson(inputReader, TransportEndpoints)
		} finally {
			inputReader.close
		}
	}

	def static TransportEndpoints loadConfig(ActiveConfiguration selectedConfig) {
		loadConfig(selectedConfig.name)
	}

}
