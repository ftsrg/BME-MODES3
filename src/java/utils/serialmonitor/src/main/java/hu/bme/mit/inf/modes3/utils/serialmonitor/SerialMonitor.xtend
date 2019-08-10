package hu.bme.mit.inf.modes3.utils.serialmonitor

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.Arrays
import java.util.logging.Level
import java.util.logging.Logger
import jssc.SerialPort
import jssc.SerialPortEvent
import jssc.SerialPortEventListener
import jssc.SerialPortException

/** 
 * Java implementation for serial communication (via USB).
 * Running in command-line with known serial port and baud rate: `java SerialMonitor /dev/ttyUSB0 9600`
 * 
 * @author zsoltmazlo
 */
class SerialMonitor {
	/** 
	 * @param args the command line arguments
	 */
	def static void main(String[] args) {
		// if we got commandline parameters, then we set
		// up the connection by it
		if(args.length > 0) {
			if(args.get(0).equals("availablePorts") || args.get(0).equals("ports")) {
				println("Available ports")
				while(true) {
					println("----------------------------------")
					var ports = SerialConnection.availablePorts
					if(ports.length > 0) {
						for (var int i = 0; i < ports.length; i++) {
							println(ports.get(i))
						}
					} else {
						println("No Serial Device connected.")
					}
					try {
						Thread.sleep(5000)
					} catch(InterruptedException ex) {
						Logger.getLogger(SerialMonitor.name).log(Level.SEVERE, null, ex)
					}

				}
			}
			new SerialMonitor(args.get(0), args.get(1))
			System.exit(0)
		}
		// listing avaiable ports
		var ports = SerialConnection.availablePorts
		println("Available ports")
		if(ports.length > 0) {
			for (var int i = 0; i < ports.length; i++) {
				println(ports.get(i))
			}
		} else {
			println("No Serial Device connected.")
			System.exit(0)
		}
		var BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
		try {
			// chose one port, baudrate
			print("Port: ")
			var String port = reader.readLine
			print("Baud rate: ")
			var String baudRate = reader.readLine
			// if port only have numbers in it, then complete it with COM string
			if(port.matches("[0-9]?")) {
				if(System.getProperty("os.name").equals("Linux")) {
					port = '''/dev/ttyUSB«port»'''
				} else {
					port = '''COM«port»'''
				}
			}
			// starting monitoring
			new SerialMonitor(port, baudRate)
			System.exit(0)
		} catch(IOException ex) {
			Logger.getLogger(SerialMonitor.name).log(Level.SEVERE, null, ex)
		} finally {
			reader?.close
		}

	}

	/**
	 * Opens a new connection on the given port with the specified baudRate. If the port is
	 * open then waits for commands from the standard input.
	 * 
	 * @param port the identifier of serial port to be opened
	 * @param baudRate the baud rate to be used on the port
	 */
	new(String port, String baudRate) {
		var SerialConnection conn = null
		var BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))
		try {
			// create serial connection
			println('''Trying to create connection on «port» with «baudRate» baudRate''')
			conn = new SerialConnection(port, Integer.parseInt(baudRate))
			conn.open
			// add event listener
			conn.addEventListener(new EventListener(conn.port))
			println("Connection established.")
			// infinite loop for sending via serial
			while(true) {
				try {
					var String command = reader.readLine
					println('''sending: «command»''')
					conn.port.writeString('''«command»''')
				} catch(IOException ex) {
					Logger.getLogger(SerialMonitor.name).log(Level.SEVERE, null, ex)
				}

			}
		} catch(SerialPortException ex) {
			println("Connection not established, see error message for more details.")
			ex.printStackTrace
		} finally {
			if(conn !== null) {
				try {
					conn.close
				} catch(SerialPortException ex) {
					ex.printStackTrace
				}
			}
			reader?.close
		}
	}

	private static class EventListener implements SerialPortEventListener {
		final SerialPort port

		new(SerialPort port) {
			this.port = port
		}

		override void serialEvent(SerialPortEvent event) {
			// If data is available
			if(event.RXCHAR) {
				// Check bytes count in the input buffer
				if(event.eventValue > 0) {
					try {
						println(Arrays.toString(port.readBytes))
					} catch(SerialPortException ex) {
						println(ex)
					}
				}
			} else if(event.CTS) {
				// If CTS line has changed state
				if(event.eventValue === 1) {
					// If line is ON
					println("CTS - ON")
				} else {
					println("CTS - OFF")
				}
			} else if(event.DSR) {
				// /If DSR line has changed state
				if(event.eventValue === 1) {
					// If line is ON
					println("DSR - ON")
				} else {
					println("DSR - OFF")
				}
			}
		}
	}
}
