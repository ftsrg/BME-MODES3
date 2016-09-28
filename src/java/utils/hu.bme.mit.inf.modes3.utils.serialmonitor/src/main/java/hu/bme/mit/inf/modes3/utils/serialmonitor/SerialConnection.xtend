package hu.bme.mit.inf.modes3.utils.serialmonitor

import jssc.SerialPort
import jssc.SerialPortEventListener
import jssc.SerialPortException
import jssc.SerialPortList
import org.eclipse.xtend.lib.annotations.Accessors

/** 
 * @author zsoltmazlo
 */
class SerialConnection {
	@Accessors(PUBLIC_GETTER) SerialPort port
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int baudRate
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int dataBits = SerialPort.DATABITS_8
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int stopBits = SerialPort.STOPBITS_1
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int parity = SerialPort.PARITY_NONE

	new(String port, int baudRate) {
		this.port = new SerialPort(port)
		this.baudRate = baudRate
	}

	def open() throws SerialPortException {
		this.port.openPort
		this.port.setParams(baudRate, dataBits, stopBits, parity)
	}

	def close() throws SerialPortException {
		this.port.closePort
	}

	def static getAvailablePorts() {
		SerialPortList.portNames
	}

	def addEventListener(SerialPortEventListener eventListener) throws SerialPortException {
		this.port.addEventListener(eventListener)
	}
}
