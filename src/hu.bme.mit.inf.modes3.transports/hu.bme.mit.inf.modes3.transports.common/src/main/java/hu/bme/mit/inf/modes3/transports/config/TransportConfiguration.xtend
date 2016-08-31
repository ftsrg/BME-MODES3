package hu.bme.mit.inf.modes3.transports.config

import com.google.gson.Gson
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.Map
import org.eclipse.xtend.lib.annotations.Accessors

enum ActiveConfiguration {
	PRODUCTION,
	INTEGRATION_TEST
}

class TransportConfiguration {
	
	public static TransportEndpointService SERVICE = null;
	
	public static ActiveConfiguration ACTIVE_CONFIGURATION = ActiveConfiguration.PRODUCTION
	private static val CONFIG_MAPPING = #{
		ActiveConfiguration.PRODUCTION -> '/production_config.json',
		ActiveConfiguration.INTEGRATION_TEST -> '/integration_config.json'
	}
	
	@Accessors(PUBLIC_GETTER) Map<String, ArrayList<TransportEndpointService>> core = null;

	def static TransportConfiguration loadConfig() {	
		val gson = new Gson
		val inputReader = new InputStreamReader(TransportConfiguration.getResourceAsStream(CONFIG_MAPPING.get(ACTIVE_CONFIGURATION)))
		try {
			return gson.fromJson(inputReader, TransportConfiguration)
		} finally {
			inputReader.close
		}
	}

}
