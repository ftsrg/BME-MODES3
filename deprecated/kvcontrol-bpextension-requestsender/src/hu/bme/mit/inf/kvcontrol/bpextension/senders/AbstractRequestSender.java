package hu.bme.mit.inf.kvcontrol.bpextension.senders;

import java.io.IOException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author benedekh
 */
public abstract class AbstractRequestSender {

    public void sendRequest(HttpUriRequest request) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        httpClient.execute(request);
    }

}
