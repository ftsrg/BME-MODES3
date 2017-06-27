package hu.bme.mit.inf.modes3.components.occupancyquery.config

import com.pi4j.io.serial.Baud
import com.pi4j.io.serial.DataBits
import com.pi4j.io.serial.FlowControl
import com.pi4j.io.serial.Parity
import com.pi4j.io.serial.SerialConfig
import com.pi4j.io.serial.StopBits

abstract class SerialConfigFactory {

	def static createDefaultConfig() {
		return createConfig(
			new SerialConfigParameters(
				// SerialPort.defaultPort, // default UART port 
				"/dev/ttyUSB0", // USB port on Raspberry Pi
				Baud._115200,
				DataBits._8,
				Parity.NONE,
				StopBits._1,
				FlowControl.NONE
			)
		)
	}

	def static createConfig(SerialConfigParameters parameters) {
		val config = new SerialConfig
		config.device(parameters.device).baud(parameters.baud).dataBits(parameters.dataBits).parity(parameters.parity).stopBits(parameters.stopBits).flowControl(
			parameters.flowControl
		)
		return config
	}

}
