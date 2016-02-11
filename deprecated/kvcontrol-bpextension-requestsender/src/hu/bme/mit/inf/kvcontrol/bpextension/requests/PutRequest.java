package hu.bme.mit.inf.kvcontrol.bpextension.requests;

import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.HttpPut;

/**
 *
 * @author benedekh
 */
public class PutRequest extends AbstractRequest{
    
    public PutRequest(){
        
    }
    
    public PutRequest(String base){
        super(base);
    }
    
    public PutRequest(String base, int port){
        super(base, port);
    }
    
    public HttpPut createPut(String extension){
        HttpPut request = new HttpPut(super.createURL(extension));
        return request;
    }
    
    public HttpPut createPut(String extension, String payload){
        HttpPut request = new HttpPut(super.createURL(extension));
        request.setEntity(EntityBuilder.create().setText(payload).build());
        return request;
    }
    
}
