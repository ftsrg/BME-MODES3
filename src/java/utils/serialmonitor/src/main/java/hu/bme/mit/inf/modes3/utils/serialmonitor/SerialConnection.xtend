package hu.bme.mit.inf.modes3.utils.serialmonitor

import jssc.SerialPort
import jssc.SerialPortEventListener
import jssc.SerialPortException
import jssc.SerialPortList
import org.eclipse.xtend.lib.annotations.Accessors

/** 
 * A connection on a serial port. 
 * 
 * @author zsoltmazlo
 */
class SerialConnection {
	@Accessors(PUBLIC_GETTER) SerialPort port
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int baudRate
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int dataBits = SerialPort.DATABITS_8
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int stopBits = SerialPort.STOPBITS_1
	@Accessors(PUBLIC_GETTER, PUBLIC_SETTER) int parity = SerialPort.PARITY_NONE

	/**
	 * Opens a new connection on the given port with the specified baudRate.
	 * 
	 * @param port the identifier of serial port to be opened
	 * @param baudRate the baud rate to be used on the port
	 */
	new(String port, int baudRate) {
		this.port = new SerialPort(port)
		this.baudRate = baudRate
	}

	/**
	 * Opens the connection on the port.
	 * @throws SerialPortException {@link SerialPort#openPort}
	 */
	def open() throws SerialPortException {
		this.port.openPort
		this.port.setParams(baudRate, dataBits, stopBits, parity)
	}

	/**
	 * Closes the connection on the port.
	 * @throws SerialPortException {@link SerialPort#closePort}
	 */
	def close() throws SerialPortException {
		this.port.closePort
	}

	/**
	 * @return the available serial ports on the device
	 */
	def static getAvailablePorts() {
		SerialPortList.portNames
	}

	/**
	 * Registers the event listener on the port.
	 * 
	 * @param eventListener the listener to be registered on the port
	 * @throws SerialPortException {@link SerialPort#addEventListener(jssc.SerialPortEventListener)}
	 */
	def addEventListener(SerialPortEventListener eventListener) throws SerialPortException {
		this.port.addEventListener(eventListener)
	}
}
