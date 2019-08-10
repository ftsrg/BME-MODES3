package hu.bme.mit.inf.modes3.transports.config

import org.eclipse.xtend.lib.annotations.Data

/**
 * The configuration parameter of the transport layer.
 * 
 * @author baloghlaszlo, benedekh
 */
@Data
class TransportConfiguration {
	String id
	String addr
	Integer port
}

