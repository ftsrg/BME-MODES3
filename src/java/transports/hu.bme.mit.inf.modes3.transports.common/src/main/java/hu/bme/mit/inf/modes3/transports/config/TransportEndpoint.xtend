package hu.bme.mit.inf.modes3.transports.config

import org.eclipse.xtend.lib.annotations.Data

@Data
class TransportEndpoint {
	String addr;
	String id;
	Integer pubPort;
	Integer repPort;
}