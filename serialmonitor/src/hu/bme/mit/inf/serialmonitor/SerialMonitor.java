/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.bme.mit.inf.serialmonitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;

/**
 *
 * @author zsoltmazlo
 */
public class SerialMonitor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // if we got commandline parameters, then we set
        // up the connection by it
        if (args.length > 0) {
            if (args[0].equals("availablePorts") || args[0].equals("ports")) {

                System.out.println("Available ports");
                while (true) {
                    System.out.println("----------------------------------");
                    String[] ports = SerialConnection.getAvailablePorts();
                    if (ports.length > 0) {
                        for (int i = 0; i < ports.length; i++) {
                            String port = ports[i];
                            System.out.println(port);
                        }
                    } else {
                        System.out.println("No Serial Device connected.");
                    }

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SerialMonitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            SerialMonitor monitor = new SerialMonitor(args[0], args[1]);
            System.exit(0);
        }

        // listing avaiable ports
        String[] ports = SerialConnection.getAvailablePorts();
        System.out.println("Available ports");
        if (ports.length > 0) {
            for (int i = 0; i < ports.length; i++) {
                String port = ports[i];
                System.out.println(port);
            }
        } else {
            System.out.println("No Serial Device connected.");
            System.exit(0);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            // chose one port, baudrate
            System.out.print("Port: ");
            String port = reader.readLine();
            System.out.print("Baud rate: ");
            String baudRate = reader.readLine();

            // if port only have numbers in it, then complete it with COM string
            if (port.matches("[0-9]?")) {
                if (System.getProperty("os.name").equals("Linux")) {
                    port = "/dev/ttyUSB" + port;
                } else {

                    port = "COM" + port;
                }
            }

            // starting monitoring
            SerialMonitor monitor = new SerialMonitor(port, baudRate);

            System.exit(0);

        } catch (IOException ex) {
            Logger.getLogger(SerialMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public SerialMonitor(String port, String baudRate) {
        SerialConnection conn = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            // create serial connection
            System.out.println("Trying to create connection on " + port + " with " + baudRate + " baudRate");
            conn = new SerialConnection(port, Integer.parseInt(baudRate));
            conn.open();

            // add event listner
            conn.addEventListener(new EventListener(conn.getPort()));

            System.out.println("Connection established.");

            // infinite loop for sending via serial
            while (true) {
                try {
                    String command = reader.readLine();
                    System.out.println("sending: " + command);

                    conn.getPort().writeString(command + "\n");

                } catch (IOException ex) {
                    Logger.getLogger(SerialMonitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } catch (SerialPortException ex) {
            System.out.println("Connection not established, see error message for more details.");
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SerialPortException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class EventListener implements SerialPortEventListener {

        private final SerialPort port;

        public EventListener(SerialPort port) {
            this.port = port;

        }

        @Override
        public void serialEvent(SerialPortEvent event) {
            if (event.isRXCHAR()) { //If data is available
                if (event.getEventValue() > 0) {//Check bytes count in the input buffer
                    //Read data, if 10 bytes available 
                    try {
//                        String in = port.readHexString();
                        String in = port.readString();
                        System.out.print(in);
//                        System.out.println(System.currentTimeMillis()+": "+in);
                    } catch (SerialPortException ex) {
                        System.out.println(ex);
                    }
                }
            } else if (event.isCTS()) {//If CTS line has changed state
                if (event.getEventValue() == 1) {//If line is ON
                    System.out.println("CTS - ON");
                } else {
                    System.out.println("CTS - OFF");
                }
            } else if (event.isDSR()) {///If DSR line has changed state
                if (event.getEventValue() == 1) {//If line is ON
                    System.out.println("DSR - ON");
                } else {
                    System.out.println("DSR - OFF");
                }
            }
        }
    }

}
