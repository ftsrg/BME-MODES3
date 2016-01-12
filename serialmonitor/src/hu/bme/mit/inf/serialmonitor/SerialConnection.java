package hu.bme.mit.inf.serialmonitor;


import jssc.SerialPort;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import jssc.SerialPortList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zsoltmazlo
 */
public class SerialConnection {

    private SerialPort port;

    private int baudRate;

    private int dataBits = SerialPort.DATABITS_8;
    private int stopBits = SerialPort.STOPBITS_1;
    private int parity = SerialPort.PARITY_NONE;

    public SerialConnection(String port, int baudRate) {
        this.port = new SerialPort(port);
        this.baudRate = baudRate;
    }

    public void open() throws SerialPortException {
        this.port.openPort();
        this.port.setParams(baudRate, dataBits, stopBits, parity);
    }

    public void close() throws SerialPortException {
        this.port.closePort();
    }

    public static String[] getAvailablePorts() {
        String[] list = SerialPortList.getPortNames();
        return list;
    }

    /**
     * @return the port
     */
    public SerialPort getPort() {
        return port;
    }

    /**
     * @return the baudRate
     */
    public int getBaudRate() {
        return baudRate;
    }

    /**
     * @param baudRate the baudRate to set
     */
    public void setBaudRate(int baudRate) {
        this.baudRate = baudRate;
    }

    /**
     * @return the dataBits
     */
    public int getDataBits() {
        return dataBits;
    }

    /**
     * @param dataBits the dataBits to set
     */
    public void setDataBits(int dataBits) {
        this.dataBits = dataBits;
    }

    /**
     * @return the stopBits
     */
    public int getStopBits() {
        return stopBits;
    }

    /**
     * @param stopBits the stopBits to set
     */
    public void setStopBits(int stopBits) {
        this.stopBits = stopBits;
    }

    /**
     * @return the parity
     */
    public int getParity() {
        return parity;
    }

    /**
     * @param parity the parity to set
     */
    public void setParity(int parity) {
        this.parity = parity;
    }
    
    public void addEventListener(SerialPortEventListener eventListener) throws SerialPortException {
        this.port.addEventListener(eventListener);
    }

}
