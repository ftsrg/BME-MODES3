package hu.bme.mit.inf.kvcontrol.requests;

/**
 *
 * @author benedekh
 */
public abstract class AbstractRequest {

    private static String DEFAULT_ADDRESS = "http://localhost";
    private static int DEFAULT_PORT = 8080;

    protected String baseAddress = DEFAULT_ADDRESS;
    protected int port = DEFAULT_PORT;

    protected AbstractRequest() {
        this.baseAddress = DEFAULT_ADDRESS;
        this.port = DEFAULT_PORT;
    }
    
    public static void setDefultAddress(String address) {
        DEFAULT_ADDRESS = address;
    }
    
    public static void setDefaultPort(int port) {
        DEFAULT_PORT = port;
    }

    protected AbstractRequest(String baseAddress, int port) {
        this.baseAddress = baseAddress;
        this.port = port;
    }

    protected AbstractRequest(String baseAddress) {
        this.baseAddress = baseAddress;
    }

    protected String createURL(String extension) {
        return baseAddress + ":" + port + "/" + extension;
    }

}
