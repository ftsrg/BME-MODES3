package hu.bme.mit.inf.modes3.components.occupancyquery.config

import com.pi4j.io.serial.Baud
import com.pi4j.io.serial.DataBits
import com.pi4j.io.serial.FlowControl
import com.pi4j.io.serial.Parity
import com.pi4j.io.serial.StopBits
import org.eclipse.xtend.lib.annotations.Data

@Data
class SerialConfigParameters {
	
	String device
	Baud baud
	DataBits dataBits
	Parity parity
	StopBits stopBits
	FlowControl flowControl
	
}