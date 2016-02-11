package hu.bme.mit.inf.kvcontrol.bpextension.requests;

import org.apache.http.client.methods.HttpGet;

/**
 *
 * @author benedekh
 */
public class GetRequest extends AbstractRequest {
    
    public GetRequest(){
        
    }
    
    public GetRequest(String base){
        super(base);
    }
    
    public GetRequest(String base, int port){
        super(base, port);
    }
    
    public HttpGet createGet(String extension){
        return new HttpGet(super.createURL(extension));
    }
    
}
