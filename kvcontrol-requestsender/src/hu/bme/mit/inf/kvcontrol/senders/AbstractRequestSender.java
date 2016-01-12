package hu.bme.mit.inf.kvcontrol.senders;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import hu.bme.mit.inf.kvcontrol.requests.GetRequest;
import hu.bme.mit.inf.kvcontrol.requests.PutRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author benedekh
 */
public abstract class AbstractRequestSender {
    
    protected static final String RESULT_TAG = "result";
    
    private BufferedReader getResponseContent(HttpUriRequest request) throws IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(request);
        return new BufferedReader(new InputStreamReader(
                response.getEntity().getContent()));
    }
    
    protected JSONObject getPutResponse(String url, JSONObject payload) {
        BufferedReader br = null;
        try {
            PutRequest request = new PutRequest();
            br = getResponseContent(request.createPut(url, payload.toString()));
            return getJSONResponse(br);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(OccupancyRequestSender.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(OccupancyRequestSender.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
        return new JSONObject();
    }
    
    protected JSONObject getGetResponse(String url) {
        BufferedReader br = null;
        try {
            GetRequest request = new GetRequest();
            br = getResponseContent(request.createGet(url));
            return getJSONResponse(br);
        } catch (IOException | JSONException ex) {
            Logger.getLogger(OccupancyRequestSender.class.getName()).log(
                    Level.SEVERE, null, ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(OccupancyRequestSender.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
        return new JSONObject();
    }
    
    private JSONObject getJSONResponse(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String text = br.readLine();
            if (text == null) {
                break;
            } else {
                sb.append(text);
            }
        }
        return new JSONObject(sb.toString());
    }
    
}
